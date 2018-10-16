package com.baidu.webkit.sdk;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.webkit.sdk.WebSettings;
import com.baidu.webkit.sdk.WebView;
import com.baidu.webkit.sdk.dumper.ZeusLogUploader;
import com.baidu.webkit.sdk.jschecker.BdJsCheckPolicy;
import com.baidu.webkit.sdk.location.ZeusGeoLocationInfo;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Observable;
/* loaded from: classes2.dex */
public abstract class WebViewFactoryProvider extends Observable {
    public static final String SETTING_AD_BLOCK = "ADBlock";
    public static final String SETTING_DEBUG = "Debug";
    public static final String SETTING_ENABLE_JS_PROMPT = "JsPromptEnable";
    public static final String SETTING_EYE_SHIELD_MODE = "EyeShieldMode";
    public static final String SETTING_FIX_WEBVIEW_HOLES = "FixWebViewSecurityHoles";
    public static final String SETTING_GIF_FIRST_FRAME = "GifFirstFrameOnly";
    public static final String SETTING_JS_CHECK_POLICY = "JsCheckPolicy";
    public static final String SETTING_JS_ENABLE_ON_FILE_SCHEMA = "JavaScriptEnabledOnFileScheme";
    public static final String SETTING_MONITOR = "Monitor";
    public static final String SETTING_NIGHT_THEME = "NightTheme";
    public static final String SETTING_NO_IMAGE_MODE = "NoImageMode";
    public static final String SETTING_PROXY_TYPE = "ProxyType";
    public static final String SETTING_SAVE_FLOW = "SaveFlow";
    public static final String SETTING_SPDY = "Spdy";
    public static final String SETTING_UA_EMULATE = "UaEmulate";
    public static final String SETTING_URL_SAFE_CHECK = "UrlSafeCheck";
    public static final int STATIC_SETTING_SIZE = 16;
    public HashMap<String, Object> mStaticWebSettings;
    public static final Boolean SETTING_JS_ENABLE_ON_FILE_SCHEMA_VALUE = new Boolean(false);
    public static final Boolean SETTING_FIX_WEBVIEW_HOLES_VALUE = new Boolean(true);
    public static final Boolean SETTING_AD_BLOCK_VALUE = new Boolean(false);
    public static final Boolean SETTING_URL_SAFE_CHECK_VALUE = new Boolean(false);
    public static final Boolean SETTING_SPDY_VALUE = new Boolean(false);
    public static final Boolean SETTING_SAVE_FLOW_VALUE = new Boolean(false);
    public static final Boolean SETTING_GIF_FIRST_FRAME_VALUE = new Boolean(false);
    public static final Boolean SETTING_DEBUG_VALUE = new Boolean(false);
    public static final Boolean SETTING_MONITOR_VALUE = new Boolean(false);
    public static final Integer SETTING_PROXY_TYPE_VALUE = new Integer(WebSettings.ProxyType.NO_PROXY.ordinal());
    public static final Boolean SETTING_UA_EMULATE_VALUE = new Boolean(false);
    public static final Boolean SETTING_ENABLE_JS_PROMPT_VALUE = new Boolean(false);
    public static final BdJsCheckPolicy SETTING_JS_CHECK_POLICY_VALUE = null;
    public static final Boolean SETTING_NIGHT_THEME_VALUE = new Boolean(false);
    public static final Boolean SETTING_EYE_SHIELD_MODE_VALUE = new Boolean(false);
    public static final Boolean SETTING_NO_IMAGE_MODE_VALUE = new Boolean(false);

    /* loaded from: classes2.dex */
    public interface SettingsStatics {
        boolean canUseFreeFlow();

        void clearNetworkFlow();

        void clearSavingBytes();

        long generateBKDRHash(String str);

        String getAppId();

        boolean getChromiunNetInit();

        String getCloudHost();

        String getCloudSettingUrl();

        boolean getCronetEnable();

        String getCuid();

        String getDNSStatistic();

        String getDnsInfo(String str);

        int getDownTraffic();

        boolean getEnableEngineStat();

        boolean getEnableProxy();

        boolean getEnableSpdy();

        boolean getEnableZeusManager();

        String getEngineStatUrl();

        String getFakeBaiduUrl();

        boolean getGifOneFrameEnabled();

        boolean getHttp2Enabled();

        String getHttpCode();

        String getHttpDnsUrl();

        HttpURLConnection getHttpUrlConnection(String str);

        WebSettings.ImgQuality getImgQuality();

        String getLocalDns();

        int getLogLevel();

        boolean getMF30Inited();

        String getMLModelUrl();

        String getMainFrameIdInfo(int i);

        String getMainFrameIdReferrer(int i);

        boolean getMainLinkDirectEnabled();

        int getNetworkFlow();

        int getNetworkRtt();

        int getNetworkSpeed();

        boolean getOnePacketEnabled();

        boolean getPFLogEnabled();

        String getPacUrl();

        String getPageFeature(String str);

        String getProxyInfo();

        boolean getQuicEnabled();

        String getQuicHost();

        String getRc4SecrectKey();

        WebSettings.RemoveAdLevel getRemoveAdLevel();

        int getSavingBytes();

        boolean getSendEngineUsageInfoEnabled();

        boolean getSendRequestEnabled();

        boolean getSessionHeaderEnabled();

        String getSessionUploadUrl();

        boolean getSpdy31Enabled();

        boolean getSpdyCompressEnabled();

        boolean getSpdyEncryptionEnabled();

        boolean getSubResourceMonitorEnabled();

        String getSubResourceTiming();

        boolean getSysProxyEnabled();

        String getTimgConfUrl();

        int getUpTraffic();

        int getVideoPlayerMode();

        boolean getWebessenseEnabled();

        boolean getWormholeEnabled();

        String getWormholeForbidenHost();

        int getWormholeNum(int i);

        String getZeusManagerPkgName();

        void initCronet();

        boolean isFeedNoProxyAdUrl(String str);

        boolean isFeedProxyAdUrl(String str);

        boolean isShowWebProviderBy();

        void kernelEncrypt(byte[] bArr, int i, byte[] bArr2);

        void removeDnsInfo(String str);

        void removeMainFrameIdInfo(int i);

        void setAppId(String str);

        void setClientIP(String str);

        void setCloudSettingsToT5(String str);

        void setCuid(String str);

        void setEnableEngineStat(boolean z);

        void setEnableProxy(boolean z);

        void setEnableSpdy(boolean z);

        void setEnableZeusManager(boolean z);

        void setEngineStatUrl(String str);

        void setFakeBaiduWhiteList(String str);

        void setFastPac(String str);

        void setFreeFlow(boolean z);

        void setGifOneFrameEnabled(boolean z);

        void setHijackEnv(boolean z);

        void setHttpDnsCache(String str);

        void setHttpDnsExtHostcache(String str);

        void setImgQuality(WebSettings.ImgQuality imgQuality);

        void setMLModel(String str, byte[] bArr);

        void setMainLinkDirectEnabled(boolean z);

        void setNavigationInterceptionEnable(boolean z);

        void setOnePacketEnabled(boolean z);

        void setPacData(String str);

        void setPacDataFreeFlow(String str);

        void setPacUrl(String str);

        void setProxyInfo(String str);

        void setProxyType(int i);

        void setRemoveAdLevel(WebSettings.RemoveAdLevel removeAdLevel);

        void setSendEngineUsageInfoEnabled(boolean z);

        void setSessionHeaderEnabled(boolean z);

        void setShowWebProviderBy(boolean z);

        void setSpdyCompressEnabled(boolean z);

        void setSpdyEncryptionEnabled(boolean z);

        void setSpdyTimeout(int i);

        void setStatisticParam(String str);

        void setSubResourceMonitorEnabled(boolean z);

        void setT5SDKSpdyEnabled(boolean z);

        void setTcSpeedUpEnabled(boolean z);

        void setTimgConfData(String str);

        void setTimgConfUrl(String str);

        void setVideoPlayerMode(int i);

        void setWebessenseEnabled(boolean z);

        void setWormholeEnabled(boolean z);

        void setZeusManagerPkgName(String str);

        boolean shouldAccessNetworkOverSpdy(String str);

        boolean useCronet();
    }

    /* loaded from: classes2.dex */
    public interface Statics {
        int AdBlockInit(String str, boolean z);

        void clearClientCertPreferences(Runnable runnable);

        void clearPageCacheCounts();

        void crashIntentionally();

        void enableSlowWholeDocumentDraw();

        String findAddress(String str);

        void freeMemoryForTests();

        String getDefaultUserAgent(Context context);

        String getZeusSeriesNum(int i, int i2, int i3);

        int historyNavigationCount();

        void initPageCacheCounts(Context context);

        void makeMF30Inited();

        void onMemoryPresure();

        int pageCacheCount();

        Uri[] parseFileChooserResult(int i, Intent intent);

        void preconnectUrl(String str);

        void resolveUrl(String str);

        void setWebContentsDebuggingEnabled(boolean z);
    }

    public CookieSyncManager createCookieSyncManager(Context context) {
        return null;
    }

    public WebViewProvider createWebView(WebView webView, WebView.PrivateAccess privateAccess) {
        return null;
    }

    public void disableFeature(String str) {
    }

    public void enableFeature(String str) {
    }

    public CookieManager getCookieManager() {
        return null;
    }

    public CookieSyncManager getCookieSyncManager() {
        return null;
    }

    public GeolocationPermissions getGeolocationPermissions() {
        return null;
    }

    public GeolocationServiceBridge getGeolocationServiceBridge() {
        return null;
    }

    public ZeusLogUploader getLogUploader(String str, String str2, boolean z) {
        return null;
    }

    public MimeTypeMap getMimeTypeMap() {
        return null;
    }

    public NativeRestore getNativeRestoreImpl(String str) {
        return null;
    }

    public SettingsStatics getSettingsStatics() {
        return null;
    }

    public Object getStaticWebSeting(String str) {
        if (TextUtils.isEmpty(str) || this.mStaticWebSettings == null || !this.mStaticWebSettings.containsKey(str)) {
            return null;
        }
        return this.mStaticWebSettings.get(str);
    }

    public Statics getStatics() {
        return null;
    }

    public WebIconDatabase getWebIconDatabase() {
        return null;
    }

    public WebStorage getWebStorage() {
        return null;
    }

    public WebViewDatabase getWebViewDatabase(Context context) {
        return null;
    }

    public String getZeusJarVersion() {
        return null;
    }

    public String getZeusNativeLibraryVersion() {
        return null;
    }

    public void initPageCacheCounts(Context context) {
    }

    public void lazyInitialize() {
    }

    public void setLocation(ZeusGeoLocationInfo zeusGeoLocationInfo, boolean z) {
    }

    public void setStaticWebSeting(String str, Object obj) {
        if (TextUtils.isEmpty(str) || this.mStaticWebSettings == null || !this.mStaticWebSettings.containsKey(str)) {
            return;
        }
        this.mStaticWebSettings.put(str, obj);
    }
}
