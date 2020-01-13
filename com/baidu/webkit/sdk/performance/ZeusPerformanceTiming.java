package com.baidu.webkit.sdk.performance;

import android.os.Environment;
import android.os.Looper;
import com.a.a.a.a.a.a.a;
import com.baidu.webkit.internal.GlobalConstants;
import com.baidu.webkit.internal.daemon.ZeusThreadPoolUtil;
import com.baidu.webkit.internal.monitor.SessionMonitorEngine;
import com.baidu.webkit.internal.utils.CommonUtils;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
import com.baidu.webkit.sdk.WebView;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class ZeusPerformanceTiming {
    private static final String CONFIG_FILE = "startup_timing_log";
    private static final String KEY_AMOUNT_FREE_DISK_SPACE = "AmountFreeDiskSpace";
    private static final String KEY_AMOUNT_PHYSICAL_MEMORY = "AmountPhysicalMemory";
    private static final String KEY_APP_NEW_WEBVIEW = "app_new_webview";
    private static final String KEY_BUILD_DATE_UTC = "BuildDateUTC";
    private static final String KEY_DALVIK_HEAP_SIZE = "DalvikHeapSize";
    private static final String KEY_FORCE_INIT_ZEUS = "force_init_zeus";
    private static final String KEY_GET_PROVIDER = "get_provider";
    private static final String KEY_GET_PROVIDER_THREAD = "get_provider_thread";
    private static final String KEY_INIT_START = "init_start";
    private static final String KEY_INIT_SYS_WEBKIT = "init_sys_webkit";
    private static final String KEY_INIT_WEBKIT = "init_webkit";
    private static final String KEY_IS_PROCESS_MAIN = "is_process_main";
    private static final String KEY_MAX_CPU_FREQ = "MaxCpuFreq";
    private static final String KEY_MEMORY = "memory";
    private static final String KEY_NEW_SYS_WEBVIEW = "new_sys_webview";
    private static final String KEY_NEW_WEBVIEW = "new_webview";
    private static final String KEY_NEW_ZEUS_CL = "new_zeus_cl";
    private static final String KEY_NUM_PROCESSORS = "NumProcessors";
    private static final String KEY_PROVIDER_MTHREAD_STACK = "provider_mthread_stack";
    private static final String KEY_TYPE = "type";
    private static final String KEY_UNZIP = "unzip";
    private static final String KEY_UNZIP_END_DIFF = "unzip_end_diff";
    private static final String KEY_UNZIP_START_DIFF = "unzip_start_diff";
    private static final String KEY_WEBKIT_INIT_STATISTICS = "webkit_init_statistics";
    private static final int MONITOR_TYPE_STARTUP_TIMING = 12300;
    public static final int RECORD_FROM_FORCE_INIT = 2;
    public static final int RECORD_FROM_WEBVIEW_INIT = 1;
    public static final String SERVER_TYPE_T7_INIT = "t7_init";
    private static boolean mIsMainThread;
    private static String mMainThreadStack;
    private static JSONObject mWebkitInitStatistics;
    private static boolean sUploaded;
    private static boolean sLogEnabled = false;
    private static long mInitOnAppStart = 0;
    private static long sInitSysWebkitStart = 0;
    private static long sInitSysWebkitEnd = 0;
    private static long mNewSysWebViewStart = 0;
    private static long mNewSysWebViewEnd = 0;
    private static long mNewWebViewStart = 0;
    private static long mNewWebViewEnd = 0;
    private static long mInitProviderStart = 0;
    private static long mInitProviderEnd = 0;
    private static long mUnzipStart = 0;
    private static long mUnzipEnd = 0;
    private static long mNewZeusClassLoaderStart = 0;
    private static long mNewZeusClassLoaderEnd = 0;
    private static boolean mIsForceInitT7 = false;
    private static long sInitWebkitStart = 0;
    private static long sInitWebkitEnd = 0;
    private static int mNewWebViewLoadClassTime = 0;
    private static long mClassLoaderLoadClassStart = 0;
    private static long mClassLoaderLoadClassEnd = 0;
    private static long mShouldUseSystemWebViewStart = 0;
    private static long mShouldUseSystemWebViewEnd = 0;
    private static long mFetchDefaultPackageInfoStart = 0;
    private static long mFetchDefaultPackageInfoEnd = 0;
    private static long mGetProviderImplStart = 0;
    private static long mGetProviderImplEnd = 0;
    private static long mNewWebViewChromiumFactoryProviderInstanceStart = 0;
    private static long mNewWebViewChromiumFactoryProviderInstanceEnd = 0;
    private static long mInitSharedPerfrencesStart = 0;
    private static long mInitSharedPerfrencesEnd = 0;
    private static long mTranslateInitCloudSettingDataToMapStart = 0;
    private static long mTranslateInitCloudSettingDataToMapEnd = 0;
    private static List<Long> sWebViewInitTimingList = new ArrayList();
    private static long sWebViewInitTiming = 0;
    private static int sRecordType = 0;

    public static void classLoaderLoadClassEnd() {
        mClassLoaderLoadClassEnd = getCurrentTimeMillis(mClassLoaderLoadClassEnd);
    }

    public static void classLoaderLoadClassStart() {
        mClassLoaderLoadClassStart = getCurrentTimeMillis(mClassLoaderLoadClassStart);
    }

    public static void fetchDefaultPackageInfoEnd() {
        mFetchDefaultPackageInfoEnd = getCurrentTimeMillis(mFetchDefaultPackageInfoEnd);
    }

    public static void fetchDefaultPackageInfoStart() {
        mFetchDefaultPackageInfoStart = getCurrentTimeMillis(mFetchDefaultPackageInfoStart);
    }

    public static void forceInitT7() {
        mIsForceInitT7 = true;
    }

    private static boolean getBooleanFromFile() {
        try {
        } catch (Exception e) {
            a.a(e);
        }
        return new File(new StringBuilder().append(Environment.getExternalStorageDirectory().getAbsolutePath()).append("/startup_timing_log").toString()).exists();
    }

    private static long getCurrentTimeMillis(long j) {
        return j == 0 ? System.currentTimeMillis() : j;
    }

    public static void getProviderImplEnd() {
        mGetProviderImplEnd = getCurrentTimeMillis(mGetProviderImplEnd);
    }

    public static void getProviderImplStart() {
        mGetProviderImplStart = getCurrentTimeMillis(mGetProviderImplStart);
    }

    public static String getSysInitTiming() {
        StringBuilder sb = new StringBuilder();
        if (sInitSysWebkitStart > 0 && sInitSysWebkitEnd > 0) {
            sb.append("initSysWebkit = ");
            sb.append(String.valueOf(sInitSysWebkitEnd - sInitSysWebkitStart));
        }
        return sb.toString();
    }

    public static String getWebViewInitTiming() {
        StringBuilder sb = new StringBuilder();
        if (mNewWebViewStart > 0 && mNewWebViewEnd > 0) {
            sb.append("new first zeus WebView = ");
            sb.append(String.valueOf(mNewWebViewEnd - mNewWebViewStart));
        }
        return sb.toString();
    }

    public static List<Long> getWebViewInitTimings() {
        return sWebViewInitTimingList;
    }

    public static String getZeusInitTiming() {
        StringBuilder sb = new StringBuilder();
        if (sInitWebkitStart > 0 && sInitWebkitEnd > 0) {
            sb.append("initWebkit = ");
            sb.append(String.valueOf(sInitWebkitEnd - sInitWebkitStart));
            makeTimingFormat(sb, "shouldUseSystemWebView   ", mShouldUseSystemWebViewStart, mShouldUseSystemWebViewEnd, sInitWebkitStart);
            makeTimingFormat(sb, "fetchDefaultPackageInfo   ", mFetchDefaultPackageInfoStart, mFetchDefaultPackageInfoEnd, sInitWebkitStart);
            makeTimingFormat(sb, "ZeusClassLoader", mNewZeusClassLoaderStart, mNewZeusClassLoaderEnd, sInitWebkitStart);
            makeTimingFormat(sb, "classLoaderLoadClass   ", mClassLoaderLoadClassStart, mClassLoaderLoadClassEnd, sInitWebkitStart);
            makeTimingFormat(sb, "unzip          ", mUnzipStart, mUnzipEnd, sInitWebkitStart);
            makeTimingFormat(sb, "newWebViewChromiumFactoryProviderInstance   ", mNewWebViewChromiumFactoryProviderInstanceStart, mNewWebViewChromiumFactoryProviderInstanceEnd, sInitWebkitStart);
            makeTimingFormat(sb, "getProviderImpl   ", mGetProviderImplStart, mGetProviderImplEnd, sInitWebkitStart);
            makeTimingFormat(sb, "initProvider   ", mInitProviderStart, mInitProviderEnd, sInitWebkitStart);
        }
        return sb.toString();
    }

    public static String getZeusPerformanceTiming() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", 12300);
            jSONObject.put(KEY_INIT_START, initWebkitStartTime() - initOnAppStartTime());
            jSONObject.put(KEY_INIT_WEBKIT, initWebkitTime());
            jSONObject.put(KEY_GET_PROVIDER, initProviderTime());
            jSONObject.put(KEY_GET_PROVIDER_THREAD, initProviderInMainThread());
            jSONObject.put(KEY_NEW_WEBVIEW, newWebViewTime());
            jSONObject.put(KEY_NEW_ZEUS_CL, newZeusClassLoaderTime());
            jSONObject.put(KEY_UNZIP, unzipTime());
            jSONObject.put(KEY_UNZIP_START_DIFF, unzipStartDiff());
            jSONObject.put(KEY_UNZIP_END_DIFF, unzipEndDiff());
            jSONObject.put(KEY_IS_PROCESS_MAIN, WebKitFactory.getNeedDownloadCloudResource());
            if (CommonUtils.getSysMemoryInfo() != null) {
                jSONObject.put(KEY_MEMORY, CommonUtils.getSysMemoryInfo().get("MemTotal:"));
            }
            HashMap<String, Long> currentSystemInfraInfo = WebView.getCurrentSystemInfraInfo();
            if (currentSystemInfraInfo != null) {
                Log.d("getZeusPerformanceTiming", " getCurrentSystemInfraInfo");
                jSONObject.put(KEY_NUM_PROCESSORS, currentSystemInfraInfo.get(KEY_NUM_PROCESSORS));
                jSONObject.put(KEY_MAX_CPU_FREQ, currentSystemInfraInfo.get(KEY_MAX_CPU_FREQ));
                jSONObject.put(KEY_AMOUNT_PHYSICAL_MEMORY, currentSystemInfraInfo.get(KEY_AMOUNT_PHYSICAL_MEMORY));
                jSONObject.put(KEY_AMOUNT_FREE_DISK_SPACE, currentSystemInfraInfo.get(KEY_AMOUNT_FREE_DISK_SPACE));
                jSONObject.put(KEY_DALVIK_HEAP_SIZE, currentSystemInfraInfo.get(KEY_DALVIK_HEAP_SIZE));
                jSONObject.put(KEY_BUILD_DATE_UTC, currentSystemInfraInfo.get(KEY_BUILD_DATE_UTC));
            }
            jSONObject.put(KEY_APP_NEW_WEBVIEW, SessionMonitorEngine.getInstance().getWebViewTimeStamp());
            if (initProviderInMainThread()) {
                jSONObject.put(KEY_PROVIDER_MTHREAD_STACK, initProviderMainThreadStack());
            }
            jSONObject.put(KEY_FORCE_INIT_ZEUS, isforceInitT7());
            jSONObject.put(KEY_NEW_SYS_WEBVIEW, newSysWebViewTime());
            jSONObject.put(KEY_INIT_SYS_WEBKIT, initSysWebkitTime());
            jSONObject.put(KEY_WEBKIT_INIT_STATISTICS, mWebkitInitStatistics);
            return jSONObject.toString();
        } catch (JSONException e) {
            Log.printStackTrace(e);
            return null;
        }
    }

    public static void initOnAppStart() {
        mInitOnAppStart = getCurrentTimeMillis(mInitOnAppStart);
    }

    public static long initOnAppStartTime() {
        return mInitOnAppStart;
    }

    public static void initProviderEnd() {
        mInitProviderEnd = getCurrentTimeMillis(mInitProviderEnd);
    }

    public static boolean initProviderInMainThread() {
        return mIsMainThread;
    }

    public static String initProviderMainThreadStack() {
        return mMainThreadStack != null ? mMainThreadStack : "";
    }

    public static void initProviderStart() {
        mInitProviderStart = getCurrentTimeMillis(mInitProviderStart);
        boolean z = Looper.getMainLooper() == Looper.myLooper();
        mIsMainThread = z;
        if (z) {
            mMainThreadStack = android.util.Log.getStackTraceString(new NullPointerException());
            android.util.Log.i(GlobalConstants.LOG_PER_TAG, "initWebkit on MainThread  : " + mMainThreadStack);
        }
    }

    public static long initProviderTime() {
        return mInitProviderEnd - mInitProviderStart;
    }

    public static void initSharedPerfrencesEnd() {
        mInitSharedPerfrencesEnd = getCurrentTimeMillis(mInitSharedPerfrencesEnd);
    }

    public static void initSharedPerfrencesStart() {
        mInitSharedPerfrencesStart = getCurrentTimeMillis(mInitSharedPerfrencesStart);
    }

    public static void initSysWebkitEnd() {
        sInitSysWebkitEnd = getCurrentTimeMillis(sInitSysWebkitEnd);
    }

    public static void initSysWebkitStart() {
        sInitSysWebkitStart = getCurrentTimeMillis(sInitSysWebkitStart);
    }

    public static long initSysWebkitTime() {
        if (sInitSysWebkitEnd <= 0 || sInitSysWebkitStart <= 0) {
            return 0L;
        }
        return sInitSysWebkitEnd - sInitSysWebkitStart;
    }

    public static void initWebkitEnd() {
        sInitWebkitEnd = getCurrentTimeMillis(sInitWebkitEnd);
    }

    public static void initWebkitStart() {
        sInitWebkitStart = getCurrentTimeMillis(sInitWebkitStart);
    }

    public static long initWebkitStartTime() {
        return sInitWebkitStart;
    }

    public static long initWebkitTime() {
        return sInitWebkitEnd - sInitWebkitStart;
    }

    public static boolean isforceInitT7() {
        return mIsForceInitT7;
    }

    private static void makeTimingFormat(StringBuilder sb, String str, long j, long j2, long j3) {
        if (sb == null || str == null || j <= 0 || j2 <= 0) {
            return;
        }
        sb.append('\n');
        sb.append(str + " from init: ");
        sb.append(j2 - j3);
        sb.append(" self: ");
        sb.append(j2 - j);
    }

    public static void newSysWebViewEnd() {
        mNewSysWebViewEnd = getCurrentTimeMillis(mNewSysWebViewEnd);
    }

    public static void newSysWebViewStart() {
        mNewSysWebViewStart = getCurrentTimeMillis(mNewSysWebViewStart);
    }

    public static long newSysWebViewTime() {
        if (sInitSysWebkitEnd <= 0 || sInitSysWebkitStart <= 0) {
            return 0L;
        }
        return mNewSysWebViewEnd - mNewSysWebViewStart;
    }

    public static void newWebViewChromiumFactoryProviderInstanceEnd() {
        mNewWebViewChromiumFactoryProviderInstanceEnd = getCurrentTimeMillis(mNewWebViewChromiumFactoryProviderInstanceEnd);
    }

    public static void newWebViewChromiumFactoryProviderInstanceStart() {
        mNewWebViewChromiumFactoryProviderInstanceStart = getCurrentTimeMillis(mNewWebViewChromiumFactoryProviderInstanceStart);
    }

    public static void newWebViewEnd() {
        mNewWebViewEnd = getCurrentTimeMillis(mNewWebViewEnd);
        sWebViewInitTimingList.add(Long.valueOf(System.currentTimeMillis() - sWebViewInitTiming));
    }

    public static void newWebViewStart() {
        mNewWebViewStart = getCurrentTimeMillis(mNewWebViewStart);
        sWebViewInitTiming = System.currentTimeMillis();
    }

    public static long newWebViewTime() {
        return mNewWebViewEnd - mNewWebViewStart;
    }

    public static void newZeusClassLoaderEnd() {
        mNewZeusClassLoaderEnd = getCurrentTimeMillis(mNewZeusClassLoaderEnd);
    }

    public static void newZeusClassLoaderStart() {
        mNewZeusClassLoaderStart = getCurrentTimeMillis(mNewZeusClassLoaderStart);
    }

    public static long newZeusClassLoaderTime() {
        return mNewZeusClassLoaderEnd - mNewZeusClassLoaderStart;
    }

    public static void recordWebkitInitStatistics(int i) {
        if (sUploaded) {
            return;
        }
        sRecordType |= i;
        if (WebKitFactory.isForceInitT7() && sRecordType != 3) {
            Log.i("ZeusPerformanceTiming", "wait forceT7Init and WebView inited, sRecordType=" + sRecordType);
            return;
        }
        ZeusThreadPoolUtil.executeIgnoreZeus(new Runnable() { // from class: com.baidu.webkit.sdk.performance.ZeusPerformanceTiming.1
            @Override // java.lang.Runnable
            public final void run() {
                ZeusPerformanceTiming.upload();
            }
        });
        sUploaded = true;
    }

    public static void setZeusWebkitInitStatistics(JSONObject jSONObject) {
        mWebkitInitStatistics = jSONObject;
    }

    public static void shouldUseSystemWebViewEnd() {
        mShouldUseSystemWebViewEnd = getCurrentTimeMillis(mShouldUseSystemWebViewEnd);
    }

    public static void shouldUseSystemWebViewStart() {
        mShouldUseSystemWebViewStart = getCurrentTimeMillis(mShouldUseSystemWebViewStart);
    }

    public static void sumLoadClassTime(long j) {
        if (mNewWebViewStart <= 0 || mNewWebViewEnd != 0) {
            return;
        }
        mNewWebViewLoadClassTime = (int) (mNewWebViewLoadClassTime + j);
    }

    public static void translateInitCloudSettingDataToMapEnd() {
        mTranslateInitCloudSettingDataToMapEnd = getCurrentTimeMillis(mTranslateInitCloudSettingDataToMapEnd);
    }

    public static void translateInitCloudSettingDataToMapStart() {
        mTranslateInitCloudSettingDataToMapStart = getCurrentTimeMillis(mTranslateInitCloudSettingDataToMapStart);
    }

    public static void unzipEnd() {
        mUnzipEnd = getCurrentTimeMillis(mUnzipEnd);
    }

    public static long unzipEndDiff() {
        return mUnzipEnd - mNewZeusClassLoaderEnd;
    }

    public static void unzipStart() {
        mUnzipStart = getCurrentTimeMillis(mUnzipStart);
    }

    public static long unzipStartDiff() {
        return mNewZeusClassLoaderStart - mUnzipStart;
    }

    public static long unzipTime() {
        return mUnzipEnd - mUnzipStart;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void upload() {
        try {
            sLogEnabled = getBooleanFromFile();
            String zeusPerformanceTiming = getZeusPerformanceTiming();
            if (sLogEnabled) {
                Log.i("ZeusPerformanceTiming", "upload data: " + zeusPerformanceTiming);
            }
            if (zeusPerformanceTiming != null) {
                SessionMonitorEngine.getInstance().recordImmediately(SERVER_TYPE_T7_INIT, zeusPerformanceTiming);
            }
        } catch (Exception e) {
            Log.printStackTrace(e);
        }
    }
}
