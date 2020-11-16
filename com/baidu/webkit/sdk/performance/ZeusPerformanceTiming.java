package com.baidu.webkit.sdk.performance;

import android.os.Looper;
import android.os.SystemClock;
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
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ZeusPerformanceTiming {
    private static final String CONFIG_FILE = "startup_timing_log";
    private static final String KEY_AMOUNT_FREE_DISK_SPACE = "AmountFreeDiskSpace";
    private static final String KEY_AMOUNT_PHYSICAL_MEMORY = "AmountPhysicalMemory";
    private static final String KEY_APP_NEW_WEBVIEW = "app_new_webview";
    private static final String KEY_APP_START_SOURCE = "app_start_source";
    public static final String KEY_BROWSER_STARTUP = "p1";
    private static final String KEY_BROWSER_STARTUP_THREAD = "p1_thread";
    private static final String KEY_BUILD_DATE_UTC = "BuildDateUTC";
    public static final String KEY_CHECK_USE_T7 = "k_p0";
    private static final String KEY_CHECK_USE_T7_THREAD = "k_p0_thread";
    private static final String KEY_CUR_CPU_FREQ = "CurCpuFreq";
    private static final String KEY_DALVIK_HEAP_SIZE = "DalvikHeapSize";
    public static final String KEY_FETCH_PACKAGE_INFO = "k_p1";
    private static final String KEY_FETCH_PACKAGE_INFO_THREAD = "k_p1_thread";
    private static final String KEY_FORCE_INIT_ZEUS = "force_init_zeus";
    public static final String KEY_GET_PROVIDER = "get_provider";
    private static final String KEY_GET_PROVIDER_THREAD = "get_provider_thread";
    private static final String KEY_GET_PROVIDER_THREAD_TIME = "get_provider_thread_time";
    private static final String KEY_INIT_START = "init_start";
    public static final String KEY_INIT_SYS_WEBKIT = "init_sys_webkit";
    public static final String KEY_INIT_WEBKIT = "init_webkit";
    private static final String KEY_INIT_WEBKIT_START_TIMESTAMP = "init_webkit_start_timestamp";
    private static final String KEY_INIT_WEBKIT_THREAD = "init_webkit_thread";
    private static final String KEY_INIT_WEBVIEW_START_TIMESTAMP = "init_webview_start_timestamp";
    private static final String KEY_INIT_WEBVIEW_THREAD_START_TIMESTAMP = "init_webview_thread_start_timestamp";
    private static final String KEY_IS_GET_PROVIDER_HIT_SYNCHRONIZED = "is_get_provider_hit_synchronized";
    private static final String KEY_IS_PROCESS_MAIN = "is_process_main";
    private static final String KEY_MAX_CPU_FREQ = "MaxCpuFreq";
    private static final String KEY_MEMORY = "memory";
    private static final String KEY_MIN_CPU_FREQ = "MinCpuFreq";
    public static final String KEY_NEW_SYS_WEBVIEW = "new_sys_webview";
    private static final String KEY_NEW_WEBVIEW = "new_webview";
    public static final String KEY_NEW_WEBVIEW_METHOD = "new_webview_method";
    private static final String KEY_NEW_WEBVIEW_METHOD_THREAD = "new_webview_method_thread";
    private static final String KEY_NEW_WEBVIEW_THREAD = "new_webview_thread";
    public static final String KEY_NEW_ZEUS_CL = "k_p2";
    private static final String KEY_NEW_ZEUS_CL_THREAD = "k_p2_thread";
    private static final String KEY_NUM_PROCESSORS = "NumProcessors";
    private static final String KEY_PROVIDER_HIT_SYNCHRONIZED_STACK = "provider_hit_synchronized_stack";
    private static final String KEY_PROVIDER_MTHREAD_STACK = "provider_mthread_stack";
    public static final String KEY_T7_CHROMIUM_PROVIDER_INIT = "k_p3";
    public static final String KEY_T7_CHROMIUM_PROVIDER_INIT_STEP0 = "k_p3_s0";
    public static final String KEY_T7_CHROMIUM_PROVIDER_INIT_STEP1 = "k_p3_s1";
    public static final String KEY_T7_CHROMIUM_PROVIDER_INIT_STEP2 = "k_p3_s2";
    public static final String KEY_T7_CHROMIUM_PROVIDER_INIT_STEP3 = "k_p3_s3";
    private static final String KEY_T7_CHROMIUM_PROVIDER_INIT_THREAD = "k_p3_thread";
    private static final String KEY_T7_CHROMIUM_PROVIDER_INIT_THREAD_STEP0 = "k_p3_s0_thread";
    private static final String KEY_T7_CHROMIUM_PROVIDER_INIT_THREAD_STEP1 = "k_p3_s1_thread";
    private static final String KEY_T7_CHROMIUM_PROVIDER_INIT_THREAD_STEP2 = "k_p3_s2_thread";
    private static final String KEY_T7_CHROMIUM_PROVIDER_INIT_THREAD_STEP3 = "k_p3_s3_thread";
    private static final String KEY_TYPE = "type";
    public static final String KEY_UNZIP = "unzip";
    private static final String KEY_UNZIP_END_DIFF = "unzip_end_diff";
    private static final String KEY_UNZIP_START_DIFF = "unzip_start_diff";
    private static final String KEY_UNZIP_THREAD = "unzip_thread";
    private static final String KEY_WEBKIT_INIT_STATISTICS = "webkit_init_statistics";
    private static final String KEY_WEBKIT_WEBVIEW_START_DIFF = "init_webkit_webview_start_diff";
    public static final String KEY_WEBVIEWCHROMIUM_CONSTRUCT = "p0";
    private static final String KEY_WEBVIEWCHROMIUM_CONSTRUCT_THREAD = "p0_thread";
    public static final String KEY_WEBVIEWCHROMIUM_INIT = "webviewchromium_init";
    public static final String KEY_WEBVIEWCHROMIUM_INIT_FOR_REAL = "p4";
    private static final String KEY_WEBVIEWCHROMIUM_INIT_FOR_REAL_THREAD = "p4_thread";
    private static final String KEY_WEBVIEWCHROMIUM_INIT_THREAD = "webviewchromium_init_thread";
    public static final String KEY_WEBVIEW_CONTENT_CLIENT_ADAPTER_CREATED = "p2";
    private static final String KEY_WEBVIEW_CONTENT_CLIENT_ADAPTER_CREATED_THREAD = "p2_thread";
    public static final String KEY_WEBVIEW_DEFAULT_SETTINGS = "p5";
    private static final String KEY_WEBVIEW_DEFAULT_SETTINGS_THREAD = "p5_thread";
    public static final String KEY_WEBVIEW_PROVIDER_INIT = "webview_provider_init";
    private static final String KEY_WEBVIEW_PROVIDER_INIT_THREAD = "webview_provider_init_thread";
    public static final String KEY_WEBVIEW_WAITING_RESOURCE = "webview_waiting_resource";
    public static final String KEY_WEBVIEW_ZWSETTINGS_CREATED = "p3";
    private static final String KEY_WEBVIEW_ZWSETTINGS_CREATED_THREAD = "p3_thread";
    private static final String KEY_ZEUS_WEBVIEW_LOAD_CLASS = "zeus_webview_load_class";
    private static final int MONITOR_TYPE_STARTUP_TIMING = 12300;
    public static final int RECORD_FROM_FORCE_INIT = 2;
    public static final int RECORD_FROM_WEBVIEW_INIT = 1;
    public static final String SERVER_TYPE_T7_INIT = "t7_init";
    private static long mInitOnAppStart;
    private static boolean mIsForceInitT7;
    private static boolean mIsGetProviderHitSynchronized;
    private static boolean mIsMainThread;
    private static String mMainThreadStack;
    private static String mProviderHitSynchronizedStack;
    private static JSONObject mWebkitInitStatistics;
    private static int mZeusWebViewLoadClassTime;
    private static String sAppStartSource;
    private static boolean sLogEnabled;
    private static int sRecordType;
    private static boolean sUploaded;
    private static long sWebViewInitTiming;
    private static List<Long> sWebViewInitTimingList = new ArrayList();
    private static ConcurrentHashMap<String, Long> sStartTimeStamps = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, Long> sEndTimeStamps = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, Long> sStartThreadTimeStamps = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, Long> sEndThreadTimeStamps = new ConcurrentHashMap<>();

    /* loaded from: classes5.dex */
    public enum Stage {
        Start,
        End
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
            e.printStackTrace();
            return false;
        }
    }

    private static long getCurrentThreadTimeMillis(long j) {
        return j == 0 ? SystemClock.currentThreadTimeMillis() : j;
    }

    private static long getCurrentTimeMillis(long j) {
        return j == 0 ? System.currentTimeMillis() : j;
    }

    public static long getRecordedThreadTime(String str) {
        if (sStartThreadTimeStamps.containsKey(str) && sEndThreadTimeStamps.containsKey(str)) {
            long longValue = sEndThreadTimeStamps.get(str).longValue();
            long longValue2 = sStartThreadTimeStamps.get(str).longValue();
            if (longValue > longValue2) {
                return longValue - longValue2;
            }
        }
        return 0L;
    }

    public static long getRecordedTime(String str) {
        if (sStartTimeStamps.containsKey(str) && sEndTimeStamps.containsKey(str)) {
            long longValue = sEndTimeStamps.get(str).longValue();
            long longValue2 = sStartTimeStamps.get(str).longValue();
            if (longValue > longValue2) {
                return longValue - longValue2;
            }
        }
        return 0L;
    }

    public static String getSysInitTiming() {
        StringBuilder sb = new StringBuilder();
        if (sStartTimeStamps.containsKey(KEY_INIT_SYS_WEBKIT) && sEndTimeStamps.containsKey(KEY_INIT_SYS_WEBKIT)) {
            sb.append("initSysWebkit = ");
            sb.append(String.valueOf(getRecordedTime(KEY_INIT_SYS_WEBKIT)));
        }
        return sb.toString();
    }

    private static long getTimeStampFromMap(Map<String, Long> map, String str) {
        if (map == null || str == null || !map.containsKey(str)) {
            return 0L;
        }
        return map.get(str).longValue();
    }

    public static String getWebViewInitTiming() {
        StringBuilder sb = new StringBuilder();
        if (SessionMonitorEngine.getInstance().getWebViewTimeStamp() != null) {
            sb.append("\n new App WebView  " + SessionMonitorEngine.getInstance().getWebViewTimeStamp().toString());
        }
        if (sStartTimeStamps.containsKey(KEY_NEW_WEBVIEW_METHOD) && sEndTimeStamps.containsKey(KEY_NEW_WEBVIEW_METHOD)) {
            sb.append("new first zeus WebView = ");
            sb.append(String.valueOf(getRecordedTime(KEY_NEW_WEBVIEW_METHOD)));
        }
        sb.append("\n new zeus WebView loasClass  " + mZeusWebViewLoadClassTime);
        return sb.toString();
    }

    public static List<Long> getWebViewInitTimings() {
        return sWebViewInitTimingList;
    }

    public static String getZeusInitTiming() {
        StringBuilder sb = new StringBuilder();
        if (sStartTimeStamps.containsKey(KEY_INIT_WEBKIT) && sEndTimeStamps.containsKey(KEY_INIT_WEBKIT)) {
            sb.append("initWebkit = ");
            sb.append(getRecordedTime(KEY_INIT_WEBKIT));
            long longValue = sStartTimeStamps.get(KEY_INIT_WEBKIT).longValue();
            makeTimingFormat(sb, "shouldUseSystemWebView   ", getTimeStampFromMap(sStartTimeStamps, KEY_CHECK_USE_T7), getTimeStampFromMap(sEndTimeStamps, KEY_CHECK_USE_T7), longValue);
            makeTimingFormat(sb, "fetchDefaultPackageInfo   ", getTimeStampFromMap(sStartTimeStamps, KEY_FETCH_PACKAGE_INFO), getTimeStampFromMap(sEndTimeStamps, KEY_FETCH_PACKAGE_INFO), longValue);
            makeTimingFormat(sb, "ZeusClassLoader", getTimeStampFromMap(sStartTimeStamps, KEY_NEW_ZEUS_CL), getTimeStampFromMap(sEndTimeStamps, KEY_NEW_ZEUS_CL), longValue);
            makeTimingFormat(sb, "unzip          ", getTimeStampFromMap(sStartTimeStamps, KEY_UNZIP), getTimeStampFromMap(sEndTimeStamps, KEY_UNZIP), longValue);
            makeTimingFormat(sb, "newWebViewChromiumFactoryProviderInstance   ", getTimeStampFromMap(sStartTimeStamps, KEY_T7_CHROMIUM_PROVIDER_INIT), getTimeStampFromMap(sEndTimeStamps, KEY_T7_CHROMIUM_PROVIDER_INIT), longValue);
            makeTimingFormat(sb, "initProvider   ", getTimeStampFromMap(sStartTimeStamps, KEY_GET_PROVIDER), getTimeStampFromMap(sEndTimeStamps, KEY_GET_PROVIDER), longValue);
        }
        return sb.toString();
    }

    public static String getZeusPerformanceTiming() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("type", 12300);
            jSONObject.putOpt(KEY_INIT_START, Long.valueOf(initWebkitStartTime() - initOnAppStartTime()));
            jSONObject.putOpt(KEY_INIT_WEBKIT, Long.valueOf(getRecordedTime(KEY_INIT_WEBKIT)));
            jSONObject.putOpt(KEY_INIT_WEBKIT_THREAD, Long.valueOf(getRecordedThreadTime(KEY_INIT_WEBKIT)));
            jSONObject.putOpt(KEY_GET_PROVIDER, Long.valueOf(getRecordedTime(KEY_GET_PROVIDER)));
            jSONObject.putOpt(KEY_GET_PROVIDER_THREAD, Boolean.valueOf(initProviderInMainThread()));
            jSONObject.putOpt(KEY_NEW_WEBVIEW, Long.valueOf(newWebViewTime()));
            jSONObject.putOpt(KEY_NEW_WEBVIEW_THREAD, Long.valueOf(newWebViewThreadTime()));
            jSONObject.putOpt(KEY_NEW_WEBVIEW_METHOD, Long.valueOf(getRecordedTime(KEY_NEW_WEBVIEW_METHOD)));
            jSONObject.putOpt(KEY_NEW_WEBVIEW_METHOD_THREAD, Long.valueOf(getRecordedThreadTime(KEY_NEW_WEBVIEW_METHOD)));
            jSONObject.putOpt(KEY_CHECK_USE_T7, Long.valueOf(getRecordedTime(KEY_CHECK_USE_T7)));
            jSONObject.putOpt(KEY_FETCH_PACKAGE_INFO, Long.valueOf(getRecordedTime(KEY_FETCH_PACKAGE_INFO)));
            jSONObject.putOpt(KEY_NEW_ZEUS_CL, Long.valueOf(getRecordedTime(KEY_NEW_ZEUS_CL)));
            jSONObject.putOpt(KEY_T7_CHROMIUM_PROVIDER_INIT, Long.valueOf(getRecordedTime(KEY_T7_CHROMIUM_PROVIDER_INIT)));
            jSONObject.putOpt(KEY_T7_CHROMIUM_PROVIDER_INIT_STEP0, Long.valueOf(getRecordedTime(KEY_T7_CHROMIUM_PROVIDER_INIT_STEP0)));
            jSONObject.putOpt(KEY_T7_CHROMIUM_PROVIDER_INIT_STEP1, Long.valueOf(getRecordedTime(KEY_T7_CHROMIUM_PROVIDER_INIT_STEP1)));
            jSONObject.putOpt(KEY_T7_CHROMIUM_PROVIDER_INIT_STEP2, Long.valueOf(getRecordedTime(KEY_T7_CHROMIUM_PROVIDER_INIT_STEP2)));
            jSONObject.putOpt(KEY_T7_CHROMIUM_PROVIDER_INIT_STEP3, Long.valueOf(getRecordedTime(KEY_T7_CHROMIUM_PROVIDER_INIT_STEP3)));
            jSONObject.putOpt(KEY_ZEUS_WEBVIEW_LOAD_CLASS, Long.valueOf(zeusWebViewLoadClassTime()));
            jSONObject.putOpt(KEY_UNZIP, Long.valueOf(getRecordedTime(KEY_UNZIP)));
            jSONObject.putOpt(KEY_UNZIP_START_DIFF, Long.valueOf(unzipStartDiff()));
            jSONObject.putOpt(KEY_UNZIP_END_DIFF, Long.valueOf(unzipEndDiff()));
            jSONObject.putOpt(KEY_IS_PROCESS_MAIN, Boolean.valueOf(WebKitFactory.getNeedDownloadCloudResource()));
            jSONObject.putOpt(KEY_GET_PROVIDER_THREAD_TIME, Long.valueOf(getRecordedThreadTime(KEY_GET_PROVIDER)));
            jSONObject.putOpt(KEY_CHECK_USE_T7_THREAD, Long.valueOf(getRecordedThreadTime(KEY_CHECK_USE_T7)));
            jSONObject.putOpt(KEY_FETCH_PACKAGE_INFO_THREAD, Long.valueOf(getRecordedThreadTime(KEY_FETCH_PACKAGE_INFO)));
            jSONObject.putOpt(KEY_NEW_ZEUS_CL_THREAD, Long.valueOf(getRecordedThreadTime(KEY_NEW_ZEUS_CL)));
            jSONObject.putOpt(KEY_T7_CHROMIUM_PROVIDER_INIT_THREAD, Long.valueOf(getRecordedThreadTime(KEY_T7_CHROMIUM_PROVIDER_INIT)));
            jSONObject.putOpt(KEY_T7_CHROMIUM_PROVIDER_INIT_THREAD_STEP0, Long.valueOf(getRecordedThreadTime(KEY_T7_CHROMIUM_PROVIDER_INIT_STEP0)));
            jSONObject.putOpt(KEY_T7_CHROMIUM_PROVIDER_INIT_THREAD_STEP1, Long.valueOf(getRecordedThreadTime(KEY_T7_CHROMIUM_PROVIDER_INIT_STEP1)));
            jSONObject.putOpt(KEY_T7_CHROMIUM_PROVIDER_INIT_THREAD_STEP2, Long.valueOf(getRecordedThreadTime(KEY_T7_CHROMIUM_PROVIDER_INIT_STEP2)));
            jSONObject.putOpt(KEY_T7_CHROMIUM_PROVIDER_INIT_THREAD_STEP3, Long.valueOf(getRecordedThreadTime(KEY_T7_CHROMIUM_PROVIDER_INIT_STEP3)));
            jSONObject.putOpt(KEY_UNZIP_THREAD, Long.valueOf(getRecordedThreadTime(KEY_UNZIP)));
            if (CommonUtils.getSysMemoryInfo() != null) {
                jSONObject.putOpt(KEY_MEMORY, CommonUtils.getSysMemoryInfo().get("MemTotal:"));
            }
            HashMap<String, Long> currentSystemInfraInfo = WebView.getCurrentSystemInfraInfo();
            if (currentSystemInfraInfo != null) {
                Log.d("getZeusPerformanceTiming", " getCurrentSystemInfraInfo");
                jSONObject.putOpt(KEY_NUM_PROCESSORS, currentSystemInfraInfo.get(KEY_NUM_PROCESSORS));
                jSONObject.putOpt(KEY_MAX_CPU_FREQ, currentSystemInfraInfo.get(KEY_MAX_CPU_FREQ));
                jSONObject.putOpt(KEY_AMOUNT_PHYSICAL_MEMORY, currentSystemInfraInfo.get(KEY_AMOUNT_PHYSICAL_MEMORY));
                jSONObject.putOpt(KEY_DALVIK_HEAP_SIZE, currentSystemInfraInfo.get(KEY_DALVIK_HEAP_SIZE));
                jSONObject.putOpt(KEY_BUILD_DATE_UTC, currentSystemInfraInfo.get(KEY_BUILD_DATE_UTC));
            }
            jSONObject.putOpt(KEY_APP_NEW_WEBVIEW, SessionMonitorEngine.getInstance().getWebViewTimeStamp());
            if (initProviderInMainThread()) {
                jSONObject.putOpt(KEY_PROVIDER_MTHREAD_STACK, initProviderMainThreadStack());
            }
            jSONObject.putOpt(KEY_FORCE_INIT_ZEUS, Boolean.valueOf(isforceInitT7()));
            jSONObject.putOpt(KEY_NEW_SYS_WEBVIEW, Long.valueOf(getRecordedTime(KEY_NEW_SYS_WEBVIEW)));
            jSONObject.putOpt(KEY_INIT_SYS_WEBKIT, Long.valueOf(getRecordedTime(KEY_INIT_SYS_WEBKIT)));
            jSONObject.putOpt(KEY_WEBVIEWCHROMIUM_CONSTRUCT, Long.valueOf(getRecordedTime(KEY_WEBVIEWCHROMIUM_CONSTRUCT)));
            jSONObject.putOpt(KEY_BROWSER_STARTUP, Long.valueOf(getRecordedTime(KEY_BROWSER_STARTUP)));
            jSONObject.putOpt("p2", Long.valueOf(getRecordedTime("p2")));
            jSONObject.putOpt(KEY_WEBVIEW_ZWSETTINGS_CREATED, Long.valueOf(getRecordedTime(KEY_WEBVIEW_ZWSETTINGS_CREATED)));
            jSONObject.putOpt(KEY_WEBVIEWCHROMIUM_INIT_FOR_REAL, Long.valueOf(getRecordedTime(KEY_WEBVIEWCHROMIUM_INIT_FOR_REAL)));
            jSONObject.putOpt(KEY_WEBVIEW_DEFAULT_SETTINGS, Long.valueOf(getRecordedTime(KEY_WEBVIEW_DEFAULT_SETTINGS)));
            jSONObject.putOpt(KEY_WEBVIEW_WAITING_RESOURCE, Long.valueOf(getRecordedTime(KEY_WEBVIEW_WAITING_RESOURCE)));
            jSONObject.putOpt(KEY_WEBVIEWCHROMIUM_INIT, Long.valueOf(getRecordedTime(KEY_WEBVIEWCHROMIUM_INIT)));
            jSONObject.putOpt(KEY_WEBVIEW_PROVIDER_INIT, Long.valueOf(getRecordedTime(KEY_WEBVIEW_PROVIDER_INIT)));
            jSONObject.putOpt(KEY_WEBVIEWCHROMIUM_CONSTRUCT_THREAD, Long.valueOf(getRecordedThreadTime(KEY_WEBVIEWCHROMIUM_CONSTRUCT)));
            jSONObject.putOpt(KEY_BROWSER_STARTUP_THREAD, Long.valueOf(getRecordedThreadTime(KEY_BROWSER_STARTUP)));
            jSONObject.putOpt(KEY_WEBVIEW_CONTENT_CLIENT_ADAPTER_CREATED_THREAD, Long.valueOf(getRecordedThreadTime("p2")));
            jSONObject.putOpt(KEY_WEBVIEW_ZWSETTINGS_CREATED_THREAD, Long.valueOf(getRecordedThreadTime(KEY_WEBVIEW_ZWSETTINGS_CREATED)));
            jSONObject.putOpt(KEY_WEBVIEWCHROMIUM_INIT_FOR_REAL_THREAD, Long.valueOf(getRecordedThreadTime(KEY_WEBVIEWCHROMIUM_INIT_FOR_REAL)));
            jSONObject.putOpt(KEY_WEBVIEW_DEFAULT_SETTINGS_THREAD, Long.valueOf(getRecordedThreadTime(KEY_WEBVIEW_DEFAULT_SETTINGS)));
            jSONObject.putOpt(KEY_WEBVIEWCHROMIUM_INIT_THREAD, Long.valueOf(getRecordedThreadTime(KEY_WEBVIEWCHROMIUM_INIT)));
            jSONObject.putOpt(KEY_WEBVIEW_PROVIDER_INIT_THREAD, Long.valueOf(getRecordedThreadTime(KEY_WEBVIEW_PROVIDER_INIT)));
            jSONObject.putOpt(KEY_IS_GET_PROVIDER_HIT_SYNCHRONIZED, Boolean.valueOf(isGetProviderHitSynchronized()));
            jSONObject.putOpt(KEY_INIT_WEBKIT_START_TIMESTAMP, Long.valueOf(getTimeStampFromMap(sStartTimeStamps, KEY_INIT_WEBKIT)));
            jSONObject.putOpt(KEY_INIT_WEBVIEW_START_TIMESTAMP, Long.valueOf(getTimeStampFromMap(sStartTimeStamps, KEY_NEW_WEBVIEW_METHOD)));
            jSONObject.putOpt(KEY_WEBKIT_WEBVIEW_START_DIFF, Long.valueOf(getTimeStampFromMap(sStartTimeStamps, KEY_NEW_WEBVIEW_METHOD) - getTimeStampFromMap(sStartTimeStamps, KEY_INIT_WEBKIT)));
            jSONObject.putOpt(KEY_INIT_WEBVIEW_THREAD_START_TIMESTAMP, Long.valueOf(getTimeStampFromMap(sStartThreadTimeStamps, KEY_NEW_WEBVIEW_METHOD)));
            if (mProviderHitSynchronizedStack != null) {
                jSONObject.putOpt(KEY_PROVIDER_HIT_SYNCHRONIZED_STACK, mProviderHitSynchronizedStack);
            }
            jSONObject.putOpt(KEY_APP_START_SOURCE, sAppStartSource);
            jSONObject.putOpt(KEY_WEBKIT_INIT_STATISTICS, mWebkitInitStatistics);
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

    public static boolean initProviderInMainThread() {
        return mIsMainThread;
    }

    public static String initProviderMainThreadStack() {
        return mMainThreadStack != null ? mMainThreadStack : "";
    }

    public static long initWebkitStartTime() {
        return getTimeStampFromMap(sStartTimeStamps, KEY_INIT_WEBKIT);
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

    public static long newWebViewThreadTime() {
        return getRecordedThreadTime(KEY_WEBVIEWCHROMIUM_CONSTRUCT) + getRecordedThreadTime(KEY_BROWSER_STARTUP) + getRecordedThreadTime("p2") + getRecordedThreadTime(KEY_WEBVIEW_ZWSETTINGS_CREATED) + getRecordedThreadTime(KEY_WEBVIEWCHROMIUM_INIT_FOR_REAL) + getRecordedThreadTime(KEY_WEBVIEW_DEFAULT_SETTINGS);
    }

    public static long newWebViewTime() {
        return getRecordedTime(KEY_WEBVIEWCHROMIUM_CONSTRUCT) + getRecordedTime(KEY_BROWSER_STARTUP) + getRecordedTime("p2") + getRecordedTime(KEY_WEBVIEW_ZWSETTINGS_CREATED) + getRecordedTime(KEY_WEBVIEWCHROMIUM_INIT_FOR_REAL) + getRecordedTime(KEY_WEBVIEW_DEFAULT_SETTINGS);
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00d2, code lost:
        if (r7.equals(com.baidu.webkit.sdk.performance.ZeusPerformanceTiming.KEY_NEW_WEBVIEW_METHOD) != false) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void record(Stage stage, String str) {
        char c = 65535;
        boolean z = false;
        if (str == null) {
            return;
        }
        if (Stage.Start != stage) {
            if (Stage.End == stage) {
                if (!sEndTimeStamps.containsKey(str)) {
                    sEndTimeStamps.put(str, Long.valueOf(System.currentTimeMillis()));
                    switch (str.hashCode()) {
                        case -2077939610:
                            break;
                        default:
                            z = true;
                            break;
                    }
                    switch (z) {
                        case false:
                            sWebViewInitTimingList.add(Long.valueOf(System.currentTimeMillis() - sWebViewInitTiming));
                            break;
                    }
                }
                if (sEndThreadTimeStamps.containsKey(str)) {
                    return;
                }
                sEndThreadTimeStamps.put(str, Long.valueOf(SystemClock.currentThreadTimeMillis()));
                return;
            }
            return;
        }
        if (!sStartTimeStamps.containsKey(str)) {
            sStartTimeStamps.put(str, Long.valueOf(System.currentTimeMillis()));
            switch (str.hashCode()) {
                case -2077939610:
                    if (str.equals(KEY_NEW_WEBVIEW_METHOD)) {
                        c = 1;
                        break;
                    }
                    break;
                case 1384417466:
                    if (str.equals(KEY_GET_PROVIDER)) {
                        c = 0;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    boolean z2 = Looper.getMainLooper() == Looper.myLooper();
                    mIsMainThread = z2;
                    if (z2) {
                        mMainThreadStack = android.util.Log.getStackTraceString(new NullPointerException());
                        android.util.Log.i(GlobalConstants.LOG_PER_TAG, "initWebkit on MainThread  : " + mMainThreadStack);
                        break;
                    }
                    break;
                case 1:
                    sWebViewInitTiming = System.currentTimeMillis();
                    break;
            }
        }
        if (sStartThreadTimeStamps.containsKey(str)) {
            return;
        }
        sStartThreadTimeStamps.put(str, Long.valueOf(SystemClock.currentThreadTimeMillis()));
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

    public static void setAppStartSource(String str) {
        if (sAppStartSource == null) {
            sAppStartSource = str;
        }
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

    public static void sumLoadClassTime(long j) {
        if (getTimeStampFromMap(sStartTimeStamps, KEY_NEW_WEBVIEW_METHOD) <= 0 || getTimeStampFromMap(sEndTimeStamps, KEY_NEW_WEBVIEW_METHOD) != 0) {
            return;
        }
        mZeusWebViewLoadClassTime += (int) j;
    }

    public static long unzipEndDiff() {
        return getTimeStampFromMap(sEndTimeStamps, KEY_UNZIP) - getTimeStampFromMap(sEndTimeStamps, KEY_NEW_ZEUS_CL);
    }

    public static long unzipStartDiff() {
        return getTimeStampFromMap(sStartTimeStamps, KEY_NEW_ZEUS_CL) - getTimeStampFromMap(sStartTimeStamps, KEY_UNZIP);
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
