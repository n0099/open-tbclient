package com.baidu.webkit.sdk.system;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Message;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import com.baidu.webkit.sdk.WebChromeClient;
import com.baidu.webkit.sdk.system.GeolocationPermissionsImpl;
import com.baidu.webkit.sdk.system.WebStorageImpl;
import com.baidu.webkit.sdk.system.WebViewImpl;
/* loaded from: classes11.dex */
final class WebChromeClientWrapper extends WebChromeClient {
    static final /* synthetic */ boolean $assertionsDisabled;
    private final com.baidu.webkit.sdk.WebChromeClient mClient;
    private final WebViewImpl mWebView;

    /* loaded from: classes11.dex */
    private static class CustomViewCallbackImpl implements WebChromeClient.CustomViewCallback {
        private WebChromeClient.CustomViewCallback mCallback;

        private CustomViewCallbackImpl(WebChromeClient.CustomViewCallback customViewCallback) {
            this.mCallback = customViewCallback;
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient.CustomViewCallback
        public void onCustomViewHidden() {
            this.mCallback.onCustomViewHidden();
        }
    }

    @TargetApi(21)
    /* loaded from: classes11.dex */
    private static class FileChooserParamsImpl extends WebChromeClient.FileChooserParams {
        private final WebChromeClient.FileChooserParams mImpl;

        private FileChooserParamsImpl(WebChromeClient.FileChooserParams fileChooserParams) {
            this.mImpl = fileChooserParams;
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient.FileChooserParams
        public Intent createIntent() {
            return this.mImpl.createIntent();
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient.FileChooserParams
        public String[] getAcceptTypes() {
            return this.mImpl.getAcceptTypes();
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient.FileChooserParams
        public String getFilenameHint() {
            return this.mImpl.getFilenameHint();
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient.FileChooserParams
        public int getMode() {
            return this.mImpl.getMode();
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient.FileChooserParams
        public CharSequence getTitle() {
            return this.mImpl.getTitle();
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient.FileChooserParams
        public boolean isCaptureEnabled() {
            return this.mImpl.isCaptureEnabled();
        }
    }

    static {
        $assertionsDisabled = !WebChromeClientWrapper.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebChromeClientWrapper(WebViewImpl webViewImpl, com.baidu.webkit.sdk.WebChromeClient webChromeClient) {
        this.mClient = webChromeClient;
        this.mWebView = webViewImpl;
    }

    @Override // android.webkit.WebChromeClient
    public final Bitmap getDefaultVideoPoster() {
        return this.mClient.getDefaultVideoPoster();
    }

    @Override // android.webkit.WebChromeClient
    public final View getVideoLoadingProgressView() {
        return this.mClient.getVideoLoadingProgressView();
    }

    @Override // android.webkit.WebChromeClient
    public final void getVisitedHistory(ValueCallback<String[]> valueCallback) {
        this.mClient.getVisitedHistory(valueCallback);
    }

    @Override // android.webkit.WebChromeClient
    public final void onCloseWindow(WebView webView) {
        this.mClient.onCloseWindow(this.mWebView.getWebView());
    }

    @Override // android.webkit.WebChromeClient
    public final void onConsoleMessage(String str, int i, String str2) {
        this.mClient.onConsoleMessage(str, i, str2);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        return this.mClient.onConsoleMessage(consoleMessage);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        if ($assertionsDisabled || message != null) {
            if ($assertionsDisabled || message.obj != null) {
                WebViewImpl webViewImpl = this.mWebView;
                webViewImpl.getClass();
                message.obj = new WebViewImpl.WebViewTransportImpl(this.mWebView.getWebView(), (WebView.WebViewTransport) message.obj);
                boolean onCreateWindow = this.mClient.onCreateWindow(this.mWebView.getWebView(), z, z2, message);
                message.obj = (WebView.WebViewTransport) message.obj;
                return onCreateWindow;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    @Override // android.webkit.WebChromeClient
    public final void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
        this.mClient.onExceededDatabaseQuota(str, str2, j, j2, j3, quotaUpdater == null ? null : new WebStorageImpl.QuotaUpdater(quotaUpdater));
    }

    @Override // android.webkit.WebChromeClient
    public final void onGeolocationPermissionsHidePrompt() {
        this.mClient.onGeolocationPermissionsHidePrompt();
    }

    @Override // android.webkit.WebChromeClient
    public final void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        this.mClient.onGeolocationPermissionsShowPrompt(str, callback == null ? null : new GeolocationPermissionsImpl.CallbackWrapper(callback));
    }

    @Override // android.webkit.WebChromeClient
    public final void onHideCustomView() {
        this.mClient.onHideCustomView();
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return this.mClient.onJsAlert(this.mWebView.getWebView(), str, str2, Glue.cast(jsResult));
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        return this.mClient.onJsBeforeUnload(this.mWebView.getWebView(), str, str2, Glue.cast(jsResult));
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        return this.mClient.onJsConfirm(this.mWebView.getWebView(), str, str2, Glue.cast(jsResult));
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return this.mClient.onJsPrompt(this.mWebView.getWebView(), str, str2, str3, Glue.cast(jsPromptResult));
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsTimeout() {
        return this.mClient.onJsTimeout();
    }

    @Override // android.webkit.WebChromeClient
    public final void onPermissionRequest(PermissionRequest permissionRequest) {
        this.mClient.onPermissionRequest(PermissionRequestImpl.from(permissionRequest));
    }

    @Override // android.webkit.WebChromeClient
    public final void onPermissionRequestCanceled(PermissionRequest permissionRequest) {
        this.mClient.onPermissionRequestCanceled(PermissionRequestImpl.from(permissionRequest));
    }

    @Override // android.webkit.WebChromeClient
    public final void onProgressChanged(WebView webView, int i) {
        if (!$assertionsDisabled && webView != this.mWebView) {
            throw new AssertionError();
        }
        this.mClient.onProgressChanged(this.mWebView.getWebView(), i);
    }

    @Override // android.webkit.WebChromeClient
    public final void onReachedMaxAppCacheSize(long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
        this.mClient.onReachedMaxAppCacheSize(j, j2, quotaUpdater == null ? null : new WebStorageImpl.QuotaUpdater(quotaUpdater));
    }

    @Override // android.webkit.WebChromeClient
    public final void onReceivedIcon(WebView webView, Bitmap bitmap) {
        if (!$assertionsDisabled && webView != this.mWebView) {
            throw new AssertionError();
        }
        this.mClient.onReceivedIcon(this.mWebView.getWebView(), bitmap);
    }

    @Override // android.webkit.WebChromeClient
    public final void onReceivedTitle(WebView webView, String str) {
        if (!$assertionsDisabled && webView != this.mWebView) {
            throw new AssertionError();
        }
        this.mClient.onReceivedTitle(this.mWebView.getWebView(), str);
    }

    @Override // android.webkit.WebChromeClient
    public final void onReceivedTouchIconUrl(WebView webView, String str, boolean z) {
        if (!$assertionsDisabled && webView != this.mWebView) {
            throw new AssertionError();
        }
        this.mClient.onReceivedTouchIconUrl(this.mWebView.getWebView(), str, z);
    }

    @Override // android.webkit.WebChromeClient
    public final void onRequestFocus(WebView webView) {
        this.mClient.onRequestFocus(this.mWebView.getWebView());
    }

    @Override // android.webkit.WebChromeClient
    public final void onShowCustomView(View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
        this.mClient.onShowCustomView(view, i, customViewCallback != null ? new CustomViewCallbackImpl(customViewCallback) : null);
    }

    @Override // android.webkit.WebChromeClient
    public final void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        this.mClient.onShowCustomView(view, customViewCallback != null ? new CustomViewCallbackImpl(customViewCallback) : null);
    }

    @Override // android.webkit.WebChromeClient
    @TargetApi(21)
    public final boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        return this.mClient.onShowFileChooser(this.mWebView.getWebView(), valueCallback, fileChooserParams != null ? new FileChooserParamsImpl(fileChooserParams) : null);
    }

    public final void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
        this.mClient.openFileChooser(valueCallback, str, str2);
    }

    public final void setupAutoFill(Message message) {
        this.mClient.setupAutoFill(message);
    }
}
