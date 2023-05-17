package com.baidu.webkit.sdk.system;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.webkit.WebChromeClient;
import com.baidu.webkit.sdk.CookieManager;
import com.baidu.webkit.sdk.CookieSyncManager;
import com.baidu.webkit.sdk.GeolocationPermissions;
import com.baidu.webkit.sdk.GeolocationServiceBridge;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.MimeTypeMap;
import com.baidu.webkit.sdk.NativeRestore;
import com.baidu.webkit.sdk.ServiceWorkerController;
import com.baidu.webkit.sdk.TracingController;
import com.baidu.webkit.sdk.WebIconDatabase;
import com.baidu.webkit.sdk.WebSettings;
import com.baidu.webkit.sdk.WebStorage;
import com.baidu.webkit.sdk.WebView;
import com.baidu.webkit.sdk.WebViewDatabase;
import com.baidu.webkit.sdk.WebViewFactoryProvider;
import com.baidu.webkit.sdk.WebViewProvider;
import com.baidu.webkit.sdk.location.ZeusGeoLocationInfo;
import java.net.HttpURLConnection;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public final class WebViewSystemFactoryProvider extends WebViewFactoryProvider {
    public static final String LOGTAG = "WebViewSystemFactoryProvider";
    public static WebViewSystemFactoryProvider mInstance;
    public CookieManagerImpl mCookieManager;
    public CookieSyncManagerImpl mCookieSyncManager;
    public GeolocationPermissionsImpl mGeolocationPermissions;
    public final Object mLock = new Object();
    public MimeTypeMapImpl mMimeTypeMap;
    public ServiceWorkerControllerImpl mServiceWorkerController;
    public TracingControllerImpl mTracingController;
    public WebIconDatabaseImpl mWebIconDatabase;
    public WebStorageImpl mWebStorage;
    public WebViewDatabaseImpl mWebViewDatabase;

    public WebViewSystemFactoryProvider() {
        if (this.mStaticWebSettings == null) {
            this.mStaticWebSettings = new HashMap<>(16);
        }
        this.mStaticWebSettings.put(WebViewFactoryProvider.SETTING_JS_ENABLE_ON_FILE_SCHEMA, WebViewFactoryProvider.SETTING_JS_ENABLE_ON_FILE_SCHEMA_VALUE);
        this.mStaticWebSettings.put(WebViewFactoryProvider.SETTING_FIX_WEBVIEW_HOLES, WebViewFactoryProvider.SETTING_FIX_WEBVIEW_HOLES_VALUE);
        this.mStaticWebSettings.put(WebViewFactoryProvider.SETTING_URL_SAFE_CHECK, WebViewFactoryProvider.SETTING_URL_SAFE_CHECK_VALUE);
        this.mStaticWebSettings.put(WebViewFactoryProvider.SETTING_DEBUG, WebViewFactoryProvider.SETTING_DEBUG_VALUE);
        this.mStaticWebSettings.put(WebViewFactoryProvider.SETTING_UA_EMULATE, WebViewFactoryProvider.SETTING_UA_EMULATE_VALUE);
        this.mStaticWebSettings.put(WebViewFactoryProvider.SETTING_ENABLE_JS_PROMPT, WebViewFactoryProvider.SETTING_ENABLE_JS_PROMPT_VALUE);
        this.mStaticWebSettings.put(WebViewFactoryProvider.SETTING_JS_CHECK_POLICY, WebViewFactoryProvider.SETTING_JS_CHECK_POLICY_VALUE);
        this.mStaticWebSettings.put(WebViewFactoryProvider.SETTING_NA2_WEB_ENABLE, WebViewFactoryProvider.SETTING_NA2_WEB_VALUE);
    }

    public static synchronized WebViewSystemFactoryProvider getInstance() {
        WebViewSystemFactoryProvider webViewSystemFactoryProvider;
        synchronized (WebViewSystemFactoryProvider.class) {
            if (mInstance == null) {
                Log.i(LOGTAG, "create WebViewSystemFactoryProvider");
                mInstance = new WebViewSystemFactoryProvider();
            }
            webViewSystemFactoryProvider = mInstance;
        }
        return webViewSystemFactoryProvider;
    }

    @Override // com.baidu.webkit.sdk.WebViewFactoryProvider
    public final CookieSyncManager createCookieSyncManager(Context context) {
        android.webkit.CookieSyncManager.createInstance(context);
        return getCookieSyncManager();
    }

    @Override // com.baidu.webkit.sdk.WebViewFactoryProvider
    public final WebViewProvider createWebView(WebView webView, WebView.PrivateAccess privateAccess) {
        if (webView == null || privateAccess == null) {
            throw new IllegalArgumentException("webView or privateAccess can not be null");
        }
        return new WebViewImpl(webView, privateAccess);
    }

    @Override // com.baidu.webkit.sdk.WebViewFactoryProvider
    public final CookieManager getCookieManager() {
        synchronized (this.mLock) {
            if (this.mCookieManager == null) {
                this.mCookieManager = new CookieManagerImpl();
            }
        }
        return this.mCookieManager;
    }

    @Override // com.baidu.webkit.sdk.WebViewFactoryProvider
    public final CookieSyncManager getCookieSyncManager() {
        synchronized (this.mLock) {
            if (this.mCookieSyncManager == null) {
                this.mCookieSyncManager = new CookieSyncManagerImpl();
            }
        }
        return this.mCookieSyncManager;
    }

    @Override // com.baidu.webkit.sdk.WebViewFactoryProvider
    public final GeolocationPermissions getGeolocationPermissions() {
        synchronized (this.mLock) {
            if (this.mGeolocationPermissions == null) {
                this.mGeolocationPermissions = new GeolocationPermissionsImpl();
            }
        }
        return this.mGeolocationPermissions;
    }

    @Override // com.baidu.webkit.sdk.WebViewFactoryProvider
    public final GeolocationServiceBridge getGeolocationServiceBridge() {
        return null;
    }

    @Override // com.baidu.webkit.sdk.WebViewFactoryProvider
    public final MimeTypeMap getMimeTypeMap() {
        synchronized (this.mLock) {
            if (this.mMimeTypeMap == null) {
                this.mMimeTypeMap = new MimeTypeMapImpl();
            }
        }
        return this.mMimeTypeMap;
    }

    @Override // com.baidu.webkit.sdk.WebViewFactoryProvider
    public final NativeRestore getNativeRestoreImpl(String str) {
        return null;
    }

    @Override // com.baidu.webkit.sdk.WebViewFactoryProvider
    public final ServiceWorkerController getServiceWorkerController() {
        synchronized (this.mLock) {
            if (this.mServiceWorkerController == null) {
                this.mServiceWorkerController = new ServiceWorkerControllerImpl();
            }
        }
        return this.mServiceWorkerController;
    }

    @Override // com.baidu.webkit.sdk.WebViewFactoryProvider
    public final WebViewFactoryProvider.SettingsStatics getSettingsStatics() {
        return new WebViewFactoryProvider.SettingsStatics() { // from class: com.baidu.webkit.sdk.system.WebViewSystemFactoryProvider.2
            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void addPreConnectPrefixes(String str) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public boolean canUseFreeFlow() {
                return false;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void clearNetworkFlow() {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void clearSavingBytes() {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public long generateBKDRHash(String str) {
                return -1L;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public String getAppId() {
                return null;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public boolean getChromiunNetInit() {
                return false;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public String getCloudHost() {
                return null;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public String getCloudSettingUrl() {
                return null;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public boolean getCronetEnable() {
                return false;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public String getCuid() {
                return null;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public String getDNSStatistic() {
                return null;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public boolean getDitingMaxForceLoadSwitch() {
                return false;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public String getDnsInfo(String str) {
                return null;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public int getDownTraffic() {
                return 0;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public boolean getEnableEngineStat() {
                return false;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public boolean getEnableProxy() {
                return false;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public boolean getEnableSpdy() {
                return false;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public boolean getEnableZeusManager() {
                return false;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public String getEngineStatUrl() {
                return null;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public String getFakeBaiduUrl() {
                return null;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public boolean getGifOneFrameEnabled() {
                return false;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public boolean getHttp2Enabled() {
                return false;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public String getHttpCode() {
                return null;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public String getHttpDnsCache() {
                return null;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public String getHttpDnsUrl() {
                return null;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public HttpURLConnection getHttpUrlConnection(String str) {
                return null;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public WebSettings.ImgQuality getImgQuality() {
                return WebSettings.ImgQuality.NO_COMPRESS;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public boolean getInNovelSiteList(String str) {
                return false;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public boolean getInVideoSiteList(String str) {
                return false;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public boolean getIpv6Env() {
                return false;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public int getKeepAliveTime() {
                return -1;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public Context getKernelContext() {
                return null;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public int getLevelInfo(String str) {
                return -1;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public String getLocalDns() {
                return null;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public int getLogLevel() {
                return -1;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public boolean getMF30Inited() {
                return false;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public String getMLModelUrl() {
                return null;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public String getMainFrameIdInfo(int i) {
                return null;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public String getMainFrameIdReferrer(int i) {
                return null;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public boolean getMainLinkDirectEnabled() {
                return false;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public String getMfJsUrl() {
                return null;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public int getNQE() {
                return 0;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public int getNetworkFlow() {
                return 0;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public int getNetworkRtt() {
                return 0;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public int getNetworkSpeed() {
                return 0;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public boolean getOnePacketEnabled() {
                return false;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public boolean getPFLogEnabled() {
                return false;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public String getPacUrl() {
                return null;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public String getPageFeature(String str) {
                return null;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public String getPageWormHoleErrors() {
                return null;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public int getPopupWindowNum() {
                return 0;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public String getProxyInfo() {
                return null;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public String getQuicHost() {
                return null;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public String getQuicInfo() {
                return null;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public boolean getQuicInit() {
                return false;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public int getQuicThreshold() {
                return -1;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public String getRc4SecrectKey() {
                return null;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public WebSettings.RemoveAdLevel getRemoveAdLevel() {
                return WebSettings.RemoveAdLevel.DISABLE;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public int getSavingBytes() {
                return 0;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public int getSearchDnsMiss() {
                return 0;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public boolean getSendEngineUsageInfoEnabled() {
                return false;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public boolean getSendRequestEnabled() {
                return false;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public boolean getSessionHeaderEnabled() {
                return false;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public String getSessionUploadUrl() {
                return null;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public int getSiteTypeInfo(String str) {
                return -1;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public String getSkeletonJsUrl() {
                return null;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public int getSocketGroupNumber() {
                return -1;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public boolean getSpdy31Enabled() {
                return false;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public boolean getSpdyCompressEnabled() {
                return false;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public boolean getSpdyEncryptionEnabled() {
                return false;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public boolean getSubResourceMonitorEnabled() {
                return false;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public String getSubResourceTiming() {
                return null;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public boolean getSysProxyEnabled() {
                return false;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public String getTimgConfUrl() {
                return null;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public int getUpTraffic() {
                return 0;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public int getVideoPlayerMode() {
                return 0;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public boolean getWebessenseEnabled() {
                return false;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public boolean getWormholeEnabled() {
                return false;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public String getWormholeForbidenHost() {
                return null;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public int getWormholeNum(int i) {
                return 0;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public String getZeusManagerPkgName() {
                return null;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public String getZeusResourceUrl() {
                return null;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public boolean hasQuicAltService(String str) {
                return false;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void initCronet(Context context) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public boolean isFeedNoProxyAdUrl(String str) {
                return false;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public boolean isFeedProxyAdUrl(String str) {
                return false;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public boolean isShowWebProviderBy() {
                return false;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public ByteBuffer kernelBrotliCreate(long[] jArr) {
                return ByteBuffer.allocate(0);
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void kernelBrotliDestroy(long[] jArr) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public ByteBuffer kernelBrotliPull(long[] jArr) {
                return ByteBuffer.allocate(0);
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void kernelBrotliPush(long[] jArr, int i) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void kernelEncrypt(byte[] bArr, int i, byte[] bArr2) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void notifyBdAppStatusChange(int i) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void removeDnsInfo(String str) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void removeMainFrameIdInfo(int i) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setAltServiceToBlink(String str) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setAppId(String str) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setAppStatus(boolean z) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setBackupDnsJobDelayTime(int i) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setBackupJobDelayTime(int i) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setBackupLandingJobDelayTime(int i) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setClientIP(String str) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setCloudSettingsToT5(String str) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setConThreshold(int i) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setCuid(String str) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setDitingMaxEnabled(boolean z, boolean z2, boolean z3) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setEnableEngineStat(boolean z) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setEnableProxy(boolean z) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setEnableSpdy(boolean z) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setEnableZeusManager(boolean z) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setEngineStatUrl(String str) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setEvilPageWhiteBlackListPath(String str) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setFakeBaiduWhiteList(String str) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setFastPac(String str) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setFileInIOEnabled(boolean z) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setFreeFlow(boolean z) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setGifOneFrameEnabled(boolean z) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setHijackEnv(boolean z) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setHisHijackStopAbEnable(int i) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setHttpDnsCache(String str, int i) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setHttpDnsDnFailed(String str) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setIPV6CheckList(String str) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setIPV6Timeout(int i) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setImgQuality(WebSettings.ImgQuality imgQuality) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setImproveContentCache(boolean z) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setInPageJudgeWhiteList(boolean z, boolean z2) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setIpv6First(boolean z) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setKeepAliveTime(int i) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setMLModel(String str, String str2) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setMainLinkDirectEnabled(boolean z) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setMaxFatalAllocationFailureSize(int i) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setMulripleConnectEnabled(boolean z) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setNativeHttpdnsEnabled(boolean z) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setNavigationInterceptionEnable(boolean z) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setNeedDownloadCloudResource(boolean z) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setNetWorkChangeNotifyEnabled(boolean z) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setOnePacketEnabled(boolean z) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setPacData(String str) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setPacDataFreeFlow(String str) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setPacUrl(String str) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setPopupWindowOptEnabled(boolean z) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setPreConnectEnabled(boolean z) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setProxyInfo(String str, String[] strArr) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setProxyType(int i) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setQuicDefaultOpen(boolean z) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setQuicThreshold(int i) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setRefererPattern(String str, String str2) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setRemoveAdLevel(WebSettings.RemoveAdLevel removeAdLevel) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setSearchFrameQuicEnabled(boolean z) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setSendEngineUsageInfoEnabled(boolean z) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setSessionHeaderEnabled(boolean z) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setShowWebProviderBy(boolean z) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setSocketGroupNumber(int i) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setSpdyCompressEnabled(boolean z) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setSpdyEncryptionEnabled(boolean z) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setSpdyTimeout(int i) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setStatisticParam(String str) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setSubResourceMonitorEnabled(boolean z) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setT5SDKSpdyEnabled(boolean z) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setTcSpeedUpEnabled(boolean z) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setTimgConfData(String str) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setTimgConfUrl(String str) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setVideoPlayerMode(int i) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setWebessenseEnabled(boolean z) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setWhiteAndBlackList(String str) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setWormholeEnabled(boolean z) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setZeusManagerPkgName(String str) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public boolean shouldAccessNetworkOverSpdy(String str) {
                return false;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void updateFixAdblockLevelInfo(String str, int i, int i2) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public boolean useCronet() {
                return false;
            }
        };
    }

    @Override // com.baidu.webkit.sdk.WebViewFactoryProvider
    public final WebViewFactoryProvider.Statics getStatics() {
        return new WebViewFactoryProvider.Statics() { // from class: com.baidu.webkit.sdk.system.WebViewSystemFactoryProvider.1
            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.Statics
            public int AdBlockInit(String str, boolean z) {
                return -1;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.Statics
            public void addToWebCache(String str, boolean z, boolean z2, Map<String, String> map, boolean z3) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.Statics
            public void addVirtualMemoryListener(WebView.IVirtualMemoryListener iVirtualMemoryListener) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.Statics
            public void cancelPrefetch(String str) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.Statics
            public void cancelResourcePrefetch(String str) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.Statics
            public void clearClientCertPreferences(Runnable runnable) {
                if (Build.VERSION.SDK_INT >= 21) {
                    android.webkit.WebView.clearClientCertPreferences(runnable);
                } else if (runnable != null) {
                    new Handler().post(runnable);
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.Statics
            public void clearPageCacheCounts() {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.Statics
            public void crashIntentionally(int i) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.Statics
            public void enableSlowWholeDocumentDraw() {
                if (Build.VERSION.SDK_INT >= 21) {
                    android.webkit.WebView.enableSlowWholeDocumentDraw();
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.Statics
            public String findAddress(String str) {
                return android.webkit.WebView.findAddress(str);
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.Statics
            public void freeMemoryForTests() {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.Statics
            public HashMap<String, Long> getCurrentSystemInfraInfo() {
                return null;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.Statics
            public String getDefaultUserAgent(Context context) {
                return Build.VERSION.SDK_INT >= 17 ? android.webkit.WebSettings.getDefaultUserAgent(context) : "";
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.Statics
            public String getZeusSeriesNum(int i, int i2, int i3) {
                return "";
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.Statics
            public int historyNavigationCount() {
                return 0;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.Statics
            public void initPageCacheCounts(Context context) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.Statics
            public boolean isInWebCache(String str) {
                return false;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.Statics
            public void makeMF30Inited() {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.Statics
            public void onMemoryPresure(int i, Activity activity) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.Statics
            public int pageCacheCount() {
                return 0;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.Statics
            public Uri[] parseFileChooserResult(int i, Intent intent) {
                if (Build.VERSION.SDK_INT >= 21) {
                    return WebChromeClient.FileChooserParams.parseResult(i, intent);
                }
                Uri data = (intent == null || i != -1) ? null : intent.getData();
                if (data == null) {
                    return null;
                }
                return new Uri[]{data};
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.Statics
            public void preconnectUrl(String str, int i) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.Statics
            public void prefetch(String str, Map<String, String> map, WebView.MainResourcePrefetchListener mainResourcePrefetchListener) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.Statics
            public void prefetchResource(String str, String[] strArr, Map<String, String> map) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.Statics
            public void removeFromWebCache(String str) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.Statics
            public void removeVirtualMemoryWatcher(WebView.IVirtualMemoryListener iVirtualMemoryListener) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.Statics
            public void resolveUrl(String str) {
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.Statics
            public void setWebContentsDebuggingEnabled(boolean z) {
                if (Build.VERSION.SDK_INT >= 19) {
                    android.webkit.WebView.setWebContentsDebuggingEnabled(z);
                }
            }
        };
    }

    @Override // com.baidu.webkit.sdk.WebViewFactoryProvider
    public final TracingController getTracingController() {
        synchronized (this.mLock) {
            if (this.mTracingController == null) {
                this.mTracingController = new TracingControllerImpl();
            }
        }
        return this.mTracingController;
    }

    @Override // com.baidu.webkit.sdk.WebViewFactoryProvider
    public final WebIconDatabase getWebIconDatabase() {
        synchronized (this.mLock) {
            if (this.mWebIconDatabase == null) {
                this.mWebIconDatabase = new WebIconDatabaseImpl();
            }
        }
        return this.mWebIconDatabase;
    }

    @Override // com.baidu.webkit.sdk.WebViewFactoryProvider
    public final WebStorage getWebStorage() {
        synchronized (this.mLock) {
            if (this.mWebStorage == null) {
                this.mWebStorage = new WebStorageImpl();
            }
        }
        return this.mWebStorage;
    }

    @Override // com.baidu.webkit.sdk.WebViewFactoryProvider
    @TargetApi(28)
    public final ClassLoader getWebViewClassLoader() {
        if (Build.VERSION.SDK_INT >= 28) {
            return android.webkit.WebView.getWebViewClassLoader();
        }
        return null;
    }

    @Override // com.baidu.webkit.sdk.WebViewFactoryProvider
    public final WebViewDatabase getWebViewDatabase(Context context) {
        synchronized (this.mLock) {
            if (this.mWebViewDatabase == null && context != null) {
                this.mWebViewDatabase = new WebViewDatabaseImpl(context);
            }
        }
        return this.mWebViewDatabase;
    }

    @Override // com.baidu.webkit.sdk.WebViewFactoryProvider
    public final String getZeusJarVersion() {
        return "";
    }

    @Override // com.baidu.webkit.sdk.WebViewFactoryProvider
    public final String getZeusNativeLibraryVersion() {
        return "";
    }

    @Override // com.baidu.webkit.sdk.WebViewFactoryProvider
    public final void initPageCacheCounts(Context context) {
    }

    @Override // com.baidu.webkit.sdk.WebViewFactoryProvider
    public final void setLocation(ZeusGeoLocationInfo zeusGeoLocationInfo, boolean z) {
    }
}
