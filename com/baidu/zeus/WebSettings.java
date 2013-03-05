package com.baidu.zeus;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.util.EventLog;
import java.util.Locale;
/* loaded from: classes.dex */
public class WebSettings {
    private static final String DESKTOP_USERAGENT = "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_5_7; en-us) AppleWebKit/530.17 (KHTML, like Gecko) Version/4.0 Safari/530.17";
    private static final String DOUBLE_TAP_TOAST_COUNT = "double_tap_toast_count";
    private static final int EVENT_LOG_BROWSER_SNAP_CENTER = 70150;
    private static final int EVENT_LOG_BROWSER_TEXT_SIZE_CHANGE = 70151;
    private static final int EVENT_LOG_DOUBLE_TAP_DURATION = 70102;
    private static final int EVENT_LOG_ZOOM_LEVEL_CHANGE = 70101;
    private static final String IPHONE_USERAGENT = "Mozilla/5.0 (iPhone; U; CPU iPhone OS 3_0 like Mac OS X; en-us) AppleWebKit/528.18 (KHTML, like Gecko) Version/4.0 Mobile/7A341 Safari/528.16";
    public static final int LOAD_CACHE_ELSE_NETWORK = 1;
    public static final int LOAD_CACHE_ONLY = 3;
    public static final int LOAD_DEFAULT = -1;
    public static final int LOAD_NORMAL = 0;
    public static final int LOAD_NO_CACHE = 2;
    private static final String PREF_FILE = "WebViewSettings";
    private static int mDoubleTapToastCount = 3;
    private static Locale sLocale;
    private static Object sLockForLocaleSettings;
    private String mAcceptLanguage;
    private boolean mBlockNetworkLoads;
    private BrowserFrame mBrowserFrame;
    private Context mContext;
    private boolean mUseDefaultUserAgent;
    private String mUserAgent;
    private WebView mWebView;
    private boolean mSyncPending = false;
    private boolean mDisableFlash = false;
    private LayoutAlgorithm mLayoutAlgorithm = LayoutAlgorithm.NARROW_COLUMNS;
    private TextSize mTextSize = TextSize.NORMAL;
    private String mStandardFontFamily = "sans-serif";
    private String mFixedFontFamily = "monospace";
    private String mSansSerifFontFamily = "sans-serif";
    private String mSerifFontFamily = "serif";
    private String mCursiveFontFamily = "cursive";
    private String mFantasyFontFamily = "fantasy";
    private int mMinimumFontSize = 8;
    private int mMinimumLogicalFontSize = 8;
    private int mDefaultFontSize = 16;
    private int mDefaultFixedFontSize = 13;
    private int mPageCacheCapacity = 0;
    private boolean mLoadsImagesAutomatically = true;
    private boolean mBlockNetworkImage = false;
    private boolean mJavaScriptEnabled = false;
    private boolean mPauseAudioEnabled = true;
    private PluginState mPluginState = PluginState.OFF;
    private boolean mJavaScriptCanOpenWindowsAutomatically = false;
    private boolean mUseDoubleTree = false;
    private boolean mUseWideViewport = false;
    private boolean mSupportMultipleWindows = false;
    private boolean mShrinksStandaloneImagesToFit = false;
    private boolean mAppCacheEnabled = false;
    private boolean mDatabaseEnabled = true;
    private boolean mDomStorageEnabled = false;
    private boolean mWorkersEnabled = false;
    private boolean mGeolocationEnabled = true;
    private long mAppCacheMaxSize = Long.MAX_VALUE;
    private String mAppCachePath = "";
    private String mDatabasePath = "";
    private boolean mDatabasePathHasBeenSet = false;
    private String mGeolocationDatabasePath = "";
    private ZoomDensity mDefaultZoom = ZoomDensity.MEDIUM;
    private RenderPriority mRenderPriority = RenderPriority.NORMAL;
    private int mOverrideCacheMode = -1;
    private boolean mSaveFormData = true;
    private boolean mSavePassword = true;
    private boolean mLightTouchEnabled = false;
    private boolean mNeedInitialFocus = true;
    private boolean mNavDump = false;
    private boolean mSupportZoom = true;
    private boolean mBuiltInZoomControls = false;
    private boolean mAllowFileAccess = true;
    private boolean mAllowContentAccess = true;
    private boolean mLoadWithOverviewMode = false;
    private boolean mHardwareAccelSkia = false;
    private boolean mIsForcePageCanScale = false;
    public boolean mUseGLRendering = true;
    public boolean mEnableFlashFullScreenMode = true;
    private boolean mMarkSubject = false;
    private boolean mNightModeEnabled = false;
    private int mImageMaxWidth = 0;
    private boolean mCollectMainAction = false;
    private boolean mUseImageLoadProxy = false;
    private boolean mUseGifLoadProxy = false;
    private boolean mUseUnderLine = false;
    private boolean mPreloadEnabled = false;
    private boolean mUseScaleStore = true;
    private final EventHandler mEventHandler = new EventHandler();
    private String mDefaultTextEncoding = "GBK";

    /* loaded from: classes.dex */
    public enum LayoutAlgorithm {
        NORMAL,
        SINGLE_COLUMN,
        NARROW_COLUMNS
    }

    /* loaded from: classes.dex */
    public enum PluginState {
        ON,
        ON_DEMAND,
        OFF
    }

    /* loaded from: classes.dex */
    public enum RenderPriority {
        NORMAL,
        HIGH,
        LOW
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeSync(int i);

    /* loaded from: classes.dex */
    public enum TextSize {
        SMALLEST(50),
        SMALLER(75),
        NORMAL(100),
        LARGERLITTLE(125),
        LARGER(WebChromeClient.STRING_DLG_BTN_SET),
        LARGERMORE(175),
        LARGEST(200);
        
        int value;

        TextSize(int i) {
            this.value = i;
        }
    }

    /* loaded from: classes.dex */
    public enum ZoomDensity {
        FAR(WebChromeClient.STRING_DLG_BTN_SET),
        MEDIUM(100),
        CLOSE(75);
        
        int value;

        ZoomDensity(int i) {
            this.value = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class EventHandler {
        static final int POST_INVALIDATE_VIEW = 3;
        static final int PRIORITY = 1;
        static final int SET_DOUBLE_TAP_TOAST_COUNT = 2;
        static final int SYNC = 0;
        private Handler mHandler;

        private EventHandler() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void createHandler() {
            setRenderPriority();
            this.mHandler = new Handler() { // from class: com.baidu.zeus.WebSettings.EventHandler.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    switch (message.what) {
                        case 0:
                            synchronized (WebSettings.this) {
                                if (WebSettings.this.mBrowserFrame.mNativeFrame != 0) {
                                    WebSettings.this.nativeSync(WebSettings.this.mBrowserFrame.mNativeFrame);
                                }
                                WebSettings.this.mSyncPending = false;
                            }
                            return;
                        case 1:
                            EventHandler.this.setRenderPriority();
                            return;
                        case 2:
                            SharedPreferences.Editor edit = WebSettings.this.mContext.getSharedPreferences(WebSettings.PREF_FILE, 0).edit();
                            edit.putInt(WebSettings.DOUBLE_TAP_TOAST_COUNT, WebSettings.mDoubleTapToastCount);
                            edit.commit();
                            return;
                        case 3:
                            WebSettings.this.mWebView.setContentChangeState(3);
                            WebSettings.this.mWebView.postInvalidate();
                            return;
                        default:
                            return;
                    }
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRenderPriority() {
            synchronized (WebSettings.this) {
                if (WebSettings.this.mRenderPriority != RenderPriority.NORMAL) {
                    if (WebSettings.this.mRenderPriority != RenderPriority.HIGH) {
                        if (WebSettings.this.mRenderPriority == RenderPriority.LOW) {
                            Process.setThreadPriority(10);
                        }
                    } else {
                        Process.setThreadPriority(-1);
                    }
                } else {
                    Process.setThreadPriority(0);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized boolean sendMessage(Message message) {
            boolean z;
            if (this.mHandler != null) {
                this.mHandler.sendMessage(message);
                z = true;
            } else {
                z = false;
            }
            return z;
        }
    }

    public synchronized void setHardwareAccelSkiaEnabled(boolean z) {
        if (this.mHardwareAccelSkia != z) {
            this.mHardwareAccelSkia = z;
            postSync();
        }
    }

    public synchronized boolean getHardwareAccelSkiaEnabled() {
        return this.mHardwareAccelSkia;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebSettings(Context context, WebView webView) {
        this.mContext = context;
        this.mWebView = webView;
        if (sLockForLocaleSettings == null) {
            sLockForLocaleSettings = new Object();
            sLocale = Locale.getDefault();
        }
        this.mAcceptLanguage = getCurrentAcceptLanguage();
        this.mUserAgent = getCurrentUserAgent();
        this.mUseDefaultUserAgent = true;
        this.mBlockNetworkLoads = this.mContext.checkPermission("android.permission.INTERNET", Process.myPid(), Process.myUid()) != 0;
    }

    private String getCurrentAcceptLanguage() {
        Locale locale;
        synchronized (sLockForLocaleSettings) {
            locale = sLocale;
        }
        StringBuffer stringBuffer = new StringBuffer();
        String language = locale.getLanguage();
        if (language != null) {
            stringBuffer.append(language);
            String country = locale.getCountry();
            if (country != null) {
                stringBuffer.append("-");
                stringBuffer.append(country);
            }
        }
        if (!locale.equals(Locale.US)) {
            stringBuffer.append(", ");
            Locale locale2 = Locale.US;
            if (locale2.getLanguage() != null) {
                stringBuffer.append(locale2.getLanguage());
                String country2 = locale2.getCountry();
                if (country2 != null) {
                    stringBuffer.append("-");
                    stringBuffer.append(country2);
                }
            }
        }
        return stringBuffer.toString();
    }

    private synchronized String getCurrentUserAgent() {
        Locale locale;
        StringBuffer stringBuffer;
        synchronized (sLockForLocaleSettings) {
            locale = sLocale;
        }
        stringBuffer = new StringBuffer();
        String str = Build.VERSION.RELEASE;
        if (str.length() > 0) {
            stringBuffer.append(str);
        } else {
            stringBuffer.append("1.0");
        }
        stringBuffer.append("; ");
        String language = locale.getLanguage();
        if (language != null) {
            stringBuffer.append(language.toLowerCase());
            String country = locale.getCountry();
            if (country != null) {
                stringBuffer.append("-");
                stringBuffer.append(country.toLowerCase());
            }
        } else {
            stringBuffer.append("en");
        }
        return String.format("Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/530.17 (KHTML, like Gecko) Version/4.0 Mobile Safari/530.17", stringBuffer);
    }

    public void setNavDump(boolean z) {
        this.mNavDump = z;
    }

    public boolean getNavDump() {
        return this.mNavDump;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean supportTouchOnly() {
        return this.mLightTouchEnabled;
    }

    public void setSupportZoom(boolean z) {
        this.mSupportZoom = z;
        this.mWebView.updateMultiTouchSupport(this.mContext);
        postSync();
    }

    public boolean supportZoom() {
        return this.mSupportZoom;
    }

    public void setBuiltInZoomControls(boolean z) {
        this.mBuiltInZoomControls = z;
        this.mWebView.updateMultiTouchSupport(this.mContext);
    }

    public boolean getBuiltInZoomControls() {
        return this.mBuiltInZoomControls;
    }

    public void setAllowFileAccess(boolean z) {
        this.mAllowFileAccess = z;
    }

    public boolean getAllowFileAccess() {
        return this.mAllowFileAccess;
    }

    public void setAllowContentAccess(boolean z) {
        this.mAllowContentAccess = z;
    }

    public boolean getAllowContentAccess() {
        return this.mAllowContentAccess;
    }

    public void setLoadWithOverviewMode(boolean z) {
        this.mLoadWithOverviewMode = z;
    }

    public boolean getLoadWithOverviewMode() {
        return this.mLoadWithOverviewMode;
    }

    public void setSaveFormData(boolean z) {
        this.mSaveFormData = z;
    }

    public boolean getSaveFormData() {
        return this.mSaveFormData;
    }

    public void setSavePassword(boolean z) {
        this.mSavePassword = z;
    }

    public boolean getSavePassword() {
        return this.mSavePassword;
    }

    public synchronized void setTextSize(TextSize textSize) {
        if (WebView.mLogEvent && this.mTextSize != textSize) {
            EventLog.writeEvent((int) EVENT_LOG_BROWSER_TEXT_SIZE_CHANGE, Integer.valueOf(this.mTextSize.value), Integer.valueOf(textSize.value));
        }
        if (this.mWebView != null) {
            this.mWebView.selectionDone();
        }
        this.mTextSize = textSize;
        postSync();
    }

    public synchronized TextSize getTextSize() {
        return this.mTextSize;
    }

    public void setDefaultZoom(ZoomDensity zoomDensity) {
        if (this.mDefaultZoom != zoomDensity) {
            this.mDefaultZoom = zoomDensity;
            this.mWebView.updateDefaultZoomDensity(zoomDensity.value);
        }
    }

    public ZoomDensity getDefaultZoom() {
        return this.mDefaultZoom;
    }

    public void setLightTouchEnabled(boolean z) {
        this.mLightTouchEnabled = z;
    }

    public boolean getLightTouchEnabled() {
        return this.mLightTouchEnabled;
    }

    @Deprecated
    public synchronized void setUseDoubleTree(boolean z) {
    }

    @Deprecated
    public synchronized boolean getUseDoubleTree() {
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x002a, code lost:
        if (r3 != 0) goto L7;
     */
    @Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void setUserAgent(int i) {
        String str = null;
        if (i == 1) {
            if (!DESKTOP_USERAGENT.equals(this.mUserAgent)) {
                str = DESKTOP_USERAGENT;
                setUserAgentString(str);
            }
        } else if (i == 2) {
            if (!IPHONE_USERAGENT.equals(this.mUserAgent)) {
                str = IPHONE_USERAGENT;
                setUserAgentString(str);
            }
        }
    }

    @Deprecated
    public synchronized int getUserAgent() {
        int i;
        if (DESKTOP_USERAGENT.equals(this.mUserAgent)) {
            i = 1;
        } else if (IPHONE_USERAGENT.equals(this.mUserAgent)) {
            i = 2;
        } else if (this.mUseDefaultUserAgent) {
            i = 0;
        } else {
            i = -1;
        }
        return i;
    }

    public synchronized void setUseWideViewPort(boolean z) {
        if (this.mUseWideViewport != z) {
            this.mUseWideViewport = z;
            postSync();
        }
    }

    public synchronized boolean getUseWideViewPort() {
        return this.mUseWideViewport;
    }

    public synchronized void setForcePageCanBeScaled(boolean z) {
        if (this.mIsForcePageCanScale != z) {
            this.mIsForcePageCanScale = z;
            postSync();
        }
    }

    public synchronized boolean getIsForcePageCanBeScaled() {
        return this.mIsForcePageCanScale;
    }

    public synchronized void setUseGLRendering(boolean z) {
        if (this.mUseGLRendering != z) {
            this.mUseGLRendering = z;
            postSync();
        }
    }

    public boolean getUseGLRendering() {
        return this.mUseGLRendering;
    }

    public synchronized void setEnableFlashFullScreenMode(boolean z) {
        if (this.mEnableFlashFullScreenMode != z) {
            this.mEnableFlashFullScreenMode = z;
            postSync();
        }
    }

    public boolean getFlashFullScreenMode() {
        return this.mEnableFlashFullScreenMode;
    }

    public synchronized void setSupportMultipleWindows(boolean z) {
        if (this.mSupportMultipleWindows != z) {
            this.mSupportMultipleWindows = z;
            postSync();
        }
    }

    public synchronized boolean supportMultipleWindows() {
        return this.mSupportMultipleWindows;
    }

    public synchronized void setLayoutAlgorithm(LayoutAlgorithm layoutAlgorithm) {
        if (this.mLayoutAlgorithm != layoutAlgorithm) {
            this.mLayoutAlgorithm = layoutAlgorithm;
            postSync();
        }
    }

    public synchronized LayoutAlgorithm getLayoutAlgorithm() {
        return this.mLayoutAlgorithm;
    }

    public synchronized void setStandardFontFamily(String str) {
        if (str != null) {
            if (!str.equals(this.mStandardFontFamily)) {
                this.mStandardFontFamily = str;
                postSync();
            }
        }
    }

    public synchronized String getStandardFontFamily() {
        return this.mStandardFontFamily;
    }

    public synchronized void setFixedFontFamily(String str) {
        if (str != null) {
            if (!str.equals(this.mFixedFontFamily)) {
                this.mFixedFontFamily = str;
                postSync();
            }
        }
    }

    public synchronized String getFixedFontFamily() {
        return this.mFixedFontFamily;
    }

    public synchronized void setSansSerifFontFamily(String str) {
        if (str != null) {
            if (!str.equals(this.mSansSerifFontFamily)) {
                this.mSansSerifFontFamily = str;
                postSync();
            }
        }
    }

    public synchronized String getSansSerifFontFamily() {
        return this.mSansSerifFontFamily;
    }

    public synchronized void setSerifFontFamily(String str) {
        if (str != null) {
            if (!str.equals(this.mSerifFontFamily)) {
                this.mSerifFontFamily = str;
                postSync();
            }
        }
    }

    public synchronized String getSerifFontFamily() {
        return this.mSerifFontFamily;
    }

    public synchronized void setCursiveFontFamily(String str) {
        if (str != null) {
            if (!str.equals(this.mCursiveFontFamily)) {
                this.mCursiveFontFamily = str;
                postSync();
            }
        }
    }

    public synchronized String getCursiveFontFamily() {
        return this.mCursiveFontFamily;
    }

    public synchronized void setFantasyFontFamily(String str) {
        if (str != null) {
            if (!str.equals(this.mFantasyFontFamily)) {
                this.mFantasyFontFamily = str;
                postSync();
            }
        }
    }

    public synchronized String getFantasyFontFamily() {
        return this.mFantasyFontFamily;
    }

    public synchronized void setMinimumFontSize(int i) {
        int pin = pin(i);
        if (this.mMinimumFontSize != pin) {
            this.mMinimumFontSize = pin;
            postSync();
        }
    }

    public synchronized int getMinimumFontSize() {
        return this.mMinimumFontSize;
    }

    public synchronized void setMinimumLogicalFontSize(int i) {
        int pin = pin(i);
        if (this.mMinimumLogicalFontSize != pin) {
            this.mMinimumLogicalFontSize = pin;
            postSync();
        }
    }

    public synchronized int getMinimumLogicalFontSize() {
        return this.mMinimumLogicalFontSize;
    }

    public synchronized void setDefaultFontSize(int i) {
        int pin = pin(i);
        if (this.mDefaultFontSize != pin) {
            this.mDefaultFontSize = pin;
            postSync();
        }
    }

    public synchronized int getDefaultFontSize() {
        return this.mDefaultFontSize;
    }

    public synchronized void setDefaultFixedFontSize(int i) {
        int pin = pin(i);
        if (this.mDefaultFixedFontSize != pin) {
            this.mDefaultFixedFontSize = pin;
            postSync();
        }
    }

    public synchronized int getDefaultFixedFontSize() {
        return this.mDefaultFixedFontSize;
    }

    public synchronized void setPageCacheCapacity(int i) {
        synchronized (this) {
            int i2 = i < 0 ? 0 : i;
            int i3 = i2 <= 20 ? i2 : 20;
            if (this.mPageCacheCapacity != i3) {
                this.mPageCacheCapacity = i3;
                postSync();
            }
        }
    }

    public synchronized void setLoadsImagesAutomatically(boolean z) {
        if (this.mLoadsImagesAutomatically != z) {
            this.mLoadsImagesAutomatically = z;
            postSync();
        }
    }

    public synchronized boolean getLoadsImagesAutomatically() {
        return this.mLoadsImagesAutomatically;
    }

    public synchronized void setBlockNetworkImage(boolean z) {
        if (this.mBlockNetworkImage != z) {
            this.mBlockNetworkImage = z;
            postSync();
        }
    }

    public synchronized boolean getBlockNetworkImage() {
        return this.mBlockNetworkImage;
    }

    public synchronized void setBlockNetworkLoads(boolean z) {
        if (this.mBlockNetworkLoads != z) {
            this.mBlockNetworkLoads = z;
            verifyNetworkAccess();
        }
    }

    public synchronized boolean getBlockNetworkLoads() {
        return this.mBlockNetworkLoads;
    }

    private void verifyNetworkAccess() {
        if (!this.mBlockNetworkLoads && this.mContext.checkPermission("android.permission.INTERNET", Process.myPid(), Process.myUid()) != 0) {
            throw new SecurityException("Permission denied - application missing INTERNET permission");
        }
    }

    public synchronized void setJavaScriptEnabled(boolean z) {
        if (this.mJavaScriptEnabled != z) {
            this.mJavaScriptEnabled = z;
            postSync();
        }
    }

    public synchronized void setPluginsEnabled(boolean z) {
        setPluginState(PluginState.ON);
    }

    public synchronized void setPluginState(PluginState pluginState) {
        if (this.mPluginState != pluginState) {
            this.mPluginState = pluginState;
            postSync();
        }
    }

    public synchronized void setPluginsPath(String str) {
    }

    public synchronized void setDatabasePath(String str) {
        if (str != null) {
            if (!this.mDatabasePathHasBeenSet) {
                this.mDatabasePath = str;
                this.mDatabasePathHasBeenSet = true;
                postSync();
            }
        }
    }

    public synchronized void setGeolocationDatabasePath(String str) {
        if (str != null) {
            if (!str.equals(this.mGeolocationDatabasePath)) {
                this.mGeolocationDatabasePath = str;
                postSync();
            }
        }
    }

    public synchronized void setAppCacheEnabled(boolean z) {
        if (this.mAppCacheEnabled != z) {
            this.mAppCacheEnabled = z;
            postSync();
        }
    }

    public synchronized void setAppCachePath(String str) {
        if (str != null) {
            if (!str.equals(this.mAppCachePath)) {
                this.mAppCachePath = str;
                postSync();
            }
        }
    }

    public synchronized void setAppCacheMaxSize(long j) {
        if (j != this.mAppCacheMaxSize) {
            this.mAppCacheMaxSize = j;
            postSync();
        }
    }

    public synchronized void setDatabaseEnabled(boolean z) {
        if (this.mDatabaseEnabled != z) {
            this.mDatabaseEnabled = z;
            postSync();
        }
    }

    public synchronized void setDomStorageEnabled(boolean z) {
        if (this.mDomStorageEnabled != z) {
            this.mDomStorageEnabled = z;
            postSync();
        }
    }

    public synchronized boolean getDomStorageEnabled() {
        return this.mDomStorageEnabled;
    }

    public synchronized String getDatabasePath() {
        return this.mDatabasePath;
    }

    public synchronized boolean getDatabaseEnabled() {
        return this.mDatabaseEnabled;
    }

    public synchronized void setWorkersEnabled(boolean z) {
        if (this.mWorkersEnabled != z) {
            this.mWorkersEnabled = z;
            postSync();
        }
    }

    public synchronized void setGeolocationEnabled(boolean z) {
        if (this.mGeolocationEnabled != z) {
            this.mGeolocationEnabled = z;
            postSync();
        }
    }

    public synchronized boolean getJavaScriptEnabled() {
        return this.mJavaScriptEnabled;
    }

    public synchronized boolean getPluginsEnabled() {
        return this.mPluginState == PluginState.ON;
    }

    public synchronized PluginState getPluginState() {
        return this.mPluginState;
    }

    public synchronized String getPluginsPath() {
        return "";
    }

    public synchronized void setJavaScriptCanOpenWindowsAutomatically(boolean z) {
        if (this.mJavaScriptCanOpenWindowsAutomatically != z) {
            this.mJavaScriptCanOpenWindowsAutomatically = z;
            postSync();
        }
    }

    public synchronized boolean getJavaScriptCanOpenWindowsAutomatically() {
        return this.mJavaScriptCanOpenWindowsAutomatically;
    }

    public synchronized void setDefaultTextEncodingName(String str) {
        if (str != null) {
            if (!str.equals(this.mDefaultTextEncoding)) {
                this.mDefaultTextEncoding = str;
                postSync();
            }
        }
    }

    public synchronized String getDefaultTextEncodingName() {
        return this.mDefaultTextEncoding;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0030 A[Catch: all -> 0x003a, TRY_LEAVE, TryCatch #1 {, blocks: (B:4:0x0003, B:25:0x003e, B:13:0x0028, B:15:0x0030, B:6:0x0009, B:7:0x000b, B:12:0x0021, B:8:0x000c, B:10:0x0018, B:11:0x0020), top: B:27:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void setUserAgentString(String str) {
        if (str != null) {
            if (str.length() != 0) {
                this.mUseDefaultUserAgent = false;
                if (!str.equals(this.mUserAgent)) {
                    this.mUserAgent = str;
                    postSync();
                }
            }
        }
        synchronized (sLockForLocaleSettings) {
            Locale locale = Locale.getDefault();
            if (!sLocale.equals(locale)) {
                sLocale = locale;
                this.mAcceptLanguage = getCurrentAcceptLanguage();
            }
        }
        str = getCurrentUserAgent();
        this.mUseDefaultUserAgent = true;
        if (!str.equals(this.mUserAgent)) {
        }
    }

    public synchronized String getUserAgentString() {
        String str;
        if (DESKTOP_USERAGENT.equals(this.mUserAgent) || IPHONE_USERAGENT.equals(this.mUserAgent) || !this.mUseDefaultUserAgent) {
            str = this.mUserAgent;
        } else {
            boolean z = false;
            synchronized (sLockForLocaleSettings) {
                Locale locale = Locale.getDefault();
                if (!sLocale.equals(locale)) {
                    sLocale = locale;
                    this.mUserAgent = getCurrentUserAgent();
                    this.mAcceptLanguage = getCurrentAcceptLanguage();
                    z = true;
                }
            }
            if (z) {
                postSync();
            }
            str = this.mUserAgent;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized String getAcceptLanguage() {
        synchronized (sLockForLocaleSettings) {
            Locale locale = Locale.getDefault();
            if (!sLocale.equals(locale)) {
                sLocale = locale;
                this.mAcceptLanguage = getCurrentAcceptLanguage();
            }
        }
        return this.mAcceptLanguage;
    }

    public void setNeedInitialFocus(boolean z) {
        if (this.mNeedInitialFocus != z) {
            this.mNeedInitialFocus = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean getNeedInitialFocus() {
        return this.mNeedInitialFocus;
    }

    public synchronized void setRenderPriority(RenderPriority renderPriority) {
        if (this.mRenderPriority != renderPriority) {
            this.mRenderPriority = renderPriority;
            this.mEventHandler.sendMessage(Message.obtain((Handler) null, 1));
        }
    }

    public void setCacheMode(int i) {
        if (i != this.mOverrideCacheMode) {
            this.mOverrideCacheMode = i;
        }
    }

    public int getCacheMode() {
        return this.mOverrideCacheMode;
    }

    public void setShrinksStandaloneImagesToFit(boolean z) {
        if (this.mShrinksStandaloneImagesToFit != z) {
            this.mShrinksStandaloneImagesToFit = z;
            postSync();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getDoubleTapToastCount() {
        return mDoubleTapToastCount;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setDoubleTapToastCount(int i) {
        if (mDoubleTapToastCount != i) {
            mDoubleTapToastCount = i;
            this.mEventHandler.sendMessage(Message.obtain((Handler) null, 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void syncSettingsAndCreateHandler(BrowserFrame browserFrame) {
        this.mBrowserFrame = browserFrame;
        SharedPreferences sharedPreferences = this.mContext.getSharedPreferences(PREF_FILE, 0);
        if (mDoubleTapToastCount > 0) {
            mDoubleTapToastCount = sharedPreferences.getInt(DOUBLE_TAP_TOAST_COUNT, mDoubleTapToastCount);
        }
        nativeSync(browserFrame.mNativeFrame);
        this.mSyncPending = false;
        this.mEventHandler.createHandler();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void onDestroyed() {
    }

    private int pin(int i) {
        if (i < 1) {
            return 1;
        }
        if (i > 72) {
            return 72;
        }
        return i;
    }

    public void setMarkSubjectEnabled(boolean z) {
        if (this.mMarkSubject != z) {
            this.mMarkSubject = z;
            postSync();
        }
    }

    public boolean markSubjectEnabled() {
        return this.mMarkSubject;
    }

    public void setNightModeEnabled(boolean z) {
        if (this.mNightModeEnabled != z) {
            this.mNightModeEnabled = z;
            postSync();
            if (z) {
                this.mWebView.setBackgroundColorNotCore(-16777216);
            } else {
                this.mWebView.setBackgroundColorNotCore(-1);
            }
            postInvalidateView();
        }
    }

    public boolean nightModeEnabled() {
        return this.mNightModeEnabled;
    }

    public void setImageMaxWidth(int i) {
        if (this.mImageMaxWidth != i) {
            this.mImageMaxWidth = i;
            postSync();
        }
    }

    public void setCollectMainAction(boolean z) {
        if (this.mCollectMainAction != z) {
            this.mCollectMainAction = z;
            postSync();
        }
    }

    public boolean collectMainAction() {
        return this.mCollectMainAction;
    }

    public void setUseImageLoadProxy(boolean z) {
        if (this.mUseImageLoadProxy != z) {
            this.mUseImageLoadProxy = z;
            postSync();
        }
    }

    public boolean useImageLoadProxy() {
        return this.mUseImageLoadProxy;
    }

    public void setEnableVideo(boolean z) {
        if (this.mDisableFlash != z) {
            this.mDisableFlash = z;
            postSync();
        }
    }

    public boolean getEnableVideo() {
        return this.mDisableFlash;
    }

    public synchronized void setPauseAudioEnabled(boolean z) {
        if (this.mPauseAudioEnabled != z) {
            this.mPauseAudioEnabled = z;
            postSync();
        }
    }

    public synchronized boolean getPauseAudioEnabled() {
        return this.mPauseAudioEnabled;
    }

    public void setUseGifLoadProxy(boolean z) {
        if (this.mUseGifLoadProxy != z) {
            this.mUseGifLoadProxy = z;
            postSync();
        }
    }

    public boolean useGifLoadProxy() {
        return this.mUseGifLoadProxy;
    }

    public void setUseUnderLine(boolean z) {
        if (this.mUseUnderLine != z) {
            this.mUseUnderLine = z;
            postSync();
        }
    }

    public boolean useUnderLine() {
        return this.mUseUnderLine;
    }

    public boolean preloadEnabled() {
        return this.mPreloadEnabled;
    }

    public void setPreloadEnabled(boolean z) {
        if (this.mPreloadEnabled != z) {
            this.mPreloadEnabled = z;
            postSync();
        }
    }

    public boolean useScaleStore() {
        return this.mUseScaleStore;
    }

    public void setUseScaleStore(boolean z) {
        if (this.mUseScaleStore != z) {
            this.mUseScaleStore = z;
            postSync();
        }
    }

    private synchronized void postSync() {
        if (!this.mSyncPending) {
            this.mSyncPending = this.mEventHandler.sendMessage(Message.obtain((Handler) null, 0));
        }
    }

    private synchronized void postInvalidateView() {
        this.mEventHandler.sendMessage(Message.obtain((Handler) null, 3));
    }
}
