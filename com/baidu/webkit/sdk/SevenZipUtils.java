package com.baidu.webkit.sdk;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.StatFs;
import android.support.v7.widget.ActivityChooserView;
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
/* loaded from: classes19.dex */
public class SevenZipUtils {
    private static final String ASSETS_NAME_PREFIX = "file:///android_assets";
    private static final int BUF_SIZE = 512;
    private static final boolean DEBUG = false;
    private static final String FILE_NAME_DEST = "libzeuswebviewchromium.so";
    private static final String FILE_NAME_LOCK = "lock";
    private static final String FILE_NAME_LZMA = "lzma";
    private static final String FILE_NAME_META = "meta";
    private static final String FILE_NAME_TEMP = "temp";
    private static final String FILE_SEP = "##";
    private static final int FILE_SEP_LEN = 2;
    private static final String FILE_TIMESTAMP_PREFIX = "zeus_lib_timestamp-";
    private static final String LZMA_META_KEY_COUNT = "count";
    private static final String LZMA_META_KEY_FILE = "file";
    private static final String LZMA_META_KEY_LOADABLE = "loadable";
    private static final String LZMA_META_KEY_MEMSZ = "memsz";
    private static final String LZMA_META_KEY_OFFSET = "offsets";
    private static final String LZMA_META_KEY_PHNUM = "phnum";
    private static final String LZMA_META_KEY_SZ_OFFSET = "szoffsets";
    private static final String LZMA_META_KEY_TOTAL = "total";
    private static final String LZMA_META_KEY_VADDR = "vaddr";
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
    private static final String TAG = "SevenZipUtils";
    private static SevenZipUtils mInstance;
    private static boolean sLibraryLoaded;
    int m7zCount;
    String m7zFile;
    int[] m7zOffsets;
    int[] m7zSizes;
    int[] m7zSzOffsets;
    int m7zTotal;
    private FileChannel mChannel;
    Context mContext;
    String mDestPath;
    boolean mEnableApiHook = true;
    private int mErrorCode;
    boolean mHooked;
    JSONObject mJson_elf;
    JSONObject mJson_meta;
    private FileLock mLock;
    private File mLockFile;
    private RandomAccessFile mLockRAFile;
    int mMaxAddr;
    int mMinAddr;
    int mOffset_7z;
    int mOffset_elf;
    int mOffset_meta;
    boolean mPrepared;
    String mSrcPath;
    String mTempPath;
    private String mTimeStamp;

    static {
        try {
            System.loadLibrary("zeuslzma");
            sLibraryLoaded = true;
        } catch (Throwable th) {
            Log.e(TAG, "failed to load lzma library: " + th);
        }
    }

    private SevenZipUtils() {
    }

    private static void LogI(String str) {
    }

    private synchronized int createDir(String str) {
        int i = 98;
        synchronized (this) {
            File file = new File(str);
            if (file.exists() || file.mkdirs()) {
                while (file != null && file.setExecutable(true, false)) {
                    file = file.getParentFile();
                }
                File file2 = new File(this.mTempPath);
                if (file2.exists()) {
                    if (!FileUtils.deleteDir(file2, file2)) {
                        Log.e(TAG, "Unable to remove files in directory " + this.mTempPath);
                    }
                    i = 0;
                } else {
                    if (!file2.mkdirs()) {
                        Log.e(TAG, "Unable to create directory " + this.mTempPath);
                    }
                    i = 0;
                }
            }
        }
        return i;
    }

    private int decode() {
        if (this.m7zCount <= 0 || this.m7zTotal <= 0) {
            return 0;
        }
        this.mContext.getResources().getAssets();
        int i = this.m7zCount;
        final String str = this.m7zFile;
        final int[] iArr = this.m7zSizes;
        final int[] iArr2 = this.m7zOffsets;
        final int[] iArr3 = this.m7zSzOffsets;
        if (!this.mHooked) {
            this.mMinAddr = 0;
            this.mMaxAddr = this.m7zTotal;
        }
        int doInit = doInit(this.mTempPath, this.mDestPath + "libzeuswebviewchromium.so", this.m7zTotal, this.mMinAddr, this.mMaxAddr, this.mHooked ? 1 : 0);
        if (doInit != 0) {
            return doInit;
        }
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(i);
        for (final int i2 = 0; i2 < i; i2++) {
            newFixedThreadPool.submit(new Runnable() { // from class: com.baidu.webkit.sdk.SevenZipUtils.2
                @Override // java.lang.Runnable
                public void run() {
                    SevenZipUtils.this.decodeAndMerge(null, str, iArr2[i2], iArr[i2], iArr3[i2]);
                }
            });
        }
        shutdownAndAwaitTermination(newFixedThreadPool);
        return !this.mHooked ? submit() : doInit;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native void decodeAndMerge(AssetManager assetManager, String str, int i, int i2, int i3);

    private native int doHook(int i, boolean z);

    private int doInit(String str, String str2, int i, int i2, int i3, int i4) {
        if (sLibraryLoaded) {
            try {
                return init(str, str2, i, i2, i3, i4);
            } catch (UnsatisfiedLinkError e) {
                LoadErrorCode.getInstance().trace("512:" + e.toString());
                return 0;
            }
        }
        return 0;
    }

    private native int extract(String str, String str2, int i, int i2);

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
        return str == null ? this.mContext.getFilesDir().getParent() + "/lib" : str;
    }

    private native int init(String str, String str2, int i, int i2, int i3, int i4);

    private boolean isEnoughSpace(long j) {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks()) > j;
        } catch (Exception e) {
            Log.i(TAG, "[WARNING]get available blocks failed : " + e.toString());
            return true;
        }
    }

    private native int nativeCheckNativeMethods(String str);

    private int readMeta() {
        try {
            this.m7zCount = this.mJson_meta.getInt("count");
            this.m7zSizes = new int[this.m7zCount];
            this.m7zOffsets = new int[this.m7zCount];
            this.m7zSzOffsets = new int[this.m7zCount];
            this.m7zFile = getNativeLibraryDir() + "/" + this.mJson_meta.getString("file");
            JSONArray jSONArray = this.mJson_meta.getJSONArray(LZMA_META_KEY_OFFSET);
            JSONArray jSONArray2 = this.mJson_meta.getJSONArray(LZMA_META_KEY_SZ_OFFSET);
            this.m7zOffsets[0] = 0;
            for (int i = 0; i < this.m7zCount; i++) {
                this.m7zSizes[i] = jSONArray.getInt(i);
                if (i > 0) {
                    this.m7zOffsets[i] = this.m7zOffsets[i - 1] + this.m7zSizes[i - 1];
                }
                this.m7zSzOffsets[i] = jSONArray2.getInt(i) + this.mOffset_7z;
            }
            this.m7zTotal = this.mJson_meta.getInt("total");
            return 0;
        } catch (Exception e) {
            Log.e(TAG, "[FAIL]read meta failed : " + e.toString());
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
        } catch (InterruptedException e) {
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
            this.mLockFile = new File(file, FILE_NAME_LOCK);
            this.mLockRAFile = new RandomAccessFile(this.mLockFile, "rw");
            this.mChannel = this.mLockRAFile.getChannel();
            this.mLock = this.mChannel.tryLock();
            return this.mLock != null;
        } catch (Exception e) {
            e.printStackTrace();
            LoadErrorCode.getInstance().trace("504:" + e.toString());
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
        } catch (Exception e) {
            LoadErrorCode.getInstance().trace("505:" + e.toString());
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
            } catch (IOException e) {
                Log.e(TAG, "[FAIL]create timestamp failed : " + e.toString());
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
                    int i;
                    try {
                        i = SevenZipUtils.this.submit();
                    } catch (UnsatisfiedLinkError e) {
                        LoadErrorCode.getInstance().trace("512:" + e.toString());
                        i = 89;
                    }
                    if (i == 0) {
                        SevenZipUtils.this.createTimestamp();
                    } else {
                        LoadErrorCode.getInstance().set(101, "write back: " + i);
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
            } catch (UnsatisfiedLinkError e) {
                LoadErrorCode.getInstance().trace("512:" + e.toString());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:78:0x0212 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean prepare(Context context, String str, String str2) {
        FileInputStream fileInputStream;
        boolean z;
        if (str == null) {
            z = false;
        } else {
            this.mContext = context.getApplicationContext();
            if (tryLock(str2)) {
                this.mTempPath = str2 + FILE_NAME_TEMP;
                File file = new File(this.mTempPath);
                if (file.exists()) {
                    FileUtils.deleteDir(file, null);
                }
                File file2 = new File(UtilsBlink.getDownloadLibPath(WebKitFactory.getContext()) + "libzeuswebviewchromium.so");
                this.mTimeStamp = checkTimestamp(this.mContext, str2);
                if (this.mTimeStamp == null && file2.exists() && !EngineManager.getInstance().isInstallBreak()) {
                    unLock();
                    LoadErrorCode.getInstance().trace(506);
                    z = false;
                } else {
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
                        fileInputStream = new FileInputStream(str);
                    } catch (Exception e) {
                        e = e;
                        fileInputStream = null;
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = null;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e2) {
                                Log.e(TAG, "[FAIL]close input stream failed : " + e2.toString());
                            }
                        }
                        throw th;
                    }
                    try {
                        try {
                            byte[] bArr = new byte[512];
                            fileInputStream.read(bArr);
                            String str3 = new String(bArr, "UTF-8");
                            this.mOffset_meta = str3.indexOf(FILE_SEP) + 2;
                            this.mOffset_elf = str3.indexOf(FILE_SEP, this.mOffset_meta) + 2;
                            this.mOffset_7z = str3.indexOf(FILE_SEP, this.mOffset_elf) + 2;
                            this.mJson_meta = new JSONObject(str3.substring(this.mOffset_meta, this.mOffset_elf - 2));
                            this.mJson_elf = new JSONObject(str3.substring(this.mOffset_elf, this.mOffset_7z - 2));
                            int i = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                            JSONArray jSONArray = this.mJson_elf.getJSONArray(LZMA_META_KEY_LOADABLE);
                            int i2 = 0;
                            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                                int i4 = jSONObject.getInt(LZMA_META_KEY_VADDR);
                                int i5 = jSONObject.getInt(LZMA_META_KEY_MEMSZ);
                                if (i4 < i) {
                                    i = i4;
                                }
                                if (i4 + i5 > i2) {
                                    i2 = i4 + i5;
                                }
                            }
                            this.mMinAddr = i;
                            this.mMaxAddr = i2;
                            this.mPrepared = true;
                            try {
                                fileInputStream.close();
                            } catch (Exception e3) {
                                Log.e(TAG, "[FAIL]close input stream failed : " + e3.toString());
                            }
                            z = true;
                        } catch (Exception e4) {
                            e = e4;
                            unLock();
                            LoadErrorCode.getInstance().trace("501:" + e);
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Exception e5) {
                                    Log.e(TAG, "[FAIL]close input stream failed : " + e5.toString());
                                }
                            }
                            z = false;
                            return z;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileInputStream != null) {
                        }
                        throw th;
                    }
                }
            } else {
                z = false;
            }
        }
        return z;
    }

    public void unzip(String str, String str2) {
        if (this.mErrorCode != 0) {
            return;
        }
        if (!sLibraryLoaded) {
            this.mErrorCode = 92;
            return;
        }
        File file = new File(str2);
        if (!file.exists() || !file.isDirectory()) {
            file.mkdirs();
        }
        try {
            int i = Build.VERSION.SDK_INT;
            if (i == 19 && Build.VERSION.RELEASE.contains("4.4.3")) {
                i = 20;
            }
            if (extract(str, str2, this.mOffset_7z, i) == 0) {
                return;
            }
        } catch (Throwable th) {
            Log.e(TAG, "failed to extract " + str + ": " + th);
        }
        this.mErrorCode = 91;
    }

    public synchronized void unzipWithMeta(String str, String str2) {
        if (this.mErrorCode == 0 && this.mPrepared) {
            this.mSrcPath = str;
            this.mDestPath = str2;
            if (isEnoughSpace(this.m7zTotal)) {
                int createDir = createDir(str2);
                this.mErrorCode = createDir;
                if (createDir == 0) {
                    int readMeta = readMeta();
                    this.mErrorCode = readMeta;
                    if (readMeta == 0) {
                        int decode = decode();
                        this.mErrorCode = decode;
                        if (decode == 0 && !this.mHooked) {
                            createTimestamp();
                        }
                    }
                }
            } else {
                this.mErrorCode = 94;
            }
        }
    }
}
