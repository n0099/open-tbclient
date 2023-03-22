package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
/* loaded from: classes6.dex */
public class wd6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(File file, File file2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65536, null, file, file2, z)) == null) {
            if (file == null || file2 == null) {
                return false;
            }
            String str = file2.getPath() + File.separator;
            if (str.contains(file.getPath() + File.separator) || !file.exists() || !file.isDirectory() || !c(file2)) {
                return false;
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file3 : listFiles) {
                    File file4 = new File(str + file3.getName());
                    if (file3.isFile()) {
                        if (!b(file3, file4, z)) {
                            return false;
                        }
                    } else if (file3.isDirectory() && !a(file3, file4, z)) {
                        return false;
                    }
                }
            }
            if (z && !e(file)) {
                return false;
            }
            return true;
        }
        return invokeLLZ.booleanValue;
    }

    public static boolean b(File file, File file2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65537, null, file, file2, z)) == null) {
            if (file != null && file2 != null && !file.equals(file2) && file.exists() && file.isFile()) {
                if ((file2.exists() && !file2.delete()) || !c(file2.getParentFile())) {
                    return false;
                }
                try {
                    if (!m(file2, new FileInputStream(file))) {
                        return false;
                    }
                    if (z) {
                        if (!g(file)) {
                            return false;
                        }
                    }
                    return true;
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
            return false;
        }
        return invokeLLZ.booleanValue;
    }

    public static boolean c(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, file)) == null) {
            if (file != null && (!file.exists() ? file.mkdirs() : file.isDirectory())) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            return e(new File(str));
        }
        return invokeL.booleanValue;
    }

    public static boolean g(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, file)) == null) {
            if (file != null && (!file.exists() || (file.isFile() && file.delete()))) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean d(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, file)) == null) {
            if (file == null) {
                return false;
            }
            if (file.exists()) {
                return file.isFile();
            }
            if (!c(file.getParentFile())) {
                return false;
            }
            try {
                return file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean e(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, file)) == null) {
            if (file == null) {
                return false;
            }
            if (!file.exists()) {
                return true;
            }
            if (!file.isDirectory()) {
                return false;
            }
            File[] listFiles = file.listFiles();
            if (!vd6.d(listFiles)) {
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        if (!file2.delete()) {
                            return false;
                        }
                    } else if (file2.isDirectory() && !e(file2)) {
                        return false;
                    }
                }
            }
            return file.delete();
        }
        return invokeL.booleanValue;
    }

    public static boolean h(File file, ZipInputStream zipInputStream) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, file, zipInputStream)) == null) {
            try {
                try {
                    ZipEntry nextEntry = zipInputStream.getNextEntry();
                    boolean z = true;
                    while (nextEntry != null) {
                        String name = nextEntry.getName();
                        if (!TextUtils.isEmpty(name) && !name.contains("__MACOSX/")) {
                            File file2 = new File(file, name);
                            if (nextEntry.isDirectory()) {
                                z = file2.mkdirs();
                            } else if (!i(file2, zipInputStream)) {
                                z = i(file2, zipInputStream);
                            }
                            if (!z) {
                                try {
                                    zipInputStream.closeEntry();
                                } catch (IOException unused) {
                                }
                                return false;
                            }
                            nextEntry = zipInputStream.getNextEntry();
                        }
                    }
                    try {
                        zipInputStream.closeEntry();
                    } catch (IOException unused2) {
                    }
                    return true;
                } catch (IOException unused3) {
                    return false;
                }
            } catch (Exception unused4) {
                zipInputStream.closeEntry();
                return false;
            } catch (Throwable th) {
                try {
                    zipInputStream.closeEntry();
                } catch (IOException unused5) {
                }
                throw th;
            }
        }
        return invokeLL.booleanValue;
    }

    public static boolean i(File file, ZipInputStream zipInputStream) {
        InterceptResult invokeLL;
        BufferedOutputStream bufferedOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, file, zipInputStream)) == null) {
            byte[] bArr = new byte[2048];
            FileOutputStream fileOutputStream = null;
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    bufferedOutputStream = new BufferedOutputStream(fileOutputStream2);
                    while (true) {
                        try {
                            int read = zipInputStream.read(bArr, 0, 2048);
                            if (read != -1) {
                                bufferedOutputStream.write(bArr, 0, read);
                            } else {
                                bufferedOutputStream.flush();
                                xd6.a(fileOutputStream2, bufferedOutputStream);
                                return true;
                            }
                        } catch (Exception unused) {
                            fileOutputStream = fileOutputStream2;
                            xd6.a(fileOutputStream, bufferedOutputStream);
                            return false;
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream = fileOutputStream2;
                            xd6.a(fileOutputStream, bufferedOutputStream);
                            throw th;
                        }
                    }
                } catch (Exception unused2) {
                    bufferedOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedOutputStream = null;
                }
            } catch (Exception unused3) {
                bufferedOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                bufferedOutputStream = null;
            }
        } else {
            return invokeLL.booleanValue;
        }
    }

    public static boolean j(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, str, str2)) == null) {
            return a(new File(str), new File(str2), true);
        }
        return invokeLL.booleanValue;
    }

    public static boolean k(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, str, str2)) == null) {
            boolean l = l(new File(str), new File(str2));
            if (!l) {
                return l(new File(str), new File(str2));
            }
            return l;
        }
        return invokeLL.booleanValue;
    }

    public static boolean l(File file, File file2) {
        InterceptResult invokeLL;
        CheckedInputStream checkedInputStream;
        ZipInputStream zipInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, file, file2)) == null) {
            if (file2 == null || file == null || !file.exists() || !file.isFile()) {
                return false;
            }
            if (!file2.exists() && !file2.mkdirs()) {
                return false;
            }
            FileInputStream fileInputStream = null;
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    checkedInputStream = new CheckedInputStream(fileInputStream2, new CRC32());
                    try {
                        zipInputStream = new ZipInputStream(checkedInputStream);
                    } catch (Exception e) {
                        e = e;
                        zipInputStream = null;
                    } catch (Throwable th) {
                        th = th;
                        zipInputStream = null;
                    }
                    try {
                        boolean h = h(file2, zipInputStream);
                        xd6.a(fileInputStream2, checkedInputStream, zipInputStream);
                        return h;
                    } catch (Exception e2) {
                        e = e2;
                        fileInputStream = fileInputStream2;
                        try {
                            e.printStackTrace();
                            xd6.a(fileInputStream, checkedInputStream, zipInputStream);
                            return false;
                        } catch (Throwable th2) {
                            th = th2;
                            xd6.a(fileInputStream, checkedInputStream, zipInputStream);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        fileInputStream = fileInputStream2;
                        xd6.a(fileInputStream, checkedInputStream, zipInputStream);
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    checkedInputStream = null;
                    zipInputStream = null;
                } catch (Throwable th4) {
                    th = th4;
                    checkedInputStream = null;
                    zipInputStream = null;
                }
            } catch (Exception e4) {
                e = e4;
                checkedInputStream = null;
                zipInputStream = null;
            } catch (Throwable th5) {
                th = th5;
                checkedInputStream = null;
                zipInputStream = null;
            }
        } else {
            return invokeLL.booleanValue;
        }
    }

    public static boolean m(File file, InputStream inputStream) {
        InterceptResult invokeLL;
        BufferedOutputStream bufferedOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, file, inputStream)) == null) {
            if (inputStream == null || !d(file)) {
                return false;
            }
            BufferedOutputStream bufferedOutputStream2 = null;
            try {
                try {
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file, false), 524288);
                } catch (IOException e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                byte[] bArr = new byte[524288];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read != -1) {
                        bufferedOutputStream.write(bArr, 0, read);
                    } else {
                        bufferedOutputStream.flush();
                        xd6.a(inputStream, bufferedOutputStream);
                        return true;
                    }
                }
            } catch (IOException e2) {
                e = e2;
                bufferedOutputStream2 = bufferedOutputStream;
                e.printStackTrace();
                xd6.a(inputStream, bufferedOutputStream2);
                return false;
            } catch (Throwable th2) {
                th = th2;
                bufferedOutputStream2 = bufferedOutputStream;
                xd6.a(inputStream, bufferedOutputStream2);
                throw th;
            }
        } else {
            return invokeLL.booleanValue;
        }
    }
}
