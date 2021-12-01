package com.baidu.webkit.sdk;

import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.widget.AbsoluteLayout;
import com.baidu.webkit.sdk.WebView;
import com.baidu.webkit.sdk.performance.PagePerformanceTiming;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import java.io.BufferedWriter;
import java.util.Map;
/* loaded from: classes12.dex */
public interface WebViewProvider {

    /* loaded from: classes12.dex */
    public interface ScrollDelegate {
        int computeHorizontalScrollOffset();

        int computeHorizontalScrollRange();

        void computeScroll();

        int computeVerticalScrollExtent();

        int computeVerticalScrollOffset();

        int computeVerticalScrollRange();
    }

    /* loaded from: classes12.dex */
    public interface ViewDelegate {
        boolean dispatchKeyEvent(KeyEvent keyEvent);

        View findFocus(View view);

        AccessibilityNodeProvider getAccessibilityNodeProvider();

        Handler getHandler(Handler handler);

        AbsoluteLayout getWebViewImpl();

        void onAttachedToWindow();

        boolean onCheckIsTextEditor();

        void onConfigurationChanged(Configuration configuration);

        InputConnection onCreateInputConnection(EditorInfo editorInfo);

        void onDetachedFromWindow();

        boolean onDragEvent(DragEvent dragEvent);

        void onDraw(Canvas canvas);

        void onDrawVerticalScrollBar(Canvas canvas, Drawable drawable, int i2, int i3, int i4, int i5);

        void onFinishTemporaryDetach();

        void onFocusChanged(boolean z, int i2, Rect rect);

        boolean onGenericMotionEvent(MotionEvent motionEvent);

        boolean onHoverEvent(MotionEvent motionEvent);

        void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent);

        void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo);

        boolean onInterceptTouchEvent(MotionEvent motionEvent);

        boolean onKeyDown(int i2, KeyEvent keyEvent);

        boolean onKeyMultiple(int i2, int i3, KeyEvent keyEvent);

        boolean onKeyUp(int i2, KeyEvent keyEvent);

        void onMeasure(int i2, int i3);

        void onOverScrolled(int i2, int i3, boolean z, boolean z2);

        void onProvideVirtualStructure(ViewStructure viewStructure);

        void onScrollChanged(int i2, int i3, int i4, int i5);

        void onSizeChanged(int i2, int i3, int i4, int i5);

        void onStartTemporaryDetach();

        boolean onTouchEvent(MotionEvent motionEvent);

        boolean onTrackballEvent(MotionEvent motionEvent);

        void onVisibilityChanged(View view, int i2);

        void onWindowFocusChanged(boolean z);

        void onWindowVisibilityChanged(int i2);

        boolean performAccessibilityAction(int i2, Bundle bundle);

        boolean performLongClick();

        void preDispatchDraw(Canvas canvas);

        boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z);

        boolean requestFocus(int i2, Rect rect);

        void setBackgroundColor(int i2);

        boolean setFrame(int i2, int i3, int i4, int i5);

        void setLayerType(int i2, Paint paint);

        void setLayoutParams(ViewGroup.LayoutParams layoutParams);

        void setOverScrollMode(int i2);

        void setScrollBarStyle(int i2);

        boolean shouldDelayChildPressedState();
    }

    void addEmbeddedTitleBarFinished();

    void addJavascriptInterface(Object obj, String str);

    void addNoStatePrefetch(String str, String str2);

    void addWebMessageListener(WebMessageListener webMessageListener, String str, String[] strArr);

    void addZeusPluginFactory(ZeusPluginFactory zeusPluginFactory);

    boolean canGoBack();

    boolean canGoBackOrForward(int i2);

    boolean canGoForward();

    boolean canGoPrerender();

    boolean canZoomIn();

    boolean canZoomOut();

    void cancelCurrentNoStatePrefetch();

    Picture captureHistoryPicture(int i2, int i3, int i4);

    Picture capturePicture(int i2, int i3, boolean z);

    void capturePicture(int i2, int i3, ValueCallback<Picture> valueCallback);

    void clearCache(boolean z);

    boolean clearDiskJsCodeCache(String str);

    void clearFormData();

    void clearHistory();

    void clearMatches();

    void clearPrerender();

    void clearSslPreferences();

    void clearView();

    WebBackForwardList copyBackForwardListZeus();

    void cutdownUserData(int i2);

    void destroy();

    void disableMedia();

    void documentHasImages(Message message);

    void dumpViewHierarchyWithProperties(BufferedWriter bufferedWriter, int i2);

    void emulateShiftHeldOnLink();

    void emulateShiftHeldOnNormalText();

    void enableMedia();

    void evaluateJavaScript(String str, ValueCallback<String> valueCallback);

    void evaluateJavaScriptMethod(String str, String str2, String str3, ValueCallback<String> valueCallback);

    void evaluateJavaScriptOnPrerender(String str, ValueCallback<String> valueCallback);

    void exitFullScreenMode();

    void extendSelection();

    int findAll(String str);

    void findAllAsync(String str);

    View findHierarchyView(String str, int i2);

    void findNext(boolean z);

    void flingScroll(int i2, int i3);

    void freeMemory();

    Bitmap getCanvasCacheBmp();

    SslCertificate getCertificate();

    int getContentHeight();

    int getContentWidth();

    Bitmap getFavicon();

    String getGpuInfo();

    WebView.HitTestResult getHitTestResultZeus();

    String[] getHttpAuthUsernamePassword(String str, String str2);

    void getManifestInfo(ManifestInfoCallback manifestInfoCallback);

    float getMaxZoomScale();

    float getMinZoomScale();

    String getOriginalUrl();

    PagePerformanceTiming getPerformanceTiming();

    int getProgress();

    String getReferer();

    boolean getRendererPriorityWaivedWhenNotVisible();

    int getRendererRequestedPriority();

    float getScale();

    ScrollDelegate getScrollDelegate();

    boolean getSelectingText();

    WebSettings getSettingsZeus();

    CharSequence getTextFieldText();

    String getTitle();

    int getTouchMode();

    String getUrl();

    Object getUserData(int i2, int i3);

    ViewDelegate getViewDelegate();

    int getVisibleTitleHeightZeus();

    void getWebAppShortcutData(WebAppShortcutDataListener webAppShortcutDataListener, boolean z);

    WebChromeClient getWebChromeClientZeus();

    WebViewClient getWebViewClientZeus();

    ViewGroup getWebViewPager();

    void goBack();

    void goBackOrForward(int i2);

    void goForward();

    void goNextOrPreTextField(boolean z);

    void goPrerender();

    void hitAd(String str);

    void init(Map<String, Object> map, boolean z);

    void initNet();

    void insertTextFieldText(CharSequence charSequence);

    void insertVisualStateCallback(long j2, WebView.VisualStateCallback visualStateCallback);

    void invokeZoomPicker();

    boolean isAutoShowTitlebar();

    boolean isMobileSite();

    boolean isPaused();

    boolean isPrivateBrowsingEnabled();

    boolean isScrollInProgress();

    boolean isZeusWebViewProvider();

    void loadData(String str, String str2, String str3);

    void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5);

    void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5, boolean z);

    void loadUrl(String str);

    void loadUrl(String str, Map<String, String> map);

    void loadUrl(String str, Map<String, String> map, boolean z);

    void notifyUkmPageLeave();

    void notifyUnsafeInvolved(int i2, String str);

    void onPageSwapFromWebview(WebView webView, String str, boolean z);

    void onPause();

    void onPauseAll();

    void onResume();

    void onResumeAll();

    boolean overlayHorizontalScrollbar();

    boolean overlayVerticalScrollbar();

    boolean pageDown(boolean z);

    boolean pageUp(boolean z);

    void pauseMedia();

    void pauseTimers();

    void postMessageToMainFrame(WebMessage webMessage, Uri uri);

    void postUrl(String str, byte[] bArr);

    void reinjectJavascriptInterface();

    void reload();

    void removeHistoryItems();

    void removeJavascriptInterface(String str);

    void requestFocusNodeHref(Message message);

    void requestImageRef(Message message);

    void resetClearView();

    void resetLoadingAnimation();

    WebBackForwardList restoreStateZeus(Bundle bundle);

    void resumeMedia();

    void resumeTimers();

    boolean savePageAsLocalFiles(String str, String str2, WebView.SaveAsType saveAsType);

    void savePassword(String str, String str2, String str3);

    WebBackForwardList saveStateZeus(Bundle bundle);

    void saveWebArchive(String str);

    void saveWebArchive(String str, boolean z, ValueCallback<String> valueCallback);

    void selectionDone();

    void sendFeedback(String str, String str2);

    void setAutoShowTitlebar(boolean z);

    void setBeginScale();

    void setBottomControlsHeight(int i2);

    void setCanvasCacheBmp(Bitmap bitmap);

    void setCertificate(SslCertificate sslCertificate);

    void setDefaultViewSize(int i2, int i3);

    void setDownloadListener(DownloadListener downloadListener);

    void setEndScale();

    void setFindListener(WebView.FindListener findListener);

    void setHorizontalScrollbarOverlay(boolean z);

    void setHttpAuthUsernamePassword(String str, String str2, String str3, String str4);

    void setInitialScale(int i2);

    void setMapTrackballToArrowKeys(boolean z);

    void setNetworkAvailable(boolean z);

    void setPageTransformer(boolean z, PageTransformer pageTransformer);

    void setPauseSyncActions(boolean z);

    void setPictureListener(WebView.PictureListener pictureListener);

    boolean setPreviewZoomScale(float f2);

    void setRendererPriorityPolicy(int i2, boolean z);

    boolean setSelectingText(boolean z);

    void setStatusBar(View view, int i2);

    void setTextFieldText(CharSequence charSequence);

    void setTopControlsHeight(int i2, boolean z);

    void setUserData(int i2, int i3, Object obj);

    void setVerticalScrollbarOverlay(boolean z);

    void setVideoPlayerFactory(VideoPlayerFactory videoPlayerFactory);

    void setWebChromeClient(WebChromeClient webChromeClient);

    void setWebViewClient(WebViewClient webViewClient);

    void setWebViewMargin(int i2, int i3, int i4, int i5);

    void setWebViewPagerContainer(ViewGroup viewGroup);

    void setWebViewPagerSize(int i2, int i3);

    boolean showFindDialog(String str, boolean z);

    void startLoadingAnimation(String str);

    int startPrerender(String str);

    void stopLoading();

    void stopPrerender();

    void suspendScheduledTasks(String str);

    void switchTitleBar(boolean z);

    void updateTopControlOffset(int i2);

    void updateTopControlsState(boolean z, boolean z2, boolean z3);

    boolean zoomByZeus(float f2);

    boolean zoomIn();

    boolean zoomOut();
}
