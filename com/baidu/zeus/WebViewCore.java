package com.baidu.zeus;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DrawFilter;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Picture;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Region;
import android.media.MediaFile;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import com.baidu.browser.explorer.BdWebErrorView;
import com.baidu.browser.webpool.BdWebPoolView;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import com.baidu.zeus.GeolocationPermissions;
import com.baidu.zeus.ViewManager;
import com.baidu.zeus.WebSettings;
import com.baidu.zeus.WebStorage;
import com.baidu.zeus.WebView;
import com.baidu.zeus.bouncycastle.DERTags;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import junit.framework.Assert;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class WebViewCore {
    static final int ACTION_DOUBLETAP = 512;
    static final int ACTION_LONGPRESS = 256;
    static final int DEFAULT_VIEWPORT_WIDTH = 800;
    private static final String LOGTAG = "webviewcore.java";
    static final int SCROLL_BITS = 6;
    static final String THREAD_NAME = "WebViewCoreThread";
    static final int ZOOM_BITS = 134;
    private static Handler sWebCoreHandler;
    private BrowserFrame mBrowserFrame;
    private final CallbackProxy mCallbackProxy;
    private final Context mContext;
    private DeviceMotionService mDeviceMotionService;
    private DeviceOrientationService mDeviceOrientationService;
    private boolean mDrawIsPaused;
    private boolean mDrawIsScheduled;
    private boolean mDrawLayersIsScheduled;
    private final EventHub mEventHub;
    private int mHighMemoryUsageThresholdMb;
    private int mHighUsageDeltaMb;
    private Map<String, Object> mJavascriptInterfaces;
    private int mLowMemoryUsageThresholdMb;
    private int mNativeClass;
    private final WebSettings mSettings;
    private boolean mSplitPictureIsScheduled;
    private WebView mWebView;
    static final String[] HandlerDebugString = {"REQUEST_LABEL", "UPDATE_FRAME_CACHE_IF_LOADING", "SCROLL_TEXT_INPUT", "LOAD_URL", "STOP_LOADING", "RELOAD", "KEY_DOWN", "KEY_UP", "VIEW_SIZE_CHANGED", "GO_BACK_FORWARD", "SET_SCROLL_OFFSET", "RESTORE_STATE", "PAUSE_TIMERS", "RESUME_TIMERS", "CLEAR_CACHE", "CLEAR_HISTORY", "SET_SELECTION", "REPLACE_TEXT", "PASS_TO_JS", "SET_GLOBAL_BOUNDS", "UPDATE_CACHE_AND_TEXT_ENTRY", "CLICK", "SET_NETWORK_STATE", "DOC_HAS_IMAGES", "121", "DELETE_SELECTION", "LISTBOX_CHOICES", "SINGLE_LISTBOX_CHOICE", "MESSAGE_RELAY", "SET_BACKGROUND_COLOR", "SET_MOVE_FOCUS", "SAVE_DOCUMENT_STATE", "129", "WEBKIT_DRAW", "SYNC_SCROLL", "POST_URL", "SPLIT_PICTURE_SET", "CLEAR_CONTENT", "SET_MOVE_MOUSE", "SET_MOVE_MOUSE_IF_LATEST", "REQUEST_CURSOR_HREF", "ADD_JS_INTERFACE", "LOAD_DATA", "TOUCH_UP", "TOUCH_EVENT", "SET_ACTIVE", "ON_PAUSE", "ON_RESUME", "FREE_MEMORY", "VALID_NODE_BOUNDS", "STOP_SCROLL", "WEBKIT_DRAW_LAYERS", "SET_WEBVIEW_ACTION", "FIRST_LAYOUT", "LONG_PRESS"};
    private static boolean mRepaintScheduled = false;
    private int mViewportWidth = -1;
    private int mViewportHeight = -1;
    private int mViewportInitialScale = 0;
    private int mViewportMinimumScale = 0;
    private int mViewportMaximumScale = 0;
    private boolean mViewportUserScalable = true;
    private int mSiteTypeWebCore = -1;
    private boolean mIsMobileSiteWebCore = false;
    private int mViewportDensityDpi = -1;
    private int mRestoredScale = 0;
    private int mRestoredScreenWidthScale = 0;
    private int mRestoredX = 0;
    private int mRestoredY = 0;
    private int mWebkitScrollX = 0;
    private int mWebkitScrollY = 0;
    private boolean mSuspendWebView = false;
    private boolean mUpdateViewPort = false;
    private DeviceMotionAndOrientationManager mDeviceMotionAndOrientationManager = new DeviceMotionAndOrientationManager(this);
    private int mCurrentViewWidth = 0;
    private int mCurrentViewHeight = 0;
    private float mCurrentViewScale = 1.0f;
    private boolean m_ForceResumeUpdatePic = false;
    private RestoreState mRestoreState = null;
    DrawData mLastDrawData = null;
    final DrawFilter mZoomFilter = new PaintFlagsDrawFilter(ZOOM_BITS, 64);
    final DrawFilter mScrollFilter = new PaintFlagsDrawFilter(6, 0);
    private ArrayList<Rect> mSubjectRectsWebCore = new ArrayList<>();
    private int mLastSubjectRectLeft = -1;
    private int mLastSubjectRectTop = -1;
    private int mLastSubjectRectRight = -1;
    private int mLastSubjectRectBottom = -1;
    private int mLastCount = -1;

    /* loaded from: classes.dex */
    class BaseUrlData {
        String mBaseUrl;
        String mData;
        String mEncoding;
        String mHistoryUrl;
        String mMimeType;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class DoubleTapScaleData {
        int mAnchorX;
        int mAnchorY;
        Rect mBlockRect;
        int mNode;
        int mScreenWidth;
    }

    /* loaded from: classes.dex */
    class EngWordData {
        int bottom;
        int left;
        int picture;
        int right;
        int top;
        int x;
        int y;
    }

    /* loaded from: classes.dex */
    class GetUrlData {
        Map<String, String> mExtraHeaders;
        WebView.PageType mType;
        String mUrl;
    }

    /* loaded from: classes.dex */
    class JSInterfaceData {
        String mInterfaceName;
        Object mObject;
    }

    /* loaded from: classes.dex */
    class JSKeyData {
        String mCurrentText;
        KeyEvent mEvent;
    }

    /* loaded from: classes.dex */
    class MotionUpData {
        Rect mBounds;
        int mFrame;
        int mNode;
        int mX;
        int mY;
        boolean sendToCore = true;
    }

    /* loaded from: classes.dex */
    class PostUrlData {
        byte[] mPostData;
        String mUrl;
    }

    /* loaded from: classes.dex */
    class ReplaceTextData {
        int mNewEnd;
        int mNewStart;
        String mReplace;
        int mTextGeneration;
    }

    /* loaded from: classes.dex */
    class TouchEventData {
        int mAction;
        int mActionIndex;
        int[] mIds;
        int mMetaState;
        MotionEvent mMotionEvent;
        int mNativeLayer;
        Rect mNativeLayerRect = new Rect();
        boolean mNativeResult;
        boolean mReprocess;
        long mSequence;
        float mViewX;
        float mViewY;
        int mX;
        int mY;
    }

    /* loaded from: classes.dex */
    class TouchHighlightData {
        int mNativeLayer;
        Rect mNativeLayerRect;
        int mSlop;
        int mX;
        int mY;
    }

    /* loaded from: classes.dex */
    class TouchUpData {
        int mFrame;
        int mMoveGeneration;
        int mNativeLayer;
        Rect mNativeLayerRect = new Rect();
        int mNode;
        int mX;
        int mY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native void makeNativeElementExitFullScreen(int i);

    private native void nativeCanvasDrawBitmap(Canvas canvas, Bitmap bitmap);

    private native boolean nativeCheckIfNeedUpdateSubjectRects();

    private native boolean nativeCleanBitmap();

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeClearContent();

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeClearFocus();

    private native void nativeClearLastSubjectRects();

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeClick(int i, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeCloseIdleConnections();

    private native void nativeCopyContentToPicture(int i, int i2, int i3, int i4, int i5, int i6, int i7, float f);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeCoreInvalidate(int i, int i2, int i3, int i4);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeDeleteSelection(int i, int i2, int i3);

    private native boolean nativeDestroyPluginView();

    /* JADX INFO: Access modifiers changed from: private */
    public native Rect nativeDoubleTapMaxBounds(int i, int i2, int i3, int i4);

    private native boolean nativeDrawContent(Canvas canvas, Bitmap bitmap, int i, float f, float f2, float f3, float f4, float f5, int i2, int i3, int i4, boolean z, boolean z2, boolean z3);

    private native boolean nativeDrawContentInScale(Canvas canvas, Bitmap bitmap, int i, float f, float f2, float f3, float f4, float f5, int i2, int i3, int i4, boolean z, boolean z2);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeDumpDomTree(boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeDumpNavTree();

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeDumpRenderTree(boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeDumpV8Counters();

    private native boolean nativeEmulateDrawContent(float f, float f2, float f3, float f4, float f5, int i, int i2, int i3, boolean z, boolean z2, boolean z3);

    /* JADX INFO: Access modifiers changed from: private */
    public native Rect nativeEngWordSelection(int i, int i2, int i3, int i4, int i5, int i6, int i7);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native String nativeFindAddress(String str, boolean z);

    private native boolean nativeFocusBoundsChanged();

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeFreeMemory();

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeFullScreenPluginHidden(int i);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeGeolocationPermissionsProvide(String str, boolean z, boolean z2);

    private native Bitmap nativeGetCanvasBitmap(ByteBuffer byteBuffer, boolean z);

    private native int nativeGetContentMinPrefWidth();

    private native int nativeGetLastSubjectCount();

    private native Rect nativeGetLastSubjectRect(int i);

    public static native int nativeGetNetworkDownload();

    public static native int nativeGetNetworkUpload();

    public static native int nativeGetNetworkVolume();

    /* JADX INFO: Access modifiers changed from: private */
    public native String nativeGetSelection(Region region);

    /* JADX INFO: Access modifiers changed from: private */
    public native String nativeGetSubjectContent(int i);

    private native ArrayList<Rect> nativeGetTouchHighlightRects(int i, int i2, int i3);

    /* JADX INFO: Access modifiers changed from: private */
    public native boolean nativeHandleTouchEvent(int i, int i2, int i3, int i4);

    private static native boolean nativeHasGPU();

    private native boolean nativeKey(int i, int i2, int i3, boolean z, boolean z2, boolean z3, boolean z4);

    private native boolean nativeKeyString(int i, String str, int i2, boolean z, boolean z2, boolean z3, boolean z4);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeMoveFocus(int i, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeMoveMouse(int i, int i2, int i3);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeMoveMouseIfLatest(int i, int i2, int i3, int i4);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeNotificationEventDispatch(int i, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativePageVisibilityChange(int i, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativePause();

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativePauseMedia(int i);

    private native boolean nativePictureReady();

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativePluginSurfaceReady();

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeProvideVisitedHistory(String[] strArr);

    private native int nativeRecordContent(Region region, Point point);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeRegisterURLSchemeAsLocal(String str);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeReplaceTextfieldText(int i, int i2, String str, int i3, int i4, int i5);

    /* JADX INFO: Access modifiers changed from: private */
    public native String nativeRequestLabel(int i, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeResume();

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeResumeMedia(int i);

    /* JADX INFO: Access modifiers changed from: private */
    public native String nativeRetrieveAnchorText(int i, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    public native String nativeRetrieveHref(int i, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeSaveDocumentState(int i);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeScrollFocusedTextInput(float f, int i);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeScrollLayer(int i, Rect rect);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeSendListBoxChoice(int i);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeSendListBoxChoices(boolean[] zArr, int i);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeSetBackgroundColor(int i);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeSetBigPluginView();

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeSetCanCachePage(boolean z);

    private native boolean nativeSetCanvasWidthHeight(int i, int i2, int i3);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeSetCaretVisible(boolean z);

    private native void nativeSetDirtyRgnEmpty();

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeSetFocusControllerActive(boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeSetGlobalBounds(int i, int i2, int i3, int i4);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeSetJsFlags(String str);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeSetNewStorageLimit(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeSetScrollOffset(int i, int i2, int i3);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeSetSelection(int i, int i2);

    private native void nativeSetSize(int i, int i2, int i3, float f, int i4, int i5, int i6, int i7, boolean z);

    private native boolean nativeSetSubjectBitmap(int i, int i2, int i3);

    private native void nativeSetSubjectRectToJava(int i);

    private native boolean nativeSetViewWidthHeight(int i, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeSetWebViewAction(int i);

    private native void nativeSetWebViewHeight(int i);

    private native void nativeSetWebViewWidth(int i);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeSplitContent();

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeTouchUp(int i, int i2, int i3, int i4, int i5);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeUpdateFrameCache();

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeUpdateFrameCacheIfLoading();

    private native boolean nativeUpdateLayers(int i);

    /* JADX INFO: Access modifiers changed from: private */
    public native boolean nativeValidNodeAndBounds(int i, int i2, Rect rect);

    /* JADX INFO: Access modifiers changed from: private */
    public native void passToJs(int i, String str, int i2, int i3, boolean z, boolean z2, boolean z3, boolean z4);

    private native void setViewportSettingsFromNative();

    /* loaded from: classes.dex */
    public class SITE_TYPE {
        public static final int MOBILE_SITE = 1;
        public static final int PC_SITE = 0;
        public static final int UNKNOW_SITE = -1;

        public SITE_TYPE() {
        }
    }

    public void suspendWebView() {
        this.mSuspendWebView = true;
    }

    public void resumeWebView() {
        this.mSuspendWebView = false;
        this.mEventHub.sendMessage(Message.obtain((Handler) null, 130));
    }

    public WebViewCore(Context context, WebView webView, CallbackProxy callbackProxy, Map<String, Object> map) {
        this.mCallbackProxy = callbackProxy;
        this.mWebView = webView;
        this.mJavascriptInterfaces = map;
        this.mContext = context;
        synchronized (WebViewCore.class) {
            if (sWebCoreHandler == null) {
                Thread thread = new Thread(new WebCoreThread());
                thread.setName(THREAD_NAME);
                thread.start();
                try {
                    WebViewCore.class.wait();
                } catch (InterruptedException e) {
                    Log.e(LOGTAG, "Caught exception while waiting for thread creation.");
                    Log.e(LOGTAG, Log.getStackTraceString(e));
                }
            }
        }
        this.mEventHub = new EventHub();
        this.mSettings = new WebSettings(this.mContext, this.mWebView);
        WebIconDatabase.getInstance();
        WebStorage.getInstance().createUIHandler();
        GeolocationPermissions.getInstance().createUIHandler();
        NotificationManagerThread.getInstance().initInstance(context);
        ActivityManager activityManager = (ActivityManager) this.mContext.getSystemService("activity");
        activityManager.getMemoryInfo(new ActivityManager.MemoryInfo());
        this.mLowMemoryUsageThresholdMb = activityManager.getMemoryClass();
        this.mHighMemoryUsageThresholdMb = (int) (this.mLowMemoryUsageThresholdMb * 1.5d);
        this.mHighUsageDeltaMb = this.mLowMemoryUsageThresholdMb / 32;
        Log.v("ZL", "low = " + this.mLowMemoryUsageThresholdMb + " high = " + this.mHighMemoryUsageThresholdMb + " delta = " + this.mHighUsageDeltaMb);
        sWebCoreHandler.sendMessage(sWebCoreHandler.obtainMessage(0, this));
    }

    public void notificationEventDispatch(int i, int i2) {
        sendMessage(198, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initialize() {
        this.mBrowserFrame = new BrowserFrame(this.mContext, this, this.mCallbackProxy, this.mSettings, this.mJavascriptInterfaces);
        this.mJavascriptInterfaces = null;
        this.mSettings.syncSettingsAndCreateHandler(this.mBrowserFrame);
        WebIconDatabase.getInstance().createHandler();
        WebStorage.getInstance().createHandler();
        GeolocationPermissions.getInstance().createHandler();
        this.mEventHub.transferMessages();
        if (this.mWebView != null) {
            Message.obtain(this.mWebView.mPrivateHandler, SocialAPIErrorCodes.ERROR_INVALID_TIMESTAMP, this.mNativeClass, 0).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void initializeSubwindow() {
        initialize();
        sWebCoreHandler.removeMessages(0, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BrowserFrame getBrowserFrame() {
        return this.mBrowserFrame;
    }

    public void simulateTouchUp(int i, int i2) {
        nativeTouchUp(0, 0, 0, i, i2);
    }

    public void simulateKeyDown(KeyEvent keyEvent) {
        key(keyEvent, true);
    }

    public void simulateKeyUp(KeyEvent keyEvent) {
        key(keyEvent, false);
    }

    public static void pauseTimers() {
        if (BrowserFrame.sJavaBridge == null) {
            throw new IllegalStateException("No WebView has been created in this process!");
        }
        BrowserFrame.sJavaBridge.pause();
    }

    public static void resumeTimers() {
        if (BrowserFrame.sJavaBridge == null) {
            throw new IllegalStateException("No WebView has been created in this process!");
        }
        BrowserFrame.sJavaBridge.resume();
    }

    public WebSettings getSettings() {
        return this.mSettings;
    }

    static boolean supportsMimeType(String str) {
        int fileTypeForMimeType = MediaFile.getFileTypeForMimeType(str);
        return MediaFile.isAudioFileType(fileTypeForMimeType) || MediaFile.isVideoFileType(fileTypeForMimeType) || MediaFile.isPlayListFileType(fileTypeForMimeType) || (str != null && str.startsWith("video/m4v"));
    }

    static boolean printfMyLog(String str, int i) {
        Log.v(LOGTAG, "----String = " + str + "  nSize = " + i);
        return true;
    }

    protected void addMessageToConsole(String str, int i, String str2, int i2) {
        this.mCallbackProxy.addMessageToConsole(str, i, str2, i2);
    }

    protected void jsAlert(String str, String str2) {
        this.mCallbackProxy.onJsAlert(str, str2);
    }

    private String openFileChooser() {
        Cursor query;
        Uri openFileChooser = this.mCallbackProxy.openFileChooser();
        if (openFileChooser == null) {
            return "";
        }
        if (WebKitInit.getOSId() < 3) {
            query = this.mContext.getContentResolver().query(openFileChooser, new String[]{"_display_name"}, null, null, null);
            String str = "";
            if (query != null) {
                try {
                    if (query.moveToNext()) {
                        str = query.getString(0);
                    }
                } finally {
                }
            }
            return openFileChooser.toString() + "/" + str;
        }
        query = this.mContext.getContentResolver().query(openFileChooser, new String[]{"_data"}, null, null, null);
        String str2 = "";
        if (query != null) {
            try {
                if (query.moveToNext()) {
                    str2 = Uri.decode(query.getString(0));
                }
            } finally {
            }
        } else {
            str2 = Uri.decode(openFileChooser.getLastPathSegment());
        }
        String decode = Uri.decode(openFileChooser.toString());
        return decode.startsWith("content://") ? "file://" + str2 : decode;
    }

    protected void exceededDatabaseQuota(String str, String str2, long j, long j2) {
        this.mCallbackProxy.onExceededDatabaseQuota(str, str2, j, j2, getUsedQuota(), new WebStorage.QuotaUpdater() { // from class: com.baidu.zeus.WebViewCore.1
            @Override // com.baidu.zeus.WebStorage.QuotaUpdater
            public void updateQuota(long j3) {
                WebViewCore.this.nativeSetNewStorageLimit(j3);
            }
        });
    }

    protected void reachedMaxAppCacheSize(long j) {
        this.mCallbackProxy.onReachedMaxAppCacheSize(j, getUsedQuota(), new WebStorage.QuotaUpdater() { // from class: com.baidu.zeus.WebViewCore.2
            @Override // com.baidu.zeus.WebStorage.QuotaUpdater
            public void updateQuota(long j2) {
                WebViewCore.this.nativeSetNewStorageLimit(j2);
            }
        });
    }

    protected void populateVisitedLinks() {
        this.mCallbackProxy.getVisitedHistory(new ValueCallback<String[]>() { // from class: com.baidu.zeus.WebViewCore.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.zeus.ValueCallback
            public void onReceiveValue(String[] strArr) {
                WebViewCore.this.sendMessage(181, strArr);
            }
        });
    }

    protected NotificationProxy creatNotificationProxy(String str, String str2, int i) {
        return NotificationManagerThread.getInstance().creatNotificationProxy(this.mContext, this, str, str2, i);
    }

    protected boolean showNormalNotification(NotificationProxy notificationProxy, byte[] bArr, String str, String str2) {
        return notificationProxy.simpleNotificationInit(bArr, str, str2);
    }

    protected boolean showWebNotification(NotificationProxy notificationProxy, String str) {
        return notificationProxy.webNotificationInit(str);
    }

    protected void cancelNotification(NotificationProxy notificationProxy) {
        notificationProxy.cancelFromJs();
    }

    protected void geolocationPermissionsShowPrompt(String str) {
        this.mCallbackProxy.onGeolocationPermissionsShowPrompt(str, new GeolocationPermissions.Callback() { // from class: com.baidu.zeus.WebViewCore.4
            @Override // com.baidu.zeus.GeolocationPermissions.Callback
            public void invoke(String str2, boolean z, boolean z2) {
                GeolocationPermissionsData geolocationPermissionsData = new GeolocationPermissionsData();
                geolocationPermissionsData.mOrigin = str2;
                geolocationPermissionsData.mAllow = z;
                geolocationPermissionsData.mRemember = z2;
                WebViewCore.this.sendMessage(180, geolocationPermissionsData);
            }
        });
    }

    protected void geolocationPermissionsHidePrompt() {
        this.mCallbackProxy.onGeolocationPermissionsHidePrompt();
    }

    protected boolean jsConfirm(String str, String str2) {
        return this.mCallbackProxy.onJsConfirm(str, str2);
    }

    protected String openDateTimeOrColorChooser(int i, String str) {
        return this.mCallbackProxy.onOpenDateTimeOrColorChooser(i, str);
    }

    protected void nativeElementEnterFullScreen() {
        if (this.mCallbackProxy != null && this.mCallbackProxy.getWebChromeClient() != null) {
            this.mCallbackProxy.getWebChromeClient().onNativeElementEnterFullScreen();
        }
    }

    protected void nativeElementExitFullScreen() {
        if (this.mCallbackProxy != null && this.mCallbackProxy.getWebChromeClient() != null) {
            this.mCallbackProxy.getWebChromeClient().onNativeElementExitFullScreen();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean needNotifyNativeExitFullScreen() {
        return this.mCallbackProxy.getWebChromeClient() != null && this.mCallbackProxy.getWebChromeClient().needNotifyNativeExitFullScreen();
    }

    protected String jsPrompt(String str, String str2, String str3) {
        return this.mCallbackProxy.onJsPrompt(str, str2, str3);
    }

    protected boolean jsUnload(String str, String str2) {
        return this.mCallbackProxy.onJsBeforeUnload(str, str2);
    }

    protected boolean jsInterrupt() {
        return this.mCallbackProxy.onJsTimeout();
    }

    /* loaded from: classes.dex */
    class WebCoreThread implements Runnable {
        private static final int INITIALIZE = 0;
        private static final int REDUCE_PRIORITY = 1;
        private static final int RESUME_PRIORITY = 2;

        private WebCoreThread() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Looper.prepare();
            Assert.assertNull(WebViewCore.sWebCoreHandler);
            synchronized (WebViewCore.class) {
                Handler unused = WebViewCore.sWebCoreHandler = new Handler() { // from class: com.baidu.zeus.WebViewCore.WebCoreThread.1
                    @Override // android.os.Handler
                    public void handleMessage(Message message) {
                        switch (message.what) {
                            case 0:
                                ((WebViewCore) message.obj).initialize();
                                return;
                            case 1:
                                Process.setThreadPriority(3);
                                return;
                            case 2:
                                Process.setThreadPriority(0);
                                return;
                            case 193:
                                if (BrowserFrame.sJavaBridge == null) {
                                    throw new IllegalStateException("No WebView has been created in this process!");
                                }
                                BrowserFrame.sJavaBridge.updateProxy((ProxyProperties) message.obj);
                                return;
                            default:
                                return;
                        }
                    }
                };
                WebViewCore.class.notify();
            }
            Looper.loop();
        }
    }

    /* loaded from: classes.dex */
    class CursorData {
        int mFrame;
        int mMoveGeneration;
        int mNode;
        int mX;
        int mY;

        /* JADX INFO: Access modifiers changed from: package-private */
        public CursorData() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public CursorData(int i, int i2, int i3, int i4) {
            this.mFrame = i;
            this.mNode = i2;
            this.mX = i3;
            this.mY = i4;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class TextSelectionData {
        int mEnd;
        int mStart;

        public TextSelectionData(int i, int i2) {
            this.mStart = i;
            this.mEnd = i2;
        }
    }

    /* loaded from: classes.dex */
    class RequestKeyboardData {
        Rect mBounds;
        TextSelectionData mSelData;
        String mText;

        public RequestKeyboardData(TextSelectionData textSelectionData, Rect rect, String str) {
            this.mSelData = null;
            this.mBounds = null;
            this.mText = null;
            this.mSelData = textSelectionData;
            this.mBounds = rect;
            this.mText = str;
        }
    }

    /* loaded from: classes.dex */
    class GeolocationPermissionsData {
        boolean mAllow;
        String mOrigin;
        boolean mRemember;

        GeolocationPermissionsData() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class EventHub {
        static final int ADD_JS_INTERFACE = 138;
        static final int ADD_PACKAGE_NAME = 185;
        static final int ADD_PACKAGE_NAMES = 184;
        static final int CHECK_CLICK_ON_SUBJECT = 408;
        static final int CLEAR_CACHE = 111;
        static final int CLEAR_CONTENT = 134;
        static final int CLEAR_FOCUS = 187;
        static final int CLEAR_HISTORY = 112;
        static final int CLEAR_SSL_PREF_TABLE = 150;
        static final int CLICK = 118;
        static final int CORE_INVALIDATE = 188;
        static final int CORE_SEND_CAPTURE_SCALE_PIC = 189;
        static final int DELETE_SELECTION = 122;
        private static final int DESTROY = 200;
        static final int DESTROY_PLUGINVIEW = 300;
        static final int DOC_HAS_IMAGES = 120;
        static final int DOUBLE_TAP_SCALE = 502;
        static final int DUMP_DOMTREE = 170;
        static final int DUMP_NAVTREE = 172;
        static final int DUMP_RENDERTREE = 171;
        static final int DUMP_V8COUNTERS = 173;
        static final int ENGLISH_WORD_SELECTION = 404;
        static final int EXIT_FULLSCREEN_MODE = 302;
        static final int FEATURE_PERMISSIONS_PROVIDE = 199;
        static final int FIRST_LAYOUT = 400;
        static final int FREE_MEMORY = 145;
        static final int GEOLOCATION_PERMISSIONS_PROVIDE = 180;
        static final int GET_SELECTION = 403;
        static final int GET_TOUCH_HIGHLIGHT_RECTS = 301;
        static final int GO_BACK_FORWARD = 106;
        static final int HIDE_FULLSCREEN = 182;
        static final int KEY_DOWN = 103;
        static final int KEY_UP = 104;
        static final int LISTBOX_CHOICES = 123;
        static final int LOAD_DATA = 139;
        static final int LOAD_URL = 100;
        static final int LONG_PRESS = 402;
        static final int MESSAGE_RELAY = 125;
        static final int NOTIFICATION_EVENT_DISPATCH = 198;
        static final int NOTIFY_NATIVE_EXIT_FULL_SCREEN = 409;
        static final int ON_PAUSE = 143;
        static final int ON_PAUSE_MEDIA = 503;
        static final int ON_RESUME = 144;
        static final int ON_RESUME_MEDIA = 504;
        static final int PAGE_VISIBILITY_CHANGE = 501;
        static final int PASS_TO_JS = 115;
        static final int PAUSE_TIMERS = 109;
        static final int PLUGIN_SURFACE_READY = 500;
        static final int POPULATE_VISITED_LINKS = 181;
        static final int POST_URL = 132;
        static final int PROXY_CHANGED = 193;
        static final int RELOAD = 102;
        static final int REMOVE_PACKAGE_NAME = 186;
        static final int REPLACE_TEXT = 114;
        static final int REQUEST_CURSOR_HREF = 137;
        static final int REQUEST_DOC_AS_TEXT = 161;
        static final int REQUEST_EXT_REPRESENTATION = 160;
        static final int REQUEST_LABEL = 97;
        static final int RESTORE_STATE = 108;
        static final int RESUME_TIMERS = 110;
        static final int SAVE_DOCUMENT_STATE = 128;
        static final int SCROLL_TEXT_INPUT = 99;
        static final int SET_ACTIVE = 142;
        static final int SET_BACKGROUND_COLOR = 126;
        static final int SET_BIG_PLUGIN_VIEW = 407;
        static final int SET_CAN_CACHE_PAGE = 405;
        static final int SET_CARET = 401;
        static final int SET_GLOBAL_BOUNDS = 116;
        static final int SET_JS_FLAGS = 174;
        static final int SET_MOVE_FOCUS = 127;
        static final int SET_MOVE_MOUSE = 135;
        static final int SET_MOVE_MOUSE_IF_LATEST = 136;
        static final int SET_NETWORK_STATE = 119;
        static final int SET_NETWORK_TYPE = 183;
        static final int SET_SCROLL_OFFSET = 107;
        static final int SET_SELECTION = 113;
        static final int SET_WEBVIEW_ACTION = 149;
        static final int SINGLE_LISTBOX_CHOICE = 124;
        static final int SPLIT_PICTURE_SET = 133;
        static final int STOP_LOADING = 101;
        static final int STOP_SCROLL = 147;
        static final int SYNC_SCROLL = 131;
        static final int TOUCH_EVENT = 141;
        static final int TOUCH_UP = 140;
        static final int UPDATE_CACHE_AND_TEXT_ENTRY = 117;
        static final int UPDATE_FRAME_CACHE_IF_LOADING = 98;
        static final int USE_MOCK_DEVICE_ORIENTATION = 191;
        static final int VALID_NODE_BOUNDS = 146;
        static final int VIEW_SIZE_CHANGED = 105;
        static final int WEBKIT_DRAW = 130;
        static final int WEBKIT_DRAW_LAYERS = 148;
        private boolean mBlockMessages;
        private Handler mHandler;
        private ArrayList<Message> mMessages;
        private int mSavedPriority;
        private int mTid;

        private EventHub() {
            this.mMessages = new ArrayList<>();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void transferMessages() {
            this.mTid = Process.myTid();
            this.mSavedPriority = Process.getThreadPriority(this.mTid);
            this.mHandler = new Handler() { // from class: com.baidu.zeus.WebViewCore.EventHub.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    int indexOf;
                    switch (message.what) {
                        case EventHub.REQUEST_LABEL /* 97 */:
                            if (WebViewCore.this.mWebView != null) {
                                int i = message.arg2;
                                String nativeRequestLabel = WebViewCore.this.nativeRequestLabel(message.arg1, i);
                                if (nativeRequestLabel != null && nativeRequestLabel.length() > 0) {
                                    Message.obtain(WebViewCore.this.mWebView.mPrivateHandler, 125, i, 0, nativeRequestLabel).sendToTarget();
                                    return;
                                }
                                return;
                            }
                            return;
                        case EventHub.UPDATE_FRAME_CACHE_IF_LOADING /* 98 */:
                            WebViewCore.this.nativeUpdateFrameCacheIfLoading();
                            return;
                        case 99:
                            WebViewCore.this.nativeScrollFocusedTextInput(((Float) message.obj).floatValue(), message.arg1);
                            return;
                        case 100:
                            GetUrlData getUrlData = (GetUrlData) message.obj;
                            WebViewCore.this.loadUrl(getUrlData.mUrl, getUrlData.mExtraHeaders, getUrlData.mType);
                            return;
                        case 101:
                            if (WebViewCore.this.mBrowserFrame.committed() && !WebViewCore.this.mBrowserFrame.firstLayoutDone()) {
                                WebViewCore.this.mBrowserFrame.didFirstLayout();
                            }
                            WebViewCore.this.stopLoading();
                            return;
                        case 102:
                            WebViewCore.this.mBrowserFrame.reload(false);
                            return;
                        case 103:
                            WebViewCore.this.key((KeyEvent) message.obj, true);
                            return;
                        case 104:
                            WebViewCore.this.key((KeyEvent) message.obj, false);
                            return;
                        case 105:
                            WebView.ViewSizeData viewSizeData = (WebView.ViewSizeData) message.obj;
                            WebViewCore.this.viewSizeChanged(viewSizeData.mWidth, viewSizeData.mHeight, viewSizeData.mTextWrapWidth, viewSizeData.mScale, viewSizeData.mAnchorX, viewSizeData.mAnchorY, viewSizeData.mIgnoreHeight);
                            return;
                        case 106:
                            if (WebViewCore.this.mBrowserFrame.committed() || message.arg1 != -1 || WebViewCore.this.mBrowserFrame.loadType() != 0) {
                                WebViewCore.this.mBrowserFrame.goBackOrForward(message.arg1);
                                return;
                            } else {
                                WebViewCore.this.mBrowserFrame.reload(true);
                                return;
                            }
                        case 107:
                            Point point = (Point) message.obj;
                            WebViewCore.this.nativeSetScrollOffset(message.arg1, point.x, point.y);
                            return;
                        case EventHub.RESTORE_STATE /* 108 */:
                            WebViewCore.this.stopLoading();
                            WebViewCore.this.restoreState(message.arg1);
                            return;
                        case EventHub.PAUSE_TIMERS /* 109 */:
                            EventHub.this.mSavedPriority = Process.getThreadPriority(EventHub.this.mTid);
                            Process.setThreadPriority(EventHub.this.mTid, 10);
                            WebViewCore.pauseTimers();
                            if (JniUtil.useChromiumHttpStack()) {
                                WebViewCore.this.nativeCloseIdleConnections();
                                return;
                            } else {
                                WebViewWorker.getHandler().sendEmptyMessage(111);
                                return;
                            }
                        case 110:
                            Process.setThreadPriority(EventHub.this.mTid, EventHub.this.mSavedPriority);
                            WebViewCore.resumeTimers();
                            if (!JniUtil.useChromiumHttpStack()) {
                                WebViewWorker.getHandler().sendEmptyMessage(112);
                                return;
                            }
                            return;
                        case 111:
                            WebViewCore.this.clearCache(message.arg1 == 1);
                            return;
                        case 112:
                            WebViewCore.this.mCallbackProxy.getBackForwardList().close(WebViewCore.this.mBrowserFrame.mNativeFrame);
                            return;
                        case EventHub.SET_SELECTION /* 113 */:
                            WebViewCore.this.nativeSetSelection(message.arg1, message.arg2);
                            return;
                        case EventHub.REPLACE_TEXT /* 114 */:
                            ReplaceTextData replaceTextData = (ReplaceTextData) message.obj;
                            WebViewCore.this.nativeReplaceTextfieldText(message.arg1, message.arg2, replaceTextData.mReplace, replaceTextData.mNewStart, replaceTextData.mNewEnd, replaceTextData.mTextGeneration);
                            return;
                        case 115:
                            JSKeyData jSKeyData = (JSKeyData) message.obj;
                            KeyEvent keyEvent = jSKeyData.mEvent;
                            WebViewCore.this.passToJs(message.arg1, jSKeyData.mCurrentText, keyEvent.getKeyCode(), keyEvent.getUnicodeChar(), keyEvent.isDown(), keyEvent.isShiftPressed(), keyEvent.isAltPressed(), keyEvent.isSymPressed());
                            return;
                        case 116:
                            Rect rect = (Rect) message.obj;
                            WebViewCore.this.nativeSetGlobalBounds(rect.left, rect.top, rect.width(), rect.height());
                            return;
                        case 117:
                            WebViewCore.this.nativeUpdateFrameCache();
                            if (WebViewCore.this.mWebView != null) {
                                WebViewCore.this.mWebView.postInvalidate();
                            }
                            WebViewCore.this.sendUpdateTextEntry();
                            return;
                        case 118:
                            WebViewCore.this.nativeClick(message.arg1, message.arg2);
                            return;
                        case 119:
                            if (BrowserFrame.sJavaBridge == null) {
                                throw new IllegalStateException("No WebView has been created in this process!");
                            }
                            BrowserFrame.sJavaBridge.setNetworkOnLine(message.arg1 == 1);
                            return;
                        case 120:
                            Message message2 = (Message) message.obj;
                            message2.arg1 = WebViewCore.this.mBrowserFrame.documentHasImages() ? 1 : 0;
                            message2.sendToTarget();
                            return;
                        case 122:
                            TextSelectionData textSelectionData = (TextSelectionData) message.obj;
                            WebViewCore.this.nativeDeleteSelection(textSelectionData.mStart, textSelectionData.mEnd, message.arg1);
                            return;
                        case 123:
                            SparseBooleanArray sparseBooleanArray = (SparseBooleanArray) message.obj;
                            int i2 = message.arg1;
                            boolean[] zArr = new boolean[i2];
                            for (int i3 = 0; i3 < i2; i3++) {
                                zArr[i3] = sparseBooleanArray.get(i3);
                            }
                            WebViewCore.this.nativeSendListBoxChoices(zArr, i2);
                            return;
                        case 124:
                            WebViewCore.this.nativeSendListBoxChoice(message.arg1);
                            return;
                        case 125:
                            if (message.obj instanceof Message) {
                                ((Message) message.obj).sendToTarget();
                                return;
                            }
                            return;
                        case EventHub.SET_BACKGROUND_COLOR /* 126 */:
                            WebViewCore.this.nativeSetBackgroundColor(message.arg1);
                            return;
                        case EventHub.SET_MOVE_FOCUS /* 127 */:
                            CursorData cursorData = (CursorData) message.obj;
                            WebViewCore.this.nativeMoveFocus(cursorData.mFrame, cursorData.mNode);
                            return;
                        case 128:
                            WebViewCore.this.nativeSaveDocumentState(((CursorData) message.obj).mFrame);
                            return;
                        case EventHub.WEBKIT_DRAW /* 130 */:
                            WebViewCore.this.webkitDraw();
                            return;
                        case EventHub.SYNC_SCROLL /* 131 */:
                            WebViewCore.this.mWebkitScrollX = message.arg1;
                            WebViewCore.this.mWebkitScrollY = message.arg2;
                            return;
                        case EventHub.POST_URL /* 132 */:
                            PostUrlData postUrlData = (PostUrlData) message.obj;
                            WebViewCore.this.mBrowserFrame.postUrl(postUrlData.mUrl, postUrlData.mPostData);
                            return;
                        case EventHub.SPLIT_PICTURE_SET /* 133 */:
                            WebViewCore.this.nativeSplitContent();
                            WebViewCore.this.mSplitPictureIsScheduled = false;
                            return;
                        case EventHub.CLEAR_CONTENT /* 134 */:
                            WebViewCore.this.nativeClearContent();
                            if (WebViewCore.this.mWebView != null) {
                                WebViewCore.this.mWebView.postInvalidate();
                                return;
                            }
                            return;
                        case EventHub.SET_MOVE_MOUSE /* 135 */:
                            CursorData cursorData2 = (CursorData) message.obj;
                            WebViewCore.this.nativeMoveMouse(cursorData2.mFrame, cursorData2.mX, cursorData2.mY);
                            return;
                        case EventHub.SET_MOVE_MOUSE_IF_LATEST /* 136 */:
                            CursorData cursorData3 = (CursorData) message.obj;
                            WebViewCore.this.nativeMoveMouseIfLatest(cursorData3.mMoveGeneration, cursorData3.mFrame, cursorData3.mX, cursorData3.mY);
                            return;
                        case EventHub.REQUEST_CURSOR_HREF /* 137 */:
                            Message message3 = (Message) message.obj;
                            message3.getData().putString(SocialConstants.PARAM_URL, WebViewCore.this.nativeRetrieveHref(message.arg1, message.arg2));
                            message3.getData().putString("title", WebViewCore.this.nativeRetrieveAnchorText(message.arg1, message.arg2));
                            message3.sendToTarget();
                            return;
                        case EventHub.ADD_JS_INTERFACE /* 138 */:
                            JSInterfaceData jSInterfaceData = (JSInterfaceData) message.obj;
                            WebViewCore.this.mBrowserFrame.addJavascriptInterface(jSInterfaceData.mObject, jSInterfaceData.mInterfaceName);
                            return;
                        case EventHub.LOAD_DATA /* 139 */:
                            BaseUrlData baseUrlData = (BaseUrlData) message.obj;
                            String str = baseUrlData.mBaseUrl;
                            if (str != null && (indexOf = str.indexOf(58)) > 0) {
                                String substring = str.substring(0, indexOf);
                                if (!substring.startsWith("http") && !substring.startsWith("ftp") && !substring.startsWith("about") && !substring.startsWith("javascript")) {
                                    WebViewCore.this.nativeRegisterURLSchemeAsLocal(substring);
                                }
                            }
                            WebViewCore.this.mBrowserFrame.loadData(str, baseUrlData.mData, baseUrlData.mMimeType, baseUrlData.mEncoding, baseUrlData.mHistoryUrl);
                            return;
                        case EventHub.TOUCH_UP /* 140 */:
                            TouchUpData touchUpData = (TouchUpData) message.obj;
                            if (touchUpData.mNativeLayer != 0) {
                                WebViewCore.this.nativeScrollLayer(touchUpData.mNativeLayer, touchUpData.mNativeLayerRect);
                            }
                            WebViewCore.this.nativeTouchUp(touchUpData.mMoveGeneration, touchUpData.mFrame, touchUpData.mNode, touchUpData.mX, touchUpData.mY);
                            return;
                        case EventHub.TOUCH_EVENT /* 141 */:
                            TouchEventData touchEventData = (TouchEventData) message.obj;
                            Handler handler = WebViewCore.this.mWebView.mPrivateHandler;
                            int i4 = touchEventData.mAction;
                            int i5 = WebViewCore.this.nativeHandleTouchEvent(touchEventData.mAction, touchEventData.mX, touchEventData.mY, touchEventData.mMetaState) ? 1 : 0;
                            if (!touchEventData.mReprocess) {
                                touchEventData = null;
                            }
                            Message.obtain(handler, 115, i4, i5, touchEventData).sendToTarget();
                            return;
                        case EventHub.SET_ACTIVE /* 142 */:
                            WebViewCore.this.nativeSetFocusControllerActive(message.arg1 == 1);
                            return;
                        case EventHub.ON_PAUSE /* 143 */:
                            WebViewCore.this.nativePause();
                            return;
                        case EventHub.ON_RESUME /* 144 */:
                            WebViewCore.this.nativeResume();
                            return;
                        case EventHub.FREE_MEMORY /* 145 */:
                            WebViewCore.this.clearCache(false);
                            WebViewCore.this.nativeFreeMemory();
                            return;
                        case EventHub.VALID_NODE_BOUNDS /* 146 */:
                            MotionUpData motionUpData = (MotionUpData) message.obj;
                            if (!WebViewCore.this.nativeValidNodeAndBounds(motionUpData.mFrame, motionUpData.mNode, motionUpData.mBounds)) {
                                WebViewCore.this.nativeUpdateFrameCache();
                            }
                            WebViewCore.this.mWebView.mPrivateHandler.sendMessageAtFrontOfQueue(WebViewCore.this.mWebView.mPrivateHandler.obtainMessage(119, motionUpData.mX, motionUpData.mY, Boolean.valueOf(motionUpData.sendToCore)));
                            return;
                        case EventHub.STOP_SCROLL /* 147 */:
                            if (WebViewCore.this.mWebView != null) {
                                WebViewCore.this.mWebView.stopScroll();
                                return;
                            }
                            return;
                        case EventHub.WEBKIT_DRAW_LAYERS /* 148 */:
                            WebViewCore.this.webkitDrawLayers();
                            return;
                        case EventHub.SET_WEBVIEW_ACTION /* 149 */:
                            WebViewCore.this.nativeSetWebViewAction(message.arg1);
                            return;
                        case 150:
                            if (!JniUtil.useChromiumHttpStack()) {
                                Network.getInstance(WebViewCore.this.mContext).clearUserSslPrefTable();
                                return;
                            }
                            SslCertLookupTable.getInstance().clear();
                            WebViewCore.this.nativeCloseIdleConnections();
                            return;
                        case EventHub.REQUEST_EXT_REPRESENTATION /* 160 */:
                            WebViewCore.this.mBrowserFrame.externalRepresentation((Message) message.obj);
                            return;
                        case 161:
                            WebViewCore.this.mBrowserFrame.documentAsText((Message) message.obj);
                            return;
                        case EventHub.DUMP_DOMTREE /* 170 */:
                            WebViewCore.this.nativeDumpDomTree(message.arg1 == 1);
                            return;
                        case EventHub.DUMP_RENDERTREE /* 171 */:
                            WebViewCore.this.nativeDumpRenderTree(message.arg1 == 1);
                            return;
                        case EventHub.DUMP_NAVTREE /* 172 */:
                            WebViewCore.this.nativeDumpNavTree();
                            return;
                        case EventHub.DUMP_V8COUNTERS /* 173 */:
                            WebViewCore.this.nativeDumpV8Counters();
                            return;
                        case EventHub.SET_JS_FLAGS /* 174 */:
                            WebViewCore.this.nativeSetJsFlags((String) message.obj);
                            return;
                        case EventHub.GEOLOCATION_PERMISSIONS_PROVIDE /* 180 */:
                            GeolocationPermissionsData geolocationPermissionsData = (GeolocationPermissionsData) message.obj;
                            WebViewCore.this.nativeGeolocationPermissionsProvide(geolocationPermissionsData.mOrigin, geolocationPermissionsData.mAllow, geolocationPermissionsData.mRemember);
                            return;
                        case EventHub.POPULATE_VISITED_LINKS /* 181 */:
                            WebViewCore.this.nativeProvideVisitedHistory((String[]) message.obj);
                            return;
                        case EventHub.HIDE_FULLSCREEN /* 182 */:
                            WebViewCore.this.nativeFullScreenPluginHidden(message.arg1);
                            return;
                        case EventHub.SET_NETWORK_TYPE /* 183 */:
                            if (BrowserFrame.sJavaBridge == null) {
                                throw new IllegalStateException("No WebView has been created in this process!");
                            }
                            Map map = (Map) message.obj;
                            BrowserFrame.sJavaBridge.setNetworkType((String) map.get("type"), (String) map.get("subtype"));
                            return;
                        case EventHub.ADD_PACKAGE_NAMES /* 184 */:
                            if (BrowserFrame.sJavaBridge == null) {
                                throw new IllegalStateException("No WebView has been created in this process!");
                            }
                            BrowserFrame.sJavaBridge.addPackageNames((Set) message.obj);
                            return;
                        case EventHub.ADD_PACKAGE_NAME /* 185 */:
                            if (BrowserFrame.sJavaBridge == null) {
                                throw new IllegalStateException("No WebView has been created in this process!");
                            }
                            BrowserFrame.sJavaBridge.addPackageName((String) message.obj);
                            return;
                        case EventHub.REMOVE_PACKAGE_NAME /* 186 */:
                            if (BrowserFrame.sJavaBridge == null) {
                                throw new IllegalStateException("No WebView has been created in this process!");
                            }
                            BrowserFrame.sJavaBridge.removePackageName((String) message.obj);
                            return;
                        case EventHub.CLEAR_FOCUS /* 187 */:
                            WebViewCore.this.nativeClearFocus();
                            return;
                        case EventHub.CORE_INVALIDATE /* 188 */:
                            Rect rect2 = (Rect) message.obj;
                            if (rect2 != null) {
                                WebViewCore.this.nativeCoreInvalidate(rect2.left, rect2.top, rect2.width(), rect2.height());
                                return;
                            }
                            return;
                        case EventHub.CORE_SEND_CAPTURE_SCALE_PIC /* 189 */:
                            if (WebViewCore.this.mWebView != null) {
                                if (WebViewCore.this.mWebView.mPrivateHandler.hasMessages(EventHub.POST_URL)) {
                                    WebViewCore.this.mWebView.mPrivateHandler.removeMessages(EventHub.POST_URL);
                                }
                                Message.obtain(WebViewCore.this.mWebView.mPrivateHandler, (int) EventHub.POST_URL).sendToTarget();
                                return;
                            }
                            return;
                        case EventHub.USE_MOCK_DEVICE_ORIENTATION /* 191 */:
                            WebViewCore.this.useMockDeviceOrientation();
                            return;
                        case EventHub.NOTIFICATION_EVENT_DISPATCH /* 198 */:
                            WebViewCore.this.nativeNotificationEventDispatch(message.arg1, message.arg2);
                            return;
                        case 200:
                            synchronized (WebViewCore.this) {
                                WebViewCore.this.mBrowserFrame.destroy();
                                WebViewCore.this.mBrowserFrame = null;
                                WebViewCore.this.mSettings.onDestroyed();
                                WebViewCore.this.mNativeClass = 0;
                                WebViewCore.this.mWebView = null;
                            }
                            return;
                        case EventHub.DESTROY_PLUGINVIEW /* 300 */:
                            synchronized (WebViewCore.this) {
                                WebViewCore.this.destroyPluginView();
                            }
                            return;
                        case EventHub.GET_TOUCH_HIGHLIGHT_RECTS /* 301 */:
                            TouchHighlightData touchHighlightData = (TouchHighlightData) message.obj;
                            if (touchHighlightData.mNativeLayer != 0) {
                                WebViewCore.this.nativeScrollLayer(touchHighlightData.mNativeLayer, touchHighlightData.mNativeLayerRect);
                                return;
                            }
                            return;
                        case EventHub.EXIT_FULLSCREEN_MODE /* 302 */:
                            WebViewCore.this.mBrowserFrame.exitFullScreenMode();
                            return;
                        case 400:
                            Message.obtain(WebViewCore.this.mWebView.mPrivateHandler, EventHub.WEBKIT_DRAW, (String) message.obj).sendToTarget();
                            return;
                        case 401:
                            WebViewCore.this.nativeSetCaretVisible(message.arg1 == 1);
                            return;
                        case EventHub.LONG_PRESS /* 402 */:
                            int i6 = message.arg1;
                            int i7 = message.arg2;
                            Log.e(WebViewCore.LOGTAG, "LONG_PRESS " + i6 + " " + i7);
                            if (WebViewCore.this.mWebView != null) {
                                boolean nativeHitTextNode = WebViewCore.this.mWebView.nativeHitTextNode(i6, i7);
                                Log.e(WebViewCore.LOGTAG, "LONG_PRESS hit text: " + nativeHitTextNode);
                                Message.obtain(WebViewCore.this.mWebView.mPrivateHandler, EventHub.SET_MOVE_MOUSE_IF_LATEST, nativeHitTextNode ? 1 : 0, 0).sendToTarget();
                                return;
                            }
                            return;
                        case 403:
                            String nativeGetSelection = WebViewCore.this.nativeGetSelection((Region) message.obj);
                            if (WebViewCore.this.mWebView != null) {
                                Message.obtain(WebViewCore.this.mWebView.mPrivateHandler, EventHub.REQUEST_CURSOR_HREF, nativeGetSelection).sendToTarget();
                                return;
                            }
                            return;
                        case 404:
                            EngWordData engWordData = (EngWordData) message.obj;
                            if (engWordData != null) {
                                Rect nativeEngWordSelection = WebViewCore.this.nativeEngWordSelection(engWordData.x, engWordData.y, engWordData.picture, engWordData.left, engWordData.top, engWordData.right, engWordData.bottom);
                                if (WebViewCore.this.mWebView != null) {
                                    Message.obtain(WebViewCore.this.mWebView.mPrivateHandler, EventHub.LOAD_DATA, nativeEngWordSelection).sendToTarget();
                                    return;
                                }
                                return;
                            }
                            return;
                        case 405:
                            WebViewCore.this.nativeSetCanCachePage(((Boolean) message.obj).booleanValue());
                            return;
                        case 407:
                            WebViewCore.this.nativeSetBigPluginView();
                            return;
                        case 408:
                            String nativeGetSubjectContent = WebViewCore.this.nativeGetSubjectContent(message.arg1);
                            Log.e(WebViewCore.LOGTAG, "content:" + nativeGetSubjectContent);
                            Message.obtain(WebViewCore.this.mWebView.mPrivateHandler, EventHub.SET_ACTIVE, nativeGetSubjectContent).sendToTarget();
                            return;
                        case 409:
                            WebViewCore.this.makeNativeElementExitFullScreen(message.arg1);
                            return;
                        case 500:
                            WebViewCore.this.nativePluginSurfaceReady();
                            return;
                        case 501:
                            WebViewCore.this.nativePageVisibilityChange(message.arg1, message.arg2 != 0);
                            return;
                        case 502:
                            DoubleTapScaleData doubleTapScaleData = (DoubleTapScaleData) message.obj;
                            WebViewCore.this.showBlockRect(WebViewCore.this.nativeDoubleTapMaxBounds(doubleTapScaleData.mScreenWidth, doubleTapScaleData.mAnchorX, doubleTapScaleData.mAnchorY, doubleTapScaleData.mNode), doubleTapScaleData.mScreenWidth, doubleTapScaleData.mAnchorX, doubleTapScaleData.mAnchorY);
                            return;
                        case 503:
                            WebViewCore.this.nativePauseMedia(0);
                            return;
                        case 504:
                            WebViewCore.this.nativeResumeMedia(0);
                            return;
                        default:
                            return;
                    }
                }
            };
            synchronized (this) {
                int size = this.mMessages.size();
                for (int i = 0; i < size; i++) {
                    this.mHandler.sendMessage(this.mMessages.get(i));
                }
                this.mMessages = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void sendMessage(Message message) {
            if (!this.mBlockMessages) {
                if (this.mMessages != null) {
                    this.mMessages.add(message);
                } else {
                    this.mHandler.sendMessage(message);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void removeMessages(int i) {
            if (!this.mBlockMessages) {
                if (i == WEBKIT_DRAW) {
                    WebViewCore.this.mDrawIsScheduled = false;
                }
                if (this.mMessages != null) {
                    Log.w(WebViewCore.LOGTAG, "Not supported in this case.");
                } else {
                    this.mHandler.removeMessages(i);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized boolean hasMessages(int i) {
            boolean z = false;
            synchronized (this) {
                if (!this.mBlockMessages) {
                    if (this.mMessages != null) {
                        Log.w(WebViewCore.LOGTAG, "hasMessages() is not supported in this case.");
                    } else {
                        z = this.mHandler.hasMessages(i);
                    }
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void sendMessageDelayed(Message message, long j) {
            if (!this.mBlockMessages) {
                this.mHandler.sendMessageDelayed(message, j);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void sendMessageAtFrontOfQueue(Message message) {
            if (!this.mBlockMessages) {
                if (this.mMessages != null) {
                    this.mMessages.add(0, message);
                } else {
                    this.mHandler.sendMessageAtFrontOfQueue(message);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void removeMessages() {
            WebViewCore.this.mDrawIsScheduled = false;
            WebViewCore.this.mSplitPictureIsScheduled = false;
            if (this.mMessages != null) {
                this.mMessages.clear();
            } else {
                this.mHandler.removeCallbacksAndMessages(null);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void blockMessages() {
            this.mBlockMessages = true;
        }
    }

    void stopLoading() {
        if (this.mBrowserFrame != null) {
            this.mBrowserFrame.stopLoading();
        }
    }

    void sendMessage(Message message) {
        this.mEventHub.sendMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void sendMessage(int i) {
        this.mEventHub.sendMessage(Message.obtain((Handler) null, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void sendMessage(int i, Object obj) {
        this.mEventHub.sendMessage(Message.obtain(null, i, obj));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void sendMessage(int i, int i2) {
        this.mEventHub.sendMessage(Message.obtain(null, i, i2, 0));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void sendMessage(int i, int i2, int i3) {
        this.mEventHub.sendMessage(Message.obtain(null, i, i2, i3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void sendMessage(int i, int i2, Object obj) {
        this.mEventHub.sendMessage(Message.obtain(null, i, i2, 0, obj));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void sendMessage(int i, int i2, int i3, Object obj) {
        this.mEventHub.sendMessage(Message.obtain(null, i, i2, i3, obj));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void sendMessageAtFrontOfQueue(int i, Object obj) {
        this.mEventHub.sendMessageAtFrontOfQueue(Message.obtain(null, i, obj));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void sendMessageDelayed(int i, Object obj, long j) {
        this.mEventHub.sendMessageDelayed(Message.obtain(null, i, obj), j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeMessages(int i) {
        this.mEventHub.removeMessages(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeMessages() {
        this.mEventHub.removeMessages();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void destroy() {
        synchronized (this.mEventHub) {
            boolean hasMessages = this.mEventHub.hasMessages(SocialAPIErrorCodes.ERROR_MISS_ACCESS_TOKEN);
            boolean hasMessages2 = this.mEventHub.hasMessages(109);
            this.mEventHub.removeMessages();
            this.mEventHub.sendMessageAtFrontOfQueue(Message.obtain((Handler) null, (int) BdWebPoolView.DELAYED_TIME));
            if (hasMessages2) {
                this.mEventHub.sendMessageAtFrontOfQueue(Message.obtain((Handler) null, 109));
            }
            if (hasMessages) {
                this.mEventHub.sendMessageAtFrontOfQueue(Message.obtain((Handler) null, (int) SocialAPIErrorCodes.ERROR_MISS_ACCESS_TOKEN));
            }
            this.mEventHub.blockMessages();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCache(boolean z) {
        this.mBrowserFrame.clearCache();
        if (z) {
            CacheManager.removeAllCacheFiles();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadUrl(String str, Map<String, String> map, WebView.PageType pageType) {
        this.mBrowserFrame.setPageType(pageType);
        this.mBrowserFrame.loadUrl(str, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void key(KeyEvent keyEvent, boolean z) {
        boolean z2;
        int keyCode = keyEvent.getKeyCode();
        int unicodeChar = keyEvent.getUnicodeChar();
        if (keyCode == 0 && keyEvent.getCharacters() != null && keyEvent.getCharacters().length() > 0) {
            z2 = !nativeKeyString(keyCode, keyEvent.getCharacters(), keyEvent.getRepeatCount(), keyEvent.isShiftPressed(), keyEvent.isAltPressed(), keyEvent.isSymPressed(), z);
        } else {
            z2 = nativeKey(keyCode, unicodeChar, keyEvent.getRepeatCount(), keyEvent.isShiftPressed(), keyEvent.isAltPressed(), keyEvent.isSymPressed(), z) ? false : true;
        }
        if (z2 && keyCode != 66) {
            if (keyCode >= 19 && keyCode <= 22) {
                if (this.mWebView != null && keyEvent.isDown()) {
                    Message.obtain(this.mWebView.mPrivateHandler, SocialAPIErrorCodes.ERROR_MISS_ACCESS_TOKEN, Integer.valueOf(keyCode)).sendToTarget();
                    return;
                }
                return;
            }
            this.mCallbackProxy.onUnhandledKeyEvent(keyEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void viewSizeChanged(int i, int i2, int i3, float f, int i4, int i5, boolean z) {
        int i6;
        if (i != 0) {
            if (!this.mSettings.getUseWideViewPort()) {
                i6 = i;
            } else if (this.mViewportWidth == -1) {
                if (this.mSettings.getLayoutAlgorithm() == WebSettings.LayoutAlgorithm.NORMAL) {
                    i6 = DEFAULT_VIEWPORT_WIDTH;
                } else {
                    i6 = Math.min(WebView.sMaxViewportWidth, Math.max(i, Math.max((int) DEFAULT_VIEWPORT_WIDTH, nativeGetContentMinPrefWidth())));
                }
            } else {
                i6 = this.mViewportWidth > 0 ? Math.max(i, this.mViewportWidth) : i3;
            }
            nativeSetSize(i6, i6 == i ? i2 : Math.round((i6 * i2) / i), i3, f, i, i2, i4, i5, z);
            boolean z2 = this.mCurrentViewWidth == 0;
            this.mCurrentViewWidth = i;
            this.mCurrentViewHeight = i2;
            this.mCurrentViewScale = f;
            if (z2) {
                contentDraw();
            }
            this.mEventHub.sendMessage(Message.obtain((Handler) null, (int) SocialAPIErrorCodes.ERROR_INVALID_MEDIA_TYPE));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendUpdateTextEntry() {
        if (this.mWebView != null) {
            Message.obtain(this.mWebView.mPrivateHandler, (int) SocialAPIErrorCodes.ERROR_INVALID_SIGNATURE_ALGORITHM).sendToTarget();
        }
    }

    private long getUsedQuota() {
        long j = 0;
        Collection<WebStorage.Origin> originsSync = WebStorage.getInstance().getOriginsSync();
        if (originsSync == null) {
            return 0L;
        }
        Iterator<WebStorage.Origin> it = originsSync.iterator();
        while (true) {
            long j2 = j;
            if (!it.hasNext()) {
                return j2;
            }
            j = j2 + it.next().getQuota();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class RestoreState {
        float mDefaultScale;
        float mMaxScale;
        float mMinScale;
        boolean mMobileSite;
        int mScrollX;
        int mScrollY;
        float mTextWrapScale;
        float mViewScale;

        RestoreState() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class DrawData {
        boolean mFocusSizeChanged;
        int mMinPrefWidth;
        RestoreState mRestoreState;
        boolean mUpdateViewPort;
        Point mViewPoint;
        int mBaseLayer = 0;
        Region mInvalRegion = new Region();
        Point mWidthHeight = new Point();

        DrawData() {
        }
    }

    public void layersDraw() {
        synchronized (this) {
            if (!this.mDrawLayersIsScheduled) {
                this.mDrawLayersIsScheduled = true;
                this.mEventHub.sendMessage(Message.obtain((Handler) null, 148));
            }
        }
    }

    public static int GetNetworkUpload() {
        return nativeGetNetworkUpload();
    }

    public static int GetNetworkVolume() {
        return nativeGetNetworkVolume();
    }

    public static int GetNetworkDownload() {
        return nativeGetNetworkDownload();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void webkitDrawLayers() {
        this.mDrawLayersIsScheduled = false;
        if (this.mDrawIsScheduled || this.mLastDrawData == null) {
            removeMessages(130);
            webkitDraw();
            return;
        }
        if (nativeUpdateLayers(this.mLastDrawData.mBaseLayer)) {
            webkitDraw();
        }
        this.mWebView.mPrivateHandler.removeMessages(SocialAPIErrorCodes.ERROR_INVALID_MEDIA_TYPE);
        this.mWebView.mPrivateHandler.sendMessageAtFrontOfQueue(this.mWebView.mPrivateHandler.obtainMessage(SocialAPIErrorCodes.ERROR_INVALID_MEDIA_TYPE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void webkitDraw() {
        int i;
        if (!this.mSuspendWebView) {
            sendSubjectRectsToWebView();
            this.mDrawIsScheduled = false;
            DrawData drawData = new DrawData();
            drawData.mBaseLayer = nativeRecordContent(drawData.mInvalRegion, drawData.mWidthHeight);
            if (drawData.mBaseLayer == 0) {
            }
            if (this.mWebView != null) {
                drawData.mFocusSizeChanged = nativeFocusBoundsChanged();
                drawData.mViewPoint = new Point(this.mCurrentViewWidth, this.mCurrentViewHeight);
                if (this.mSettings.getUseWideViewPort()) {
                    if (this.mViewportWidth == -1) {
                        i = DEFAULT_VIEWPORT_WIDTH;
                    } else {
                        i = this.mViewportWidth == 0 ? this.mCurrentViewWidth : this.mViewportWidth;
                    }
                    drawData.mMinPrefWidth = Math.max(i, nativeGetContentMinPrefWidth());
                }
                if (this.mRestoreState != null) {
                    drawData.mRestoreState = this.mRestoreState;
                    this.mRestoreState = null;
                }
                drawData.mUpdateViewPort = this.mUpdateViewPort;
                this.mUpdateViewPort = false;
                Message.obtain(this.mWebView.mPrivateHandler, 105, drawData).sendToTarget();
                if (this.mWebkitScrollX != 0 || this.mWebkitScrollY != 0) {
                    Message.obtain(this.mWebView.mPrivateHandler, 104, this.mWebkitScrollX, this.mWebkitScrollY).sendToTarget();
                    this.mWebkitScrollY = 0;
                    this.mWebkitScrollX = 0;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean SetCanvasWidthHeight(int i, int i2, int i3) {
        return nativeSetCanvasWidthHeight(i, i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean HasGPU() {
        return nativeHasGPU();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean SetViewWidthHeight(int i, int i2) {
        return nativeSetViewWidthHeight(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean SetSubjectBitmap(int i, int i2, int i3) {
        return nativeSetSubjectBitmap(i, i2, i3);
    }

    void cleanNativeBitmap() {
        nativeCleanBitmap();
    }

    void destroyPluginView() {
        nativeDestroyPluginView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void emulateDrawContentPicture(Canvas canvas, int i, boolean z, boolean z2, Bitmap bitmap, float f, float f2, float f3, float f4, float f5, int i2, int i3, int i4, boolean z3, boolean z4) {
        nativeEmulateDrawContent(f, f2, f3, f4, f5, i2, i3, i4, false, z3, z4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void drawContentPicture(Canvas canvas, int i, boolean z, boolean z2, Bitmap bitmap, float f, float f2, float f3, float f4, float f5, int i2, int i3, int i4, boolean z3, boolean z4) {
        if (z) {
            DrawFilter drawFilter = this.mZoomFilter;
        } else if (z2) {
            DrawFilter drawFilter2 = this.mScrollFilter;
        }
        if (canvas != null) {
            canvas.setDrawFilter(this.mScrollFilter);
        }
        boolean nativeDrawContent = nativeDrawContent(canvas, bitmap, i, f, f2, f3, f4, f5, i2, i3, i4, z3, this.mWebView.mDragging, z4);
        if (canvas != null) {
            canvas.setDrawFilter(null);
        }
        if (nativeDrawContent && !this.mSplitPictureIsScheduled) {
            this.mSplitPictureIsScheduled = true;
            sendMessage(133);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void SplitContent() {
        this.mSplitPictureIsScheduled = true;
        nativeSplitContent();
        this.mSplitPictureIsScheduled = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void drawContentPictureInScale(Canvas canvas, int i, boolean z, boolean z2, Bitmap bitmap, float f, float f2, float f3, float f4, float f5, int i2, int i3, int i4, boolean z3, boolean z4) {
        nativeDrawContentInScale(canvas, bitmap, i, f, f2, f3, f4, f5, i2, i3, i4, z3, z4);
    }

    Bitmap getCanvasBitmap(ByteBuffer byteBuffer, boolean z) {
        return nativeGetCanvasBitmap(byteBuffer, z);
    }

    void CanvasDrawBitmap(Canvas canvas, Bitmap bitmap) {
        nativeCanvasDrawBitmap(canvas, bitmap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean pictureReady() {
        return this.mNativeClass != 0 ? nativePictureReady() : false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Picture copyContentPicture(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        if (this.mNativeClass != 0 && i4 != 0) {
            nativeCopyContentToPicture(i, i2, i3, i4, i5, i6, i7, i / i4);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void reducePriority() {
        sWebCoreHandler.removeMessages(1);
        sWebCoreHandler.removeMessages(2);
        sWebCoreHandler.sendMessageAtFrontOfQueue(sWebCoreHandler.obtainMessage(1));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void resumePriority() {
        sWebCoreHandler.removeMessages(1);
        sWebCoreHandler.removeMessages(2);
        sWebCoreHandler.sendMessageAtFrontOfQueue(sWebCoreHandler.obtainMessage(2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void sendStaticMessage(int i, Object obj) {
        if (sWebCoreHandler != null) {
            sWebCoreHandler.sendMessage(sWebCoreHandler.obtainMessage(i, obj));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void pauseUpdatePicture(WebViewCore webViewCore) {
        if (webViewCore != null && webViewCore.mWebView.getWebViewType() != WebView.WebViewType.BIGPLUGIN) {
            synchronized (webViewCore) {
                webViewCore.nativeSetDirtyRgnEmpty();
                webViewCore.mDrawIsPaused = true;
                if (webViewCore.mDrawIsScheduled) {
                    webViewCore.mEventHub.removeMessages(130);
                }
            }
        }
    }

    public void setForceResumeUpdatePicture(boolean z) {
        this.m_ForceResumeUpdatePic = z;
    }

    public boolean shouldForceResumeUpdatePicture() {
        return this.m_ForceResumeUpdatePic;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void resumeUpdatePicture(WebViewCore webViewCore) {
        if (webViewCore != null) {
            synchronized (webViewCore) {
                webViewCore.mDrawIsPaused = false;
                if (webViewCore.mDrawIsScheduled) {
                    webViewCore.mDrawIsScheduled = false;
                    webViewCore.contentDraw();
                } else if (webViewCore.shouldForceResumeUpdatePicture()) {
                    webViewCore.setForceResumeUpdatePicture(false);
                    webViewCore.mDrawIsScheduled = false;
                    webViewCore.contentDraw();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void restoreState(int i) {
        WebBackForwardList backForwardList = this.mCallbackProxy.getBackForwardList();
        int size = backForwardList.getSize();
        for (int i2 = 0; i2 < size; i2++) {
            backForwardList.getItemAtIndex(i2).inflate(this.mBrowserFrame.mNativeFrame);
        }
        this.mBrowserFrame.mLoadInitFromJava = true;
        WebBackForwardList.restoreIndex(this.mBrowserFrame.mNativeFrame, i);
        this.mBrowserFrame.mLoadInitFromJava = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void contentDraw() {
        if (this.mCurrentViewWidth != 0 && this.mBrowserFrame != null && this.mBrowserFrame.firstLayoutDone()) {
            synchronized (this) {
                if (!this.mDrawIsScheduled) {
                    this.mDrawIsScheduled = true;
                    if (!this.mDrawIsPaused) {
                        this.mEventHub.sendMessage(Message.obtain((Handler) null, 130));
                    }
                }
            }
        }
    }

    void forceContentDraw() {
        if (this.mCurrentViewWidth != 0 && this.mBrowserFrame != null) {
            synchronized (this) {
                if (!this.mDrawIsScheduled) {
                    this.mDrawIsScheduled = true;
                    if (!this.mDrawIsPaused) {
                        this.mEventHub.sendMessage(Message.obtain((Handler) null, 130));
                    }
                }
            }
        }
    }

    void sendCoreInvalidate(int i, int i2, int i3, int i4) {
        if (this.mEventHub != null) {
            this.mEventHub.sendMessage(Message.obtain(null, 188, new Rect(i, i2, i3, i4)));
        }
    }

    void firstLayout() {
        this.mEventHub.sendMessage(Message.obtain((Handler) null, (int) BdWebErrorView.ERROR_CODE_400));
    }

    private void stopScroll() {
        this.mWebView.stopScroll();
    }

    public void addPlugin() {
        Message.obtain(this.mWebView.mPrivateHandler, 143).sendToTarget();
    }

    private void contentScrollBy(int i, int i2, boolean z) {
        if (this.mBrowserFrame.firstLayoutDone() && this.mWebView != null) {
            Message obtain = Message.obtain(this.mWebView.mPrivateHandler, 102, i, i2, new Boolean(z));
            if (this.mDrawIsScheduled) {
                this.mEventHub.sendMessage(Message.obtain(null, SocialAPIErrorCodes.ERROR_INVALID_UPLOAD_FILE, obtain));
            } else {
                obtain.sendToTarget();
            }
        }
    }

    private void contentScrollTo(int i, int i2) {
        if (!this.mBrowserFrame.firstLayoutDone()) {
            this.mRestoredX = i;
            this.mRestoredY = i2;
        } else if (this.mWebView != null) {
            this.mWebkitScrollY = 0;
            this.mWebkitScrollX = 0;
            Message obtain = Message.obtain(this.mWebView.mPrivateHandler, 101, i, i2);
            if (this.mDrawIsScheduled) {
                this.mEventHub.sendMessage(Message.obtain(null, SocialAPIErrorCodes.ERROR_INVALID_UPLOAD_FILE, obtain));
            } else {
                obtain.sendToTarget();
            }
        }
    }

    private void contentSpawnScrollTo(int i, int i2) {
        if (!this.mBrowserFrame.firstLayoutDone()) {
            this.mRestoredX = i;
            this.mRestoredY = i2;
        } else if (this.mWebView != null) {
            Message obtain = Message.obtain(this.mWebView.mPrivateHandler, 103, i, i2);
            if (this.mDrawIsScheduled) {
                this.mEventHub.sendMessage(Message.obtain(null, SocialAPIErrorCodes.ERROR_INVALID_UPLOAD_FILE, obtain));
            } else {
                obtain.sendToTarget();
            }
        }
    }

    private void sendNotifyProgressFinished() {
        sendUpdateTextEntry();
        if (!JniUtil.useChromiumHttpStack()) {
            WebViewWorker.getHandler().sendEmptyMessage(113);
            WebViewWorker.getHandler().removeMessages(SocialAPIErrorCodes.ERROR_MISS_ACCESS_TOKEN);
            WebViewWorker.getHandler().sendEmptyMessage(SocialAPIErrorCodes.ERROR_MISS_ACCESS_TOKEN);
        }
        contentDraw();
    }

    private void sendViewInvalidate(int i, int i2, int i3, int i4) {
        if (this.mWebView != null) {
            Message.obtain(this.mWebView.mPrivateHandler, SocialAPIErrorCodes.ERROR_INVALID_MEDIA_TYPE, new Rect(i, i2, i3, i4)).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void signalRepaintDone() {
        mRepaintScheduled = false;
    }

    private void sendImmediateRepaint() {
        if (this.mWebView != null && !mRepaintScheduled) {
            mRepaintScheduled = true;
            Message.obtain(this.mWebView.mPrivateHandler, (int) SocialAPIErrorCodes.ERROR_INVALID_BDUSS).sendToTarget();
        }
    }

    private void sendCaptureScalePic() {
        if (this.mEventHub != null) {
            this.mEventHub.sendMessage(Message.obtain((Handler) null, 189));
        }
    }

    public void initialLastSubjectRectSize() {
        if (this.mSubjectRectsWebCore == null) {
            this.mSubjectRectsWebCore = new ArrayList<>();
        }
        this.mSubjectRectsWebCore.clear();
        nativeClearLastSubjectRects();
    }

    private int getJavaSubjectCount() {
        return this.mSubjectRectsWebCore.size();
    }

    public Rect getJavaSubjectRect(int i) {
        return this.mSubjectRectsWebCore.get(i);
    }

    private void sendSubjectRectsToWebView() {
        if (nativeCheckIfNeedUpdateSubjectRects()) {
            if (this.mSubjectRectsWebCore == null) {
                this.mSubjectRectsWebCore = new ArrayList<>();
            }
            int nativeGetLastSubjectCount = nativeGetLastSubjectCount();
            if (nativeGetLastSubjectCount != getJavaSubjectCount()) {
                this.mSubjectRectsWebCore.clear();
                for (int i = 0; i < nativeGetLastSubjectCount; i++) {
                    nativeSetSubjectRectToJava(i);
                    this.mSubjectRectsWebCore.add(new Rect(this.mLastSubjectRectLeft, this.mLastSubjectRectTop, this.mLastSubjectRectRight, this.mLastSubjectRectBottom));
                }
            } else {
                for (int i2 = 0; i2 < nativeGetLastSubjectCount; i2++) {
                    nativeSetSubjectRectToJava(i2);
                    this.mSubjectRectsWebCore.get(i2).set(this.mLastSubjectRectLeft, this.mLastSubjectRectTop, this.mLastSubjectRectRight, this.mLastSubjectRectBottom);
                }
            }
            if (this.mWebView != null) {
                if (this.mWebView.mPrivateHandler.hasMessages(146)) {
                    this.mWebView.mPrivateHandler.removeMessages(146);
                }
                Message.obtain(this.mWebView.mPrivateHandler, 146, this.mSubjectRectsWebCore).sendToTarget();
            }
        }
    }

    private void setRootLayer(int i) {
        if (this.mWebView != null) {
            Message.obtain(this.mWebView.mPrivateHandler, SocialAPIErrorCodes.ERROR_UPLOAD_FILE_SIZE_TOO_LARGE, i, 0).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebView getWebView() {
        return this.mWebView;
    }

    private void didFirstLayout(boolean z) {
        this.mBrowserFrame.didFirstLayout();
        if (this.mWebView != null) {
            boolean z2 = z || this.mRestoredScale > 0;
            setupViewport(z2);
            if (!z2) {
                this.mWebView.mViewManager.postReadyToDrawAll();
            }
            this.mRestoredScreenWidthScale = 0;
            this.mRestoredScale = 0;
            this.mRestoredY = 0;
            this.mRestoredX = 0;
            this.mWebkitScrollY = 0;
            this.mWebkitScrollX = 0;
            if (getSettings().supportTouchOnly()) {
                this.mWebView.mPrivateHandler.sendEmptyMessage(ZOOM_BITS);
            }
        }
    }

    private void didFirstPaint(String str) {
        this.mEventHub.sendMessage(Message.obtain(null, BdWebErrorView.ERROR_CODE_400, str));
    }

    private void notifyFrameworkPlayMedia(String str) {
        this.mCallbackProxy.onPlayVideo(str);
    }

    private void notifyFrameworkDownLoadFlash(String str) {
        this.mCallbackProxy.onDownLoadFlash(str);
    }

    private void updateViewport() {
        if (this.mBrowserFrame.firstLayoutDone()) {
            setupViewport(true);
        }
    }

    public float getViewportDensityFromJava() {
        return WebView.DEFAULT_SCALE_PERCENT / 100.0f;
    }

    private boolean checkViewportSettingsForMobileSite() {
        if (this.mSiteTypeWebCore == 1) {
            return true;
        }
        return this.mSiteTypeWebCore == -1 && this.mViewportWidth == 0;
    }

    public boolean isMobileSiteWebCore() {
        return this.mIsMobileSiteWebCore;
    }

    private void guessIsMobileSiteZeus() {
        this.mIsMobileSiteWebCore = checkViewportSettingsForMobileSite();
        if (this.mWebView != null) {
            Message.obtain(this.mWebView.mPrivateHandler, 144, new Boolean(this.mIsMobileSiteWebCore)).sendToTarget();
        }
    }

    private void forcePageCanScale(int i) {
        if (getSettings().getIsForcePageCanBeScaled()) {
            if (this.mViewportMaximumScale < this.mViewportMinimumScale * 2) {
                this.mViewportMaximumScale = this.mViewportMinimumScale * 2;
            }
            if (this.mViewportWidth == 0 && this.mViewportMinimumScale == 0) {
                this.mViewportMaximumScale = i * 2;
            }
        }
    }

    private void setupViewport(boolean z) {
        int i;
        int round;
        boolean z2;
        int round2;
        float f;
        setViewportSettingsFromNative();
        guessIsMobileSiteZeus();
        this.mUpdateViewPort = true;
        float f2 = 1.0f;
        if (this.mViewportDensityDpi == -1) {
            if (WebView.DEFAULT_SCALE_PERCENT != 100) {
                f2 = WebView.DEFAULT_SCALE_PERCENT / 100.0f;
            }
        } else if (this.mViewportDensityDpi > 0) {
            f2 = this.mContext.getResources().getDisplayMetrics().densityDpi / this.mViewportDensityDpi;
        }
        int i2 = (int) (f2 * 100.0f);
        if (this.mViewportInitialScale > 0) {
            this.mViewportInitialScale = (int) (this.mViewportInitialScale * f2);
        }
        if (this.mViewportMinimumScale > 0) {
            this.mViewportMinimumScale = (int) (this.mViewportMinimumScale * f2);
        }
        if (this.mViewportMaximumScale > 0) {
            this.mViewportMaximumScale = (int) (this.mViewportMaximumScale * f2);
        }
        if (this.mViewportWidth == 0 && this.mViewportInitialScale == 0) {
            this.mViewportInitialScale = i2;
        }
        if (!this.mViewportUserScalable) {
            this.mViewportInitialScale = i2;
            this.mViewportMinimumScale = i2;
            this.mViewportMaximumScale = i2;
        }
        if (this.mViewportMinimumScale > this.mViewportInitialScale && this.mViewportInitialScale != 0) {
            this.mViewportMinimumScale = this.mViewportInitialScale;
        }
        if (this.mViewportMaximumScale > 0 && this.mViewportMaximumScale < this.mViewportInitialScale) {
            this.mViewportMaximumScale = this.mViewportInitialScale;
        }
        if (this.mViewportWidth < 0 && this.mViewportInitialScale == i2) {
            this.mViewportWidth = 0;
        }
        forcePageCanScale(i2);
        if (this.mViewportWidth != 0 && !z) {
            RestoreState restoreState = new RestoreState();
            restoreState.mMinScale = this.mViewportMinimumScale / 100.0f;
            restoreState.mMaxScale = this.mViewportMaximumScale / 100.0f;
            restoreState.mDefaultScale = f2;
            restoreState.mMobileSite = false;
            restoreState.mScrollX = 0;
            Message.obtain(this.mWebView.mPrivateHandler, 109, restoreState).sendToTarget();
            return;
        }
        int i3 = this.mCurrentViewWidth;
        int i4 = this.mCurrentViewHeight;
        if (i3 == 0) {
            int viewWidth = this.mWebView.getViewWidth();
            int i5 = (int) (viewWidth / f2);
            if (i5 == 0) {
                Log.w(LOGTAG, "Can't get the viewWidth after the first layout");
                i = i5;
                round = viewWidth;
                z2 = true;
            } else {
                i = i5;
                round = viewWidth;
                z2 = true;
            }
        } else {
            i = i3;
            round = Math.round(i3 * this.mCurrentViewScale);
            z2 = false;
        }
        if (i4 == 0) {
            round2 = this.mWebView.getViewHeight();
            if (((int) (round2 / f2)) == 0) {
                Log.w(LOGTAG, "Can't get the viewHeight after the first layout");
            }
        } else {
            round2 = Math.round(i4 * this.mCurrentViewScale);
        }
        this.mRestoreState = new RestoreState();
        this.mRestoreState.mMinScale = this.mViewportMinimumScale / 100.0f;
        this.mRestoreState.mMaxScale = this.mViewportMaximumScale / 100.0f;
        this.mRestoreState.mDefaultScale = f2;
        this.mRestoreState.mScrollX = this.mRestoredX;
        this.mRestoreState.mScrollY = this.mRestoredY;
        this.mRestoreState.mMobileSite = this.mViewportWidth == 0;
        if (this.mRestoredScale > 0) {
            this.mRestoreState.mViewScale = this.mRestoredScale / 100.0f;
            if (this.mRestoredScreenWidthScale > 0) {
                this.mRestoreState.mTextWrapScale = this.mRestoredScreenWidthScale / 100.0f;
            } else {
                this.mRestoreState.mTextWrapScale = this.mRestoreState.mViewScale;
            }
        } else if (this.mViewportInitialScale > 0) {
            RestoreState restoreState2 = this.mRestoreState;
            float f3 = this.mViewportInitialScale / 100.0f;
            this.mRestoreState.mTextWrapScale = f3;
            restoreState2.mViewScale = f3;
        } else if (this.mViewportWidth > 0 && this.mViewportWidth < round) {
            RestoreState restoreState3 = this.mRestoreState;
            float f4 = round / this.mViewportWidth;
            this.mRestoreState.mTextWrapScale = f4;
            restoreState3.mViewScale = f4;
        } else {
            this.mRestoreState.mTextWrapScale = f2;
            this.mRestoreState.mViewScale = 0.0f;
        }
        if (this.mWebView.mHeightCanMeasure) {
            this.mWebView.mLastHeightSent = 0;
            WebView.ViewSizeData viewSizeData = new WebView.ViewSizeData();
            viewSizeData.mWidth = this.mWebView.mLastWidthSent;
            viewSizeData.mHeight = 0;
            viewSizeData.mTextWrapWidth = viewSizeData.mWidth;
            viewSizeData.mScale = -1.0f;
            viewSizeData.mIgnoreHeight = false;
            viewSizeData.mAnchorY = 0;
            viewSizeData.mAnchorX = 0;
            this.mEventHub.removeMessages(105);
            this.mEventHub.sendMessageAtFrontOfQueue(Message.obtain(null, 105, viewSizeData));
        } else if (this.mSettings.getUseWideViewPort()) {
            if (i == 0) {
                this.mWebView.mLastWidthSent = 0;
                return;
            }
            WebView.ViewSizeData viewSizeData2 = new WebView.ViewSizeData();
            if (this.mRestoreState.mViewScale == 0.0f) {
                f = this.mRestoredScale > 0 ? this.mRestoredScale / 100.0f : this.mRestoreState.mTextWrapScale;
            } else {
                f = this.mRestoreState.mViewScale;
            }
            viewSizeData2.mScale = f;
            viewSizeData2.mWidth = Math.round(round / viewSizeData2.mScale);
            if (z2) {
                nativeSetWebViewWidth(viewSizeData2.mWidth);
            }
            nativeSetWebViewHeight(Math.round(round2 / viewSizeData2.mScale));
            viewSizeData2.mHeight = this.mCurrentViewHeight == 0 ? Math.round(this.mWebView.getViewHeight() / viewSizeData2.mScale) : (this.mCurrentViewHeight * viewSizeData2.mWidth) / i;
            viewSizeData2.mTextWrapWidth = Math.round(round / this.mRestoreState.mTextWrapScale);
            viewSizeData2.mIgnoreHeight = false;
            viewSizeData2.mAnchorY = 0;
            viewSizeData2.mAnchorX = 0;
            this.mEventHub.removeMessages(105);
            viewSizeChanged(viewSizeData2.mWidth, viewSizeData2.mHeight, viewSizeData2.mTextWrapWidth, viewSizeData2.mScale, viewSizeData2.mAnchorX, viewSizeData2.mAnchorY, viewSizeData2.mIgnoreHeight);
        }
    }

    private void restoreScale(int i) {
        if (!this.mBrowserFrame.firstLayoutDone()) {
            this.mRestoredScale = i;
        }
    }

    private void restoreScreenWidthScale(int i) {
        if (this.mSettings.getUseWideViewPort() && !this.mBrowserFrame.firstLayoutDone()) {
            this.mRestoredScreenWidthScale = i;
        }
    }

    private void needTouchEvents(boolean z) {
        if (this.mWebView != null) {
            Message.obtain(this.mWebView.mPrivateHandler, SocialAPIErrorCodes.ERROR_INVALID_GRANT_TYPE, z ? 1 : 0, 0).sendToTarget();
        }
    }

    private void updateTextfield(int i, boolean z, String str, int i2) {
        if (this.mWebView != null) {
            Message obtain = Message.obtain(this.mWebView.mPrivateHandler, 108, i, i2, str);
            obtain.getData().putBoolean("password", z);
            obtain.sendToTarget();
        }
    }

    private void updateTextSelection(int i, int i2, int i3, int i4) {
        if (this.mWebView != null) {
            Message.obtain(this.mWebView.mPrivateHandler, SocialAPIErrorCodes.ERROR_EXPIRED_SESSION_KEY, i, i4, new TextSelectionData(i2, i3)).sendToTarget();
        }
    }

    private void clearTextEntry() {
        if (this.mWebView != null) {
            Message.obtain(this.mWebView.mPrivateHandler, (int) SocialAPIErrorCodes.ERROR_EXPIRED_ACCESS_TOKEN).sendToTarget();
        }
    }

    private boolean isBigPluginWebView() {
        return this.mWebView != null && this.mWebView.getWebViewType() == WebView.WebViewType.BIGPLUGIN;
    }

    public void hasVideo() {
        this.mCallbackProxy.hasVideo();
    }

    public void notifyScale(float f) {
        if (this.mWebView != null) {
            this.mWebView.setAdjustScale(f);
            Message.obtain(this.mWebView.mPrivateHandler, 145, Float.valueOf(f)).sendToTarget();
        }
    }

    private void sendFindAgain() {
        if (this.mWebView != null) {
            Message.obtain(this.mWebView.mPrivateHandler, 126).sendToTarget();
        }
    }

    private void sendHideCursor() {
        if (this.mWebView != null) {
            Message.obtain(this.mWebView.mPrivateHandler, 138).sendToTarget();
        }
    }

    private void requestListBox(String[] strArr, int[] iArr, int[] iArr2, int i, int i2, int i3, int i4, int i5) {
        if (this.mWebView != null) {
            this.mWebView.requestListBox(strArr, iArr, iArr2, i, i2, i3, i4, i5);
        }
    }

    private void requestListBox(String[] strArr, int[] iArr, int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.mWebView != null) {
            this.mWebView.requestListBox(strArr, iArr, i, i2, i3, i4, i5, i6);
        }
    }

    private void requestListBox(String[] strArr, int[] iArr, int[] iArr2) {
        if (this.mWebView != null) {
            this.mWebView.requestListBox(strArr, iArr, iArr2);
        }
    }

    private void requestListBox(String[] strArr, int[] iArr, int i) {
        if (this.mWebView != null) {
            this.mWebView.requestListBox(strArr, iArr, i);
        }
    }

    private void requestKeyboardWithSelection(int i, int i2, int i3, int i4) {
        if (this.mWebView != null) {
            Message.obtain(this.mWebView.mPrivateHandler, DERTags.TAGGED, i, i4, new TextSelectionData(i2, i3)).sendToTarget();
        }
    }

    private void requestKeyboardWithSelectionExt(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, String str) {
        if (this.mWebView != null) {
            Message obtain = Message.obtain(this.mWebView.mPrivateHandler, 133, i, i4, new RequestKeyboardData(new TextSelectionData(i2, i3), new Rect(i5, i6, i7, i8), str));
            if (this.mDrawIsScheduled) {
                this.mEventHub.sendMessage(Message.obtain(null, SocialAPIErrorCodes.ERROR_INVALID_UPLOAD_FILE, obtain));
                Log.d(LOGTAG, "yejianchun anxin contentScrollTo2");
                return;
            }
            obtain.sendToTarget();
        }
    }

    private void focusedInputBoundsChanged(int i, int i2, int i3, int i4, String str) {
        if (this.mWebView != null) {
            Message.obtain(this.mWebView.mPrivateHandler, 131, new RequestKeyboardData(null, new Rect(i, i2, i3, i4), str)).sendToTarget();
        }
    }

    private void requestKeyboard(boolean z) {
        if (this.mWebView != null) {
            Message.obtain(this.mWebView.mPrivateHandler, SocialAPIErrorCodes.ERROR_INVALID_REDIRECT_URI, z ? 1 : 0, 0).sendToTarget();
        }
    }

    private Context getContext() {
        return this.mContext;
    }

    private Class<?> getPluginClass(String str, String str2) {
        if (this.mWebView == null) {
            return null;
        }
        PluginManager pluginManager = PluginManager.getInstance(null);
        String pluginsAPKName = pluginManager.getPluginsAPKName(str);
        if (pluginsAPKName == null) {
            Log.w(LOGTAG, "Unable to resolve " + str + " to a plugin APK");
            return null;
        }
        try {
            return pluginManager.getPluginClass(pluginsAPKName, str2);
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(LOGTAG, "Unable to find plugin classloader for the apk (" + pluginsAPKName + ")");
            return null;
        } catch (ClassNotFoundException e2) {
            Log.e(LOGTAG, "Unable to find plugin class (" + str2 + ") in the apk (" + pluginsAPKName + ")");
            return null;
        }
    }

    private void showFullScreenPlugin(ViewManager.ChildView childView, int i) {
        if (this.mWebView != null) {
            Message obtainMessage = this.mWebView.mPrivateHandler.obtainMessage(SocialAPIErrorCodes.ERROR_INVALID_AUTHORIZED_CODE);
            obtainMessage.obj = childView.mView;
            obtainMessage.arg1 = i;
            obtainMessage.sendToTarget();
        }
    }

    private void showFullScreenPlugin(ViewManager.ChildView childView, int i, int i2) {
        if (this.mWebView != null) {
            Message obtainMessage = this.mWebView.mPrivateHandler.obtainMessage(SocialAPIErrorCodes.ERROR_INVALID_AUTHORIZED_CODE);
            obtainMessage.obj = childView.mView;
            obtainMessage.arg1 = i;
            obtainMessage.arg2 = i2;
            obtainMessage.sendToTarget();
        }
    }

    private void hideFullScreenPlugin() {
        if (this.mWebView != null) {
            this.mWebView.mPrivateHandler.obtainMessage(SocialAPIErrorCodes.ERROR_INVALID_STATE).sendToTarget();
        }
    }

    public void didFullScreenMode(boolean z) {
        if (this.mWebView != null) {
            this.mWebView.mPrivateHandler.obtainMessage(z ? 140 : 141).sendToTarget();
            if (z) {
                this.mWebView.m_ExitFullScreen = false;
                this.mWebView.onResume();
            }
        }
    }

    private ViewManager.ChildView createSurface(View view) {
        if (this.mWebView == null) {
            return null;
        }
        if (view == null) {
            Log.e(LOGTAG, "Attempted to add an empty plugin view to the view hierarchy");
            return null;
        }
        view.setWillNotDraw(false);
        if (view instanceof SurfaceView) {
            ((SurfaceView) view).setZOrderOnTop(true);
        }
        ViewManager.ChildView createView = this.mWebView.mViewManager.createView();
        createView.mView = view;
        return createView;
    }

    private ViewManager.ChildView addSurface(View view, int i, int i2, int i3, int i4) {
        if (this.mWebView == null) {
            return null;
        }
        if (view == null) {
            Log.e(LOGTAG, "Attempted to add an empty plugin view to the view hierarchy");
            return null;
        }
        view.setWillNotDraw(false);
        if (view instanceof SurfaceView) {
            ((SurfaceView) view).setZOrderOnTop(true);
        }
        ViewManager.ChildView createView = this.mWebView.mViewManager.createView();
        createView.mView = view;
        createView.attachView(i, i2, i3, i4);
        return createView;
    }

    private void updateSurface(ViewManager.ChildView childView, int i, int i2, int i3, int i4) {
        childView.attachView(i, i2, i3, i4);
    }

    private void destroySurface(ViewManager.ChildView childView) {
        childView.removeView();
    }

    /* loaded from: classes.dex */
    class ShowRectData {
        int mContentHeight;
        int mContentWidth;
        int mHeight;
        int mLeft;
        int mTop;
        int mWidth;
        float mXPercentInDoc;
        float mXPercentInView;
        float mYPercentInDoc;
        float mYPercentInView;

        ShowRectData() {
        }
    }

    private void showRect(int i, int i2, int i3, int i4, int i5, int i6, float f, float f2, float f3, float f4) {
        if (this.mWebView != null) {
            ShowRectData showRectData = new ShowRectData();
            showRectData.mLeft = i;
            showRectData.mTop = i2;
            showRectData.mWidth = i3;
            showRectData.mHeight = i4;
            showRectData.mContentWidth = i5;
            showRectData.mContentHeight = i6;
            showRectData.mXPercentInDoc = f;
            showRectData.mXPercentInView = f2;
            showRectData.mYPercentInDoc = f3;
            showRectData.mYPercentInView = f4;
            Message.obtain(this.mWebView.mPrivateHandler, 113, showRectData).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showBlockRect(Rect rect, int i, int i2, int i3) {
        if (this.mWebView != null) {
            DoubleTapScaleData doubleTapScaleData = new DoubleTapScaleData();
            doubleTapScaleData.mBlockRect = rect;
            doubleTapScaleData.mScreenWidth = i;
            doubleTapScaleData.mAnchorX = i2;
            doubleTapScaleData.mAnchorY = i3;
            this.mWebView.mPrivateHandler.sendMessageAtFrontOfQueue(this.mWebView.mPrivateHandler.obtainMessage(147, doubleTapScaleData));
        }
    }

    private void centerFitRect(int i, int i2, int i3, int i4) {
        if (this.mWebView != null) {
            this.mWebView.mPrivateHandler.obtainMessage(127, new Rect(i, i2, i + i3, i2 + i4)).sendToTarget();
        }
    }

    private void setScrollbarModes(int i, int i2) {
        if (this.mWebView != null) {
            this.mWebView.mPrivateHandler.obtainMessage(129, i, i2).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void useMockDeviceOrientation() {
        this.mDeviceMotionAndOrientationManager.useMock();
    }

    public void setMockDeviceOrientation(boolean z, double d, boolean z2, double d2, boolean z3, double d3) {
        this.mDeviceMotionAndOrientationManager.setMockOrientation(z, d, z2, d2, z3, d3);
    }

    protected DeviceMotionService getDeviceMotionService() {
        if (this.mDeviceMotionService == null) {
            this.mDeviceMotionService = new DeviceMotionService(this.mDeviceMotionAndOrientationManager, this.mContext);
        }
        return this.mDeviceMotionService;
    }

    protected DeviceOrientationService getDeviceOrientationService() {
        if (this.mDeviceOrientationService == null) {
            this.mDeviceOrientationService = new DeviceOrientationService(this.mDeviceMotionAndOrientationManager, this.mContext);
        }
        return this.mDeviceOrientationService;
    }
}
