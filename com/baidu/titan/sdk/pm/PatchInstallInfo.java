package com.baidu.titan.sdk.pm;

import android.os.Build;
import androidx.multidex.MultiDexExtractor;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.titan.sdk.internal.util.Closes;
import com.baidu.titan.sdk.internal.util.EncodeUtils;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class PatchInstallInfo {
    public File mPatchDir;
    public FileLock mShareFileLock;
    public FileLock mWriteFileLock;

    public PatchInstallInfo(File file) {
        this.mPatchDir = file;
    }

    private void deleteFile(File file) {
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
                return;
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    deleteFile(file2);
                }
            }
            file.delete();
        }
    }

    public void cleanIfNeed() {
        deleteFile(this.mPatchDir);
    }

    public boolean exist() {
        return this.mPatchDir.exists() && this.mPatchDir.isDirectory() && this.mPatchDir.list() != null;
    }

    public boolean finished() {
        return getStatusFile().exists();
    }

    public int getDexCount() {
        DataInputStream dataInputStream;
        DataInputStream dataInputStream2 = null;
        try {
            try {
                dataInputStream = new DataInputStream(new FileInputStream(new File(this.mPatchDir, ".dexCount")));
            } catch (Throwable th) {
                th = th;
            }
        } catch (FileNotFoundException e2) {
            e = e2;
        } catch (IOException e3) {
            e = e3;
        }
        try {
            int readInt = dataInputStream.readInt();
            Closes.closeQuiet((InputStream) dataInputStream);
            return readInt;
        } catch (FileNotFoundException e4) {
            e = e4;
            dataInputStream2 = dataInputStream;
            e.printStackTrace();
            Closes.closeQuiet((InputStream) dataInputStream2);
            return -1;
        } catch (IOException e5) {
            e = e5;
            dataInputStream2 = dataInputStream;
            e.printStackTrace();
            Closes.closeQuiet((InputStream) dataInputStream2);
            return -1;
        } catch (Throwable th2) {
            th = th2;
            dataInputStream2 = dataInputStream;
            Closes.closeQuiet((InputStream) dataInputStream2);
            throw th;
        }
    }

    public File getDexOptDir() {
        return new File(this.mPatchDir, "dexopt");
    }

    public String getDexPath() {
        if (Build.VERSION.SDK_INT <= 19 && getDexCount() > 1) {
            List<File> orderedDexList = getOrderedDexList();
            if (orderedDexList == null || orderedDexList.size() == 0) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            Iterator<File> it = orderedDexList.iterator();
            while (it.hasNext()) {
                sb.append(it.next().getAbsoluteFile());
                if (it.hasNext()) {
                    sb.append(File.pathSeparator);
                }
            }
            return sb.toString();
        }
        return getPatchFile().getAbsolutePath();
    }

    public String getId() {
        return this.mPatchDir.getName();
    }

    public File getLockFile() {
        File file = new File(this.mPatchDir, ".lock");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        return file;
    }

    public List<File> getOrderedDexList() {
        ArrayList arrayList = new ArrayList();
        File file = new File(this.mPatchDir, "classes.jar");
        if (file.exists()) {
            arrayList.add(file);
        }
        int i2 = 2;
        while (true) {
            File file2 = this.mPatchDir;
            File file3 = new File(file2, MultiDexExtractor.DEX_PREFIX + i2 + ".jar");
            if (!file3.exists()) {
                return arrayList;
            }
            arrayList.add(file3);
            i2++;
        }
    }

    public File getPatchDir() {
        return this.mPatchDir;
    }

    public File getPatchFile() {
        return new File(this.mPatchDir, "patch.apk");
    }

    public FileLock getShareLock() {
        return this.mShareFileLock;
    }

    public File getStatusFile() {
        return new File(this.mPatchDir, "status");
    }

    public FileLock getWriteLock() {
        return this.mWriteFileLock;
    }

    public void prepare() {
        this.mPatchDir.mkdirs();
    }

    public HashMap<String, String> readOptDigests() {
        File file = new File(getPatchDir(), ".opt_dig");
        HashMap<String, String> hashMap = new HashMap<>();
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            break;
                        }
                        String[] split = readLine.trim().split(":");
                        if (split.length == 2) {
                            hashMap.put(split[0], split[1]);
                        }
                    } catch (Exception e2) {
                        e = e2;
                        bufferedReader = bufferedReader2;
                        e.printStackTrace();
                        Closes.closeQuiet((Reader) bufferedReader);
                        return hashMap;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        Closes.closeQuiet((Reader) bufferedReader);
                        throw th;
                    }
                }
                Closes.closeQuiet((Reader) bufferedReader2);
            } catch (Exception e3) {
                e = e3;
            }
            return hashMap;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public boolean releaseShareLock() {
        FileLock fileLock = this.mShareFileLock;
        if (fileLock != null) {
            try {
                fileLock.release();
                return true;
            } catch (IOException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public boolean releaseWriteLock() {
        FileLock fileLock = this.mWriteFileLock;
        if (fileLock != null) {
            try {
                fileLock.release();
                Closes.closeQuiet(fileLock.channel());
                return true;
            } catch (IOException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public boolean saveDexCount(int i2) {
        DataOutputStream dataOutputStream;
        DataOutputStream dataOutputStream2 = null;
        try {
            try {
                dataOutputStream = new DataOutputStream(new FileOutputStream(new File(this.mPatchDir, ".dexCount")));
            } catch (Throwable th) {
                th = th;
            }
        } catch (FileNotFoundException e2) {
            e = e2;
        } catch (IOException e3) {
            e = e3;
        }
        try {
            dataOutputStream.writeInt(i2);
            Closes.closeQuiet((OutputStream) dataOutputStream);
            return true;
        } catch (FileNotFoundException e4) {
            e = e4;
            dataOutputStream2 = dataOutputStream;
            e.printStackTrace();
            Closes.closeQuiet((OutputStream) dataOutputStream2);
            return false;
        } catch (IOException e5) {
            e = e5;
            dataOutputStream2 = dataOutputStream;
            e.printStackTrace();
            Closes.closeQuiet((OutputStream) dataOutputStream2);
            return false;
        } catch (Throwable th2) {
            th = th2;
            dataOutputStream2 = dataOutputStream;
            Closes.closeQuiet((OutputStream) dataOutputStream2);
            throw th;
        }
    }

    public boolean saveOptFileDigests(File file) {
        FileWriter fileWriter;
        File[] listFiles;
        FileWriter fileWriter2 = null;
        try {
            try {
                fileWriter = new FileWriter(new File(getPatchDir(), ".opt_dig"));
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e2) {
            e = e2;
        }
        try {
            for (File file2 : file.listFiles()) {
                if (!file2.isDirectory()) {
                    String bytesToHex = EncodeUtils.bytesToHex(EncodeUtils.sha256(file2));
                    fileWriter.write(file2.getName());
                    fileWriter.write(":");
                    fileWriter.write(bytesToHex);
                    fileWriter.write("\n");
                }
            }
            fileWriter.flush();
            Closes.closeQuiet(fileWriter);
            return true;
        } catch (IOException e3) {
            e = e3;
            fileWriter2 = fileWriter;
            e.printStackTrace();
            Closes.closeQuiet(fileWriter2);
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileWriter2 = fileWriter;
            Closes.closeQuiet(fileWriter2);
            throw th;
        }
    }

    public boolean shareLock() {
        try {
            FileLock tryLock = new RandomAccessFile(getLockFile(), r.f7788a).getChannel().tryLock(0L, 0L, true);
            this.mShareFileLock = tryLock;
            return tryLock != null;
        } catch (IOException unused) {
            return false;
        }
    }

    public boolean writeLock() {
        try {
            FileLock tryLock = new RandomAccessFile(getLockFile(), "rw").getChannel().tryLock(0L, 0L, false);
            this.mWriteFileLock = tryLock;
            return tryLock != null;
        } catch (IOException unused) {
            return false;
        }
    }
}
