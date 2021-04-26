package com.baidu.webkit.sdk;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.StatFs;
import android.text.TextUtils;
import com.baidu.webkit.internal.CpuInfo;
import com.baidu.webkit.internal.GlobalConstants;
import com.baidu.webkit.internal.ReflectUtils;
import com.baidu.webkit.internal.blink.EngineManager;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import com.baidu.webkit.internal.utils.UtilsBlink;
import com.baidu.webkit.internal.utils.ZipUtils;
import com.baidu.webkit.sdk.LoadErrorCode;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class SevenZipUtils {
    public static final String ASSETS_NAME_PREFIX = "file:///android_assets";
    public static final int BUF_SIZE = 512;
    public static final boolean DEBUG = false;
    public static final String FILE_NAME_DEST = "libzeuswebviewchromium.so";
    public static final String FILE_NAME_LOCK = "lock";
    public static final String FILE_NAME_LZMA = "lzma";
    public static final String FILE_NAME_META = "meta";
    public static final String FILE_NAME_TEMP = "temp";
    public static final String FILE_SEP = "##";
    public static final int FILE_SEP_LEN = 2;
    public static final String FILE_TIMESTAMP_PREFIX = "zeus_lib_timestamp-";
    public static final String LZMA_META_KEY_COUNT = "count";
    public static final String LZMA_META_KEY_FILE = "file";
    public static final String LZMA_META_KEY_LOADABLE = "loadable";
    public static final String LZMA_META_KEY_MEMSZ = "memsz";
    public static final String LZMA_META_KEY_OFFSET = "offsets";
    public static final String LZMA_META_KEY_PHNUM = "phnum";
    public static final String LZMA_META_KEY_SZ_OFFSET = "szoffsets";
    public static final String LZMA_META_KEY_TOTAL = "total";
    public static final String LZMA_META_KEY_VADDR = "vaddr";
    public static final int SZ_ERROR_CLOSE_META = 96;
    public static final int SZ_ERROR_CREATE_LIB_PATH = 98;
    public static final int SZ_ERROR_DELETE_SO = 93;
    public static final int SZ_ERROR_EXTRACT = 91;
    public static final int SZ_ERROR_GET_LIB_PATH = 99;
    public static final int SZ_ERROR_INIT = 95;
    public static final int SZ_ERROR_JNI_ERR = 89;
    public static final int SZ_ERROR_LOAD_LZMA = 92;
    public static final int SZ_ERROR_NO_SPACE = 94;
    public static final int SZ_ERROR_OTHER = 90;
    public static final int SZ_ERROR_READ_META = 97;
    public static final int SZ_OK = 0;
    public static final String TAG = "SevenZipUtils";
    public static SevenZipUtils mInstance;
    public static boolean sLibraryLoaded;
    public int m7zCount;
    public String m7zFile;
    public int[] m7zOffsets;
    public int[] m7zSizes;
    public int[] m7zSzOffsets;
    public int m7zTotal;
    public FileChannel mChannel;
    public Context mContext;
    public String mDestPath;
    public boolean mEnableApiHook = true;
    public int mErrorCode;
    public boolean mHooked;
    public JSONObject mJson_elf;
    public JSONObject mJson_meta;
    public FileLock mLock;
    public File mLockFile;
    public RandomAccessFile mLockRAFile;
    public int mMaxAddr;
    public int mMinAddr;
    public int mOffset_7z;
    public int mOffset_elf;
    public int mOffset_meta;
    public boolean mPrepared;
    public String mSrcPath;
    public String mTempPath;
    public String mTimeStamp;

    static {
        try {
            System.loadLibrary("zeuslzma");
            sLibraryLoaded = true;
        } catch (Throwable th) {
            Log.e(TAG, "failed to load lzma library: " + th);
        }
    }

    public static void LogI(String str) {
    }

    private synchronized int createDir(String str) {
        File file = new File(str);
        if (file.exists() || file.mkdirs()) {
            while (file != null && file.setExecutable(true, false)) {
                file = file.getParentFile();
            }
            File file2 = new File(this.mTempPath);
            if (file2.exists()) {
                if (!FileUtils.deleteDir(file2, file2)) {
                    Log.e(TAG, "Unable to remove files in directory " + this.mTempPath);
                    return 98;
                }
            } else if (!file2.mkdirs()) {
                Log.e(TAG, "Unable to create directory " + this.mTempPath);
                return 98;
            }
            return 0;
        }
        return 98;
    }

    private int decode() {
        int i2 = 0;
        if (this.m7zCount <= 0 || this.m7zTotal <= 0) {
            return 0;
        }
        this.mContext.getResources().getAssets();
        int i3 = this.m7zCount;
        final String str = this.m7zFile;
        final int[] iArr = this.m7zSizes;
        final int[] iArr2 = this.m7zOffsets;
        final int[] iArr3 = this.m7zSzOffsets;
        if (!this.mHooked) {
            this.mMinAddr = 0;
            this.mMaxAddr = this.m7zTotal;
        }
        String str2 = this.mTempPath;
        int doInit = doInit(str2, this.mDestPath + "libzeuswebviewchromium.so", this.m7zTotal, this.mMinAddr, this.mMaxAddr, this.mHooked ? 1 : 0);
        if (doInit != 0) {
            return doInit;
        }
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(i3);
        while (i2 < i3) {
            final int i4 = i2;
            newFixedThreadPool.submit(new Runnable() { // from class: com.baidu.webkit.sdk.SevenZipUtils.2
                @Override // java.lang.Runnable
                public void run() {
                    SevenZipUtils sevenZipUtils = SevenZipUtils.this;
                    String str3 = str;
                    int[] iArr4 = iArr2;
                    int i5 = i4;
                    sevenZipUtils.decodeAndMerge(null, str3, iArr4[i5], iArr[i5], iArr3[i5]);
                }
            });
            i2++;
            i3 = i3;
        }
        shutdownAndAwaitTermination(newFixedThreadPool);
        return !this.mHooked ? submit() : doInit;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native void decodeAndMerge(AssetManager assetManager, String str, int i2, int i3, int i4);

    private native int doHook(int i2, boolean z);

    private int doInit(String str, String str2, int i2, int i3, int i4, int i5) {
        if (sLibraryLoaded) {
            try {
                return init(str, str2, i2, i3, i4, i5);
            } catch (UnsatisfiedLinkError e2) {
                LoadErrorCode loadErrorCode = LoadErrorCode.getInstance();
                loadErrorCode.trace("512:" + e2.toString());
                return 0;
            }
        }
        return 0;
    }

    private native int extract(String str, String str2, int i2, int i3);

    public static synchronized SevenZipUtils getInstance() {
        SevenZipUtils sevenZipUtils;
        synchronized (SevenZipUtils.class) {
            if (mInstance == null) {
                mInstance = new SevenZipUtils();
            }
            sevenZipUtils = mInstance;
        }
        return sevenZipUtils;
    }

    private String getNativeLibraryDir() {
        String str = this.mContext.getApplicationContext().getApplicationInfo().nativeLibraryDir;
        if (str == null) {
            return this.mContext.getFilesDir().getParent() + "/lib";
        }
        return str;
    }

    private native int init(String str, String str2, int i2, int i3, int i4, int i5);

    private boolean isEnoughSpace(long j) {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks()) > j;
        } catch (Exception e2) {
            Log.i(TAG, "[WARNING]get available blocks failed : " + e2.toString());
            return true;
        }
    }

    private native int nativeCheckNativeMethods(String str);

    private int readMeta() {
        try {
            int i2 = this.mJson_meta.getInt("count");
            this.m7zCount = i2;
            this.m7zSizes = new int[i2];
            this.m7zOffsets = new int[i2];
            this.m7zSzOffsets = new int[i2];
            this.m7zFile = getNativeLibraryDir() + "/" + this.mJson_meta.getString("file");
            JSONArray jSONArray = this.mJson_meta.getJSONArray(LZMA_META_KEY_OFFSET);
            JSONArray jSONArray2 = this.mJson_meta.getJSONArray(LZMA_META_KEY_SZ_OFFSET);
            this.m7zOffsets[0] = 0;
            for (int i3 = 0; i3 < this.m7zCount; i3++) {
                this.m7zSizes[i3] = jSONArray.getInt(i3);
                if (i3 > 0) {
                    int i4 = i3 - 1;
                    this.m7zOffsets[i3] = this.m7zOffsets[i4] + this.m7zSizes[i4];
                }
                this.m7zSzOffsets[i3] = jSONArray2.getInt(i3) + this.mOffset_7z;
            }
            this.m7zTotal = this.mJson_meta.getInt("total");
            return 0;
        } catch (Exception e2) {
            Log.e(TAG, "[FAIL]read meta failed : " + e2.toString());
            return 97;
        }
    }

    private void shutdownAndAwaitTermination(ExecutorService executorService) {
        executorService.shutdown();
        try {
            if (executorService.awaitTermination(60L, TimeUnit.SECONDS)) {
                return;
            }
            executorService.shutdownNow();
            if (executorService.awaitTermination(60L, TimeUnit.SECONDS)) {
                return;
            }
            Log.e(TAG, "Pool did not terminate");
        } catch (InterruptedException unused) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native int submit();

    private boolean tryLock(String str) {
        File file = new File(str);
        if (!file.exists() && !file.mkdirs()) {
            LoadErrorCode.getInstance().trace(503);
            return false;
        }
        try {
            this.mLockFile = new File(file, "lock");
            RandomAccessFile randomAccessFile = new RandomAccessFile(this.mLockFile, "rw");
            this.mLockRAFile = randomAccessFile;
            FileChannel channel = randomAccessFile.getChannel();
            this.mChannel = channel;
            FileLock tryLock = channel.tryLock();
            this.mLock = tryLock;
            return tryLock != null;
        } catch (Exception e2) {
            e2.printStackTrace();
            LoadErrorCode loadErrorCode = LoadErrorCode.getInstance();
            loadErrorCode.trace("504:" + e2.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unLock() {
        try {
            if (this.mLock != null) {
                this.mLock.release();
                this.mLock = null;
            }
        } catch (Exception e2) {
            LoadErrorCode loadErrorCode = LoadErrorCode.getInstance();
            loadErrorCode.trace("505:" + e2.toString());
        }
    }

    public boolean checkNativeMethods(String str) {
        return !sLibraryLoaded || this.mEnableApiHook || nativeCheckNativeMethods(str) >= 0;
    }

    public String checkTimestamp(Context context, String str) {
        String sdkVersionCode = WebKitFactory.getSdkVersionCode();
        if (TextUtils.isEmpty(sdkVersionCode)) {
            sdkVersionCode = GlobalConstants.DEFAULT_VERSION;
        }
        boolean z = true;
        String GetCloudSettingsValue = WebSettingsGlobalBlink.GetCloudSettingsValue("zeus_same_version_no7z_enable");
        if (GetCloudSettingsValue != null && GetCloudSettingsValue.equalsIgnoreCase("false")) {
            z = false;
        }
        Log.i(GlobalConstants.LOG_PER_TAG, "zeus_same_version_no7z_enable = " + z);
        return (!z || GlobalConstants.DEFAULT_VERSION.equalsIgnoreCase(sdkVersionCode)) ? FileUtils.checkTimestamp(context, str, FILE_TIMESTAMP_PREFIX) : FileUtils.checkTimestamp(str, FILE_TIMESTAMP_PREFIX, sdkVersionCode);
    }

    public String checkTimestamp(String str) {
        return FileUtils.checkTimestamp(this.mContext, str, FILE_TIMESTAMP_PREFIX);
    }

    public void clearTimestamp(String str) {
        FileUtils.clearTimestamp(this.mContext, str, FILE_TIMESTAMP_PREFIX);
    }

    public void createTimestamp() {
        if (this.mTimeStamp != null) {
            try {
                new File(this.mDestPath, this.mTimeStamp).createNewFile();
            } catch (IOException e2) {
                Log.e(TAG, "[FAIL]create timestamp failed : " + e2.toString());
            }
        }
    }

    public void finish() {
        if (this.mPrepared) {
            this.mJson_meta = null;
            this.mJson_elf = null;
            if (!this.mHooked) {
                createTimestamp();
                return;
            }
            HandlerThread handlerThread = new HandlerThread("T7@write_back_lib");
            handlerThread.start();
            new Handler(handlerThread.getLooper()).post(new Runnable() { // from class: com.baidu.webkit.sdk.SevenZipUtils.1
                @Override // java.lang.Runnable
                public void run() {
                    int i2;
                    try {
                        i2 = SevenZipUtils.this.submit();
                    } catch (UnsatisfiedLinkError e2) {
                        LoadErrorCode loadErrorCode = LoadErrorCode.getInstance();
                        loadErrorCode.trace("512:" + e2.toString());
                        i2 = 89;
                    }
                    if (i2 == 0) {
                        SevenZipUtils.this.createTimestamp();
                    } else {
                        LoadErrorCode loadErrorCode2 = LoadErrorCode.getInstance();
                        loadErrorCode2.set(101, "write back: " + i2);
                        LoadErrorCode.Statistics.record();
                    }
                    SevenZipUtils.this.unLock();
                }
            });
        }
    }

    public int getErrorCode() {
        if (!this.mHooked) {
            unLock();
        }
        return this.mErrorCode;
    }

    public void hook(boolean z) {
        if (!this.mEnableApiHook) {
            Log.e(TAG, "hook  mEnableApiHook:" + this.mEnableApiHook);
        } else if (!z || (this.mMinAddr == 0 && !CpuInfo.isCPU64())) {
            try {
                if (doHook(Build.VERSION.SDK_INT, z) > 0) {
                    this.mHooked = true;
                }
            } catch (UnsatisfiedLinkError e2) {
                LoadErrorCode loadErrorCode = LoadErrorCode.getInstance();
                loadErrorCode.trace("512:" + e2.toString());
            }
        }
    }

    public synchronized boolean prepare(Context context, String str, String str2) {
        FileInputStream fileInputStream;
        if (str == null) {
            return false;
        }
        this.mContext = context.getApplicationContext();
        if (tryLock(str2)) {
            this.mTempPath = str2 + FILE_NAME_TEMP;
            File file = new File(this.mTempPath);
            FileInputStream fileInputStream2 = null;
            if (file.exists()) {
                FileUtils.deleteDir(file, null);
            }
            String downloadLibPath = UtilsBlink.getDownloadLibPath(WebKitFactory.getContext());
            File file2 = new File(downloadLibPath + "libzeuswebviewchromium.so");
            String checkTimestamp = checkTimestamp(this.mContext, str2);
            this.mTimeStamp = checkTimestamp;
            if (checkTimestamp == null && file2.exists() && !EngineManager.getInstance().isInstallBreak()) {
                unLock();
                LoadErrorCode.getInstance().trace(506);
                return false;
            }
            String nativeLibraryDir = getNativeLibraryDir();
            File file3 = new File(nativeLibraryDir);
            if (!file3.exists()) {
                LoadErrorCode.getInstance().trace(507);
                file3.mkdir();
                ZipUtils.getInstance().unZip(this.mContext, this.mContext.getApplicationInfo().sourceDir, nativeLibraryDir.toString(), nativeLibraryDir.contains("arm64") ? "lib/arm64-v8a/" : "lib/armeabi/", false);
                ReflectUtils.expandPathList(nativeLibraryDir, SevenZipUtils.class);
                System.loadLibrary(FILE_NAME_LZMA);
                sLibraryLoaded = true;
            }
            if (new File(str).exists()) {
                EngineManager.getInstance().resetZeus();
                EngineManager.getInstance().removeUnusedFiles(context);
                EngineManager.getInstance().removeOldStatisticsFiles(context);
            }
            this.mErrorCode = 0;
            try {
                try {
                    fileInputStream = new FileInputStream(str);
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                byte[] bArr = new byte[512];
                fileInputStream.read(bArr);
                String str3 = new String(bArr, "UTF-8");
                int indexOf = str3.indexOf(FILE_SEP) + 2;
                this.mOffset_meta = indexOf;
                int indexOf2 = str3.indexOf(FILE_SEP, indexOf) + 2;
                this.mOffset_elf = indexOf2;
                this.mOffset_7z = str3.indexOf(FILE_SEP, indexOf2) + 2;
                this.mJson_meta = new JSONObject(str3.substring(this.mOffset_meta, this.mOffset_elf - 2));
                JSONObject jSONObject = new JSONObject(str3.substring(this.mOffset_elf, this.mOffset_7z - 2));
                this.mJson_elf = jSONObject;
                int i2 = Integer.MAX_VALUE;
                JSONArray jSONArray = jSONObject.getJSONArray(LZMA_META_KEY_LOADABLE);
                int i3 = 0;
                for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i4);
                    int i5 = jSONObject2.getInt(LZMA_META_KEY_VADDR);
                    int i6 = jSONObject2.getInt(LZMA_META_KEY_MEMSZ);
                    if (i5 < i2) {
                        i2 = i5;
                    }
                    int i7 = i5 + i6;
                    if (i7 > i3) {
                        i3 = i7;
                    }
                }
                this.mMinAddr = i2;
                this.mMaxAddr = i3;
                this.mPrepared = true;
                try {
                    fileInputStream.close();
                } catch (Exception e3) {
                    Log.e(TAG, "[FAIL]close input stream failed : " + e3.toString());
                }
                return true;
            } catch (Exception e4) {
                e = e4;
                fileInputStream2 = fileInputStream;
                unLock();
                LoadErrorCode loadErrorCode = LoadErrorCode.getInstance();
                loadErrorCode.trace("501:" + e);
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (Exception e5) {
                        Log.e(TAG, "[FAIL]close input stream failed : " + e5.toString());
                    }
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (Exception e6) {
                        Log.e(TAG, "[FAIL]close input stream failed : " + e6.toString());
                    }
                }
                throw th;
            }
        }
        return false;
    }

    public void unzip(String str, String str2) {
        int i2;
        if (this.mErrorCode != 0) {
            return;
        }
        if (sLibraryLoaded) {
            File file = new File(str2);
            if (!file.exists() || !file.isDirectory()) {
                file.mkdirs();
            }
            try {
                int i3 = Build.VERSION.SDK_INT;
                if (i3 == 19 && Build.VERSION.RELEASE.contains("4.4.3")) {
                    i3 = 20;
                }
                if (extract(str, str2, this.mOffset_7z, i3) == 0) {
                    return;
                }
            } catch (Throwable th) {
                Log.e(TAG, "failed to extract " + str + ": " + th);
            }
            i2 = 91;
        } else {
            i2 = 92;
        }
        this.mErrorCode = i2;
    }

    public synchronized void unzipWithMeta(String str, String str2) {
        if (this.mErrorCode == 0 && this.mPrepared) {
            this.mSrcPath = str;
            this.mDestPath = str2;
            if (!isEnoughSpace(this.m7zTotal)) {
                this.mErrorCode = 94;
                return;
            }
            int createDir = createDir(str2);
            this.mErrorCode = createDir;
            if (createDir != 0) {
                return;
            }
            int readMeta = readMeta();
            this.mErrorCode = readMeta;
            if (readMeta != 0) {
                return;
            }
            int decode = decode();
            this.mErrorCode = decode;
            if (decode != 0) {
                return;
            }
            if (!this.mHooked) {
                createTimestamp();
            }
        }
    }
}
