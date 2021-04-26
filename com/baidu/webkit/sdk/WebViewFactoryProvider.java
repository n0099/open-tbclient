package com.baidu.webkit.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.webkit.internal.daemon.PacDownload;
import com.baidu.webkit.internal.daemon.VideoPacDownload;
import com.baidu.webkit.sdk.WebSettings;
import com.baidu.webkit.sdk.WebView;
import com.baidu.webkit.sdk.WebViewRendererService;
import com.baidu.webkit.sdk.dumper.ZeusLogUploader;
import com.baidu.webkit.sdk.jschecker.BdJsCheckPolicy;
import com.baidu.webkit.sdk.location.ZeusGeoLocationInfo;
import java.net.HttpURLConnection;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
/* loaded from: classes5.dex */
public abstract class WebViewFactoryProvider extends Observable {
    public static final String LOG_TAG = "WebViewFactoryProvider";
    public static final String SETTING_AD_BLOCK = "ADBlock";
    public static final String SETTING_DEBUG = "Debug";
    public static final String SETTING_ENABLE_JS_PROMPT = "JsPromptEnable";
    public static final String SETTING_EYE_SHIELD_MODE = "EyeShieldMode";
    public static final String SETTING_FIX_WEBVIEW_HOLES = "FixWebViewSecurityHoles";
    public static final String SETTING_GIF_FIRST_FRAME = "GifFirstFrameOnly";
    public static final String SETTING_JS_CHECK_POLICY = "JsCheckPolicy";
    public static final String SETTING_JS_ENABLE_ON_FILE_SCHEMA = "JavaScriptEnabledOnFileScheme";
    public static final String SETTING_MONITOR = "Monitor";
    public static final String SETTING_NA2_WEB_ENABLE = "NA2WebEnable";
    public static final String SETTING_NIGHT_THEME = "NightTheme";
    public static final String SETTING_NO_IMAGE_MODE = "NoImageMode";
    public static final String SETTING_PAGE_FREEZE = "PageFreeze";
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
    public static final Boolean SETTING_NA2_WEB_VALUE = new Boolean(false);

    /* loaded from: classes5.dex */
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

        boolean getDitingMaxForceLoadSwitch();

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

        String getHttpDnsCache();

        String getHttpDnsUrl();

        HttpURLConnection getHttpUrlConnection(String str);

        WebSettings.ImgQuality getImgQuality();

        boolean getIpv6Env();

        int getKeepAliveTime();

        Context getKernelContext();

        String getLocalDns();

        int getLogLevel();

        boolean getMF30Inited();

        String getMLModelUrl();

        String getMainFrameIdInfo(int i2);

        String getMainFrameIdReferrer(int i2);

        boolean getMainLinkDirectEnabled();

        String getMfJsUrl();

        int getNQE();

        int getNetworkFlow();

        int getNetworkRtt();

        int getNetworkSpeed();

        boolean getOnePacketEnabled();

        boolean getPFLogEnabled();

        String getPacUrl();

        String getPageFeature(String str);

        String getPageWormHoleErrors();

        int getPopupWindowNum();

        String getProxyInfo();

        String getQuicHost();

        String getQuicInfo();

        boolean getQuicInit();

        int getQuicThreshold();

        String getRc4SecrectKey();

        WebSettings.RemoveAdLevel getRemoveAdLevel();

        int getSavingBytes();

        int getSearchDnsMiss();

        boolean getSendEngineUsageInfoEnabled();

        boolean getSendRequestEnabled();

        boolean getSessionHeaderEnabled();

        String getSessionUploadUrl();

        String getSkeletonJsUrl();

        int getSocketGroupNumber();

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

        int getWormholeNum(int i2);

        String getZeusManagerPkgName();

        String getZeusResourceUrl();

        boolean hasQuicAltService(String str);

        void initCronet(Context context);

        boolean isFeedNoProxyAdUrl(String str);

        boolean isFeedProxyAdUrl(String str);

        boolean isShowWebProviderBy();

        ByteBuffer kernelBrotliCreate(long[] jArr);

        void kernelBrotliDestroy(long[] jArr);

        ByteBuffer kernelBrotliPull(long[] jArr);

        void kernelBrotliPush(long[] jArr, int i2);

        void kernelEncrypt(byte[] bArr, int i2, byte[] bArr2);

        void notifyBdAppStatusChange(int i2);

        void removeDnsInfo(String str);

        void removeMainFrameIdInfo(int i2);

        void setAbTestSwitch(String str);

        void setAltServiceToBlink(String str);

        void setAppId(String str);

        void setAppStatus(boolean z);

        void setBackupDnsJobDelayTime(int i2);

        void setBackupJobDelayTime(int i2);

        void setBackupLandingJobDelayTime(int i2);

        void setClientIP(String str);

        void setCloudSettingsToT5(String str);

        void setConThreshold(int i2);

        void setCuid(String str);

        void setDitingMaxEnabled(boolean z, boolean z2, boolean z3);

        void setEnableEngineStat(boolean z);

        void setEnableProxy(boolean z);

        void setEnableSpdy(boolean z);

        void setEnableZeusManager(boolean z);

        void setEngineStatUrl(String str);

        void setEvilPageWhiteBlackListPath(String str);

        void setFakeBaiduWhiteList(String str);

        void setFastPac(String str);

        void setFileInIOEnabled(boolean z);

        void setFreeFlow(boolean z);

        void setGifOneFrameEnabled(boolean z);

        void setHijackEnv(boolean z);

        void setHisHijackStopAbEnable(int i2);

        void setHttpDnsCache(String str, int i2);

        void setHttpDnsDnFailed(String str);

        void setIPV6CheckList(String str);

        void setIPV6Timeout(int i2);

        void setImgQuality(WebSettings.ImgQuality imgQuality);

        void setImproveContentCache(boolean z);

        void setIpv6First(boolean z);

        void setKeepAliveTime(int i2);

        void setMLModel(String str, String str2);

        void setMainLinkDirectEnabled(boolean z);

        void setMaxFatalAllocationFailureSize(int i2);

        void setMulripleConnectEnabled(boolean z);

        void setNativeHttpdnsEnabled(boolean z);

        void setNavigationInterceptionEnable(boolean z);

        void setNeedDownloadCloudResource(boolean z);

        void setNetWorkChangeNotifyEnabled(boolean z);

        void setOnePacketEnabled(boolean z);

        void setPacData(String str);

        void setPacDataFreeFlow(String str);

        void setPacUrl(String str);

        void setPopupWindowOptEnabled(boolean z);

        void setPreConnectEnabled(boolean z);

        void setProxyInfo(String str, String[] strArr);

        void setProxyType(int i2);

        void setQuicDefaultOpen(boolean z);

        void setQuicThreshold(int i2);

        void setRefererPattern(String str, String str2);

        void setRemoveAdLevel(WebSettings.RemoveAdLevel removeAdLevel);

        void setSearchFrameQuicEnabled(boolean z);

        void setSendEngineUsageInfoEnabled(boolean z);

        void setSessionHeaderEnabled(boolean z);

        void setShowWebProviderBy(boolean z);

        void setSocketGroupNumber(int i2);

        void setSpdyCompressEnabled(boolean z);

        void setSpdyEncryptionEnabled(boolean z);

        void setSpdyTimeout(int i2);

        void setStatisticParam(String str);

        void setSubResourceMonitorEnabled(boolean z);

        void setT5SDKSpdyEnabled(boolean z);

        void setTcSpeedUpEnabled(boolean z);

        void setTimgConfData(String str);

        void setTimgConfUrl(String str);

        void setVideoPlayerMode(int i2);

        void setWebessenseEnabled(boolean z);

        void setWhiteAndBlackList(String str);

        void setWormholeEnabled(boolean z);

        void setZeusManagerPkgName(String str);

        boolean shouldAccessNetworkOverSpdy(String str);

        boolean useCronet();
    }

    /* loaded from: classes5.dex */
    public interface Statics {
        int AdBlockInit(String str, boolean z);

        void addToWebCache(String str, boolean z, boolean z2, Map<String, String> map);

        void addVirtualMemoryListener(WebView.IVirtualMemoryListener iVirtualMemoryListener);

        void cancelPrefetch(String str);

        void cancelResourcePrefetch(String str);

        void clearClientCertPreferences(Runnable runnable);

        void clearPageCacheCounts();

        void crashIntentionally(int i2);

        void enableSlowWholeDocumentDraw();

        String findAddress(String str);

        void freeMemoryForTests();

        HashMap<String, Long> getCurrentSystemInfraInfo();

        String getDefaultUserAgent(Context context);

        String getZeusSeriesNum(int i2, int i3, int i4);

        int historyNavigationCount();

        void initPageCacheCounts(Context context);

        boolean isInWebCache(String str);

        void makeMF30Inited();

        void onMemoryPresure(int i2, Activity activity);

        int pageCacheCount();

        Uri[] parseFileChooserResult(int i2, Intent intent);

        void preconnectUrl(String str, int i2);

        void prefetch(String str, Map<String, String> map, WebView.MainResourcePrefetchListener mainResourcePrefetchListener);

        void prefetchResource(String str, String[] strArr, Map<String, String> map);

        void removeFromWebCache(String str);

        void removeVirtualMemoryWatcher(WebView.IVirtualMemoryListener iVirtualMemoryListener);

        void resolveUrl(String str);

        void setWebContentsDebuggingEnabled(boolean z);
    }

    public void RecordUrl(String str) {
    }

    public void commonInitialize() {
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

    public Object getApisInteractWithMario() {
        return null;
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

    public PermissionRequest getPermissionRequest(String str) {
        return null;
    }

    public WebViewRendererService.ServiceProvider getRendererService() {
        return null;
    }

    public ServiceWorkerController getServiceWorkerController() {
        return null;
    }

    public SettingsStatics getSettingsStatics() {
        return null;
    }

    public Object getStaticWebSeting(String str) {
        HashMap<String, Object> hashMap;
        if (TextUtils.isEmpty(str) || (hashMap = this.mStaticWebSettings) == null || !hashMap.containsKey(str)) {
            return null;
        }
        return this.mStaticWebSettings.get(str);
    }

    public Statics getStatics() {
        return null;
    }

    public TracingController getTracingController() {
        return null;
    }

    public WebIconDatabase getWebIconDatabase() {
        return null;
    }

    public WebStorage getWebStorage() {
        return null;
    }

    public ClassLoader getWebViewClassLoader() {
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

    public void initNet() {
    }

    public void initPageCacheCounts(Context context) {
    }

    public void lazyInitialize() {
        Log.i(LOG_TAG, "lazyInitialize");
        VideoPacDownload.tryToDownLoadAsync(WebViewFactory.getContext());
        PacDownload.tryToDownLoadAsyncFreeFlow(WebViewFactory.getContext());
        PacDownload.tryToDownLoadAsync(WebViewFactory.getContext());
    }

    public void onABTestReady() {
    }

    public void onPageKeySectionTimeCostKeySection(WebView webView, String str, int i2, long j) {
    }

    public void preInitWebView() {
    }

    public void setLocation(ZeusGeoLocationInfo zeusGeoLocationInfo, boolean z) {
    }

    public void setStaticWebSeting(String str, Object obj) {
        HashMap<String, Object> hashMap;
        if (TextUtils.isEmpty(str) || (hashMap = this.mStaticWebSettings) == null || !hashMap.containsKey(str)) {
            return;
        }
        this.mStaticWebSettings.put(str, obj);
    }

    public void setWebviewNumber(String str) {
    }

    public void startBrowserProcess(boolean z) {
    }
}
