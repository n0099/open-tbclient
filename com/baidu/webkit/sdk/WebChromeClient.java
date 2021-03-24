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
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
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
/* loaded from: classes5.dex */
public class WebChromeClient {
    public static final String DEFAULT_ERROR_IMAGE_PATH = "file:///android_asset/webkit/errorpage/images/error_page.png";
    public static final int ERROR_CODE_FUNCTION_CALL_FAILED = 100;
    public static final int ERROR_CODE_FUNCTION_NOT_FOUND = 102;
    public static final int ERROR_CODE_INTERFACE_NOT_FOUND = 101;
    public static final int ERROR_CODE_OK = 0;
    public static final String JIS_NAME = "FLYFLOW-JSI:";
    public static final String JIS_NAME_NEW = "flyflow://";
    public static final String KEY_ARG_ARRAY = "args";
    public static final String KEY_ARG_CALLBACK = "callback";
    public static final String KEY_FUNCTION_NAME = "func";
    public static final String KEY_INTERFACE_NAME = "obj";
    public static final String MSG_METHOD_GETVERSION = "getVersion";
    public static final String PARAM_SEPARATOR = "\\|";
    public WebView mWebView;
    public static final boolean DEBUG = Log.isDebug();
    public static final String LOG_TAG = WebChromeClient.class.getSimpleName();
    public static final String MSG_PROMPT_HEADER = "BdboxApp:";
    public static final String MSG_PROMPT_HEADER_IMPACT = MSG_PROMPT_HEADER.toLowerCase();

    /* loaded from: classes5.dex */
    public interface CustomViewCallback {
        void onCustomViewHidden();
    }

    /* loaded from: classes5.dex */
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

    private void doJsCheckIfNeeded(BdJsCallInfo bdJsCallInfo) {
        if (bdJsCallInfo == null) {
            return;
        }
        BdJsCheckPolicy bdJsCheckPolicy = null;
        try {
            if (WebViewFactory.hasProvider()) {
                Object staticWebSeting = WebViewFactory.getProvider().getStaticWebSeting(WebViewFactoryProvider.SETTING_JS_CHECK_POLICY);
                if (staticWebSeting instanceof BdJsCheckPolicy) {
                    bdJsCheckPolicy = (BdJsCheckPolicy) staticWebSeting;
                }
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            String str = Log.LOG_TAG;
            Log.e(str, "setDefaultEnableJsPromptSailor error:" + th);
        }
        if (DEBUG) {
            String str2 = LOG_TAG;
            Log.d(str2, "doJsCheckIfNeeded() jsCallInfo: " + bdJsCallInfo + " ,policy:" + bdJsCheckPolicy);
        }
        if (bdJsCheckPolicy != null) {
            if (bdJsCallInfo.hasFinishedPermissionCheck()) {
                bdJsCheckPolicy.onJsCheckFinished(bdJsCallInfo);
            } else {
                bdJsCheckPolicy.onJsCheckUnFinished(bdJsCallInfo);
            }
        }
    }

    private Method getBdJsCallMethod(Object obj, String str, Class[] clsArr) {
        Class<?>[] clsArr2;
        if (obj != null && !TextUtils.isEmpty(str)) {
            if (clsArr != null) {
                clsArr2 = new Class[clsArr.length + 1];
                System.arraycopy(clsArr, 0, clsArr2, 1, clsArr.length);
            } else {
                clsArr2 = new Class[1];
            }
            clsArr2[0] = BdJsCallInfo.class;
            try {
                return obj.getClass().getMethod(str, clsArr2);
            } catch (Exception e2) {
                if (DEBUG) {
                    Log.e(LOG_TAG, e2.toString());
                }
            }
        }
        return null;
    }

    private Class getClassFromJsonObject(Object obj) {
        Class<?> cls = obj.getClass();
        return cls == Integer.class ? Integer.TYPE : cls == Boolean.class ? Boolean.TYPE : String.class;
    }

    private String getReturnValueInJSON(int i, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("error", i);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("msg", str);
            }
            if (i == 0 && str2 != null) {
                jSONObject.put("result", str2);
            }
        } catch (JSONException e2) {
            if (DEBUG) {
                Log.e(LOG_TAG, e2.toString());
            }
        }
        return jSONObject.toString();
    }

    private boolean handleGetVersionMessage(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith(MSG_PROMPT_HEADER)) {
            try {
                JSONObject jSONObject = new JSONObject(str.substring(9));
                String optString = jSONObject.optString(KEY_FUNCTION_NAME);
                String optString2 = jSONObject.optString("callback");
                if (MSG_METHOD_GETVERSION.equals(optString) && !TextUtils.isEmpty(optString2) && this.mWebView != null) {
                    WebView webView = this.mWebView;
                    webView.execJavaScriptExt(optString2 + "(" + CommonUtils.getVersionName(this.mWebView.getContext()) + SmallTailInfo.EMOTION_SUFFIX, new String[0]);
                    return true;
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0156 A[Catch: InvocationTargetException -> 0x017b, IllegalAccessException -> 0x018a, IllegalArgumentException -> 0x0196, NoSuchMethodException -> 0x01c1, TryCatch #2 {IllegalAccessException -> 0x018a, IllegalArgumentException -> 0x0196, NoSuchMethodException -> 0x01c1, InvocationTargetException -> 0x017b, blocks: (B:33:0x00cb, B:35:0x00d1, B:37:0x00dc, B:39:0x00e6, B:41:0x00ea, B:44:0x00f4, B:45:0x010d, B:48:0x0113, B:51:0x0145, B:59:0x015a, B:61:0x015e, B:63:0x0173, B:64:0x0177, B:58:0x0156, B:49:0x013f), top: B:96:0x00cb }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x015e A[Catch: InvocationTargetException -> 0x017b, IllegalAccessException -> 0x018a, IllegalArgumentException -> 0x0196, NoSuchMethodException -> 0x01c1, TryCatch #2 {IllegalAccessException -> 0x018a, IllegalArgumentException -> 0x0196, NoSuchMethodException -> 0x01c1, InvocationTargetException -> 0x017b, blocks: (B:33:0x00cb, B:35:0x00d1, B:37:0x00dc, B:39:0x00e6, B:41:0x00ea, B:44:0x00f4, B:45:0x010d, B:48:0x0113, B:51:0x0145, B:59:0x015a, B:61:0x015e, B:63:0x0173, B:64:0x0177, B:58:0x0156, B:49:0x013f), top: B:96:0x00cb }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0173 A[Catch: InvocationTargetException -> 0x017b, IllegalAccessException -> 0x018a, IllegalArgumentException -> 0x0196, NoSuchMethodException -> 0x01c1, TryCatch #2 {IllegalAccessException -> 0x018a, IllegalArgumentException -> 0x0196, NoSuchMethodException -> 0x01c1, InvocationTargetException -> 0x017b, blocks: (B:33:0x00cb, B:35:0x00d1, B:37:0x00dc, B:39:0x00e6, B:41:0x00ea, B:44:0x00f4, B:45:0x010d, B:48:0x0113, B:51:0x0145, B:59:0x015a, B:61:0x015e, B:63:0x0173, B:64:0x0177, B:58:0x0156, B:49:0x013f), top: B:96:0x00cb }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01bd  */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean invokeJSInterfaceMethod(WebView webView, JsPromptResult jsPromptResult, boolean z, String str, String str2, Object[] objArr) {
        Class<?>[] clsArr;
        String str3;
        String invocationTargetException;
        boolean z2;
        Object invoke;
        boolean z3;
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
            int length = objArr != null ? objArr.length : 0;
            if (length > 0) {
                clsArr = new Class[length];
                for (int i = 0; i < length; i++) {
                    clsArr[i] = getClassFromJsonObject(objArr[i]);
                    if (DEBUG) {
                        Log.d(LOG_TAG, "type:" + clsArr[i].getName());
                    }
                }
            } else {
                clsArr = null;
            }
            try {
                Method bdJsCallMethod = getBdJsCallMethod(obj, str2, clsArr);
                if (bdJsCallMethod == null) {
                    bdJsCallMethod = obj.getClass().getMethod(str2, clsArr);
                    z2 = false;
                } else {
                    z2 = true;
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
                    invoke = invokeBdJsCallMethod(bdJsCallMethod, obj, bdJsCallInfo, objArr);
                    doJsCheckIfNeeded(bdJsCallInfo);
                } else {
                    invoke = bdJsCallMethod.invoke(obj, objArr);
                }
                if (invoke != null && invoke.getClass() != Void.TYPE) {
                    z3 = false;
                    String obj2 = !z3 ? "" : invoke.toString();
                    if (DEBUG) {
                        Log.d(LOG_TAG, "called ok: " + obj2);
                    }
                    if (z) {
                        obj2 = getReturnValueInJSON(0, null, obj2);
                    }
                    jsPromptResult.confirm(obj2);
                    return true;
                }
                z3 = true;
                if (!z3) {
                }
                if (DEBUG) {
                }
                if (z) {
                }
                jsPromptResult.confirm(obj2);
                return true;
            } catch (IllegalAccessException e2) {
                if (DEBUG) {
                    str3 = LOG_TAG;
                    invocationTargetException = e2.toString();
                    Log.e(str3, invocationTargetException);
                    return false;
                }
                if (z) {
                    jsPromptResult.confirm(getReturnValueInJSON(100, str2 + " call failed!", null));
                } else {
                    jsPromptResult.cancel();
                }
                return true;
            } catch (IllegalArgumentException e3) {
                if (DEBUG) {
                    str3 = LOG_TAG;
                    invocationTargetException = e3.toString();
                    Log.e(str3, invocationTargetException);
                    return false;
                }
                if (z) {
                }
                return true;
            } catch (NoSuchMethodException unused) {
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
                    sb.append(SmallTailInfo.EMOTION_SUFFIX);
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
                    str3 = LOG_TAG;
                    invocationTargetException = e4.toString();
                    Log.e(str3, invocationTargetException);
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
        if (DEBUG) {
            String str4 = LOG_TAG;
            Log.d(str4, "handle url: " + str);
            String str5 = LOG_TAG;
            Log.i(str5, "handle msg: " + str2);
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
            String string = jSONObject.getString("obj");
            Object[] objArr = null;
            String optString = jSONObject.optString(KEY_FUNCTION_NAME, null);
            JSONArray optJSONArray = jSONObject.optJSONArray("args");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                objArr = new Object[length];
                for (int i = 0; i < length; i++) {
                    objArr[i] = optJSONArray.get(i);
                }
                if (DEBUG) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(string);
                    sb.append(".");
                    sb.append(optString);
                    sb.append("(");
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
                    sb.append(SmallTailInfo.EMOTION_SUFFIX);
                    String str6 = LOG_TAG;
                    Log.d(str6, "call: " + sb.toString());
                }
            }
            return invokeJSInterfaceMethod(webView, jsPromptResult, z, string, optString, objArr);
        } catch (JSONException e2) {
            if (DEBUG) {
                Log.e(LOG_TAG, e2.toString());
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
        handleGetVersionMessage(str);
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
        String str4 = LOG_TAG;
        Log.d(str4, "onJsPrompt url = " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + str2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + str3);
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

    public void onOffsetsForFullscreenChanged(float f2, float f3, float f4) {
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
