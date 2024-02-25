import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Nacional> lista_Nacionales = new ArrayList<>();
    static ArrayList<Importado> lista_Importados = new ArrayList<>();
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        mostrarMenu();
    }

    static void mostrarMenu() {
        while (true) {
            System.out.print(
                    "Selecciona la acción que deseas realizar\n" +
                            "1\uFE0F⃣ Registrar producto Nacional\n" +
                            "2\uFE0F⃣ Registrar producto Importado\n" +
                            "3\uFE0F⃣ Revisar lista de productos Nacionales\n" +
                            "4\uFE0F⃣ Revisar lista de productos Importados\n" +
                            "5\uFE0F⃣ Buscar producto Nacional\n" +
                            "6\uFE0F⃣ Buscar producto Importado\n" +
                            "7\uFE0F⃣ Salir\n" +
                            "Acción --> ");
            System.out.println("\n-------------------------------------");

            int eleccion = scn.nextInt();

            switch (eleccion) {
                case 1:
                    registrar_Producto_Nacional();
                    break;
                case 2:
                    registrar_Producto_Importado();
                    break;
                case 3:
                    mostrar_Productos_Nacionales();
                    break;
                case 4:
                    mostrar_Productos_Importados();
                    break;
                case 5:
                    buscar_Producto_Nacional();
                    break;
                case 6:
                    buscar_Producto_Importado();
                    break;
                case 7:
                    scn.close();
                    return;
                default:
                    System.out.println("Opcion no valida. Vuelve a intentarlo.");
            }
        }
    }

    static void registrar_Producto_Nacional() {
        System.out.print("\nNombre del producto:");
        String nombre = scn.next();
        System.out.print("\nCodigo del producto: ");
        int codigo = scn.nextInt();
        System.out.print("\nRegistro DIAN: ");
        String registroDIAN = scn.next();

        lista_Nacionales.add(new Nacional(nombre, codigo, registroDIAN));
    }

    static void registrar_Producto_Importado() {
        System.out.print("\nNombre del producto:");
        String nombre = scn.next();
        System.out.print("\nCodigo del producto: ");
        int codigo = scn.nextInt();
        System.out.print("\nLicencia de importacion: ");
        String licencia_Importacion = scn.next();

        lista_Importados.add(new Importado(nombre, codigo, licencia_Importacion));
    }

    static void mostrar_Productos_Nacionales() {
        System.out.println("Lista productos Nacionales: ");
        for (Nacional producto : lista_Nacionales) {
            System.out.println("Nombre  |  Codigo  |  Registro DIAN " );
            System.out.println(producto.getNombre() + "   |   " + producto.getCodigo() + "    |     " + producto.registroDIAN);
            System.out.println("-------------------------------------");

        }
    }

    static void mostrar_Productos_Importados() {
        System.out.println("Lista de productos Importados: ");
        for (Importado producto : lista_Importados) {
            System.out.println("Nombre  |  Codigo  |  Licencia Importacion " );
            System.out.println(producto.getNombre() +"    |   " + producto.getCodigo() + "     |     " +  producto.licenciaImportacion);
            System.out.println("-------------------------------------");

        }
    }

    static void buscar_Producto_Nacional() {
        System.out.print("Nombre del producto nacional a buscar: ");
        String nombre_Buscado = scn.next();
        boolean encontrado = false;

        for (Nacional producto : lista_Nacionales) {
            if (producto.getNombre().equals(nombre_Buscado)) {
                System.out.println("El producto a sido encontrado con exito:");
                System.out.println("Nombre  |  Codigo    |     Registro DIAN: " );
                System.out.println(producto.getNombre() + "  |  " + producto.getCodigo() + "    |     " + producto.registroDIAN );
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("Su producto no a sido encontrado.");
        }
    }

    static void buscar_Producto_Importado() {
        System.out.print("Nombre del producto importado a buscar: ");
        String Buscando = scn.next();
        boolean encontrado = false;

        for (Importado producto : lista_Importados) {
            if (producto.getNombre().equals(Buscando)) {
                System.out.println("Producto encontrado:");
                System.out.println("Nombre  |  Codigo    |     Licencia Importacion: " );
                System.out.println(producto.getNombre() + "  |  " +  producto.getCodigo() + "    |     " + producto.licenciaImportacion);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("Su producto no a sido encontrado.");
        }
    }
}