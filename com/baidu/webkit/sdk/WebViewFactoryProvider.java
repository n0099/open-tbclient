package com.baidu.webkit.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.daemon.PacDownload;
import com.baidu.webkit.internal.daemon.VideoPacDownload;
import com.baidu.webkit.sdk.WebSettings;
import com.baidu.webkit.sdk.WebView;
import com.baidu.webkit.sdk.WebViewRendererService;
import com.baidu.webkit.sdk.dumper.ZeusLogUploader;
import com.baidu.webkit.sdk.jschecker.BdJsCheckPolicy;
import com.baidu.webkit.sdk.location.ZeusGeoLocationInfo;
import com.baidu.webkit.sdk.performance.UMALogger;
import java.net.HttpURLConnection;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes12.dex */
public abstract class WebViewFactoryProvider {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String LOG_TAG = "WebViewFactoryProvider";
    public static final String SETTING_AD_BLOCK = "ADBlock";
    public static final Boolean SETTING_AD_BLOCK_VALUE;
    public static final String SETTING_DEBUG = "Debug";
    public static final Boolean SETTING_DEBUG_VALUE;
    public static final String SETTING_ENABLE_JS_PROMPT = "JsPromptEnable";
    public static final Boolean SETTING_ENABLE_JS_PROMPT_VALUE;
    public static final String SETTING_EYE_SHIELD_MODE = "EyeShieldMode";
    public static final Boolean SETTING_EYE_SHIELD_MODE_VALUE;
    public static final String SETTING_FIX_WEBVIEW_HOLES = "FixWebViewSecurityHoles";
    public static final Boolean SETTING_FIX_WEBVIEW_HOLES_VALUE;
    public static final String SETTING_GIF_FIRST_FRAME = "GifFirstFrameOnly";
    public static final Boolean SETTING_GIF_FIRST_FRAME_VALUE;
    public static final String SETTING_JS_CHECK_POLICY = "JsCheckPolicy";
    public static final BdJsCheckPolicy SETTING_JS_CHECK_POLICY_VALUE;
    public static final String SETTING_JS_ENABLE_ON_FILE_SCHEMA = "JavaScriptEnabledOnFileScheme";
    public static final Boolean SETTING_JS_ENABLE_ON_FILE_SCHEMA_VALUE;
    public static final String SETTING_MONITOR = "Monitor";
    public static final Boolean SETTING_MONITOR_VALUE;
    public static final String SETTING_NA2_WEB_ENABLE = "NA2WebEnable";
    public static final Boolean SETTING_NA2_WEB_VALUE;
    public static final String SETTING_NIGHT_THEME = "NightTheme";
    public static final Boolean SETTING_NIGHT_THEME_VALUE;
    public static final String SETTING_NO_IMAGE_MODE = "NoImageMode";
    public static final Boolean SETTING_NO_IMAGE_MODE_VALUE;
    public static final String SETTING_PAGE_FREEZE = "PageFreeze";
    public static final String SETTING_PROXY_TYPE = "ProxyType";
    public static final Integer SETTING_PROXY_TYPE_VALUE;
    public static final String SETTING_SAVE_FLOW = "SaveFlow";
    public static final Boolean SETTING_SAVE_FLOW_VALUE;
    public static final String SETTING_SPDY = "Spdy";
    public static final Boolean SETTING_SPDY_VALUE;
    public static final String SETTING_UA_EMULATE = "UaEmulate";
    public static final Boolean SETTING_UA_EMULATE_VALUE;
    public static final String SETTING_URL_SAFE_CHECK = "UrlSafeCheck";
    public static final Boolean SETTING_URL_SAFE_CHECK_VALUE;
    public static final int STATIC_SETTING_SIZE = 16;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, Object> mStaticWebSettings;

    /* loaded from: classes12.dex */
    public interface SettingsStatics {
        void addPreConnectPrefixes(String str);

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

        boolean getInNovelSiteList(String str);

        boolean getInVideoSiteList(String str);

        boolean getIpv6Env();

        int getKeepAliveTime();

        Context getKernelContext();

        int getLevelInfo(String str);

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

        int getSiteTypeInfo(String str);

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

        void setInPageJudgeWhiteList(boolean z, boolean z2);

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

        void updateFixAdblockLevelInfo(String str, int i2, int i3);

        boolean useCronet();
    }

    /* loaded from: classes12.dex */
    public interface Statics {
        int AdBlockInit(String str, boolean z);

        void addToWebCache(String str, boolean z, boolean z2, Map<String, String> map, boolean z3);

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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-750019643, "Lcom/baidu/webkit/sdk/WebViewFactoryProvider;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-750019643, "Lcom/baidu/webkit/sdk/WebViewFactoryProvider;");
                return;
            }
        }
        SETTING_JS_ENABLE_ON_FILE_SCHEMA_VALUE = Boolean.FALSE;
        SETTING_FIX_WEBVIEW_HOLES_VALUE = Boolean.TRUE;
        Boolean bool = Boolean.FALSE;
        SETTING_AD_BLOCK_VALUE = bool;
        SETTING_URL_SAFE_CHECK_VALUE = bool;
        SETTING_SPDY_VALUE = bool;
        SETTING_SAVE_FLOW_VALUE = bool;
        SETTING_GIF_FIRST_FRAME_VALUE = bool;
        SETTING_DEBUG_VALUE = bool;
        SETTING_MONITOR_VALUE = bool;
        SETTING_PROXY_TYPE_VALUE = new Integer(WebSettings.ProxyType.NO_PROXY.ordinal());
        Boolean bool2 = Boolean.FALSE;
        SETTING_UA_EMULATE_VALUE = bool2;
        SETTING_ENABLE_JS_PROMPT_VALUE = bool2;
        SETTING_JS_CHECK_POLICY_VALUE = null;
        SETTING_NIGHT_THEME_VALUE = bool2;
        SETTING_EYE_SHIELD_MODE_VALUE = bool2;
        SETTING_NO_IMAGE_MODE_VALUE = bool2;
        SETTING_NA2_WEB_VALUE = bool2;
    }

    public WebViewFactoryProvider() {
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

    public String[] GetKernelInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new String[0] : (String[]) invokeV.objValue;
    }

    public void RecordUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
        }
    }

    public void commonInitialize() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    public CookieSyncManager createCookieSyncManager(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            return null;
        }
        return (CookieSyncManager) invokeL.objValue;
    }

    public WebViewProvider createWebView(WebView webView, WebView.PrivateAccess privateAccess) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, webView, privateAccess)) == null) {
            return null;
        }
        return (WebViewProvider) invokeLL.objValue;
    }

    public void disableFeature(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
        }
    }

    public void enableFeature(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
        }
    }

    public Object getApisInteractWithMario() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return null;
        }
        return invokeV.objValue;
    }

    public CookieManager getCookieManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return null;
        }
        return (CookieManager) invokeV.objValue;
    }

    public CookieSyncManager getCookieSyncManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return null;
        }
        return (CookieSyncManager) invokeV.objValue;
    }

    public GeolocationPermissions getGeolocationPermissions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return null;
        }
        return (GeolocationPermissions) invokeV.objValue;
    }

    public GeolocationServiceBridge getGeolocationServiceBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return null;
        }
        return (GeolocationServiceBridge) invokeV.objValue;
    }

    public ZeusLogUploader getLogUploader(String str, String str2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048588, this, str, str2, z)) == null) {
            return null;
        }
        return (ZeusLogUploader) invokeLLZ.objValue;
    }

    public MimeTypeMap getMimeTypeMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return null;
        }
        return (MimeTypeMap) invokeV.objValue;
    }

    public NativeRestore getNativeRestoreImpl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            return null;
        }
        return (NativeRestore) invokeL.objValue;
    }

    public PermissionRequest getPermissionRequest(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            return null;
        }
        return (PermissionRequest) invokeL.objValue;
    }

    public WebViewRendererService.ServiceProvider getRendererService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return null;
        }
        return (WebViewRendererService.ServiceProvider) invokeV.objValue;
    }

    public ServiceWorkerController getServiceWorkerController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return null;
        }
        return (ServiceWorkerController) invokeV.objValue;
    }

    public SettingsStatics getSettingsStatics() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return null;
        }
        return (SettingsStatics) invokeV.objValue;
    }

    public Object getStaticWebSeting(String str) {
        InterceptResult invokeL;
        HashMap<String, Object> hashMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            if (TextUtils.isEmpty(str) || (hashMap = this.mStaticWebSettings) == null || !hashMap.containsKey(str)) {
                return null;
            }
            return this.mStaticWebSettings.get(str);
        }
        return invokeL.objValue;
    }

    public Statics getStatics() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return null;
        }
        return (Statics) invokeV.objValue;
    }

    public TracingController getTracingController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return null;
        }
        return (TracingController) invokeV.objValue;
    }

    public UMALogger getUMALogger() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return null;
        }
        return (UMALogger) invokeV.objValue;
    }

    public WebIconDatabase getWebIconDatabase() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return null;
        }
        return (WebIconDatabase) invokeV.objValue;
    }

    public WebStorage getWebStorage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return null;
        }
        return (WebStorage) invokeV.objValue;
    }

    public ClassLoader getWebViewClassLoader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return null;
        }
        return (ClassLoader) invokeV.objValue;
    }

    public WebViewDatabase getWebViewDatabase(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, context)) == null) {
            return null;
        }
        return (WebViewDatabase) invokeL.objValue;
    }

    public String getZeusJarVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    public String getZeusNativeLibraryVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    public void initNet() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
        }
    }

    public void initPageCacheCounts(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, context) == null) {
        }
    }

    public void lazyInitialize() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            Log.i(LOG_TAG, "lazyInitialize");
            VideoPacDownload.tryToDownLoadAsync(WebViewFactory.getContext());
            PacDownload.tryToDownLoadAsyncFreeFlow(WebViewFactory.getContext());
            PacDownload.tryToDownLoadAsync(WebViewFactory.getContext());
        }
    }

    public void onABTestReady() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
        }
    }

    public void onPageKeySectionTimeCostKeySection(WebView webView, String str, int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{webView, str, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
        }
    }

    public void preInitWebView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
        }
    }

    public void setLocation(ZeusGeoLocationInfo zeusGeoLocationInfo, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048611, this, zeusGeoLocationInfo, z) == null) {
        }
    }

    public void setStaticWebSeting(String str, Object obj) {
        HashMap<String, Object> hashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048612, this, str, obj) == null) || TextUtils.isEmpty(str) || (hashMap = this.mStaticWebSettings) == null || !hashMap.containsKey(str)) {
            return;
        }
        this.mStaticWebSettings.put(str, obj);
    }

    public void setWebviewNumber(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, str) == null) {
        }
    }

    public void startBrowserProcess(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
        }
    }
}
