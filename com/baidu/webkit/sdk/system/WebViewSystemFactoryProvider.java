package com.baidu.webkit.sdk.system;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.webkit.WebChromeClient;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes6.dex */
public final class WebViewSystemFactoryProvider extends WebViewFactoryProvider {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String LOGTAG = "WebViewSystemFactoryProvider";
    public static WebViewSystemFactoryProvider mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public CookieManagerImpl mCookieManager;
    public CookieSyncManagerImpl mCookieSyncManager;
    public GeolocationPermissionsImpl mGeolocationPermissions;
    public final Object mLock;
    public MimeTypeMapImpl mMimeTypeMap;
    public ServiceWorkerControllerImpl mServiceWorkerController;
    public TracingControllerImpl mTracingController;
    public WebIconDatabaseImpl mWebIconDatabase;
    public WebStorageImpl mWebStorage;
    public WebViewDatabaseImpl mWebViewDatabase;

    public WebViewSystemFactoryProvider() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mLock = new Object();
        if (this.mStaticWebSettings == null) {
            this.mStaticWebSettings = new HashMap<>(16);
        }
        this.mStaticWebSettings.put(WebViewFactoryProvider.SETTING_JS_ENABLE_ON_FILE_SCHEMA, WebViewFactoryProvider.SETTING_JS_ENABLE_ON_FILE_SCHEMA_VALUE);
        this.mStaticWebSettings.put(WebViewFactoryProvider.SETTING_FIX_WEBVIEW_HOLES, WebViewFactoryProvider.SETTING_FIX_WEBVIEW_HOLES_VALUE);
        this.mStaticWebSettings.put(WebViewFactoryProvider.SETTING_URL_SAFE_CHECK, WebViewFactoryProvider.SETTING_URL_SAFE_CHECK_VALUE);
        this.mStaticWebSettings.put("Debug", WebViewFactoryProvider.SETTING_DEBUG_VALUE);
        this.mStaticWebSettings.put(WebViewFactoryProvider.SETTING_UA_EMULATE, WebViewFactoryProvider.SETTING_UA_EMULATE_VALUE);
        this.mStaticWebSettings.put(WebViewFactoryProvider.SETTING_ENABLE_JS_PROMPT, WebViewFactoryProvider.SETTING_ENABLE_JS_PROMPT_VALUE);
        this.mStaticWebSettings.put(WebViewFactoryProvider.SETTING_JS_CHECK_POLICY, WebViewFactoryProvider.SETTING_JS_CHECK_POLICY_VALUE);
        this.mStaticWebSettings.put(WebViewFactoryProvider.SETTING_NA2_WEB_ENABLE, WebViewFactoryProvider.SETTING_NA2_WEB_VALUE);
    }

    public static synchronized WebViewSystemFactoryProvider getInstance() {
        InterceptResult invokeV;
        WebViewSystemFactoryProvider webViewSystemFactoryProvider;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (WebViewSystemFactoryProvider.class) {
                if (mInstance == null) {
                    Log.i(LOGTAG, "create WebViewSystemFactoryProvider");
                    mInstance = new WebViewSystemFactoryProvider();
                }
                webViewSystemFactoryProvider = mInstance;
            }
            return webViewSystemFactoryProvider;
        }
        return (WebViewSystemFactoryProvider) invokeV.objValue;
    }

    @Override // com.baidu.webkit.sdk.WebViewFactoryProvider
    public final CookieSyncManager createCookieSyncManager(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            android.webkit.CookieSyncManager.createInstance(context);
            return getCookieSyncManager();
        }
        return (CookieSyncManager) invokeL.objValue;
    }

    @Override // com.baidu.webkit.sdk.WebViewFactoryProvider
    public final WebViewProvider createWebView(WebView webView, WebView.PrivateAccess privateAccess) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, privateAccess)) == null) {
            if (webView == null || privateAccess == null) {
                throw new IllegalArgumentException("webView or privateAccess can not be null");
            }
            return new WebViewImpl(webView, privateAccess);
        }
        return (WebViewProvider) invokeLL.objValue;
    }

    @Override // com.baidu.webkit.sdk.WebViewFactoryProvider
    public final CookieManager getCookieManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this.mLock) {
                if (this.mCookieManager == null) {
                    this.mCookieManager = new CookieManagerImpl();
                }
            }
            return this.mCookieManager;
        }
        return (CookieManager) invokeV.objValue;
    }

    @Override // com.baidu.webkit.sdk.WebViewFactoryProvider
    public final CookieSyncManager getCookieSyncManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this.mLock) {
                if (this.mCookieSyncManager == null) {
                    this.mCookieSyncManager = new CookieSyncManagerImpl();
                }
            }
            return this.mCookieSyncManager;
        }
        return (CookieSyncManager) invokeV.objValue;
    }

    @Override // com.baidu.webkit.sdk.WebViewFactoryProvider
    public final GeolocationPermissions getGeolocationPermissions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this.mLock) {
                if (this.mGeolocationPermissions == null) {
                    this.mGeolocationPermissions = new GeolocationPermissionsImpl();
                }
            }
            return this.mGeolocationPermissions;
        }
        return (GeolocationPermissions) invokeV.objValue;
    }

    @Override // com.baidu.webkit.sdk.WebViewFactoryProvider
    public final GeolocationServiceBridge getGeolocationServiceBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return null;
        }
        return (GeolocationServiceBridge) invokeV.objValue;
    }

    @Override // com.baidu.webkit.sdk.WebViewFactoryProvider
    public final MimeTypeMap getMimeTypeMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this.mLock) {
                if (this.mMimeTypeMap == null) {
                    this.mMimeTypeMap = new MimeTypeMapImpl();
                }
            }
            return this.mMimeTypeMap;
        }
        return (MimeTypeMap) invokeV.objValue;
    }

    @Override // com.baidu.webkit.sdk.WebViewFactoryProvider
    public final NativeRestore getNativeRestoreImpl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            return null;
        }
        return (NativeRestore) invokeL.objValue;
    }

    @Override // com.baidu.webkit.sdk.WebViewFactoryProvider
    public final ServiceWorkerController getServiceWorkerController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            synchronized (this.mLock) {
                if (this.mServiceWorkerController == null) {
                    this.mServiceWorkerController = new ServiceWorkerControllerImpl();
                }
            }
            return this.mServiceWorkerController;
        }
        return (ServiceWorkerController) invokeV.objValue;
    }

    @Override // com.baidu.webkit.sdk.WebViewFactoryProvider
    public final WebViewFactoryProvider.SettingsStatics getSettingsStatics() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? new WebViewFactoryProvider.SettingsStatics(this) { // from class: com.baidu.webkit.sdk.system.WebViewSystemFactoryProvider.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ WebViewSystemFactoryProvider this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void addPreConnectPrefixes(String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public boolean canUseFreeFlow() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    return false;
                }
                return invokeV2.booleanValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void clearNetworkFlow() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void clearSavingBytes() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public long generateBKDRHash(String str) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048580, this, str)) == null) {
                    return -1L;
                }
                return invokeL.longValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public String getAppId() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048581, this)) == null) {
                    return null;
                }
                return (String) invokeV2.objValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public boolean getChromiunNetInit() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048582, this)) == null) {
                    return false;
                }
                return invokeV2.booleanValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public String getCloudHost() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048583, this)) == null) {
                    return null;
                }
                return (String) invokeV2.objValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public String getCloudSettingUrl() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                    return null;
                }
                return (String) invokeV2.objValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public boolean getCronetEnable() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048585, this)) == null) {
                    return false;
                }
                return invokeV2.booleanValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public String getCuid() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048586, this)) == null) {
                    return null;
                }
                return (String) invokeV2.objValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public String getDNSStatistic() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048587, this)) == null) {
                    return null;
                }
                return (String) invokeV2.objValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public boolean getDitingMaxForceLoadSwitch() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048588, this)) == null) {
                    return false;
                }
                return invokeV2.booleanValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public String getDnsInfo(String str) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048589, this, str)) == null) {
                    return null;
                }
                return (String) invokeL.objValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public int getDownTraffic() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048590, this)) == null) {
                    return 0;
                }
                return invokeV2.intValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public boolean getEnableEngineStat() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048591, this)) == null) {
                    return false;
                }
                return invokeV2.booleanValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public boolean getEnableProxy() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048592, this)) == null) {
                    return false;
                }
                return invokeV2.booleanValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public boolean getEnableSpdy() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048593, this)) == null) {
                    return false;
                }
                return invokeV2.booleanValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public boolean getEnableZeusManager() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048594, this)) == null) {
                    return false;
                }
                return invokeV2.booleanValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public String getEngineStatUrl() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048595, this)) == null) {
                    return null;
                }
                return (String) invokeV2.objValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public String getFakeBaiduUrl() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048596, this)) == null) {
                    return null;
                }
                return (String) invokeV2.objValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public boolean getGifOneFrameEnabled() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048597, this)) == null) {
                    return false;
                }
                return invokeV2.booleanValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public boolean getHttp2Enabled() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048598, this)) == null) {
                    return false;
                }
                return invokeV2.booleanValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public String getHttpCode() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048599, this)) == null) {
                    return null;
                }
                return (String) invokeV2.objValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public String getHttpDnsCache() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048600, this)) == null) {
                    return null;
                }
                return (String) invokeV2.objValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public String getHttpDnsUrl() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048601, this)) == null) {
                    return null;
                }
                return (String) invokeV2.objValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public HttpURLConnection getHttpUrlConnection(String str) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048602, this, str)) == null) {
                    return null;
                }
                return (HttpURLConnection) invokeL.objValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public WebSettings.ImgQuality getImgQuality() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048603, this)) == null) ? WebSettings.ImgQuality.NO_COMPRESS : (WebSettings.ImgQuality) invokeV2.objValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public boolean getInNovelSiteList(String str) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048604, this, str)) == null) {
                    return false;
                }
                return invokeL.booleanValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public boolean getInVideoSiteList(String str) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048605, this, str)) == null) {
                    return false;
                }
                return invokeL.booleanValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public boolean getIpv6Env() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048606, this)) == null) {
                    return false;
                }
                return invokeV2.booleanValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public int getKeepAliveTime() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048607, this)) == null) {
                    return -1;
                }
                return invokeV2.intValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public Context getKernelContext() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048608, this)) == null) {
                    return null;
                }
                return (Context) invokeV2.objValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public int getLevelInfo(String str) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048609, this, str)) == null) {
                    return -1;
                }
                return invokeL.intValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public String getLocalDns() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048610, this)) == null) {
                    return null;
                }
                return (String) invokeV2.objValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public int getLogLevel() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048611, this)) == null) {
                    return -1;
                }
                return invokeV2.intValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public boolean getMF30Inited() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048612, this)) == null) {
                    return false;
                }
                return invokeV2.booleanValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public String getMLModelUrl() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048613, this)) == null) {
                    return null;
                }
                return (String) invokeV2.objValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public String getMainFrameIdInfo(int i) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeI = interceptable2.invokeI(1048614, this, i)) == null) {
                    return null;
                }
                return (String) invokeI.objValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public String getMainFrameIdReferrer(int i) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeI = interceptable2.invokeI(1048615, this, i)) == null) {
                    return null;
                }
                return (String) invokeI.objValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public boolean getMainLinkDirectEnabled() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048616, this)) == null) {
                    return false;
                }
                return invokeV2.booleanValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public String getMfJsUrl() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048617, this)) == null) {
                    return null;
                }
                return (String) invokeV2.objValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public int getNQE() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048618, this)) == null) {
                    return 0;
                }
                return invokeV2.intValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public int getNetworkFlow() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048619, this)) == null) {
                    return 0;
                }
                return invokeV2.intValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public int getNetworkRtt() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048620, this)) == null) {
                    return 0;
                }
                return invokeV2.intValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public int getNetworkSpeed() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048621, this)) == null) {
                    return 0;
                }
                return invokeV2.intValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public boolean getOnePacketEnabled() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048622, this)) == null) {
                    return false;
                }
                return invokeV2.booleanValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public boolean getPFLogEnabled() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048623, this)) == null) {
                    return false;
                }
                return invokeV2.booleanValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public String getPacUrl() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048624, this)) == null) {
                    return null;
                }
                return (String) invokeV2.objValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public String getPageFeature(String str) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048625, this, str)) == null) {
                    return null;
                }
                return (String) invokeL.objValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public String getPageWormHoleErrors() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048626, this)) == null) {
                    return null;
                }
                return (String) invokeV2.objValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public int getPopupWindowNum() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048627, this)) == null) {
                    return 0;
                }
                return invokeV2.intValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public String getProxyInfo() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048628, this)) == null) {
                    return null;
                }
                return (String) invokeV2.objValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public String getQuicHost() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048629, this)) == null) {
                    return null;
                }
                return (String) invokeV2.objValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public String getQuicInfo() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048630, this)) == null) {
                    return null;
                }
                return (String) invokeV2.objValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public boolean getQuicInit() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048631, this)) == null) {
                    return false;
                }
                return invokeV2.booleanValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public int getQuicThreshold() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048632, this)) == null) {
                    return -1;
                }
                return invokeV2.intValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public String getRc4SecrectKey() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048633, this)) == null) {
                    return null;
                }
                return (String) invokeV2.objValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public WebSettings.RemoveAdLevel getRemoveAdLevel() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048634, this)) == null) ? WebSettings.RemoveAdLevel.DISABLE : (WebSettings.RemoveAdLevel) invokeV2.objValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public int getSavingBytes() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048635, this)) == null) {
                    return 0;
                }
                return invokeV2.intValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public int getSearchDnsMiss() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048636, this)) == null) {
                    return 0;
                }
                return invokeV2.intValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public boolean getSendEngineUsageInfoEnabled() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048637, this)) == null) {
                    return false;
                }
                return invokeV2.booleanValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public boolean getSendRequestEnabled() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048638, this)) == null) {
                    return false;
                }
                return invokeV2.booleanValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public boolean getSessionHeaderEnabled() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048639, this)) == null) {
                    return false;
                }
                return invokeV2.booleanValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public String getSessionUploadUrl() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048640, this)) == null) {
                    return null;
                }
                return (String) invokeV2.objValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public int getSiteTypeInfo(String str) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048641, this, str)) == null) {
                    return -1;
                }
                return invokeL.intValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public String getSkeletonJsUrl() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048642, this)) == null) {
                    return null;
                }
                return (String) invokeV2.objValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public int getSocketGroupNumber() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048643, this)) == null) {
                    return -1;
                }
                return invokeV2.intValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public boolean getSpdy31Enabled() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048644, this)) == null) {
                    return false;
                }
                return invokeV2.booleanValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public boolean getSpdyCompressEnabled() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048645, this)) == null) {
                    return false;
                }
                return invokeV2.booleanValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public boolean getSpdyEncryptionEnabled() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048646, this)) == null) {
                    return false;
                }
                return invokeV2.booleanValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public boolean getSubResourceMonitorEnabled() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048647, this)) == null) {
                    return false;
                }
                return invokeV2.booleanValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public String getSubResourceTiming() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048648, this)) == null) {
                    return null;
                }
                return (String) invokeV2.objValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public boolean getSysProxyEnabled() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048649, this)) == null) {
                    return false;
                }
                return invokeV2.booleanValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public String getTimgConfUrl() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048650, this)) == null) {
                    return null;
                }
                return (String) invokeV2.objValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public int getUpTraffic() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048651, this)) == null) {
                    return 0;
                }
                return invokeV2.intValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public int getVideoPlayerMode() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048652, this)) == null) {
                    return 0;
                }
                return invokeV2.intValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public boolean getWebessenseEnabled() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048653, this)) == null) {
                    return false;
                }
                return invokeV2.booleanValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public boolean getWormholeEnabled() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048654, this)) == null) {
                    return false;
                }
                return invokeV2.booleanValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public String getWormholeForbidenHost() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048655, this)) == null) {
                    return null;
                }
                return (String) invokeV2.objValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public int getWormholeNum(int i) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeI = interceptable2.invokeI(1048656, this, i)) == null) {
                    return 0;
                }
                return invokeI.intValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public String getZeusManagerPkgName() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048657, this)) == null) {
                    return null;
                }
                return (String) invokeV2.objValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public String getZeusResourceUrl() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048658, this)) == null) {
                    return null;
                }
                return (String) invokeV2.objValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public boolean hasQuicAltService(String str) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048659, this, str)) == null) {
                    return false;
                }
                return invokeL.booleanValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void initCronet(Context context) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048660, this, context) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public boolean isFeedNoProxyAdUrl(String str) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048661, this, str)) == null) {
                    return false;
                }
                return invokeL.booleanValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public boolean isFeedProxyAdUrl(String str) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048662, this, str)) == null) {
                    return false;
                }
                return invokeL.booleanValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public boolean isShowWebProviderBy() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048663, this)) == null) {
                    return false;
                }
                return invokeV2.booleanValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public ByteBuffer kernelBrotliCreate(long[] jArr) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048664, this, jArr)) == null) ? ByteBuffer.allocate(0) : (ByteBuffer) invokeL.objValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void kernelBrotliDestroy(long[] jArr) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048665, this, jArr) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public ByteBuffer kernelBrotliPull(long[] jArr) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048666, this, jArr)) == null) ? ByteBuffer.allocate(0) : (ByteBuffer) invokeL.objValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void kernelBrotliPush(long[] jArr, int i) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLI(1048667, this, jArr, i) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void kernelEncrypt(byte[] bArr, int i, byte[] bArr2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLIL(1048668, this, bArr, i, bArr2) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void notifyBdAppStatusChange(int i) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048669, this, i) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void removeDnsInfo(String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048670, this, str) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void removeMainFrameIdInfo(int i) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048671, this, i) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setAltServiceToBlink(String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048672, this, str) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setAppId(String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048673, this, str) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setAppStatus(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(1048674, this, z) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setBackupDnsJobDelayTime(int i) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048675, this, i) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setBackupJobDelayTime(int i) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048676, this, i) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setBackupLandingJobDelayTime(int i) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048677, this, i) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setClientIP(String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048678, this, str) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setCloudSettingsToT5(String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048679, this, str) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setConThreshold(int i) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048680, this, i) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setCuid(String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048681, this, str) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setDitingMaxEnabled(boolean z, boolean z2, boolean z3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048682, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setEnableEngineStat(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(1048683, this, z) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setEnableProxy(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(1048684, this, z) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setEnableSpdy(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(1048685, this, z) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setEnableZeusManager(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(1048686, this, z) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setEngineStatUrl(String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048687, this, str) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setEvilPageWhiteBlackListPath(String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048688, this, str) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setFakeBaiduWhiteList(String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048689, this, str) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setFastPac(String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048690, this, str) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setFileInIOEnabled(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(1048691, this, z) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setFreeFlow(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(1048692, this, z) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setGifOneFrameEnabled(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(1048693, this, z) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setHijackEnv(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(1048694, this, z) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setHisHijackStopAbEnable(int i) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048695, this, i) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setHttpDnsCache(String str, int i) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLI(1048696, this, str, i) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setHttpDnsDnFailed(String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048697, this, str) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setIPV6CheckList(String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048698, this, str) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setIPV6Timeout(int i) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048699, this, i) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setImgQuality(WebSettings.ImgQuality imgQuality) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048700, this, imgQuality) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setImproveContentCache(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(1048701, this, z) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setInPageJudgeWhiteList(boolean z, boolean z2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048702, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setIpv6First(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(1048703, this, z) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setKeepAliveTime(int i) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048704, this, i) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setMLModel(String str, String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048705, this, str, str2) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setMainLinkDirectEnabled(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(1048706, this, z) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setMaxFatalAllocationFailureSize(int i) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048707, this, i) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setMulripleConnectEnabled(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(1048708, this, z) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setNativeHttpdnsEnabled(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(1048709, this, z) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setNavigationInterceptionEnable(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(1048710, this, z) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setNeedDownloadCloudResource(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(1048711, this, z) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setNetWorkChangeNotifyEnabled(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(1048712, this, z) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setOnePacketEnabled(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(1048713, this, z) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setPacData(String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048714, this, str) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setPacDataFreeFlow(String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048715, this, str) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setPacUrl(String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048716, this, str) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setPopupWindowOptEnabled(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(1048717, this, z) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setPreConnectEnabled(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(1048718, this, z) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setProxyInfo(String str, String[] strArr) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048719, this, str, strArr) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setProxyType(int i) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048720, this, i) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setQuicDefaultOpen(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(1048721, this, z) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setQuicThreshold(int i) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048722, this, i) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setRefererPattern(String str, String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048723, this, str, str2) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setRemoveAdLevel(WebSettings.RemoveAdLevel removeAdLevel) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048724, this, removeAdLevel) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setSearchFrameQuicEnabled(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(1048725, this, z) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setSendEngineUsageInfoEnabled(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(1048726, this, z) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setSessionHeaderEnabled(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(1048727, this, z) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setShowWebProviderBy(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(1048728, this, z) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setSocketGroupNumber(int i) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048729, this, i) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setSpdyCompressEnabled(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(1048730, this, z) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setSpdyEncryptionEnabled(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(1048731, this, z) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setSpdyTimeout(int i) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048732, this, i) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setStatisticParam(String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048733, this, str) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setSubResourceMonitorEnabled(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(1048734, this, z) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setT5SDKSpdyEnabled(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(1048735, this, z) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setTcSpeedUpEnabled(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(1048736, this, z) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setTimgConfData(String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048737, this, str) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setTimgConfUrl(String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048738, this, str) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setVideoPlayerMode(int i) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048739, this, i) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setWebessenseEnabled(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(1048740, this, z) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setWhiteAndBlackList(String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048741, this, str) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setWormholeEnabled(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(1048742, this, z) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void setZeusManagerPkgName(String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048743, this, str) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public boolean shouldAccessNetworkOverSpdy(String str) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048744, this, str)) == null) {
                    return false;
                }
                return invokeL.booleanValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public void updateFixAdblockLevelInfo(String str, int i, int i2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLII(1048745, this, str, i, i2) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.SettingsStatics
            public boolean useCronet() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048746, this)) == null) {
                    return false;
                }
                return invokeV2.booleanValue;
            }
        } : (WebViewFactoryProvider.SettingsStatics) invokeV.objValue;
    }

    @Override // com.baidu.webkit.sdk.WebViewFactoryProvider
    public final WebViewFactoryProvider.Statics getStatics() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? new WebViewFactoryProvider.Statics(this) { // from class: com.baidu.webkit.sdk.system.WebViewSystemFactoryProvider.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ WebViewSystemFactoryProvider this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.Statics
            public int AdBlockInit(String str, boolean z) {
                InterceptResult invokeLZ;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLZ = interceptable2.invokeLZ(1048576, this, str, z)) == null) {
                    return -1;
                }
                return invokeLZ.intValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.Statics
            public void addToWebCache(String str, boolean z, boolean z2, Map<String, String> map, boolean z3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2), map, Boolean.valueOf(z3)}) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.Statics
            public void addVirtualMemoryListener(WebView.IVirtualMemoryListener iVirtualMemoryListener) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, iVirtualMemoryListener) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.Statics
            public void cancelPrefetch(String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048579, this, str) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.Statics
            public void cancelResourcePrefetch(String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048580, this, str) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.Statics
            public void clearClientCertPreferences(Runnable runnable) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048581, this, runnable) == null) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        android.webkit.WebView.clearClientCertPreferences(runnable);
                    } else if (runnable != null) {
                        new Handler().post(runnable);
                    }
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.Statics
            public void clearPageCacheCounts() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048582, this) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.Statics
            public void crashIntentionally(int i) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048583, this, i) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.Statics
            public void enableSlowWholeDocumentDraw() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || Build.VERSION.SDK_INT < 21) {
                    return;
                }
                android.webkit.WebView.enableSlowWholeDocumentDraw();
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.Statics
            public String findAddress(String str) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048585, this, str)) == null) ? android.webkit.WebView.findAddress(str) : (String) invokeL.objValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.Statics
            public void freeMemoryForTests() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048586, this) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.Statics
            public HashMap<String, Long> getCurrentSystemInfraInfo() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048587, this)) == null) {
                    return null;
                }
                return (HashMap) invokeV2.objValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.Statics
            public String getDefaultUserAgent(Context context) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048588, this, context)) == null) ? Build.VERSION.SDK_INT >= 17 ? android.webkit.WebSettings.getDefaultUserAgent(context) : "" : (String) invokeL.objValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.Statics
            public String getZeusSeriesNum(int i, int i2, int i3) {
                InterceptResult invokeIII;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeIII = interceptable2.invokeIII(1048589, this, i, i2, i3)) == null) ? "" : (String) invokeIII.objValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.Statics
            public int historyNavigationCount() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048590, this)) == null) {
                    return 0;
                }
                return invokeV2.intValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.Statics
            public void initPageCacheCounts(Context context) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048591, this, context) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.Statics
            public boolean isInWebCache(String str) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048592, this, str)) == null) {
                    return false;
                }
                return invokeL.booleanValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.Statics
            public void makeMF30Inited() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048593, this) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.Statics
            public void onMemoryPresure(int i, Activity activity) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(1048594, this, i, activity) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.Statics
            public int pageCacheCount() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048595, this)) == null) {
                    return 0;
                }
                return invokeV2.intValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.Statics
            public Uri[] parseFileChooserResult(int i, Intent intent) {
                InterceptResult invokeIL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeIL = interceptable2.invokeIL(1048596, this, i, intent)) == null) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        return WebChromeClient.FileChooserParams.parseResult(i, intent);
                    }
                    Uri data = (intent == null || i != -1) ? null : intent.getData();
                    if (data == null) {
                        return null;
                    }
                    return new Uri[]{data};
                }
                return (Uri[]) invokeIL.objValue;
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.Statics
            public void preconnectUrl(String str, int i) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLI(1048597, this, str, i) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.Statics
            public void prefetch(String str, Map<String, String> map, WebView.MainResourcePrefetchListener mainResourcePrefetchListener) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(1048598, this, str, map, mainResourcePrefetchListener) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.Statics
            public void prefetchResource(String str, String[] strArr, Map<String, String> map) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(1048599, this, str, strArr, map) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.Statics
            public void removeFromWebCache(String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048600, this, str) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.Statics
            public void removeVirtualMemoryWatcher(WebView.IVirtualMemoryListener iVirtualMemoryListener) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048601, this, iVirtualMemoryListener) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.Statics
            public void resolveUrl(String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048602, this, str) == null) {
                }
            }

            @Override // com.baidu.webkit.sdk.WebViewFactoryProvider.Statics
            public void setWebContentsDebuggingEnabled(boolean z) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeZ(1048603, this, z) == null) || Build.VERSION.SDK_INT < 19) {
                    return;
                }
                android.webkit.WebView.setWebContentsDebuggingEnabled(z);
            }
        } : (WebViewFactoryProvider.Statics) invokeV.objValue;
    }

    @Override // com.baidu.webkit.sdk.WebViewFactoryProvider
    public final TracingController getTracingController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            synchronized (this.mLock) {
                if (this.mTracingController == null) {
                    this.mTracingController = new TracingControllerImpl();
                }
            }
            return this.mTracingController;
        }
        return (TracingController) invokeV.objValue;
    }

    @Override // com.baidu.webkit.sdk.WebViewFactoryProvider
    public final WebIconDatabase getWebIconDatabase() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            synchronized (this.mLock) {
                if (this.mWebIconDatabase == null) {
                    this.mWebIconDatabase = new WebIconDatabaseImpl();
                }
            }
            return this.mWebIconDatabase;
        }
        return (WebIconDatabase) invokeV.objValue;
    }

    @Override // com.baidu.webkit.sdk.WebViewFactoryProvider
    public final WebStorage getWebStorage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            synchronized (this.mLock) {
                if (this.mWebStorage == null) {
                    this.mWebStorage = new WebStorageImpl();
                }
            }
            return this.mWebStorage;
        }
        return (WebStorage) invokeV.objValue;
    }

    @Override // com.baidu.webkit.sdk.WebViewFactoryProvider
    @TargetApi(28)
    public final ClassLoader getWebViewClassLoader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                return android.webkit.WebView.getWebViewClassLoader();
            }
            return null;
        }
        return (ClassLoader) invokeV.objValue;
    }

    @Override // com.baidu.webkit.sdk.WebViewFactoryProvider
    public final WebViewDatabase getWebViewDatabase(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, context)) == null) {
            synchronized (this.mLock) {
                if (this.mWebViewDatabase == null && context != null) {
                    this.mWebViewDatabase = new WebViewDatabaseImpl(context);
                }
            }
            return this.mWebViewDatabase;
        }
        return (WebViewDatabase) invokeL.objValue;
    }

    @Override // com.baidu.webkit.sdk.WebViewFactoryProvider
    public final String getZeusJarVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? "" : (String) invokeV.objValue;
    }

    @Override // com.baidu.webkit.sdk.WebViewFactoryProvider
    public final String getZeusNativeLibraryVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? "" : (String) invokeV.objValue;
    }

    @Override // com.baidu.webkit.sdk.WebViewFactoryProvider
    public final void initPageCacheCounts(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, context) == null) {
        }
    }

    @Override // com.baidu.webkit.sdk.WebViewFactoryProvider
    public final void setLocation(ZeusGeoLocationInfo zeusGeoLocationInfo, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048595, this, zeusGeoLocationInfo, z) == null) {
        }
    }
}
