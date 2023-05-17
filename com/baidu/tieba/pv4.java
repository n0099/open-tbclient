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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.browser.UegTbJsBridge;
import com.baidu.tbadk.browser.auth.AliAuthHttpProxy;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.LoginDialogData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.xiuba.JSResultData;
import com.baidu.tieba.pv4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class pv4 implements jh6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AliAuthHttpProxy a;

    @Override // com.baidu.tieba.jh6
    public /* synthetic */ void a(WebView webView, String str, JSONObject jSONObject) {
        ih6.a(this, webView, str, jSONObject);
    }

    public pv4() {
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

    @Override // com.baidu.tieba.jh6
    public void onDestroy() {
        AliAuthHttpProxy aliAuthHttpProxy;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (aliAuthHttpProxy = this.a) != null) {
            aliAuthHttpProxy.k();
        }
    }

    @Override // com.baidu.tieba.jh6
    public boolean b(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, str2, str3, jsPromptResult)) == null) {
            if (!TextUtils.equals("CommonJSBridge", str)) {
                return false;
            }
            if (TextUtils.equals("startLoginModule", str2)) {
                try {
                    jsPromptResult.confirm(k(webView, new JSONObject(str3).optString("cssUrl")).a());
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (CommonTbJsBridge.LOAD_THIRD_PARTY_LOGIN.equals(str2)) {
                jsPromptResult.confirm(g(webView, str3));
            } else if (CommonTbJsBridge.START_DOWNLOAD_CSS.equals(str2)) {
                try {
                    jsPromptResult.confirm(j(webView, new JSONObject(str3).optString(TTDownloadField.TT_DOWNLOAD_URL)).a());
                } catch (JSONException e2) {
                    BdLog.e(e2);
                }
            } else if (UegTbJsBridge.METHOD_BIND_MOBILE_NUMBER.equals(str2)) {
                jsPromptResult.confirm(c(webView).a());
                return true;
            } else if (TextUtils.equals("startAllLoginModule", str2)) {
                try {
                    JSONObject jSONObject = new JSONObject(str3);
                    jsPromptResult.confirm(i(webView, jSONObject.optString("type"), jSONObject.optString("addObserverNotify"), jSONObject.optString("activityId"), jSONObject.optString("cssUrl")).a());
                    return true;
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            return false;
        }
        return invokeLLLLL.booleanValue;
    }

    public js9 c(WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, webView)) == null) {
            js9 js9Var = new js9();
            try {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921372, t95.b()));
            } catch (Exception e) {
                e.printStackTrace();
            }
            return js9Var;
        }
        return (js9) invokeL.objValue;
    }

    public js9 d(WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, webView)) == null) {
            if (this.a == null) {
                this.a = new AliAuthHttpProxy(webView);
            }
            return this.a.l();
        }
        return (js9) invokeL.objValue;
    }

    public /* synthetic */ void f(WebView webView) {
        kh6.a().d(webView, "commonLogin", new HashMap<String, Object>(this) { // from class: com.baidu.tbadk.browser.bridge.AccountJsBridgePlugin$1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ pv4 this$0;

            {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                put("resultCode", 2);
                put("hasLogin", Boolean.TRUE);
            }
        });
    }

    public js9 e(WebView webView, int i, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048580, this, webView, i, str)) == null) {
            js9 js9Var = new js9();
            JSONObject jSONObject = new JSONObject();
            Activity a = yg6.a(webView.getContext());
            if (a == null) {
                try {
                    jSONObject.put("resultCode", 0);
                } catch (JSONException e) {
                    BdLog.e(e);
                }
                js9Var.o(jSONObject.toString());
                return js9Var;
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
            js9Var.o(jSONObject.toString());
            return js9Var;
        }
        return (js9) invokeLIL.objValue;
    }

    public final String g(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, webView, str)) == null) {
            if (!qi.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    return e(webView, jSONObject.optInt("socialType", 0), jSONObject.optString("activityId")).a();
                } catch (JSONException e) {
                    BdLog.e(e);
                    return null;
                }
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public js9 k(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, webView, str)) == null) {
            js9 js9Var = new js9();
            Activity a = yg6.a(webView.getContext());
            if (a != null) {
                ViewHelper.checkUpIsLoginFromH5(a, webView.getOriginalUrl(), str);
            }
            JSResultData jSResultData = new JSResultData();
            jSResultData.setStatus(1);
            jSResultData.setErrorCode("0");
            jSResultData.setErrorMsg("");
            js9Var.o(OrmObject.jsonStrWithObject(jSResultData));
            return js9Var;
        }
        return (js9) invokeLL.objValue;
    }

    public js9 h(WebView webView, HashMap<String, String> hashMap) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, webView, hashMap)) == null) {
            js9 js9Var = new js9();
            int i2 = -1;
            try {
                i2 = Integer.parseInt(hashMap.get("status"));
                js9Var.y(i2);
                js9Var.u(hashMap.get("message"));
                if (i2 == 0) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("avatar", hashMap.get("avatar"));
                    jSONObject.put("nick_name", hashMap.get("nick_name"));
                    jSONObject.put("alipay_user_id", hashMap.get("alipay_user_id"));
                    js9Var.o(jSONObject.toString());
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_GET_ALI_PAY_USER_INFO);
            if (i2 == 0) {
                i = 0;
            } else {
                i = 1;
            }
            TiebaStatic.log(statisticItem.param("obj_param1", i));
            return js9Var;
        }
        return (js9) invokeLL.objValue;
    }

    public js9 j(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, webView, str)) == null) {
            js9 js9Var = new js9();
            JSONObject jSONObject = new JSONObject();
            if (!qi.isEmpty(str)) {
                try {
                    if (qi.isEmpty(str)) {
                        jSONObject.put("resultCode", 0);
                        js9Var.o(jSONObject.toString());
                        return js9Var;
                    }
                    String customLoginCssFileName = FileHelper.getCustomLoginCssFileName(str);
                    String customLoginCssStoragePath = FileHelper.getCustomLoginCssStoragePath(str);
                    if (!FileHelper.checkIsCssFile(customLoginCssStoragePath)) {
                        jSONObject.put("resultCode", 0);
                        js9Var.o(jSONObject.toString());
                        return js9Var;
                    }
                    DownloadData downloadData = new DownloadData(customLoginCssFileName, customLoginCssFileName, str, null);
                    downloadData.setPath(customLoginCssStoragePath);
                    oe5.k().l(downloadData);
                    jSONObject.put("resultCode", 1);
                } catch (JSONException e) {
                    BdLog.e(e);
                }
            }
            js9Var.o(jSONObject.toString());
            return js9Var;
        }
        return (js9) invokeLL.objValue;
    }

    public js9 i(final WebView webView, String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, webView, str, str2, str3, str4)) == null) {
            js9 js9Var = new js9();
            if (TbadkCoreApplication.isLogin()) {
                bh6.a().c(new Runnable() { // from class: com.baidu.tieba.kv4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            pv4.this.f(webView);
                        }
                    }
                });
                return js9Var;
            }
            if ((str.equals("0") || str.equals("")) && str4 != null) {
                Activity a = yg6.a(webView.getContext());
                if (a != null) {
                    ViewHelper.checkUpIsLoginFromH5(a, webView.getOriginalUrl(), str4);
                }
                JSResultData jSResultData = new JSResultData();
                jSResultData.setStatus(1);
                jSResultData.setErrorCode("0");
                jSResultData.setErrorMsg("");
                js9Var.o(OrmObject.jsonStrWithObject(jSResultData));
            }
            if ((str3 != null && !StringUtils.isNull(str) && (str.equals("1") || str.equals("2"))) || str.equals("3") || str.equals("100")) {
                JSONObject jSONObject = new JSONObject();
                Activity a2 = yg6.a(webView.getContext());
                if (a2 == null) {
                    try {
                        jSONObject.put("resultCode", 0);
                        jSONObject.put("status", 403);
                    } catch (JSONException e) {
                        BdLog.e(e);
                    }
                    js9Var.o(jSONObject.toString());
                    return js9Var;
                }
                if (!StringUtils.isNull(str) && str.equals("100")) {
                    DialogLoginHelper.checkUpIsLogin(new LoginDialogData(yg6.a(webView.getContext()), LoginDialogData.SCHEMA_LOGIN));
                }
                if (!StringUtils.isNull(str) && (str.equals("1") || str.equals("2") || str.equals("3"))) {
                    LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) a2, true);
                    loginActivityConfig.setThirdPartyLoginForResult(Integer.parseInt(str), str3);
                    loginActivityConfig.setUrl(webView.getOriginalUrl());
                    ViewHelper.checkUpIsLoginFromH5(loginActivityConfig);
                }
                try {
                    jSONObject.put("resultCode", 1);
                } catch (JSONException e2) {
                    BdLog.e(e2);
                }
                js9Var.o(jSONObject.toString());
            }
            return js9Var;
        }
        return (js9) invokeLLLLL.objValue;
    }

    public js9 l(WebView webView, HashMap<String, Object> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, webView, hashMap)) == null) {
            js9 js9Var = new js9();
            JSONObject jSONObject = new JSONObject();
            if (hashMap != null && hashMap.get("hasLogin") != null && Boolean.TRUE.equals(hashMap.get("hasLogin"))) {
                try {
                    jSONObject.put("resultCode", 2);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                js9Var.o(jSONObject.toString());
                return js9Var;
            } else if (hashMap != null && hashMap.get("isLogin") != null && Boolean.TRUE.equals(hashMap.get("isLogin")) && (!hashMap.containsKey("resultCode") || ((Integer) hashMap.get("resultCode")).intValue() != 0)) {
                try {
                    jSONObject.put("resultCode", 1);
                    jSONObject.put("socialType", hashMap.get("social_type"));
                    jSONObject.put("activityId", hashMap.get("activityId"));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                a(webView, CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN, jSONObject);
                js9Var.o(jSONObject.toString());
                return js9Var;
            } else {
                try {
                    jSONObject.put("resultCode", 0);
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
                js9Var.o(jSONObject.toString());
                js9Var.q(403, "登录失败！");
                return js9Var;
            }
        }
        return (js9) invokeLL.objValue;
    }
}
