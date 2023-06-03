package com.baidu.tieba;

import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
/* loaded from: classes8.dex */
public class w7 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean b;
    public static boolean c;
    public static boolean d;
    public static boolean e;
    public static boolean f;
    public static boolean g;
    public static boolean h;
    public static final HashSet<String> i;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    static {
        InterceptResult invokeClinit;
        boolean z;
        boolean z2;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448319245, "Lcom/baidu/tieba/w7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448319245, "Lcom/baidu/tieba/w7;");
                return;
            }
        }
        b = System.getProperty("os.name").contains("Windows");
        c = System.getProperty("os.name").contains("Linux");
        d = System.getProperty("os.name").contains("Mac");
        e = false;
        f = false;
        if (!System.getProperty("os.arch").startsWith("arm") && !System.getProperty("os.arch").startsWith("aarch64")) {
            z = false;
        } else {
            z = true;
        }
        g = z;
        if (!System.getProperty("os.arch").contains("64") && !System.getProperty("os.arch").startsWith("armv8")) {
            z2 = false;
        } else {
            z2 = true;
        }
        h = z2;
        String property = System.getProperty("java.runtime.name");
        if (property != null && property.contains("Android Runtime")) {
            f = true;
            b = false;
            c = false;
            d = false;
            h = false;
        }
        if (!f && !b && !c && !d) {
            e = true;
            f = false;
            b = false;
            c = false;
            d = false;
            h = false;
        }
        i = new HashSet<>();
    }

    public w7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static synchronized boolean c(String str) {
        InterceptResult invokeL;
        boolean contains;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            synchronized (w7.class) {
                contains = i.contains(str);
            }
            return contains;
        }
        return invokeL.booleanValue;
    }

    public static synchronized void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            synchronized (w7.class) {
                i.add(str);
            }
        }
    }

    public String a(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, inputStream)) == null) {
            if (inputStream != null) {
                CRC32 crc32 = new CRC32();
                byte[] bArr = new byte[4096];
                while (true) {
                    try {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        crc32.update(bArr, 0, read);
                    } catch (Exception unused) {
                    } catch (Throwable th) {
                        a8.a(inputStream);
                        throw th;
                    }
                }
                a8.a(inputStream);
                return Long.toString(crc32.getValue(), 16);
            }
            throw new IllegalArgumentException("input cannot be null.");
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(6:3|(9:(4:44|45|(9:11|12|14|15|16|17|18|(3:19|20|(1:24)(2:22|23))|25)|9)|14|15|16|17|18|(4:19|20|(0)(0)|23)|25|9)|5|(1:7)|11|12) */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0050, code lost:
        r7 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0051, code lost:
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0053, code lost:
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0054, code lost:
        r0 = null;
        r1 = r8;
        r8 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0039 A[EDGE_INSN: B:55:0x0039->B:19:0x0039 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final File b(String str, String str2, File file) throws IOException {
        InterceptResult invokeLLL;
        String a;
        FileOutputStream fileOutputStream;
        IOException e2;
        InputStream inputStream;
        byte[] bArr;
        int read;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, file)) == null) {
            InputStream inputStream2 = null;
            try {
                try {
                    try {
                        if (file.exists()) {
                            try {
                                a = a(new FileInputStream(file));
                            } catch (FileNotFoundException unused) {
                            }
                            if (a != null || !a.equals(str2)) {
                                inputStream = h(str);
                                file.getParentFile().mkdirs();
                                fileOutputStream = new FileOutputStream(file);
                                bArr = new byte[4096];
                                while (true) {
                                    read = inputStream.read(bArr);
                                    if (read != -1) {
                                        break;
                                    }
                                    fileOutputStream.write(bArr, 0, read);
                                }
                                a8.a(inputStream);
                                a8.a(fileOutputStream);
                            }
                            return file;
                        }
                        bArr = new byte[4096];
                        while (true) {
                            read = inputStream.read(bArr);
                            if (read != -1) {
                            }
                            fileOutputStream.write(bArr, 0, read);
                        }
                        a8.a(inputStream);
                        a8.a(fileOutputStream);
                        return file;
                    } catch (IOException e3) {
                        e2 = e3;
                        throw new GdxRuntimeException("Error extracting file: " + str + "\nTo: " + file.getAbsolutePath(), e2);
                    }
                } catch (Throwable th) {
                    th = th;
                    inputStream2 = inputStream;
                    a8.a(inputStream2);
                    a8.a(fileOutputStream);
                    throw th;
                }
                file.getParentFile().mkdirs();
                fileOutputStream = new FileOutputStream(file);
            } catch (IOException e4) {
                e2 = e4;
                fileOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
                inputStream2 = inputStream;
                a8.a(inputStream2);
                a8.a(fileOutputStream);
                throw th;
            }
            a = null;
            if (a != null) {
            }
            inputStream = h(str);
        } else {
            return (File) invokeLLL.objValue;
        }
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) != null) || e) {
            return;
        }
        synchronized (w7.class) {
            if (c(str)) {
                return;
            }
            String g2 = g(str);
            if (f) {
                System.loadLibrary(g2);
            } else {
                f(g2);
            }
            i(str);
        }
    }

    public String g(String str) {
        InterceptResult invokeL;
        String str2;
        String str3;
        String str4;
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (b) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                if (h) {
                    str5 = "64.dll";
                } else {
                    str5 = ".dll";
                }
                sb.append(str5);
                return sb.toString();
            } else if (c) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("lib");
                sb2.append(str);
                if (g) {
                    str3 = "arm";
                } else {
                    str3 = "";
                }
                sb2.append(str3);
                if (h) {
                    str4 = "64.so";
                } else {
                    str4 = ".so";
                }
                sb2.append(str4);
                return sb2.toString();
            } else if (d) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("lib");
                sb3.append(str);
                if (h) {
                    str2 = "64.dylib";
                } else {
                    str2 = ".dylib";
                }
                sb3.append(str2);
                return sb3.toString();
            } else {
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    public final Throwable e(String str, String str2, File file) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, str, str2, file)) == null) {
            try {
                b(str, str2, file);
                System.load(file.getAbsolutePath());
                return null;
            } catch (Throwable th) {
                return th;
            }
        }
        return (Throwable) invokeLLL.objValue;
    }

    public final void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            String a = a(h(str));
            String name = new File(str).getName();
            Throwable e2 = e(str, a, new File(System.getProperty("java.io.tmpdir") + "/libgdx" + System.getProperty("user.name") + "/" + a, name));
            if (e2 == null) {
                return;
            }
            try {
                File createTempFile = File.createTempFile(a, null);
                if (createTempFile.delete()) {
                    if (e(str, a, createTempFile) == null) {
                        return;
                    }
                }
            } catch (Throwable unused) {
            }
            if (e(str, a, new File(System.getProperty("user.home") + "/.libgdx/" + a, name)) == null) {
                return;
            }
            if (e(str, a, new File(".temp/" + a, name)) == null) {
                return;
            }
            File file = new File(System.getProperty("java.library.path"), str);
            if (file.exists()) {
                System.load(file.getAbsolutePath());
                return;
            }
            throw new GdxRuntimeException(e2);
        }
    }

    public final InputStream h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (this.a == null) {
                InputStream resourceAsStream = w7.class.getResourceAsStream("/" + str);
                if (resourceAsStream != null) {
                    return resourceAsStream;
                }
                throw new GdxRuntimeException("Unable to read file for extraction: " + str);
            }
            try {
                ZipFile zipFile = new ZipFile(this.a);
                ZipEntry entry = zipFile.getEntry(str);
                if (entry != null) {
                    return zipFile.getInputStream(entry);
                }
                throw new GdxRuntimeException("Couldn't find '" + str + "' in JAR: " + this.a);
            } catch (IOException e2) {
                throw new GdxRuntimeException("Error reading '" + str + "' in JAR: " + this.a, e2);
            }
        }
        return (InputStream) invokeL.objValue;
    }
}
