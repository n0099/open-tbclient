package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Xml;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
/* loaded from: classes7.dex */
public class or4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:27:0x0043 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:29:0x0045 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:41:0x0021 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v14 */
    public static boolean a(InputStream inputStream, File file) {
        InterceptResult invokeLL;
        FileOutputStream fileOutputStream;
        int read;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, inputStream, file)) == null) {
            boolean z = false;
            if (inputStream == null || file == null) {
                return false;
            }
            File parentFile = file.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            if (file.exists()) {
                file.delete();
            }
            FileOutputStream fileOutputStream2 = null;
            FileOutputStream fileOutputStream3 = null;
            try {
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e) {
                e = e;
            }
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                fileOutputStream.flush();
                z = true;
                lr4.d(fileOutputStream);
                fileOutputStream2 = read;
            } catch (Exception e2) {
                e = e2;
                fileOutputStream3 = fileOutputStream;
                e.printStackTrace();
                lr4.d(fileOutputStream3);
                fileOutputStream2 = fileOutputStream3;
                lr4.d(inputStream);
                return z;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                lr4.d(fileOutputStream2);
                lr4.d(inputStream);
                throw th;
            }
            lr4.d(inputStream);
            return z;
        }
        return invokeLL.booleanValue;
    }

    public static String b(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, inputStream)) == null) {
            return c(inputStream, Xml.Encoding.UTF_8.toString());
        }
        return (String) invokeL.objValue;
    }

    public static String c(InputStream inputStream, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, inputStream, str)) == null) {
            if (inputStream == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            try {
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, str), 8192);
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine);
                    }
                } catch (Throwable th) {
                    lr4.d(inputStream);
                    throw th;
                }
            } catch (Exception | OutOfMemoryError e) {
                e.printStackTrace();
            }
            lr4.d(inputStream);
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    public static boolean d(InputStream inputStream, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, inputStream, str)) == null) {
            boolean z = false;
            if (inputStream != null && !TextUtils.isEmpty(str)) {
                File file = new File(str);
                if (!file.exists()) {
                    file.mkdirs();
                }
                byte[] bArr = new byte[8192];
                ZipInputStream zipInputStream = new ZipInputStream(inputStream);
                while (true) {
                    try {
                        ZipEntry nextEntry = zipInputStream.getNextEntry();
                        if (nextEntry != null) {
                            String str2 = str + "/" + nextEntry.getName();
                            if (lr4.x(str2)) {
                                lr4.d(zipInputStream);
                                return false;
                            } else if (nextEntry.isDirectory()) {
                                File file2 = new File(str2);
                                if (!file2.exists()) {
                                    file2.mkdirs();
                                }
                            } else {
                                File parentFile = new File(str2).getParentFile();
                                if (!parentFile.exists()) {
                                    parentFile.mkdirs();
                                }
                                if (!parentFile.isDirectory()) {
                                    parentFile.delete();
                                    parentFile.mkdirs();
                                }
                                FileOutputStream fileOutputStream = new FileOutputStream(str2);
                                while (true) {
                                    try {
                                        int read = zipInputStream.read(bArr);
                                        if (read == -1) {
                                            break;
                                        }
                                        fileOutputStream.write(bArr, 0, read);
                                    } finally {
                                    }
                                }
                                lr4.d(fileOutputStream);
                            }
                        } else {
                            z = true;
                            break;
                        }
                    } catch (IOException unused) {
                    } catch (Throwable th) {
                        lr4.d(zipInputStream);
                        throw th;
                    }
                }
                lr4.d(zipInputStream);
            }
            return z;
        }
        return invokeLL.booleanValue;
    }
}
