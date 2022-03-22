package com.baidu.webkit.internal.blink;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.webkit.ValueCallback;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.CfgFileUtils;
import com.baidu.webkit.internal.ETAG;
import com.baidu.webkit.internal.INoProGuard;
import com.baidu.webkit.internal.daemon.HttpDnsCache;
import com.baidu.webkit.internal.daemon.QuicPreConnect;
import com.baidu.webkit.internal.daemon.ZeusThreadPoolUtil;
import com.baidu.webkit.internal.monitor.SessionMonitorEngine;
import com.baidu.webkit.net.BdNetEngine;
import com.baidu.webkit.sdk.ICronetListenerInterface;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.VideoCloudSetting;
import com.baidu.webkit.sdk.WebKitFactory;
import com.baidu.webkit.sdk.WebSettings;
import com.baidu.webkit.sdk.WebViewFactory;
import com.baidu.webkit.sdk.abtest.ABTestSDK;
import com.heytap.mcssdk.mode.CommandMessage;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
/* loaded from: classes6.dex */
public class WebSettingsGlobalBlink implements INoProGuard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CLOUD_SETTING_URL = "https://browserkernel.baidu.com/config/t5config?cmd=1&";
    public static final String DEFAULT_MULTIPROCESS_MODELS = "TRT-AL00A,TRT-AL00,TRT-TL10A,TRT-TL10,SLA-AL00,SLA-TL10,DLI-AL10,DLI-TL20,SM-C5000";
    public static final String DEFAULT_SECRECT_KEY = "SFIyRVI=";
    public static final String ENGINE_STAT_URL = "https://browserkernel.baidu.com/timing_txt/browser7_7.searchbox8_3.js.encrypt";
    public static final String FAKE_BAIDU_URL = "https://browserkernel.baidu.com/fakebaidu";
    public static final String HTTP_DNS_URL_HOST = "https://httpsdns.baidu.com/v6/0010";
    public static final String HTTP_DNS_URL_IP = "https://180.76.76.112/v6/0010";
    public static final String KEY_GUM_WHITE_LIST = "gum_white_list";
    public static final String LOGTAG = "WebSettingsGlobalBlink";
    public static int MAX_RENDER_CRASH_COUNT = 0;
    public static final String MF_JS_URL = "https://browserkernel.baidu.com/adblock/magicfilter.js?";
    public static final String ML_MODEL_URL = "https://browserkernel.baidu.com/ml_model/";
    public static final int MP_MIN_AVAILABLE_MEMORY = 500;
    public static final int MP_SDK_MAX = 29;
    public static final int MP_SDK_MIN = 21;
    public static final int MP_SDK_PUBLISH_MAX = 29;
    public static final int MP_SDK_PUBLISH_MIN = 26;
    public static final String PAC_URL = "https://browserkernel.baidu.com/newpac31/spdy.conf.txt";
    public static String PREF_KEY_MULTIPROCESS_DISABLED = null;
    public static String PREF_KEY_RENDER_CRASHES = null;
    public static String PREF_NAME_MULTIPROCESS = null;
    public static long RENDER_CRASH_LOG_TIMEOUT = 0;
    public static final String SAILOR_URL_SAFE_CHECK_CLOUD_SWITCH = "searchbox_urlsafe_switch_pr";
    public static final int SAILOR_URL_SAFE_CHECK_CLOUD_SWITCH_CLOSE = 0;
    public static final int SAILOR_URL_SAFE_CHECK_CLOUD_SWITCH_OPEN = 1;
    public static final String SESSION_UPLOAD_URL = "https://browserkernel.baidu.com/kw?r_en=true&type=";
    public static final String SETTING_IMPL_CLASS = "com.baidu.blink.WebSettingsGlobalProxy";
    public static String SFSWITCH = null;
    public static String SFSWITCH_VALUE_OPEN = null;
    public static final String SKELENTON_JS_URL = "https://browserkernel.baidu.com/skeleton/collect_link.js?";
    public static final String ZEUS_RESOURCE_URL = "https://browserkernel.baidu.com/integration.php";
    public static int httpDnsSource = 0;
    public static String mBrowserVersion = null;
    public static boolean mChromiumNetInit = false;
    public static String mCloudSettings = null;
    public static Map<String, String> mCloudSettingsMap = null;
    public static boolean mCronetEnable = false;
    public static final String mDateFomat = "yyyy-MM-dd HH:mm:ss";
    public static boolean mDoubleLogEnabled;
    public static HashSet<String> mFCCheatBlackList;
    public static boolean mFirstGetLogEnable;
    public static HashMap<String, Boolean> mGetUserMediaConfirmed;
    public static boolean mHijackEnv;
    public static Map<String, String> mHttpDnsCacheMap;
    public static boolean mHttpDnsNetChangedAfterPause;
    public static long mHttpDnsUpdateTime;
    public static boolean mHttpDnsUpdated;
    public static boolean mIpv6HttpdnsEnv;
    public static boolean mIsAlive;
    public static boolean mLogEnable;
    public static boolean mLogsdkEnabled;
    public static WebSettings.ProxyType mProxyType;
    public static long mQuicCheckTime;
    public static boolean mQuicDefaultOpen;
    public static boolean mQuicInit;
    public static Object mSelfLock;
    public static boolean mSessionDataEnable;
    public static long mSoHandler;
    public static long mTotalMem;
    public static boolean mUseLogSdk;
    public static boolean mUseT5Log;
    public static Map<String, JSONArray> mWhiteAndBlackList;
    public static HashSet<String> sBlackListModels;
    public static HashSet<String> sDeviceSet;
    public static boolean sDitingMaxHit;
    public static JSONObject sMf30InitInfo;
    public static Boolean sMultiprocessEnabled;
    public static long sNativeV8FunctionTablePointer;
    public static final List<ValueCallback<Long>> sOnCronetThreadInitializedListenerList;
    public static int zeusNetLogLevel;
    public static boolean zeusNetLogLevelSetted;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(122754259, "Lcom/baidu/webkit/internal/blink/WebSettingsGlobalBlink;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(122754259, "Lcom/baidu/webkit/internal/blink/WebSettingsGlobalBlink;");
                return;
            }
        }
        mCloudSettingsMap = new HashMap();
        mHttpDnsCacheMap = new HashMap();
        mGetUserMediaConfirmed = new HashMap<>();
        mWhiteAndBlackList = new HashMap();
        mFCCheatBlackList = new HashSet<>();
        sOnCronetThreadInitializedListenerList = new ArrayList();
        mProxyType = WebSettings.ProxyType.SPDYANDOVERSEAS_PROXY;
        mCronetEnable = true;
        mIsAlive = true;
        mSelfLock = new Object();
        mTotalMem = 2048L;
        SFSWITCH = VideoCloudSetting.PREF_KEY_SPRING_FESTIVAL_SWITCH;
        SFSWITCH_VALUE_OPEN = "true";
        PREF_NAME_MULTIPROCESS = "zeus_preferences_multiprocess";
        PREF_KEY_RENDER_CRASHES = "zeus_render_crashes";
        PREF_KEY_MULTIPROCESS_DISABLED = "zeus_multiprocess_disabled";
        RENDER_CRASH_LOG_TIMEOUT = 3600000L;
        MAX_RENDER_CRASH_COUNT = 3;
    }

    public WebSettingsGlobalBlink() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String GetCloudSettingsValue(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            synchronized (mSelfLock) {
                str2 = mCloudSettingsMap.get(str);
            }
            return str2;
        }
        return (String) invokeL.objValue;
    }

    public static boolean GetHttpDnsCache(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void addOnCronetThreadInitializedListener(ValueCallback<Long> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, valueCallback) == null) {
            Log.i(LOGTAG, "addOnCronetThreadInitializedListener. listener=%s, list size=%d", valueCallback, Integer.valueOf(sOnCronetThreadInitializedListenerList.size()));
            synchronized (sOnCronetThreadInitializedListenerList) {
                if (sNativeV8FunctionTablePointer != 0) {
                    valueCallback.onReceiveValue(Long.valueOf(sNativeV8FunctionTablePointer));
                } else {
                    sOnCronetThreadInitializedListenerList.add(valueCallback);
                }
            }
        }
    }

    public static void addPreConnectPrefixes(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, str) == null) {
            try {
                Log.w(LOGTAG, "addPreConnectPrefixes ".concat(String.valueOf(str)));
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().getSettingsStatics().addPreConnectPrefixes(str);
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static boolean canUseFreeFlow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            Log.w(LOGTAG, "canUseFreeFlow called");
            try {
                if (WebViewFactory.hasProvider()) {
                    return WebViewFactory.getProvider().getSettingsStatics().canUseFreeFlow();
                }
                return false;
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return false;
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static void checkHttpDnsUpdate() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65548, null) == null) && WebKitFactory.getNeedDownloadCloudResource() && getHttpDnsUpdateEnabled()) {
            int i = 3600;
            String GetCloudSettingsValue = GetCloudSettingsValue("httpdns_check_interval");
            if (GetCloudSettingsValue != null && !GetCloudSettingsValue.isEmpty()) {
                try {
                    i = Integer.parseInt(GetCloudSettingsValue);
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                }
            }
            Log.i(LOGTAG, "defaultHttpDnsInterval ".concat(String.valueOf(i)));
            if (System.currentTimeMillis() - mHttpDnsUpdateTime > i * 1000) {
                mHttpDnsUpdateTime = System.currentTimeMillis();
                HttpDnsCache.tryToUpdateHttpDnsCacheStaticIP(WebViewFactory.getContext());
            }
        }
    }

    public static void checkQuicConnection() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, null) == null) {
            try {
                if (!WebViewFactory.hasProvider() || !mQuicDefaultOpen || mQuicInit || System.currentTimeMillis() - mQuicCheckTime <= 10000) {
                    return;
                }
                Log.w(LOGTAG, "checkQuicConnection1 ");
                boolean quicInit = WebViewFactory.getProvider().getSettingsStatics().getQuicInit();
                mQuicInit = quicInit;
                if (quicInit) {
                    return;
                }
                Log.w(LOGTAG, "checkQuicConnection2 ");
                mQuicCheckTime = System.currentTimeMillis();
                QuicPreConnect.tryToQuicPreConnect(WebKitFactory.getContext());
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void chromiumNetInit(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65550, null, j) == null) {
            initCronet(getKernelContext());
            mSoHandler = j;
            synchronized (BdNetEngine.mSelfLock) {
                Log.w(LOGTAG, "chromiunNetInit notifyAll");
                BdNetEngine.mSelfLock.notifyAll();
            }
            String str = null;
            try {
                str = CfgFileUtils.get(CfgFileUtils.KEY_ALT_SERVICE, (String) null);
            } catch (Throwable th) {
                Log.e(LOGTAG, "get KEY_ALT_SERVICE error: ".concat(String.valueOf(th)));
            }
            if (str != null) {
                setAltServiceToBlink(str);
            }
            setNeedDownloadCloudResource(WebKitFactory.getNeedDownloadCloudResource());
            ICronetListenerInterface cronetListenerInterface = WebViewFactory.getCronetListenerInterface();
            if (cronetListenerInterface == null) {
                Log.e(LOGTAG, "ICronetListenerInterface null");
                return;
            }
            Log.e(LOGTAG, "ICronetListenerInterface not null");
            cronetListenerInterface.notifyCronetInit();
        }
    }

    public static void clearNetworkFlow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, null) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().getSettingsStatics().clearNetworkFlow();
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                Log.w(LOGTAG, "clearNetworkFlow error:".concat(String.valueOf(th)));
            }
        }
    }

    public static void clearSavingBytes() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, null) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().getSettingsStatics().clearSavingBytes();
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                Log.w(LOGTAG, "clearSavingBytes error:".concat(String.valueOf(th)));
            }
        }
    }

    public static long generateBKDRHash(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, str)) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    return WebViewFactory.getProvider().getSettingsStatics().generateBKDRHash(str);
                }
                return -1L;
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return -1L;
            } catch (Throwable th) {
                th.printStackTrace();
                return -1L;
            }
        }
        return invokeL.longValue;
    }

    public static String getAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    return WebViewFactory.getProvider().getSettingsStatics().getAppId();
                }
                return null;
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return null;
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String getBrowserVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) ? mBrowserVersion : (String) invokeV.objValue;
    }

    public static long getChromiumHandle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) ? mSoHandler : invokeV.longValue;
    }

    public static boolean getChromiunNetInit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) {
            try {
                if (WebKitFactory.getCurEngine() == 1 && WebViewFactory.hasProvider()) {
                    if (mChromiumNetInit) {
                        return true;
                    }
                    boolean chromiunNetInit = WebViewFactory.getProvider().getSettingsStatics().getChromiunNetInit();
                    mChromiumNetInit = chromiunNetInit;
                    return chromiunNetInit;
                }
                return false;
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return false;
            } catch (Throwable th) {
                Log.e(LOGTAG, "getChromiunNetInit error:".concat(String.valueOf(th)));
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static String getCloudHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    return WebViewFactory.getProvider().getSettingsStatics().getCloudHost();
                }
                return null;
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return null;
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String getCloudSettingUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) {
            try {
                String cloudSettingUrl = WebViewFactory.hasProvider() ? WebViewFactory.getProvider().getSettingsStatics().getCloudSettingUrl() : null;
                if (cloudSettingUrl != null) {
                    if (cloudSettingUrl.length() > 0) {
                        return cloudSettingUrl;
                    }
                }
                return "https://browserkernel.baidu.com/config/t5config?cmd=1&";
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return "https://browserkernel.baidu.com/config/t5config?cmd=1&";
            } catch (Throwable th) {
                th.printStackTrace();
                return "https://browserkernel.baidu.com/config/t5config?cmd=1&";
            }
        }
        return (String) invokeV.objValue;
    }

    public static boolean getCloudSwitchInPercentage(String str, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65560, null, str, f2)) == null) {
            if (f2 < 0.0f || f2 > 1.0f) {
                throw new IllegalArgumentException("defPercent must between [0.0f, 1.0f]");
            }
            try {
                float floatValue = Float.valueOf(GetCloudSettingsValue(str)).floatValue();
                if (floatValue >= 0.0f && floatValue <= 1.0f) {
                    f2 = floatValue;
                }
            } catch (Throwable unused) {
            }
            double random = Math.random();
            Log.d(LOGTAG, "getCloudSwitchInPercentage key=" + str + " result=" + random + " value=" + f2);
            return random < ((double) f2);
        }
        return invokeLF.booleanValue;
    }

    public static boolean getCronetEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) {
            try {
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                Log.e(LOGTAG, "getCronetEnable error:".concat(String.valueOf(th)));
            }
            if ((GetCloudSettingsValue("oppp_enabled_cronet") == null || !GetCloudSettingsValue("oppp_enabled_cronet").equals("true")) && Build.VERSION.SDK_INT == 23 && Build.MODEL.indexOf("OPPO") != -1) {
                Log.e(LOGTAG, "mCronetEnable false");
                return false;
            }
            if (WebKitFactory.getCurEngine() == 1 && WebViewFactory.hasProvider()) {
                boolean z = CfgFileUtils.get(CfgFileUtils.KEY_CRONET_AB_STAT, true);
                mCronetEnable = z;
                if (z) {
                    Log.e(LOGTAG, "mCronetEnable");
                    boolean cronetEnable = WebViewFactory.getProvider().getSettingsStatics().getCronetEnable();
                    mCronetEnable = cronetEnable;
                    return cronetEnable;
                }
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static String getCuid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65562, null)) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    return WebViewFactory.getProvider().getSettingsStatics().getCuid();
                }
                return null;
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return null;
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String getDNSStatistic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65563, null)) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    return WebViewFactory.getProvider().getSettingsStatics().getDNSStatistic();
                }
                return null;
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return null;
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public static boolean getDitingMaxForceLoadSwitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65564, null)) == null) {
            boolean z = !"false".equals(GetCloudSettingsValue("diting_max_force_load_switch"));
            try {
                return WebViewFactory.hasProvider() ? z & WebViewFactory.getProvider().getSettingsStatics().getDitingMaxForceLoadSwitch() : z;
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return z;
            } catch (Throwable th) {
                th.printStackTrace();
                return z;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean getDitingMaxHit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65565, null)) == null) ? sDitingMaxHit : invokeV.booleanValue;
    }

    public static String getDnsInfo(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, str)) == null) {
            if (str != null) {
                try {
                    String dnsInfoEngine = getDnsInfoEngine(Uri.parse(str).getHost());
                    return dnsInfoEngine != null ? dnsInfoEngine : "";
                } catch (Throwable th) {
                    th.printStackTrace();
                    return "";
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String getDnsInfoEngine(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65567, null, str)) == null) {
            try {
                return WebViewFactory.hasProvider() ? WebViewFactory.getProvider().getSettingsStatics().getDnsInfo(str) : "";
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return "";
            } catch (Throwable th) {
                th.printStackTrace();
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static boolean getDoubleLogEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65568, null)) == null) ? mDoubleLogEnabled : invokeV.booleanValue;
    }

    public static int getDownTraffic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65569, null)) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    return WebViewFactory.getProvider().getSettingsStatics().getDownTraffic();
                }
                return 0;
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return 0;
            } catch (Throwable th) {
                Log.w(LOGTAG, "getDownTraffic error:".concat(String.valueOf(th)));
                return 0;
            }
        }
        return invokeV.intValue;
    }

    public static boolean getEnableEngineStat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65570, null)) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    return WebViewFactory.getProvider().getSettingsStatics().getEnableEngineStat();
                }
                return true;
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return true;
            } catch (Throwable th) {
                th.printStackTrace();
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean getEnableProxy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65571, null)) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    return WebViewFactory.getProvider().getSettingsStatics().getEnableProxy();
                }
                return false;
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return false;
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean getEnableSpdy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65572, null)) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    return WebViewFactory.getProvider().getSettingsStatics().getEnableSpdy();
                }
                return false;
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return false;
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean getEnableZeusManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65573, null)) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    return WebViewFactory.getProvider().getSettingsStatics().getEnableZeusManager();
                }
                return false;
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return false;
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static String getEngineStatUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65574, null)) == null) {
            try {
                String engineStatUrl = WebViewFactory.hasProvider() ? WebViewFactory.getProvider().getSettingsStatics().getEngineStatUrl() : null;
                if (engineStatUrl != null) {
                    if (engineStatUrl.length() > 0) {
                        return engineStatUrl;
                    }
                }
                return ENGINE_STAT_URL;
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return ENGINE_STAT_URL;
            } catch (Throwable th) {
                th.printStackTrace();
                return ENGINE_STAT_URL;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String getFakeBaiduUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65575, null)) == null) {
            try {
                String fakeBaiduUrl = WebViewFactory.hasProvider() ? WebViewFactory.getProvider().getSettingsStatics().getFakeBaiduUrl() : null;
                if (fakeBaiduUrl != null) {
                    if (fakeBaiduUrl.length() > 0) {
                        return fakeBaiduUrl;
                    }
                }
                return FAKE_BAIDU_URL;
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return FAKE_BAIDU_URL;
            } catch (Throwable th) {
                th.printStackTrace();
                return FAKE_BAIDU_URL;
            }
        }
        return (String) invokeV.objValue;
    }

    public static Boolean getGetUserMediaConfirmed(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65576, null, str)) == null) {
            String stripQueryAndAnchor = stripQueryAndAnchor(str);
            return (mGetUserMediaConfirmed.containsKey(stripQueryAndAnchor) && mGetUserMediaConfirmed.get(stripQueryAndAnchor).booleanValue()) ? Boolean.TRUE : Boolean.FALSE;
        }
        return (Boolean) invokeL.objValue;
    }

    public static boolean getGifOneFrameEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65577, null)) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    return WebViewFactory.getProvider().getSettingsStatics().getGifOneFrameEnabled();
                }
                return false;
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return false;
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean getHijackEnv() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65578, null)) == null) ? mHijackEnv : invokeV.booleanValue;
    }

    public static boolean getHttp2Enabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65579, null)) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    return WebViewFactory.getProvider().getSettingsStatics().getHttp2Enabled();
                }
                return false;
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return false;
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static String getHttpCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65580, null)) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    return WebViewFactory.getProvider().getSettingsStatics().getHttpCode();
                }
                return null;
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return null;
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String getHttpDnsCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65581, null)) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    return WebViewFactory.getProvider().getSettingsStatics().getHttpDnsCache();
                }
                return null;
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return null;
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public static int getHttpDnsSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65582, null)) == null) ? httpDnsSource : invokeV.intValue;
    }

    public static boolean getHttpDnsUpdateEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65583, null)) == null) {
            try {
                return CfgFileUtils.get(CfgFileUtils.KEY_HTTPDNS_AB_STAT, true);
            } catch (Throwable th) {
                Log.e(LOGTAG, "getHttpDnsUpdateEnabled error:".concat(String.valueOf(th)));
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static String getHttpDnsUrlHOST() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65584, null)) == null) {
            try {
                String httpDnsUrl = WebViewFactory.hasProvider() ? WebViewFactory.getProvider().getSettingsStatics().getHttpDnsUrl() : null;
                if (httpDnsUrl != null) {
                    if (httpDnsUrl.length() > 0) {
                        return httpDnsUrl;
                    }
                }
                return HTTP_DNS_URL_HOST;
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return HTTP_DNS_URL_HOST;
            } catch (Throwable th) {
                th.printStackTrace();
                return HTTP_DNS_URL_HOST;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String getHttpDnsUrlIP() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65585, null)) == null) {
            try {
                String httpDnsUrl = WebViewFactory.hasProvider() ? WebViewFactory.getProvider().getSettingsStatics().getHttpDnsUrl() : null;
                if (httpDnsUrl != null) {
                    if (httpDnsUrl.length() > 0) {
                        return httpDnsUrl;
                    }
                }
                return "https://180.76.76.112/v6/0010";
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return "https://180.76.76.112/v6/0010";
            } catch (Throwable th) {
                th.printStackTrace();
                return "https://180.76.76.112/v6/0010";
            }
        }
        return (String) invokeV.objValue;
    }

    public static HttpURLConnection getHttpUrlConnection(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65586, null, str)) == null) ? WebViewFactory.getProvider().getSettingsStatics().getHttpUrlConnection(str) : (HttpURLConnection) invokeL.objValue;
    }

    public static WebSettings.ImgQuality getImgQuality() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65587, null)) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    return WebViewFactory.getProvider().getSettingsStatics().getImgQuality();
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return WebSettings.ImgQuality.NO_COMPRESS;
        }
        return (WebSettings.ImgQuality) invokeV.objValue;
    }

    public static boolean getInNovelSiteList(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65588, null, str)) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    return WebViewFactory.getProvider().getSettingsStatics().getInNovelSiteList(str);
                }
                return false;
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return false;
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean getInVideoSiteList(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65589, null, str)) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    return WebViewFactory.getProvider().getSettingsStatics().getInVideoSiteList(str);
                }
                return false;
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return false;
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static int getInspectorKernelSupport() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65590, null)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public static boolean getIpv6Env() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65591, null)) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    return WebViewFactory.getProvider().getSettingsStatics().getIpv6Env();
                }
                return false;
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return false;
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean getIpv6HttpdnsEnv() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65592, null)) == null) {
            try {
                boolean z = CfgFileUtils.get(CfgFileUtils.KEY_HTTP_DNS_IPV6_ENV, false);
                Log.i(LOGTAG, "getIpv6HttpdnsEnv ".concat(String.valueOf(z)));
                return z;
            } catch (Exception e2) {
                Log.e(LOGTAG, "getIpv6HttpdnsEnv error: ".concat(String.valueOf(e2)));
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static int getKeepAliveTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65593, null)) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    return WebViewFactory.getProvider().getSettingsStatics().getKeepAliveTime();
                }
                return -1;
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return -1;
            } catch (Throwable th) {
                th.printStackTrace();
                return -1;
            }
        }
        return invokeV.intValue;
    }

    public static Context getKernelContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65594, null)) == null) ? WebViewFactory.getProvider().getSettingsStatics().getKernelContext() : (Context) invokeV.objValue;
    }

    public static int getLevelInfo(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65595, null, str)) == null) {
            int i = -1;
            try {
                if (WebViewFactory.hasProvider()) {
                    i = WebViewFactory.getProvider().getSettingsStatics().getLevelInfo(str);
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            Log.i(LOGTAG, "getLevelInfo host: %s, level: %d", str, Integer.valueOf(i));
            return i;
        }
        return invokeL.intValue;
    }

    public static String getLocalDns() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65596, null)) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    return WebViewFactory.getProvider().getSettingsStatics().getLocalDns();
                }
                return null;
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return null;
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public static int getLogLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65597, null)) == null) {
            try {
                if (WebKitFactory.getCurEngine() == 1 && WebViewFactory.hasProvider()) {
                    return WebViewFactory.getProvider().getSettingsStatics().getLogLevel();
                }
                return -1;
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return -1;
            } catch (Throwable th) {
                Log.e(LOGTAG, "getLogLevel error:".concat(String.valueOf(th)));
                return -1;
            }
        }
        return invokeV.intValue;
    }

    public static boolean getLogsdkEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65598, null)) == null) ? mLogsdkEnabled : invokeV.booleanValue;
    }

    public static boolean getMF30Inited() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65599, null)) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    return WebViewFactory.getProvider().getSettingsStatics().getMF30Inited();
                }
                return false;
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return false;
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static String getMLModelUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65600, null)) == null) {
            try {
                String mLModelUrl = WebViewFactory.hasProvider() ? WebViewFactory.getProvider().getSettingsStatics().getMLModelUrl() : null;
                if (mLModelUrl != null) {
                    if (mLModelUrl.length() > 0) {
                        return mLModelUrl;
                    }
                }
                return ML_MODEL_URL;
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return ML_MODEL_URL;
            } catch (Throwable th) {
                th.printStackTrace();
                return ML_MODEL_URL;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String getMainFrameIdInfo(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65601, null, i)) == null) {
            try {
                return WebViewFactory.hasProvider() ? WebViewFactory.getProvider().getSettingsStatics().getMainFrameIdInfo(i) : "";
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return "";
            } catch (Throwable th) {
                th.printStackTrace();
                return "";
            }
        }
        return (String) invokeI.objValue;
    }

    public static String getMainFrameIdReferrer(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65602, null, i)) == null) {
            try {
                return WebViewFactory.hasProvider() ? WebViewFactory.getProvider().getSettingsStatics().getMainFrameIdReferrer(i) : "";
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return "";
            } catch (Throwable th) {
                th.printStackTrace();
                return "";
            }
        }
        return (String) invokeI.objValue;
    }

    public static boolean getMainLinkDirectEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65603, null)) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    return WebViewFactory.getProvider().getSettingsStatics().getMainLinkDirectEnabled();
                }
                return false;
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return false;
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static JSONObject getMf30InitInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65604, null)) == null) ? sMf30InitInfo : (JSONObject) invokeV.objValue;
    }

    public static String getMfJsUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65605, null)) == null) {
            try {
                String mfJsUrl = WebViewFactory.hasProvider() ? WebViewFactory.getProvider().getSettingsStatics().getMfJsUrl() : null;
                if (mfJsUrl != null) {
                    if (mfJsUrl.length() > 0) {
                        return mfJsUrl;
                    }
                }
                return MF_JS_URL;
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return MF_JS_URL;
            } catch (Throwable th) {
                th.printStackTrace();
                return MF_JS_URL;
            }
        }
        return (String) invokeV.objValue;
    }

    public static int getNQE() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65606, null)) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    return WebViewFactory.getProvider().getSettingsStatics().getNQE();
                }
                return 0;
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return 0;
            } catch (Throwable th) {
                th.printStackTrace();
                return 0;
            }
        }
        return invokeV.intValue;
    }

    public static int getNetworkFlow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65607, null)) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    return WebViewFactory.getProvider().getSettingsStatics().getNetworkFlow();
                }
                return 0;
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return 0;
            } catch (Throwable th) {
                Log.w(LOGTAG, "getNetworkFlow error:".concat(String.valueOf(th)));
                return 0;
            }
        }
        return invokeV.intValue;
    }

    public static int getNetworkRtt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65608, null)) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    return WebViewFactory.getProvider().getSettingsStatics().getNetworkRtt();
                }
                return 0;
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return 0;
            } catch (Throwable th) {
                th.printStackTrace();
                return 0;
            }
        }
        return invokeV.intValue;
    }

    public static int getNetworkSpeed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65609, null)) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    return WebViewFactory.getProvider().getSettingsStatics().getNetworkSpeed();
                }
                return 0;
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return 0;
            } catch (Throwable th) {
                th.printStackTrace();
                return 0;
            }
        }
        return invokeV.intValue;
    }

    public static boolean getOnePacketEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65610, null)) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    return WebViewFactory.getProvider().getSettingsStatics().getOnePacketEnabled();
                }
                return false;
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return false;
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean getPFLogEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65611, null)) == null) {
            try {
                if (WebKitFactory.getCurEngine() == 1 && WebViewFactory.hasProvider()) {
                    return WebViewFactory.getProvider().getSettingsStatics().getPFLogEnabled();
                }
                return false;
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return false;
            } catch (Throwable th) {
                Log.e(LOGTAG, "getPFLogEnabled error:".concat(String.valueOf(th)));
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static String getPacUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65612, null)) == null) {
            try {
                String pacUrl = WebViewFactory.hasProvider() ? WebViewFactory.getProvider().getSettingsStatics().getPacUrl() : null;
                if (pacUrl != null) {
                    if (pacUrl.length() > 0) {
                        return pacUrl;
                    }
                }
                return PAC_URL;
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return PAC_URL;
            } catch (Throwable th) {
                th.printStackTrace();
                return PAC_URL;
            }
        }
        return (String) invokeV.objValue;
    }

    public static boolean getPageCacheEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65613, null)) == null) {
            try {
                if (GetCloudSettingsValue("page_cache") != null) {
                    return !GetCloudSettingsValue("page_cache").equals("false");
                }
                return true;
            } catch (Throwable th) {
                Log.w(LOGTAG, "getPageCacheEnabled error ".concat(String.valueOf(th)));
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public static String getPageFeature(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65614, null, str)) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    return WebViewFactory.getProvider().getSettingsStatics().getPageFeature(str);
                }
                return null;
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return null;
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String getPageWormHoleErrors() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65615, null)) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    return WebViewFactory.getProvider().getSettingsStatics().getPageWormHoleErrors();
                }
                return null;
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return null;
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public static int getPopupWindowNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65616, null)) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    return WebViewFactory.getProvider().getSettingsStatics().getPopupWindowNum();
                }
                return 0;
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return 0;
            } catch (Throwable th) {
                th.printStackTrace();
                return 0;
            }
        }
        return invokeV.intValue;
    }

    public static String getProxyInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65617, null)) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    return WebViewFactory.getProvider().getSettingsStatics().getProxyInfo();
                }
                return null;
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return null;
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public static WebSettings.ProxyType getProxyType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65618, null)) == null) ? mProxyType : (WebSettings.ProxyType) invokeV.objValue;
    }

    public static String getQuicHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65619, null)) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    return WebViewFactory.getProvider().getSettingsStatics().getQuicHost();
                }
                return null;
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return null;
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String getQuicInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65620, null)) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    return WebViewFactory.getProvider().getSettingsStatics().getQuicInfo();
                }
                return null;
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return null;
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public static int getQuicThreshold() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65621, null)) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    return WebViewFactory.getProvider().getSettingsStatics().getQuicThreshold();
                }
                return -1;
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return -1;
            } catch (Throwable th) {
                th.printStackTrace();
                return -1;
            }
        }
        return invokeV.intValue;
    }

    public static String getRc4SecrectKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65622, null)) == null) {
            try {
                String rc4SecrectKey = WebViewFactory.hasProvider() ? WebViewFactory.getProvider().getSettingsStatics().getRc4SecrectKey() : null;
                return (rc4SecrectKey == null || rc4SecrectKey.length() <= 0) ? new String(Base64.decode(DEFAULT_SECRECT_KEY.getBytes(), 0)) : new String(Base64.decode(rc4SecrectKey.getBytes(), 0));
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return new String(Base64.decode(DEFAULT_SECRECT_KEY.getBytes(), 0));
            } catch (Throwable th) {
                th.printStackTrace();
                return new String(Base64.decode(DEFAULT_SECRECT_KEY.getBytes(), 0));
            }
        }
        return (String) invokeV.objValue;
    }

    public static WebSettings.RemoveAdLevel getRemoveAdLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65623, null)) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    return WebViewFactory.getProvider().getSettingsStatics().getRemoveAdLevel();
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return WebSettings.RemoveAdLevel.DISABLE;
        }
        return (WebSettings.RemoveAdLevel) invokeV.objValue;
    }

    public static int getSavingBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65624, null)) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    return WebViewFactory.getProvider().getSettingsStatics().getSavingBytes();
                }
                return 0;
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return 0;
            } catch (Throwable th) {
                Log.w(LOGTAG, "getSavingBytes error:".concat(String.valueOf(th)));
                return 0;
            }
        }
        return invokeV.intValue;
    }

    public static int getSearchDnsMiss() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65625, null)) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    return WebViewFactory.getProvider().getSettingsStatics().getSearchDnsMiss();
                }
                return 0;
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return 0;
            } catch (Throwable th) {
                th.printStackTrace();
                return 0;
            }
        }
        return invokeV.intValue;
    }

    public static boolean getSendEngineUsageInfoEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65626, null)) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    return WebViewFactory.getProvider().getSettingsStatics().getSendEngineUsageInfoEnabled();
                }
                return false;
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return false;
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean getSendRequestEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65627, null)) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    return WebViewFactory.getProvider().getSettingsStatics().getSendRequestEnabled();
                }
                return false;
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return false;
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean getSessionHeaderEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65628, null)) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    return WebViewFactory.getProvider().getSettingsStatics().getSessionHeaderEnabled();
                }
                return true;
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return true;
            } catch (Throwable th) {
                th.printStackTrace();
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public static String getSessionUploadUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65629, null)) == null) {
            try {
                r0 = WebViewFactory.hasProvider() ? WebViewFactory.getProvider().getSettingsStatics().getSessionUploadUrl() : null;
                if (TextUtils.isEmpty(r0)) {
                    r0 = GetCloudSettingsValue("session_upload_url");
                }
            } catch (Throwable th) {
                Log.printStackTrace(th);
            }
            return !TextUtils.isEmpty(r0) ? r0 : SESSION_UPLOAD_URL;
        }
        return (String) invokeV.objValue;
    }

    public static int getSiteTypeInfo(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65630, null, str)) == null) {
            int i = -1;
            try {
                if (WebViewFactory.hasProvider()) {
                    i = WebViewFactory.getProvider().getSettingsStatics().getSiteTypeInfo(str);
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            Log.i(LOGTAG, "getSiteTypeInfo host: %s, siteType: %d", str, Integer.valueOf(i));
            return i;
        }
        return invokeL.intValue;
    }

    public static String getSkeletonJsUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65631, null)) == null) {
            String str = null;
            try {
                if (WebViewFactory.hasProvider()) {
                    str = WebViewFactory.getProvider().getSettingsStatics().getSkeletonJsUrl();
                    Log.i("ZeusSkeletonController", " getSkeletonJsUrl url = ".concat(String.valueOf(str)));
                }
                if (str != null) {
                    if (str.length() > 0) {
                        return str;
                    }
                }
                return SKELENTON_JS_URL;
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return SKELENTON_JS_URL;
            } catch (Throwable th) {
                th.printStackTrace();
                return SKELENTON_JS_URL;
            }
        }
        return (String) invokeV.objValue;
    }

    public static int getSocketGroupNumber() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65632, null)) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    return WebViewFactory.getProvider().getSettingsStatics().getSocketGroupNumber();
                }
                return -1;
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return -1;
            } catch (Throwable th) {
                th.printStackTrace();
                return -1;
            }
        }
        return invokeV.intValue;
    }

    public static boolean getSpdy31Enabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65633, null)) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    return WebViewFactory.getProvider().getSettingsStatics().getSpdy31Enabled();
                }
                return false;
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return false;
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean getSpdyCompressEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65634, null)) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    return WebViewFactory.getProvider().getSettingsStatics().getSpdyCompressEnabled();
                }
                return true;
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return true;
            } catch (Throwable th) {
                th.printStackTrace();
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean getSpdyEncryptionEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65635, null)) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    return WebViewFactory.getProvider().getSettingsStatics().getSpdyEncryptionEnabled();
                }
                return false;
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return false;
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean getSubResourceMonitorEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65636, null)) == null) {
            String GetCloudSettingsValue = GetCloudSettingsValue("sub_resource_monitor");
            return GetCloudSettingsValue == null || !GetCloudSettingsValue.equals("false");
        }
        return invokeV.booleanValue;
    }

    public static String getSubResourceTiming() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65637, null)) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    return WebViewFactory.getProvider().getSettingsStatics().getSubResourceTiming();
                }
                return null;
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return null;
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public static boolean getSysProxyEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65638, null)) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    return WebViewFactory.getProvider().getSettingsStatics().getSysProxyEnabled();
                }
                return false;
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return false;
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static String getTimgConfUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65639, null)) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    return WebViewFactory.getProvider().getSettingsStatics().getTimgConfUrl();
                }
                return null;
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return null;
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public static int getUpTraffic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65640, null)) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    return WebViewFactory.getProvider().getSettingsStatics().getUpTraffic();
                }
                return 0;
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return 0;
            } catch (Throwable th) {
                Log.w(LOGTAG, "getUpTraffic error:".concat(String.valueOf(th)));
                return 0;
            }
        }
        return invokeV.intValue;
    }

    public static boolean getWebessenseEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65641, null)) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    return WebViewFactory.getProvider().getSettingsStatics().getWebessenseEnabled();
                }
                return true;
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return true;
            } catch (Throwable th) {
                th.printStackTrace();
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public static List<String> getWhiteAndBlackList(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65642, null, str)) == null) {
            JSONArray jSONArray = mWhiteAndBlackList.get(str);
            if (jSONArray != null) {
                try {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        arrayList.add(jSONArray.getString(i));
                    }
                    return arrayList;
                } catch (JSONException e2) {
                    Log.w(LOGTAG, "parserData JSONTokener error ".concat(String.valueOf(e2)));
                    return null;
                }
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public static boolean getWormholeEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65643, null)) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    return WebViewFactory.getProvider().getSettingsStatics().getWormholeEnabled();
                }
                return false;
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return false;
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static String getWormholeForbidenHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65644, null)) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    return WebViewFactory.getProvider().getSettingsStatics().getWormholeForbidenHost();
                }
                return null;
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return null;
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public static int getWormholeNum(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65645, null, i)) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    return WebViewFactory.getProvider().getSettingsStatics().getWormholeNum(i);
                }
                return 0;
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return 0;
            } catch (Throwable th) {
                th.printStackTrace();
                return 0;
            }
        }
        return invokeI.intValue;
    }

    public static String getZeusManagerPkgName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65646, null)) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    return WebViewFactory.getProvider().getSettingsStatics().getZeusManagerPkgName();
                }
                return null;
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return null;
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String getZeusResourceUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65647, null)) == null) {
            String str = null;
            try {
                if (WebViewFactory.hasProvider()) {
                    str = WebViewFactory.getProvider().getSettingsStatics().getZeusResourceUrl();
                    Log.i("ZeusSkeletonController", " getZeusResourceUrl url = ".concat(String.valueOf(str)));
                }
                if (str != null) {
                    if (str.length() > 0) {
                        return str;
                    }
                }
                return ZEUS_RESOURCE_URL;
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return ZEUS_RESOURCE_URL;
            } catch (Throwable th) {
                th.printStackTrace();
                return ZEUS_RESOURCE_URL;
            }
        }
        return (String) invokeV.objValue;
    }

    public static boolean hasQuicAltService(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65648, null, str)) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    return WebViewFactory.getProvider().getSettingsStatics().hasQuicAltService(str);
                }
                return false;
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return false;
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static void initCronet(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65649, null, context) == null) {
            WebViewFactory.getProvider().getSettingsStatics().initCronet(context);
        }
    }

    public static void initNet() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65650, null) == null) {
            Log.e(LOGTAG, "initNet1");
            if (WebKitFactory.getCurEngine() == 1 && WebViewFactory.hasProvider()) {
                Log.e(LOGTAG, "initNet2");
                WebViewFactory.getProvider().initNet();
                Log.e(LOGTAG, "initNet3");
            }
        }
    }

    public static boolean isBlackListedDevice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65651, null)) == null) {
            android.util.Log.d(LOGTAG, "manufacturer: " + Build.MANUFACTURER);
            android.util.Log.d(LOGTAG, "build host: " + Build.HOST);
            android.util.Log.d(LOGTAG, "version: " + Build.VERSION.INCREMENTAL);
            try {
                String GetCloudSettingsValue = GetCloudSettingsValue("multiple_process_blacklist");
                if (GetCloudSettingsValue == null) {
                    android.util.Log.d(LOGTAG, "blacklist not configured");
                }
                if (GetCloudSettingsValue != null) {
                    android.util.Log.d(LOGTAG, "blackList=".concat(String.valueOf(GetCloudSettingsValue)));
                    JSONArray jSONArray = new JSONArray(GetCloudSettingsValue);
                    if (jSONArray.length() == 0) {
                        android.util.Log.d(LOGTAG, "empty blacklist");
                        return false;
                    }
                    for (int i = 0; i < jSONArray.length(); i++) {
                        if (isMatchedDevice((JSONObject) jSONArray.get(i))) {
                            android.util.Log.d(LOGTAG, "in blacklist");
                            return true;
                        }
                    }
                    android.util.Log.d(LOGTAG, "not in blackList");
                    return false;
                }
            } catch (Throwable th) {
                Log.w(LOGTAG, "error when parsing blacklist: ".concat(String.valueOf(th)));
            }
            return ("Xiaomi".equals(Build.MANUFACTURER) || Build.HOST.contains("miui")) && Build.VERSION.INCREMENTAL.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX).length == 3;
        }
        return invokeV.booleanValue;
    }

    public static boolean isEffectiveDate(Date date, Date date2, Date date3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65652, null, date, date2, date3)) == null) {
            if (date.getTime() == date2.getTime() || date.getTime() == date3.getTime()) {
                return true;
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(date2);
            Calendar calendar3 = Calendar.getInstance();
            calendar3.setTime(date3);
            return calendar.after(calendar2) && calendar.before(calendar3);
        }
        return invokeLLL.booleanValue;
    }

    public static boolean isFeedNoProxyAdUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65653, null, str)) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    return WebViewFactory.getProvider().getSettingsStatics().isFeedNoProxyAdUrl(str);
                }
                return false;
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return false;
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean isFeedProxyAdUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65654, null, str)) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    return WebViewFactory.getProvider().getSettingsStatics().isFeedProxyAdUrl(str);
                }
                return false;
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return false;
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean isInFCCheatBlackList(String str) {
        InterceptResult invokeL;
        JSONArray jSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65655, null, str)) == null) {
            if (mFCCheatBlackList.isEmpty() && (jSONArray = mWhiteAndBlackList.get("FC_Landing_Cheat")) != null) {
                try {
                    synchronized (mFCCheatBlackList) {
                        for (int i = 0; i < jSONArray.length(); i++) {
                            mFCCheatBlackList.add(jSONArray.getString(i).toLowerCase());
                        }
                    }
                } catch (JSONException e2) {
                    Log.w(LOGTAG, "parserData JSONTokener error ".concat(String.valueOf(e2)));
                }
            }
            return mFCCheatBlackList.contains(str.toLowerCase());
        }
        return invokeL.booleanValue;
    }

    public static boolean isMatchedDevice(JSONObject jSONObject) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65656, null, jSONObject)) == null) {
            android.util.Log.d(LOGTAG, "isMatchedDevice, rule=".concat(String.valueOf(jSONObject)));
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                jSONObject.getString(next);
                if (HttpConstants.HTTP_MANUFACTURER.equals(next)) {
                    if (!Build.MANUFACTURER.equals(jSONObject.getString(next))) {
                        return false;
                    }
                } else if ("model".equals(next)) {
                    if (sBlackListModels == null) {
                        sBlackListModels = new HashSet<>();
                        for (String str : jSONObject.getString(next).split(",")) {
                            sBlackListModels.add(str);
                        }
                    }
                    Log.i(LOGTAG, "blacklist: " + sBlackListModels);
                    if (!sBlackListModels.contains(Build.MODEL)) {
                        return false;
                    }
                } else if (!"sdk_int".equals(next)) {
                    Log.w(LOGTAG, "unknown key: ".concat(String.valueOf(next)));
                    return false;
                } else if (Build.VERSION.SDK_INT != jSONObject.getInt(next)) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean isMultiProcessEnabled() {
        InterceptResult invokeV;
        String str;
        String str2;
        Boolean bool;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65657, null)) == null) {
            Boolean bool2 = sMultiprocessEnabled;
            if (bool2 != null) {
                return bool2.booleanValue();
            }
            if (WebViewFactory.isMainAppProcess()) {
                if (WebKitFactory.getEnableMultipleProcess() != WebKitFactory.SwitchState.Invalid) {
                    Log.i(LOGTAG, "multiprocess %s", WebKitFactory.getEnableMultipleProcess());
                    bool = Boolean.valueOf(WebKitFactory.getEnableMultipleProcess() == WebKitFactory.SwitchState.On);
                    sMultiprocessEnabled = bool;
                } else {
                    int i = Build.VERSION.SDK_INT;
                    if (i < 21 || i > 29) {
                        str = "multiprocess not enabled for current SDK version";
                    } else {
                        ActivityManager activityManager = (ActivityManager) WebViewFactory.getContext().getSystemService("activity");
                        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                        try {
                            activityManager.getMemoryInfo(memoryInfo);
                            android.util.Log.d(LOGTAG, "MemoryInfo.totalMem: " + (memoryInfo.totalMem >> 20) + " MB");
                            android.util.Log.d(LOGTAG, "MemoryInfo.threshold: " + (memoryInfo.threshold >> 20) + " MB");
                            android.util.Log.d(LOGTAG, "MemoryInfo.availMem: " + (memoryInfo.availMem >> 20) + " MB");
                            StringBuilder sb = new StringBuilder("MemoryInfo.lowMemory: ");
                            sb.append(memoryInfo.lowMemory);
                            android.util.Log.d(LOGTAG, sb.toString());
                        } catch (RuntimeException e2) {
                            Log.w(LOGTAG, "Failed to get memory info due to a runtime exception: %s", e2);
                        }
                        if ((memoryInfo.totalMem >> 20) < mTotalMem) {
                            Log.i(LOGTAG, "multiprocess not enabled for low memory device");
                            sMultiprocessEnabled = Boolean.FALSE;
                            return false;
                        }
                        if (memoryInfo.availMem < memoryInfo.threshold * 2 || (memoryInfo.availMem >> 20) < 500) {
                            Log.i(LOGTAG, "multiprocess not enabled for low memory");
                            sMultiprocessEnabled = Boolean.FALSE;
                            return false;
                        }
                        if (isBlackListedDevice()) {
                            sMultiprocessEnabled = Boolean.FALSE;
                            str2 = "multiprocess disabled for device";
                        } else if (isWhiteListedDevice()) {
                            Log.i(LOGTAG, "multiprocess enabled for device");
                            sMultiprocessEnabled = Boolean.TRUE;
                            return true;
                        } else {
                            int i2 = Build.VERSION.SDK_INT;
                            if (i2 < 26 || i2 > 29) {
                                str = "multiprocess not published for current SDK version";
                            } else {
                                try {
                                    if (GetCloudSettingsValue(ABTestSDK.ZEUS_MULTIPLE_PROCESS) != null && GetCloudSettingsValue(ABTestSDK.ZEUS_MULTIPLE_PROCESS).equals("false")) {
                                        Log.i(LOGTAG, "multiprocess cloud settings off");
                                        sMultiprocessEnabled = Boolean.FALSE;
                                        return false;
                                    }
                                } catch (Throwable th) {
                                    Log.w(LOGTAG, "isMultiProcessEnabled error ".concat(String.valueOf(th)));
                                }
                                if (!ABTestSDK.isReady()) {
                                    str = "multiprocess AbTestInterface not set";
                                } else if (ABTestSDK.isMultipleProcessEnabled()) {
                                    sMultiprocessEnabled = shouldBockFrequentCrash() ? Boolean.valueOf(!WebViewFactory.getContext().getSharedPreferences(PREF_NAME_MULTIPROCESS, 0).getBoolean(PREF_KEY_MULTIPROCESS_DISABLED, false)) : Boolean.TRUE;
                                    str2 = "multiprocess enabled: " + sMultiprocessEnabled;
                                } else {
                                    str = "multiprocess Ab test off";
                                }
                            }
                        }
                        Log.i(LOGTAG, str2);
                        bool = sMultiprocessEnabled;
                    }
                }
                return bool.booleanValue();
            }
            str = "multiprocess not enabled for current process";
            Log.i(LOGTAG, str);
            sMultiprocessEnabled = Boolean.FALSE;
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean isSFSwitchEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65658, null)) == null) {
            String GetCloudSettingsValue = GetCloudSettingsValue(SFSWITCH);
            return !TextUtils.isEmpty(GetCloudSettingsValue) && GetCloudSettingsValue.equalsIgnoreCase(SFSWITCH_VALUE_OPEN);
        }
        return invokeV.booleanValue;
    }

    public static boolean isSessionDataEnable() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65659, null)) == null) {
            String GetCloudSettingsValue = GetCloudSettingsValue("log_method");
            boolean z = true;
            if (GetCloudSettingsValue != null) {
                if (!GetCloudSettingsValue.equals("1") && !GetCloudSettingsValue.equals("4") && !GetCloudSettingsValue.equals("5") && !GetCloudSettingsValue.equals("6")) {
                    z = false;
                }
                mSessionDataEnable = z;
                str = "isSessionDataEnable(), log_method=" + GetCloudSettingsValue + ", isSessionDataEnable=" + mSessionDataEnable;
            } else {
                mSessionDataEnable = true;
                str = "isSessionDataEnable(), log_method is not configured, isSessionDataEnable=" + mSessionDataEnable;
            }
            Log.w(LOGTAG, str);
            return mSessionDataEnable;
        }
        return invokeV.booleanValue;
    }

    public static boolean isShowWebProviderBy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65660, null)) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    return WebViewFactory.getProvider().getSettingsStatics().isShowWebProviderBy();
                }
                return false;
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return false;
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean isWebViewMonitorEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65661, null)) == null) {
            try {
                if (GetCloudSettingsValue("webview_monitor") != null) {
                    return !GetCloudSettingsValue("webview_monitor").equals("false");
                }
                return true;
            } catch (Throwable th) {
                Log.w(LOGTAG, "isWebViewMonitorEnabled error ".concat(String.valueOf(th)));
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean isWhiteListedDevice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65662, null)) == null) {
            try {
                String GetCloudSettingsValue = GetCloudSettingsValue("multiple_process_devices");
                if (GetCloudSettingsValue != null) {
                    if (GetCloudSettingsValue.equals("false")) {
                        return false;
                    }
                }
            } catch (Throwable th) {
                Log.w(LOGTAG, "isWhiteListedDevice error ".concat(String.valueOf(th)));
            }
            if (sDeviceSet == null) {
                sDeviceSet = new HashSet<>();
                for (String str : DEFAULT_MULTIPROCESS_MODELS.split(",")) {
                    sDeviceSet.add(str);
                }
            }
            Log.i(LOGTAG, "device model: " + Build.MODEL);
            return sDeviceSet.contains(Build.MODEL);
        }
        return invokeV.booleanValue;
    }

    public static ByteBuffer kernelBrotliCreate(long[] jArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65663, null, jArr)) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    return WebViewFactory.getProvider().getSettingsStatics().kernelBrotliCreate(jArr);
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return ByteBuffer.allocate(0);
        }
        return (ByteBuffer) invokeL.objValue;
    }

    public static void kernelBrotliDestroy(long[] jArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65664, null, jArr) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().getSettingsStatics().kernelBrotliDestroy(jArr);
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static ByteBuffer kernelBrotliPull(long[] jArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65665, null, jArr)) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    return WebViewFactory.getProvider().getSettingsStatics().kernelBrotliPull(jArr);
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return ByteBuffer.allocate(0);
        }
        return (ByteBuffer) invokeL.objValue;
    }

    public static void kernelBrotliPush(long[] jArr, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65666, null, jArr, i) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().getSettingsStatics().kernelBrotliPush(jArr, i);
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void kernelEncrypt(byte[] bArr, int i, byte[] bArr2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65667, null, bArr, i, bArr2) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().getSettingsStatics().kernelEncrypt(bArr, i, bArr2);
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void kernelLog(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65668, null, str, str2) == null) {
            if (!mFirstGetLogEnable && WebKitFactory.getCurEngine() == 1) {
                mLogEnable = getPFLogEnabled();
                Log.i(LOGTAG, "mLogEnable " + mLogEnable);
                mFirstGetLogEnable = true;
            }
            if (mLogEnable) {
                Log.i(str, str2);
            }
        }
    }

    public static void notifyAllOnCronetThreadInitializedListener(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65669, null, j) == null) {
            Log.i(LOGTAG, "NotifyAllOnCronetThreadInitializedListener. nativeTablePointer=%d, list size=%d", Long.valueOf(j), Integer.valueOf(sOnCronetThreadInitializedListenerList.size()));
            synchronized (sOnCronetThreadInitializedListenerList) {
                sNativeV8FunctionTablePointer = j;
                for (ValueCallback<Long> valueCallback : sOnCronetThreadInitializedListenerList) {
                    valueCallback.onReceiveValue(Long.valueOf(j));
                }
                sOnCronetThreadInitializedListenerList.clear();
            }
        }
    }

    public static void notifyBdAppStatusChange(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65670, null, i) == null) {
            Log.e(LOGTAG, "notifyBdAppStatusChange ".concat(String.valueOf(i)));
            WebViewFactory.getProvider().getSettingsStatics().notifyBdAppStatusChange(i);
        }
    }

    public static void notifyPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65671, null) == null) {
            mHttpDnsNetChangedAfterPause = false;
            mIsAlive = false;
            setAppStatus(false);
        }
    }

    public static void notifyResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65672, null) == null) {
            mIsAlive = true;
            setAppStatus(true);
            if (WebKitFactory.getNeedDownloadCloudResource() && mHttpDnsNetChangedAfterPause && getHttpDnsUpdateEnabled()) {
                mHttpDnsUpdateTime = System.currentTimeMillis();
                Log.i(LOGTAG, "notifyResume tryToUpdateHttpDnsCache");
                HttpDnsCache.tryToUpdateHttpDnsCache(WebViewFactory.getContext());
            }
        }
    }

    public static void onZeusEnableWillChange(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65673, null, str, str2) == null) {
            boolean z = false;
            if ((str == null || str.length() == 0 || str.toLowerCase().equals("true")) != ((str2 == null || str2.length() == 0 || str2.toLowerCase().equals("true")) ? true : true)) {
                EngineManager.getInstance().setNeedKillProcess(true);
            }
        }
    }

    public static boolean recordRenderCrash() {
        InterceptResult invokeV;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65674, null)) == null) {
            if (shouldBockFrequentCrash()) {
                long currentTimeMillis = System.currentTimeMillis();
                Context context = WebViewFactory.getContext();
                Log.d(LOGTAG, "recordRenderCrash()");
                if (context == null) {
                    return false;
                }
                SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME_MULTIPROCESS, 0);
                SharedPreferences.Editor edit = sharedPreferences.edit();
                StringBuilder sb = new StringBuilder();
                sb.append(String.valueOf(currentTimeMillis));
                String string = sharedPreferences.getString(PREF_KEY_RENDER_CRASHES, null);
                Log.d(LOGTAG, "  existing crashes: ".concat(String.valueOf(string)));
                if (string != null) {
                    int i = 1;
                    for (String str : string.split(",")) {
                        if (currentTimeMillis - Long.parseLong(str, 10) < RENDER_CRASH_LOG_TIMEOUT) {
                            i++;
                            sb.append(",");
                            sb.append(str);
                        }
                    }
                    Log.d(LOGTAG, "  recent crash count: ".concat(String.valueOf(i)));
                    if (i >= MAX_RENDER_CRASH_COUNT) {
                        Log.i(LOGTAG, "  too many crashes recently, disabling multiprocess");
                        edit.putBoolean(PREF_KEY_MULTIPROCESS_DISABLED, true);
                        edit.remove(PREF_KEY_RENDER_CRASHES);
                        edit.commit();
                        return true;
                    }
                }
                Log.d(LOGTAG, "  new crashes: " + sb.toString());
                edit.putString(PREF_KEY_RENDER_CRASHES, sb.toString());
                edit.commit();
                Log.d(LOGTAG, "  done");
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static void removeDnsInfo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65675, null, str) == null) {
            try {
                removeDnsInfoEngine(Uri.parse(str).getHost());
            } catch (Throwable th) {
                Log.w(LOGTAG, "removeDnsInfo error ".concat(String.valueOf(th)));
            }
        }
    }

    public static void removeDnsInfoEngine(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65676, null, str) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().getSettingsStatics().removeDnsInfo(str);
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void removeMainFrameIdInfo(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65677, null, i) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().getSettingsStatics().removeMainFrameIdInfo(i);
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void removeOnCronetThreadInitializedListener(ValueCallback<Long> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65678, null, valueCallback) == null) {
            synchronized (sOnCronetThreadInitializedListenerList) {
                sOnCronetThreadInitializedListenerList.remove(valueCallback);
            }
        }
    }

    public static void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65679, null) == null) {
        }
    }

    public static void restoreHttpDnsCacheFromCfg() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65680, null) == null) {
            HttpDnsCache.restoreLastCacheFromCfg();
        }
    }

    public static void setAltService(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65681, null, str) == null) {
            CfgFileUtils.set(CfgFileUtils.KEY_ALT_SERVICE, str);
        }
    }

    public static void setAltServiceToBlink(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65682, null, str) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().getSettingsStatics().setAltServiceToBlink(str);
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void setAppId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65683, null, str) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().getSettingsStatics().setAppId(str);
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void setAppStatus(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65684, null, z) == null) {
            try {
                Log.w(LOGTAG, "setAppStatus ".concat(String.valueOf(z)));
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().getSettingsStatics().setAppStatus(z);
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void setBackupDnsJobDelayTime(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65685, null, i) == null) {
            try {
                Log.w(LOGTAG, "setBackupDnsJobDelayTime ".concat(String.valueOf(i)));
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().getSettingsStatics().setBackupDnsJobDelayTime(i);
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void setBackupJobDelayTime(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65686, null, i) == null) {
            try {
                Log.w(LOGTAG, "setBackupJobDelayTime ".concat(String.valueOf(i)));
                CfgFileUtils.set(CfgFileUtils.KEY_BACK_DNS_TIME, String.valueOf(i));
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().getSettingsStatics().setBackupJobDelayTime(i);
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void setBackupLandingJobDelayTime(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65687, null, i) == null) {
            try {
                Log.w(LOGTAG, "setBackupLandingJobDelayTime ".concat(String.valueOf(i)));
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().getSettingsStatics().setBackupLandingJobDelayTime(i);
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void setBrowserVersion(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65688, null, str) == null) {
            mBrowserVersion = str;
        }
    }

    public static void setClientIP(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65689, null, str) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().getSettingsStatics().setClientIP(str);
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void setCloudSettings(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65690, null, str) == null) {
            String GetCloudSettingsValue = GetCloudSettingsValue(ETAG.KEY_HTTP_DNS_ENABLE);
            String GetCloudSettingsValue2 = GetCloudSettingsValue("chromium63_zeus_enable");
            if (str != null) {
                mCloudSettings = str;
                try {
                    JSONObject jSONObject = (JSONObject) new JSONTokener(str).nextValue();
                    if (jSONObject.length() > 0) {
                        synchronized (mSelfLock) {
                            mCloudSettingsMap.clear();
                        }
                    }
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        String string = jSONObject.getString(next);
                        synchronized (mSelfLock) {
                            mCloudSettingsMap.put(next, string);
                        }
                    }
                } catch (Throwable th) {
                    Log.w(LOGTAG, "setCloudSettings parserData JSONTokener error ".concat(String.valueOf(th)));
                }
                try {
                    onZeusEnableWillChange(GetCloudSettingsValue2, GetCloudSettingsValue("chromium63_zeus_enable"));
                    if (mCloudSettings != null) {
                        setCloudSettingsToT5(mCloudSettings);
                        shouldReLoadHttpDns(GetCloudSettingsValue);
                    }
                } catch (Throwable th2) {
                    Log.w(LOGTAG, "setCloudSettings to zeus error ".concat(String.valueOf(th2)));
                }
            }
        }
    }

    public static void setCloudSettingsToT5(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65691, null, str) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().getSettingsStatics().setCloudSettingsToT5(str);
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void setConThreshold(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65692, null, i) == null) {
            try {
                Log.w(LOGTAG, "setConThreshold ".concat(String.valueOf(i)));
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().getSettingsStatics().setConThreshold(i);
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void setCronetEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65693, null, z) == null) {
            Log.w(LOGTAG, "setCronetEnable ".concat(String.valueOf(z)));
            mCronetEnable = z;
            CfgFileUtils.set(CfgFileUtils.KEY_CRONET_AB_STAT, z);
        }
    }

    public static void setCuid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65694, null, str) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().getSettingsStatics().setCuid(str);
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void setDitingMaxEnabled(boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65695, null, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().getSettingsStatics().setDitingMaxEnabled(z, z2, z3);
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void setDitingMaxHit(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65696, null, z) == null) {
            sDitingMaxHit = z;
        }
    }

    public static void setDoubleLogEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65697, null, z) == null) {
            Log.w(LOGTAG, "setDoubleLogEnabled ".concat(String.valueOf(z)));
            mDoubleLogEnabled = z;
        }
    }

    public static void setEnableEngineStat(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65698, null, z) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().getSettingsStatics().setEnableEngineStat(z);
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void setEnableProxy(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65699, null, z) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().getSettingsStatics().setEnableProxy(z);
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void setEnableSpdy(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65700, null, z) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().getSettingsStatics().setEnableSpdy(z);
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void setEnableZeusManager(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65701, null, z) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().getSettingsStatics().setEnableZeusManager(z);
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void setEngineStatUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65702, null, str) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().getSettingsStatics().setEngineStatUrl(str);
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void setEvilPageWhiteBlackListPath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65703, null, str) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().getSettingsStatics().setEvilPageWhiteBlackListPath(str);
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void setFakeBaiduWhiteList(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65704, null, str) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().getSettingsStatics().setFakeBaiduWhiteList(str);
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void setFastPac(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65705, null, str) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().getSettingsStatics().setFastPac(str);
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void setFileInIOEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65706, null, z) == null) {
            try {
                Log.w(LOGTAG, "setFileInIOEnabled ".concat(String.valueOf(z)));
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().getSettingsStatics().setFileInIOEnabled(z);
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void setFreeFlow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65707, null, z) == null) {
            Log.w(LOGTAG, "setFreeFlow ".concat(String.valueOf(z)));
            try {
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().getSettingsStatics().setFreeFlow(z);
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void setGetUserMediaConfirmed(String str, Boolean bool) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65708, null, str, bool) == null) || str == null) {
            return;
        }
        mGetUserMediaConfirmed.put(stripQueryAndAnchor(str), bool);
    }

    public static void setGifOneFrameEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65709, null, z) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().getSettingsStatics().setGifOneFrameEnabled(z);
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void setHijackEnv(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65710, null, z) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().getSettingsStatics().setHijackEnv(z);
                    mHijackEnv = z;
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void setHttpDnsCache(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65711, null, str, i) == null) {
            try {
                httpDnsSource = i;
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().getSettingsStatics().setHttpDnsCache(str, i);
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void setHttpDnsDnFailed(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65712, null, str) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().getSettingsStatics().setHttpDnsDnFailed(str);
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void setHttpDnsUpdateEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65713, null, z) == null) {
            Log.w(LOGTAG, "setHttpDnsUpdateEnabled ".concat(String.valueOf(z)));
            CfgFileUtils.set(CfgFileUtils.KEY_HTTPDNS_AB_STAT, z);
        }
    }

    public static void setIPV6CheckList(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65714, null, str) == null) {
            try {
                Log.w(LOGTAG, "setIPV6CheckList ".concat(String.valueOf(str)));
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().getSettingsStatics().setIPV6CheckList(str);
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void setIPV6Timeout(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65715, null, i) == null) {
            try {
                Log.w(LOGTAG, "setIPV6Timeout ".concat(String.valueOf(i)));
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().getSettingsStatics().setIPV6Timeout(i);
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void setImgQuality(WebSettings.ImgQuality imgQuality) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65716, null, imgQuality) == null) {
        }
    }

    public static void setInPageJudgeWhiteList(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65717, null, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().getSettingsStatics().setInPageJudgeWhiteList(z, z2);
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void setIpv6First(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65718, null, z) == null) {
            try {
                Log.w(LOGTAG, "setIpv6First ".concat(String.valueOf(z)));
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().getSettingsStatics().setIpv6First(z);
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void setIpv6HttpdnsEnv(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65719, null, z) == null) {
            Log.w(LOGTAG, "setIpv6HttpdnsEnv ".concat(String.valueOf(z)));
            try {
                CfgFileUtils.set(CfgFileUtils.KEY_HTTP_DNS_IPV6_ENV, z);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void setKeepAliveTime(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65720, null, i) == null) {
            try {
                Log.w(LOGTAG, "setKeepAliveTime ".concat(String.valueOf(i)));
                CfgFileUtils.set(CfgFileUtils.KEY_KEEP_ALIVE_TIME, String.valueOf(i));
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().getSettingsStatics().setKeepAliveTime(i);
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void setLogsdkEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65721, null, z) == null) {
            Log.w(LOGTAG, "setLogsdkEnabled ".concat(String.valueOf(z)));
            mLogsdkEnabled = z;
        }
    }

    public static void setMLModel(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65722, null, str, str2) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().getSettingsStatics().setMLModel(str, str2);
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void setMagicFilterModelSize(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65723, null, j) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("mf_size", j);
                jSONObject.put("type", 16391);
                SessionMonitorEngine.getInstance().recordImmediately("sailor_monitor", jSONObject.toString());
            } catch (Throwable th) {
                Log.printStackTrace(th);
            }
        }
    }

    public static void setMainLinkDirectEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65724, null, z) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().getSettingsStatics().setMainLinkDirectEnabled(z);
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void setMf30InitInfo(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65725, null, jSONObject) == null) {
            sMf30InitInfo = jSONObject;
        }
    }

    public static void setMulripleConnectEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65726, null, z) == null) {
            try {
                Log.w(LOGTAG, "setMulripleConnectEnabled ".concat(String.valueOf(z)));
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().getSettingsStatics().setMulripleConnectEnabled(z);
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void setNavigationInterceptionEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65727, null, z) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().getSettingsStatics().setNavigationInterceptionEnable(z);
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void setNeedDownloadCloudResource(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65728, null, z) == null) {
            try {
                Log.w(LOGTAG, "setNeedDownloadCloudResource ".concat(String.valueOf(z)));
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().getSettingsStatics().setNeedDownloadCloudResource(z);
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void setNetWorkChangeNotifyEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65729, null, z) == null) {
            try {
                Log.w(LOGTAG, "setNetWorkChangeNotifyEnabled ".concat(String.valueOf(z)));
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().getSettingsStatics().setNetWorkChangeNotifyEnabled(z);
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void setOnePacketEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65730, null, z) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().getSettingsStatics().setOnePacketEnabled(z);
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void setPacData(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65731, null, str) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().getSettingsStatics().setPacData(str);
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void setPacDataFreeFlow(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65732, null, str) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().getSettingsStatics().setPacDataFreeFlow(str);
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void setPacUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65733, null, str) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().getSettingsStatics().setPacUrl(str);
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void setPopupWindowOptEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65734, null, z) == null) {
            try {
                Log.w(LOGTAG, "setPopupWindowOptEnabled ".concat(String.valueOf(z)));
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().getSettingsStatics().setPopupWindowOptEnabled(z);
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void setPreConnectEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65735, null, z) == null) {
            try {
                Log.w(LOGTAG, "setPreConnectEnabled ".concat(String.valueOf(z)));
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().getSettingsStatics().setPreConnectEnabled(z);
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void setProxyInfo(String str, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65736, null, str, strArr) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().getSettingsStatics().setProxyInfo(str, strArr);
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void setProxyType(WebSettings.ProxyType proxyType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65737, null, proxyType) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    Log.w(LOGTAG, "setProxyType ".concat(String.valueOf(proxyType)));
                    if (WebSettings.ProxyType.NO_PROXY == proxyType) {
                        WebViewFactory.getProvider().getSettingsStatics().setProxyType(0);
                    } else if (WebSettings.ProxyType.SPDY_PROXY == proxyType) {
                        WebViewFactory.getProvider().getSettingsStatics().setProxyType(1);
                    } else if (WebSettings.ProxyType.OVERSEAS_PROXY == proxyType) {
                        WebViewFactory.getProvider().getSettingsStatics().setProxyType(2);
                    } else if (WebSettings.ProxyType.SPDYANDOVERSEAS_PROXY == proxyType) {
                        WebViewFactory.getProvider().getSettingsStatics().setProxyType(3);
                    }
                    mProxyType = proxyType;
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void setQuicDefaultOpen(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65738, null, z) == null) {
            try {
                Log.w(LOGTAG, "setQuicDefaultOpen ".concat(String.valueOf(z)));
                mQuicDefaultOpen = z;
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().getSettingsStatics().setQuicDefaultOpen(z);
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void setQuicThreshold(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65739, null, i) == null) {
            try {
                Log.w(LOGTAG, "setQuicThreshold ".concat(String.valueOf(i)));
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().getSettingsStatics().setQuicThreshold(i);
                    if (i == -1 || WebViewFactory.getProvider().getSettingsStatics().getQuicInit()) {
                        return;
                    }
                    QuicPreConnect.tryToQuicPreConnect(WebKitFactory.getContext());
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void setRefererPattern(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65740, null, str, str2) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().getSettingsStatics().setRefererPattern(str, str2);
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                Log.w(LOGTAG, "getSavingBytes error:".concat(String.valueOf(th)));
            }
        }
    }

    public static void setRemoveAdLevel(WebSettings.RemoveAdLevel removeAdLevel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65741, null, removeAdLevel) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().getSettingsStatics().setRemoveAdLevel(removeAdLevel);
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void setSearchFrameQuicEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65742, null, z) == null) {
            try {
                Log.w(LOGTAG, "setSearchFrameQuicEnabled ".concat(String.valueOf(z)));
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().getSettingsStatics().setSearchFrameQuicEnabled(z);
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void setSendEngineUsageInfoEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65743, null, z) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().getSettingsStatics().setSendEngineUsageInfoEnabled(z);
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void setSessionHeaderEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65744, null, z) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().getSettingsStatics().setSessionHeaderEnabled(z);
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void setShowWebProviderBy(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65745, null, z) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().getSettingsStatics().setShowWebProviderBy(z);
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void setSocketGroupNumber(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65746, null, i) == null) {
            try {
                Log.w(LOGTAG, "setSocketGroupNumber ".concat(String.valueOf(i)));
                CfgFileUtils.set(CfgFileUtils.KEY_SOCKET_GROUP_NUMBER, String.valueOf(i));
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().getSettingsStatics().setSocketGroupNumber(i);
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void setSpdyCompressEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65747, null, z) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().getSettingsStatics().setSpdyCompressEnabled(z);
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void setSpdyEncryptionEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65748, null, z) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().getSettingsStatics().setSpdyEncryptionEnabled(z);
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void setSpdyTimeout(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65749, null, i) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().getSettingsStatics().setSpdyTimeout(i);
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void setStatisticParam(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65750, null, str) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().getSettingsStatics().setStatisticParam(str);
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void setSubResourceMonitorEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65751, null, z) == null) {
            try {
                Log.w(LOGTAG, "setSubResourceMonitorEnabled ".concat(String.valueOf(z)));
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().getSettingsStatics().setSubResourceMonitorEnabled(z);
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void setT5SDKSpdyEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65752, null, z) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().getSettingsStatics().setT5SDKSpdyEnabled(z);
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void setTcSpeedUpEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65753, null, z) == null) {
            try {
                Log.w(LOGTAG, "setTcSpeedUpEnabled ".concat(String.valueOf(z)));
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().getSettingsStatics().setTcSpeedUpEnabled(z);
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void setTimgConfData(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65754, null, str) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().getSettingsStatics().setTimgConfData(str);
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void setTimgConfUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65755, null, str) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().getSettingsStatics().setTimgConfUrl(str);
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void setUseLogSdk(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65756, null, z) == null) {
            mUseLogSdk = z;
        }
    }

    public static void setVideoPlayerMode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65757, null, i) == null) {
            Log.w(LOGTAG, "setVideoPlayerMode ".concat(String.valueOf(i)));
            try {
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().getSettingsStatics().setVideoPlayerMode(i);
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void setWebessenseEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65758, null, z) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().getSettingsStatics().setWebessenseEnabled(z);
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void setWhiteAndBlackList(String str, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65759, null, str, jSONArray) == null) {
            mWhiteAndBlackList.put(str, jSONArray);
            if ("false".equals(GetCloudSettingsValue(KEY_GUM_WHITE_LIST)) || !KEY_GUM_WHITE_LIST.equals(str)) {
                return;
            }
            for (String str2 : getWhiteAndBlackList(str)) {
                if (Uri.parse(str2).getHost().endsWith(".baidu.com")) {
                    mGetUserMediaConfirmed.put(str2, Boolean.TRUE);
                    Log.i(LOGTAG, "adding gum white list: ".concat(String.valueOf(str2)));
                }
            }
        }
    }

    public static void setWhiteAndBlackListToNative(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65760, null, str) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().getSettingsStatics().setWhiteAndBlackList(str);
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void setWormholeEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65761, null, z) == null) {
            try {
                Log.w(LOGTAG, "setWormholeEnabled ".concat(String.valueOf(z)));
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().getSettingsStatics().setWormholeEnabled(z);
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void setZeusManagerPkgName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65762, null, str) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().getSettingsStatics().setZeusManagerPkgName(str);
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static boolean shouldAccessNetworkOverSpdy(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65763, null, str)) == null) {
            try {
                if (WebViewFactory.hasProvider()) {
                    return WebViewFactory.getProvider().getSettingsStatics().shouldAccessNetworkOverSpdy(str);
                }
                return false;
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                return false;
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean shouldBockFrequentCrash() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65764, null)) == null) {
            if (GetCloudSettingsValue("frequent_crash_block") == null || !GetCloudSettingsValue("frequent_crash_block").equals("false")) {
                return true;
            }
            Log.i(LOGTAG, "frequent crash block disabled.");
            return false;
        }
        return invokeV.booleanValue;
    }

    public static void shouldReLoadHttpDns(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65765, null, str) == null) || str == null) {
            return;
        }
        try {
            if (str.equals("false")) {
                if (GetCloudSettingsValue(ETAG.KEY_HTTP_DNS_ENABLE) == null || !GetCloudSettingsValue(ETAG.KEY_HTTP_DNS_ENABLE).equals("false")) {
                    HttpDnsCache.tryToUpdateHttpDnsCache(WebKitFactory.getContext());
                }
            }
        } catch (Throwable th) {
            Log.w(LOGTAG, "shouldReLoadHttpDns error ".concat(String.valueOf(th)));
        }
    }

    public static Boolean shouldUploadResponseBySmartDetector(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65766, null, str)) == null) {
            try {
                String host = new URL(str).getHost();
                if (GetCloudSettingsValue("smart_detector_white_hosts") != null) {
                    String[] split = GetCloudSettingsValue("smart_detector_white_hosts").split(";");
                    for (int i = 0; i < split.length; i++) {
                        if (!"".equals(split[i]) && host.indexOf(split[i]) >= 0) {
                            Log.d(LOGTAG, "url : " + str + " match white host: " + split[i]);
                            return Boolean.TRUE;
                        }
                    }
                }
            } catch (MalformedURLException e2) {
                e2.printStackTrace();
            }
            return Boolean.FALSE;
        }
        return (Boolean) invokeL.objValue;
    }

    public static String stripQueryAndAnchor(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65767, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            int indexOf = str.indexOf("?");
            if (indexOf < 0) {
                indexOf = str.indexOf("#");
            }
            return indexOf > 0 ? str.substring(0, indexOf) : str;
        }
        return (String) invokeL.objValue;
    }

    public static void updateCloudSettingsToEngine() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65768, null) == null) {
            try {
                Log.w(LOGTAG, "updateCloudSettingsToEngine1");
                if (mCloudSettings != null) {
                    setCloudSettingsToT5(mCloudSettings);
                }
            } catch (Throwable th) {
                Log.w(LOGTAG, "setCloudSettings to zeus error ".concat(String.valueOf(th)));
            }
        }
    }

    public static void updateFixAdblockLevelInfo(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65769, null, str, i, i2) == null) {
            Log.i(LOGTAG, "updateFixAdblockLevelInfo host: %s, siteType: %d, level: %d  ", str, Integer.valueOf(i), Integer.valueOf(i2));
            try {
                if (WebViewFactory.hasProvider()) {
                    WebViewFactory.getProvider().getSettingsStatics().updateFixAdblockLevelInfo(str, i, i2);
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void updateHttpDns() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65770, null) == null) {
            ZeusThreadPoolUtil.execute(new Runnable() { // from class: com.baidu.webkit.internal.blink.WebSettingsGlobalBlink.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    String str;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && WebKitFactory.getNeedDownloadCloudResource() && WebSettingsGlobalBlink.getHttpDnsUpdateEnabled()) {
                        if (!WebSettingsGlobalBlink.mHttpDnsUpdated) {
                            boolean unused = WebSettingsGlobalBlink.mHttpDnsUpdated = true;
                            str = "updateHttpDns first download";
                        } else if (!WebSettingsGlobalBlink.mIsAlive) {
                            Log.i(WebSettingsGlobalBlink.LOGTAG, "updateHttpDns net background");
                            boolean unused2 = WebSettingsGlobalBlink.mHttpDnsNetChangedAfterPause = true;
                            return;
                        } else {
                            try {
                                Thread.sleep(3000L);
                            } catch (InterruptedException e2) {
                                e2.printStackTrace();
                            }
                            str = "updateHttpDns net change";
                        }
                        Log.i(WebSettingsGlobalBlink.LOGTAG, str);
                        long unused3 = WebSettingsGlobalBlink.mHttpDnsUpdateTime = System.currentTimeMillis();
                        HttpDnsCache.tryToUpdateHttpDnsCache(WebViewFactory.getContext());
                    }
                }
            });
        }
    }

    public static void uploadBuildinJsInfo(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65771, null, str, str2, str3) == null) {
            if (str2.equals("checked_by_max")) {
                setDitingMaxHit(true);
                if (!getCloudSwitchInPercentage("diting_max_upload_rate", 0.1f)) {
                    return;
                }
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", str);
                jSONObject.put("requestUrl", "buildin");
                jSONObject.put("feature", str2);
                if (str3.length() > 100) {
                    jSONObject.put("file_data", new String(Base64.encode(str3.getBytes(), 0)));
                }
                jSONObject.put("type", CommandMessage.COMMAND_SET_ACCOUNTS);
                Log.i(LOGTAG, "[diting] recordImmediately :" + jSONObject.toString());
                SessionMonitorEngine.getInstance().recordImmediately("sailor_monitor", jSONObject.toString());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void uploadMF30InitInfo(long j, long j2, long j3, long j4, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65772, null, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Boolean.valueOf(z)}) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("vm_size_in_smaps", j);
                jSONObject.put("vm_max_slice", j2);
                jSONObject.put("vm_size_available", j3);
                jSONObject.put("pm_size_available", j4);
                jSONObject.put("in_good_state", z ? 1 : 0);
                jSONObject.put("type", CommandMessage.COMMAND_UNSET_ACCOUNTS);
                sMf30InitInfo = jSONObject;
                Log.i(LOGTAG, "uploadMF30InitInfo :" + jSONObject.toString());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static boolean useCronet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65773, null)) == null) ? WebViewFactory.getProvider().getSettingsStatics().useCronet() : invokeV.booleanValue;
    }

    public static boolean useLogSdk() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65774, null)) == null) {
            String GetCloudSettingsValue = GetCloudSettingsValue("log_method");
            if (GetCloudSettingsValue != null) {
                mUseLogSdk = GetCloudSettingsValue.equals("1");
                str = "useLogSdk(), log_method=" + GetCloudSettingsValue + ", useLogSdk=" + mUseLogSdk;
            } else {
                str = "useLogSdk(), log_method is not configured, useLogSdk=" + mUseLogSdk;
            }
            Log.w(LOGTAG, str);
            return mUseLogSdk;
        }
        return invokeV.booleanValue;
    }

    public static boolean useT5Log() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65775, null)) == null) {
            String GetCloudSettingsValue = GetCloudSettingsValue("log_method");
            if (GetCloudSettingsValue != null) {
                mUseT5Log = GetCloudSettingsValue.equals("2") || GetCloudSettingsValue.equals("3") || GetCloudSettingsValue.equals("5");
                str = "useT5Log(), log_method=" + GetCloudSettingsValue + ", useT5Log=" + mUseT5Log;
            } else {
                str = "useT5Log(), log_method is not configured, useT5Log=" + mUseT5Log;
            }
            Log.w(LOGTAG, str);
            return mUseT5Log;
        }
        return invokeV.booleanValue;
    }
}
