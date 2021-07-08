package com.baidu.webkit.sdk.system;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.GlobalConstants;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import com.baidu.webkit.sdk.WebSettings;
import com.baidu.webkit.sdk.WebViewFactoryProvider;
/* loaded from: classes5.dex */
public final class WebSettingsImpl extends WebSettings {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mEnableFileSchemaOnPrivate;
    public android.webkit.WebSettings mSettings;

    public WebSettingsImpl(android.webkit.WebSettings webSettings) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {webSettings};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mEnableFileSchemaOnPrivate = true;
        this.mSettings = webSettings;
    }

    public static WebSettings from(android.webkit.WebSettings webSettings) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, webSettings)) == null) {
            if (webSettings == null) {
                return null;
            }
            return new WebSettingsImpl(webSettings);
        }
        return (WebSettings) invokeL.objValue;
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    @TargetApi(11)
    public final boolean enableSmoothTransition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (Build.VERSION.SDK_INT >= 11) {
                return this.mSettings.enableSmoothTransition();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    @TargetApi(11)
    public final boolean getAllowContentAccess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (Build.VERSION.SDK_INT >= 11) {
                return this.mSettings.getAllowContentAccess();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final boolean getAllowFileAccess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mSettings.getAllowFileAccess() : invokeV.booleanValue;
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    @TargetApi(16)
    public final boolean getAllowFileAccessFromFileURLs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                return this.mSettings.getAllowFileAccessFromFileURLs();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    @TargetApi(16)
    public final boolean getAllowUniversalAccessFromFileURLs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                return this.mSettings.getAllowUniversalAccessFromFileURLs();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final boolean getBlockNetworkImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mSettings.getBlockNetworkImage() : invokeV.booleanValue;
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final boolean getBlockNetworkLoads() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mSettings.getBlockNetworkLoads() : invokeV.booleanValue;
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final boolean getBuiltInZoomControls() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mSettings.getBuiltInZoomControls() : invokeV.booleanValue;
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final int getCacheMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mSettings.getCacheMode() : invokeV.intValue;
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final String getCursiveFontFamily() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mSettings.getCursiveFontFamily() : (String) invokeV.objValue;
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final boolean getDatabaseEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mSettings.getDatabaseEnabled() : invokeV.booleanValue;
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final String getDatabasePath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mSettings.getDatabasePath() : (String) invokeV.objValue;
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final int getDefaultFixedFontSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mSettings.getDefaultFixedFontSize() : invokeV.intValue;
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final int getDefaultFontSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mSettings.getDefaultFontSize() : invokeV.intValue;
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final String getDefaultTextEncodingName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mSettings.getDefaultTextEncodingName() : (String) invokeV.objValue;
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final WebSettings.ZoomDensity getDefaultZoom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? Glue.cast(this.mSettings.getDefaultZoom()) : (WebSettings.ZoomDensity) invokeV.objValue;
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    @TargetApi(24)
    public final int getDisabledActionModeMenuItems() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                return this.mSettings.getDisabledActionModeMenuItems();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    @TargetApi(11)
    public final boolean getDisplayZoomControls() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (Build.VERSION.SDK_INT >= 11) {
                return this.mSettings.getDisplayZoomControls();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final boolean getDomStorageEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mSettings.getDomStorageEnabled() : invokeV.booleanValue;
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final boolean getEnableFileSchemaOnPrivate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.mEnableFileSchemaOnPrivate : invokeV.booleanValue;
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final boolean getEnableJsPrompt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.mEnableJsPrompt : invokeV.booleanValue;
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final String getFantasyFontFamily() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.mSettings.getFantasyFontFamily() : (String) invokeV.objValue;
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final String getFixedFontFamily() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.mSettings.getFixedFontFamily() : (String) invokeV.objValue;
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final boolean getJavaScriptCanOpenWindowsAutomatically() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.mSettings.getJavaScriptCanOpenWindowsAutomatically() : invokeV.booleanValue;
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final boolean getJavaScriptEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.mSettings.getJavaScriptEnabled() : invokeV.booleanValue;
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final WebSettings.LayoutAlgorithm getLayoutAlgorithm() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? Glue.cast(this.mSettings.getLayoutAlgorithm()) : (WebSettings.LayoutAlgorithm) invokeV.objValue;
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final boolean getLightTouchEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.mSettings.getLightTouchEnabled() : invokeV.booleanValue;
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final boolean getLoadWithOverviewMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.mSettings.getLoadWithOverviewMode() : invokeV.booleanValue;
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final boolean getLoadsImagesAutomatically() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.mSettings.getLoadsImagesAutomatically() : invokeV.booleanValue;
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    @TargetApi(17)
    public final boolean getMediaPlaybackRequiresUserGesture() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            if (Build.VERSION.SDK_INT >= 17) {
                return this.mSettings.getMediaPlaybackRequiresUserGesture();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final int getMinimumFontSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.mSettings.getMinimumFontSize() : invokeV.intValue;
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final int getMinimumLogicalFontSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.mSettings.getMinimumLogicalFontSize() : invokeV.intValue;
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    @TargetApi(21)
    public final int getMixedContentMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return this.mSettings.getMixedContentMode();
            }
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    @TargetApi(23)
    public final boolean getOffscreenPreRaster() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                return this.mSettings.getOffscreenPreRaster();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final WebSettings.PluginState getPluginState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? Glue.cast(this.mSettings.getPluginState()) : (WebSettings.PluginState) invokeV.objValue;
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final String getSansSerifFontFamily() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.mSettings.getSansSerifFontFamily() : (String) invokeV.objValue;
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final boolean getSaveFormData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.mSettings.getSaveFormData() : invokeV.booleanValue;
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final boolean getSavePassword() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.mSettings.getSavePassword() : invokeV.booleanValue;
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final String getSerifFontFamily() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.mSettings.getSansSerifFontFamily() : (String) invokeV.objValue;
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final String getStandardFontFamily() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.mSettings.getStandardFontFamily() : (String) invokeV.objValue;
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    @TargetApi(14)
    public final int getTextZoom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            if (Build.VERSION.SDK_INT >= 14) {
                return this.mSettings.getTextZoom();
            }
            return 100;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final boolean getUseWebViewBackgroundForOverscrollBackground() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final boolean getUseWideViewPort() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.mSettings.getUseWideViewPort() : invokeV.booleanValue;
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final String getUserAgentString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.mSettings.getUserAgentString() : (String) invokeV.objValue;
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final String getWebViewFrameName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.mWebviewFrameName : (String) invokeV.objValue;
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void initDefaultSettings(Context context, WebViewFactoryProvider webViewFactoryProvider) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048621, this, context, webViewFactoryProvider) == null) {
            setNeedInitialFocus(false);
            setJavaScriptEnabled(true);
            setDefaultTextEncodingName("GBK");
            setUseWideViewPort(true);
            setRenderPriority(WebSettings.RenderPriority.NORMAL);
            setGeolocationEnabled(true);
            setDatabaseEnabled(true);
            setDomStorageEnabled(true);
            setAppCacheEnabled(true);
            String path = context.getDir("databases", 0).getPath();
            setGeolocationDatabasePath(context.getDir("geolocation", 0).getPath());
            setDatabasePath(path);
            setAppCachePath(context.getDir("appcache_sys", 0).getPath());
            setSupportMultipleWindows(true);
            if (webViewFactoryProvider != null) {
                String GetCloudSettingsValue = WebSettingsGlobalBlink.GetCloudSettingsValue("searchbox_urlsafe_switch_pr");
                if (!TextUtils.isEmpty(GetCloudSettingsValue)) {
                    setUrlSecurityCheckEnabled((Integer.parseInt(GetCloudSettingsValue) == 1) && ((Boolean) webViewFactoryProvider.getStaticWebSeting(WebViewFactoryProvider.SETTING_URL_SAFE_CHECK)).booleanValue());
                }
            }
            if (GlobalConstants.enableSearchboxFeatures()) {
                setLoadWithOverviewMode(true);
            } else {
                setLoadWithOverviewMode(false);
            }
        }
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final boolean isFullScreenMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final boolean isLoadingAnimationEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    @TargetApi(11)
    public final void setAllowContentAccess(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048624, this, z) == null) || Build.VERSION.SDK_INT < 11) {
            return;
        }
        this.mSettings.setAllowContentAccess(z);
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setAllowFileAccess(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048625, this, z) == null) {
            this.mSettings.setAllowFileAccess(z);
        }
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    @TargetApi(16)
    public final void setAllowFileAccessFromFileURLs(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048626, this, z) == null) || Build.VERSION.SDK_INT < 16) {
            return;
        }
        this.mSettings.setAllowFileAccessFromFileURLs(z);
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    @TargetApi(16)
    public final void setAllowUniversalAccessFromFileURLs(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048627, this, z) == null) || Build.VERSION.SDK_INT < 16) {
            return;
        }
        this.mSettings.setAllowUniversalAccessFromFileURLs(z);
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setAppCacheEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048628, this, z) == null) {
            this.mSettings.setAppCacheEnabled(z);
        }
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setAppCacheMaxSize(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048629, this, j) == null) {
            this.mSettings.setAppCacheMaxSize(j);
        }
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setAppCachePath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, str) == null) {
            this.mSettings.setAppCachePath(str);
        }
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setBlockNetworkImage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048631, this, z) == null) {
            this.mSettings.setBlockNetworkImage(z);
        }
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setBlockNetworkLoads(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048632, this, z) == null) {
            this.mSettings.setBlockNetworkLoads(z);
        }
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setBuiltInZoomControls(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048633, this, z) == null) {
            this.mSettings.setBuiltInZoomControls(z);
        }
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setCacheMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048634, this, i2) == null) {
            this.mSettings.setCacheMode(i2);
        }
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setCursiveFontFamily(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, str) == null) {
            this.mSettings.setCursiveFontFamily(str);
        }
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setDatabaseEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048636, this, z) == null) {
            this.mSettings.setDatabaseEnabled(z);
        }
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setDatabasePath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, str) == null) {
            this.mSettings.setDatabasePath(str);
        }
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setDefaultFixedFontSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048638, this, i2) == null) {
            this.mSettings.setDefaultFixedFontSize(i2);
        }
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setDefaultFontSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048639, this, i2) == null) {
            this.mSettings.setDefaultFontSize(i2);
        }
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setDefaultTextEncodingName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, str) == null) {
            this.mSettings.setDefaultTextEncodingName(str);
        }
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setDefaultZoom(WebSettings.ZoomDensity zoomDensity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, zoomDensity) == null) {
            this.mSettings.setDefaultZoom(Glue.cast(zoomDensity));
        }
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    @TargetApi(24)
    public final void setDisabledActionModeMenuItems(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048642, this, i2) == null) || Build.VERSION.SDK_INT < 24) {
            return;
        }
        this.mSettings.setDisabledActionModeMenuItems(i2);
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    @TargetApi(11)
    public final void setDisplayZoomControls(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048643, this, z) == null) || Build.VERSION.SDK_INT < 11) {
            return;
        }
        this.mSettings.setDisplayZoomControls(z);
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setDomStorageEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048644, this, z) == null) {
            this.mSettings.setDomStorageEnabled(z);
        }
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setEnableFileSchemaOnPrivate(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048645, this, z) == null) {
            this.mEnableFileSchemaOnPrivate = z;
        }
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setEnableJsPrompt(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048646, this, z) == null) {
            this.mEnableJsPrompt = z;
        }
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setEnableLoadingAnimation(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048647, this, z) == null) {
        }
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    @TargetApi(11)
    public final void setEnableSmoothTransition(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048648, this, z) == null) || Build.VERSION.SDK_INT < 11) {
            return;
        }
        this.mSettings.setEnableSmoothTransition(z);
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setFantasyFontFamily(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048649, this, str) == null) {
            this.mSettings.setFantasyFontFamily(str);
        }
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setFixedFontFamily(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048650, this, str) == null) {
            this.mSettings.setFixedFontFamily(str);
        }
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setFullScreenMode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048651, this, z) == null) {
        }
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setGeolocationDatabasePath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048652, this, str) == null) {
            this.mSettings.setGeolocationDatabasePath(str);
        }
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setGeolocationEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048653, this, z) == null) {
            this.mSettings.setGeolocationEnabled(z);
        }
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setJavaScriptCanOpenWindowsAutomatically(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048654, this, z) == null) {
            this.mSettings.setJavaScriptCanOpenWindowsAutomatically(z);
        }
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setJavaScriptEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048655, this, z) == null) {
            this.mSettings.setJavaScriptEnabled(z);
        }
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setLayoutAlgorithm(WebSettings.LayoutAlgorithm layoutAlgorithm) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048656, this, layoutAlgorithm) == null) {
            this.mSettings.setLayoutAlgorithm(Glue.cast(layoutAlgorithm));
        }
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setLightTouchEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048657, this, z) == null) {
            this.mSettings.setLightTouchEnabled(z);
        }
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setLoadWithOverviewMode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048658, this, z) == null) {
            this.mSettings.setLoadWithOverviewMode(z);
        }
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setLoadsImagesAutomatically(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048659, this, z) == null) {
            this.mSettings.setLoadsImagesAutomatically(z);
        }
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    @TargetApi(17)
    public final void setMediaPlaybackRequiresUserGesture(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048660, this, z) == null) || Build.VERSION.SDK_INT < 17) {
            return;
        }
        this.mSettings.setMediaPlaybackRequiresUserGesture(z);
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setMinimumFontSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048661, this, i2) == null) {
            this.mSettings.setMinimumFontSize(i2);
        }
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setMinimumLogicalFontSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048662, this, i2) == null) {
            this.mSettings.setMinimumLogicalFontSize(i2);
        }
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    @TargetApi(21)
    public final void setMixedContentMode(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048663, this, i2) == null) || Build.VERSION.SDK_INT < 21) {
            return;
        }
        this.mSettings.setMixedContentMode(i2);
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setNeedInitialFocus(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048664, this, z) == null) {
            this.mSettings.setNeedInitialFocus(z);
        }
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    @TargetApi(23)
    public final void setOffscreenPreRaster(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048665, this, z) == null) || Build.VERSION.SDK_INT < 23) {
            return;
        }
        this.mSettings.setOffscreenPreRaster(z);
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setPluginState(WebSettings.PluginState pluginState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048666, this, pluginState) == null) {
            this.mSettings.setPluginState(Glue.cast(pluginState));
        }
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setRenderPriority(WebSettings.RenderPriority renderPriority) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048667, this, renderPriority) == null) {
            this.mSettings.setRenderPriority(Glue.cast(renderPriority));
        }
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setSansSerifFontFamily(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048668, this, str) == null) {
            this.mSettings.setSansSerifFontFamily(str);
        }
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setSaveFormData(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048669, this, z) == null) {
            this.mSettings.setSaveFormData(z);
        }
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setSavePassword(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048670, this, z) == null) {
            this.mSettings.setSavePassword(z);
        }
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setSerifFontFamily(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048671, this, str) == null) {
            this.mSettings.setSerifFontFamily(str);
        }
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setStandardFontFamily(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048672, this, str) == null) {
            this.mSettings.setStandardFontFamily(str);
        }
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setSupportMultipleWindows(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048673, this, z) == null) {
            this.mSettings.setSupportMultipleWindows(z);
        }
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setSupportZoom(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048674, this, z) == null) {
            this.mSettings.setSupportZoom(z);
        }
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    @TargetApi(14)
    public final void setTextZoom(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048675, this, i2) == null) || Build.VERSION.SDK_INT < 14) {
            return;
        }
        this.mSettings.setTextZoom(i2);
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setUseWebViewBackgroundForOverscrollBackground(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048676, this, z) == null) {
        }
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setUseWideViewPort(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048677, this, z) == null) {
            this.mSettings.setUseWideViewPort(z);
        }
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setUserAgentString(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048678, this, str) == null) {
            this.mSettings.setUserAgentString(str);
        }
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setWebViewFrameName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048679, this, str) == null) {
            this.mWebviewFrameName = str;
        }
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final boolean supportMultipleWindows() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048680, this)) == null) ? this.mSettings.supportMultipleWindows() : invokeV.booleanValue;
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final boolean supportZoom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048681, this)) == null) ? this.mSettings.supportZoom() : invokeV.booleanValue;
    }
}
