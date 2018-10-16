package com.baidu.webkit.sdk;

import android.content.Context;
import android.support.v7.widget.ActivityChooserView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import java.util.Observable;
import java.util.Observer;
/* loaded from: classes2.dex */
public abstract class WebSettings implements Observer {
    public static final int LOAD_CACHE_ELSE_NETWORK = 1;
    public static final int LOAD_CACHE_ONLY = 3;
    public static final int LOAD_DEFAULT = -1;
    @Deprecated
    public static final int LOAD_NORMAL = 0;
    public static final int LOAD_NO_CACHE = 2;
    private static final String LOGTAG = "WebSettings";
    public static final int MENU_ITEM_NONE = 0;
    public static final int MIXED_CONTENT_ALWAYS_ALLOW = 0;
    public static final int MIXED_CONTENT_COMPATIBILITY_MODE = 2;
    public static final int MIXED_CONTENT_NEVER_ALLOW = 1;
    public static final int MSG_setADblockEnabled = 100;
    public static final int MSG_setEnableSpdy = 102;
    public static final int MSG_setUrlSecurityCheckEnable = 101;
    public static final int MSG_setUseGifLoadProxy = 105;
    public static final int MSG_setUseImageLoadProxy = 104;
    public String mWebviewFrameName;
    public boolean mEnableJsPrompt = true;
    private boolean mAdblockEnable = false;

    /* loaded from: classes2.dex */
    public enum FlingAlgorithm {
        FAST,
        QUADRATIC,
        CUBIC
    }

    /* loaded from: classes2.dex */
    public enum ImgQuality {
        NO_COMPRESS,
        LOW_COMPRESS,
        MEDIUM_COMPRESS,
        HIGHT_COMPRESS
    }

    /* loaded from: classes2.dex */
    public enum LayoutAlgorithm {
        NORMAL,
        SINGLE_COLUMN,
        NARROW_COLUMNS,
        TEXT_AUTOSIZING
    }

    /* loaded from: classes2.dex */
    public enum PluginState {
        ON,
        ON_DEMAND,
        OFF
    }

    /* loaded from: classes2.dex */
    public enum ProxyType {
        NO_PROXY,
        SPDY_PROXY,
        OVERSEAS_PROXY,
        SPDYANDOVERSEAS_PROXY
    }

    /* loaded from: classes2.dex */
    public enum RemoveAdLevel {
        DISABLE,
        LOW_LEVEL,
        HIGH_LEVEL
    }

    /* loaded from: classes2.dex */
    public enum RenderPriority {
        NORMAL,
        HIGH,
        LOW
    }

    @Deprecated
    /* loaded from: classes2.dex */
    public enum TextSize {
        SMALLEST(50),
        SMALLER(75),
        NORMAL(100),
        LARGERLITTLE(125),
        LARGER(BaseActivity.SHOW_SOFT_KEYBOARD_DELAY),
        LARGERMORE(175),
        LARGEST(200);
        
        int value;

        TextSize(int i) {
            this.value = i;
        }
    }

    /* loaded from: classes2.dex */
    public enum ZoomDensity {
        FAR(BaseActivity.SHOW_SOFT_KEYBOARD_DELAY),
        MEDIUM(100),
        CLOSE(75);
        
        int value;

        ZoomDensity(int i) {
            this.value = i;
        }

        public final int getValue() {
            return this.value;
        }
    }

    public static int backgroundNightColor() {
        return 0;
    }

    public static int bigPluginTextNightColor() {
        return 16777215;
    }

    public static int borderNightColor() {
        return 16777215;
    }

    public static void changeInspectorStatus(boolean z) {
    }

    public static int defaultLinkTextNightColor() {
        return 255;
    }

    public static long generateBKDRHash(String str) {
        return WebSettingsGlobalBlink.generateBKDRHash(str);
    }

    public static String getBrowserVersion() {
        return "6.0";
    }

    public static String getCuid() {
        return WebKitFactory.getCUIDString();
    }

    public static String getDefaultUserAgent(Context context) {
        return WebViewFactory.getProvider().getStatics().getDefaultUserAgent(context);
    }

    public static int getInspectorKernelSupport() {
        return 0;
    }

    public static boolean getPageCacheEnabled() {
        return WebSettingsGlobalBlink.getPageCacheEnabled();
    }

    public static boolean getT5SDKSpdyEnabled() {
        return false;
    }

    public static void setCuid(String str) {
        WebSettingsGlobalBlink.setCuid(str);
    }

    public static void setFreeFlow(boolean z) {
        WebSettingsGlobalBlink.setFreeFlow(z);
    }

    public static void setVideoPlayerMode(int i) {
        WebSettingsGlobalBlink.setVideoPlayerMode(i);
    }

    @Deprecated
    public abstract boolean enableSmoothTransition();

    public boolean enableVendorSpecifiedFont() {
        return false;
    }

    public boolean getADblockEnabled() {
        return this.mAdblockEnable;
    }

    public abstract boolean getAllowContentAccess();

    public abstract boolean getAllowFileAccess();

    public abstract boolean getAllowFileAccessFromFileURLs();

    public abstract boolean getAllowUniversalAccessFromFileURLs();

    public boolean getBackForwardAnimationEnable() {
        return false;
    }

    public abstract boolean getBlockNetworkImage();

    public abstract boolean getBlockNetworkLoads();

    public abstract boolean getBuiltInZoomControls();

    public abstract int getCacheMode();

    public boolean getCollectMainAction() {
        return false;
    }

    public abstract String getCursiveFontFamily();

    public boolean getCustomFocusEnabled() {
        return false;
    }

    public abstract boolean getDatabaseEnabled();

    @Deprecated
    public abstract String getDatabasePath();

    public abstract int getDefaultFixedFontSize();

    public abstract int getDefaultFontSize();

    public abstract String getDefaultTextEncodingName();

    @Deprecated
    public abstract ZoomDensity getDefaultZoom();

    public abstract boolean getDisplayZoomControls();

    public abstract boolean getDomStorageEnabled();

    public abstract boolean getEnableFileSchemaOnPrivate();

    public abstract boolean getEnableJsPrompt();

    public int getEyeShieldMode() {
        return 0;
    }

    public abstract String getFantasyFontFamily();

    public float getFastFlingDampFactor() {
        return 0.0f;
    }

    public abstract String getFixedFontFamily();

    public FlingAlgorithm getFlingAlgorithm() {
        return FlingAlgorithm.FAST;
    }

    public boolean getForcePageCanBeScaled() {
        return false;
    }

    public boolean getHtml5NotificationEnabled() {
        return false;
    }

    public boolean getHtml5VideoEnabled() {
        return false;
    }

    public abstract boolean getJavaScriptCanOpenWindowsAutomatically();

    public abstract boolean getJavaScriptEnabled();

    public boolean getKeywordExtensionEnabled() {
        return false;
    }

    public abstract LayoutAlgorithm getLayoutAlgorithm();

    @Deprecated
    public abstract boolean getLightTouchEnabled();

    public abstract boolean getLoadWithOverviewMode();

    public abstract boolean getLoadsImagesAutomatically();

    public boolean getMagicFilterEnabledExt() {
        return false;
    }

    public boolean getMarkSubjectEnabled() {
        return false;
    }

    public abstract boolean getMediaPlaybackRequiresUserGesture();

    public abstract int getMinimumFontSize();

    public abstract int getMinimumLogicalFontSize();

    public abstract int getMixedContentMode();

    public boolean getMultiScaleEnableTextWrap() {
        return false;
    }

    public boolean getNightModeEnabled() {
        return false;
    }

    public abstract boolean getOffscreenPreRaster();

    public boolean getPauseAudioEnabled() {
        return false;
    }

    public boolean getPlayVideoInFullScreenMode() {
        return false;
    }

    @Deprecated
    public abstract PluginState getPluginState();

    @Deprecated
    public String getPluginsPath() {
        return "";
    }

    public boolean getPrerenderEnabled() {
        return false;
    }

    public abstract String getSansSerifFontFamily();

    public abstract boolean getSaveFormData();

    @Deprecated
    public abstract boolean getSavePassword();

    public int getScrollSpeed() {
        return 0;
    }

    public abstract String getSerifFontFamily();

    public boolean getShowUnderLine() {
        return false;
    }

    public abstract String getStandardFontFamily();

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0029, code lost:
        if (r3 == null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002b, code lost:
        r2 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002d, code lost:
        r2 = com.baidu.webkit.sdk.WebSettings.TextSize.NORMAL;
     */
    @Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized TextSize getTextSize() {
        TextSize textSize;
        TextSize textSize2;
        TextSize textSize3 = null;
        int i = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int textZoom = getTextZoom();
        TextSize[] values = TextSize.values();
        int length = values.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            textSize = values[i2];
            int abs = Math.abs(textZoom - textSize.value);
            if (abs == 0) {
                break;
            }
            if (abs < i) {
                textSize2 = textSize;
            } else {
                abs = i;
                textSize2 = textSize3;
            }
            i2++;
            textSize3 = textSize2;
            i = abs;
        }
        return textSize;
    }

    public abstract int getTextZoom();

    public boolean getUrlSecurityCheckEnabled() {
        return false;
    }

    @Deprecated
    public boolean getUseDoubleTree() {
        return false;
    }

    public boolean getUseGLRendering() {
        return false;
    }

    public boolean getUseScaleStore() {
        return false;
    }

    @Deprecated
    public abstract boolean getUseWebViewBackgroundForOverscrollBackground();

    public abstract boolean getUseWideViewPort();

    public abstract String getUserAgentString();

    public abstract String getWebViewFrameName();

    public abstract void initDefaultSettings(Context context, WebViewFactoryProvider webViewFactoryProvider);

    public void setADblockEnabled(boolean z) {
        this.mAdblockEnable = z;
    }

    public void setAdBlockCssEnabled(boolean z) {
    }

    public abstract void setAllowContentAccess(boolean z);

    public abstract void setAllowFileAccess(boolean z);

    public abstract void setAllowFileAccessFromFileURLs(boolean z);

    public abstract void setAllowUniversalAccessFromFileURLs(boolean z);

    public void setAntiHackInfoEnabled(boolean z) {
    }

    public abstract void setAppCacheEnabled(boolean z);

    @Deprecated
    public abstract void setAppCacheMaxSize(long j);

    public abstract void setAppCachePath(String str);

    public void setBackForwardAnimationEnable(boolean z) {
    }

    public abstract void setBlockNetworkImage(boolean z);

    public abstract void setBlockNetworkLoads(boolean z);

    public abstract void setBuiltInZoomControls(boolean z);

    public abstract void setCacheMode(int i);

    public void setCollectMainAction(boolean z) {
    }

    public abstract void setCursiveFontFamily(String str);

    public void setCustomFocusEnabled(boolean z) {
    }

    public abstract void setDatabaseEnabled(boolean z);

    @Deprecated
    public abstract void setDatabasePath(String str);

    public abstract void setDefaultFixedFontSize(int i);

    public abstract void setDefaultFontSize(int i);

    public abstract void setDefaultTextEncodingName(String str);

    @Deprecated
    public abstract void setDefaultZoom(ZoomDensity zoomDensity);

    public abstract void setDisplayZoomControls(boolean z);

    public void setDomParserOptType(int i) {
    }

    public abstract void setDomStorageEnabled(boolean z);

    public abstract void setEnableFileSchemaOnPrivate(boolean z);

    public abstract void setEnableJsPrompt(boolean z);

    @Deprecated
    public abstract void setEnableSmoothTransition(boolean z);

    public void setEnableVendorSpecifiedFont(boolean z) {
    }

    public void setEyeShieldMode(int i) {
    }

    public abstract void setFantasyFontFamily(String str);

    public void setFastFlingDampFactor(float f) {
    }

    public void setFeatureDatabasePath(String str) {
    }

    public void setFeedNewsFirstScreenOptEnabled(boolean z) {
    }

    public abstract void setFixedFontFamily(String str);

    public void setFlingAlgorithm(FlingAlgorithm flingAlgorithm) {
    }

    public void setForcePageCanBeScaled(boolean z) {
    }

    public abstract void setGeolocationDatabasePath(String str);

    public abstract void setGeolocationEnabled(boolean z);

    public void setHardwareAccelSkiaEnabled(boolean z) {
    }

    public void setHtml5NotificationEnabled(boolean z) {
    }

    public void setHtml5VideoEnabled(boolean z) {
    }

    public void setImageMaxWidth(int i) {
    }

    public void setImagesEnabled(boolean z) {
    }

    public abstract void setJavaScriptCanOpenWindowsAutomatically(boolean z);

    public abstract void setJavaScriptEnabled(boolean z);

    public void setKeywordExtensionEnabled(boolean z) {
    }

    public abstract void setLayoutAlgorithm(LayoutAlgorithm layoutAlgorithm);

    @Deprecated
    public abstract void setLightTouchEnabled(boolean z);

    public void setLinkPrefetchEnabled(boolean z) {
    }

    public abstract void setLoadWithOverviewMode(boolean z);

    public abstract void setLoadsImagesAutomatically(boolean z);

    public void setMagicFilter21Enabled(boolean z) {
    }

    public void setMagicFilter30Enabled(boolean z) {
    }

    public void setMagicFilterEnabledExt(boolean z) {
    }

    public void setMarkSubjectEnabled(boolean z) {
    }

    public abstract void setMediaPlaybackRequiresUserGesture(boolean z);

    public abstract void setMinimumFontSize(int i);

    public abstract void setMinimumLogicalFontSize(int i);

    public abstract void setMixedContentMode(int i);

    public void setMultiScaleEnableTextWrap(boolean z) {
    }

    public abstract void setNeedInitialFocus(boolean z);

    public void setNightModeEnabled(boolean z) {
    }

    public abstract void setOffscreenPreRaster(boolean z);

    public void setPageCacheCapacity(int i) {
    }

    public void setPauseAudioEnabled(boolean z) {
    }

    public void setPhoenixNetAdFirstScreenOptEnabled(boolean z) {
    }

    public void setPlayVideoInFullScreenMode(boolean z) {
    }

    @Deprecated
    public abstract void setPluginState(PluginState pluginState);

    @Deprecated
    public void setPluginsPath(String str) {
    }

    public void setPrerenderEnabled(boolean z) {
    }

    public void setPrivateBrowsingEnabled(boolean z) {
    }

    @Deprecated
    public abstract void setRenderPriority(RenderPriority renderPriority);

    public void setSafePageEnabled(boolean z) {
    }

    public abstract void setSansSerifFontFamily(String str);

    public abstract void setSaveFormData(boolean z);

    @Deprecated
    public abstract void setSavePassword(boolean z);

    public void setScrollSpeed(int i) {
    }

    public abstract void setSerifFontFamily(String str);

    public void setShouldDispatchBeforeunload(boolean z) {
    }

    public void setShowUnderLine(boolean z) {
    }

    public void setShrinksStandaloneImagesToFit(boolean z) {
    }

    public abstract void setStandardFontFamily(String str);

    public void setStatisticsInfo(String str, String str2) {
    }

    public abstract void setSupportMultipleWindows(boolean z);

    public abstract void setSupportZoom(boolean z);

    @Deprecated
    public synchronized void setTextSize(TextSize textSize) {
        setTextZoom(textSize.value);
    }

    public abstract void setTextZoom(int i);

    public void setUrlSecurityCheckEnabled(boolean z) {
    }

    @Deprecated
    public void setUseDoubleTree(boolean z) {
    }

    public void setUseGLRendering(boolean z) {
    }

    public void setUseScaleStore(boolean z) {
    }

    @Deprecated
    public abstract void setUseWebViewBackgroundForOverscrollBackground(boolean z);

    public abstract void setUseWideViewPort(boolean z);

    public abstract void setUserAgentString(String str);

    public void setUsesPageCache(boolean z) {
    }

    public abstract void setWebViewFrameName(String str);

    public void setWiseSearchFirstScreenOptType(int i) {
    }

    public void setWorkersEnabled(boolean z) {
    }

    public void setXSSAuditorEnabled(boolean z) {
    }

    public abstract boolean supportMultipleWindows();

    public abstract boolean supportZoom();

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
    }

    public boolean usesPageCache() {
        return false;
    }
}
