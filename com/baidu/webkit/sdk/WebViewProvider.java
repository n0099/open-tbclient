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
/* loaded from: classes6.dex */
public interface WebViewProvider {

    /* loaded from: classes6.dex */
    public interface ScrollDelegate {
        int computeHorizontalScrollOffset();

        int computeHorizontalScrollRange();

        void computeScroll();

        int computeVerticalScrollExtent();

        int computeVerticalScrollOffset();

        int computeVerticalScrollRange();
    }

    /* loaded from: classes6.dex */
    public interface ViewDelegate {
        boolean dispatchKeyEvent(KeyEvent keyEvent);

        View findFocus(View view2);

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

        void onDrawVerticalScrollBar(Canvas canvas, Drawable drawable, int i, int i2, int i3, int i4);

        void onFinishTemporaryDetach();

        void onFocusChanged(boolean z, int i, Rect rect);

        boolean onGenericMotionEvent(MotionEvent motionEvent);

        boolean onHoverEvent(MotionEvent motionEvent);

        void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent);

        void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo);

        boolean onInterceptTouchEvent(MotionEvent motionEvent);

        boolean onKeyDown(int i, KeyEvent keyEvent);

        boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent);

        boolean onKeyUp(int i, KeyEvent keyEvent);

        void onMeasure(int i, int i2);

        void onOverScrolled(int i, int i2, boolean z, boolean z2);

        void onProvideVirtualStructure(ViewStructure viewStructure);

        void onScrollChanged(int i, int i2, int i3, int i4);

        void onSizeChanged(int i, int i2, int i3, int i4);

        void onStartTemporaryDetach();

        boolean onTouchEvent(MotionEvent motionEvent);

        boolean onTrackballEvent(MotionEvent motionEvent);

        void onVisibilityChanged(View view2, int i);

        void onWindowFocusChanged(boolean z);

        void onWindowVisibilityChanged(int i);

        boolean performAccessibilityAction(int i, Bundle bundle);

        boolean performLongClick();

        void preDispatchDraw(Canvas canvas);

        boolean requestChildRectangleOnScreen(View view2, Rect rect, boolean z);

        boolean requestFocus(int i, Rect rect);

        void setBackgroundColor(int i);

        boolean setFrame(int i, int i2, int i3, int i4);

        void setLayerType(int i, Paint paint);

        void setLayoutParams(ViewGroup.LayoutParams layoutParams);

        void setOverScrollMode(int i);

        void setScrollBarStyle(int i);

        boolean shouldDelayChildPressedState();
    }

    void addEmbeddedTitleBarFinished();

    void addJavascriptInterface(Object obj, String str);

    void addNoStatePrefetch(String str, String str2);

    void addWebMessageListener(WebMessageListener webMessageListener, String str, String[] strArr);

    void addZeusPluginFactory(ZeusPluginFactory zeusPluginFactory);

    boolean canGoBack();

    boolean canGoBackOrForward(int i);

    boolean canGoForward();

    boolean canGoPrerender();

    boolean canZoomIn();

    boolean canZoomOut();

    void cancelCurrentNoStatePrefetch();

    Picture captureHistoryPicture(int i, int i2, int i3);

    Picture capturePicture(int i, int i2, boolean z);

    void capturePicture(int i, int i2, ValueCallback valueCallback);

    void clearCache(boolean z);

    boolean clearDiskJsCodeCache(String str);

    void clearFormData();

    void clearHistory();

    void clearMatches();

    void clearPrerender();

    void clearSslPreferences();

    void clearView();

    WebBackForwardList copyBackForwardListZeus();

    void cutdownUserData(int i);

    void destroy();

    void disableMedia();

    void documentHasImages(Message message);

    void dumpViewHierarchyWithProperties(BufferedWriter bufferedWriter, int i);

    void emulateShiftHeldOnLink();

    void emulateShiftHeldOnNormalText();

    void enableMedia();

    void evaluateJavaScript(String str, ValueCallback valueCallback);

    void evaluateJavaScriptMethod(String str, String str2, String str3, ValueCallback valueCallback);

    void evaluateJavaScriptOnPrerender(String str, ValueCallback valueCallback);

    void exitFullScreenMode();

    void extendSelection();

    int findAll(String str);

    void findAllAsync(String str);

    View findHierarchyView(String str, int i);

    void findNext(boolean z);

    void flingScroll(int i, int i2);

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

    Object getUserData(int i, int i2);

    ViewDelegate getViewDelegate();

    int getVisibleTitleHeightZeus();

    void getWebAppShortcutData(WebAppShortcutDataListener webAppShortcutDataListener, boolean z);

    WebChromeClient getWebChromeClientZeus();

    WebViewClient getWebViewClientZeus();

    ViewGroup getWebViewPager();

    void goBack();

    void goBackOrForward(int i);

    void goForward();

    void goNextOrPreTextField(boolean z);

    void goPrerender();

    void hitAd(String str);

    void init(Map map, boolean z);

    void initNet();

    void insertTextFieldText(CharSequence charSequence);

    void insertVisualStateCallback(long j, WebView.VisualStateCallback visualStateCallback);

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

    void loadUrl(String str, Map map);

    void loadUrl(String str, Map map, boolean z);

    void notifyUkmPageLeave();

    void notifyUnsafeInvolved(int i, String str);

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

    void saveWebArchive(String str, boolean z, ValueCallback valueCallback);

    void selectionDone();

    void sendFeedback(String str, String str2);

    void setAutoShowTitlebar(boolean z);

    void setBeginScale();

    void setBottomControlsHeight(int i);

    void setCanvasCacheBmp(Bitmap bitmap);

    void setCertificate(SslCertificate sslCertificate);

    void setDefaultViewSize(int i, int i2);

    void setDownloadListener(DownloadListener downloadListener);

    void setEndScale();

    void setFindListener(WebView.FindListener findListener);

    void setHorizontalScrollbarOverlay(boolean z);

    void setHttpAuthUsernamePassword(String str, String str2, String str3, String str4);

    void setInitialScale(int i);

    void setMapTrackballToArrowKeys(boolean z);

    void setNetworkAvailable(boolean z);

    void setPageTransformer(boolean z, PageTransformer pageTransformer);

    void setPauseSyncActions(boolean z);

    void setPictureListener(WebView.PictureListener pictureListener);

    boolean setPreviewZoomScale(float f);

    void setRendererPriorityPolicy(int i, boolean z);

    boolean setSelectingText(boolean z);

    void setStatusBar(View view2, int i);

    void setTextFieldText(CharSequence charSequence);

    void setTopControlsHeight(int i, boolean z);

    void setUserData(int i, int i2, Object obj);

    void setVerticalScrollbarOverlay(boolean z);

    void setVideoPlayerFactory(VideoPlayerFactory videoPlayerFactory);

    void setWebChromeClient(WebChromeClient webChromeClient);

    void setWebViewClient(WebViewClient webViewClient);

    void setWebViewMargin(int i, int i2, int i3, int i4);

    void setWebViewPagerContainer(ViewGroup viewGroup);

    void setWebViewPagerSize(int i, int i2);

    boolean showFindDialog(String str, boolean z);

    void startLoadingAnimation(String str);

    int startPrerender(String str);

    void stopLoading();

    void stopPrerender();

    void suspendScheduledTasks(String str);

    void switchTitleBar(boolean z);

    void updateTopControlOffset(int i);

    void updateTopControlsState(boolean z, boolean z2, boolean z3);

    boolean zoomByZeus(float f);

    boolean zoomIn();

    boolean zoomOut();
}
