package com.baidu.webkit.sdk;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.webkit.internal.utils.CommonUtils;
import com.baidu.webkit.sdk.GeolocationPermissions;
import com.baidu.webkit.sdk.WebStorage;
import com.baidu.webkit.sdk.WebView;
import com.baidu.webkit.sdk.jschecker.BdJsCallInfo;
import com.baidu.webkit.sdk.jschecker.BdJsCheckPolicy;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class WebChromeClient {
    public static final String DEFAULT_ERROR_IMAGE_PATH = "file:///android_asset/webkit/errorpage/images/error_page.png";
    protected static final int ERROR_CODE_FUNCTION_CALL_FAILED = 100;
    protected static final int ERROR_CODE_FUNCTION_NOT_FOUND = 102;
    protected static final int ERROR_CODE_INTERFACE_NOT_FOUND = 101;
    protected static final int ERROR_CODE_OK = 0;
    protected static final String JIS_NAME = "FLYFLOW-JSI:";
    protected static final String JIS_NAME_NEW = "flyflow://";
    protected static final String KEY_ARG_ARRAY = "args";
    protected static final String KEY_ARG_CALLBACK = "callback";
    protected static final String KEY_FUNCTION_NAME = "func";
    protected static final String KEY_INTERFACE_NAME = "obj";
    private static final String MSG_METHOD_GETVERSION = "getVersion";
    protected static final String PARAM_SEPARATOR = "\\|";
    private WebView mWebView;
    private static final boolean DEBUG = Log.isDebug();
    private static final String LOG_TAG = WebChromeClient.class.getSimpleName();
    protected static final String MSG_PROMPT_HEADER = "BdboxApp:";
    protected static final String MSG_PROMPT_HEADER_IMPACT = MSG_PROMPT_HEADER.toLowerCase();

    /* loaded from: classes14.dex */
    public interface CustomViewCallback {
        void onCustomViewHidden();
    }

    /* loaded from: classes14.dex */
    public static abstract class FileChooserParams {
        public static final int MODE_OPEN = 0;
        public static final int MODE_OPEN_FOLDER = 2;
        public static final int MODE_OPEN_MULTIPLE = 1;
        public static final int MODE_SAVE = 3;

        public static Uri[] parseResult(int i, Intent intent) {
            return WebViewFactory.getProvider().getStatics().parseFileChooserResult(i, intent);
        }

        public abstract Intent createIntent();

        public abstract String[] getAcceptTypes();

        public abstract String getFilenameHint();

        public abstract int getMode();

        public abstract CharSequence getTitle();

        public abstract boolean isCaptureEnabled();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void doJsCheckIfNeeded(BdJsCallInfo bdJsCallInfo) {
        BdJsCheckPolicy bdJsCheckPolicy;
        if (bdJsCallInfo == null) {
            return;
        }
        BdJsCheckPolicy bdJsCheckPolicy2 = null;
        try {
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
        } catch (Throwable th) {
            Log.e(Log.LOG_TAG, "setDefaultEnableJsPromptSailor error:" + th);
        }
        if (WebViewFactory.hasProvider()) {
            Object staticWebSeting = WebViewFactory.getProvider().getStaticWebSeting(WebViewFactoryProvider.SETTING_JS_CHECK_POLICY);
            if (staticWebSeting instanceof BdJsCheckPolicy) {
                bdJsCheckPolicy = (BdJsCheckPolicy) staticWebSeting;
                bdJsCheckPolicy2 = bdJsCheckPolicy;
                if (DEBUG) {
                    Log.d(LOG_TAG, "doJsCheckIfNeeded() jsCallInfo: " + bdJsCallInfo + " ,policy:" + bdJsCheckPolicy2);
                }
                if (bdJsCheckPolicy2 == null) {
                    if (bdJsCallInfo.hasFinishedPermissionCheck()) {
                        bdJsCheckPolicy2.onJsCheckFinished(bdJsCallInfo);
                        return;
                    } else {
                        bdJsCheckPolicy2.onJsCheckUnFinished(bdJsCallInfo);
                        return;
                    }
                }
                return;
            }
        }
        bdJsCheckPolicy = null;
        bdJsCheckPolicy2 = bdJsCheckPolicy;
        if (DEBUG) {
        }
        if (bdJsCheckPolicy2 == null) {
        }
    }

    private Method getBdJsCallMethod(Object obj, String str, Class[] clsArr) {
        Class<?>[] clsArr2;
        if (obj == null || TextUtils.isEmpty(str)) {
            return null;
        }
        if (clsArr != null) {
            clsArr2 = new Class[clsArr.length + 1];
            System.arraycopy(clsArr, 0, clsArr2, 1, clsArr.length);
        } else {
            clsArr2 = new Class[1];
        }
        clsArr2[0] = BdJsCallInfo.class;
        try {
            return obj.getClass().getMethod(str, clsArr2);
        } catch (Exception e) {
            if (DEBUG) {
                Log.e(LOG_TAG, e.toString());
            }
            return null;
        }
    }

    private Class getClassFromJsonObject(Object obj) {
        Class<?> cls = obj.getClass();
        return cls == Integer.class ? Integer.TYPE : cls == Boolean.class ? Boolean.TYPE : String.class;
    }

    private String getReturnValueInJSON(int i, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(BdStatsConstant.StatsType.ERROR, i);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("msg", str);
            }
            if (i == 0 && str2 != null) {
                jSONObject.put("result", str2);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e(LOG_TAG, e.toString());
            }
        }
        return jSONObject.toString();
    }

    private boolean handleGetVersionMessage(String str) {
        if (TextUtils.isEmpty(str) || !str.startsWith(MSG_PROMPT_HEADER)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str.substring(9));
            String optString = jSONObject.optString(KEY_FUNCTION_NAME);
            String optString2 = jSONObject.optString("callback");
            if (!MSG_METHOD_GETVERSION.equals(optString) || TextUtils.isEmpty(optString2) || this.mWebView == null) {
                return false;
            }
            this.mWebView.execJavaScriptExt(optString2 + "(" + CommonUtils.getVersionName(this.mWebView.getContext()) + ")", new String[0]);
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:90:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x026f  */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean invokeJSInterfaceMethod(WebView webView, JsPromptResult jsPromptResult, boolean z, String str, String str2, Object[] objArr) {
        Object invoke;
        Object obj = webView.getSecureProcessor().d().get(str);
        if (obj == null) {
            if (DEBUG) {
                Log.e(LOG_TAG, "not exist js interface:" + str);
            }
            if (z) {
                jsPromptResult.confirm(getReturnValueInJSON(101, "interface:" + str + " not found!", null));
            } else {
                jsPromptResult.cancel();
            }
            return true;
        } else if (objArr == null && str2 == null) {
            if (DEBUG) {
                Log.d(LOG_TAG, "interface query: found for " + str);
            }
            if (z) {
                jsPromptResult.confirm(getReturnValueInJSON(0, "interface:" + str + " found!", Boolean.TRUE.toString()));
            } else {
                jsPromptResult.cancel();
            }
            return true;
        } else {
            Class<?>[] clsArr = null;
            int length = objArr != null ? objArr.length : 0;
            if (length > 0) {
                clsArr = new Class[length];
                for (int i = 0; i < length; i++) {
                    clsArr[i] = getClassFromJsonObject(objArr[i]);
                    if (DEBUG) {
                        Log.d(LOG_TAG, "type:" + clsArr[i].getName());
                    }
                }
            }
            boolean z2 = true;
            try {
                Method bdJsCallMethod = getBdJsCallMethod(obj, str2, clsArr);
                if (bdJsCallMethod == null) {
                    z2 = false;
                    bdJsCallMethod = obj.getClass().getMethod(str2, clsArr);
                }
                if (((JavascriptInterface) bdJsCallMethod.getAnnotation(JavascriptInterface.class)) == null) {
                    if (DEBUG) {
                        Log.e(LOG_TAG, "function has no @JavascriptInterface");
                        return false;
                    }
                    if (z) {
                        jsPromptResult.confirm(getReturnValueInJSON(100, str2 + " is protected from JS calling!", null));
                    } else {
                        jsPromptResult.cancel();
                    }
                    return true;
                }
                if (z2) {
                    BdJsCallInfo bdJsCallInfo = new BdJsCallInfo();
                    bdJsCallInfo.setWebViewFrameName(webView.getSettings().getWebViewFrameName());
                    bdJsCallInfo.setUrl(webView.getUrl());
                    bdJsCallInfo.setJsInterfaceName(str);
                    bdJsCallInfo.setJsMethodName(str2);
                    bdJsCallInfo.setJsMethodDeclaration(bdJsCallMethod.toString());
                    Object invokeBdJsCallMethod = invokeBdJsCallMethod(bdJsCallMethod, obj, bdJsCallInfo, objArr);
                    doJsCheckIfNeeded(bdJsCallInfo);
                    invoke = invokeBdJsCallMethod;
                } else {
                    invoke = bdJsCallMethod.invoke(obj, objArr);
                }
                String obj2 = invoke == null || invoke.getClass() == Void.TYPE ? "" : invoke.toString();
                if (DEBUG) {
                    Log.d(LOG_TAG, "called ok: " + obj2);
                }
                if (z) {
                    jsPromptResult.confirm(getReturnValueInJSON(0, null, obj2));
                } else {
                    jsPromptResult.confirm(obj2);
                }
                return true;
            } catch (IllegalAccessException e) {
                if (DEBUG) {
                    Log.e(LOG_TAG, e.toString());
                    return false;
                }
                if (z) {
                    jsPromptResult.confirm(getReturnValueInJSON(100, str2 + " call failed!", null));
                } else {
                    jsPromptResult.cancel();
                }
                return true;
            } catch (IllegalArgumentException e2) {
                if (DEBUG) {
                    Log.e(LOG_TAG, e2.toString());
                    return false;
                }
                if (z) {
                }
                return true;
            } catch (NoSuchMethodException e3) {
                if (DEBUG) {
                    StringBuilder sb = new StringBuilder(str2);
                    sb.append("(");
                    if (length > 0) {
                        sb.append("'");
                        sb.append(objArr[0]);
                        sb.append("'");
                        for (int i2 = 1; i2 < length; i2++) {
                            sb.append(",'");
                            sb.append(objArr[i2]);
                            sb.append("'");
                        }
                    }
                    sb.append(")");
                    Log.e(LOG_TAG, "obj has no function:" + sb.toString());
                }
                if (z) {
                    jsPromptResult.confirm(getReturnValueInJSON(102, str2 + " not found, check the method name or arguments.", null));
                } else {
                    jsPromptResult.cancel();
                }
                return true;
            } catch (InvocationTargetException e4) {
                if (DEBUG) {
                    Log.e(LOG_TAG, e4.toString());
                    return false;
                }
                if (z) {
                }
                return true;
            }
        }
    }

    public void copyText(WebView webView, String str) {
    }

    public void doTextSearch(WebView webView, String str) {
    }

    public void doTextTranslate(WebView webView, String str) {
    }

    public Bitmap getDefaultVideoPoster() {
        return null;
    }

    public View getVideoLoadingProgressView() {
        return null;
    }

    public void getVisitedHistory(ValueCallback<String[]> valueCallback) {
    }

    public boolean handleJavascriptInterface(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        String substring;
        boolean z;
        Object[] objArr = null;
        if (DEBUG) {
            Log.d(LOG_TAG, "handle url: " + str);
            Log.i(LOG_TAG, "handle msg: " + str2);
        }
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        if (str2.startsWith(MSG_PROMPT_HEADER)) {
            substring = str2.substring(9);
            z = true;
        } else if (!str2.startsWith(MSG_PROMPT_HEADER_IMPACT)) {
            return false;
        } else {
            substring = str2.substring(MSG_PROMPT_HEADER_IMPACT.length());
            z = false;
        }
        try {
            JSONObject jSONObject = new JSONObject(substring);
            String string = jSONObject.getString(KEY_INTERFACE_NAME);
            String optString = jSONObject.optString(KEY_FUNCTION_NAME, null);
            JSONArray optJSONArray = jSONObject.optJSONArray(KEY_ARG_ARRAY);
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                objArr = new Object[length];
                for (int i = 0; i < length; i++) {
                    objArr[i] = optJSONArray.get(i);
                }
                if (DEBUG) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(string).append(".").append(optString).append("(");
                    if (length > 0) {
                        sb.append("\"");
                        sb.append(objArr[0]);
                        sb.append("\"");
                        for (int i2 = 1; i2 < length; i2++) {
                            sb.append(",\"");
                            sb.append(objArr[i2]);
                            sb.append("\"");
                        }
                    }
                    sb.append(")");
                    Log.d(LOG_TAG, "call: " + sb.toString());
                }
            }
            return invokeJSInterfaceMethod(webView, jsPromptResult, z, string, optString, objArr);
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e(LOG_TAG, e.toString());
                return false;
            }
            jsPromptResult.cancel();
            return true;
        }
    }

    public void hideMagnifier(WebView webView, int i, int i2) {
    }

    public void hideSelectionActionDialog(WebView webView) {
    }

    public Object invokeBdJsCallMethod(Method method, Object obj, BdJsCallInfo bdJsCallInfo, Object[] objArr) throws InvocationTargetException, IllegalAccessException {
        Object[] objArr2;
        if (objArr != null) {
            objArr2 = new Object[objArr.length + 1];
            System.arraycopy(objArr, 0, objArr2, 1, objArr.length);
        } else {
            objArr2 = new Object[1];
        }
        objArr2[0] = bdJsCallInfo;
        return method.invoke(obj, objArr2);
    }

    public void moveMagnifier(WebView webView, int i, int i2, int i3, int i4) {
    }

    public boolean needNotifyNativeExitFullScreen() {
        return false;
    }

    public void notifyClickWhenLoad() {
    }

    public void notifyClientStatus(WebView webView, int i) {
    }

    public void onCloseWindow(WebView webView) {
    }

    @Deprecated
    public void onConsoleMessage(String str, int i, String str2) {
        if (handleGetVersionMessage(str)) {
        }
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String message = consoleMessage.message();
        Log.d(LOG_TAG, message);
        if (TextUtils.isEmpty(message) || !handleGetVersionMessage(message)) {
            onConsoleMessage(consoleMessage.message(), consoleMessage.lineNumber(), consoleMessage.sourceId());
            return false;
        }
        return true;
    }

    public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        return false;
    }

    @Deprecated
    public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
        quotaUpdater.updateQuota(j);
    }

    public void onGeolocationPermissionsHidePrompt() {
    }

    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
    }

    public void onHideCustomView() {
    }

    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return false;
    }

    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        return false;
    }

    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        return false;
    }

    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        Log.d(LOG_TAG, "onJsPrompt url = " + str + ", " + str2 + ", " + str3);
        return !TextUtils.isEmpty(str2) && handleJavascriptInterface(webView, str, str2, str3, jsPromptResult);
    }

    @Deprecated
    public boolean onJsTimeout() {
        return true;
    }

    public void onNativeElementEnterFullScreen() {
    }

    public void onNativeElementExitFullScreen() {
    }

    public void onOffsetsForFullscreenChanged(float f, float f2, float f3) {
    }

    public void onPermissionRequest(PermissionRequest permissionRequest) {
        if (permissionRequest.defaultHandler()) {
            return;
        }
        permissionRequest.deny();
    }

    public void onPermissionRequestCanceled(PermissionRequest permissionRequest) {
    }

    public void onPrerenderChanged(int i, WebView.PrerenderStatus prerenderStatus) {
    }

    public void onProgressChanged(WebView webView, int i) {
    }

    @Deprecated
    public void onReachedMaxAppCacheSize(long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
        quotaUpdater.updateQuota(j2);
    }

    public void onReceivedIcon(WebView webView, Bitmap bitmap) {
    }

    public void onReceivedTitle(WebView webView, String str) {
    }

    public void onReceivedTouchIconUrl(WebView webView, String str, boolean z) {
    }

    public void onRequestFocus(WebView webView) {
    }

    public void onSetLoadURL(WebView webView, String str) {
    }

    @Deprecated
    public void onShowCustomView(View view, int i, CustomViewCallback customViewCallback) {
    }

    public void onShowCustomView(View view, CustomViewCallback customViewCallback) {
    }

    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, FileChooserParams fileChooserParams) {
        return false;
    }

    @Deprecated
    public void openFileChooser(ValueCallback<Uri> valueCallback) {
        openFileChooser(valueCallback, null, null);
    }

    @Deprecated
    public void openFileChooser(ValueCallback<Uri> valueCallback, String str) {
        openFileChooser(valueCallback, str, null);
    }

    @Deprecated
    public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
        valueCallback.onReceiveValue(null);
    }

    public void performLongClick(WebView webView, int i, String str, String str2, int i2, int i3) {
        webView.mHasPerformedLongPress = true;
    }

    public void performLongClick(WebView webView, WebView.HitTestResult hitTestResult, int i, int i2) {
        webView.mHasPerformedLongPress = true;
    }

    public void setInstallableWebApp() {
    }

    public void setWebView(WebView webView) {
        this.mWebView = webView;
    }

    public void setupAutoFill(Message message) {
    }

    public void showMagnifier(WebView webView, int i, int i2, int i3, int i4) {
    }

    public void showSelectionActionDialog(WebView webView, int i, int i2, int i3, int i4, String str) {
    }
}
