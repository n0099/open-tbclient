package com.baidu.webkit.internal.blink;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.webkit.ValueCallback;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.wallet.core.Domains;
import com.baidu.webkit.internal.ABTestConstants;
import com.baidu.webkit.internal.CfgFileUtils;
import com.baidu.webkit.internal.ETAG;
import com.baidu.webkit.internal.INoProGuard;
import com.baidu.webkit.internal.daemon.HttpDnsCache;
import com.baidu.webkit.internal.daemon.QuicPreConnect;
import com.baidu.webkit.internal.daemon.ZeusThreadPoolUtil;
import com.baidu.webkit.internal.monitor.SessionMonitorEngine;
import com.baidu.webkit.internal.monitor.ZeusMonitorType;
import com.baidu.webkit.net.BdNetEngine;
import com.baidu.webkit.sdk.IABTestInterface;
import com.baidu.webkit.sdk.ICronetListenerInterface;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.VideoCloudSetting;
import com.baidu.webkit.sdk.WebKitFactory;
import com.baidu.webkit.sdk.WebSettings;
import com.baidu.webkit.sdk.WebViewFactory;
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
/* loaded from: classes5.dex */
public class WebSettingsGlobalBlink implements INoProGuard {
    public static final String CLOUD_SETTING_URL = "https://browserkernel.baidu.com/config/t5config?cmd=1&";
    public static final String DEFAULT_MULTIPROCESS_MODELS = "TRT-AL00A,TRT-AL00,TRT-TL10A,TRT-TL10,SLA-AL00,SLA-TL10,DLI-AL10,DLI-TL20,SM-C5000";
    public static final String DEFAULT_SECRECT_KEY = "SFIyRVI=";
    public static final String ENGINE_STAT_URL = "https://browserkernel.baidu.com/timing_txt/browser7_7.searchbox8_3.js.encrypt";
    public static final String FAKE_BAIDU_URL = "https://browserkernel.baidu.com/fakebaidu";
    public static final String HTTP_DNS_URL_HOST = "https://httpsdns.baidu.com/v6/0010";
    public static final String HTTP_DNS_URL_IP = "https://180.76.76.112/v6/0010";
    public static final String KEY_GUM_WHITE_LIST = "gum_white_list";
    public static final String LOGTAG = "WebSettingsGlobalBlink";
    public static final String MF_JS_URL = "https://browserkernel.baidu.com/adblock/magicfilter.js?";
    public static final String ML_MODEL_URL = "https://browserkernel.baidu.com/ml_model/";
    public static final int MP_MIN_AVAILABLE_MEMORY = 500;
    public static final int MP_SDK_MAX = 29;
    public static final int MP_SDK_MIN = 21;
    public static final int MP_SDK_PUBLISH_MAX = 29;
    public static final int MP_SDK_PUBLISH_MIN = 26;
    public static final String PAC_URL = "https://browserkernel.baidu.com/newpac31/spdy.conf.txt";
    public static final String SAILOR_URL_SAFE_CHECK_CLOUD_SWITCH = "searchbox_urlsafe_switch_pr";
    public static final int SAILOR_URL_SAFE_CHECK_CLOUD_SWITCH_CLOSE = 0;
    public static final int SAILOR_URL_SAFE_CHECK_CLOUD_SWITCH_OPEN = 1;
    public static final String SESSION_UPLOAD_URL = "https://browserkernel.baidu.com/kw?r_en=true&type=";
    public static final String SETTING_IMPL_CLASS = "com.baidu.blink.WebSettingsGlobalProxy";
    public static final String SKELENTON_JS_URL = "https://browserkernel.baidu.com/skeleton/collect_link.js?";
    public static final String ZEUS_RESOURCE_URL = "https://browserkernel.baidu.com/integration.php";
    public static int httpDnsSource = 0;
    public static String mBrowserVersion = null;
    public static boolean mChromiumNetInit = false;
    public static String mCloudSettings = null;
    public static final String mDateFomat = "yyyy-MM-dd HH:mm:ss";
    public static boolean mDoubleLogEnabled;
    public static boolean mFirstGetLogEnable;
    public static boolean mHijackEnv;
    public static boolean mHttpDnsNetChangedAfterPause;
    public static long mHttpDnsUpdateTime;
    public static boolean mHttpDnsUpdated;
    public static boolean mIpv6HttpdnsEnv;
    public static boolean mLogEnable;
    public static boolean mLogsdkEnabled;
    public static long mQuicCheckTime;
    public static boolean mQuicDefaultOpen;
    public static boolean mQuicInit;
    public static boolean mSessionDataEnable;
    public static long mSoHandler;
    public static boolean mUseLogSdk;
    public static boolean mUseT5Log;
    public static HashSet<String> sBlackListModels;
    public static HashSet<String> sDeviceSet;
    public static boolean sDitingMaxHit;
    public static JSONObject sMf30InitInfo;
    public static Boolean sMultiprocessEnabled;
    public static long sNativeV8FunctionTablePointer;
    public static int zeusNetLogLevel;
    public static boolean zeusNetLogLevelSetted;
    public static Map<String, String> mCloudSettingsMap = new HashMap();
    public static Map<String, String> mHttpDnsCacheMap = new HashMap();
    public static HashMap<String, Boolean> mGetUserMediaConfirmed = new HashMap<>();
    public static Map<String, JSONArray> mWhiteAndBlackList = new HashMap();
    public static final List<ValueCallback<Long>> sOnCronetThreadInitializedListenerList = new ArrayList();
    public static WebSettings.ProxyType mProxyType = WebSettings.ProxyType.SPDYANDOVERSEAS_PROXY;
    public static boolean mCronetEnable = true;
    public static boolean mIsAlive = true;
    public static Object mSelfLock = new Object();
    public static long mTotalMem = 2048;
    public static String SFSWITCH = VideoCloudSetting.PREF_KEY_SPRING_FESTIVAL_SWITCH;
    public static String SFSWITCH_VALUE_OPEN = "true";
    public static String PREF_NAME_MULTIPROCESS = "zeus_preferences_multiprocess";
    public static String PREF_KEY_RENDER_CRASHES = "zeus_render_crashes";
    public static String PREF_KEY_MULTIPROCESS_DISABLED = "zeus_multiprocess_disabled";
    public static long RENDER_CRASH_LOG_TIMEOUT = 3600000;
    public static int MAX_RENDER_CRASH_COUNT = 3;

    public static String GetCloudSettingsValue(String str) {
        String str2;
        synchronized (mSelfLock) {
            str2 = mCloudSettingsMap.get(str);
        }
        return str2;
    }

    public static boolean GetHttpDnsCache(String str) {
        return false;
    }

    public static void addOnCronetThreadInitializedListener(ValueCallback<Long> valueCallback) {
        Log.i(LOGTAG, "addOnCronetThreadInitializedListener. listener=%s, list size=%d", valueCallback, Integer.valueOf(sOnCronetThreadInitializedListenerList.size()));
        synchronized (sOnCronetThreadInitializedListenerList) {
            if (sNativeV8FunctionTablePointer != 0) {
                valueCallback.onReceiveValue(Long.valueOf(sNativeV8FunctionTablePointer));
            } else {
                sOnCronetThreadInitializedListenerList.add(valueCallback);
            }
        }
    }

    public static void addPreConnectPrefixes(String str) {
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

    public static boolean canUseFreeFlow() {
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

    public static void checkHttpDnsUpdate() {
        if (WebKitFactory.getNeedDownloadCloudResource() && getHttpDnsUpdateEnabled()) {
            int i2 = 3600;
            String GetCloudSettingsValue = GetCloudSettingsValue("httpdns_check_interval");
            if (GetCloudSettingsValue != null && !GetCloudSettingsValue.isEmpty()) {
                try {
                    i2 = Integer.parseInt(GetCloudSettingsValue);
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                }
            }
            Log.i(LOGTAG, "defaultHttpDnsInterval ".concat(String.valueOf(i2)));
            if (System.currentTimeMillis() - mHttpDnsUpdateTime > i2 * 1000) {
                mHttpDnsUpdateTime = System.currentTimeMillis();
                HttpDnsCache.tryToUpdateHttpDnsCacheStaticIP(WebViewFactory.getContext());
            }
        }
    }

    public static boolean checkPrefetchResourceByFilter() {
        IABTestInterface abTestInterface = WebViewFactory.getAbTestInterface();
        if (abTestInterface != null) {
            boolean z = abTestInterface.getSwitch(ABTestConstants.CHECK_PREFETCH_BY_ADFILTER, false);
            Log.i(LOGTAG, "[maqian04-prefetch-filter] AbTestValue checkPrefetchByFilterEnable = ".concat(String.valueOf(z)));
            return z;
        }
        return false;
    }

    public static void checkQuicConnection() {
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

    public static void chromiumNetInit(long j) {
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

    public static void clearNetworkFlow() {
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

    public static void clearSavingBytes() {
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

    public static long generateBKDRHash(String str) {
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

    public static String getAbtestStringValue(String str) {
        IABTestInterface abTestInterface = WebViewFactory.getAbTestInterface();
        if (abTestInterface != null) {
            String str2 = abTestInterface.getSwitch(str, "");
            Log.d(LOGTAG, "getAbtestStringValue: " + abTestInterface.getRawSwitch().toString());
            return str2;
        }
        return "";
    }

    public static String getAppId() {
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

    public static int getBackupDnsJobDelayTime() {
        IABTestInterface abTestInterface = WebViewFactory.getAbTestInterface();
        if (abTestInterface != null) {
            int i2 = abTestInterface.getSwitch(ABTestConstants.BACKUP_DNS_JOB_DELAY_TIME, -1);
            Log.i(LOGTAG, "getBackupDnsJobDelayTime ".concat(String.valueOf(i2)));
            return i2;
        }
        try {
            String str = CfgFileUtils.get(CfgFileUtils.KEY_BACK_DNS_TIME, "-1");
            Log.i(LOGTAG, "getBackupDnsJobDelayTime listener null ".concat(String.valueOf(str)));
            return Integer.parseInt(str);
        } catch (Exception e2) {
            Log.e(LOGTAG, "getBackupDnsJobDelayTime error: ".concat(String.valueOf(e2)));
            return -1;
        }
    }

    public static String getBrowserVersion() {
        return mBrowserVersion;
    }

    public static long getChromiumHandle() {
        return mSoHandler;
    }

    public static boolean getChromiunNetInit() {
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

    public static String getCloudHost() {
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

    public static String getCloudSettingUrl() {
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

    public static boolean getCloudSwitchInPercentage(String str, float f2) {
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

    public static int getCodeCacheSizeByAbTest() {
        IABTestInterface abTestInterface = WebViewFactory.getAbTestInterface();
        if (abTestInterface != null) {
            return abTestInterface.getSwitch(ABTestConstants.CODECACHE_SIZE_KEY, 0);
        }
        return 0;
    }

    public static boolean getCronetEnable() {
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

    public static String getCuid() {
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

    public static String getDNSStatistic() {
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

    public static boolean getDitingMaxForceLoadSwitch() {
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

    public static boolean getDitingMaxHit() {
        return sDitingMaxHit;
    }

    public static String getDnsInfo(String str) {
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

    public static String getDnsInfoEngine(String str) {
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

    public static boolean getDoubleLogEnabled() {
        return mDoubleLogEnabled;
    }

    public static int getDownTraffic() {
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

    public static boolean getEnableEngineStat() {
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

    public static boolean getEnableProxy() {
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

    public static boolean getEnableRetryQuicPreconnect() {
        IABTestInterface abTestInterface = WebViewFactory.getAbTestInterface();
        if (abTestInterface != null) {
            boolean z = abTestInterface.getSwitch(ABTestConstants.RETRY_QUIC_PRECONNECT_KEY, false);
            Log.i(LOGTAG, "QuicPreconnect getEnableRetryQuicPreconnect enable = ".concat(String.valueOf(z)));
            return z;
        }
        return false;
    }

    public static boolean getEnableSpdy() {
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

    public static boolean getEnableZeusManager() {
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

    public static String getEngineStatUrl() {
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

    public static String getFakeBaiduUrl() {
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

    public static Boolean getGetUserMediaConfirmed(String str) {
        String stripQueryAndAnchor = stripQueryAndAnchor(str);
        return (mGetUserMediaConfirmed.containsKey(stripQueryAndAnchor) && mGetUserMediaConfirmed.get(stripQueryAndAnchor).booleanValue()) ? Boolean.TRUE : Boolean.FALSE;
    }

    public static boolean getGifOneFrameEnabled() {
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

    public static boolean getHijackEnv() {
        return mHijackEnv;
    }

    public static boolean getHttp2Enabled() {
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

    public static String getHttpCode() {
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

    public static String getHttpDnsCache() {
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

    public static int getHttpDnsSource() {
        return httpDnsSource;
    }

    public static boolean getHttpDnsUpdateEnabled() {
        try {
            return CfgFileUtils.get(CfgFileUtils.KEY_HTTPDNS_AB_STAT, true);
        } catch (Throwable th) {
            Log.e(LOGTAG, "getHttpDnsUpdateEnabled error:".concat(String.valueOf(th)));
            return false;
        }
    }

    public static String getHttpDnsUrlHOST() {
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

    public static String getHttpDnsUrlIP() {
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

    public static HttpURLConnection getHttpUrlConnection(String str) {
        return WebViewFactory.getProvider().getSettingsStatics().getHttpUrlConnection(str);
    }

    public static WebSettings.ImgQuality getImgQuality() {
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

    public static boolean getInNovelSiteList(String str) {
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

    public static boolean getInVideoSiteList(String str) {
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

    public static int getInspectorKernelSupport() {
        return 0;
    }

    public static boolean getIpv6Env() {
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

    public static boolean getIpv6HttpdnsEnv() {
        try {
            boolean z = CfgFileUtils.get(CfgFileUtils.KEY_HTTP_DNS_IPV6_ENV, false);
            Log.i(LOGTAG, "getIpv6HttpdnsEnv ".concat(String.valueOf(z)));
            return z;
        } catch (Exception e2) {
            Log.e(LOGTAG, "getIpv6HttpdnsEnv error: ".concat(String.valueOf(e2)));
            return false;
        }
    }

    public static int getKeepAliveTime() {
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

    public static int getKeepAliveTimeNative() {
        IABTestInterface abTestInterface = WebViewFactory.getAbTestInterface();
        if (abTestInterface != null) {
            int i2 = abTestInterface.getSwitch(CfgFileUtils.KEY_KEEP_ALIVE_TIME, 63);
            Log.i(LOGTAG, "getKeepAliveTime1 ".concat(String.valueOf(i2)));
            return i2;
        }
        try {
            String str = CfgFileUtils.get(CfgFileUtils.KEY_KEEP_ALIVE_TIME, "-1");
            Log.i(LOGTAG, "getKeepAliveTime1 listener null ".concat(String.valueOf(str)));
            return Integer.parseInt(str);
        } catch (Exception e2) {
            Log.e(LOGTAG, "getKeepAliveTime error: ".concat(String.valueOf(e2)));
            return -1;
        }
    }

    public static Context getKernelContext() {
        return WebViewFactory.getProvider().getSettingsStatics().getKernelContext();
    }

    public static int getLevelInfo(String str) {
        int i2 = -1;
        try {
            if (WebViewFactory.hasProvider()) {
                i2 = WebViewFactory.getProvider().getSettingsStatics().getLevelInfo(str);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        Log.i(LOGTAG, "getLevelInfo host: %s, level: %d", str, Integer.valueOf(i2));
        return i2;
    }

    public static String getLocalDns() {
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

    public static int getLogLevel() {
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

    public static boolean getLogsdkEnabled() {
        return mLogsdkEnabled;
    }

    public static boolean getMF30Inited() {
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

    public static String getMLModelUrl() {
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

    public static String getMainFrameIdInfo(int i2) {
        try {
            return WebViewFactory.hasProvider() ? WebViewFactory.getProvider().getSettingsStatics().getMainFrameIdInfo(i2) : "";
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return "";
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String getMainFrameIdReferrer(int i2) {
        try {
            return WebViewFactory.hasProvider() ? WebViewFactory.getProvider().getSettingsStatics().getMainFrameIdReferrer(i2) : "";
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return "";
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static int getMainHttpCacheSizeByAbTest() {
        IABTestInterface abTestInterface = WebViewFactory.getAbTestInterface();
        if (abTestInterface != null) {
            return abTestInterface.getSwitch(ABTestConstants.MAIN_HTTPCACHE_SIZE_KEY, -1);
        }
        return -1;
    }

    public static boolean getMainLinkDirectEnabled() {
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

    public static JSONObject getMf30InitInfo() {
        return sMf30InitInfo;
    }

    public static String getMfJsUrl() {
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

    public static int getNQE() {
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

    public static boolean getNativeHttpdnsEnabled() {
        IABTestInterface abTestInterface = WebViewFactory.getAbTestInterface();
        if (abTestInterface != null) {
            boolean z = abTestInterface.getSwitch("native_httpdns_enabled", false);
            Log.i(LOGTAG, "getNativeHttpdnsEnabled ".concat(String.valueOf(z)));
            return z;
        }
        try {
            boolean z2 = CfgFileUtils.get("native_httpdns_enabled", false);
            Log.i(LOGTAG, "getNativeHttpdnsEnabled listener null ".concat(String.valueOf(z2)));
            return z2;
        } catch (Exception e2) {
            Log.e(LOGTAG, "getNativeHttpdnsEnabled error: ".concat(String.valueOf(e2)));
            return false;
        }
    }

    public static int getNetworkFlow() {
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

    public static int getNetworkRtt() {
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

    public static int getNetworkSpeed() {
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

    public static boolean getOnePacketEnabled() {
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

    public static boolean getPFLogEnabled() {
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

    public static String getPacUrl() {
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

    public static boolean getPageCacheEnabled() {
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

    public static String getPageFeature(String str) {
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

    public static String getPageWormHoleErrors() {
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

    public static int getPopupWindowNum() {
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

    public static boolean getPreconnectABTestEnable() {
        IABTestInterface abTestInterface = WebViewFactory.getAbTestInterface();
        if (abTestInterface != null) {
            boolean z = abTestInterface.getSwitch(ABTestConstants.ENABLE_QUIC_PRECONNECT_KEY, false);
            Log.i(LOGTAG, "QuicPreconnect getPreconnectABTestEnable enable = ".concat(String.valueOf(z)));
            return z;
        }
        return false;
    }

    public static boolean getPrecreateContentCacheSwitch() {
        IABTestInterface abTestInterface = WebViewFactory.getAbTestInterface();
        if (abTestInterface != null) {
            return abTestInterface.getSwitch(ABTestConstants.PRECREATE_CONTENT_CACHE_KEY, false);
        }
        return false;
    }

    public static String getProxyInfo() {
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

    public static WebSettings.ProxyType getProxyType() {
        return mProxyType;
    }

    public static String getQuicHost() {
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

    public static String getQuicInfo() {
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

    public static int getQuicThreshold() {
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

    public static String getRc4SecrectKey() {
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

    public static WebSettings.RemoveAdLevel getRemoveAdLevel() {
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

    public static int getSavingBytes() {
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

    public static int getSearchDnsMiss() {
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

    public static boolean getSendEngineUsageInfoEnabled() {
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

    public static boolean getSendRequestEnabled() {
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

    public static boolean getSessionHeaderEnabled() {
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

    public static String getSessionUploadUrl() {
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

    public static int getSiteTypeInfo(String str) {
        int i2 = -1;
        try {
            if (WebViewFactory.hasProvider()) {
                i2 = WebViewFactory.getProvider().getSettingsStatics().getSiteTypeInfo(str);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        Log.i(LOGTAG, "getSiteTypeInfo host: %s, siteType: %d", str, Integer.valueOf(i2));
        return i2;
    }

    public static String getSkeletonJsUrl() {
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

    public static int getSocketGroupNumber() {
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

    public static int getSocketGroupNumberNative() {
        IABTestInterface abTestInterface = WebViewFactory.getAbTestInterface();
        if (abTestInterface != null) {
            int i2 = abTestInterface.getSwitch("socket_group_number", -1);
            Log.i(LOGTAG, "getSocketGroupNumberNative ".concat(String.valueOf(i2)));
            return i2;
        }
        try {
            String str = CfgFileUtils.get("socket_group_number", "-1");
            Log.i(LOGTAG, "getSocketGroupNumberNative listener null ".concat(String.valueOf(str)));
            return Integer.parseInt(str);
        } catch (Exception e2) {
            Log.e(LOGTAG, "getSocketGroupNumberNative error: ".concat(String.valueOf(e2)));
            return -1;
        }
    }

    public static boolean getSpdy31Enabled() {
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

    public static boolean getSpdyCompressEnabled() {
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

    public static boolean getSpdyEncryptionEnabled() {
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

    public static boolean getSubResourceMonitorEnabled() {
        String GetCloudSettingsValue = GetCloudSettingsValue("sub_resource_monitor");
        return GetCloudSettingsValue == null || !GetCloudSettingsValue.equals("false");
    }

    public static String getSubResourceTiming() {
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

    public static int getSwanHttpCacheSizeByAbTest() {
        IABTestInterface abTestInterface = WebViewFactory.getAbTestInterface();
        if (abTestInterface != null) {
            return abTestInterface.getSwitch(ABTestConstants.SWAN_HTTPCACHE_SIZE_KEY, -1);
        }
        return -1;
    }

    public static boolean getSysProxyEnabled() {
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

    public static String getTimgConfUrl() {
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

    public static int getUnusedIdleSocketTimeout() {
        IABTestInterface abTestInterface = WebViewFactory.getAbTestInterface();
        if (abTestInterface != null) {
            int i2 = abTestInterface.getSwitch(ABTestConstants.UNUSED_IDLE_SOCKET_TIMEOUT_KEY, 0);
            Log.i(LOGTAG, "T7-preconnect getUnusedIdleSocketTimeout AbTestValue = ".concat(String.valueOf(i2)));
            return i2;
        }
        return 0;
    }

    public static int getUpTraffic() {
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

    public static boolean getWatchVirtualMemory() {
        IABTestInterface abTestInterface = WebViewFactory.getAbTestInterface();
        if (abTestInterface != null) {
            return abTestInterface.getSwitch(ABTestConstants.WATCH_VIRTUAL_MEMORY_KEY, true);
        }
        return true;
    }

    public static int getWeakNetOptAbtestSwitch() {
        IABTestInterface abTestInterface = WebViewFactory.getAbTestInterface();
        if (abTestInterface != null) {
            int i2 = abTestInterface.getSwitch(ABTestConstants.WEAK_NET_OPT_SWITCH_KEY, 0);
            Log.d(LOGTAG, "[WEAK_NET_OPT] switch value: " + abTestInterface.getRawSwitch().toString());
            return i2;
        }
        return 0;
    }

    public static boolean getWebessenseEnabled() {
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

    public static List<String> getWhiteAndBlackList(String str) {
        JSONArray jSONArray = mWhiteAndBlackList.get(str);
        if (jSONArray != null) {
            try {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    arrayList.add(jSONArray.getString(i2));
                }
                return arrayList;
            } catch (JSONException e2) {
                Log.w(LOGTAG, "parserData JSONTokener error ".concat(String.valueOf(e2)));
                return null;
            }
        }
        return null;
    }

    public static boolean getWormholeEnabled() {
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

    public static String getWormholeForbidenHost() {
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

    public static int getWormholeNum(int i2) {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getWormholeNum(i2);
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

    public static String getZeusManagerPkgName() {
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

    public static int getZeusNetLogLevel() {
        if (WebViewFactory.isMainAppProcess()) {
            if (zeusNetLogLevelSetted) {
                return zeusNetLogLevel;
            }
            IABTestInterface abTestInterface = WebViewFactory.getAbTestInterface();
            if (abTestInterface != null) {
                zeusNetLogLevel = abTestInterface.getSwitch(ABTestConstants.ZEUS_NET_LOG_LEVEL_KEY, 0);
                zeusNetLogLevelSetted = true;
                Log.i(LOGTAG, "[huqin-netlog-level] zeus_net_log_level AbTestValue = " + zeusNetLogLevel);
                return zeusNetLogLevel;
            }
            return 0;
        }
        return -1;
    }

    public static int getZeusPageJumpJudge() {
        IABTestInterface abTestInterface = WebViewFactory.getAbTestInterface();
        if (abTestInterface != null) {
            int i2 = abTestInterface.getSwitch(ABTestConstants.ZEUS_PAGE_JUMP_JUDGE, 1);
            Log.i(LOGTAG, "[debug] getZeusPageJumpJudge AbTestValue = ".concat(String.valueOf(i2)));
            return i2;
        }
        return 1;
    }

    public static boolean getZeusPsLogSerializationEnable() {
        IABTestInterface abTestInterface = WebViewFactory.getAbTestInterface();
        if (abTestInterface != null) {
            boolean z = abTestInterface.getSwitch(ABTestConstants.ZEUS_PS_SERIALIZATION_KEY, false);
            Log.i(LOGTAG, "[debug] getZeusPsLogSerializationEnable AbTestValue = ".concat(String.valueOf(z)));
            return z;
        }
        return false;
    }

    public static int getZeusPsLogUploadServer() {
        IABTestInterface abTestInterface = WebViewFactory.getAbTestInterface();
        if (abTestInterface != null) {
            int i2 = abTestInterface.getSwitch(ABTestConstants.ZEUS_PS_LOG_UPLOAD_SERVER, 0);
            Log.i(LOGTAG, "[debug] getZeusPsLogUploadServer AbTestValue = ".concat(String.valueOf(i2)));
            return i2;
        }
        return 0;
    }

    public static int getZeusPsSwitch() {
        IABTestInterface abTestInterface = WebViewFactory.getAbTestInterface();
        if (abTestInterface != null) {
            int i2 = abTestInterface.getSwitch(ABTestConstants.ZEUS_PS_KEY, 1);
            Log.i(LOGTAG, "[debug] getZeusPsSwitch AbTestValue = ".concat(String.valueOf(i2)));
            return i2;
        }
        return 1;
    }

    public static int getZeusPsUploadDelay() {
        IABTestInterface abTestInterface = WebViewFactory.getAbTestInterface();
        if (abTestInterface != null) {
            int i2 = abTestInterface.getSwitch(ABTestConstants.ZEUS_PS_UPLOAD_DELAY_KEY, 3);
            Log.i(LOGTAG, "[debug] getZeusPsUploadDelay AbTestValue = ".concat(String.valueOf(i2)));
            return i2;
        }
        return 3;
    }

    public static int getZeusResourceRecordType() {
        IABTestInterface abTestInterface = WebViewFactory.getAbTestInterface();
        if (abTestInterface != null) {
            int i2 = abTestInterface.getSwitch(ABTestConstants.ZEUS_RESOURCE_RECORD_TYPE_KEY, 0);
            Log.i(LOGTAG, "[debug] getZeusResourceRecordType AbTestValue = ".concat(String.valueOf(i2)));
            return i2;
        }
        return 0;
    }

    public static String getZeusResourceUrl() {
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

    public static boolean hasQuicAltService(String str) {
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

    public static void initCronet(Context context) {
        WebViewFactory.getProvider().getSettingsStatics().initCronet(context);
    }

    public static void initNet() {
        Log.e(LOGTAG, "initNet1");
        if (WebKitFactory.getCurEngine() == 1 && WebViewFactory.hasProvider()) {
            Log.e(LOGTAG, "initNet2");
            WebViewFactory.getProvider().initNet();
            Log.e(LOGTAG, "initNet3");
        }
    }

    public static boolean isBlackListedDevice() {
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
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    if (isMatchedDevice((JSONObject) jSONArray.get(i2))) {
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

    public static boolean isEffectiveDate(Date date, Date date2, Date date3) {
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

    public static boolean isFeedNoProxyAdUrl(String str) {
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

    public static boolean isFeedProxyAdUrl(String str) {
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

    public static boolean isInvisibleFixedEnable() {
        IABTestInterface abTestInterface = WebViewFactory.getAbTestInterface();
        if (abTestInterface != null) {
            boolean z = abTestInterface.getSwitch(ABTestConstants.INVISIBLE_FIXED_KEY, true);
            Log.i(LOGTAG, "WhiteScreen AbTestValue isInvisibleFixedEnable = ".concat(String.valueOf(z)));
            return z;
        }
        return false;
    }

    public static boolean isMatchedDevice(JSONObject jSONObject) throws JSONException {
        android.util.Log.d(LOGTAG, "isMatchedDevice, rule=".concat(String.valueOf(jSONObject)));
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            jSONObject.getString(next);
            if ("manufacturer".equals(next)) {
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

    public static boolean isMultiProcessEnabled() {
        String str;
        String str2;
        Boolean bool;
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
                int i2 = Build.VERSION.SDK_INT;
                if (i2 < 21 || i2 > 29) {
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
                        int i3 = Build.VERSION.SDK_INT;
                        if (i3 < 26 || i3 > 29) {
                            str = "multiprocess not published for current SDK version";
                        } else {
                            try {
                                if (GetCloudSettingsValue(ABTestConstants.MULTIPLE_PROCESS_KEY) != null && GetCloudSettingsValue(ABTestConstants.MULTIPLE_PROCESS_KEY).equals("false")) {
                                    Log.i(LOGTAG, "multiprocess cloud settings off");
                                    sMultiprocessEnabled = Boolean.FALSE;
                                    return false;
                                }
                            } catch (Throwable th) {
                                Log.w(LOGTAG, "isMultiProcessEnabled error ".concat(String.valueOf(th)));
                            }
                            if (WebViewFactory.getAbTestInterface() == null) {
                                str = "multiprocess AbTestInterface not set";
                            } else if (WebViewFactory.getAbTestInterface().getSwitch(ABTestConstants.MULTIPLE_PROCESS_KEY, false)) {
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

    public static boolean isSFSwitchEnabled() {
        String GetCloudSettingsValue = GetCloudSettingsValue(SFSWITCH);
        return !TextUtils.isEmpty(GetCloudSettingsValue) && GetCloudSettingsValue.equalsIgnoreCase(SFSWITCH_VALUE_OPEN);
    }

    public static boolean isSessionDataEnable() {
        String str;
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

    public static boolean isShowWebProviderBy() {
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

    public static boolean isWebViewMonitorEnabled() {
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

    public static boolean isWhiteListedDevice() {
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

    public static ByteBuffer kernelBrotliCreate(long[] jArr) {
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

    public static void kernelBrotliDestroy(long[] jArr) {
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

    public static ByteBuffer kernelBrotliPull(long[] jArr) {
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

    public static void kernelBrotliPush(long[] jArr, int i2) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().kernelBrotliPush(jArr, i2);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void kernelEncrypt(byte[] bArr, int i2, byte[] bArr2) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().kernelEncrypt(bArr, i2, bArr2);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void kernelLog(String str, String str2) {
        if (!mFirstGetLogEnable && WebKitFactory.getCurEngine() == 1) {
            mLogEnable = getPFLogEnabled();
            Log.i(LOGTAG, "mLogEnable " + mLogEnable);
            mFirstGetLogEnable = true;
        }
        if (mLogEnable) {
            Log.i(str, str2);
        }
    }

    public static void notifyAllOnCronetThreadInitializedListener(long j) {
        Log.i(LOGTAG, "NotifyAllOnCronetThreadInitializedListener. nativeTablePointer=%d, list size=%d", Long.valueOf(j), Integer.valueOf(sOnCronetThreadInitializedListenerList.size()));
        synchronized (sOnCronetThreadInitializedListenerList) {
            sNativeV8FunctionTablePointer = j;
            for (ValueCallback<Long> valueCallback : sOnCronetThreadInitializedListenerList) {
                valueCallback.onReceiveValue(Long.valueOf(j));
            }
            sOnCronetThreadInitializedListenerList.clear();
        }
    }

    public static void notifyBdAppStatusChange(int i2) {
        Log.e(LOGTAG, "notifyBdAppStatusChange ".concat(String.valueOf(i2)));
        WebViewFactory.getProvider().getSettingsStatics().notifyBdAppStatusChange(i2);
    }

    public static void notifyPause() {
        mHttpDnsNetChangedAfterPause = false;
        mIsAlive = false;
        setAppStatus(false);
    }

    public static void notifyResume() {
        mIsAlive = true;
        setAppStatus(true);
        if (WebKitFactory.getNeedDownloadCloudResource() && mHttpDnsNetChangedAfterPause && getHttpDnsUpdateEnabled()) {
            mHttpDnsUpdateTime = System.currentTimeMillis();
            Log.i(LOGTAG, "notifyResume tryToUpdateHttpDnsCache");
            HttpDnsCache.tryToUpdateHttpDnsCache(WebViewFactory.getContext());
        }
    }

    public static void onZeusEnableWillChange(String str, String str2) {
        boolean z = false;
        if ((str == null || str.length() == 0 || str.toLowerCase().equals("true")) != ((str2 == null || str2.length() == 0 || str2.toLowerCase().equals("true")) ? true : true)) {
            EngineManager.getInstance().setNeedKillProcess(true);
        }
    }

    public static boolean recordRenderCrash() {
        String[] split;
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
                int i2 = 1;
                for (String str : string.split(",")) {
                    if (currentTimeMillis - Long.parseLong(str, 10) < RENDER_CRASH_LOG_TIMEOUT) {
                        i2++;
                        sb.append(",");
                        sb.append(str);
                    }
                }
                Log.d(LOGTAG, "  recent crash count: ".concat(String.valueOf(i2)));
                if (i2 >= MAX_RENDER_CRASH_COUNT) {
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

    public static void removeDnsInfo(String str) {
        try {
            removeDnsInfoEngine(Uri.parse(str).getHost());
        } catch (Throwable th) {
            Log.w(LOGTAG, "removeDnsInfo error ".concat(String.valueOf(th)));
        }
    }

    public static void removeDnsInfoEngine(String str) {
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

    public static void removeMainFrameIdInfo(int i2) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().removeMainFrameIdInfo(i2);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void removeOnCronetThreadInitializedListener(ValueCallback<Long> valueCallback) {
        synchronized (sOnCronetThreadInitializedListenerList) {
            sOnCronetThreadInitializedListenerList.remove(valueCallback);
        }
    }

    public static void reset() {
    }

    public static void restoreHttpDnsCacheFromCfg() {
        HttpDnsCache.restoreLastCacheFromCfg();
    }

    public static void setAltService(String str) {
        CfgFileUtils.set(CfgFileUtils.KEY_ALT_SERVICE, str);
    }

    public static void setAltServiceToBlink(String str) {
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

    public static void setAppId(String str) {
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

    public static void setAppStatus(boolean z) {
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

    public static void setBackupDnsJobDelayTime(int i2) {
        try {
            Log.w(LOGTAG, "setBackupDnsJobDelayTime ".concat(String.valueOf(i2)));
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setBackupDnsJobDelayTime(i2);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void setBackupJobDelayTime(int i2) {
        try {
            Log.w(LOGTAG, "setBackupJobDelayTime ".concat(String.valueOf(i2)));
            CfgFileUtils.set(CfgFileUtils.KEY_BACK_DNS_TIME, String.valueOf(i2));
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setBackupJobDelayTime(i2);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void setBackupLandingJobDelayTime(int i2) {
        try {
            Log.w(LOGTAG, "setBackupLandingJobDelayTime ".concat(String.valueOf(i2)));
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setBackupLandingJobDelayTime(i2);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void setBrowserVersion(String str) {
        mBrowserVersion = str;
    }

    public static void setClientIP(String str) {
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

    public static void setCloudSettings(String str) {
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

    public static void setCloudSettingsToT5(String str) {
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

    public static void setConThreshold(int i2) {
        try {
            Log.w(LOGTAG, "setConThreshold ".concat(String.valueOf(i2)));
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setConThreshold(i2);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void setCronetEnable(boolean z) {
        Log.w(LOGTAG, "setCronetEnable ".concat(String.valueOf(z)));
        mCronetEnable = z;
        CfgFileUtils.set(CfgFileUtils.KEY_CRONET_AB_STAT, z);
    }

    public static void setCuid(String str) {
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

    public static void setDitingMaxEnabled(boolean z, boolean z2, boolean z3) {
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

    public static void setDitingMaxHit(boolean z) {
        sDitingMaxHit = z;
    }

    public static void setDoubleLogEnabled(boolean z) {
        Log.w(LOGTAG, "setDoubleLogEnabled ".concat(String.valueOf(z)));
        mDoubleLogEnabled = z;
    }

    public static void setEnableEngineStat(boolean z) {
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

    public static void setEnableProxy(boolean z) {
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

    public static void setEnableSpdy(boolean z) {
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

    public static void setEnableZeusManager(boolean z) {
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

    public static void setEngineStatUrl(String str) {
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

    public static void setEvilPageWhiteBlackListPath(String str) {
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

    public static void setFakeBaiduWhiteList(String str) {
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

    public static void setFastPac(String str) {
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

    public static void setFileInIOEnabled(boolean z) {
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

    public static void setFreeFlow(boolean z) {
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

    public static void setGetUserMediaConfirmed(String str, Boolean bool) {
        if (str != null) {
            mGetUserMediaConfirmed.put(stripQueryAndAnchor(str), bool);
        }
    }

    public static void setGifOneFrameEnabled(boolean z) {
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

    public static void setHijackEnv(boolean z) {
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

    public static void setHttpDnsCache(String str, int i2) {
        try {
            httpDnsSource = i2;
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setHttpDnsCache(str, i2);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void setHttpDnsDnFailed(String str) {
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

    public static void setHttpDnsUpdateEnabled(boolean z) {
        Log.w(LOGTAG, "setHttpDnsUpdateEnabled ".concat(String.valueOf(z)));
        CfgFileUtils.set(CfgFileUtils.KEY_HTTPDNS_AB_STAT, z);
    }

    public static void setIPV6CheckList(String str) {
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

    public static void setIPV6Timeout(int i2) {
        try {
            Log.w(LOGTAG, "setIPV6Timeout ".concat(String.valueOf(i2)));
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setIPV6Timeout(i2);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void setImgQuality(WebSettings.ImgQuality imgQuality) {
    }

    public static void setInPageJudgeWhiteList(boolean z, boolean z2) {
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

    public static void setIpv6First(boolean z) {
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

    public static void setIpv6HttpdnsEnv(boolean z) {
        Log.w(LOGTAG, "setIpv6HttpdnsEnv ".concat(String.valueOf(z)));
        try {
            CfgFileUtils.set(CfgFileUtils.KEY_HTTP_DNS_IPV6_ENV, z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void setKeepAliveTime(int i2) {
        try {
            Log.w(LOGTAG, "setKeepAliveTime ".concat(String.valueOf(i2)));
            CfgFileUtils.set(CfgFileUtils.KEY_KEEP_ALIVE_TIME, String.valueOf(i2));
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setKeepAliveTime(i2);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void setLogsdkEnabled(boolean z) {
        Log.w(LOGTAG, "setLogsdkEnabled ".concat(String.valueOf(z)));
        mLogsdkEnabled = z;
    }

    public static void setMLModel(String str, String str2) {
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

    public static void setMagicFilterModelSize(long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mf_size", j);
            jSONObject.put("type", ZeusMonitorType.MONITOR_TYPE_MAGICFILTER_MODEL_SIZE);
            SessionMonitorEngine.getInstance().recordImmediately("sailor_monitor", jSONObject.toString());
        } catch (Throwable th) {
            Log.printStackTrace(th);
        }
    }

    public static void setMainLinkDirectEnabled(boolean z) {
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

    public static void setMf30InitInfo(JSONObject jSONObject) {
        sMf30InitInfo = jSONObject;
    }

    public static void setMulripleConnectEnabled(boolean z) {
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

    public static void setNativeHttpdnsEnabled(boolean z) {
        try {
            Log.w(LOGTAG, "setNativeHttpdnsEnabled ".concat(String.valueOf(z)));
            CfgFileUtils.set("native_httpdns_enabled", z);
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setNativeHttpdnsEnabled(z);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void setNavigationInterceptionEnable(boolean z) {
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

    public static void setNeedDownloadCloudResource(boolean z) {
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

    public static void setNetWorkChangeNotifyEnabled(boolean z) {
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

    public static void setOnePacketEnabled(boolean z) {
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

    public static void setPacData(String str) {
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

    public static void setPacDataFreeFlow(String str) {
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

    public static void setPacUrl(String str) {
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

    public static void setPopupWindowOptEnabled(boolean z) {
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

    public static void setPreConnectEnabled(boolean z) {
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

    public static void setProxyInfo(String str, String[] strArr) {
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

    public static void setProxyType(WebSettings.ProxyType proxyType) {
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

    public static void setQuicDefaultOpen(boolean z) {
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

    public static void setQuicThreshold(int i2) {
        try {
            Log.w(LOGTAG, "setQuicThreshold ".concat(String.valueOf(i2)));
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setQuicThreshold(i2);
                if (i2 == -1 || WebViewFactory.getProvider().getSettingsStatics().getQuicInit()) {
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

    public static void setRefererPattern(String str, String str2) {
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

    public static void setRemoveAdLevel(WebSettings.RemoveAdLevel removeAdLevel) {
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

    public static void setSearchFrameQuicEnabled(boolean z) {
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

    public static void setSendEngineUsageInfoEnabled(boolean z) {
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

    public static void setSessionHeaderEnabled(boolean z) {
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

    public static void setShowWebProviderBy(boolean z) {
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

    public static void setSocketGroupNumber(int i2) {
        try {
            Log.w(LOGTAG, "setSocketGroupNumber ".concat(String.valueOf(i2)));
            CfgFileUtils.set("socket_group_number", String.valueOf(i2));
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setSocketGroupNumber(i2);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void setSpdyCompressEnabled(boolean z) {
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

    public static void setSpdyEncryptionEnabled(boolean z) {
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

    public static void setSpdyTimeout(int i2) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setSpdyTimeout(i2);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void setStatisticParam(String str) {
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

    public static void setSubResourceMonitorEnabled(boolean z) {
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

    public static void setT5SDKSpdyEnabled(boolean z) {
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

    public static void setTcSpeedUpEnabled(boolean z) {
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

    public static void setTimgConfData(String str) {
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

    public static void setTimgConfUrl(String str) {
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

    public static void setUseLogSdk(boolean z) {
        mUseLogSdk = z;
    }

    public static void setVideoPlayerMode(int i2) {
        Log.w(LOGTAG, "setVideoPlayerMode ".concat(String.valueOf(i2)));
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setVideoPlayerMode(i2);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void setWebessenseEnabled(boolean z) {
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

    public static void setWhiteAndBlackList(String str, JSONArray jSONArray) {
        mWhiteAndBlackList.put(str, jSONArray);
        if ("false".equals(GetCloudSettingsValue(KEY_GUM_WHITE_LIST)) || !KEY_GUM_WHITE_LIST.equals(str)) {
            return;
        }
        for (String str2 : getWhiteAndBlackList(str)) {
            if (Uri.parse(str2).getHost().endsWith(Domains.BAIDU)) {
                mGetUserMediaConfirmed.put(str2, Boolean.TRUE);
                Log.i(LOGTAG, "adding gum white list: ".concat(String.valueOf(str2)));
            }
        }
    }

    public static void setWhiteAndBlackListToNative(String str) {
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

    public static void setWormholeEnabled(boolean z) {
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

    public static void setZeusManagerPkgName(String str) {
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

    public static boolean shouldAccessNetworkOverSpdy(String str) {
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

    public static boolean shouldBockFrequentCrash() {
        if (GetCloudSettingsValue("frequent_crash_block") == null || !GetCloudSettingsValue("frequent_crash_block").equals("false")) {
            return true;
        }
        Log.i(LOGTAG, "frequent crash block disabled.");
        return false;
    }

    public static void shouldReLoadHttpDns(String str) {
        if (str != null) {
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
    }

    public static Boolean shouldUploadResponseBySmartDetector(String str) {
        try {
            String host = new URL(str).getHost();
            if (GetCloudSettingsValue("smart_detector_white_hosts") != null) {
                String[] split = GetCloudSettingsValue("smart_detector_white_hosts").split(";");
                for (int i2 = 0; i2 < split.length; i2++) {
                    if (!"".equals(split[i2]) && host.indexOf(split[i2]) >= 0) {
                        Log.d(LOGTAG, "url : " + str + " match white host: " + split[i2]);
                        return Boolean.TRUE;
                    }
                }
            }
        } catch (MalformedURLException e2) {
            e2.printStackTrace();
        }
        return Boolean.FALSE;
    }

    public static String stripQueryAndAnchor(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int indexOf = str.indexOf("?");
        if (indexOf < 0) {
            indexOf = str.indexOf("#");
        }
        return indexOf > 0 ? str.substring(0, indexOf) : str;
    }

    public static void updateCloudSettingsToEngine() {
        try {
            Log.w(LOGTAG, "updateCloudSettingsToEngine1");
            if (mCloudSettings != null) {
                setCloudSettingsToT5(mCloudSettings);
            }
        } catch (Throwable th) {
            Log.w(LOGTAG, "setCloudSettings to zeus error ".concat(String.valueOf(th)));
        }
    }

    public static void updateFixAdblockLevelInfo(String str, int i2, int i3) {
        Log.i(LOGTAG, "updateFixAdblockLevelInfo host: %s, siteType: %d, level: %d  ", str, Integer.valueOf(i2), Integer.valueOf(i3));
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().updateFixAdblockLevelInfo(str, i2, i3);
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void updateHttpDns() {
        ZeusThreadPoolUtil.execute(new Runnable() { // from class: com.baidu.webkit.internal.blink.WebSettingsGlobalBlink.1
            @Override // java.lang.Runnable
            public final void run() {
                String str;
                if (WebKitFactory.getNeedDownloadCloudResource() && WebSettingsGlobalBlink.getHttpDnsUpdateEnabled()) {
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

    public static void uploadBuildinJsInfo(String str, String str2, String str3) {
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
            jSONObject.put("type", 12301);
            Log.i(LOGTAG, "[diting] recordImmediately :" + jSONObject.toString());
            SessionMonitorEngine.getInstance().recordImmediately("sailor_monitor", jSONObject.toString());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void uploadMF30InitInfo(long j, long j2, long j3, long j4, boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("vm_size_in_smaps", j);
            jSONObject.put("vm_max_slice", j2);
            jSONObject.put("vm_size_available", j3);
            jSONObject.put("pm_size_available", j4);
            jSONObject.put("in_good_state", z ? 1 : 0);
            jSONObject.put("type", 12303);
            sMf30InitInfo = jSONObject;
            Log.i(LOGTAG, "uploadMF30InitInfo :" + jSONObject.toString());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static boolean useCronet() {
        return WebViewFactory.getProvider().getSettingsStatics().useCronet();
    }

    public static boolean useLogSdk() {
        String str;
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

    public static boolean useT5Log() {
        String str;
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
}
