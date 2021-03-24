package com.baidu.webkit.sdk;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.SslErrorHandler;
import com.baidu.webkit.internal.b.a;
import com.baidu.webkit.internal.b.b;
import com.baidu.webkit.internal.b.f;
import com.baidu.webkit.internal.b.g;
import com.baidu.webkit.internal.b.h;
import com.baidu.webkit.internal.b.i;
import com.baidu.webkit.internal.b.j;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class WebViewClient {
    public static final int ERROR_AUTHENTICATION = -4;
    public static final int ERROR_BAD_URL = -12;
    public static final int ERROR_CONNECT = -6;
    public static final int ERROR_FAILED_SSL_HANDSHAKE = -11;
    public static final int ERROR_FILE = -13;
    public static final int ERROR_FILE_NOT_FOUND = -14;
    public static final int ERROR_HOST_LOOKUP = -2;
    public static final int ERROR_IO = -7;
    public static final int ERROR_PROXY_AUTHENTICATION = -5;
    public static final int ERROR_REDIRECT_LOOP = -9;
    public static final int ERROR_TIMEOUT = -8;
    public static final int ERROR_TOO_MANY_REQUESTS = -15;
    public static final int ERROR_UNKNOWN = -1;
    public static final int ERROR_UNSUPPORTED_AUTH_SCHEME = -3;
    public static final int ERROR_UNSUPPORTED_SCHEME = -10;
    public static final String LOG_TAG = "WebViewClient";
    public static final String SCHEMA_HTTP = "http://";
    public static final String SCHEMA_HTTPS = "https://";
    public static final String TAG = "WebViewClient";
    public List<j> mUrlHandlers = new ArrayList();

    /* loaded from: classes5.dex */
    public enum InteractionType {
        INPUT,
        CONTENT_CHANGE,
        FORM_SUBMIT,
        OTHERS
    }

    /* loaded from: classes5.dex */
    public static class SecurityInfo {
        public WebSiteInfo info;
        public SecurityLevel level = SecurityLevel.UNCERTAIN;

        public SecurityLevel getSecurityLevel() {
            return this.level;
        }

        public WebSiteInfo getWebSiteInfo() {
            return this.info;
        }

        public void setSecurityLevel(SecurityLevel securityLevel) {
            this.level = securityLevel;
        }

        public void setWebSiteInfo(WebSiteInfo webSiteInfo) {
            this.info = webSiteInfo;
        }
    }

    /* loaded from: classes5.dex */
    public enum SecurityLevel {
        SECURE,
        DANGEROUS,
        UNCERTAIN,
        FORBIDDEN,
        FAKE_BAIDU,
        FAKE_SITE,
        MALCIOUS_RESOURCE,
        DEFAULT
    }

    /* loaded from: classes5.dex */
    public static class WebSiteInfo {
        public String name;
        public WebSiteType type;

        public WebSiteInfo(WebSiteType webSiteType, String str) {
            this.type = WebSiteType.UNCERTAIN;
            this.type = webSiteType;
            this.name = str;
        }

        public String getWebSiteName() {
            return this.name;
        }

        public WebSiteType getWebSiteType() {
            return this.type;
        }
    }

    /* loaded from: classes5.dex */
    public enum WebSiteType {
        BANK,
        PAYMENT,
        EBUSINESS,
        FAKEBAIDU,
        UNCERTAIN,
        PHONE_STATE,
        EVIL_DOWNLOAD,
        DEFAULT
    }

    /* loaded from: classes5.dex */
    public interface ZeusVideoInfoDelegate {
        void notifyUpdateVideoInfo(String str);
    }

    public WebViewClient() {
        addUrlHandler(new f());
        addUrlHandler(new b());
        addUrlHandler(new g());
        addUrlHandler(new i());
        addUrlHandler(new a());
        addUrlHandler(new h());
    }

    public void AntiHijackSign(WebView webView, String str) {
    }

    public void addUrlHandler(j jVar) {
        if (jVar != null) {
            this.mUrlHandlers.add(jVar);
        }
    }

    public boolean canHandleImage(WebView webView, String str, String str2, String str3) {
        return false;
    }

    public int computeHookH5NavigationStep(int i) {
        return i;
    }

    public void doUpdateVisitedHistory(WebView webView, String str, boolean z, boolean z2, boolean z3, boolean z4) {
    }

    public void onAbortResourceRequest(WebView webView, String str, String str2, long j) {
    }

    public void onBaiduSearchPVCollected(WebView webView) {
    }

    public void onCancel(WebView webView) {
    }

    public void onCheckHasManifestAndServiceWorker(WebView webView, String str, String str2, boolean z) {
    }

    public void onDiTingUploadFeatures(WebView webView, String str, String str2, String str3) {
    }

    public void onDidAsyncWiseSearchStatusChanged(WebView webView, String str, int i, long j) {
    }

    public void onDisplaySoftKeyboard(WebView webView) {
    }

    public void onDownloadStart(WebView webView, String str) {
    }

    public void onFirstContentfulPaint(WebView webView, String str) {
    }

    public void onFirstDrawnDid(WebView webView, String str) {
    }

    public void onFirstImagePaint(WebView webView, String str) {
    }

    public void onFirstLayoutDid(WebView webView, String str) {
    }

    public void onFirstMeaningfulPaint(WebView webView, String str) {
    }

    public void onFirstPaintDid(WebView webView, String str) {
    }

    public void onFirstScreenPaintFinished(WebView webView, String str, int i, int i2, int i3, int i4, int i5) {
    }

    public void onFirstTextPaint(WebView webView, String str) {
    }

    public void onFormResubmission(WebView webView, Message message, Message message2) {
        message.sendToTarget();
    }

    public void onFullScreenMode(WebView webView, boolean z, int i, int i2) {
    }

    public void onGestureFlingEnded(WebView webView, int i, int i2) {
    }

    public void onGestureScrollEnded(WebView webView, int i, int i2) {
    }

    public void onGestureScrollStarted(WebView webView, int i, int i2) {
    }

    public String onGetErrorContent(WebView webView, int i, String str, String str2) {
        return null;
    }

    public void onGoBackOrForward(WebView webView, int i) {
    }

    public void onGoBackOrForwardAnimationFinish(WebView webView, int i) {
    }

    public void onGoBackOrForwardAnimationStart(WebView webView, int i) {
    }

    public void onGotNotResponse(WebView webView) {
    }

    public void onHandleBackForwardBeyondHistory(int i) {
    }

    public void onHasVideo(WebView webView) {
    }

    public void onHideSoftKeyboard(WebView webView) {
    }

    public void onHyperLink(WebView webView, String str, String str2) {
    }

    public void onJsJumpDid(WebView webView, String str) {
    }

    public void onKeywordExtension(WebView webView, String str, String str2) {
    }

    public void onLoadResource(WebView webView, String str) {
    }

    public void onMagicFilterAbortResourceRequest(String str, String str2, boolean z) {
    }

    public void onMagicFilterHideElement(WebView webView, String str, int i, int i2, int i3, int i4, int i5) {
    }

    public void onMainActionsCollected(WebView webView, boolean z, int i) {
    }

    public void onMainResourceHttpcodeDid(WebView webView, int i, String str) {
    }

    public void onMainResourceIdDid(WebView webView, int i) {
    }

    public void onMainResourceNetcodeDid(WebView webView, int i) {
    }

    public void onMainResourceResponseDid(WebView webView, String str) {
    }

    public void onManifestChanged(WebView webView) {
    }

    public void onNavigationAnimationFinish(WebView webView) {
    }

    public void onNavigationAnimationFinish(WebView webView, boolean z, boolean z2) {
    }

    public void onNavigationAnimationStart(WebView webView) {
    }

    public void onNavigationAnimationStart(WebView webView, boolean z) {
    }

    public void onNewHistoryItem(WebView webView, String str, int i) {
    }

    public void onPageCanBeScaled(WebView webView, boolean z) {
    }

    public void onPageCommitVisible(WebView webView, String str, boolean z) {
    }

    public void onPageFinished(WebView webView, String str) {
        if (webView == null || !webView.getContext().getPackageName().contains("com.baidu.searchbox")) {
            return;
        }
        webView.getSecureProcessor().c();
    }

    public void onPageLoadTime(WebView webView, String str, long j) {
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        if (webView == null || !webView.getContext().getPackageName().contains("com.baidu.searchbox")) {
            return;
        }
        webView.getSecureProcessor().c();
    }

    public void onPageSwitching(WebView webView) {
    }

    public void onPageWithHSTSDid(String str, int i, boolean z) {
    }

    public void onPausePlugin() {
    }

    public void onPlayPlugin() {
    }

    public void onPreloadUrlFound(WebView webView, String str) {
    }

    public void onProceededAfterSslError(WebView webView, SslError sslError) {
    }

    public String onProcessWebSearchUrl(WebView webView, String str) {
        return null;
    }

    public void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest) {
        clientCertRequest.cancel();
    }

    public void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest, String str) {
        onReceivedClientCertRequest(webView, clientCertRequest);
    }

    @Deprecated
    public void onReceivedError(WebView webView, int i, String str, String str2) {
    }

    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
    }

    public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        httpAuthHandler.cancel();
    }

    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
    }

    public void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
    }

    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        sslErrorHandler.cancel();
    }

    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        return false;
    }

    public void onResourceLoaded(WebView webView, String str, long j, String str2, String str3, int i) {
    }

    public void onRestoreFromCache(WebView webView, String str) {
    }

    public void onRestoreFromPageCacheDid(WebView webView, String str) {
    }

    public void onResumePlugin() {
    }

    public void onScaleChanged(WebView webView, float f2, float f3) {
    }

    public void onSearchLandingPageClicked(WebView webView, String str, String str2, long j) {
    }

    public void onSecurityCheckResult(WebView webView, String str, SecurityInfo securityInfo) {
    }

    public void onStartFirstNavigation(WebView webView, String str, boolean z, boolean z2, boolean z3) {
    }

    public boolean onSubFrameBeforeRequest(WebView webView, String str) {
        return false;
    }

    public void onSubjectsCollected(WebView webView, boolean z, int i) {
    }

    public boolean onSupportsForceZoomScale(WebView webView) {
        return false;
    }

    public boolean onTextCopied(WebView webView) {
        return false;
    }

    public void onThemeColorChanged(WebView webView, int i) {
    }

    @Deprecated
    public void onTooManyRedirects(WebView webView, Message message, Message message2) {
        message.sendToTarget();
    }

    public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
    }

    public void onUpdateTextFieldNextPreStatus(WebView webView, boolean z, boolean z2) {
    }

    public void onUrlRedirectedDid(WebView webView, String str, String str2, int i) {
    }

    public void onUserInteraction(WebView webView, String str, InteractionType interactionType) {
    }

    public void removeUrlHander(j jVar) {
        if (jVar != null) {
            this.mUrlHandlers.remove(jVar);
        }
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        return shouldInterceptRequest(webView, webResourceRequest.getUrl().toString());
    }

    @Deprecated
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return null;
    }

    public boolean shouldKeywordExtension(WebView webView, String str) {
        return true;
    }

    public boolean shouldLoadInNewWebView(WebView webView, String str) {
        return false;
    }

    public boolean shouldOpenFlash(WebView webView, String str) {
        return false;
    }

    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        return false;
    }

    public boolean shouldOverrideSpecialUrlLoading(WebView webView, String str) {
        return false;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        return shouldOverrideUrlLoading(webView, webResourceRequest.getUrl().toString());
    }

    @Deprecated
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        for (j jVar : this.mUrlHandlers) {
            if (jVar.a(webView.getContext(), str)) {
                return true;
            }
        }
        return false;
    }

    public void shouldPageRollBack(WebView webView, String str) {
    }

    public boolean shouldShowSubject(WebView webView, String str, String str2, String str3) {
        return false;
    }
}
