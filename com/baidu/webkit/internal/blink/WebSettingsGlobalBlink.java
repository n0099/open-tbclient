package com.baidu.webkit.internal.blink;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.webkit.internal.ABTestConstants;
import com.baidu.webkit.internal.CfgFileUtils;
import com.baidu.webkit.internal.ETAG;
import com.baidu.webkit.internal.INoProGuard;
import com.baidu.webkit.internal.daemon.HttpDnsCache;
import com.baidu.webkit.internal.daemon.PacDownload;
import com.baidu.webkit.internal.daemon.VideoPacDownload;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
import com.baidu.webkit.sdk.WebSettings;
import com.baidu.webkit.sdk.WebViewFactory;
import com.tencent.connect.common.Constants;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
import org.json.JSONTokener;
/* loaded from: classes2.dex */
public class WebSettingsGlobalBlink implements INoProGuard {
    private static final String CLOUD_SETTING_URL = "https://browserkernel.baidu.com/config/t5config?cmd=1&";
    private static final String DEFAULT_SECRECT_KEY = "SFIyRVI=";
    private static final String ENGINE_STAT_URL = "https://browserkernel.baidu.com/timing_txt/browser7_7.searchbox8_3.js.encrypt";
    private static final String FAKE_BAIDU_URL = "https://browserkernel.baidu.com/fakebaidu";
    private static final String HTTP_DNS_URL = "https://180.76.76.112/";
    protected static final String LOGTAG = "WebSettingsGlobalBlink";
    private static final String ML_MODEL_URL = "https://browserkernel.baidu.com/ml_model/";
    private static final String PAC_URL = "https://browserkernel.baidu.com/newpac31/spdy.conf.txt";
    public static final String SAILOR_URL_SAFE_CHECK_CLOUD_SWITCH = "searchbox_urlsafe_switch_pr";
    public static final int SAILOR_URL_SAFE_CHECK_CLOUD_SWITCH_CLOSE = 0;
    public static final int SAILOR_URL_SAFE_CHECK_CLOUD_SWITCH_OPEN = 1;
    private static final String SESSION_UPLOAD_URL = "https://browserkernel.baidu.com/kw?r_en=true&type=";
    protected static final String SETTING_IMPL_CLASS = "com.baidu.blink.WebSettingsGlobalProxy";
    private static String mBrowserVersion;
    private static String mCloudSettings = null;
    private static Map<String, String> mCloudSettingsMap = new HashMap();
    private static Map<String, String> mHttpDnsCacheMap = new HashMap();
    private static WebSettings.ProxyType mProxyType = WebSettings.ProxyType.SPDYANDOVERSEAS_PROXY;
    private static boolean mHijackEnv = false;
    private static boolean mFirstGetLogEnable = false;
    private static boolean mLogEnable = false;
    private static boolean mChromiumNetInit = false;
    private static boolean mCronetEnable = true;
    private static boolean mUseLogSdk = false;
    private static boolean mUseT5Log = false;
    private static boolean mSessionDataEnable = false;
    private static Object mSelfLock = new Object();

    public static String GetCloudSettingsValue(String str) {
        String str2;
        synchronized (mSelfLock) {
            str2 = mCloudSettingsMap.get(str);
        }
        return str2;
    }

    public static boolean GetHttpDnsCache(String str) {
        try {
            if (GetCloudSettingsValue(ETAG.KEY_HTTP_DNS_ENABLE) == null || !GetCloudSettingsValue(ETAG.KEY_HTTP_DNS_ENABLE).equals(ABTestConstants.PHOENIX_NET_AD_FIRSTSCREEN_OPT_DISABLE)) {
                String str2 = mHttpDnsCacheMap.get(Uri.parse(str).getHost());
                String dnsInfo = getDnsInfo(str);
                if (str2 == null || str2.length() <= 0) {
                    return false;
                }
                if (dnsInfo == null || dnsInfo.length() <= 0) {
                    return true;
                }
                String substring = dnsInfo.substring(0, dnsInfo.indexOf(ETAG.ITEM_SEPARATOR));
                if (substring != null) {
                    if (str2.indexOf(substring) >= 0) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        } catch (Throwable th) {
            Log.w(LOGTAG, "GetHttpDnsCache error " + th);
            return false;
        }
    }

    public static boolean canUseFreeFlow() {
        Log.w(LOGTAG, "canUseFreeFlow called");
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().canUseFreeFlow();
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
        return false;
    }

    public static void chromiumNetInit() {
        synchronized (com.baidu.webkit.net.b.f) {
            Log.w(LOGTAG, "chromiunNetInit notifyAll");
            com.baidu.webkit.net.b.f.notifyAll();
        }
    }

    public static void clearNetworkFlow() {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().clearNetworkFlow();
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            Log.w(LOGTAG, "clearNetworkFlow error:" + th);
        }
    }

    public static void clearSavingBytes() {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().clearSavingBytes();
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            Log.w(LOGTAG, "clearSavingBytes error:" + th);
        }
    }

    public static long generateBKDRHash(String str) {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().generateBKDRHash(str);
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
        return -1L;
    }

    public static String getAppId() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getAppId();
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
        return null;
    }

    public static String getBrowserVersion() {
        return mBrowserVersion;
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
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            Log.e(LOGTAG, "getChromiunNetInit error:" + th);
        }
        return false;
    }

    public static String getCloudHost() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getCloudHost();
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
        return null;
    }

    public static String getCloudSettingUrl() {
        try {
            String cloudSettingUrl = WebViewFactory.hasProvider() ? WebViewFactory.getProvider().getSettingsStatics().getCloudSettingUrl() : null;
            if (cloudSettingUrl != null) {
                if (cloudSettingUrl.length() > 0) {
                    return cloudSettingUrl;
                }
            }
            return CLOUD_SETTING_URL;
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
            return CLOUD_SETTING_URL;
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
            return CLOUD_SETTING_URL;
        }
    }

    public static boolean getCloudSwitchInPercentage(String str, float f) {
        if (f < 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("defPercent must between [0.0f, 1.0f]");
        }
        try {
            float floatValue = Float.valueOf(GetCloudSettingsValue(str)).floatValue();
            if (floatValue >= 0.0f && floatValue <= 1.0f) {
                f = floatValue;
            }
        } catch (Throwable th) {
        }
        return Math.random() < ((double) f);
    }

    public static boolean getCronetEnable() {
        try {
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
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
            return false;
        } catch (Throwable th) {
            Log.e(LOGTAG, "getCronetEnable error:" + th);
            return false;
        }
    }

    public static String getCuid() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getCuid();
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
        return null;
    }

    public static String getDNSStatistic() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getDNSStatistic();
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
        return null;
    }

    public static String getDnsInfo(String str) {
        String dnsInfoEngine;
        try {
            dnsInfoEngine = getDnsInfoEngine(Uri.parse(str).getHost());
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
        return dnsInfoEngine != null ? dnsInfoEngine : "";
    }

    public static String getDnsInfoEngine(String str) {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getDnsInfo(str);
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
        return "";
    }

    public static int getDownTraffic() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getDownTraffic();
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            Log.w(LOGTAG, "getDownTraffic error:" + th);
        }
        return 0;
    }

    public static boolean getEnableEngineStat() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getEnableEngineStat();
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
        return true;
    }

    public static boolean getEnableProxy() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getEnableProxy();
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
        return false;
    }

    public static boolean getEnableSpdy() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getEnableSpdy();
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
        return false;
    }

    public static boolean getEnableZeusManager() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getEnableZeusManager();
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
        return false;
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
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
            return ENGINE_STAT_URL;
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
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
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
            return FAKE_BAIDU_URL;
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
            return FAKE_BAIDU_URL;
        }
    }

    public static boolean getGifOneFrameEnabled() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getGifOneFrameEnabled();
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
        return false;
    }

    public static boolean getHijackEnv() {
        return mHijackEnv;
    }

    public static boolean getHttp2Enabled() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getHttp2Enabled();
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
        return false;
    }

    public static String getHttpCode() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getHttpCode();
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
        return null;
    }

    public static String getHttpDnsUrl() {
        try {
            return getHttpDnsUrlEngine();
        } catch (Throwable th) {
            Log.w(LOGTAG, "getHttpDnsUrl error " + th);
            return null;
        }
    }

    public static String getHttpDnsUrlEngine() {
        try {
            String httpDnsUrl = WebViewFactory.hasProvider() ? WebViewFactory.getProvider().getSettingsStatics().getHttpDnsUrl() : null;
            if (httpDnsUrl != null) {
                if (httpDnsUrl.length() > 0) {
                    return httpDnsUrl;
                }
            }
            return HTTP_DNS_URL;
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
            return HTTP_DNS_URL;
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
            return HTTP_DNS_URL;
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
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
        return WebSettings.ImgQuality.NO_COMPRESS;
    }

    public static int getInspectorKernelSupport() {
        return 0;
    }

    public static String getLocalDns() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getLocalDns();
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
        return null;
    }

    public static int getLogLevel() {
        try {
            if (WebKitFactory.getCurEngine() == 1 && WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getLogLevel();
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            Log.e(LOGTAG, "getLogLevel error:" + th);
        }
        return -1;
    }

    public static boolean getMF30Inited() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getMF30Inited();
            }
            return false;
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
            return false;
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
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
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
            return ML_MODEL_URL;
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
            return ML_MODEL_URL;
        }
    }

    public static String getMainFrameIdInfo(int i) {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getMainFrameIdInfo(i);
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
        return "";
    }

    public static String getMainFrameIdReferrer(int i) {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getMainFrameIdReferrer(i);
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
        return "";
    }

    public static boolean getMainLinkDirectEnabled() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getMainLinkDirectEnabled();
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
        return false;
    }

    public static int getNetworkFlow() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getNetworkFlow();
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            Log.w(LOGTAG, "getNetworkFlow error:" + th);
        }
        return 0;
    }

    public static int getNetworkRtt() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getNetworkRtt();
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
        return 0;
    }

    public static int getNetworkSpeed() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getNetworkSpeed();
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
        return 0;
    }

    public static boolean getOnePacketEnabled() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getOnePacketEnabled();
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
        return false;
    }

    public static boolean getPFLogEnabled() {
        try {
            if (WebKitFactory.getCurEngine() == 1 && WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getPFLogEnabled();
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            Log.e(LOGTAG, "getPFLogEnabled error:" + th);
        }
        return false;
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
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
            return PAC_URL;
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
            return PAC_URL;
        }
    }

    public static boolean getPageCacheEnabled() {
        try {
            if (GetCloudSettingsValue("page_cache") != null) {
                if (GetCloudSettingsValue("page_cache").equals(ABTestConstants.PHOENIX_NET_AD_FIRSTSCREEN_OPT_DISABLE)) {
                    return false;
                }
            }
        } catch (Throwable th) {
            Log.w(LOGTAG, "getPageCacheEnabled error " + th);
        }
        return true;
    }

    public static String getPageFeature(String str) {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getPageFeature(str);
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
        return null;
    }

    public static String getProxyInfo() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getProxyInfo();
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
        return null;
    }

    public static WebSettings.ProxyType getProxyType() {
        return mProxyType;
    }

    public static boolean getQuicEnabled() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getQuicEnabled();
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
        return false;
    }

    public static String getQuicHost() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getQuicHost();
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
        return null;
    }

    public static String getRc4SecrectKey() {
        try {
            String rc4SecrectKey = WebViewFactory.hasProvider() ? WebViewFactory.getProvider().getSettingsStatics().getRc4SecrectKey() : null;
            return (rc4SecrectKey == null || rc4SecrectKey.length() <= 0) ? new String(Base64.decode(DEFAULT_SECRECT_KEY.getBytes(), 0)) : new String(Base64.decode(rc4SecrectKey.getBytes(), 0));
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
            return new String(Base64.decode(DEFAULT_SECRECT_KEY.getBytes(), 0));
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
            return new String(Base64.decode(DEFAULT_SECRECT_KEY.getBytes(), 0));
        }
    }

    public static WebSettings.RemoveAdLevel getRemoveAdLevel() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getRemoveAdLevel();
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
        return WebSettings.RemoveAdLevel.DISABLE;
    }

    public static int getSavingBytes() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getSavingBytes();
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            Log.w(LOGTAG, "getSavingBytes error:" + th);
        }
        return 0;
    }

    public static boolean getSendEngineUsageInfoEnabled() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getSendEngineUsageInfoEnabled();
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
        return false;
    }

    public static boolean getSendRequestEnabled() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getSendRequestEnabled();
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
        return false;
    }

    public static boolean getSessionHeaderEnabled() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getSessionHeaderEnabled();
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0026 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x002f A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getSessionUploadUrl() {
        String str;
        Throwable th;
        try {
            str = WebViewFactory.hasProvider() ? WebViewFactory.getProvider().getSettingsStatics().getSessionUploadUrl() : null;
            try {
                if (TextUtils.isEmpty(str)) {
                    str = GetCloudSettingsValue("session_upload_url");
                }
            } catch (Throwable th2) {
                th = th2;
                Log.printStackTrace(th);
                if (TextUtils.isEmpty(str)) {
                }
            }
        } catch (Throwable th3) {
            str = null;
            th = th3;
        }
        return TextUtils.isEmpty(str) ? str : SESSION_UPLOAD_URL;
    }

    public static boolean getSpdy31Enabled() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getSpdy31Enabled();
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
        return false;
    }

    public static boolean getSpdyCompressEnabled() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getSpdyCompressEnabled();
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
        return true;
    }

    public static boolean getSpdyEncryptionEnabled() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getSpdyEncryptionEnabled();
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
        return false;
    }

    public static boolean getSubResourceMonitorEnabled() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getSubResourceMonitorEnabled();
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
        return false;
    }

    public static String getSubResourceTiming() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getSubResourceTiming();
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
        return null;
    }

    public static boolean getSysProxyEnabled() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getSysProxyEnabled();
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
        return false;
    }

    public static String getTimgConfUrl() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getTimgConfUrl();
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
        return null;
    }

    public static int getUpTraffic() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getUpTraffic();
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            Log.w(LOGTAG, "getUpTraffic error:" + th);
        }
        return 0;
    }

    public static boolean getWebessenseEnabled() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getWebessenseEnabled();
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
        return true;
    }

    public static boolean getWormholeEnabled() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getWormholeEnabled();
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
        return false;
    }

    public static String getWormholeForbidenHost() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getWormholeForbidenHost();
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
        return null;
    }

    public static int getWormholeNum(int i) {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getWormholeNum(i);
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
        return 0;
    }

    public static String getZeusManagerPkgName() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().getZeusManagerPkgName();
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
        return null;
    }

    public static void initCronet() {
        WebViewFactory.getProvider().getSettingsStatics().initCronet();
    }

    public static boolean isFeedNoProxyAdUrl(String str) {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().isFeedNoProxyAdUrl(str);
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
        return false;
    }

    public static boolean isFeedProxyAdUrl(String str) {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().isFeedProxyAdUrl(str);
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
        return false;
    }

    public static boolean isSessionDataEnable() {
        boolean z = true;
        String GetCloudSettingsValue = GetCloudSettingsValue("log_method");
        if (GetCloudSettingsValue != null) {
            if (!GetCloudSettingsValue.equals("1") && !GetCloudSettingsValue.equals("4") && !GetCloudSettingsValue.equals("5") && !GetCloudSettingsValue.equals(Constants.VIA_SHARE_TYPE_INFO)) {
                z = false;
            }
            mSessionDataEnable = z;
            Log.w(LOGTAG, "isSessionDataEnable(), log_method=" + GetCloudSettingsValue + ", isSessionDataEnable=" + mSessionDataEnable);
        } else {
            mSessionDataEnable = true;
            Log.w(LOGTAG, "isSessionDataEnable(), log_method is not configured, isSessionDataEnable=" + mSessionDataEnable);
        }
        return mSessionDataEnable;
    }

    public static boolean isShowWebProviderBy() {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().isShowWebProviderBy();
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
        return false;
    }

    public static void kernelEncrypt(byte[] bArr, int i, byte[] bArr2) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().kernelEncrypt(bArr, i, bArr2);
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
    }

    private static void onZeusEnableWillChange(String str, String str2) {
        boolean z = false;
        boolean z2 = str == null || str.length() == 0 || str.toLowerCase().equals("true");
        if (str2 == null || str2.length() == 0 || str2.toLowerCase().equals("true")) {
            z = true;
        }
        if (z2 != z) {
            EngineManager.getInstance().setNeedKillProcess(true);
        }
    }

    public static void removeDnsInfo(String str) {
        try {
            removeDnsInfoEngine(Uri.parse(str).getHost());
        } catch (Throwable th) {
            Log.w(LOGTAG, "removeDnsInfo error " + th);
        }
    }

    public static void removeDnsInfoEngine(String str) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().removeDnsInfo(str);
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
    }

    public static void removeMainFrameIdInfo(int i) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().removeMainFrameIdInfo(i);
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
    }

    static void reset() {
    }

    public static void setAppId(String str) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setAppId(str);
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
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
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
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
                    Log.w(LOGTAG, "[cronet] setCloudSettings key " + next + " value " + string);
                    synchronized (mSelfLock) {
                        mCloudSettingsMap.put(next, string);
                    }
                }
            } catch (Throwable th) {
                Log.w(LOGTAG, "setCloudSettings parserData JSONTokener error " + th);
            }
            try {
                onZeusEnableWillChange(GetCloudSettingsValue2, GetCloudSettingsValue("chromium63_zeus_enable"));
                if (mCloudSettings != null) {
                    setCloudSettingsToT5(mCloudSettings);
                    shouldReLoadHttpDns(GetCloudSettingsValue);
                }
            } catch (Throwable th2) {
                Log.w(LOGTAG, "setCloudSettings to zeus error " + th2);
            }
        }
    }

    public static void setCloudSettingsToT5(String str) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setCloudSettingsToT5(str);
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
    }

    public static void setCronetEnable(boolean z) {
        Log.w(LOGTAG, "setCronetEnable " + z);
        mCronetEnable = z;
        CfgFileUtils.set(CfgFileUtils.KEY_CRONET_AB_STAT, z);
    }

    public static void setCuid(String str) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setCuid(str);
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
    }

    public static void setEnableEngineStat(boolean z) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setEnableEngineStat(z);
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
    }

    public static void setEnableProxy(boolean z) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setEnableProxy(z);
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
    }

    public static void setEnableSpdy(boolean z) {
        if (z) {
            try {
                Log.w(LOGTAG, "PacDownload.tryToDownLoadAsync");
                PacDownload.tryToDownLoadAsync(WebKitFactory.getContext());
            } catch (UnsatisfiedLinkError e) {
                com.a.a.a.a.a.a.a.a(e);
                return;
            } catch (Throwable th) {
                com.a.a.a.a.a.a.a.a(th);
                return;
            }
        }
        if (WebViewFactory.hasProvider()) {
            WebViewFactory.getProvider().getSettingsStatics().setEnableSpdy(z);
        }
    }

    public static void setEnableZeusManager(boolean z) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setEnableZeusManager(z);
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
    }

    public static void setEngineStatUrl(String str) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setEngineStatUrl(str);
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
    }

    public static void setFakeBaiduWhiteList(String str) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setFakeBaiduWhiteList(str);
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
    }

    public static void setFastPac(String str) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setFastPac(str);
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
    }

    public static void setFreeFlow(boolean z) {
        Log.w(LOGTAG, "setFreeFlow " + z);
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setFreeFlow(z);
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
    }

    public static void setGifOneFrameEnabled(boolean z) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setGifOneFrameEnabled(z);
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
    }

    public static void setHijackEnv(boolean z) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setHijackEnv(z);
                PacDownload.tryToDownLoadAsync(WebKitFactory.getContext());
                mHijackEnv = z;
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
    }

    public static void setHttpDnsCache(String str) {
        if (str != null) {
            try {
                JSONObject jSONObject = (JSONObject) new JSONTokener(str).nextValue();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    mHttpDnsCacheMap.put(next, jSONObject.getString(next));
                }
            } catch (Throwable th) {
                Log.w(LOGTAG, "setHttpDnsCache parserData JSONTokener error " + th);
            }
            if (str != null) {
                try {
                    Log.w(LOGTAG, "[cronet] http_dns setHttpDnsCache:" + str);
                    setHttpDnsCacheEngine(str);
                } catch (Exception e) {
                    com.a.a.a.a.a.a.a.a(e);
                }
            }
        }
    }

    public static void setHttpDnsCacheEngine(String str) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setHttpDnsCache(str);
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
    }

    public static void setHttpDnsExtHostEngine(String str) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setHttpDnsExtHostcache(str);
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
    }

    public static void setImgQuality(WebSettings.ImgQuality imgQuality) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setImgQuality(imgQuality);
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
    }

    public static void setMLModel(String str, byte[] bArr) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setMLModel(str, bArr);
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
    }

    public static void setMainLinkDirectEnabled(boolean z) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setMainLinkDirectEnabled(z);
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
    }

    public static void setNavigationInterceptionEnable(boolean z) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setNavigationInterceptionEnable(z);
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
    }

    public static void setOnePacketEnabled(boolean z) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setOnePacketEnabled(z);
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
    }

    public static void setPacData(String str) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setPacData(str);
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
    }

    public static void setPacDataFreeFlow(String str) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setPacDataFreeFlow(str);
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
    }

    public static void setPacUrl(String str) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setPacUrl(str);
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
    }

    public static void setProxyInfo(String str) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setProxyInfo(str);
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
    }

    public static void setProxyType(WebSettings.ProxyType proxyType) {
        try {
            if (WebViewFactory.hasProvider()) {
                Log.w(LOGTAG, "setProxyType " + proxyType);
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
                PacDownload.tryToDownLoadAsync(WebKitFactory.getContext());
                VideoPacDownload.tryToDownLoadAsync(WebKitFactory.getContext());
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
    }

    public static void setRemoveAdLevel(WebSettings.RemoveAdLevel removeAdLevel) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setRemoveAdLevel(removeAdLevel);
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
    }

    public static void setSendEngineUsageInfoEnabled(boolean z) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setSendEngineUsageInfoEnabled(z);
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
    }

    public static void setSessionHeaderEnabled(boolean z) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setSessionHeaderEnabled(z);
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
    }

    public static void setShowWebProviderBy(boolean z) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setShowWebProviderBy(z);
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
    }

    public static void setSpdyCompressEnabled(boolean z) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setSpdyCompressEnabled(z);
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
    }

    public static void setSpdyEncryptionEnabled(boolean z) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setSpdyEncryptionEnabled(z);
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
    }

    public static void setSpdyTimeout(int i) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setSpdyTimeout(i);
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
    }

    public static void setStatisticParam(String str) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setStatisticParam(str);
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
    }

    public static void setSubResourceMonitorEnabled(boolean z) {
        try {
            Log.w(LOGTAG, "setSubResourceMonitorEnabled " + z);
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setSubResourceMonitorEnabled(z);
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
    }

    public static void setT5SDKSpdyEnabled(boolean z) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setT5SDKSpdyEnabled(z);
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
    }

    public static void setTcSpeedUpEnabled(boolean z) {
        try {
            Log.w(LOGTAG, "setTcSpeedUpEnabled " + z);
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setTcSpeedUpEnabled(z);
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
    }

    public static void setTimgConfData(String str) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setTimgConfData(str);
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
    }

    public static void setTimgConfUrl(String str) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setTimgConfUrl(str);
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
    }

    public static void setUseLogSdk(boolean z) {
        mUseLogSdk = z;
    }

    public static void setVideoPlayerMode(int i) {
        Log.w(LOGTAG, "setVideoPlayerMode " + i);
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setVideoPlayerMode(i);
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
    }

    public static void setWebessenseEnabled(boolean z) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setWebessenseEnabled(z);
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
    }

    public static void setWormholeEnabled(boolean z) {
        try {
            Log.w(LOGTAG, "setWormholeEnabled " + z);
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setWormholeEnabled(z);
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
    }

    public static void setZeusManagerPkgName(String str) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getSettingsStatics().setZeusManagerPkgName(str);
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
    }

    public static boolean shouldAccessNetworkOverSpdy(String str) {
        try {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getSettingsStatics().shouldAccessNetworkOverSpdy(str);
            }
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            com.a.a.a.a.a.a.a.a(th);
        }
        return false;
    }

    public static void shouldReLoadHttpDns(String str) {
        if (str != null) {
            try {
                if (str.equals(ABTestConstants.PHOENIX_NET_AD_FIRSTSCREEN_OPT_DISABLE)) {
                    if (GetCloudSettingsValue(ETAG.KEY_HTTP_DNS_ENABLE) == null || !GetCloudSettingsValue(ETAG.KEY_HTTP_DNS_ENABLE).equals(ABTestConstants.PHOENIX_NET_AD_FIRSTSCREEN_OPT_DISABLE)) {
                        HttpDnsCache.tryToUpdateHttpDnsCache(WebKitFactory.getContext());
                    }
                }
            } catch (Throwable th) {
                Log.w(LOGTAG, "shouldReLoadHttpDns error " + th);
            }
        }
    }

    public static void updateCloudSettingsToEngine() {
        try {
            Log.w(LOGTAG, "updateCloudSettingsToEngine1");
            if (mCloudSettings != null) {
                setCloudSettingsToT5(mCloudSettings);
            }
        } catch (Throwable th) {
            Log.w(LOGTAG, "setCloudSettings to zeus error " + th);
        }
    }

    public static boolean useCronet() {
        return WebViewFactory.getProvider().getSettingsStatics().useCronet();
    }

    public static boolean useLogSdk() {
        String GetCloudSettingsValue = GetCloudSettingsValue("log_method");
        if (GetCloudSettingsValue != null) {
            mUseLogSdk = GetCloudSettingsValue.equals("1");
            Log.w(LOGTAG, "useLogSdk(), log_method=" + GetCloudSettingsValue + ", useLogSdk=" + mUseLogSdk);
        } else {
            Log.w(LOGTAG, "useLogSdk(), log_method is not configured, useLogSdk=" + mUseLogSdk);
        }
        return mUseLogSdk;
    }

    public static boolean useT5Log() {
        String GetCloudSettingsValue = GetCloudSettingsValue("log_method");
        if (GetCloudSettingsValue != null) {
            mUseT5Log = GetCloudSettingsValue.equals("2") || GetCloudSettingsValue.equals("3") || GetCloudSettingsValue.equals("5");
            Log.w(LOGTAG, "useT5Log(), log_method=" + GetCloudSettingsValue + ", useT5Log=" + mUseT5Log);
        } else {
            Log.w(LOGTAG, "useT5Log(), log_method is not configured, useT5Log=" + mUseT5Log);
        }
        return mUseT5Log;
    }
}
