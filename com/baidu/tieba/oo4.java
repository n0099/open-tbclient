package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.ByteArrayInputStream;
import java.io.CharArrayWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/* loaded from: classes5.dex */
public class oo4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Closeable closeable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, closeable) == null) && closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static long b(InputStream inputStream, OutputStream outputStream) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, inputStream, outputStream)) == null) {
            if (inputStream != null && outputStream != null) {
                try {
                    byte[] bArr = new byte[o81.a];
                    long j = 0;
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read > 0) {
                            outputStream.write(bArr, 0, read);
                            j += read;
                        } else {
                            outputStream.flush();
                            return j;
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return 0L;
        }
        return invokeLL.longValue;
    }

    public static boolean d(String str, File file) {
        InterceptResult invokeLL;
        File parentFile;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, file)) == null) {
            if (TextUtils.isEmpty(str) || (parentFile = file.getParentFile()) == null || !parentFile.isDirectory()) {
                return false;
            }
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            e(str.getBytes(), file);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static String c(File file) {
        InterceptResult invokeL;
        FileReader fileReader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, file)) == null) {
            FileReader fileReader2 = null;
            if (file != null && file.exists()) {
                try {
                    fileReader = new FileReader(file);
                } catch (Exception unused) {
                    fileReader = null;
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    char[] cArr = new char[256];
                    CharArrayWriter charArrayWriter = new CharArrayWriter();
                    while (true) {
                        int read = fileReader.read(cArr);
                        if (read > 0) {
                            charArrayWriter.write(cArr, 0, read);
                        } else {
                            String charArrayWriter2 = charArrayWriter.toString();
                            a(fileReader);
                            return charArrayWriter2;
                        }
                    }
                } catch (Exception unused2) {
                    a(fileReader);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    fileReader2 = fileReader;
                    a(fileReader2);
                    throw th;
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static void e(byte[] bArr, File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr, file) == null) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            f(byteArrayInputStream, file);
            a(byteArrayInputStream);
        }
    }

    public static void f(InputStream inputStream, File file) {
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, inputStream, file) == null) {
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (FileNotFoundException e) {
                e = e;
            }
            try {
                b(inputStream, fileOutputStream);
                a(fileOutputStream);
            } catch (FileNotFoundException e2) {
                e = e2;
                fileOutputStream2 = fileOutputStream;
                e.printStackTrace();
                a(fileOutputStream2);
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                a(fileOutputStream2);
                throw th;
            }
        }
    }
}
