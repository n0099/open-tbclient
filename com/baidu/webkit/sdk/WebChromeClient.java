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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes11.dex */
public class WebChromeClient {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
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
    public static final String LOG_TAG;
    public static final String MSG_METHOD_GETVERSION = "getVersion";
    public static final String MSG_PROMPT_HEADER = "BdboxApp:";
    public static final String MSG_PROMPT_HEADER_IMPACT;
    public static final String PARAM_SEPARATOR = "\\|";
    public transient /* synthetic */ FieldHolder $fh;
    public WebView mWebView;

    /* loaded from: classes11.dex */
    public interface CustomViewCallback {
        void onCustomViewHidden();
    }

    /* loaded from: classes11.dex */
    public static abstract class FileChooserParams {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int MODE_OPEN = 0;
        public static final int MODE_OPEN_FOLDER = 2;
        public static final int MODE_OPEN_MULTIPLE = 1;
        public static final int MODE_SAVE = 3;
        public transient /* synthetic */ FieldHolder $fh;

        public FileChooserParams() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static Uri[] parseResult(int i2, Intent intent) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeIL = interceptable.invokeIL(65537, null, i2, intent)) == null) ? WebViewFactory.getProvider().getStatics().parseFileChooserResult(i2, intent) : (Uri[]) invokeIL.objValue;
        }

        public abstract Intent createIntent();

        public abstract String[] getAcceptTypes();

        public abstract String getFilenameHint();

        public abstract int getMode();

        public abstract CharSequence getTitle();

        public abstract boolean isCaptureEnabled();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(156477814, "Lcom/baidu/webkit/sdk/WebChromeClient;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(156477814, "Lcom/baidu/webkit/sdk/WebChromeClient;");
                return;
            }
        }
        DEBUG = Log.isDebug();
        LOG_TAG = WebChromeClient.class.getSimpleName();
        MSG_PROMPT_HEADER_IMPACT = MSG_PROMPT_HEADER.toLowerCase();
    }

    public WebChromeClient() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    private void doJsCheckIfNeeded(BdJsCallInfo bdJsCallInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, this, bdJsCallInfo) == null) || bdJsCallInfo == null) {
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
            Log.e(Log.LOG_TAG, "setDefaultEnableJsPromptSailor error:".concat(String.valueOf(th)));
        }
        if (DEBUG) {
            String str = LOG_TAG;
            Log.d(str, "doJsCheckIfNeeded() jsCallInfo: " + bdJsCallInfo + " ,policy:" + bdJsCheckPolicy);
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
        InterceptResult invokeLLL;
        Class<?>[] clsArr2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, this, obj, str, clsArr)) == null) {
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
        return (Method) invokeLLL.objValue;
    }

    private Class getClassFromJsonObject(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, obj)) == null) {
            Class<?> cls = obj.getClass();
            return cls == Integer.class ? Integer.TYPE : cls == Boolean.class ? Boolean.TYPE : String.class;
        }
        return (Class) invokeL.objValue;
    }

    private String getReturnValueInJSON(int i2, String str, String str2) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(AdIconUtil.AD_TEXT_ID, this, i2, str, str2)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("error", i2);
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("msg", str);
                }
                if (i2 == 0 && str2 != null) {
                    jSONObject.put("result", str2);
                }
            } catch (JSONException e2) {
                if (DEBUG) {
                    Log.e(LOG_TAG, e2.toString());
                }
            }
            return jSONObject.toString();
        }
        return (String) invokeILL.objValue;
    }

    private boolean handleGetVersionMessage(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, str)) == null) {
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
        return invokeL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0152 A[Catch: InvocationTargetException -> 0x0173, IllegalAccessException -> 0x0182, IllegalArgumentException -> 0x018e, NoSuchMethodException -> 0x01b9, TryCatch #2 {IllegalAccessException -> 0x0182, IllegalArgumentException -> 0x018e, NoSuchMethodException -> 0x01b9, InvocationTargetException -> 0x0173, blocks: (B:35:0x00c7, B:37:0x00cd, B:39:0x00d8, B:41:0x00e2, B:43:0x00e6, B:46:0x00f0, B:47:0x0109, B:50:0x010f, B:53:0x0141, B:61:0x0156, B:63:0x015a, B:65:0x016b, B:66:0x016f, B:60:0x0152, B:51:0x013b), top: B:102:0x00c7 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x015a A[Catch: InvocationTargetException -> 0x0173, IllegalAccessException -> 0x0182, IllegalArgumentException -> 0x018e, NoSuchMethodException -> 0x01b9, TryCatch #2 {IllegalAccessException -> 0x0182, IllegalArgumentException -> 0x018e, NoSuchMethodException -> 0x01b9, InvocationTargetException -> 0x0173, blocks: (B:35:0x00c7, B:37:0x00cd, B:39:0x00d8, B:41:0x00e2, B:43:0x00e6, B:46:0x00f0, B:47:0x0109, B:50:0x010f, B:53:0x0141, B:61:0x0156, B:63:0x015a, B:65:0x016b, B:66:0x016f, B:60:0x0152, B:51:0x013b), top: B:102:0x00c7 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x016b A[Catch: InvocationTargetException -> 0x0173, IllegalAccessException -> 0x0182, IllegalArgumentException -> 0x018e, NoSuchMethodException -> 0x01b9, TryCatch #2 {IllegalAccessException -> 0x0182, IllegalArgumentException -> 0x018e, NoSuchMethodException -> 0x01b9, InvocationTargetException -> 0x0173, blocks: (B:35:0x00c7, B:37:0x00cd, B:39:0x00d8, B:41:0x00e2, B:43:0x00e6, B:46:0x00f0, B:47:0x0109, B:50:0x010f, B:53:0x0141, B:61:0x0156, B:63:0x015a, B:65:0x016b, B:66:0x016f, B:60:0x0152, B:51:0x013b), top: B:102:0x00c7 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01b5  */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean invokeJSInterfaceMethod(WebView webView, JsPromptResult jsPromptResult, boolean z, String str, String str2, Object[] objArr) {
        InterceptResult invokeCommon;
        Class<?>[] clsArr;
        String str3;
        String invocationTargetException;
        boolean z2;
        Object invoke;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, this, new Object[]{webView, jsPromptResult, Boolean.valueOf(z), str, str2, objArr})) == null) {
            Object obj = webView.getSecureProcessor().d().get(str);
            if (obj == null) {
                if (DEBUG) {
                    Log.e(LOG_TAG, "not exist js interface:".concat(String.valueOf(str)));
                }
                if (z) {
                    jsPromptResult.confirm(getReturnValueInJSON(101, "interface:" + str + " not found!", null));
                } else {
                    jsPromptResult.cancel();
                }
                return true;
            } else if (objArr == null && str2 == null) {
                if (DEBUG) {
                    Log.d(LOG_TAG, "interface query: found for ".concat(String.valueOf(str)));
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
                    for (int i2 = 0; i2 < length; i2++) {
                        clsArr[i2] = getClassFromJsonObject(objArr[i2]);
                        if (DEBUG) {
                            Log.d(LOG_TAG, "type:" + clsArr[i2].getName());
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
                            Log.d(LOG_TAG, "called ok: ".concat(String.valueOf(obj2)));
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
                            for (int i3 = 1; i3 < length; i3++) {
                                sb.append(",'");
                                sb.append(objArr[i3]);
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
        return invokeCommon.booleanValue;
    }

    public void copyText(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
        }
    }

    public void doTextSearch(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str) == null) {
        }
    }

    public void doTextTranslate(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, webView, str) == null) {
        }
    }

    public Bitmap getDefaultVideoPoster() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (Bitmap) invokeV.objValue;
    }

    public View getVideoLoadingProgressView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return null;
        }
        return (View) invokeV.objValue;
    }

    public void getVisitedHistory(ValueCallback<String[]> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, valueCallback) == null) {
        }
    }

    public boolean handleJavascriptInterface(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLLL;
        String substring;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048582, this, webView, str, str2, str3, jsPromptResult)) == null) {
            if (DEBUG) {
                Log.d(LOG_TAG, "handle url: ".concat(String.valueOf(str)));
                Log.i(LOG_TAG, "handle msg: ".concat(String.valueOf(str2)));
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
                    for (int i2 = 0; i2 < length; i2++) {
                        objArr[i2] = optJSONArray.get(i2);
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
                            for (int i3 = 1; i3 < length; i3++) {
                                sb.append(",\"");
                                sb.append(objArr[i3]);
                                sb.append("\"");
                            }
                        }
                        sb.append(SmallTailInfo.EMOTION_SUFFIX);
                        String str4 = LOG_TAG;
                        Log.d(str4, "call: " + sb.toString());
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
        return invokeLLLLL.booleanValue;
    }

    public void hideMagnifier(WebView webView, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048583, this, webView, i2, i3) == null) {
        }
    }

    public void hideSelectionActionDialog(WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, webView) == null) {
        }
    }

    public Object invokeBdJsCallMethod(Method method, Object obj, BdJsCallInfo bdJsCallInfo, Object[] objArr) throws InvocationTargetException, IllegalAccessException {
        InterceptResult invokeLLLL;
        Object[] objArr2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048585, this, method, obj, bdJsCallInfo, objArr)) == null) {
            if (objArr != null) {
                objArr2 = new Object[objArr.length + 1];
                System.arraycopy(objArr, 0, objArr2, 1, objArr.length);
            } else {
                objArr2 = new Object[1];
            }
            objArr2[0] = bdJsCallInfo;
            return method.invoke(obj, objArr2);
        }
        return invokeLLLL.objValue;
    }

    public void moveMagnifier(WebView webView, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{webView, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
        }
    }

    public boolean needNotifyNativeExitFullScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void notifyClickWhenLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    public void notifyClientStatus(WebView webView, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048589, this, webView, i2) == null) {
        }
    }

    public void onCloseWindow(WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, webView) == null) {
        }
    }

    @Deprecated
    public void onConsoleMessage(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048591, this, str, i2, str2) == null) {
            handleGetVersionMessage(str);
        }
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, consoleMessage)) == null) {
            String message = consoleMessage.message();
            Log.d(LOG_TAG, message);
            if (TextUtils.isEmpty(message) || !handleGetVersionMessage(message)) {
                onConsoleMessage(consoleMessage.message(), consoleMessage.lineNumber(), consoleMessage.sourceId());
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{webView, Boolean.valueOf(z), Boolean.valueOf(z2), message})) == null) {
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @Deprecated
    public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{str, str2, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), quotaUpdater}) == null) {
            quotaUpdater.updateQuota(j);
        }
    }

    public void onGeolocationPermissionsHidePrompt() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
        }
    }

    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, str, callback) == null) {
        }
    }

    public void onHideCustomView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
        }
    }

    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048598, this, webView, str, str2, jsResult)) == null) {
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048599, this, webView, str, str2, jsResult)) == null) {
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048600, this, webView, str, str2, jsResult)) == null) {
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048601, this, webView, str, str2, str3, jsPromptResult)) == null) {
            String str4 = LOG_TAG;
            Log.d(str4, "onJsPrompt url = " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + str2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + str3);
            return !TextUtils.isEmpty(str2) && handleJavascriptInterface(webView, str, str2, str3, jsPromptResult);
        }
        return invokeLLLLL.booleanValue;
    }

    @Deprecated
    public boolean onJsTimeout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void onNativeElementEnterFullScreen() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
        }
    }

    public void onNativeElementExitFullScreen() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
        }
    }

    public void onOffsetsForFullscreenChanged(float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048605, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
        }
    }

    public void onPermissionRequest(PermissionRequest permissionRequest) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048606, this, permissionRequest) == null) || permissionRequest.defaultHandler()) {
            return;
        }
        permissionRequest.deny();
    }

    public void onPermissionRequestCanceled(PermissionRequest permissionRequest) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, permissionRequest) == null) {
        }
    }

    public void onPrerenderChanged(int i2, WebView.PrerenderStatus prerenderStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048608, this, i2, prerenderStatus) == null) {
        }
    }

    public void onProgressChanged(WebView webView, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048609, this, webView, i2) == null) {
        }
    }

    @Deprecated
    public void onReachedMaxAppCacheSize(long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048610, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), quotaUpdater}) == null) {
            quotaUpdater.updateQuota(j2);
        }
    }

    public void onReceivedIcon(WebView webView, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048611, this, webView, bitmap) == null) {
        }
    }

    public void onReceivedTitle(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048612, this, webView, str) == null) {
        }
    }

    public void onReceivedTouchIconUrl(WebView webView, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048613, this, webView, str, z) == null) {
        }
    }

    public void onRequestFocus(WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, webView) == null) {
        }
    }

    public void onSetLoadURL(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048615, this, webView, str) == null) {
        }
    }

    @Deprecated
    public void onShowCustomView(View view, int i2, CustomViewCallback customViewCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048616, this, view, i2, customViewCallback) == null) {
        }
    }

    public void onShowCustomView(View view, CustomViewCallback customViewCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048617, this, view, customViewCallback) == null) {
        }
    }

    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, FileChooserParams fileChooserParams) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048618, this, webView, valueCallback, fileChooserParams)) == null) {
            return false;
        }
        return invokeLLL.booleanValue;
    }

    @Deprecated
    public void openFileChooser(ValueCallback<Uri> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, valueCallback) == null) {
            openFileChooser(valueCallback, null, null);
        }
    }

    @Deprecated
    public void openFileChooser(ValueCallback<Uri> valueCallback, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048620, this, valueCallback, str) == null) {
            openFileChooser(valueCallback, str, null);
        }
    }

    @Deprecated
    public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048621, this, valueCallback, str, str2) == null) {
            valueCallback.onReceiveValue(null);
        }
    }

    public void performLongClick(WebView webView, int i2, String str, String str2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048622, this, new Object[]{webView, Integer.valueOf(i2), str, str2, Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            webView.mHasPerformedLongPress = true;
        }
    }

    public void performLongClick(WebView webView, WebView.HitTestResult hitTestResult, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048623, this, webView, hitTestResult, i2, i3) == null) {
            webView.mHasPerformedLongPress = true;
        }
    }

    public void setInstallableWebApp() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
        }
    }

    public void setWebView(WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, webView) == null) {
            this.mWebView = webView;
        }
    }

    public void setupAutoFill(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, message) == null) {
        }
    }

    public void showMagnifier(WebView webView, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048627, this, new Object[]{webView, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
        }
    }

    public void showSelectionActionDialog(WebView webView, int i2, int i3, int i4, int i5, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048628, this, new Object[]{webView, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), str}) == null) {
        }
    }
}
