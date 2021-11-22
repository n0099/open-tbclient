package com.baidu.titan.sdk.pm;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.multidex.MultiDexExtractor;
import com.baidu.titan.sdk.initer.TitanIniter;
import com.baidu.titan.sdk.internal.util.Closes;
import com.baidu.titan.sdk.internal.util.EncodeUtils;
import com.baidu.titan.sdk.internal.util.Files;
import com.baidu.titan.sdk.loader.DelegateClassLoader;
import com.baidu.titan.sdk.loader.LoaderHead;
import com.baidu.titan.sdk.loader.LoaderManager;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class PatchManagerService {
    public static final boolean DEBUG = false;
    public static final String PATCH_INSTALL_TMP_PREFIX = "tmp_patch_install_";
    public static final String TAG = "PatchManagerService";
    public static final boolean USE_VERIFY = true;
    public static PatchManagerService sInstance;
    public Context mContext;

    public PatchManagerService(Context context) {
        this.mContext = context.getApplicationContext();
    }

    private boolean dexOpt(PatchInstallInfo patchInstallInfo, JSONObject jSONObject) {
        File dexOptDir = patchInstallInfo.getDexOptDir();
        dexOptDir.mkdirs();
        try {
            new DelegateClassLoader(patchInstallInfo.getDexPath(), dexOptDir.getAbsolutePath(), null, Object.class.getClassLoader(), patchInstallInfo.getClass().getClassLoader());
            if (Build.VERSION.SDK_INT <= 19) {
                patchInstallInfo.saveOptFileDigests(dexOptDir);
                return true;
            }
            return true;
        } catch (Throwable th) {
            if (jSONObject != null) {
                try {
                    jSONObject.put("dexopt_ex", Log.getStackTraceString(th));
                    return false;
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
            return false;
        }
    }

    private boolean extraceDexsIfNeeded(PatchInstallInfo patchInstallInfo, File file) {
        ZipFile zipFile = null;
        try {
            try {
                boolean z = true;
                if (Build.VERSION.SDK_INT <= 19) {
                    ZipFile zipFile2 = new ZipFile(file);
                    try {
                        int dexCount = getDexCount(zipFile2);
                        if (dexCount > 1 && !extractDexs(zipFile2, patchInstallInfo.getPatchDir())) {
                            Closes.closeQuiet(zipFile2);
                            return false;
                        }
                        z = patchInstallInfo.saveDexCount(dexCount);
                        zipFile = zipFile2;
                    } catch (ZipException e2) {
                        e = e2;
                        zipFile = zipFile2;
                        e.printStackTrace();
                        Closes.closeQuiet(zipFile);
                        return false;
                    } catch (IOException e3) {
                        e = e3;
                        zipFile = zipFile2;
                        e.printStackTrace();
                        Closes.closeQuiet(zipFile);
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        zipFile = zipFile2;
                        Closes.closeQuiet(zipFile);
                        throw th;
                    }
                }
                Closes.closeQuiet(zipFile);
                return z;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (ZipException e4) {
            e = e4;
        } catch (IOException e5) {
            e = e5;
        }
    }

    private void extractDex(ZipFile zipFile, ZipEntry zipEntry, File file) throws IOException {
        ZipOutputStream zipOutputStream;
        File file2 = new File(file, zipEntry.getName().replace("dex", "jar"));
        InputStream inputStream = null;
        try {
            zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file2)));
            try {
                inputStream = zipFile.getInputStream(zipEntry);
                ZipEntry zipEntry2 = new ZipEntry("classes.dex");
                zipEntry2.setTime(zipEntry.getTime());
                zipOutputStream.putNextEntry(zipEntry2);
                byte[] bArr = new byte[16384];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    zipOutputStream.write(bArr, 0, read);
                }
                zipOutputStream.closeEntry();
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception unused) {
                    }
                }
                try {
                    zipOutputStream.close();
                } catch (Exception unused2) {
                }
            } catch (Throwable th) {
                th = th;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception unused3) {
                    }
                }
                if (zipOutputStream != null) {
                    try {
                        zipOutputStream.close();
                    } catch (Exception unused4) {
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            zipOutputStream = null;
        }
    }

    private boolean extractDexs(ZipFile zipFile, File file) {
        try {
            ZipEntry entry = zipFile.getEntry("classes.dex");
            if (entry != null) {
                extractDex(zipFile, entry, file);
            }
            int i2 = 2;
            while (true) {
                ZipEntry entry2 = zipFile.getEntry(MultiDexExtractor.DEX_PREFIX + i2 + ".dex");
                if (entry2 == null) {
                    return true;
                }
                extractDex(zipFile, entry2, file);
                i2++;
            }
        } catch (IOException unused) {
            return false;
        }
    }

    private int getDexCount(ZipFile zipFile) {
        if (zipFile.getEntry("classes.dex") == null) {
            return 0;
        }
        int i2 = 2;
        int i3 = 1;
        while (true) {
            if (zipFile.getEntry(MultiDexExtractor.DEX_PREFIX + i2 + ".dex") == null) {
                return i3;
            }
            i3++;
            i2++;
        }
    }

    public static PatchManagerService getInstance() {
        PatchManagerService patchManagerService;
        synchronized (PatchManagerService.class) {
            if (sInstance == null) {
                sInstance = new PatchManagerService(TitanIniter.getAppContext());
            }
            patchManagerService = sInstance;
        }
        return patchManagerService;
    }

    private File prepareInstallTempPatch(InputStream inputStream, JSONObject jSONObject) {
        File file;
        FileOutputStream fileOutputStream;
        File tempBaseDir = TitanPaths.getTempBaseDir();
        tempBaseDir.mkdirs();
        byte[] bArr = new byte[16384];
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                file = File.createTempFile(PATCH_INSTALL_TMP_PREFIX, null, tempBaseDir);
                try {
                    fileOutputStream = new FileOutputStream(file);
                    while (true) {
                        try {
                            try {
                                int read = inputStream.read(bArr);
                                if (read > 0) {
                                    fileOutputStream.write(bArr, 0, read);
                                } else {
                                    Closes.closeQuiet((OutputStream) fileOutputStream);
                                    return file;
                                }
                            } catch (Exception e2) {
                                e = e2;
                                if (jSONObject != null) {
                                    try {
                                        jSONObject.put("prepare_patch_ex", Log.getStackTraceString(e));
                                    } catch (JSONException e3) {
                                        e3.printStackTrace();
                                    }
                                }
                                Closes.closeQuiet((OutputStream) fileOutputStream);
                                if (file != null) {
                                    file.delete();
                                }
                                return null;
                            }
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream2 = fileOutputStream;
                            Closes.closeQuiet((OutputStream) fileOutputStream2);
                            throw th;
                        }
                    }
                } catch (Exception e4) {
                    e = e4;
                    fileOutputStream = null;
                }
            } catch (Exception e5) {
                e = e5;
                file = null;
                fileOutputStream = null;
            }
        } catch (Throwable th2) {
            th = th2;
            Closes.closeQuiet((OutputStream) fileOutputStream2);
            throw th;
        }
    }

    public PatchInstallInfo createPatchInstallInfo(String str) {
        return new PatchInstallInfo(new File(TitanPaths.getPatchsDir(), str));
    }

    public void doCleanPatchsLocked() {
        LoaderHead createFromJson;
        File headFile = TitanPaths.getHeadFile();
        String str = null;
        if (headFile.exists()) {
            String fileStringContent = Files.getFileStringContent(headFile);
            if (!TextUtils.isEmpty(fileStringContent) && (createFromJson = LoaderHead.createFromJson(fileStringContent)) != null && !TextUtils.isEmpty(createFromJson.targetId) && !TextUtils.isEmpty(createFromJson.patchHash) && TextUtils.equals(LoaderManager.getInstance().getCurrentApkId(), createFromJson.targetId)) {
                str = createFromJson.patchHash;
            }
            if (TextUtils.isEmpty(str)) {
                headFile.delete();
            }
        }
        File[] listFiles = TitanPaths.getPatchsDir().listFiles();
        int i2 = 0;
        if (listFiles != null) {
            int length = listFiles.length;
            int i3 = 0;
            while (i2 < length) {
                PatchInstallInfo patchInstallInfo = new PatchInstallInfo(listFiles[i2]);
                if (TextUtils.isEmpty(str) || !patchInstallInfo.getId().equals(str)) {
                    if (patchInstallInfo.writeLock()) {
                        patchInstallInfo.cleanIfNeed();
                        patchInstallInfo.releaseWriteLock();
                    } else {
                        i3 = 1;
                    }
                }
                i2++;
            }
            i2 = i3;
        }
        File pendingCleanFile = PatchManager.getPendingCleanFile();
        if (i2 != 0) {
            try {
                pendingCleanFile.createNewFile();
                return;
            } catch (IOException unused) {
                return;
            }
        }
        pendingCleanFile.delete();
    }

    public int installSyncLocked(Uri uri, Bundle bundle, Bundle bundle2) {
        FileInputStream fileInputStream;
        try {
            if ("file".equals(uri.getScheme())) {
                String path = uri.getPath();
                if (path.startsWith("/android_asset/")) {
                    fileInputStream = this.mContext.getAssets().open(path.substring(15));
                } else {
                    fileInputStream = new FileInputStream(path);
                }
                int installSyncLocked = installSyncLocked(fileInputStream, bundle, bundle2);
                Closes.closeQuiet(fileInputStream);
                doCleanPatchsLocked();
                return installSyncLocked;
            }
            throw new IllegalArgumentException("unkown uri");
        } catch (IOException unused) {
            Closes.closeQuiet((InputStream) null);
            doCleanPatchsLocked();
            return -3;
        } catch (Throwable th) {
            Closes.closeQuiet((InputStream) null);
            doCleanPatchsLocked();
            throw th;
        }
    }

    private int installSyncLocked(InputStream inputStream, Bundle bundle, Bundle bundle2) throws IOException {
        File file;
        LoaderHead createFromJson;
        PatchMetaInfo createFromPatch;
        JSONObject jSONObject = new JSONObject();
        try {
            file = prepareInstallTempPatch(inputStream, jSONObject);
            if (file != null) {
                try {
                    if (file.exists()) {
                        String currentApkId = LoaderManager.getInstance().getCurrentApkId();
                        if (TextUtils.isEmpty(currentApkId)) {
                            if (bundle2 != null) {
                                bundle2.putString(PatchManager.INSTALL_RESULT_EXTRA_KEY, jSONObject.toString());
                            }
                            if (file != null) {
                                file.delete();
                            }
                            return -2;
                        }
                        int verify = new PatchVerifier(this.mContext, file, currentApkId, jSONObject).verify();
                        if (verify != 0) {
                            if (bundle2 != null) {
                                bundle2.putString(PatchManager.INSTALL_RESULT_EXTRA_KEY, jSONObject.toString());
                            }
                            if (file != null) {
                                file.delete();
                            }
                            return verify;
                        }
                        PatchMetaInfo createFromPatch2 = PatchMetaInfo.createFromPatch(file);
                        if (createFromPatch2 == null) {
                            if (bundle2 != null) {
                                bundle2.putString(PatchManager.INSTALL_RESULT_EXTRA_KEY, jSONObject.toString());
                            }
                            if (file != null) {
                                file.delete();
                            }
                            return -3;
                        }
                        File headFile = TitanPaths.getHeadFile();
                        if (headFile.exists() && (createFromJson = LoaderHead.createFromJson(Files.getFileStringContent(headFile))) != null && TextUtils.equals(currentApkId, createFromJson.targetId) && (createFromPatch = PatchMetaInfo.createFromPatch(new PatchInstallInfo(TitanPaths.getPatchDir(createFromJson.patchHash)).getPatchFile())) != null) {
                            if (createFromPatch2.versionInfo.patchVersionCode <= createFromPatch.versionInfo.patchVersionCode) {
                                try {
                                    jSONObject.put("curPatchInfo", createFromPatch.toJsonString());
                                } catch (JSONException e2) {
                                    e2.printStackTrace();
                                }
                                if (bundle2 != null) {
                                    bundle2.putString(PatchManager.INSTALL_RESULT_EXTRA_KEY, jSONObject.toString());
                                }
                                if (file != null) {
                                    file.delete();
                                }
                                return -6;
                            }
                        }
                        if (createFromPatch2.status == 0) {
                            TitanPaths.getHeadFile().delete();
                            if (bundle2 != null) {
                                bundle2.putString(PatchManager.INSTALL_RESULT_EXTRA_KEY, jSONObject.toString());
                            }
                            if (file != null) {
                                file.delete();
                            }
                            return 0;
                        }
                        String bytesToHex = EncodeUtils.bytesToHex(EncodeUtils.sha256(file));
                        PatchInstallInfo createPatchInstallInfo = createPatchInstallInfo(bytesToHex);
                        if (createPatchInstallInfo.finished()) {
                            if (bundle2 != null) {
                                bundle2.putString(PatchManager.INSTALL_RESULT_EXTRA_KEY, jSONObject.toString());
                            }
                            if (file != null) {
                                file.delete();
                            }
                            return 1;
                        }
                        if (createPatchInstallInfo.exist()) {
                            createPatchInstallInfo.cleanIfNeed();
                        }
                        createPatchInstallInfo.prepare();
                        File patchFile = createPatchInstallInfo.getPatchFile();
                        if (!file.renameTo(patchFile)) {
                            if (bundle2 != null) {
                                bundle2.putString(PatchManager.INSTALL_RESULT_EXTRA_KEY, jSONObject.toString());
                            }
                            if (file != null) {
                                file.delete();
                            }
                            return -3;
                        } else if (!extraceDexsIfNeeded(createPatchInstallInfo, patchFile)) {
                            if (bundle2 != null) {
                                bundle2.putString(PatchManager.INSTALL_RESULT_EXTRA_KEY, jSONObject.toString());
                            }
                            if (file != null) {
                                file.delete();
                            }
                            return -10;
                        } else if (!dexOpt(createPatchInstallInfo, jSONObject)) {
                            if (bundle2 != null) {
                                bundle2.putString(PatchManager.INSTALL_RESULT_EXTRA_KEY, jSONObject.toString());
                            }
                            if (file != null) {
                                file.delete();
                            }
                            return -7;
                        } else {
                            createPatchInstallInfo.getStatusFile().createNewFile();
                            LoaderHead loaderHead = new LoaderHead();
                            loaderHead.targetId = currentApkId;
                            loaderHead.patchHash = bytesToHex;
                            FileWriter fileWriter = new FileWriter(TitanPaths.getHeadFile());
                            fileWriter.write(loaderHead.toJsonString());
                            fileWriter.close();
                            if (bundle2 != null) {
                                bundle2.putString(PatchManager.INSTALL_RESULT_EXTRA_KEY, jSONObject.toString());
                            }
                            if (file != null) {
                                file.delete();
                            }
                            return 0;
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    if (bundle2 != null) {
                        bundle2.putString(PatchManager.INSTALL_RESULT_EXTRA_KEY, jSONObject.toString());
                    }
                    if (file != null) {
                        file.delete();
                    }
                    throw th;
                }
            }
            if (bundle2 != null) {
                bundle2.putString(PatchManager.INSTALL_RESULT_EXTRA_KEY, jSONObject.toString());
            }
            if (file != null) {
                file.delete();
            }
            return -3;
        } catch (Throwable th2) {
            th = th2;
            file = null;
        }
    }
}
