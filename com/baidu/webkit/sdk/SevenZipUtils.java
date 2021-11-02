package com.baidu.webkit.sdk;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.StatFs;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes11.dex */
public class SevenZipUtils {
    public static /* synthetic */ Interceptable $ic = null;
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
    public transient /* synthetic */ FieldHolder $fh;
    public int m7zCount;
    public String m7zFile;
    public int[] m7zOffsets;
    public int[] m7zSizes;
    public int[] m7zSzOffsets;
    public int m7zTotal;
    public FileChannel mChannel;
    public Context mContext;
    public String mDestPath;
    public boolean mEnableApiHook;
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
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(896902674, "Lcom/baidu/webkit/sdk/SevenZipUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(896902674, "Lcom/baidu/webkit/sdk/SevenZipUtils;");
                return;
            }
        }
        try {
            System.loadLibrary("zeuslzma");
            sLibraryLoaded = true;
        } catch (Throwable th) {
            Log.e(TAG, "failed to load lzma library: ".concat(String.valueOf(th)));
        }
    }

    public SevenZipUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mEnableApiHook = true;
    }

    public static void LogI(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
        }
    }

    private synchronized int createDir(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, str)) == null) {
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
        }
        return invokeL.intValue;
    }

    private int decode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            int i2 = 0;
            if (this.m7zCount <= 0 || this.m7zTotal <= 0) {
                return 0;
            }
            this.mContext.getResources().getAssets();
            int i3 = this.m7zCount;
            String str = this.m7zFile;
            int[] iArr = this.m7zSizes;
            int[] iArr2 = this.m7zOffsets;
            int[] iArr3 = this.m7zSzOffsets;
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
                newFixedThreadPool.submit(new Runnable(this, str, iArr2, i2, iArr, iArr3) { // from class: com.baidu.webkit.sdk.SevenZipUtils.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SevenZipUtils this$0;
                    public final /* synthetic */ String val$ffile;
                    public final /* synthetic */ int[] val$foffsets;
                    public final /* synthetic */ int[] val$fsizes;
                    public final /* synthetic */ int[] val$fszoffsets;
                    public final /* synthetic */ int val$n;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str, iArr2, Integer.valueOf(i2), iArr, iArr3};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i4 = newInitContext.flag;
                            if ((i4 & 1) != 0) {
                                int i5 = i4 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$ffile = str;
                        this.val$foffsets = iArr2;
                        this.val$n = i2;
                        this.val$fsizes = iArr;
                        this.val$fszoffsets = iArr3;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            SevenZipUtils sevenZipUtils = this.this$0;
                            String str3 = this.val$ffile;
                            int[] iArr4 = this.val$foffsets;
                            int i4 = this.val$n;
                            sevenZipUtils.decodeAndMerge(null, str3, iArr4[i4], this.val$fsizes[i4], this.val$fszoffsets[i4]);
                        }
                    }
                });
                i2++;
                i3 = i3;
            }
            shutdownAndAwaitTermination(newFixedThreadPool);
            return !this.mHooked ? submit() : doInit;
        }
        return invokeV.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native void decodeAndMerge(AssetManager assetManager, String str, int i2, int i3, int i4);

    private native int doHook(int i2, boolean z);

    private int doInit(String str, String str2, int i2, int i3, int i4, int i5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, this, new Object[]{str, str2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
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
        return invokeCommon.intValue;
    }

    private native int extract(String str, String str2, int i2, int i3);

    public static synchronized SevenZipUtils getInstance() {
        InterceptResult invokeV;
        SevenZipUtils sevenZipUtils;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            synchronized (SevenZipUtils.class) {
                if (mInstance == null) {
                    mInstance = new SevenZipUtils();
                }
                sevenZipUtils = mInstance;
            }
            return sevenZipUtils;
        }
        return (SevenZipUtils) invokeV.objValue;
    }

    private String getNativeLibraryDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) {
            String str = this.mContext.getApplicationContext().getApplicationInfo().nativeLibraryDir;
            if (str == null) {
                return this.mContext.getFilesDir().getParent() + "/lib";
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    private native int init(String str, String str2, int i2, int i3, int i4, int i5);

    private boolean isEnoughSpace(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65551, this, j)) == null) {
            try {
                StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                return ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks()) > j;
            } catch (Exception e2) {
                Log.i(TAG, "[WARNING]get available blocks failed : " + e2.toString());
                return true;
            }
        }
        return invokeJ.booleanValue;
    }

    private native int nativeCheckNativeMethods(String str);

    private int readMeta() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, this)) == null) {
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
                        int[] iArr = this.m7zOffsets;
                        int i4 = i3 - 1;
                        iArr[i3] = iArr[i4] + this.m7zSizes[i4];
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
        return invokeV.intValue;
    }

    private void shutdownAndAwaitTermination(ExecutorService executorService) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, this, executorService) == null) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native int submit();

    private boolean tryLock(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, this, str)) == null) {
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
        return invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unLock() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
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
    }

    public boolean checkNativeMethods(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? !sLibraryLoaded || this.mEnableApiHook || nativeCheckNativeMethods(str) >= 0 : invokeL.booleanValue;
    }

    public String checkTimestamp(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str)) == null) {
            String sdkVersionCode = WebKitFactory.getSdkVersionCode();
            if (TextUtils.isEmpty(sdkVersionCode)) {
                sdkVersionCode = GlobalConstants.DEFAULT_VERSION;
            }
            boolean z = true;
            String GetCloudSettingsValue = WebSettingsGlobalBlink.GetCloudSettingsValue("zeus_same_version_no7z_enable");
            if (GetCloudSettingsValue != null && GetCloudSettingsValue.equalsIgnoreCase("false")) {
                z = false;
            }
            Log.i(GlobalConstants.LOG_PER_TAG, "zeus_same_version_no7z_enable = ".concat(String.valueOf(z)));
            return (!z || GlobalConstants.DEFAULT_VERSION.equalsIgnoreCase(sdkVersionCode)) ? FileUtils.checkTimestamp(context, str, FILE_TIMESTAMP_PREFIX) : FileUtils.checkTimestamp(str, FILE_TIMESTAMP_PREFIX, sdkVersionCode);
        }
        return (String) invokeLL.objValue;
    }

    public String checkTimestamp(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? FileUtils.checkTimestamp(this.mContext, str, FILE_TIMESTAMP_PREFIX) : (String) invokeL.objValue;
    }

    public void clearTimestamp(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            FileUtils.clearTimestamp(this.mContext, str, FILE_TIMESTAMP_PREFIX);
        }
    }

    public void createTimestamp() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.mTimeStamp == null) {
            return;
        }
        try {
            new File(this.mDestPath, this.mTimeStamp).createNewFile();
        } catch (IOException e2) {
            Log.e(TAG, "[FAIL]create timestamp failed : " + e2.toString());
        }
    }

    public void finish() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.mPrepared) {
            this.mJson_meta = null;
            this.mJson_elf = null;
            if (!this.mHooked) {
                createTimestamp();
                return;
            }
            HandlerThread handlerThread = new HandlerThread("T7@write_back_lib");
            handlerThread.start();
            new Handler(handlerThread.getLooper()).post(new Runnable(this) { // from class: com.baidu.webkit.sdk.SevenZipUtils.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SevenZipUtils this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    int i2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            i2 = this.this$0.submit();
                        } catch (UnsatisfiedLinkError e2) {
                            LoadErrorCode loadErrorCode = LoadErrorCode.getInstance();
                            loadErrorCode.trace("512:" + e2.toString());
                            i2 = 89;
                        }
                        if (i2 == 0) {
                            this.this$0.createTimestamp();
                        } else {
                            LoadErrorCode.getInstance().set(101, "write back: ".concat(String.valueOf(i2)));
                            LoadErrorCode.Statistics.record();
                        }
                        this.this$0.unLock();
                    }
                }
            });
        }
    }

    public int getErrorCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (!this.mHooked) {
                unLock();
            }
            return this.mErrorCode;
        }
        return invokeV.intValue;
    }

    public void hook(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
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
    }

    public synchronized boolean prepare(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, str, str2)) == null) {
            synchronized (this) {
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
                        LoadErrorCode.getInstance().trace("501:".concat(String.valueOf(e)));
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
        }
        return invokeLLL.booleanValue;
    }

    public void unzip(String str, String str2) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, str, str2) == null) && this.mErrorCode == 0) {
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
    }

    public synchronized void unzipWithMeta(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, str2) == null) {
            synchronized (this) {
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
    }
}
