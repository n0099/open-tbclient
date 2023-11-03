package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
/* loaded from: classes7.dex */
public class oub {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948046157, "Lcom/baidu/tieba/oub;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948046157, "Lcom/baidu/tieba/oub;");
                return;
            }
        }
        a = AppConfig.isDebug();
    }

    public static boolean a(File file, File file2) {
        FileChannel fileChannel;
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, file, file2)) == null) {
            try {
                if (!file2.getParentFile().exists()) {
                    file2.getParentFile().mkdirs();
                }
                if (!file2.exists()) {
                    file2.createNewFile();
                }
                FileChannel fileChannel2 = null;
                try {
                    FileChannel channel = new FileInputStream(file).getChannel();
                    try {
                        fileChannel2 = new FileOutputStream(file2).getChannel();
                        fileChannel2.transferFrom(channel, 0L, channel.size());
                        if (channel != null) {
                            channel.close();
                        }
                        if (fileChannel2 != null) {
                            fileChannel2.close();
                            return true;
                        }
                        return true;
                    } catch (Throwable th) {
                        th = th;
                        FileChannel fileChannel3 = fileChannel2;
                        fileChannel2 = channel;
                        fileChannel = fileChannel3;
                        if (fileChannel2 != null) {
                            fileChannel2.close();
                        }
                        if (fileChannel != null) {
                            fileChannel.close();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileChannel = null;
                }
            } catch (IOException e) {
                if (a) {
                    e.printStackTrace();
                    return false;
                }
                return false;
            }
        } else {
            return invokeLL.booleanValue;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x004f, code lost:
        if (com.baidu.tieba.oub.a == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0051, code lost:
        r4.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0066, code lost:
        if (com.baidu.tieba.oub.a == false) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean g(String str, File file) {
        InterceptResult invokeLL;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, file)) == null) {
            if (TextUtils.isEmpty(str) || !file.exists()) {
                return false;
            }
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (FileNotFoundException e) {
                e = e;
            } catch (IOException e2) {
                e = e2;
            }
            try {
                fileOutputStream.write(str.getBytes("UTF-8"));
                fileOutputStream.flush();
                try {
                    fileOutputStream.close();
                } catch (IOException e3) {
                    if (a) {
                        e3.printStackTrace();
                    }
                }
                return true;
            } catch (FileNotFoundException e4) {
                e = e4;
                fileOutputStream2 = fileOutputStream;
                if (a) {
                    e.printStackTrace();
                }
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e5) {
                        e = e5;
                    }
                }
                return false;
            } catch (IOException e6) {
                e = e6;
                fileOutputStream2 = fileOutputStream;
                if (a) {
                    e.printStackTrace();
                }
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e7) {
                        e = e7;
                    }
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e8) {
                        if (a) {
                            e8.printStackTrace();
                        }
                    }
                }
                throw th;
            }
        }
        return invokeLL.booleanValue;
    }

    public static void b(File file) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, file) == null) && file != null && file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        file2.delete();
                    } else if (file2.isDirectory()) {
                        b(file2);
                    }
                }
            }
            file.delete();
        }
    }

    public static void c(ArrayList<File> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, arrayList) == null) && arrayList != null && arrayList.size() != 0) {
            Iterator<File> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().delete();
            }
        }
    }

    public static void d(File file, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, file, str) == null) && file != null && file.exists() && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str)) {
            File file2 = new File(file, str);
            if (file2.exists() && file2.isFile()) {
                file2.delete();
            }
        }
    }

    public static void e(File file, List<String> list) {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65541, null, file, list) == null) && (listFiles = file.listFiles()) != null && listFiles.length != 0) {
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    list.add(file2.getAbsolutePath());
                } else {
                    e(file2, list);
                }
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:25:0x004b */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:27:0x004d */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:79:0x00b6 */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x008c, code lost:
        if (com.baidu.tieba.oub.a == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x008e, code lost:
        r6.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00b2, code lost:
        if (com.baidu.tieba.oub.a == false) goto L48;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x00b9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00c1 A[Catch: IOException -> 0x00bd, TryCatch #12 {IOException -> 0x00bd, blocks: (B:81:0x00b9, B:85:0x00c1, B:87:0x00c6), top: B:102:0x00b9 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00c6 A[Catch: IOException -> 0x00bd, TRY_LEAVE, TryCatch #12 {IOException -> 0x00bd, blocks: (B:81:0x00b9, B:85:0x00c1, B:87:0x00c6), top: B:102:0x00b9 }] */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.baidu.titan.sdk.runtime.Interceptable] */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.Object, java.io.File] */
    /* JADX WARN: Type inference failed for: r6v11, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16, types: [java.io.BufferedInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r6v8, types: [java.io.BufferedInputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String f(File file) {
        ?? r3;
        InterceptResult invokeL;
        FileInputStream fileInputStream;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = (r3 = interceptable).invokeL(65542, null, file)) == null) {
            if (file == 0 || !file.exists()) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            try {
                try {
                    fileInputStream = new FileInputStream((File) file);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (FileNotFoundException e) {
                e = e;
                file = 0;
                fileInputStream = null;
                bufferedReader = null;
            } catch (IOException e2) {
                e = e2;
                file = 0;
                fileInputStream = null;
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = null;
                r3 = 0;
            }
            try {
                file = new BufferedInputStream(fileInputStream);
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader((InputStream) file, "UTF-8"));
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            sb.append(readLine);
                        } catch (FileNotFoundException e3) {
                            e = e3;
                            if (a) {
                                e.printStackTrace();
                            }
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e4) {
                                    e = e4;
                                }
                            }
                            if (file != 0) {
                                file.close();
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            return null;
                        } catch (IOException e5) {
                            e = e5;
                            if (a) {
                                e.printStackTrace();
                            }
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e6) {
                                    e = e6;
                                }
                            }
                            if (file != 0) {
                                file.close();
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            return null;
                        }
                    }
                    String sb2 = sb.toString();
                    try {
                        bufferedReader.close();
                        file.close();
                        fileInputStream.close();
                    } catch (IOException e7) {
                        if (a) {
                            e7.printStackTrace();
                        }
                    }
                    return sb2;
                } catch (FileNotFoundException e8) {
                    e = e8;
                    bufferedReader = null;
                } catch (IOException e9) {
                    e = e9;
                    bufferedReader = null;
                } catch (Throwable th3) {
                    r3 = 0;
                    th = th3;
                    if (r3 != 0) {
                        try {
                            r3.close();
                        } catch (IOException e10) {
                            if (a) {
                                e10.printStackTrace();
                            }
                            throw th;
                        }
                    }
                    if (file != 0) {
                        file.close();
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw th;
                }
            } catch (FileNotFoundException e11) {
                e = e11;
                file = 0;
                bufferedReader = null;
            } catch (IOException e12) {
                e = e12;
                file = 0;
                bufferedReader = null;
            } catch (Throwable th4) {
                th = th4;
                r3 = 0;
                th = th;
                file = r3;
                if (r3 != 0) {
                }
                if (file != 0) {
                }
                if (fileInputStream != null) {
                }
                throw th;
            }
        } else {
            return (String) invokeL.objValue;
        }
    }

    public static boolean h(File file, String str) {
        InterceptResult invokeLL;
        FileOutputStream fileOutputStream;
        ZipOutputStream zipOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, file, str)) == null) {
            ZipOutputStream zipOutputStream2 = null;
            try {
                try {
                    ArrayList<String> arrayList = new ArrayList();
                    e(file, arrayList);
                    if (arrayList.size() == 0) {
                        return false;
                    }
                    fileOutputStream = new FileOutputStream(str);
                    try {
                        zipOutputStream = new ZipOutputStream(fileOutputStream);
                    } catch (IOException e) {
                        e = e;
                    }
                    try {
                        for (String str2 : arrayList) {
                            if (a) {
                                Log.d("VoyagerFileUtil", "Zipping " + str2);
                            }
                            zipOutputStream.putNextEntry(new ZipEntry(str2.substring(file.getAbsolutePath().length() + 1, str2.length())));
                            FileInputStream fileInputStream = new FileInputStream(str2);
                            byte[] bArr = new byte[8192];
                            while (true) {
                                int read = fileInputStream.read(bArr);
                                if (read > 0) {
                                    zipOutputStream.write(bArr, 0, read);
                                }
                            }
                            zipOutputStream.closeEntry();
                            fileInputStream.close();
                        }
                        try {
                            zipOutputStream.close();
                        } catch (IOException e2) {
                            if (a) {
                                e2.printStackTrace();
                            }
                        }
                        try {
                            fileOutputStream.close();
                        } catch (IOException e3) {
                            if (a) {
                                e3.printStackTrace();
                            }
                        }
                        return true;
                    } catch (IOException e4) {
                        e = e4;
                        zipOutputStream2 = zipOutputStream;
                        if (a) {
                            e.printStackTrace();
                        }
                        if (zipOutputStream2 != null) {
                            try {
                                zipOutputStream2.close();
                            } catch (IOException e5) {
                                if (a) {
                                    e5.printStackTrace();
                                }
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e6) {
                                if (a) {
                                    e6.printStackTrace();
                                }
                            }
                        }
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        zipOutputStream2 = zipOutputStream;
                        if (zipOutputStream2 != null) {
                            try {
                                zipOutputStream2.close();
                            } catch (IOException e7) {
                                if (a) {
                                    e7.printStackTrace();
                                }
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e8) {
                                if (a) {
                                    e8.printStackTrace();
                                }
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e9) {
                e = e9;
                fileOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
        } else {
            return invokeLL.booleanValue;
        }
    }

    public static boolean i(List<String> list, String str, String str2) {
        InterceptResult invokeLLL;
        FileOutputStream fileOutputStream;
        ZipOutputStream zipOutputStream;
        ZipEntry zipEntry;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65545, null, list, str, str2)) == null) {
            if (list != null) {
                ZipOutputStream zipOutputStream2 = null;
                try {
                    if (list.size() != 0) {
                        int length = str2.length();
                        if (!new File(str2).exists()) {
                            if (a) {
                                Log.d("VoyagerFileUtil", "rootDir " + str2 + "path not exists");
                            }
                            return false;
                        }
                        fileOutputStream = new FileOutputStream(str);
                        try {
                            try {
                                zipOutputStream = new ZipOutputStream(fileOutputStream);
                            } catch (IOException e) {
                                e = e;
                            }
                        } catch (Throwable th) {
                            th = th;
                        }
                        try {
                            for (String str3 : list) {
                                if (a) {
                                    Log.d("VoyagerFileUtil", "Zipping " + str3);
                                }
                                if (length > 0 && str3.startsWith(str2)) {
                                    zipEntry = new ZipEntry(str3.substring(length + 1));
                                } else {
                                    zipEntry = new ZipEntry(str3.substring(str3.lastIndexOf(File.separator)));
                                }
                                zipOutputStream.putNextEntry(zipEntry);
                                FileInputStream fileInputStream = new FileInputStream(str3);
                                byte[] bArr = new byte[8192];
                                while (true) {
                                    int read = fileInputStream.read(bArr);
                                    if (read > 0) {
                                        zipOutputStream.write(bArr, 0, read);
                                    }
                                }
                                zipOutputStream.closeEntry();
                                fileInputStream.close();
                            }
                            try {
                                zipOutputStream.close();
                            } catch (IOException e2) {
                                if (a) {
                                    e2.printStackTrace();
                                }
                            }
                            try {
                                fileOutputStream.close();
                                return true;
                            } catch (IOException e3) {
                                if (a) {
                                    e3.printStackTrace();
                                    return true;
                                }
                                return true;
                            }
                        } catch (IOException e4) {
                            e = e4;
                            zipOutputStream2 = zipOutputStream;
                            if (a) {
                                e.printStackTrace();
                            }
                            if (zipOutputStream2 != null) {
                                try {
                                    zipOutputStream2.close();
                                } catch (IOException e5) {
                                    if (a) {
                                        e5.printStackTrace();
                                    }
                                }
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e6) {
                                    if (a) {
                                        e6.printStackTrace();
                                    }
                                }
                            }
                            return false;
                        } catch (Throwable th2) {
                            th = th2;
                            zipOutputStream2 = zipOutputStream;
                            if (zipOutputStream2 != null) {
                                try {
                                    zipOutputStream2.close();
                                } catch (IOException e7) {
                                    if (a) {
                                        e7.printStackTrace();
                                    }
                                }
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e8) {
                                    if (a) {
                                        e8.printStackTrace();
                                    }
                                }
                            }
                            throw th;
                        }
                    }
                } catch (IOException e9) {
                    e = e9;
                    fileOutputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = null;
                }
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }
}
