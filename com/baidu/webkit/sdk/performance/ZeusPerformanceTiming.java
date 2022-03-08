package com.baidu.webkit.sdk.performance;

import android.os.Looper;
import android.os.SystemClock;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.daemon.ZeusThreadPoolUtil;
import com.baidu.webkit.internal.monitor.SessionMonitorEngine;
import com.baidu.webkit.internal.utils.CommonUtils;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
import com.baidu.webkit.sdk.WebView;
import com.baidu.webkit.sdk.ZeusClassLoader;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ZeusPerformanceTiming {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CONFIG_FILE = "startup_timing_log";
    public static final String KEY_AMOUNT_FREE_DISK_SPACE = "AmountFreeDiskSpace";
    public static final String KEY_AMOUNT_PHYSICAL_MEMORY = "AmountPhysicalMemory";
    public static final String KEY_APP_NEW_WEBVIEW = "app_new_webview";
    public static final String KEY_APP_START_SOURCE = "app_start_source";
    public static final String KEY_BROWSER_STARTUP = "p1";
    public static final String KEY_BROWSER_STARTUP_THREAD = "p1_thread";
    public static final String KEY_BUILD_DATE_UTC = "BuildDateUTC";
    public static final String KEY_CHECK_USE_T7 = "k_p0";
    public static final String KEY_CHECK_USE_T7_THREAD = "k_p0_thread";
    public static final String KEY_CUR_CPU_FREQ = "CurCpuFreq";
    public static final String KEY_DALVIK_HEAP_SIZE = "DalvikHeapSize";
    public static final String KEY_FETCH_PACKAGE_INFO = "k_p1";
    public static final String KEY_FETCH_PACKAGE_INFO_THREAD = "k_p1_thread";
    public static final String KEY_FORCE_INIT_ZEUS = "force_init_zeus";
    public static final String KEY_GET_PROVIDER = "get_provider";
    public static final String KEY_GET_PROVIDER_THREAD = "get_provider_thread";
    public static final String KEY_GET_PROVIDER_THREAD_TIME = "get_provider_thread_time";
    public static final String KEY_INIT_START = "init_start";
    public static final String KEY_INIT_SYS_WEBKIT = "init_sys_webkit";
    public static final String KEY_INIT_WEBKIT = "init_webkit";
    public static final String KEY_INIT_WEBKIT_START_TIMESTAMP = "init_webkit_start_timestamp";
    public static final String KEY_INIT_WEBKIT_THREAD = "init_webkit_thread";
    public static final String KEY_INIT_WEBVIEW_START_TIMESTAMP = "init_webview_start_timestamp";
    public static final String KEY_INIT_WEBVIEW_THREAD_START_TIMESTAMP = "init_webview_thread_start_timestamp";
    public static final String KEY_IS_GET_PROVIDER_HIT_SYNCHRONIZED = "is_get_provider_hit_synchronized";
    public static final String KEY_IS_PROCESS_MAIN = "is_process_main";
    public static final String KEY_MAX_CPU_FREQ = "MaxCpuFreq";
    public static final String KEY_MEMORY = "memory";
    public static final String KEY_MIN_CPU_FREQ = "MinCpuFreq";
    public static final String KEY_NEW_SYS_WEBVIEW = "new_sys_webview";
    public static final String KEY_NEW_WEBVIEW = "new_webview";
    public static final String KEY_NEW_WEBVIEW_METHOD = "new_webview_method";
    public static final String KEY_NEW_WEBVIEW_METHOD_THREAD = "new_webview_method_thread";
    public static final String KEY_NEW_WEBVIEW_THREAD = "new_webview_thread";
    public static final String KEY_NEW_ZEUS_CL = "k_p2";
    public static final String KEY_NEW_ZEUS_CL_THREAD = "k_p2_thread";
    public static final String KEY_NUM_PROCESSORS = "NumProcessors";
    public static final String KEY_PROVIDER_HIT_SYNCHRONIZED_STACK = "provider_hit_synchronized_stack";
    public static final String KEY_PROVIDER_MTHREAD_STACK = "provider_mthread_stack";
    public static final String KEY_REVERT_DOWNLOAD_ZEUS = "revert_download_zeus";
    public static final String KEY_T7_CHROMIUM_PROVIDER_INIT = "k_p3";
    public static final String KEY_T7_CHROMIUM_PROVIDER_INIT_STEP0 = "k_p3_s0";
    public static final String KEY_T7_CHROMIUM_PROVIDER_INIT_STEP1 = "k_p3_s1";
    public static final String KEY_T7_CHROMIUM_PROVIDER_INIT_STEP2 = "k_p3_s2";
    public static final String KEY_T7_CHROMIUM_PROVIDER_INIT_STEP3 = "k_p3_s3";
    public static final String KEY_T7_CHROMIUM_PROVIDER_INIT_THREAD = "k_p3_thread";
    public static final String KEY_T7_CHROMIUM_PROVIDER_INIT_THREAD_STEP0 = "k_p3_s0_thread";
    public static final String KEY_T7_CHROMIUM_PROVIDER_INIT_THREAD_STEP1 = "k_p3_s1_thread";
    public static final String KEY_T7_CHROMIUM_PROVIDER_INIT_THREAD_STEP2 = "k_p3_s2_thread";
    public static final String KEY_T7_CHROMIUM_PROVIDER_INIT_THREAD_STEP3 = "k_p3_s3_thread";
    public static final String KEY_TYPE = "type";
    public static final String KEY_UNZIP = "unzip";
    public static final String KEY_UNZIP_END_DIFF = "unzip_end_diff";
    public static final String KEY_UNZIP_START_DIFF = "unzip_start_diff";
    public static final String KEY_UNZIP_THREAD = "unzip_thread";
    public static final String KEY_WEBKIT_INIT_STATISTICS = "webkit_init_statistics";
    public static final String KEY_WEBKIT_WEBVIEW_START_DIFF = "init_webkit_webview_start_diff";
    public static final String KEY_WEBVIEWCHROMIUM_CONSTRUCT = "p0";
    public static final String KEY_WEBVIEWCHROMIUM_CONSTRUCT_THREAD = "p0_thread";
    public static final String KEY_WEBVIEWCHROMIUM_INIT = "webviewchromium_init";
    public static final String KEY_WEBVIEWCHROMIUM_INIT_FOR_REAL = "p4";
    public static final String KEY_WEBVIEWCHROMIUM_INIT_FOR_REAL_THREAD = "p4_thread";
    public static final String KEY_WEBVIEWCHROMIUM_INIT_THREAD = "webviewchromium_init_thread";
    public static final String KEY_WEBVIEW_CONTENT_CLIENT_ADAPTER_CREATED = "p2";
    public static final String KEY_WEBVIEW_CONTENT_CLIENT_ADAPTER_CREATED_THREAD = "p2_thread";
    public static final String KEY_WEBVIEW_DEFAULT_SETTINGS = "p5";
    public static final String KEY_WEBVIEW_DEFAULT_SETTINGS_THREAD = "p5_thread";
    public static final String KEY_WEBVIEW_PROVIDER_INIT = "webview_provider_init";
    public static final String KEY_WEBVIEW_PROVIDER_INIT_THREAD = "webview_provider_init_thread";
    public static final String KEY_WEBVIEW_WAITING_RESOURCE = "webview_waiting_resource";
    public static final String KEY_WEBVIEW_ZWSETTINGS_CREATED = "p3";
    public static final String KEY_WEBVIEW_ZWSETTINGS_CREATED_THREAD = "p3_thread";
    public static final String KEY_ZEUS_WEBVIEW_LOAD_CLASS = "zeus_webview_load_class";
    public static final int RECORD_FROM_FORCE_INIT = 2;
    public static final int RECORD_FROM_WEBVIEW_INIT = 1;
    public static final String SERVER_TYPE_T7_INIT = "t7_init";
    public static final String UMA_METRIC_PREFIX = "Session.Startup.";
    public static long mInitOnAppStart;
    public static boolean mIsForceInitT7;
    public static boolean mIsGetProviderHitSynchronized;
    public static boolean mIsMainThread;
    public static String mMainThreadStack;
    public static String mProviderHitSynchronizedStack;
    public static JSONObject mWebkitInitStatistics;
    public static String mZeusDownFailDetail;
    public static JSONArray mZeusDownloadInfo;
    public static int mZeusWebViewLoadClassTime;
    public static String sAppStartSource;
    public static ConcurrentHashMap<String, Long> sEndThreadTimeStamps;
    public static ConcurrentHashMap<String, Long> sEndTimeStamps;
    public static ArrayList<String> sExcludedKeysStartup;
    public static boolean sLogEnabled;
    public static int sRecordType;
    public static ConcurrentHashMap<String, Long> sStartThreadTimeStamps;
    public static ConcurrentHashMap<String, Long> sStartTimeStamps;
    public static boolean sUploaded;
    public static long sWebViewInitTiming;
    public static List<Long> sWebViewInitTimingList;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static final class Stage {
        public static final /* synthetic */ Stage[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Stage End;
        public static final Stage Start;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(107585667, "Lcom/baidu/webkit/sdk/performance/ZeusPerformanceTiming$Stage;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(107585667, "Lcom/baidu/webkit/sdk/performance/ZeusPerformanceTiming$Stage;");
                    return;
                }
            }
            Start = new Stage("Start", 0);
            Stage stage = new Stage("End", 1);
            End = stage;
            $VALUES = new Stage[]{Start, stage};
        }

        public Stage(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static Stage valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Stage) Enum.valueOf(Stage.class, str) : (Stage) invokeL.objValue;
        }

        public static Stage[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Stage[]) $VALUES.clone() : (Stage[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-778167299, "Lcom/baidu/webkit/sdk/performance/ZeusPerformanceTiming;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-778167299, "Lcom/baidu/webkit/sdk/performance/ZeusPerformanceTiming;");
                return;
            }
        }
        sWebViewInitTimingList = new ArrayList();
        sStartTimeStamps = new ConcurrentHashMap<>();
        sEndTimeStamps = new ConcurrentHashMap<>();
        sStartThreadTimeStamps = new ConcurrentHashMap<>();
        sEndThreadTimeStamps = new ConcurrentHashMap<>();
    }

    public ZeusPerformanceTiming() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void forceInitT7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            mIsForceInitT7 = true;
        }
    }

    public static boolean getBooleanFromFile() {
        InterceptResult invokeV;
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (WebKitFactory.getContext() == null) {
                return false;
            }
            try {
                sb = new StringBuilder();
                sb.append(WebKitFactory.getContext().getExternalFilesDir("").getAbsolutePath());
                sb.append("/startup_timing_log");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return new File(sb.toString()).exists();
        }
        return invokeV.booleanValue;
    }

    public static long getCurrentThreadTimeMillis(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65542, null, j2)) == null) ? j2 == 0 ? SystemClock.currentThreadTimeMillis() : j2 : invokeJ.longValue;
    }

    public static long getCurrentTimeMillis(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65543, null, j2)) == null) ? j2 == 0 ? System.currentTimeMillis() : j2 : invokeJ.longValue;
    }

    public static long getRecordedThreadTime(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            if (sStartThreadTimeStamps.containsKey(str) && sEndThreadTimeStamps.containsKey(str)) {
                long longValue = sEndThreadTimeStamps.get(str).longValue();
                long longValue2 = sStartThreadTimeStamps.get(str).longValue();
                if (longValue > longValue2) {
                    return longValue - longValue2;
                }
                return 0L;
            }
            return 0L;
        }
        return invokeL.longValue;
    }

    public static long getRecordedTime(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            if (sStartTimeStamps.containsKey(str) && sEndTimeStamps.containsKey(str)) {
                long longValue = sEndTimeStamps.get(str).longValue();
                long longValue2 = sStartTimeStamps.get(str).longValue();
                if (longValue > longValue2) {
                    return longValue - longValue2;
                }
                return 0L;
            }
            return 0L;
        }
        return invokeL.longValue;
    }

    public static String getSysInitTiming() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            StringBuilder sb = new StringBuilder();
            if (sStartTimeStamps.containsKey(KEY_INIT_SYS_WEBKIT) && sEndTimeStamps.containsKey(KEY_INIT_SYS_WEBKIT)) {
                sb.append("initSysWebkit = ");
                sb.append(String.valueOf(getRecordedTime(KEY_INIT_SYS_WEBKIT)));
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public static long getTimeStampFromMap(Map<String, Long> map, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, map, str)) == null) {
            if (map == null || str == null || !map.containsKey(str)) {
                return 0L;
            }
            return map.get(str).longValue();
        }
        return invokeLL.longValue;
    }

    public static String getWebViewInitTiming() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
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
        return (String) invokeV.objValue;
    }

    public static List<Long> getWebViewInitTimings() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? sWebViewInitTimingList : (List) invokeV.objValue;
    }

    public static String getZeusInitTiming() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            StringBuilder sb = new StringBuilder();
            if (sStartTimeStamps.containsKey(KEY_INIT_WEBKIT) && sEndTimeStamps.containsKey(KEY_INIT_WEBKIT)) {
                sb.append("initWebkit = ");
                sb.append(getRecordedTime(KEY_INIT_WEBKIT));
                long longValue = sStartTimeStamps.get(KEY_INIT_WEBKIT).longValue();
                makeTimingFormat(sb, "shouldUseSystemWebView   ", getTimeStampFromMap(sStartTimeStamps, KEY_CHECK_USE_T7), getTimeStampFromMap(sEndTimeStamps, KEY_CHECK_USE_T7), longValue);
                makeTimingFormat(sb, "fetchDefaultPackageInfo   ", getTimeStampFromMap(sStartTimeStamps, KEY_FETCH_PACKAGE_INFO), getTimeStampFromMap(sEndTimeStamps, KEY_FETCH_PACKAGE_INFO), longValue);
                makeTimingFormat(sb, ZeusClassLoader.TAG, getTimeStampFromMap(sStartTimeStamps, KEY_NEW_ZEUS_CL), getTimeStampFromMap(sEndTimeStamps, KEY_NEW_ZEUS_CL), longValue);
                makeTimingFormat(sb, "unzip          ", getTimeStampFromMap(sStartTimeStamps, KEY_UNZIP), getTimeStampFromMap(sEndTimeStamps, KEY_UNZIP), longValue);
                makeTimingFormat(sb, "newWebViewChromiumFactoryProviderInstance   ", getTimeStampFromMap(sStartTimeStamps, KEY_T7_CHROMIUM_PROVIDER_INIT), getTimeStampFromMap(sEndTimeStamps, KEY_T7_CHROMIUM_PROVIDER_INIT), longValue);
                makeTimingFormat(sb, "initProvider   ", getTimeStampFromMap(sStartTimeStamps, KEY_GET_PROVIDER), getTimeStampFromMap(sEndTimeStamps, KEY_GET_PROVIDER), longValue);
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public static String getZeusPerformanceTiming() {
        InterceptResult invokeV;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            if (sExcludedKeysStartup == null) {
                str = KEY_T7_CHROMIUM_PROVIDER_INIT_STEP3;
                ArrayList<String> arrayList = new ArrayList<>();
                sExcludedKeysStartup = arrayList;
                str2 = KEY_T7_CHROMIUM_PROVIDER_INIT_STEP2;
                arrayList.add("type");
                sExcludedKeysStartup.add(KEY_GET_PROVIDER_THREAD);
                sExcludedKeysStartup.add(KEY_IS_PROCESS_MAIN);
                sExcludedKeysStartup.add("memory");
                sExcludedKeysStartup.add(KEY_NUM_PROCESSORS);
                sExcludedKeysStartup.add(KEY_MAX_CPU_FREQ);
                sExcludedKeysStartup.add(KEY_AMOUNT_PHYSICAL_MEMORY);
                sExcludedKeysStartup.add(KEY_DALVIK_HEAP_SIZE);
                sExcludedKeysStartup.add(KEY_BUILD_DATE_UTC);
                sExcludedKeysStartup.add(KEY_APP_NEW_WEBVIEW);
                sExcludedKeysStartup.add(KEY_PROVIDER_MTHREAD_STACK);
                sExcludedKeysStartup.add(KEY_FORCE_INIT_ZEUS);
                sExcludedKeysStartup.add(KEY_IS_GET_PROVIDER_HIT_SYNCHRONIZED);
                sExcludedKeysStartup.add(KEY_PROVIDER_HIT_SYNCHRONIZED_STACK);
                sExcludedKeysStartup.add(KEY_APP_START_SOURCE);
                sExcludedKeysStartup.add(KEY_WEBKIT_INIT_STATISTICS);
            } else {
                str = KEY_T7_CHROMIUM_PROVIDER_INIT_STEP3;
                str2 = KEY_T7_CHROMIUM_PROVIDER_INIT_STEP2;
            }
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
                String str3 = str2;
                jSONObject.putOpt(str3, Long.valueOf(getRecordedTime(str2)));
                String str4 = str;
                jSONObject.putOpt(str4, Long.valueOf(getRecordedTime(str)));
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
                jSONObject.putOpt(KEY_T7_CHROMIUM_PROVIDER_INIT_THREAD_STEP2, Long.valueOf(getRecordedThreadTime(str3)));
                jSONObject.putOpt(KEY_T7_CHROMIUM_PROVIDER_INIT_THREAD_STEP3, Long.valueOf(getRecordedThreadTime(str4)));
                jSONObject.putOpt(KEY_UNZIP_THREAD, Long.valueOf(getRecordedThreadTime(KEY_UNZIP)));
                if (CommonUtils.getSysMemoryInfo() != null) {
                    jSONObject.putOpt("memory", CommonUtils.getSysMemoryInfo().get("MemTotal:"));
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
                jSONObject.putOpt(KEY_REVERT_DOWNLOAD_ZEUS, Long.valueOf(getRecordedTime(KEY_REVERT_DOWNLOAD_ZEUS)));
                jSONObject.putOpt(KEY_WEBKIT_INIT_STATISTICS, mWebkitInitStatistics);
                UMALogger.getInstance().record(jSONObject, sExcludedKeysStartup, UMA_METRIC_PREFIX);
                return jSONObject.toString();
            } catch (JSONException e2) {
                Log.printStackTrace(e2);
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public static void initOnAppStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, null) == null) {
            mInitOnAppStart = getCurrentTimeMillis(mInitOnAppStart);
        }
    }

    public static long initOnAppStartTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) ? mInitOnAppStart : invokeV.longValue;
    }

    public static boolean initProviderInMainThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? mIsMainThread : invokeV.booleanValue;
    }

    public static String initProviderMainThreadStack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) {
            String str = mMainThreadStack;
            return str != null ? str : "";
        }
        return (String) invokeV.objValue;
    }

    public static long initWebkitStartTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) ? getTimeStampFromMap(sStartTimeStamps, KEY_INIT_WEBKIT) : invokeV.longValue;
    }

    public static boolean isGetProviderHitSynchronized() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) ? mIsGetProviderHitSynchronized : invokeV.booleanValue;
    }

    public static boolean isforceInitT7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) ? mIsForceInitT7 : invokeV.booleanValue;
    }

    public static void makeTimingFormat(StringBuilder sb, String str, long j2, long j3, long j4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65559, null, new Object[]{sb, str, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)}) == null) || sb == null || str == null || j2 <= 0 || j3 <= 0) {
            return;
        }
        sb.append('\n');
        sb.append(str + " from init: ");
        sb.append(j3 - j4);
        sb.append(" self: ");
        sb.append(j3 - j2);
    }

    public static long newWebViewThreadTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) ? getRecordedThreadTime(KEY_WEBVIEWCHROMIUM_CONSTRUCT) + getRecordedThreadTime(KEY_BROWSER_STARTUP) + getRecordedThreadTime("p2") + getRecordedThreadTime(KEY_WEBVIEW_ZWSETTINGS_CREATED) + getRecordedThreadTime(KEY_WEBVIEWCHROMIUM_INIT_FOR_REAL) + getRecordedThreadTime(KEY_WEBVIEW_DEFAULT_SETTINGS) : invokeV.longValue;
    }

    public static long newWebViewTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) ? getRecordedTime(KEY_WEBVIEWCHROMIUM_CONSTRUCT) + getRecordedTime(KEY_BROWSER_STARTUP) + getRecordedTime("p2") + getRecordedTime(KEY_WEBVIEW_ZWSETTINGS_CREATED) + getRecordedTime(KEY_WEBVIEWCHROMIUM_INIT_FOR_REAL) + getRecordedTime(KEY_WEBVIEW_DEFAULT_SETTINGS) : invokeV.longValue;
    }

    public static void record(Stage stage, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65562, null, stage, str) == null) || str == null) {
            return;
        }
        char c2 = 65535;
        if (Stage.Start != stage) {
            if (Stage.End == stage) {
                if (!sEndTimeStamps.containsKey(str)) {
                    sEndTimeStamps.put(str, Long.valueOf(System.currentTimeMillis()));
                    if (str.hashCode() == -2077939610 && str.equals(KEY_NEW_WEBVIEW_METHOD)) {
                        c2 = 0;
                    }
                    if (c2 == 0) {
                        sWebViewInitTimingList.add(Long.valueOf(System.currentTimeMillis() - sWebViewInitTiming));
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
            int hashCode = str.hashCode();
            if (hashCode != -2077939610) {
                if (hashCode == 1384417466 && str.equals(KEY_GET_PROVIDER)) {
                    c2 = 0;
                }
            } else if (str.equals(KEY_NEW_WEBVIEW_METHOD)) {
                c2 = 1;
            }
            if (c2 == 0) {
                boolean z = Looper.getMainLooper() == Looper.myLooper();
                mIsMainThread = z;
                if (z) {
                    mMainThreadStack = android.util.Log.getStackTraceString(new NullPointerException());
                    String str2 = "initWebkit on MainThread  : " + mMainThreadStack;
                }
            } else if (c2 == 1) {
                sWebViewInitTiming = System.currentTimeMillis();
            }
        }
        if (sStartThreadTimeStamps.containsKey(str)) {
            return;
        }
        sStartThreadTimeStamps.put(str, Long.valueOf(SystemClock.currentThreadTimeMillis()));
    }

    public static void recordDownloadInitStatistics() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65563, null) == null) {
            ZeusThreadPoolUtil.executeIgnoreZeus(new Runnable() { // from class: com.baidu.webkit.sdk.performance.ZeusPerformanceTiming.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ZeusPerformanceTiming.uploadDownloadAndLazyInit();
                    }
                }
            });
        }
    }

    public static void recordWebkitInitStatistics(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65564, null, i2) == null) || sUploaded) {
            return;
        }
        sRecordType = i2 | sRecordType;
        if (!WebKitFactory.isForceInitT7() || sRecordType == 3) {
            ZeusThreadPoolUtil.executeIgnoreZeus(new Runnable() { // from class: com.baidu.webkit.sdk.performance.ZeusPerformanceTiming.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ZeusPerformanceTiming.upload();
                    }
                }
            });
            sUploaded = true;
            return;
        }
        Log.i("ZeusPerformanceTiming", "wait forceT7Init and WebView inited, sRecordType=" + sRecordType);
    }

    public static void setAppStartSource(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65565, null, str) == null) && sAppStartSource == null) {
            sAppStartSource = str;
        }
    }

    public static void setDownloadFailDetail(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65566, null, str) == null) {
            mZeusDownFailDetail = str;
        }
    }

    public static void setIsGetProviderHitSynchronized(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65567, null, z) == null) {
            mIsGetProviderHitSynchronized = z;
            if (z) {
                mProviderHitSynchronizedStack = android.util.Log.getStackTraceString(new NullPointerException());
                String str = "initWebkit hit synchronized  : " + mProviderHitSynchronizedStack;
            }
        }
    }

    public static void setZeusDownloadInfo(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65568, null, jSONArray) == null) {
            mZeusDownloadInfo = jSONArray;
        }
    }

    public static void setZeusWebkitInitStatistics(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65569, null, jSONObject) == null) {
            mWebkitInitStatistics = jSONObject;
        }
    }

    public static void sumLoadClassTime(long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(65570, null, j2) == null) && getTimeStampFromMap(sStartTimeStamps, KEY_NEW_WEBVIEW_METHOD) > 0 && getTimeStampFromMap(sEndTimeStamps, KEY_NEW_WEBVIEW_METHOD) == 0) {
            mZeusWebViewLoadClassTime += (int) j2;
        }
    }

    public static long unzipEndDiff() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65571, null)) == null) ? getTimeStampFromMap(sEndTimeStamps, KEY_UNZIP) - getTimeStampFromMap(sEndTimeStamps, KEY_NEW_ZEUS_CL) : invokeV.longValue;
    }

    public static long unzipStartDiff() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65572, null)) == null) ? getTimeStampFromMap(sStartTimeStamps, KEY_NEW_ZEUS_CL) - getTimeStampFromMap(sStartTimeStamps, KEY_UNZIP) : invokeV.longValue;
    }

    public static void upload() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65573, null) == null) {
            try {
                sLogEnabled = getBooleanFromFile();
                String zeusPerformanceTiming = getZeusPerformanceTiming();
                if (sLogEnabled) {
                    Log.i("ZeusPerformanceTiming", "upload data: ".concat(String.valueOf(zeusPerformanceTiming)));
                }
                if (zeusPerformanceTiming != null) {
                    SessionMonitorEngine.getInstance().recordImmediately(SERVER_TYPE_T7_INIT, zeusPerformanceTiming);
                }
            } catch (Exception e2) {
                Log.printStackTrace(e2);
            }
        }
    }

    public static void uploadDownloadAndLazyInit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65574, null) == null) {
            try {
                if (mZeusDownloadInfo == null || mZeusDownloadInfo.length() <= 0) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("type", 12300);
                jSONObject.put("webkit_download_and_lazy_init_statics", mZeusDownloadInfo);
                if (mZeusDownFailDetail != null && mZeusDownFailDetail.length() > 0) {
                    jSONObject.put("download_fail_detail", mZeusDownFailDetail);
                }
                String jSONObject2 = jSONObject.toString();
                Log.i("ZeusPerformanceTiming", "cr_Ime uploadDownloadAndLazyInit : ".concat(String.valueOf(jSONObject2)));
                SessionMonitorEngine.getInstance().recordImmediately(SERVER_TYPE_T7_INIT, jSONObject2);
            } catch (Exception e2) {
                Log.printStackTrace(e2);
            }
        }
    }

    public static long zeusWebViewLoadClassTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65575, null)) == null) ? mZeusWebViewLoadClassTime : invokeV.longValue;
    }
}
