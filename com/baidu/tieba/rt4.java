package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.webkit.JsPromptResult;
import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.browser.UegTbJsBridge;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.xiuba.JSResultData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class rt4 implements jd6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.jd6
    public /* synthetic */ void a(WebView webView, String str, JSONObject jSONObject) {
        id6.a(this, webView, str, jSONObject);
    }

    public rt4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.jd6
    public boolean b(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, str2, str3, jsPromptResult)) == null) {
            if (!TextUtils.equals("CommonJSBridge", str)) {
                return false;
            }
            if (TextUtils.equals("startLoginModule", str2)) {
                try {
                    jsPromptResult.confirm(h(webView, new JSONObject(str3).optString("cssUrl")).a());
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (CommonTbJsBridge.LOAD_THIRD_PARTY_LOGIN.equals(str2)) {
                jsPromptResult.confirm(e(webView, str3));
            } else if (CommonTbJsBridge.START_DOWNLOAD_CSS.equals(str2)) {
                try {
                    jsPromptResult.confirm(g(webView, new JSONObject(str3).optString(TTDownloadField.TT_DOWNLOAD_URL)).a());
                } catch (JSONException e2) {
                    BdLog.e(e2);
                }
            } else if (UegTbJsBridge.METHOD_BIND_MOBILE_NUMBER.equals(str2)) {
                jsPromptResult.confirm(c(webView).a());
                return true;
            }
            return false;
        }
        return invokeLLLLL.booleanValue;
    }

    public tc9 c(WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, webView)) == null) {
            tc9 tc9Var = new tc9();
            try {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921372, q65.b()));
            } catch (Exception e) {
                e.printStackTrace();
            }
            return tc9Var;
        }
        return (tc9) invokeL.objValue;
    }

    public tc9 d(WebView webView, int i, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048579, this, webView, i, str)) == null) {
            tc9 tc9Var = new tc9();
            JSONObject jSONObject = new JSONObject();
            Activity a = zc6.a(webView.getContext());
            if (a == null) {
                try {
                    jSONObject.put("resultCode", 0);
                } catch (JSONException e) {
                    BdLog.e(e);
                }
                tc9Var.o(jSONObject.toString());
                return tc9Var;
            }
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) a, true);
            loginActivityConfig.setThirdPartyLoginForResult(i, str);
            loginActivityConfig.setUrl(webView.getOriginalUrl());
            ViewHelper.checkUpIsLoginFromH5(loginActivityConfig);
            try {
                jSONObject.put("resultCode", 1);
            } catch (JSONException e2) {
                BdLog.e(e2);
            }
            tc9Var.o(jSONObject.toString());
            return tc9Var;
        }
        return (tc9) invokeLIL.objValue;
    }

    public final String e(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, webView, str)) == null) {
            if (!gi.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    return d(webView, jSONObject.optInt("socialType", 0), jSONObject.optString("activityId")).a();
                } catch (JSONException e) {
                    BdLog.e(e);
                    return null;
                }
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public tc9 h(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, webView, str)) == null) {
            tc9 tc9Var = new tc9();
            Activity a = zc6.a(webView.getContext());
            if (a != null) {
                ViewHelper.checkUpIsLoginFromH5(a, webView.getOriginalUrl(), str);
            }
            JSResultData jSResultData = new JSResultData();
            jSResultData.setStatus(1);
            jSResultData.setErrorCode("0");
            jSResultData.setErrorMsg("");
            tc9Var.o(OrmObject.jsonStrWithObject(jSResultData));
            return tc9Var;
        }
        return (tc9) invokeLL.objValue;
    }

    public tc9 f(WebView webView, HashMap<String, Boolean> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, webView, hashMap)) == null) {
            if (hashMap == null || hashMap.get("isLogin") == null || !Boolean.TRUE.equals(hashMap.get("isLogin"))) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("resultCode", 1);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            a(webView, CommonTbJsBridge.LOGIN_RESULT_TO_H5, jSONObject);
            tc9 tc9Var = new tc9();
            tc9Var.o(jSONObject.toString());
            return tc9Var;
        }
        return (tc9) invokeLL.objValue;
    }

    public tc9 i(WebView webView, HashMap<String, Object> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, webView, hashMap)) == null) {
            if (hashMap == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("resultCode", 1);
                jSONObject.put("socialType", hashMap.get("social_type"));
                jSONObject.put("activityId", hashMap.get("activityId"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            a(webView, CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN, jSONObject);
            tc9 tc9Var = new tc9();
            tc9Var.o(jSONObject.toString());
            return tc9Var;
        }
        return (tc9) invokeLL.objValue;
    }

    public tc9 g(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, webView, str)) == null) {
            tc9 tc9Var = new tc9();
            JSONObject jSONObject = new JSONObject();
            if (!gi.isEmpty(str)) {
                try {
                    if (gi.isEmpty(str)) {
                        jSONObject.put("resultCode", 0);
                        tc9Var.o(jSONObject.toString());
                        return tc9Var;
                    }
                    String customLoginCssFileName = FileHelper.getCustomLoginCssFileName(str);
                    String customLoginCssStoragePath = FileHelper.getCustomLoginCssStoragePath(str);
                    if (!FileHelper.checkIsCssFile(customLoginCssStoragePath)) {
                        jSONObject.put("resultCode", 0);
                        tc9Var.o(jSONObject.toString());
                        return tc9Var;
                    }
                    DownloadData downloadData = new DownloadData(customLoginCssFileName, customLoginCssFileName, str, null);
                    downloadData.setPath(customLoginCssStoragePath);
                    hb5.k().l(downloadData);
                    jSONObject.put("resultCode", 1);
                } catch (JSONException e) {
                    BdLog.e(e);
                }
            }
            tc9Var.o(jSONObject.toString());
            return tc9Var;
        }
        return (tc9) invokeLL.objValue;
    }
}
