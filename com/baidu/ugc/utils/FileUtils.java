package com.baidu.ugc.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.minivideo.plugin.capture.bean.FaceItem;
import com.baidu.tieba.akb;
import com.baidu.tieba.dgb;
import com.baidu.tieba.ukb;
import com.baidu.tieba.zjb;
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
/* loaded from: classes9.dex */
public class FileUtils {
    public static final String DIR_DUAR = "duar";
    public static final String DIR_DU_MODEL = "duModel";
    public static final String DIR_DU_SO = "duSo";
    public static final String DIR_DU_STICKER = "duSticker";

    public static boolean checkSD() {
        try {
            if (!Environment.getExternalStorageState().equals("mounted")) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static long getAvailableSize() {
        String absolutePath;
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

    public static File getBaiDuUgcCacheFile() {
        File file = null;
        if (isSDMounted()) {
            file = dgb.c().getContext().getExternalFilesDir(null);
        }
        File file2 = new File(file, FaceItem.DIR_UGC_DEFAULT);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        return file2;
    }

    public static boolean isSDMounted() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static void a(File file) {
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

    public static long calculateFileSize(String str) {
        File file = new File(str);
        if (!file.exists()) {
            return 0L;
        }
        return getSize(file);
    }

    public static boolean checkFile(String str) {
        if (checkSD() && !ukb.a(str)) {
            try {
                if (!new File(str).exists()) {
                    return false;
                }
                return true;
            } catch (Exception e) {
                akb.g(e);
            }
        }
        return false;
    }

    public static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static boolean delete(File file) {
        if (file == null) {
            return false;
        }
        a(file);
        return !file.exists();
    }

    public static void deleteAllFiles(File file) {
        File[] listFiles;
        if (file != null && (listFiles = file.listFiles()) != null && listFiles.length != 0) {
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

    public static void deleteAllFilesInDir(File file) {
        File[] listFiles;
        if (file != null && (listFiles = file.listFiles()) != null && listFiles.length != 0) {
            for (File file2 : listFiles) {
                if (!file2.isDirectory()) {
                    file2.delete();
                }
            }
        }
    }

    public static void deleteDir(File file) {
        deleteDir(file, true);
    }

    public static boolean deleteFile(File file) {
        try {
            return file.delete();
        } catch (Exception unused) {
            return false;
        }
    }

    public static String getFileExt(String str) {
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return "";
        }
        return str.substring(lastIndexOf + 1).toLowerCase();
    }

    public static final String getFileFullName(String str) {
        return str.substring(str.lastIndexOf("/") + 1, str.length());
    }

    public static final String getFileNameWithOutExtention(String str) {
        return removeExtention(getFileFullName(str));
    }

    public static long getFileSize(File file) {
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
                        akb.g(e);
                        zjb.b(fileInputStream);
                        return j;
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream2;
                        zjb.b(fileInputStream);
                        throw th;
                    }
                }
            } catch (Exception e2) {
                e = e2;
            }
            zjb.b(fileInputStream);
            return j;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static final String getPrefix(@NonNull String str) {
        return str.substring(0, str.lastIndexOf("."));
    }

    public static File getPrivateCaptureRootChildDir(String str) {
        File file = new File(dgb.c().a(), str);
        if (!file.exists()) {
            if (file.mkdirs()) {
                return file;
            }
            return dgb.c().getContext().getCacheDir();
        }
        return file;
    }

    public static long getSize(File file) {
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

    public static final String getSuffix(@NonNull String str) {
        return str.substring(str.lastIndexOf(".") + 1);
    }

    public static boolean isExists(File file) {
        if (file != null && file.exists()) {
            return true;
        }
        return false;
    }

    public static byte[] loadDataFromFile(String str) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(str);
        } catch (Exception e) {
            e.printStackTrace();
            fileInputStream = null;
        }
        return loadDataFromStream(fileInputStream);
    }

    public static byte[] loadDataFromStream(InputStream inputStream) {
        try {
            if (inputStream == null) {
                return null;
            }
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

    public static boolean mkdirs(String str) {
        File file = new File(str);
        if (file.exists() || file.mkdirs()) {
            return true;
        }
        return false;
    }

    public static String readText(File file) {
        if (file != null && file.exists()) {
            try {
                return readText(new FileInputStream(file));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static String removeExtention(String str) {
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

    public static boolean b(File file, File file2) throws IOException {
        FileOutputStream fileOutputStream;
        FileChannel fileChannel;
        FileInputStream fileInputStream;
        long j;
        boolean z = false;
        if (file2.exists() && file2.isDirectory()) {
            return false;
        }
        FileChannel fileChannel2 = 0;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    fileChannel = fileInputStream.getChannel();
                    try {
                        try {
                            fileChannel2 = fileOutputStream.getChannel();
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
                        } catch (Exception e) {
                            e = e;
                            akb.g(e);
                            zjb.b(fileChannel2);
                            zjb.b(fileOutputStream);
                            zjb.b(fileChannel);
                            zjb.b(fileInputStream);
                            return z;
                        }
                    } catch (Throwable th) {
                        th = th;
                        zjb.b(fileChannel2);
                        zjb.b(fileOutputStream);
                        zjb.b(fileChannel);
                        zjb.b(fileInputStream);
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                    fileChannel = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileChannel = null;
                    zjb.b(fileChannel2);
                    zjb.b(fileOutputStream);
                    zjb.b(fileChannel);
                    zjb.b(fileInputStream);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                fileOutputStream = null;
                fileChannel = null;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
                fileChannel = null;
            }
        } catch (Exception e4) {
            e = e4;
            fileOutputStream = null;
            fileChannel = null;
            fileInputStream = null;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
            fileChannel = null;
            fileInputStream = null;
        }
        zjb.b(fileChannel2);
        zjb.b(fileOutputStream);
        zjb.b(fileChannel);
        zjb.b(fileInputStream);
        return z;
    }

    public static void unzipFile(File file, File file2) throws ZipException, IOException {
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

    public static void zipDirectory(File file, String str) {
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

    public static void c(File file, List<String> list) throws IOException {
        File[] listFiles;
        for (File file2 : file.listFiles()) {
            if (file2.isFile()) {
                list.add(file2.getAbsolutePath());
            } else {
                c(file2, list);
            }
        }
    }

    public static boolean copyFile(String str, String str2) throws IOException {
        if (checkFile(str) && !TextUtils.isEmpty(str2)) {
            return copyFile(new File(str), new File(str2));
        }
        return false;
    }

    public static void deleteDir(File file, boolean z) {
        if (file != null && file.isDirectory()) {
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

    public static byte[] loadDataFromAssets(Context context, String str) {
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

    public static void unzipFile(File file, String str) throws ZipException, IOException {
        unzipFile(file, new File(str));
    }

    public static boolean copyFile(File file, File file2) throws IOException {
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

    public static void zipSingleFile(File file, String str) {
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

    public static void d(File file, ZipOutputStream zipOutputStream, String str) throws IOException {
        String name;
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

    public static void deleteAllFiles(File file, String str) {
        File[] listFiles;
        if (file != null && (listFiles = file.listFiles()) != null && listFiles.length != 0) {
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
        FileOutputStream fileOutputStream;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(str);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
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

    public static void deleteAllFilesAndOwn(File file) {
        File[] listFiles;
        if (file == null || (listFiles = file.listFiles()) == null) {
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
        if (file != null) {
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

    public static String getParentDir(String str) {
        File parentFile;
        if (TextUtils.isEmpty(str) || !new File(str).exists() || (parentFile = new File(str).getParentFile()) == null) {
            return "";
        }
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        return parentFile.getAbsolutePath() + File.separator;
    }

    public static String readText(InputStream inputStream) {
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

    public static boolean deleteFile(String str) {
        if (!TextUtils.isEmpty(str) && checkFile(str)) {
            return deleteFile(new File(str));
        }
        return true;
    }

    public static long getFileSize(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return 0L;
            }
            return new File(str).length();
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static boolean isExists(String str) {
        if (TextUtils.isEmpty(str) || !new File(str).exists()) {
            return false;
        }
        return true;
    }

    public static String saveBitmap(String str, String str2, Bitmap bitmap, int i, Bitmap.CompressFormat compressFormat) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        if (bitmap != null) {
            try {
                if (!bitmap.isRecycled()) {
                    File file = new File(str);
                    if (!file.exists() && !file.mkdirs()) {
                        zjb.b(null);
                        return null;
                    }
                    File file2 = new File(str, str2);
                    if (file2.exists() && !file2.delete()) {
                        zjb.b(null);
                        return null;
                    } else if (!file2.createNewFile()) {
                        zjb.b(null);
                        return null;
                    } else {
                        FileOutputStream fileOutputStream3 = new FileOutputStream(file2);
                        try {
                            bitmap.compress(compressFormat, i, fileOutputStream3);
                            String absolutePath = file2.getAbsolutePath();
                            zjb.b(fileOutputStream3);
                            return absolutePath;
                        } catch (Exception e) {
                            fileOutputStream = fileOutputStream3;
                            e = e;
                            try {
                                akb.g(e);
                                zjb.b(fileOutputStream);
                                return null;
                            } catch (Throwable th) {
                                th = th;
                                fileOutputStream2 = fileOutputStream;
                                zjb.b(fileOutputStream2);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            fileOutputStream2 = fileOutputStream3;
                            th = th2;
                            zjb.b(fileOutputStream2);
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
        zjb.b(null);
        return null;
    }

    public static String saveBitmap2JPG(String str, String str2, Bitmap bitmap, int i) {
        return saveBitmap(str, str2, bitmap, i, Bitmap.CompressFormat.JPEG);
    }

    public static String saveBitmap2PNG(String str, String str2, Bitmap bitmap, int i) {
        return saveBitmap(str, str2, bitmap, i, Bitmap.CompressFormat.PNG);
    }

    public static boolean writeFile(File file, String str, boolean z) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                fileOutputStream = new FileOutputStream(file, z);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            fileOutputStream.write(str.getBytes());
            fileOutputStream.flush();
            zjb.b(fileOutputStream);
            return true;
        } catch (Exception e2) {
            e = e2;
            fileOutputStream2 = fileOutputStream;
            e.printStackTrace();
            zjb.b(fileOutputStream2);
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            zjb.b(fileOutputStream2);
            throw th;
        }
    }

    public static void zipFiles(Collection<File> collection, File file, String str) throws IOException {
        ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file), 10240));
        for (File file2 : collection) {
            d(file2, zipOutputStream, "");
        }
        zipOutputStream.setComment(str);
        zipOutputStream.close();
    }
}
