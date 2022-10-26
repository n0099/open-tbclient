package com.baidu.ugc.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.minivideo.plugin.capture.bean.FaceItem;
import com.baidu.tieba.ci9;
import com.baidu.tieba.hh9;
import com.baidu.tieba.ih9;
import com.baidu.tieba.ld9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;
/* loaded from: classes6.dex */
public class FileUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DIR_DUAR = "duar";
    public static final String DIR_DU_MODEL = "duModel";
    public static final String DIR_DU_SO = "duSo";
    public static final String DIR_DU_STICKER = "duSticker";
    public transient /* synthetic */ FieldHolder $fh;

    public FileUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static boolean checkSD() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            try {
                if (!Environment.getExternalStorageState().equals("mounted")) {
                    return false;
                }
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean isSDMounted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65571, null)) == null) {
            return Environment.getExternalStorageState().equals("mounted");
        }
        return invokeV.booleanValue;
    }

    public static void a(File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, file) == null) {
            if (file.isFile()) {
                file.delete();
                return;
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length != 0) {
                for (File file2 : listFiles) {
                    a(file2);
                    file.delete();
                }
                return;
            }
            file.delete();
        }
    }

    public static boolean checkFile(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (checkSD() && !ci9.a(str)) {
                try {
                    if (!new File(str).exists()) {
                        return false;
                    }
                    return true;
                } catch (Exception e) {
                    ih9.g(e);
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void deleteAllFiles(File file) {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65548, null, file) == null) && file != null && (listFiles = file.listFiles()) != null && listFiles.length != 0) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    deleteAllFiles(file2);
                    try {
                        file2.delete();
                    } catch (Exception unused) {
                    }
                } else if (file2.exists()) {
                    file2.delete();
                }
            }
        }
    }

    public static void deleteAllFilesAndOwn(File file) {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65550, null, file) != null) || file == null || (listFiles = file.listFiles()) == null) {
            return;
        }
        if (listFiles.length == 0) {
            file.delete();
            return;
        }
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                deleteAllFiles(file2);
                try {
                    file2.delete();
                } catch (Exception unused) {
                }
            } else if (file2.exists()) {
                file2.delete();
            }
        }
        file.delete();
    }

    public static void deleteFileOrDir(File file) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65556, null, file) == null) && file != null) {
            try {
                if (file.exists()) {
                    if (file.isDirectory()) {
                        File[] listFiles = file.listFiles();
                        int length = listFiles.length;
                        for (int i = 0; i < length; i++) {
                            if (listFiles[i].isFile()) {
                                listFiles[i].delete();
                            } else {
                                deleteFileOrDir(listFiles[i]);
                            }
                        }
                    }
                    file.delete();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static long getFileSize(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, file)) == null) {
            long j = 0;
            FileInputStream fileInputStream = null;
            try {
                try {
                    if (file.exists()) {
                        FileInputStream fileInputStream2 = new FileInputStream(file);
                        try {
                            j = fileInputStream2.available();
                            fileInputStream = fileInputStream2;
                        } catch (Exception e) {
                            e = e;
                            fileInputStream = fileInputStream2;
                            ih9.g(e);
                            hh9.b(fileInputStream);
                            return j;
                        } catch (Throwable th) {
                            th = th;
                            fileInputStream = fileInputStream2;
                            hh9.b(fileInputStream);
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e2) {
                e = e2;
            }
            hh9.b(fileInputStream);
            return j;
        }
        return invokeL.longValue;
    }

    public static File getPrivateCaptureRootChildDir(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, str)) == null) {
            File file = new File(ld9.c().a(), str);
            if (!file.exists()) {
                if (file.mkdirs()) {
                    return file;
                }
                return ld9.c().getContext().getCacheDir();
            }
            return file;
        }
        return (File) invokeL.objValue;
    }

    public static long getSize(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65567, null, file)) == null) {
            long j = 0;
            if (file == null || !file.exists()) {
                return 0L;
            }
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles == null || listFiles.length == 0) {
                    return 0L;
                }
                for (File file2 : listFiles) {
                    j += getSize(file2);
                }
                return j;
            } else if (file == null) {
                return 0L;
            } else {
                return file.length();
            }
        }
        return invokeL.longValue;
    }

    public static byte[] loadDataFromStream(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65574, null, inputStream)) == null) {
            if (inputStream == null) {
                return null;
            }
            try {
                try {
                    byte[] bArr = new byte[inputStream.available()];
                    inputStream.read(bArr);
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return bArr;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    try {
                        inputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                    return null;
                }
            } catch (Throwable th) {
                try {
                    inputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
                throw th;
            }
        }
        return (byte[]) invokeL.objValue;
    }

    public static String removeExtention(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65578, null, str)) == null) {
            File file = new File(str);
            if (file.isDirectory()) {
                return str;
            }
            String name = file.getName();
            int lastIndexOf = name.lastIndexOf(46);
            if (lastIndexOf <= 0) {
                return str;
            }
            return new File(file.getParent(), name.substring(0, lastIndexOf)).getPath();
        }
        return (String) invokeL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:25:0x0053 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:41:0x0070 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0, types: [java.lang.Object, java.io.File] */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r13v8, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r14v0, types: [java.lang.Object, java.io.File] */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r14v6 */
    /* JADX WARN: Type inference failed for: r14v8 */
    public static boolean b(File file, File file2) throws IOException {
        InterceptResult invokeLL;
        FileInputStream fileInputStream;
        FileChannel fileChannel;
        Closeable closeable;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, file, file2)) == null) {
            boolean z = false;
            if (file2.exists() && file2.isDirectory()) {
                return false;
            }
            FileChannel fileChannel2 = null;
            try {
                try {
                    fileInputStream = new FileInputStream((File) file);
                    try {
                        file = new FileOutputStream((File) file2);
                    } catch (Exception e) {
                        e = e;
                        file = 0;
                        fileChannel = null;
                    } catch (Throwable th) {
                        th = th;
                        file = 0;
                        file2 = 0;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e2) {
                e = e2;
                file = 0;
                fileChannel = null;
                fileInputStream = null;
            } catch (Throwable th3) {
                th = th3;
                file = 0;
                file2 = 0;
                fileInputStream = null;
            }
            try {
                fileChannel = fileInputStream.getChannel();
                try {
                    fileChannel2 = file.getChannel();
                    long size = fileChannel.size();
                    for (long j2 = 0; j2 < size; j2 += fileChannel2.transferFrom(fileChannel, j2, j)) {
                        long j3 = size - j2;
                        if (j3 > 31457280) {
                            j = 31457280;
                        } else {
                            j = j3;
                        }
                    }
                    z = true;
                    closeable = file;
                } catch (Exception e3) {
                    e = e3;
                    ih9.g(e);
                    closeable = file;
                    hh9.b(fileChannel2);
                    hh9.b(closeable);
                    hh9.b(fileChannel);
                    hh9.b(fileInputStream);
                    return z;
                }
            } catch (Exception e4) {
                e = e4;
                fileChannel = null;
            } catch (Throwable th4) {
                th = th4;
                file2 = 0;
                hh9.b(null);
                hh9.b(file);
                hh9.b(file2);
                hh9.b(fileInputStream);
                throw th;
            }
            hh9.b(fileChannel2);
            hh9.b(closeable);
            hh9.b(fileChannel);
            hh9.b(fileInputStream);
            return z;
        }
        return invokeLL.booleanValue;
    }

    public static void zipDirectory(File file, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65586, null, file, str) == null) {
            try {
                ArrayList<String> arrayList = new ArrayList();
                c(file, arrayList);
                FileOutputStream fileOutputStream = new FileOutputStream(str);
                ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);
                for (String str2 : arrayList) {
                    PrintStream printStream = System.out;
                    printStream.println("Zipping " + str2);
                    zipOutputStream.putNextEntry(new ZipEntry(str2.substring(file.getAbsolutePath().length() + 1, str2.length())));
                    FileInputStream fileInputStream = new FileInputStream(str2);
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read > 0) {
                            zipOutputStream.write(bArr, 0, read);
                        }
                    }
                    zipOutputStream.closeEntry();
                    fileInputStream.close();
                }
                zipOutputStream.close();
                fileOutputStream.close();
                arrayList.clear();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void zipSingleFile(File file, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65588, null, file, str) == null) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(str);
                ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);
                zipOutputStream.putNextEntry(new ZipEntry(file.getName()));
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read > 0) {
                        zipOutputStream.write(bArr, 0, read);
                    } else {
                        zipOutputStream.closeEntry();
                        zipOutputStream.close();
                        fileInputStream.close();
                        fileOutputStream.close();
                        PrintStream printStream = System.out;
                        printStream.println(file.getCanonicalPath() + " is zipped to " + str);
                        return;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void c(File file, List<String> list) throws IOException {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, file, list) == null) {
            for (File file2 : file.listFiles()) {
                if (file2.isFile()) {
                    list.add(file2.getAbsolutePath());
                } else {
                    c(file2, list);
                }
            }
        }
    }

    public static boolean copyFile(String str, String str2) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, str, str2)) == null) {
            if (checkFile(str) && !TextUtils.isEmpty(str2)) {
                return copyFile(new File(str), new File(str2));
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static byte[] loadDataFromAssets(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65572, null, context, str)) == null) {
            InputStream inputStream = null;
            if (context == null) {
                return null;
            }
            try {
                inputStream = context.getAssets().open(str);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return loadDataFromStream(inputStream);
        }
        return (byte[]) invokeLL.objValue;
    }

    public static void unzipFile(File file, String str) throws ZipException, IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65584, null, file, str) == null) {
            unzipFile(file, new File(str));
        }
    }

    public static long calculateFileSize(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            File file = new File(str);
            if (!file.exists()) {
                return 0L;
            }
            return getSize(file);
        }
        return invokeL.longValue;
    }

    public static void close(Closeable closeable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, closeable) == null) && closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static boolean delete(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, file)) == null) {
            if (file == null) {
                return false;
            }
            a(file);
            return !file.exists();
        }
        return invokeL.booleanValue;
    }

    public static void deleteAllFilesInDir(File file) {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65551, null, file) == null) && file != null && (listFiles = file.listFiles()) != null && listFiles.length != 0) {
            for (File file2 : listFiles) {
                if (!file2.isDirectory()) {
                    file2.delete();
                }
            }
        }
    }

    public static void deleteDir(File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, file) == null) {
            deleteDir(file, true);
        }
    }

    public static boolean deleteFile(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, file)) == null) {
            try {
                return file.delete();
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static String getFileExt(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, str)) == null) {
            int lastIndexOf = str.lastIndexOf(".");
            if (lastIndexOf == -1) {
                return "";
            }
            return str.substring(lastIndexOf + 1).toLowerCase();
        }
        return (String) invokeL.objValue;
    }

    public static final String getFileFullName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, str)) == null) {
            return str.substring(str.lastIndexOf("/") + 1, str.length());
        }
        return (String) invokeL.objValue;
    }

    public static final String getFileNameWithOutExtention(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, str)) == null) {
            return removeExtention(getFileFullName(str));
        }
        return (String) invokeL.objValue;
    }

    public static long getFileSize(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, str)) == null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return 0L;
                }
                return new File(str).length();
            } catch (Exception unused) {
                return 0L;
            }
        }
        return invokeL.longValue;
    }

    public static final String getPrefix(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, str)) == null) {
            return str.substring(0, str.lastIndexOf("."));
        }
        return (String) invokeL.objValue;
    }

    public static final String getSuffix(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, str)) == null) {
            return str.substring(str.lastIndexOf(".") + 1);
        }
        return (String) invokeL.objValue;
    }

    public static boolean isExists(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, null, file)) == null) {
            if (file != null && file.exists()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static byte[] loadDataFromFile(String str) {
        FileInputStream fileInputStream;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65573, null, str)) == null) {
            try {
                fileInputStream = new FileInputStream(str);
            } catch (Exception e) {
                e.printStackTrace();
                fileInputStream = null;
            }
            return loadDataFromStream(fileInputStream);
        }
        return (byte[]) invokeL.objValue;
    }

    public static boolean mkdirs(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65575, null, str)) == null) {
            File file = new File(str);
            if (file.exists() || file.mkdirs()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static String readText(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65576, null, file)) == null) {
            if (file != null && file.exists()) {
                try {
                    return readText(new FileInputStream(file));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static boolean copyFile(File file, File file2) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, file, file2)) == null) {
            if (file == null || file2 == null || !file.exists() || file.isDirectory() || file.getCanonicalPath().equals(file2.getCanonicalPath())) {
                return false;
            }
            File parentFile = file2.getParentFile();
            if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                return false;
            }
            if (file2.exists() && !file2.canWrite()) {
                return false;
            }
            return b(file, file2);
        }
        return invokeLL.booleanValue;
    }

    public static void deleteAllFiles(File file, String str) {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65549, null, file, str) == null) && file != null && (listFiles = file.listFiles()) != null && listFiles.length != 0) {
            for (File file2 : listFiles) {
                if (file2.isDirectory() && !file2.getName().equals(str)) {
                    deleteAllFiles(file2);
                    try {
                        file2.delete();
                    } catch (Exception unused) {
                    }
                } else if (!file2.isDirectory() && file2.exists()) {
                    file2.delete();
                }
            }
        }
    }

    public static boolean saveText(String str, String str2) {
        InterceptResult invokeLL;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65582, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    fileOutputStream = new FileOutputStream(str);
                } catch (Exception e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                fileOutputStream.write(str2.getBytes());
                try {
                    fileOutputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                return true;
            } catch (Exception e3) {
                e = e3;
                fileOutputStream2 = fileOutputStream;
                e.printStackTrace();
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
        }
        return invokeLL.booleanValue;
    }

    public static void d(File file, ZipOutputStream zipOutputStream, String str) throws IOException {
        String name;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, file, zipOutputStream, str) == null) {
            if (str != null && str.length() > 0) {
                String trim = str.trim();
                if (trim.length() > 0) {
                    name = trim + File.separator + file.getName();
                } else {
                    name = file.getName();
                }
            } else {
                name = file.getName();
            }
            String str2 = new String(name.getBytes("8859_1"), "GBK");
            if (file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    d(file2, zipOutputStream, str2);
                }
                return;
            }
            byte[] bArr = new byte[10240];
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file), 10240);
            zipOutputStream.putNextEntry(new ZipEntry(str2));
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read != -1) {
                    zipOutputStream.write(bArr, 0, read);
                } else {
                    bufferedInputStream.close();
                    zipOutputStream.flush();
                    zipOutputStream.closeEntry();
                    return;
                }
            }
        }
    }

    public static void deleteDir(File file, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(65553, null, file, z) == null) && file != null && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        deleteDir(file2, z);
                    } else {
                        file2.delete();
                    }
                }
            }
            if (z) {
                file.delete();
            }
        }
    }

    public static boolean deleteFile(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, str)) == null) {
            if (!TextUtils.isEmpty(str) && checkFile(str)) {
                return deleteFile(new File(str));
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean isExists(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, null, str)) == null) {
            if (TextUtils.isEmpty(str) || !new File(str).exists()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static long getAvailableSize() {
        InterceptResult invokeV;
        String absolutePath;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) {
            if (checkSD()) {
                absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
            } else {
                absolutePath = Environment.getRootDirectory().getAbsolutePath();
            }
            if (absolutePath == null) {
                return 0L;
            }
            StatFs statFs = new StatFs(absolutePath);
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        }
        return invokeV.longValue;
    }

    public static File getBaiDuUgcCacheFile() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) {
            File file = null;
            if (isSDMounted()) {
                file = ld9.c().getContext().getExternalFilesDir(null);
            }
            File file2 = new File(file, FaceItem.DIR_UGC_DEFAULT);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            return file2;
        }
        return (File) invokeV.objValue;
    }

    public static String getParentDir(String str) {
        InterceptResult invokeL;
        File parentFile;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, str)) == null) {
            if (TextUtils.isEmpty(str) || !new File(str).exists() || (parentFile = new File(str).getParentFile()) == null) {
                return "";
            }
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            return parentFile.getAbsolutePath() + File.separator;
        }
        return (String) invokeL.objValue;
    }

    public static String readText(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65577, null, inputStream)) == null) {
            if (inputStream == null) {
                return null;
            }
            try {
                try {
                    StringBuilder sb = new StringBuilder();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine);
                    }
                    String sb2 = sb.toString();
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return sb2;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    try {
                        inputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                    return null;
                }
            } catch (Throwable th) {
                try {
                    inputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
                throw th;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String saveBitmap(String str, String str2, Bitmap bitmap, int i, Bitmap.CompressFormat compressFormat) {
        InterceptResult invokeCommon;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65579, null, new Object[]{str, str2, bitmap, Integer.valueOf(i), compressFormat})) == null) {
            FileOutputStream fileOutputStream2 = null;
            if (bitmap != null) {
                try {
                    if (!bitmap.isRecycled()) {
                        File file = new File(str);
                        if (!file.exists() && !file.mkdirs()) {
                            hh9.b(null);
                            return null;
                        }
                        File file2 = new File(str, str2);
                        if (file2.exists() && !file2.delete()) {
                            hh9.b(null);
                            return null;
                        } else if (!file2.createNewFile()) {
                            hh9.b(null);
                            return null;
                        } else {
                            FileOutputStream fileOutputStream3 = new FileOutputStream(file2);
                            try {
                                bitmap.compress(compressFormat, i, fileOutputStream3);
                                String absolutePath = file2.getAbsolutePath();
                                hh9.b(fileOutputStream3);
                                return absolutePath;
                            } catch (Exception e) {
                                fileOutputStream = fileOutputStream3;
                                e = e;
                                try {
                                    ih9.g(e);
                                    hh9.b(fileOutputStream);
                                    return null;
                                } catch (Throwable th) {
                                    th = th;
                                    fileOutputStream2 = fileOutputStream;
                                    hh9.b(fileOutputStream2);
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                fileOutputStream2 = fileOutputStream3;
                                th = th2;
                                hh9.b(fileOutputStream2);
                                throw th;
                            }
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    fileOutputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                }
            }
            hh9.b(null);
            return null;
        }
        return (String) invokeCommon.objValue;
    }

    public static String saveBitmap2JPG(String str, String str2, Bitmap bitmap, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65580, null, str, str2, bitmap, i)) == null) {
            return saveBitmap(str, str2, bitmap, i, Bitmap.CompressFormat.JPEG);
        }
        return (String) invokeLLLI.objValue;
    }

    public static String saveBitmap2PNG(String str, String str2, Bitmap bitmap, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65581, null, str, str2, bitmap, i)) == null) {
            return saveBitmap(str, str2, bitmap, i, Bitmap.CompressFormat.PNG);
        }
        return (String) invokeLLLI.objValue;
    }

    public static void unzipFile(File file, File file2) throws ZipException, IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65583, null, file, file2) == null) {
            if (!file2.exists()) {
                file2.mkdirs();
            }
            String absolutePath = file2.getAbsolutePath();
            ZipFile zipFile = new ZipFile(file);
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry nextElement = entries.nextElement();
                String name = nextElement.getName();
                if (!"./".equals(name) && !".".equals(name) && !name.endsWith("/")) {
                    InputStream inputStream = zipFile.getInputStream(nextElement);
                    File file3 = new File(absolutePath + File.separator + name);
                    if (!file3.exists()) {
                        File parentFile = file3.getParentFile();
                        if (!parentFile.exists()) {
                            parentFile.mkdirs();
                        }
                        file3.createNewFile();
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(file3);
                    byte[] bArr = new byte[10240];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    inputStream.close();
                    fileOutputStream.close();
                }
            }
        }
    }

    public static boolean writeFile(File file, String str, boolean z) {
        InterceptResult invokeLLZ;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65585, null, file, str, z)) == null) {
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    fileOutputStream = new FileOutputStream(file, z);
                } catch (Exception e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                fileOutputStream.write(str.getBytes());
                fileOutputStream.flush();
                hh9.b(fileOutputStream);
                return true;
            } catch (Exception e2) {
                e = e2;
                fileOutputStream2 = fileOutputStream;
                e.printStackTrace();
                hh9.b(fileOutputStream2);
                return false;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                hh9.b(fileOutputStream2);
                throw th;
            }
        }
        return invokeLLZ.booleanValue;
    }

    public static void zipFiles(Collection<File> collection, File file, String str) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65587, null, collection, file, str) == null) {
            ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file), 10240));
            for (File file2 : collection) {
                d(file2, zipOutputStream, "");
            }
            zipOutputStream.setComment(str);
            zipOutputStream.close();
        }
    }
}
