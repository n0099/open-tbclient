package com.baidu.webkit.sdk.performance;

import android.os.Looper;
import android.os.SystemClock;
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
/* loaded from: classes11.dex */
public class ZeusPerformanceTiming {
    private static final String CONFIG_FILE = "startup_timing_log";
    private static final String KEY_AMOUNT_FREE_DISK_SPACE = "AmountFreeDiskSpace";
    private static final String KEY_AMOUNT_PHYSICAL_MEMORY = "AmountPhysicalMemory";
    private static final String KEY_APP_NEW_WEBVIEW = "app_new_webview";
    private static final String KEY_BROWSER_STARTUP = "p1";
    private static final String KEY_BROWSER_STARTUP_THREAD = "p1-thread";
    private static final String KEY_BUILD_DATE_UTC = "BuildDateUTC";
    private static final String KEY_CHECK_USE_T7 = "k_p0";
    private static final String KEY_CHECK_USE_T7_THREAD = "k_p0_thread";
    private static final String KEY_CUR_CPU_FREQ = "CurCpuFreq";
    private static final String KEY_DALVIK_HEAP_SIZE = "DalvikHeapSize";
    private static final String KEY_FETCH_PACKAGE_INFO = "k_p1";
    private static final String KEY_FETCH_PACKAGE_INFO_THREAD = "k_p1_thread";
    private static final String KEY_FORCE_INIT_ZEUS = "force_init_zeus";
    private static final String KEY_GET_PROVIDER = "get_provider";
    private static final String KEY_GET_PROVIDER_THREAD = "get_provider_thread";
    private static final String KEY_GET_PROVIDER_THREAD_TIME = "get_provider_thread_time";
    private static final String KEY_INIT_START = "init_start";
    private static final String KEY_INIT_SYS_WEBKIT = "init_sys_webkit";
    private static final String KEY_INIT_WEBKIT = "init_webkit";
    private static final String KEY_INIT_WEBKIT_START_TIMESTAMP = "init_webkit_start_timestamp";
    private static final String KEY_INIT_WEBKIT_THREAD = "init_webkit_thread";
    private static final String KEY_INIT_WEBVIEW_START_TIMESTAMP = "init_webview_start_timestamp";
    private static final String KEY_INIT_WEBVIEW_THREAD_START_TIMESTAMP = "init_webview_thread_start_timestamp";
    private static final String KEY_IS_GET_PROVIDER_HIT_SYNCHRONIZED = "is_get_provider_hit_synchronized";
    private static final String KEY_IS_PROCESS_MAIN = "is_process_main";
    private static final String KEY_MAX_CPU_FREQ = "MaxCpuFreq";
    private static final String KEY_MEMORY = "memory";
    private static final String KEY_MIN_CPU_FREQ = "MinCpuFreq";
    private static final String KEY_NEW_SYS_WEBVIEW = "new_sys_webview";
    private static final String KEY_NEW_WEBVIEW = "new_webview";
    private static final String KEY_NEW_WEBVIEW_THREAD = "new_webview_thread";
    private static final String KEY_NEW_ZEUS_CL = "k_p2";
    private static final String KEY_NEW_ZEUS_CL_THREAD = "k_p2_thread";
    private static final String KEY_NUM_PROCESSORS = "NumProcessors";
    private static final String KEY_PROVIDER_HIT_SYNCHRONIZED_STACK = "provider_hit_synchronized_stack";
    private static final String KEY_PROVIDER_MTHREAD_STACK = "provider_mthread_stack";
    private static final String KEY_T7_CHROMIUM_PROVIDER_INIT = "k_p3";
    private static final String KEY_T7_CHROMIUM_PROVIDER_INIT_THREAD = "k_p3_thread";
    private static final String KEY_TYPE = "type";
    private static final String KEY_UNZIP = "unzip";
    private static final String KEY_UNZIP_END_DIFF = "unzip_end_diff";
    private static final String KEY_UNZIP_START_DIFF = "unzip_start_diff";
    private static final String KEY_UNZIP_THREAD = "unzip_thread";
    private static final String KEY_WEBKIT_INIT_STATISTICS = "webkit_init_statistics";
    private static final String KEY_WEBKIT_WEBVIEW_START_DIFF = "init_webkit_webview_start_diff";
    private static final String KEY_WEBVIEWCHROMIUM_CONSTRUCT = "p0";
    private static final String KEY_WEBVIEWCHROMIUM_CONSTRUCT_THREAD = "p0-thread";
    private static final String KEY_WEBVIEWCHROMIUM_INIT = "webviewchromium_init";
    private static final String KEY_WEBVIEWCHROMIUM_INIT_FOR_REAL = "p4";
    private static final String KEY_WEBVIEWCHROMIUM_INIT_FOR_REAL_THREAD = "p4-thread";
    private static final String KEY_WEBVIEWCHROMIUM_INIT_THREAD = "webviewchromium_init_thread";
    private static final String KEY_WEBVIEW_CONTENT_CLIENT_ADAPTER_CREATED = "p2";
    private static final String KEY_WEBVIEW_CONTENT_CLIENT_ADAPTER_CREATED_THREAD = "p2-thread";
    private static final String KEY_WEBVIEW_DEFAULT_SETTINGS = "p5";
    private static final String KEY_WEBVIEW_DEFAULT_SETTINGS_THREAD = "p5-thread";
    private static final String KEY_WEBVIEW_PROVIDER_INIT = "webview_provider_init";
    private static final String KEY_WEBVIEW_PROVIDER_INIT_THREAD = "webview_provider_init_thread";
    private static final String KEY_WEBVIEW_WAITING_RESOURCE = "webview_waiting_resource";
    private static final String KEY_WEBVIEW_ZWSETTINGS_CREATED = "p3";
    private static final String KEY_WEBVIEW_ZWSETTINGS_CREATED_THREAD = "p3-thread";
    private static final String KEY_ZEUS_WEBVIEW_LOAD_CLASS = "zeus_webview_load_class";
    private static final int MONITOR_TYPE_STARTUP_TIMING = 12300;
    public static final int RECORD_FROM_FORCE_INIT = 2;
    public static final int RECORD_FROM_WEBVIEW_INIT = 1;
    public static final String SERVER_TYPE_T7_INIT = "t7_init";
    private static long mBrowserStartUpEnd;
    private static long mBrowserStartUpThreadEnd;
    private static long mFetchDefaultPackageInfoEnd;
    private static long mFetchDefaultPackageInfoStart;
    private static long mFetchDefaultPackageInfoThreadEnd;
    private static long mFetchDefaultPackageInfoThreadStart;
    private static long mGetProviderImplEnd;
    private static long mGetProviderImplStart;
    private static long mInitOnAppStart;
    private static long mInitProviderEnd;
    private static long mInitProviderStart;
    private static long mInitProviderThreadEnd;
    private static long mInitProviderThreadStart;
    private static long mInitSharedPerfrencesEnd;
    private static long mInitSharedPerfrencesStart;
    private static boolean mIsForceInitT7;
    private static boolean mIsGetProviderHitSynchronized;
    private static boolean mIsMainThread;
    private static String mMainThreadStack;
    private static long mNewContentsClientAdapterEnd;
    private static long mNewContentsClientAdapterThreadEnd;
    private static long mNewSysWebViewEnd;
    private static long mNewSysWebViewStart;
    private static long mNewSysWebViewThreadEnd;
    private static long mNewSysWebViewThreadStart;
    private static long mNewWebViewChromiumConstructorEnd;
    private static long mNewWebViewChromiumConstructorThreadEnd;
    private static long mNewWebViewChromiumFactoryProviderInstanceEnd;
    private static long mNewWebViewChromiumFactoryProviderInstanceStart;
    private static long mNewWebViewChromiumFactoryProviderInstanceThreadEnd;
    private static long mNewWebViewChromiumFactoryProviderInstanceThreadStart;
    private static long mNewWebViewChromiumInitEnd;
    private static long mNewWebViewChromiumInitForRealEnd;
    private static long mNewWebViewChromiumInitForRealStart;
    private static long mNewWebViewChromiumInitForRealThreadEnd;
    private static long mNewWebViewChromiumInitForRealThreadStart;
    private static long mNewWebViewChromiumInitThreadEnd;
    private static long mNewWebViewEnd;
    private static long mNewWebViewProviderInitEnd;
    private static long mNewWebViewProviderInitStart;
    private static long mNewWebViewProviderInitThreadEnd;
    private static long mNewWebViewProviderInitThreadStart;
    private static long mNewWebViewResourceWaitingEnd;
    private static long mNewWebViewResourceWaitingStart;
    private static long mNewWebViewStart;
    private static long mNewWebViewThreadEnd;
    private static long mNewWebViewThreadStart;
    private static long mNewZeusClassLoaderEnd;
    private static long mNewZeusClassLoaderStart;
    private static long mNewZeusClassLoaderThreadEnd;
    private static long mNewZeusClassLoaderThreadStart;
    private static String mProviderHitSynchronizedStack;
    private static long mShouldUseSystemWebViewEnd;
    private static long mShouldUseSystemWebViewStart;
    private static long mShouldUseSystemWebViewThreadEnd;
    private static long mShouldUseSystemWebViewThreadStart;
    private static long mTranslateInitCloudSettingDataToMapEnd;
    private static long mTranslateInitCloudSettingDataToMapStart;
    private static long mUnzipEnd;
    private static long mUnzipStart;
    private static long mUnzipThreadEnd;
    private static long mUnzipThreadStart;
    private static long mWebViewChromiumFactoryLoadClassEnd;
    private static long mWebViewChromiumFactoryLoadClassStart;
    private static JSONObject mWebkitInitStatistics;
    private static int mZeusWebViewLoadClassTime;
    private static long mZwSettingsEnd;
    private static long mZwSettingsThreadEnd;
    private static long sInitSysWebkitEnd;
    private static long sInitSysWebkitStart;
    private static long sInitWebkitEnd;
    private static long sInitWebkitStart;
    private static long sInitWebkitThreadEnd;
    private static long sInitWebkitThreadStart;
    private static boolean sLogEnabled;
    private static int sRecordType;
    private static boolean sUploaded;
    private static long sWebViewInitTiming;
    private static List<Long> sWebViewInitTimingList = new ArrayList();

    public static long checkUseT7ThreadTime() {
        if (mShouldUseSystemWebViewThreadEnd <= 0 || mShouldUseSystemWebViewThreadStart <= 0) {
            return 0L;
        }
        return mShouldUseSystemWebViewThreadEnd - mShouldUseSystemWebViewThreadStart;
    }

    public static long checkUseT7Time() {
        if (mShouldUseSystemWebViewEnd <= 0 || mShouldUseSystemWebViewStart <= 0) {
            return 0L;
        }
        return mShouldUseSystemWebViewEnd - mShouldUseSystemWebViewStart;
    }

    public static void classLoaderLoadClassEnd() {
        mWebViewChromiumFactoryLoadClassEnd = getCurrentTimeMillis(mWebViewChromiumFactoryLoadClassEnd);
    }

    public static void classLoaderLoadClassStart() {
        mWebViewChromiumFactoryLoadClassStart = getCurrentTimeMillis(mWebViewChromiumFactoryLoadClassStart);
    }

    public static void fetchDefaultPackageInfoEnd() {
        mFetchDefaultPackageInfoEnd = getCurrentTimeMillis(mFetchDefaultPackageInfoEnd);
        mFetchDefaultPackageInfoThreadEnd = getCurrentThreadTimeMillis(mFetchDefaultPackageInfoThreadEnd);
    }

    public static void fetchDefaultPackageInfoStart() {
        mFetchDefaultPackageInfoStart = getCurrentTimeMillis(mFetchDefaultPackageInfoStart);
        mFetchDefaultPackageInfoThreadStart = getCurrentThreadTimeMillis(mFetchDefaultPackageInfoThreadStart);
    }

    public static long fetchPackageInfoThreadTime() {
        if (mFetchDefaultPackageInfoThreadEnd <= 0 || mFetchDefaultPackageInfoThreadStart <= 0) {
            return 0L;
        }
        return mFetchDefaultPackageInfoThreadEnd - mFetchDefaultPackageInfoThreadStart;
    }

    public static long fetchPackageInfoTime() {
        if (mFetchDefaultPackageInfoEnd <= 0 || mFetchDefaultPackageInfoStart <= 0) {
            return 0L;
        }
        return mFetchDefaultPackageInfoEnd - mFetchDefaultPackageInfoStart;
    }

    public static void forceInitT7() {
        mIsForceInitT7 = true;
    }

    private static boolean getBooleanFromFile() {
        if (WebKitFactory.getContext() == null) {
            return false;
        }
        try {
            return new File(new StringBuilder().append(WebKitFactory.getContext().getExternalFilesDir("").getAbsolutePath()).append("/startup_timing_log").toString()).exists();
        } catch (Exception e) {
            a.a(e);
            return false;
        }
    }

    private static long getCurrentThreadTimeMillis(long j) {
        return j == 0 ? SystemClock.currentThreadTimeMillis() : j;
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
        if (SessionMonitorEngine.getInstance().getWebViewTimeStamp() != null) {
            sb.append("\n new App WebView  " + SessionMonitorEngine.getInstance().getWebViewTimeStamp().toString());
        }
        if (mNewWebViewStart > 0 && mNewWebViewEnd > 0) {
            sb.append("new first zeus WebView = ");
            sb.append(String.valueOf(mNewWebViewEnd - mNewWebViewStart));
        }
        sb.append("\n new zeus WebView loasClass  " + mZeusWebViewLoadClassTime);
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
            makeTimingFormat(sb, "WebViewChromiumFactoryLoadClass   ", mWebViewChromiumFactoryLoadClassStart, mWebViewChromiumFactoryLoadClassEnd, sInitWebkitStart);
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
            jSONObject.put(KEY_INIT_WEBKIT_THREAD, initWebkitThreadTime());
            jSONObject.put(KEY_GET_PROVIDER, initProviderTime());
            jSONObject.put(KEY_GET_PROVIDER_THREAD, initProviderInMainThread());
            jSONObject.put(KEY_NEW_WEBVIEW, newWebViewTime());
            jSONObject.put(KEY_NEW_WEBVIEW_THREAD, newWebViewThreadTime());
            jSONObject.put(KEY_CHECK_USE_T7, checkUseT7Time());
            jSONObject.put(KEY_FETCH_PACKAGE_INFO, fetchPackageInfoTime());
            jSONObject.put(KEY_NEW_ZEUS_CL, newZeusClassLoaderTime());
            jSONObject.put(KEY_T7_CHROMIUM_PROVIDER_INIT, t7ChromiumProviderInit());
            jSONObject.put(KEY_ZEUS_WEBVIEW_LOAD_CLASS, zeusWebViewLoadClassTime());
            jSONObject.put(KEY_UNZIP, unzipTime());
            jSONObject.put(KEY_UNZIP_START_DIFF, unzipStartDiff());
            jSONObject.put(KEY_UNZIP_END_DIFF, unzipEndDiff());
            jSONObject.put(KEY_IS_PROCESS_MAIN, WebKitFactory.getNeedDownloadCloudResource());
            jSONObject.put(KEY_GET_PROVIDER_THREAD_TIME, initProviderThreadTime());
            jSONObject.put(KEY_CHECK_USE_T7_THREAD, checkUseT7ThreadTime());
            jSONObject.put(KEY_FETCH_PACKAGE_INFO_THREAD, fetchPackageInfoThreadTime());
            jSONObject.put(KEY_NEW_ZEUS_CL_THREAD, newZeusClassLoaderThreadTime());
            jSONObject.put(KEY_T7_CHROMIUM_PROVIDER_INIT_THREAD, t7ChromiumProviderInitThread());
            jSONObject.put(KEY_UNZIP_THREAD, unzipThreadTime());
            if (CommonUtils.getSysMemoryInfo() != null) {
                jSONObject.put(KEY_MEMORY, CommonUtils.getSysMemoryInfo().get("MemTotal:"));
            }
            HashMap<String, Long> currentSystemInfraInfo = WebView.getCurrentSystemInfraInfo();
            if (currentSystemInfraInfo != null) {
                Log.d("getZeusPerformanceTiming", " getCurrentSystemInfraInfo");
                jSONObject.put(KEY_NUM_PROCESSORS, currentSystemInfraInfo.get(KEY_NUM_PROCESSORS));
                jSONObject.put(KEY_MAX_CPU_FREQ, currentSystemInfraInfo.get(KEY_MAX_CPU_FREQ));
                jSONObject.put(KEY_AMOUNT_PHYSICAL_MEMORY, currentSystemInfraInfo.get(KEY_AMOUNT_PHYSICAL_MEMORY));
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
            jSONObject.putOpt(KEY_WEBVIEWCHROMIUM_CONSTRUCT, Long.valueOf(newWebViewChromiumConstructorTime()));
            jSONObject.putOpt(KEY_BROWSER_STARTUP, Long.valueOf(newBrowserStartUpTime()));
            jSONObject.putOpt("p2", Long.valueOf(newContentsClientAdapterTime()));
            jSONObject.putOpt(KEY_WEBVIEW_ZWSETTINGS_CREATED, Long.valueOf(newZwSettingsTime()));
            jSONObject.putOpt(KEY_WEBVIEWCHROMIUM_INIT_FOR_REAL, Long.valueOf(newWebViewChromiumInitForRealTime()));
            jSONObject.putOpt(KEY_WEBVIEW_WAITING_RESOURCE, Long.valueOf(newWebViewResourceWaitingTime()));
            jSONObject.putOpt(KEY_WEBVIEW_DEFAULT_SETTINGS, Long.valueOf(newWebViewDefaultSettingsTime()));
            jSONObject.putOpt(KEY_WEBVIEWCHROMIUM_INIT, Long.valueOf(newWebViewChromiumInitTime()));
            jSONObject.putOpt(KEY_WEBVIEW_PROVIDER_INIT, Long.valueOf(newWebViewProviderInitTime()));
            jSONObject.putOpt(KEY_WEBVIEWCHROMIUM_CONSTRUCT_THREAD, Long.valueOf(newWebViewChromiumConstructorThreadTime()));
            jSONObject.putOpt(KEY_BROWSER_STARTUP_THREAD, Long.valueOf(newBrowserStartUpThreadTime()));
            jSONObject.putOpt(KEY_WEBVIEW_CONTENT_CLIENT_ADAPTER_CREATED_THREAD, Long.valueOf(newContentsClientAdapterThreadTime()));
            jSONObject.putOpt(KEY_WEBVIEW_ZWSETTINGS_CREATED_THREAD, Long.valueOf(newZwSettingsThreadTime()));
            jSONObject.putOpt(KEY_WEBVIEWCHROMIUM_INIT_FOR_REAL_THREAD, Long.valueOf(newWebViewChromiumInitForRealThreadTime()));
            jSONObject.putOpt(KEY_WEBVIEW_DEFAULT_SETTINGS_THREAD, Long.valueOf(newWebViewDefaultSettingsThreadTime()));
            jSONObject.putOpt(KEY_WEBVIEWCHROMIUM_INIT_THREAD, Long.valueOf(newWebViewChromiumInitThreadTime()));
            jSONObject.putOpt(KEY_WEBVIEW_PROVIDER_INIT_THREAD, Long.valueOf(newWebViewProviderInitThreadTime()));
            jSONObject.putOpt(KEY_IS_GET_PROVIDER_HIT_SYNCHRONIZED, Boolean.valueOf(isGetProviderHitSynchronized()));
            jSONObject.putOpt(KEY_INIT_WEBKIT_START_TIMESTAMP, Long.valueOf(sInitWebkitStart));
            jSONObject.putOpt(KEY_INIT_WEBVIEW_START_TIMESTAMP, Long.valueOf(mNewWebViewStart));
            jSONObject.putOpt(KEY_WEBKIT_WEBVIEW_START_DIFF, Long.valueOf(mNewWebViewStart - sInitWebkitStart));
            jSONObject.putOpt(KEY_INIT_WEBVIEW_THREAD_START_TIMESTAMP, Long.valueOf(mNewWebViewThreadStart));
            if (mProviderHitSynchronizedStack != null) {
                jSONObject.putOpt(KEY_PROVIDER_HIT_SYNCHRONIZED_STACK, mProviderHitSynchronizedStack);
            }
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
        mInitProviderThreadEnd = getCurrentThreadTimeMillis(mInitProviderThreadEnd);
    }

    public static boolean initProviderInMainThread() {
        return mIsMainThread;
    }

    public static String initProviderMainThreadStack() {
        return mMainThreadStack != null ? mMainThreadStack : "";
    }

    public static void initProviderStart() {
        mInitProviderStart = getCurrentTimeMillis(mInitProviderStart);
        mInitProviderThreadStart = getCurrentThreadTimeMillis(mInitProviderThreadStart);
        boolean z = Looper.getMainLooper() == Looper.myLooper();
        mIsMainThread = z;
        if (z) {
            mMainThreadStack = android.util.Log.getStackTraceString(new NullPointerException());
            android.util.Log.i(GlobalConstants.LOG_PER_TAG, "initWebkit on MainThread  : " + mMainThreadStack);
        }
    }

    public static long initProviderThreadTime() {
        if (mInitProviderThreadEnd <= 0 || mInitProviderThreadStart <= 0) {
            return 0L;
        }
        return mInitProviderThreadEnd - mInitProviderThreadStart;
    }

    public static long initProviderTime() {
        if (mInitProviderEnd <= 0 || mInitProviderStart <= 0) {
            return 0L;
        }
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
        sInitWebkitThreadEnd = getCurrentThreadTimeMillis(sInitWebkitThreadEnd);
    }

    public static void initWebkitStart() {
        sInitWebkitStart = getCurrentTimeMillis(sInitWebkitStart);
        sInitWebkitThreadStart = getCurrentThreadTimeMillis(sInitWebkitThreadStart);
    }

    public static long initWebkitStartTime() {
        return sInitWebkitStart;
    }

    public static long initWebkitThreadTime() {
        if (sInitWebkitThreadEnd <= 0 || sInitWebkitThreadStart <= 0) {
            return 0L;
        }
        return sInitWebkitThreadEnd - sInitWebkitThreadStart;
    }

    public static long initWebkitTime() {
        if (sInitWebkitEnd <= 0 || sInitWebkitStart <= 0) {
            return 0L;
        }
        return sInitWebkitEnd - sInitWebkitStart;
    }

    public static boolean isGetProviderHitSynchronized() {
        return mIsGetProviderHitSynchronized;
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

    public static void newBrowserStartUpEnd() {
        mBrowserStartUpEnd = getCurrentTimeMillis(mBrowserStartUpEnd);
        mBrowserStartUpThreadEnd = getCurrentThreadTimeMillis(mBrowserStartUpThreadEnd);
    }

    public static long newBrowserStartUpThreadTime() {
        if (mBrowserStartUpThreadEnd <= 0 || mNewWebViewProviderInitThreadStart <= 0 || mBrowserStartUpThreadEnd <= mNewWebViewProviderInitThreadStart) {
            return 0L;
        }
        return mBrowserStartUpThreadEnd - mNewWebViewProviderInitThreadStart;
    }

    public static long newBrowserStartUpTime() {
        if (mBrowserStartUpEnd <= 0 || mNewWebViewProviderInitStart <= 0 || mBrowserStartUpEnd <= mNewWebViewProviderInitStart) {
            return 0L;
        }
        return mBrowserStartUpEnd - mNewWebViewProviderInitStart;
    }

    public static void newContentsClientAdapterEnd() {
        mNewContentsClientAdapterEnd = getCurrentTimeMillis(mNewContentsClientAdapterEnd);
        mNewContentsClientAdapterThreadEnd = getCurrentThreadTimeMillis(mNewContentsClientAdapterThreadEnd);
    }

    public static long newContentsClientAdapterThreadTime() {
        if (mNewContentsClientAdapterThreadEnd <= 0 || mBrowserStartUpThreadEnd <= 0 || mNewContentsClientAdapterThreadEnd <= mBrowserStartUpThreadEnd) {
            return 0L;
        }
        return mNewContentsClientAdapterThreadEnd - mBrowserStartUpThreadEnd;
    }

    public static long newContentsClientAdapterTime() {
        if (mNewContentsClientAdapterEnd <= 0 || mBrowserStartUpEnd <= 0 || mNewContentsClientAdapterEnd <= mBrowserStartUpEnd) {
            return 0L;
        }
        return mNewContentsClientAdapterEnd - mBrowserStartUpEnd;
    }

    public static void newSysWebViewEnd() {
        mNewSysWebViewEnd = getCurrentTimeMillis(mNewSysWebViewEnd);
        mNewSysWebViewThreadEnd = getCurrentThreadTimeMillis(mNewSysWebViewThreadEnd);
    }

    public static void newSysWebViewStart() {
        mNewSysWebViewStart = getCurrentTimeMillis(mNewSysWebViewStart);
        mNewSysWebViewThreadStart = getCurrentThreadTimeMillis(mNewSysWebViewThreadStart);
    }

    public static long newSysWebViewTime() {
        if (sInitSysWebkitEnd <= 0 || sInitSysWebkitStart <= 0) {
            return 0L;
        }
        return mNewSysWebViewEnd - mNewSysWebViewStart;
    }

    public static void newWebViewChromiumConstructorEnd() {
        mNewWebViewChromiumConstructorEnd = getCurrentTimeMillis(mNewWebViewChromiumConstructorEnd);
        mNewWebViewChromiumConstructorThreadEnd = getCurrentThreadTimeMillis(mNewWebViewChromiumConstructorThreadEnd);
    }

    public static long newWebViewChromiumConstructorThreadTime() {
        if (mNewWebViewThreadStart <= 0 || mNewWebViewChromiumConstructorThreadEnd <= 0) {
            if (mNewSysWebViewThreadStart <= 0 || mNewWebViewChromiumConstructorThreadEnd <= 0) {
                return 0L;
            }
            return mNewWebViewChromiumConstructorThreadEnd - mNewSysWebViewThreadStart;
        }
        return mNewWebViewChromiumConstructorThreadEnd - mNewWebViewThreadStart;
    }

    public static long newWebViewChromiumConstructorTime() {
        if (mNewWebViewStart <= 0 || mNewWebViewChromiumConstructorEnd <= 0) {
            if (mNewSysWebViewStart <= 0 || mNewWebViewChromiumConstructorEnd <= 0) {
                return 0L;
            }
            return mNewWebViewChromiumConstructorEnd - mNewSysWebViewStart;
        }
        return mNewWebViewChromiumConstructorEnd - mNewWebViewStart;
    }

    public static void newWebViewChromiumFactoryProviderInstanceEnd() {
        mNewWebViewChromiumFactoryProviderInstanceEnd = getCurrentTimeMillis(mNewWebViewChromiumFactoryProviderInstanceEnd);
        mNewWebViewChromiumFactoryProviderInstanceThreadEnd = getCurrentThreadTimeMillis(mNewWebViewChromiumFactoryProviderInstanceThreadEnd);
    }

    public static void newWebViewChromiumFactoryProviderInstanceStart() {
        mNewWebViewChromiumFactoryProviderInstanceStart = getCurrentTimeMillis(mNewWebViewChromiumFactoryProviderInstanceStart);
        mNewWebViewChromiumFactoryProviderInstanceThreadStart = getCurrentThreadTimeMillis(mNewWebViewChromiumFactoryProviderInstanceThreadStart);
    }

    public static void newWebViewChromiumInitEnd() {
        mNewWebViewChromiumInitEnd = getCurrentTimeMillis(mNewWebViewChromiumInitEnd);
        mNewWebViewChromiumInitThreadEnd = getCurrentThreadTimeMillis(mNewWebViewChromiumInitThreadEnd);
    }

    public static void newWebViewChromiumInitForRealEnd() {
        mNewWebViewChromiumInitForRealEnd = getCurrentTimeMillis(mNewWebViewChromiumInitForRealEnd);
        mNewWebViewChromiumInitForRealThreadEnd = getCurrentThreadTimeMillis(mNewWebViewChromiumInitForRealThreadEnd);
    }

    public static void newWebViewChromiumInitForRealStart() {
        mNewWebViewChromiumInitForRealStart = getCurrentTimeMillis(mNewWebViewChromiumInitForRealStart);
        mNewWebViewChromiumInitForRealThreadStart = getCurrentThreadTimeMillis(mNewWebViewChromiumInitForRealThreadStart);
    }

    public static long newWebViewChromiumInitForRealThreadTime() {
        if (mNewWebViewChromiumInitForRealThreadEnd <= 0 || mNewWebViewChromiumInitForRealThreadStart <= 0) {
            return 0L;
        }
        return mNewWebViewChromiumInitForRealThreadEnd - mNewWebViewChromiumInitForRealThreadStart;
    }

    public static long newWebViewChromiumInitForRealTime() {
        if (mNewWebViewChromiumInitForRealEnd <= 0 || mNewWebViewChromiumInitForRealStart <= 0) {
            return 0L;
        }
        return mNewWebViewChromiumInitForRealEnd - mNewWebViewChromiumInitForRealStart;
    }

    public static long newWebViewChromiumInitThreadTime() {
        if (mNewWebViewProviderInitThreadEnd <= 0 || mNewWebViewChromiumConstructorThreadEnd <= 0 || mNewWebViewProviderInitThreadEnd <= mNewWebViewChromiumConstructorThreadEnd) {
            return 0L;
        }
        return mNewWebViewProviderInitThreadEnd - mNewWebViewChromiumConstructorThreadEnd;
    }

    public static long newWebViewChromiumInitTime() {
        if (mNewWebViewProviderInitEnd <= 0 || mNewWebViewChromiumConstructorEnd <= 0 || mNewWebViewProviderInitEnd <= mNewWebViewChromiumConstructorEnd) {
            return 0L;
        }
        return mNewWebViewProviderInitEnd - mNewWebViewChromiumConstructorEnd;
    }

    public static long newWebViewDefaultSettingsThreadTime() {
        if (mNewWebViewThreadEnd <= 0 || mNewWebViewChromiumInitThreadEnd <= 0) {
            if (mNewSysWebViewThreadEnd <= 0 || mNewWebViewChromiumInitThreadEnd <= 0) {
                return 0L;
            }
            return mNewSysWebViewThreadEnd - mNewWebViewChromiumInitThreadEnd;
        }
        return mNewWebViewThreadEnd - mNewWebViewChromiumInitThreadEnd;
    }

    public static long newWebViewDefaultSettingsTime() {
        if (mNewWebViewEnd <= 0 || mNewWebViewChromiumInitEnd <= 0) {
            if (mNewSysWebViewEnd <= 0 || mNewWebViewChromiumInitEnd <= 0) {
                return 0L;
            }
            return mNewSysWebViewEnd - mNewWebViewChromiumInitEnd;
        }
        return mNewWebViewEnd - mNewWebViewChromiumInitEnd;
    }

    public static void newWebViewEnd() {
        mNewWebViewEnd = getCurrentTimeMillis(mNewWebViewEnd);
        mNewWebViewThreadEnd = getCurrentThreadTimeMillis(mNewWebViewThreadEnd);
        sWebViewInitTimingList.add(Long.valueOf(System.currentTimeMillis() - sWebViewInitTiming));
    }

    public static void newWebViewProviderInitEnd() {
        mNewWebViewProviderInitEnd = getCurrentTimeMillis(mNewWebViewProviderInitEnd);
        mNewWebViewProviderInitThreadEnd = getCurrentThreadTimeMillis(mNewWebViewProviderInitThreadEnd);
    }

    public static void newWebViewProviderInitStart() {
        mNewWebViewProviderInitStart = getCurrentTimeMillis(mNewWebViewProviderInitStart);
        mNewWebViewProviderInitThreadStart = getCurrentThreadTimeMillis(mNewWebViewProviderInitThreadStart);
    }

    public static long newWebViewProviderInitThreadTime() {
        if (mNewWebViewProviderInitThreadEnd <= 0 || mNewWebViewProviderInitThreadStart <= 0) {
            return 0L;
        }
        return mNewWebViewProviderInitThreadEnd - mNewWebViewProviderInitThreadStart;
    }

    public static long newWebViewProviderInitTime() {
        if (mNewWebViewProviderInitEnd <= 0 || mNewWebViewProviderInitStart <= 0) {
            return 0L;
        }
        return mNewWebViewProviderInitEnd - mNewWebViewProviderInitStart;
    }

    public static void newWebViewResourceWaitingEnd() {
        mNewWebViewResourceWaitingEnd = getCurrentTimeMillis(mNewWebViewResourceWaitingEnd);
    }

    public static void newWebViewResourceWaitingStart() {
        mNewWebViewResourceWaitingStart = getCurrentTimeMillis(mNewWebViewResourceWaitingStart);
    }

    public static long newWebViewResourceWaitingTime() {
        if (mNewWebViewResourceWaitingEnd <= 0 || mNewWebViewResourceWaitingStart <= 0) {
            return 0L;
        }
        return mNewWebViewResourceWaitingEnd - mNewWebViewResourceWaitingStart;
    }

    public static void newWebViewStart() {
        mNewWebViewStart = getCurrentTimeMillis(mNewWebViewStart);
        mNewWebViewThreadStart = getCurrentThreadTimeMillis(mNewWebViewThreadStart);
        sWebViewInitTiming = System.currentTimeMillis();
    }

    public static long newWebViewThreadTime() {
        return mNewWebViewThreadEnd - mNewWebViewThreadStart;
    }

    public static long newWebViewTime() {
        if (mNewWebViewEnd <= 0 || mNewWebViewStart <= 0) {
            return 0L;
        }
        return mNewWebViewEnd - mNewWebViewStart;
    }

    public static void newZeusClassLoaderEnd() {
        mNewZeusClassLoaderEnd = getCurrentTimeMillis(mNewZeusClassLoaderEnd);
        mNewZeusClassLoaderThreadEnd = getCurrentThreadTimeMillis(mNewZeusClassLoaderThreadEnd);
    }

    public static void newZeusClassLoaderStart() {
        mNewZeusClassLoaderStart = getCurrentTimeMillis(mNewZeusClassLoaderStart);
        mNewZeusClassLoaderThreadStart = getCurrentThreadTimeMillis(mNewZeusClassLoaderThreadStart);
    }

    public static long newZeusClassLoaderThreadTime() {
        if (mNewZeusClassLoaderThreadEnd <= 0 || mNewZeusClassLoaderThreadStart <= 0) {
            return 0L;
        }
        return mNewZeusClassLoaderThreadEnd - mNewZeusClassLoaderThreadStart;
    }

    public static long newZeusClassLoaderTime() {
        if (mNewZeusClassLoaderEnd <= 0 || mNewZeusClassLoaderStart <= 0) {
            return 0L;
        }
        return mNewZeusClassLoaderEnd - mNewZeusClassLoaderStart;
    }

    public static void newZwSettingsEnd() {
        mZwSettingsEnd = getCurrentTimeMillis(mZwSettingsEnd);
        mZwSettingsThreadEnd = getCurrentThreadTimeMillis(mZwSettingsThreadEnd);
    }

    public static long newZwSettingsThreadTime() {
        if (mZwSettingsThreadEnd <= 0 || mNewContentsClientAdapterThreadEnd <= 0 || mZwSettingsThreadEnd <= mNewContentsClientAdapterThreadEnd) {
            return 0L;
        }
        return mZwSettingsThreadEnd - mNewContentsClientAdapterThreadEnd;
    }

    public static long newZwSettingsTime() {
        if (mZwSettingsEnd <= 0 || mNewContentsClientAdapterEnd <= 0 || mZwSettingsEnd <= mNewContentsClientAdapterEnd) {
            return 0L;
        }
        return mZwSettingsEnd - mNewContentsClientAdapterEnd;
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
            public void run() {
                ZeusPerformanceTiming.upload();
            }
        });
        sUploaded = true;
    }

    public static void setIsGetProviderHitSynchronized(boolean z) {
        mIsGetProviderHitSynchronized = z;
        if (z) {
            mProviderHitSynchronizedStack = android.util.Log.getStackTraceString(new NullPointerException());
            android.util.Log.i(GlobalConstants.LOG_PER_TAG, "initWebkit hit synchronized  : " + mProviderHitSynchronizedStack);
        }
    }

    public static void setZeusWebkitInitStatistics(JSONObject jSONObject) {
        mWebkitInitStatistics = jSONObject;
    }

    public static void shouldUseSystemWebViewEnd() {
        mShouldUseSystemWebViewEnd = getCurrentTimeMillis(mShouldUseSystemWebViewEnd);
        mShouldUseSystemWebViewThreadEnd = getCurrentThreadTimeMillis(mShouldUseSystemWebViewThreadEnd);
    }

    public static void shouldUseSystemWebViewStart() {
        mShouldUseSystemWebViewStart = getCurrentTimeMillis(mShouldUseSystemWebViewStart);
        mShouldUseSystemWebViewThreadStart = getCurrentThreadTimeMillis(mShouldUseSystemWebViewThreadStart);
    }

    public static void sumLoadClassTime(long j) {
        if (mNewWebViewStart <= 0 || mNewWebViewEnd != 0) {
            return;
        }
        mZeusWebViewLoadClassTime += (int) j;
    }

    public static long t7ChromiumProviderInit() {
        if (mNewWebViewChromiumFactoryProviderInstanceEnd <= 0 || mNewWebViewChromiumFactoryProviderInstanceStart <= 0) {
            return 0L;
        }
        return mNewWebViewChromiumFactoryProviderInstanceEnd - mNewWebViewChromiumFactoryProviderInstanceStart;
    }

    public static long t7ChromiumProviderInitThread() {
        if (mNewWebViewChromiumFactoryProviderInstanceThreadEnd <= 0 || mNewWebViewChromiumFactoryProviderInstanceThreadStart <= 0) {
            return 0L;
        }
        return mNewWebViewChromiumFactoryProviderInstanceThreadEnd - mNewWebViewChromiumFactoryProviderInstanceThreadStart;
    }

    public static void translateInitCloudSettingDataToMapEnd() {
        mTranslateInitCloudSettingDataToMapEnd = getCurrentTimeMillis(mTranslateInitCloudSettingDataToMapEnd);
    }

    public static void translateInitCloudSettingDataToMapStart() {
        mTranslateInitCloudSettingDataToMapStart = getCurrentTimeMillis(mTranslateInitCloudSettingDataToMapStart);
    }

    public static void unzipEnd() {
        mUnzipEnd = getCurrentTimeMillis(mUnzipEnd);
        mUnzipThreadEnd = getCurrentThreadTimeMillis(mUnzipThreadEnd);
    }

    public static long unzipEndDiff() {
        return mUnzipEnd - mNewZeusClassLoaderEnd;
    }

    public static void unzipStart() {
        mUnzipStart = getCurrentTimeMillis(mUnzipStart);
        mUnzipThreadStart = getCurrentThreadTimeMillis(mUnzipThreadStart);
    }

    public static long unzipStartDiff() {
        return mNewZeusClassLoaderStart - mUnzipStart;
    }

    public static long unzipThreadTime() {
        if (mUnzipThreadEnd <= 0 || mUnzipThreadStart <= 0) {
            return 0L;
        }
        return mUnzipThreadEnd - mUnzipThreadStart;
    }

    public static long unzipTime() {
        if (mUnzipEnd <= 0 || mUnzipStart <= 0) {
            return 0L;
        }
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

    public static long zeusWebViewLoadClassTime() {
        return mZeusWebViewLoadClassTime;
    }
}
