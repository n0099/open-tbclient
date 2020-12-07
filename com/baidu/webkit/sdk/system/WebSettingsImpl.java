package com.baidu.webkit.sdk.system;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.webkit.internal.GlobalConstants;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import com.baidu.webkit.sdk.WebSettings;
import com.baidu.webkit.sdk.WebViewFactoryProvider;
/* loaded from: classes12.dex */
final class WebSettingsImpl extends WebSettings {
    private boolean mEnableFileSchemaOnPrivate = true;
    private android.webkit.WebSettings mSettings;

    private WebSettingsImpl(android.webkit.WebSettings webSettings) {
        this.mSettings = webSettings;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static WebSettings from(android.webkit.WebSettings webSettings) {
        if (webSettings == null) {
            return null;
        }
        return new WebSettingsImpl(webSettings);
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    @TargetApi(11)
    public final boolean enableSmoothTransition() {
        if (Build.VERSION.SDK_INT >= 11) {
            return this.mSettings.enableSmoothTransition();
        }
        return false;
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    @TargetApi(11)
    public final boolean getAllowContentAccess() {
        if (Build.VERSION.SDK_INT >= 11) {
            return this.mSettings.getAllowContentAccess();
        }
        return false;
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final boolean getAllowFileAccess() {
        return this.mSettings.getAllowFileAccess();
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    @TargetApi(16)
    public final boolean getAllowFileAccessFromFileURLs() {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.mSettings.getAllowFileAccessFromFileURLs();
        }
        return false;
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    @TargetApi(16)
    public final boolean getAllowUniversalAccessFromFileURLs() {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.mSettings.getAllowUniversalAccessFromFileURLs();
        }
        return false;
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final boolean getBlockNetworkImage() {
        return this.mSettings.getBlockNetworkImage();
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final boolean getBlockNetworkLoads() {
        return this.mSettings.getBlockNetworkLoads();
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final boolean getBuiltInZoomControls() {
        return this.mSettings.getBuiltInZoomControls();
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final int getCacheMode() {
        return this.mSettings.getCacheMode();
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final String getCursiveFontFamily() {
        return this.mSettings.getCursiveFontFamily();
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final boolean getDatabaseEnabled() {
        return this.mSettings.getDatabaseEnabled();
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final String getDatabasePath() {
        return this.mSettings.getDatabasePath();
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final int getDefaultFixedFontSize() {
        return this.mSettings.getDefaultFixedFontSize();
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final int getDefaultFontSize() {
        return this.mSettings.getDefaultFontSize();
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final String getDefaultTextEncodingName() {
        return this.mSettings.getDefaultTextEncodingName();
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final WebSettings.ZoomDensity getDefaultZoom() {
        return Glue.cast(this.mSettings.getDefaultZoom());
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    @TargetApi(24)
    public final int getDisabledActionModeMenuItems() {
        if (Build.VERSION.SDK_INT >= 24) {
            return this.mSettings.getDisabledActionModeMenuItems();
        }
        return 0;
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    @TargetApi(11)
    public final boolean getDisplayZoomControls() {
        if (Build.VERSION.SDK_INT >= 11) {
            return this.mSettings.getDisplayZoomControls();
        }
        return false;
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final boolean getDomStorageEnabled() {
        return this.mSettings.getDomStorageEnabled();
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final boolean getEnableFileSchemaOnPrivate() {
        return this.mEnableFileSchemaOnPrivate;
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final boolean getEnableJsPrompt() {
        return this.mEnableJsPrompt;
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final String getFantasyFontFamily() {
        return this.mSettings.getFantasyFontFamily();
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final String getFixedFontFamily() {
        return this.mSettings.getFixedFontFamily();
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final boolean getJavaScriptCanOpenWindowsAutomatically() {
        return this.mSettings.getJavaScriptCanOpenWindowsAutomatically();
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final boolean getJavaScriptEnabled() {
        return this.mSettings.getJavaScriptEnabled();
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final WebSettings.LayoutAlgorithm getLayoutAlgorithm() {
        return Glue.cast(this.mSettings.getLayoutAlgorithm());
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final boolean getLightTouchEnabled() {
        return this.mSettings.getLightTouchEnabled();
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final boolean getLoadWithOverviewMode() {
        return this.mSettings.getLoadWithOverviewMode();
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final boolean getLoadsImagesAutomatically() {
        return this.mSettings.getLoadsImagesAutomatically();
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    @TargetApi(17)
    public final boolean getMediaPlaybackRequiresUserGesture() {
        if (Build.VERSION.SDK_INT >= 17) {
            return this.mSettings.getMediaPlaybackRequiresUserGesture();
        }
        return false;
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final int getMinimumFontSize() {
        return this.mSettings.getMinimumFontSize();
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final int getMinimumLogicalFontSize() {
        return this.mSettings.getMinimumLogicalFontSize();
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    @TargetApi(21)
    public final int getMixedContentMode() {
        if (Build.VERSION.SDK_INT >= 21) {
            return this.mSettings.getMixedContentMode();
        }
        return 1;
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    @TargetApi(23)
    public final boolean getOffscreenPreRaster() {
        if (Build.VERSION.SDK_INT >= 23) {
            return this.mSettings.getOffscreenPreRaster();
        }
        return false;
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final WebSettings.PluginState getPluginState() {
        return Glue.cast(this.mSettings.getPluginState());
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final String getSansSerifFontFamily() {
        return this.mSettings.getSansSerifFontFamily();
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final boolean getSaveFormData() {
        return this.mSettings.getSaveFormData();
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final boolean getSavePassword() {
        return this.mSettings.getSavePassword();
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final String getSerifFontFamily() {
        return this.mSettings.getSansSerifFontFamily();
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final String getStandardFontFamily() {
        return this.mSettings.getStandardFontFamily();
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    @TargetApi(14)
    public final int getTextZoom() {
        if (Build.VERSION.SDK_INT >= 14) {
            return this.mSettings.getTextZoom();
        }
        return 100;
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final boolean getUseWebViewBackgroundForOverscrollBackground() {
        return false;
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final boolean getUseWideViewPort() {
        return this.mSettings.getUseWideViewPort();
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final String getUserAgentString() {
        return this.mSettings.getUserAgentString();
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final String getWebViewFrameName() {
        return this.mWebviewFrameName;
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void initDefaultSettings(Context context, WebViewFactoryProvider webViewFactoryProvider) {
        setNeedInitialFocus(false);
        setJavaScriptEnabled(true);
        setDefaultTextEncodingName("GBK");
        setUseWideViewPort(true);
        setRenderPriority(WebSettings.RenderPriority.NORMAL);
        setGeolocationEnabled(true);
        setDatabaseEnabled(true);
        setDomStorageEnabled(true);
        setAppCacheEnabled(true);
        String path = context.getDir(NgWebView.APP_DATABASE_PATH, 0).getPath();
        setGeolocationDatabasePath(context.getDir(NgWebView.APP_GEO_PATH, 0).getPath());
        setDatabasePath(path);
        setAppCachePath(context.getDir("appcache_sys", 0).getPath());
        setSupportMultipleWindows(true);
        Boolean bool = false;
        if (webViewFactoryProvider != null) {
            String GetCloudSettingsValue = WebSettingsGlobalBlink.GetCloudSettingsValue("searchbox_urlsafe_switch_pr");
            if (!TextUtils.isEmpty(GetCloudSettingsValue)) {
                setUrlSecurityCheckEnabled((Integer.parseInt(GetCloudSettingsValue) == 1) && ((Boolean) webViewFactoryProvider.getStaticWebSeting(WebViewFactoryProvider.SETTING_URL_SAFE_CHECK)).booleanValue());
            }
        }
        if (GlobalConstants.enableSearchboxFeatures() || bool.booleanValue()) {
            setLoadWithOverviewMode(true);
        } else {
            setLoadWithOverviewMode(false);
        }
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final boolean isFullScreenMode() {
        return false;
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final boolean isLoadingAnimationEnable() {
        return false;
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    @TargetApi(11)
    public final void setAllowContentAccess(boolean z) {
        if (Build.VERSION.SDK_INT >= 11) {
            this.mSettings.setAllowContentAccess(z);
        }
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setAllowFileAccess(boolean z) {
        this.mSettings.setAllowFileAccess(z);
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    @TargetApi(16)
    public final void setAllowFileAccessFromFileURLs(boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.mSettings.setAllowFileAccessFromFileURLs(z);
        }
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    @TargetApi(16)
    public final void setAllowUniversalAccessFromFileURLs(boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.mSettings.setAllowUniversalAccessFromFileURLs(z);
        }
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setAppCacheEnabled(boolean z) {
        this.mSettings.setAppCacheEnabled(z);
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setAppCacheMaxSize(long j) {
        this.mSettings.setAppCacheMaxSize(j);
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setAppCachePath(String str) {
        this.mSettings.setAppCachePath(str);
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setBlockNetworkImage(boolean z) {
        this.mSettings.setBlockNetworkImage(z);
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setBlockNetworkLoads(boolean z) {
        this.mSettings.setBlockNetworkLoads(z);
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setBuiltInZoomControls(boolean z) {
        this.mSettings.setBuiltInZoomControls(z);
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setCacheMode(int i) {
        this.mSettings.setCacheMode(i);
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setCursiveFontFamily(String str) {
        this.mSettings.setCursiveFontFamily(str);
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setDatabaseEnabled(boolean z) {
        this.mSettings.setDatabaseEnabled(z);
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setDatabasePath(String str) {
        this.mSettings.setDatabasePath(str);
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setDefaultFixedFontSize(int i) {
        this.mSettings.setDefaultFixedFontSize(i);
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setDefaultFontSize(int i) {
        this.mSettings.setDefaultFontSize(i);
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setDefaultTextEncodingName(String str) {
        this.mSettings.setDefaultTextEncodingName(str);
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setDefaultZoom(WebSettings.ZoomDensity zoomDensity) {
        this.mSettings.setDefaultZoom(Glue.cast(zoomDensity));
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    @TargetApi(24)
    public final void setDisabledActionModeMenuItems(int i) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.mSettings.setDisabledActionModeMenuItems(i);
        }
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    @TargetApi(11)
    public final void setDisplayZoomControls(boolean z) {
        if (Build.VERSION.SDK_INT >= 11) {
            this.mSettings.setDisplayZoomControls(z);
        }
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setDomStorageEnabled(boolean z) {
        this.mSettings.setDomStorageEnabled(z);
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setEnableFileSchemaOnPrivate(boolean z) {
        this.mEnableFileSchemaOnPrivate = z;
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setEnableJsPrompt(boolean z) {
        this.mEnableJsPrompt = z;
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setEnableLoadingAnimation(boolean z) {
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    @TargetApi(11)
    public final void setEnableSmoothTransition(boolean z) {
        if (Build.VERSION.SDK_INT >= 11) {
            this.mSettings.setEnableSmoothTransition(z);
        }
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setFantasyFontFamily(String str) {
        this.mSettings.setFantasyFontFamily(str);
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setFixedFontFamily(String str) {
        this.mSettings.setFixedFontFamily(str);
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setFullScreenMode(boolean z) {
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setGeolocationDatabasePath(String str) {
        this.mSettings.setGeolocationDatabasePath(str);
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setGeolocationEnabled(boolean z) {
        this.mSettings.setGeolocationEnabled(z);
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setJavaScriptCanOpenWindowsAutomatically(boolean z) {
        this.mSettings.setJavaScriptCanOpenWindowsAutomatically(z);
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setJavaScriptEnabled(boolean z) {
        this.mSettings.setJavaScriptEnabled(z);
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setLayoutAlgorithm(WebSettings.LayoutAlgorithm layoutAlgorithm) {
        this.mSettings.setLayoutAlgorithm(Glue.cast(layoutAlgorithm));
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setLightTouchEnabled(boolean z) {
        this.mSettings.setLightTouchEnabled(z);
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setLoadWithOverviewMode(boolean z) {
        this.mSettings.setLoadWithOverviewMode(z);
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setLoadsImagesAutomatically(boolean z) {
        this.mSettings.setLoadsImagesAutomatically(z);
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    @TargetApi(17)
    public final void setMediaPlaybackRequiresUserGesture(boolean z) {
        if (Build.VERSION.SDK_INT >= 17) {
            this.mSettings.setMediaPlaybackRequiresUserGesture(z);
        }
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setMinimumFontSize(int i) {
        this.mSettings.setMinimumFontSize(i);
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setMinimumLogicalFontSize(int i) {
        this.mSettings.setMinimumLogicalFontSize(i);
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    @TargetApi(21)
    public final void setMixedContentMode(int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.mSettings.setMixedContentMode(i);
        }
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setNeedInitialFocus(boolean z) {
        this.mSettings.setNeedInitialFocus(z);
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    @TargetApi(23)
    public final void setOffscreenPreRaster(boolean z) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.mSettings.setOffscreenPreRaster(z);
        }
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setPluginState(WebSettings.PluginState pluginState) {
        this.mSettings.setPluginState(Glue.cast(pluginState));
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setRenderPriority(WebSettings.RenderPriority renderPriority) {
        this.mSettings.setRenderPriority(Glue.cast(renderPriority));
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setSansSerifFontFamily(String str) {
        this.mSettings.setSansSerifFontFamily(str);
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setSaveFormData(boolean z) {
        this.mSettings.setSaveFormData(z);
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setSavePassword(boolean z) {
        this.mSettings.setSavePassword(z);
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setSerifFontFamily(String str) {
        this.mSettings.setSerifFontFamily(str);
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setStandardFontFamily(String str) {
        this.mSettings.setStandardFontFamily(str);
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setSupportMultipleWindows(boolean z) {
        this.mSettings.setSupportMultipleWindows(z);
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setSupportZoom(boolean z) {
        this.mSettings.setSupportZoom(z);
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    @TargetApi(14)
    public final void setTextZoom(int i) {
        if (Build.VERSION.SDK_INT >= 14) {
            this.mSettings.setTextZoom(i);
        }
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setUseWebViewBackgroundForOverscrollBackground(boolean z) {
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setUseWideViewPort(boolean z) {
        this.mSettings.setUseWideViewPort(z);
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setUserAgentString(String str) {
        this.mSettings.setUserAgentString(str);
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final void setWebViewFrameName(String str) {
        this.mWebviewFrameName = str;
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final boolean supportMultipleWindows() {
        return this.mSettings.supportMultipleWindows();
    }

    @Override // com.baidu.webkit.sdk.WebSettings
    public final boolean supportZoom() {
        return this.mSettings.supportZoom();
    }
}
