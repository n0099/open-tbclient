package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
/* loaded from: classes8.dex */
public class zn6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, file)) == null) {
            if (file != null && (!file.exists() ? file.mkdirs() : file.isDirectory())) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean c(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, file)) == null) {
            if (file != null && (!file.exists() || (file.isFile() && file.delete()))) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean b(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, file)) == null) {
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
            if (!xn6.e(listFiles)) {
                for (File file2 : listFiles) {
                    if (file2 != null) {
                        if (file2.isFile()) {
                            if (!file2.delete()) {
                                return false;
                            }
                        } else if (file2.isDirectory() && !b(file2)) {
                            return false;
                        }
                    }
                }
            }
            return file.delete();
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:21:0x004b */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:39:0x0074 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v13, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.baidu.titan.sdk.runtime.Interceptable] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.lang.Object, java.io.File] */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9, types: [java.io.Reader, java.io.InputStreamReader] */
    public static String d(File file) {
        ?? r6;
        ?? r7;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            r6 = interceptable;
            r7 = 65539;
            InterceptResult invokeL = r6.invokeL(65539, null, file);
            if (invokeL != null) {
                return (String) invokeL.objValue;
            }
        }
        if (file == 0 || !file.exists() || !file.canRead()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        try {
            try {
                r6 = new FileInputStream((File) file);
            } catch (Throwable th) {
                th = th;
            }
            try {
                file = new InputStreamReader(r6);
            } catch (Exception e) {
                e = e;
                file = 0;
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
                r7 = 0;
                r6 = r6;
                th = th;
                file = r7;
                bo6.a(new Closeable[]{r6, file, r7});
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            file = 0;
            r6 = 0;
            bufferedReader = null;
        } catch (Throwable th3) {
            th = th3;
            r6 = 0;
            r7 = 0;
        }
        try {
            bufferedReader = new BufferedReader(file);
            try {
                for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                    sb.append(readLine);
                }
                String sb2 = sb.toString();
                bo6.a(new Closeable[]{r6, file, bufferedReader});
                return sb2;
            } catch (Exception e3) {
                e = e3;
                e.printStackTrace();
                bo6.a(new Closeable[]{r6, file, bufferedReader});
                return null;
            }
        } catch (Exception e4) {
            e = e4;
            bufferedReader = null;
        } catch (Throwable th4) {
            r7 = 0;
            th = th4;
            bo6.a(new Closeable[]{r6, file, r7});
            throw th;
        }
    }
}
