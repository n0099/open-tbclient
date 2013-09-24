package com.baidu.zeus;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Message;
import android.util.Log;
import android.view.View;
import com.baidu.zeus.GeolocationPermissions;
import com.baidu.zeus.WebStorage;
/* loaded from: classes.dex */
public class WebChromeClient {
    public static final int STRING_CANCEL = 6;
    public static final int STRING_DLG_BTN_CANCEL = 151;
    public static final int STRING_DLG_BTN_CLEAR = 152;
    public static final int STRING_DLG_BTN_SET = 150;
    public static final int STRING_DLG_TITLE_COLOR = 105;
    public static final int STRING_DLG_TITLE_DATE = 100;
    public static final int STRING_DLG_TITLE_DATETIME = 101;
    public static final int STRING_DLG_TITLE_MONTH = 103;
    public static final int STRING_DLG_TITLE_TIME = 104;
    public static final int STRING_DLG_TITLE_WEEK = 102;
    public static final int STRING_RADIO_BOX = 5;
    public static final int STRING_SAVE_PASSWORD_LABEL = 0;
    public static final int STRING_SAVE_PASSWORD_MESSAGE = 1;
    public static final int STRING_SAVE_PASSWORD_NEVER = 4;
    public static final int STRING_SAVE_PASSWORD_NONOW = 2;
    public static final int STRING_SAVE_PASSWORD_REMEMBER = 3;
    public static final int STRING_WEBAPP_ERROR = 7;

    /* loaded from: classes.dex */
    public interface CustomViewCallback {
        void onCustomViewHidden();
    }

    public void onNativeElementEnterFullScreen() {
    }

    public void onNativeElementExitFullScreen() {
    }

    public boolean needNotifyNativeExitFullScreen() {
        return false;
    }

    public void onProgressChanged(WebView webView, int i) {
    }

    public void onReceivedTitle(WebView webView, String str) {
    }

    public void onSetLoadURL(WebView webView, String str) {
    }

    public void onReceivedIcon(WebView webView, Bitmap bitmap) {
    }

    public void onReceivedTouchIconUrl(WebView webView, String str, boolean z) {
    }

    public void onShowCustomView(View view, CustomViewCallback customViewCallback) {
    }

    public void onShowCustomView(View view, int i, CustomViewCallback customViewCallback) {
    }

    public void onHideCustomView() {
    }

    public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        return false;
    }

    public void onRequestFocus(WebView webView) {
    }

    public void onCloseWindow(WebView webView) {
    }

    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return false;
    }

    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        return false;
    }

    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return false;
    }

    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        return false;
    }

    public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
        quotaUpdater.updateQuota(j);
    }

    public void onReachedMaxAppCacheSize(long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
        quotaUpdater.updateQuota(0L);
    }

    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
    }

    public void onGeolocationPermissionsHidePrompt() {
    }

    public boolean onJsTimeout() {
        return true;
    }

    @Deprecated
    public void onConsoleMessage(String str, int i, String str2) {
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        onConsoleMessage(consoleMessage.message(), consoleMessage.lineNumber(), consoleMessage.sourceId());
        return false;
    }

    public Bitmap getDefaultVideoPoster() {
        return null;
    }

    public View getVideoLoadingProgressView() {
        return null;
    }

    public void getVisitedHistory(ValueCallback<String[]> valueCallback) {
    }

    public String getStringById(int i) {
        return null;
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback) {
        valueCallback.onReceiveValue(null);
    }

    public void ShowSelectionActionDialog(WebView webView, int i, int i2, int i3, int i4, String str) {
        Log.e("chrome", "ShowSelectionActionDialog top:" + i + "bottom: " + i2 + "text: " + str);
    }

    public void HideSelectionActionDialog(WebView webView) {
        Log.e("chrome", "HideSelectionActionDialog");
    }

    public void PerformLongClick(WebView webView, int i, String str, String str2, int i2, int i3) {
        Log.e("chrome", "PerformLongClick type: " + i + " extra: " + str + " extra2: " + str2 + "x: " + i2 + " y: " + i3);
    }

    public void showMagnifier(WebView webView, int i, int i2, int i3, int i4) {
    }

    public void moveMagnifier(WebView webView, int i, int i2, int i3, int i4) {
    }

    public void hideMagnifier(WebView webView, int i, int i2) {
    }

    public void copyText(WebView webView, String str) {
        Log.e("chromeclient", "text: " + str);
    }

    public void notifyClientStatus(WebView webView, int i) {
        Log.e("chromeclient", "notifyClientStatus: " + i);
    }

    public void notifyClickWhenLoad() {
        Log.e("chromeclient", "notifyClickWhenLoad");
    }
}
