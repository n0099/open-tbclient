package com.baidu.webkit.sdk.system;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Picture;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.ManifestInfoCallback;
import com.baidu.webkit.sdk.PageTransformer;
import com.baidu.webkit.sdk.VideoPlayerFactory;
import com.baidu.webkit.sdk.WebAppShortcutDataListener;
import com.baidu.webkit.sdk.WebBackForwardList;
import com.baidu.webkit.sdk.WebChromeClient;
import com.baidu.webkit.sdk.WebMessage;
import com.baidu.webkit.sdk.WebSettings;
import com.baidu.webkit.sdk.WebView;
import com.baidu.webkit.sdk.WebViewClient;
import com.baidu.webkit.sdk.WebViewProvider;
import com.baidu.webkit.sdk.performance.PagePerformanceTiming;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import java.io.BufferedWriter;
import java.lang.reflect.Method;
import java.util.Map;
/* loaded from: classes11.dex */
public final class WebViewImpl extends WebView implements WebViewProvider {
    private final WebView.DelegateAdapter mDelegate;
    private WebSettings mSettings;
    private WebChromeClient mWebChromeClient;
    private final com.baidu.webkit.sdk.WebView mWebView;
    private WebViewClient mWebViewClient;
    private final WebView.PrivateAccess mWebViewPrivateAccess;

    /* loaded from: classes11.dex */
    private class FindAdapter implements WebView.FindListener {
        private final WebView.FindListener mListener;

        private FindAdapter(WebView.FindListener findListener) {
            this.mListener = findListener;
        }

        @Override // android.webkit.WebView.FindListener
        public void onFindResultReceived(int i, int i2, boolean z) {
            this.mListener.onFindResultReceived(i, i2, z);
        }
    }

    /* loaded from: classes11.dex */
    private class PictureAdapter implements WebView.PictureListener {
        private final WebView.PictureListener mListener;

        private PictureAdapter(WebView.PictureListener pictureListener) {
            this.mListener = pictureListener;
        }

        @Override // android.webkit.WebView.PictureListener
        public void onNewPicture(android.webkit.WebView webView, Picture picture) {
            this.mListener.onNewPicture(((WebViewImpl) webView).getWebView(), picture);
        }
    }

    /* loaded from: classes11.dex */
    public class WebViewTransportImpl extends WebView.WebViewTransport {
        private WebView.WebViewTransport mTransport;
        private com.baidu.webkit.sdk.WebView mWebViewGeneric;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WebViewTransportImpl(com.baidu.webkit.sdk.WebView webView, WebView.WebViewTransport webViewTransport) {
            super();
            webView.getClass();
            this.mTransport = webViewTransport;
        }

        WebView.WebViewTransport getTransport() {
            return this.mTransport;
        }

        @Override // com.baidu.webkit.sdk.WebView.WebViewTransport
        public synchronized com.baidu.webkit.sdk.WebView getWebView() {
            return this.mWebViewGeneric;
        }

        @Override // com.baidu.webkit.sdk.WebView.WebViewTransport
        public synchronized void setWebView(com.baidu.webkit.sdk.WebView webView) {
            this.mWebViewGeneric = webView;
            this.mTransport.setWebView((android.webkit.WebView) webView.getWebView());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebViewImpl(com.baidu.webkit.sdk.WebView webView, WebView.PrivateAccess privateAccess) {
        super(webView.getContext());
        this.mWebView = webView;
        this.mWebViewPrivateAccess = privateAccess;
        com.baidu.webkit.sdk.WebView webView2 = this.mWebView;
        webView2.getClass();
        this.mDelegate = new WebView.DelegateAdapter(this);
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void addEmbeddedTitleBarFinished() {
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void addZeusPluginFactory(ZeusPluginFactory zeusPluginFactory) {
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final boolean canGoPrerender() {
        return false;
    }

    @Override // android.webkit.WebView, com.baidu.webkit.sdk.WebViewProvider
    @TargetApi(11)
    public final boolean canZoomIn() {
        if (Build.VERSION.SDK_INT >= 11) {
            return super.canZoomIn();
        }
        return false;
    }

    @Override // android.webkit.WebView, com.baidu.webkit.sdk.WebViewProvider
    @TargetApi(11)
    public final boolean canZoomOut() {
        if (Build.VERSION.SDK_INT >= 11) {
            return super.canZoomOut();
        }
        return false;
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final Picture captureHistoryPicture(int i, int i2, int i3) {
        return null;
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final Picture capturePicture(int i, int i2, boolean z) {
        return super.capturePicture();
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void clearPrerender() {
    }

    @Override // android.webkit.WebView, android.view.View
    public final int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override // android.webkit.WebView, android.view.View
    public final int computeVerticalScrollOffset() {
        return super.computeVerticalScrollOffset();
    }

    @Override // android.webkit.WebView, android.view.View
    public final int computeVerticalScrollRange() {
        return super.computeVerticalScrollRange();
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final WebBackForwardList copyBackForwardListZeus() {
        try {
            return WebBackForwardListImpl.from(copyBackForwardList());
        } catch (Exception e) {
            return null;
        }
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void cutdownUserData(int i) {
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void disableMedia() {
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void dumpViewHierarchyWithProperties(BufferedWriter bufferedWriter, int i) {
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void emulateShiftHeldOnLink() {
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void emulateShiftHeldOnNormalText() {
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void enableMedia() {
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    @TargetApi(19)
    public final void evaluateJavaScript(String str, ValueCallback<String> valueCallback) {
        if (Build.VERSION.SDK_INT >= 19) {
            super.evaluateJavascript(str, valueCallback);
        }
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    @TargetApi(19)
    public final void evaluateJavaScriptOnPrerender(String str, ValueCallback<String> valueCallback) {
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void exitFullScreenMode() {
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void extendSelection() {
    }

    @Override // android.webkit.WebView, com.baidu.webkit.sdk.WebViewProvider
    @TargetApi(16)
    public final void findAllAsync(String str) {
        if (Build.VERSION.SDK_INT >= 16) {
            super.findAllAsync(str);
        }
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final View findHierarchyView(String str, int i) {
        return null;
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final Bitmap getCanvasCacheBmp() {
        return null;
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final int getContentWidth() {
        return 0;
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final String getGpuInfo() {
        return null;
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final WebView.HitTestResult getHitTestResultZeus() {
        try {
            return Glue.cast(getHitTestResult());
        } catch (Exception e) {
            return null;
        }
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void getManifestInfo(ManifestInfoCallback manifestInfoCallback) {
        manifestInfoCallback.onManifestInfoFailed();
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final float getMaxZoomScale() {
        return 1.0f;
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final float getMinZoomScale() {
        return 1.0f;
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final PagePerformanceTiming getPerformanceTiming() {
        return null;
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final String getReferer() {
        return null;
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final WebViewProvider.ScrollDelegate getScrollDelegate() {
        return this.mDelegate;
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final boolean getSelectingText() {
        return false;
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final WebSettings getSettingsZeus() {
        if (this.mSettings == null) {
            this.mSettings = WebSettingsImpl.from(getSettings());
        }
        return this.mSettings;
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final CharSequence getTextFieldText() {
        return null;
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final int getTouchMode() {
        return 7;
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final Object getUserData(int i, int i2) {
        return null;
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final WebViewProvider.ViewDelegate getViewDelegate() {
        return this.mDelegate;
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final int getVisibleTitleHeightZeus() {
        if (Build.VERSION.SDK_INT < 17) {
            try {
                Method declaredMethod = android.webkit.WebView.class.getDeclaredMethod("getVisibleTitleHeight", new Class[0]);
                declaredMethod.setAccessible(true);
                return ((Integer) declaredMethod.invoke(this, new Object[0])).intValue();
            } catch (Throwable th) {
                Log.d("huangweichai", "", th);
            }
        }
        return 0;
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void getWebAppShortcutData(WebAppShortcutDataListener webAppShortcutDataListener, boolean z) {
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final WebChromeClient getWebChromeClientZeus() {
        return this.mWebChromeClient;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final com.baidu.webkit.sdk.WebView getWebView() {
        return this.mWebView;
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final WebViewClient getWebViewClientZeus() {
        return this.mWebViewClient;
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final ViewGroup getWebViewPager() {
        return this;
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void goNextOrPreTextField(boolean z) {
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void goPrerender() {
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void hitAd(String str) {
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void init(Map<String, Object> map, boolean z) {
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void initNet() {
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void insertTextFieldText(CharSequence charSequence) {
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    @TargetApi(23)
    public final void insertVisualStateCallback(long j, final WebView.VisualStateCallback visualStateCallback) {
        if (Build.VERSION.SDK_INT >= 23) {
            postVisualStateCallback(j, new WebView.VisualStateCallback() { // from class: com.baidu.webkit.sdk.system.WebViewImpl.1
                @Override // android.webkit.WebView.VisualStateCallback
                public void onComplete(long j2) {
                    if (visualStateCallback != null) {
                        visualStateCallback.onComplete(j2);
                    }
                }
            });
        }
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final boolean isAutoShowTitlebar() {
        return true;
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final boolean isMobileSite() {
        return false;
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final boolean isPaused() {
        return false;
    }

    @Override // android.webkit.WebView, com.baidu.webkit.sdk.WebViewProvider
    @TargetApi(11)
    public final boolean isPrivateBrowsingEnabled() {
        if (Build.VERSION.SDK_INT >= 11) {
            return super.isPrivateBrowsingEnabled();
        }
        return false;
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final boolean isScrollInProgress() {
        return false;
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final boolean isZeusWebViewProvider() {
        return false;
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5, boolean z) {
        super.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void loadUrl(String str, Map<String, String> map, boolean z) {
        super.loadUrl(str, map);
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void notifyUnsafeInvolved(int i, String str) {
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.mWebView.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.webkit.WebView, android.view.View
    protected final void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        if (this.mWebViewPrivateAccess != null) {
            this.mWebViewPrivateAccess.onOverScrolled(i, i2, z, z2);
        }
    }

    @Override // android.webkit.WebView, com.baidu.webkit.sdk.WebViewProvider
    @TargetApi(11)
    public final void onPause() {
        if (Build.VERSION.SDK_INT >= 11) {
            super.onPause();
        }
    }

    @Override // android.webkit.WebView, com.baidu.webkit.sdk.WebViewProvider
    @TargetApi(11)
    public final void onResume() {
        if (Build.VERSION.SDK_INT >= 11) {
            super.onResume();
        }
    }

    @Override // android.webkit.WebView, android.view.View
    protected final void onScrollChanged(int i, int i2, int i3, int i4) {
        if (this.mWebViewPrivateAccess != null) {
            this.mWebViewPrivateAccess.onScrollChanged(i, i2, i3, i4);
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return this.mWebView.onTouchEvent(motionEvent);
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void pauseMedia() {
    }

    @Override // android.webkit.WebView, com.baidu.webkit.sdk.WebViewProvider
    public final void pauseTimers() {
        super.pauseTimers();
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean performLongClick() {
        return this.mWebView.performLongClick();
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    @TargetApi(23)
    public final void postMessageToMainFrame(WebMessage webMessage, Uri uri) {
        if (Build.VERSION.SDK_INT >= 23) {
            postWebMessage(Glue.cast(webMessage), uri);
        }
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void removeHistoryItems() {
    }

    @Override // android.webkit.WebView, com.baidu.webkit.sdk.WebViewProvider
    @TargetApi(11)
    public final void removeJavascriptInterface(String str) {
        if (Build.VERSION.SDK_INT >= 11) {
            super.removeJavascriptInterface(str);
        }
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void resetClearView() {
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void resetLoadingAnimation() {
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final WebBackForwardList restoreStateZeus(Bundle bundle) {
        return WebBackForwardListImpl.from(restoreState(bundle));
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void resumeMedia() {
    }

    @Override // android.webkit.WebView, com.baidu.webkit.sdk.WebViewProvider
    public final void resumeTimers() {
        super.resumeTimers();
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final boolean savePageAsLocalFiles(String str, String str2, WebView.SaveAsType saveAsType) {
        return true;
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final WebBackForwardList saveStateZeus(Bundle bundle) {
        return WebBackForwardListImpl.from(saveState(bundle));
    }

    @Override // android.webkit.WebView, com.baidu.webkit.sdk.WebViewProvider
    @TargetApi(11)
    public final void saveWebArchive(String str) {
        if (Build.VERSION.SDK_INT >= 11) {
            super.saveWebArchive(str);
        }
    }

    @Override // android.webkit.WebView, com.baidu.webkit.sdk.WebViewProvider
    @TargetApi(11)
    public final void saveWebArchive(String str, boolean z, ValueCallback<String> valueCallback) {
        if (Build.VERSION.SDK_INT >= 11) {
            super.saveWebArchive(str, z, valueCallback);
        }
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void selectionDone() {
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void sendFeedback(String str, String str2) {
        Log.v("WebViewImpl", "[houyuqi-feedback] do not upload feedback in system webview");
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void setAutoShowTitlebar(boolean z) {
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void setBeginScale() {
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void setBottomControlsHeight(int i) {
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void setCanvasCacheBmp(Bitmap bitmap) {
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void setDefaultViewSize(int i, int i2) {
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void setEndScale() {
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    @TargetApi(16)
    public final void setFindListener(WebView.FindListener findListener) {
        if (Build.VERSION.SDK_INT >= 16) {
            setFindListener(findListener != null ? new FindAdapter(findListener) : null);
        }
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void setPageTransformer(boolean z, PageTransformer pageTransformer) {
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void setPauseSyncActions(boolean z) {
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void setPictureListener(WebView.PictureListener pictureListener) {
        setPictureListener(pictureListener != null ? new PictureAdapter(pictureListener) : null);
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final boolean setPreviewZoomScale(float f) {
        return false;
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final boolean setSelectingText(boolean z) {
        return false;
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void setStatusBar(View view, int i) {
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void setTextFieldText(CharSequence charSequence) {
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void setTopControlsHeight(int i, boolean z) {
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void setUserData(int i, int i2, Object obj) {
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void setVideoPlayerFactory(VideoPlayerFactory videoPlayerFactory) {
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void setWebChromeClient(WebChromeClient webChromeClient) {
        super.setWebChromeClient(webChromeClient == null ? null : new WebChromeClientWrapper(this, webChromeClient));
        this.mWebChromeClient = webChromeClient;
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(webViewClient == null ? null : new WebViewClientWrapper(this, webViewClient));
        this.mWebViewClient = webViewClient;
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void setWebViewMargin(int i, int i2, int i3, int i4) {
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void setWebViewPagerContainer(ViewGroup viewGroup) {
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void setWebViewPagerSize(int i, int i2) {
    }

    @Override // android.webkit.WebView, com.baidu.webkit.sdk.WebViewProvider
    @TargetApi(11)
    public final boolean showFindDialog(String str, boolean z) {
        if (Build.VERSION.SDK_INT >= 11) {
            return super.showFindDialog(str, z);
        }
        return false;
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void startLoadingAnimation(String str) {
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final int startPrerender(String str) {
        return -1;
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void stopPrerender() {
    }

    public final boolean super_onInterceptTouchEvent(MotionEvent motionEvent) {
        return super.onInterceptTouchEvent(motionEvent);
    }

    public final void super_onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.onOverScrolled(i, i2, z, z2);
    }

    public final void super_onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
    }

    public final boolean super_onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && !this.mWebView.isFocused()) {
            this.mWebView.requestFocus();
        }
        return super.onTouchEvent(motionEvent);
    }

    public final boolean super_performLongClick() {
        return super.performLongClick();
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void suspendScheduledTasks(String str) {
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void switchTitleBar(boolean z) {
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void updateTopControlOffset(int i) {
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void updateTopControlsState(boolean z, boolean z2, boolean z3) {
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    @TargetApi(21)
    public final boolean zoomByZeus(float f) {
        if (Build.VERSION.SDK_INT >= 21) {
            super.zoomBy(f);
            return true;
        }
        return false;
    }
}
