package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.webkit.JsPromptResult;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.dto.FaceBaseDTO;
import com.baidu.searchbox.player.model.YYOption;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.browser.UegTbJsBridge;
import com.baidu.tbadk.browser.auth.AliAuthHttpProxy;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.account.certification.CertificationCheckParams;
import com.baidu.tbadk.core.account.certification.CertificationRequestParams;
import com.baidu.tbadk.core.account.certification.ICertificationCallback;
import com.baidu.tbadk.core.account.certification.ICheckCertificationCallback;
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
import com.baidu.tieba.browser.log.HybridLog;
import com.baidu.tieba.iy4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class iy4 implements zl6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AliAuthHttpProxy a;

    @Override // com.baidu.tieba.zl6
    public /* synthetic */ void a(WebView webView, String str, JSONObject jSONObject) {
        yl6.a(this, webView, str, jSONObject);
    }

    /* loaded from: classes6.dex */
    public class a implements ICheckCertificationCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WebView a;

        public a(iy4 iy4Var, WebView webView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iy4Var, webView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = webView;
        }

        @Override // com.baidu.tbadk.core.account.certification.ICheckCertificationCallback
        public void onResult(@Nullable t05 t05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, t05Var) == null) {
                if (t05Var == null) {
                    DefaultLog.getInstance().b("CheckCertificationResult", "---- no result ----");
                    return;
                }
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("status", Integer.valueOf(t05Var.c));
                hashMap.put(StatConstants.KEY_EXT_ERR_MSG, t05Var.d);
                hashMap.put("livingUname", t05Var.e);
                hashMap.put("authsid", t05Var.f);
                hashMap.put("authWidgetURL", t05Var.g);
                hashMap.put("realNameStatus", Integer.valueOf(t05Var.a()));
                hashMap.put(StatConstants.KEY_EXT_ERR_CODE, Integer.valueOf(t05Var.a));
                am6.a().d(this.a, "authStateResult", hashMap);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ICertificationCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WebView a;

        public b(iy4 iy4Var, WebView webView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iy4Var, webView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = webView;
        }

        @Override // com.baidu.tbadk.core.account.certification.ICertificationCallback
        public void onResult(u05 u05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, u05Var) == null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(StatConstants.KEY_EXT_ERR_CODE, Integer.valueOf(u05Var.a));
                linkedHashMap.put(StatConstants.KEY_EXT_ERR_MSG, u05Var.b);
                linkedHashMap.put("subResultCode", Integer.valueOf(u05Var.c));
                linkedHashMap.put("subResultMsg", u05Var.d);
                linkedHashMap.put("status", Integer.valueOf(u05Var.a()));
                linkedHashMap.put("callbackkey", u05Var.g);
                if (this.a != null) {
                    am6.a().d(this.a, "realNameAuthResult", linkedHashMap);
                }
            }
        }
    }

    public iy4() {
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

    @Override // com.baidu.tieba.zl6
    public void onDestroy() {
        AliAuthHttpProxy aliAuthHttpProxy;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (aliAuthHttpProxy = this.a) != null) {
            aliAuthHttpProxy.k();
        }
    }

    @Override // com.baidu.tieba.zl6
    public boolean b(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, str2, str3, jsPromptResult)) == null) {
            if (!TextUtils.equals("CommonJSBridge", str)) {
                return false;
            }
            if (TextUtils.equals("startLoginModule", str2)) {
                try {
                    jsPromptResult.confirm(q(webView, new JSONObject(str3).optString("cssUrl")).a());
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (CommonTbJsBridge.LOAD_THIRD_PARTY_LOGIN.equals(str2)) {
                jsPromptResult.confirm(i(webView, str3));
            } else if (CommonTbJsBridge.START_DOWNLOAD_CSS.equals(str2)) {
                try {
                    jsPromptResult.confirm(p(webView, new JSONObject(str3).optString(TTDownloadField.TT_DOWNLOAD_URL)).a());
                } catch (JSONException e2) {
                    BdLog.e(e2);
                }
            } else if (UegTbJsBridge.METHOD_BIND_MOBILE_NUMBER.equals(str2)) {
                jsPromptResult.confirm(c(webView).a());
                return true;
            } else if (TextUtils.equals("startAllLoginModule", str2)) {
                try {
                    JSONObject jSONObject = new JSONObject(str3);
                    jsPromptResult.confirm(o(webView, jSONObject.optString("type"), jSONObject.optString("addObserverNotify"), jSONObject.optString("activityId"), jSONObject.optString("cssUrl")).a());
                    return true;
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            return false;
        }
        return invokeLLLLL.booleanValue;
    }

    public t0a c(WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, webView)) == null) {
            t0a t0aVar = new t0a();
            try {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921372, sc5.b()));
            } catch (Exception e) {
                e.printStackTrace();
            }
            return t0aVar;
        }
        return (t0a) invokeL.objValue;
    }

    public t0a f(WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, webView)) == null) {
            if (this.a == null) {
                this.a = new AliAuthHttpProxy(webView);
            }
            return this.a.l();
        }
        return (t0a) invokeL.objValue;
    }

    public /* synthetic */ void h(WebView webView) {
        am6.a().d(webView, "commonLogin", new HashMap<String, Object>(this) { // from class: com.baidu.tbadk.browser.bridge.AccountJsBridgePlugin$1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ iy4 this$0;

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

    public t0a d(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, webView, str)) == null) {
            t0a t0aVar = new t0a();
            HashMap hashMap = new HashMap();
            hashMap.put("scene", l(str));
            MessageManager.getInstance().runTask(2921709, String.class, new CertificationCheckParams(hashMap, new a(this, webView)));
            return t0aVar;
        }
        return (t0a) invokeLL.objValue;
    }

    public final String i(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, webView, str)) == null) {
            if (!vi.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    return g(webView, jSONObject.optInt("socialType", 0), jSONObject.optString("activityId")).a();
                } catch (JSONException e) {
                    BdLog.e(e);
                    return null;
                }
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public t0a q(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, webView, str)) == null) {
            t0a t0aVar = new t0a();
            Activity a2 = ol6.a(webView.getContext());
            if (a2 != null) {
                ViewHelper.checkUpIsLoginFromH5(a2, webView.getOriginalUrl(), str);
            }
            JSResultData jSResultData = new JSResultData();
            jSResultData.setStatus(1);
            jSResultData.setErrorCode("0");
            jSResultData.setErrorMsg("");
            t0aVar.o(OrmObject.jsonStrWithObject(jSResultData));
            return t0aVar;
        }
        return (t0a) invokeLL.objValue;
    }

    public t0a e(WebView webView, HashMap<String, Object> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, webView, hashMap)) == null) {
            t0a t0aVar = new t0a();
            t0aVar.o(j(hashMap).toString());
            return t0aVar;
        }
        return (t0a) invokeLL.objValue;
    }

    public t0a n(WebView webView, HashMap<String, Object> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, webView, hashMap)) == null) {
            t0a t0aVar = new t0a();
            if (hashMap != null && !hashMap.isEmpty()) {
                t0aVar.o(j(hashMap).toString());
            }
            return t0aVar;
        }
        return (t0a) invokeLL.objValue;
    }

    public t0a g(WebView webView, int i, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048582, this, webView, i, str)) == null) {
            t0a t0aVar = new t0a();
            JSONObject jSONObject = new JSONObject();
            Activity a2 = ol6.a(webView.getContext());
            if (a2 == null) {
                try {
                    jSONObject.put("resultCode", 0);
                } catch (JSONException e) {
                    BdLog.e(e);
                }
                t0aVar.o(jSONObject.toString());
                return t0aVar;
            }
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) a2, true);
            loginActivityConfig.setThirdPartyLoginForResult(i, str);
            loginActivityConfig.setUrl(webView.getOriginalUrl());
            ViewHelper.checkUpIsLoginFromH5(loginActivityConfig);
            try {
                jSONObject.put("resultCode", 1);
            } catch (JSONException e2) {
                BdLog.e(e2);
            }
            t0aVar.o(jSONObject.toString());
            return t0aVar;
        }
        return (t0a) invokeLIL.objValue;
    }

    public final JSONObject j(Map<String, Object> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, map)) == null) {
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                try {
                    jSONObject.put(entry.getKey(), entry.getValue());
                } catch (JSONException e) {
                    tr8 hybridLog = HybridLog.getInstance();
                    hybridLog.b("AccountJsBridgePlugin", "Map转json失败:" + e);
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public final String l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return FaceBaseDTO.BUSINESS_SENCE_REALNAME_FACE;
            }
            char c = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1018959312) {
                if (hashCode != -142547405) {
                    if (hashCode == 1368645956 && str.equals(FaceBaseDTO.BUSINESS_SENCE_FACE_LOGIN_SWITCH)) {
                        c = 2;
                    }
                } else if (str.equals("baidu_mini_programs")) {
                    c = 0;
                }
            } else if (str.equals("netdisk_2pwd")) {
                c = 1;
            }
            if (c == 0) {
                return "baidu_mini_programs";
            }
            if (c == 1) {
                return "netdisk_2pwd";
            }
            if (c != 2) {
                return FaceBaseDTO.BUSINESS_SENCE_REALNAME_FACE;
            }
            return FaceBaseDTO.BUSINESS_SENCE_FACE_LOGIN_SWITCH;
        }
        return (String) invokeL.objValue;
    }

    public t0a k(WebView webView, HashMap<String, String> hashMap) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, webView, hashMap)) == null) {
            t0a t0aVar = new t0a();
            int i2 = -1;
            try {
                i2 = Integer.parseInt(hashMap.get("status"));
                t0aVar.y(i2);
                t0aVar.u(hashMap.get("message"));
                if (i2 == 0) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("avatar", hashMap.get("avatar"));
                    jSONObject.put("nick_name", hashMap.get("nick_name"));
                    jSONObject.put("alipay_user_id", hashMap.get("alipay_user_id"));
                    t0aVar.o(jSONObject.toString());
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
            return t0aVar;
        }
        return (t0a) invokeLL.objValue;
    }

    public t0a p(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, webView, str)) == null) {
            t0a t0aVar = new t0a();
            JSONObject jSONObject = new JSONObject();
            if (!vi.isEmpty(str)) {
                try {
                    if (vi.isEmpty(str)) {
                        jSONObject.put("resultCode", 0);
                        t0aVar.o(jSONObject.toString());
                        return t0aVar;
                    }
                    String customLoginCssFileName = FileHelper.getCustomLoginCssFileName(str);
                    String customLoginCssStoragePath = FileHelper.getCustomLoginCssStoragePath(str);
                    if (!FileHelper.checkIsCssFile(customLoginCssStoragePath)) {
                        jSONObject.put("resultCode", 0);
                        t0aVar.o(jSONObject.toString());
                        return t0aVar;
                    }
                    DownloadData downloadData = new DownloadData(customLoginCssFileName, customLoginCssFileName, str, null);
                    downloadData.setPath(customLoginCssStoragePath);
                    uh5.k().l(downloadData);
                    jSONObject.put("resultCode", 1);
                } catch (JSONException e) {
                    BdLog.e(e);
                }
            }
            t0aVar.o(jSONObject.toString());
            return t0aVar;
        }
        return (t0a) invokeLL.objValue;
    }

    public t0a m(WebView webView, String str, boolean z, String str2, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{webView, str, Boolean.valueOf(z), str2, Integer.valueOf(i)})) == null) {
            t0a t0aVar = new t0a();
            MessageManager.getInstance().runTask(2921710, String.class, new CertificationRequestParams(l(str), z, i, str2, new b(this, webView)));
            return t0aVar;
        }
        return (t0a) invokeCommon.objValue;
    }

    public t0a o(final WebView webView, String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048590, this, webView, str, str2, str3, str4)) == null) {
            t0a t0aVar = new t0a();
            if (TbadkCoreApplication.isLogin()) {
                rl6.a().c(new Runnable() { // from class: com.baidu.tieba.dy4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            iy4.this.h(webView);
                        }
                    }
                });
                return t0aVar;
            }
            if ((str.equals("0") || str.equals("")) && str4 != null) {
                Activity a2 = ol6.a(webView.getContext());
                if (a2 != null) {
                    ViewHelper.checkUpIsLoginFromH5(a2, webView.getOriginalUrl(), str4);
                }
                JSResultData jSResultData = new JSResultData();
                jSResultData.setStatus(1);
                jSResultData.setErrorCode("0");
                jSResultData.setErrorMsg("");
                t0aVar.o(OrmObject.jsonStrWithObject(jSResultData));
            }
            if ((str3 != null && !StringUtils.isNull(str) && (str.equals("1") || str.equals("2"))) || str.equals("3") || str.equals(YYOption.UrlProtocol.USER)) {
                JSONObject jSONObject = new JSONObject();
                Activity a3 = ol6.a(webView.getContext());
                if (a3 == null) {
                    try {
                        jSONObject.put("resultCode", 0);
                        jSONObject.put("status", 403);
                    } catch (JSONException e) {
                        BdLog.e(e);
                    }
                    t0aVar.o(jSONObject.toString());
                    return t0aVar;
                }
                if (!StringUtils.isNull(str) && str.equals(YYOption.UrlProtocol.USER)) {
                    DialogLoginHelper.checkUpIsLogin(new LoginDialogData(ol6.a(webView.getContext()), LoginDialogData.SCHEMA_LOGIN));
                }
                if (!StringUtils.isNull(str) && (str.equals("1") || str.equals("2") || str.equals("3"))) {
                    LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) a3, true);
                    loginActivityConfig.setThirdPartyLoginForResult(Integer.parseInt(str), str3);
                    loginActivityConfig.setUrl(webView.getOriginalUrl());
                    ViewHelper.checkUpIsLoginFromH5(loginActivityConfig);
                }
                try {
                    jSONObject.put("resultCode", 1);
                } catch (JSONException e2) {
                    BdLog.e(e2);
                }
                t0aVar.o(jSONObject.toString());
            }
            return t0aVar;
        }
        return (t0a) invokeLLLLL.objValue;
    }

    public t0a r(WebView webView, HashMap<String, Object> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, webView, hashMap)) == null) {
            t0a t0aVar = new t0a();
            JSONObject jSONObject = new JSONObject();
            if (hashMap != null && hashMap.get("hasLogin") != null && Boolean.TRUE.equals(hashMap.get("hasLogin"))) {
                try {
                    jSONObject.put("resultCode", 2);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                t0aVar.o(jSONObject.toString());
                return t0aVar;
            } else if (hashMap != null && hashMap.get("isLogin") != null && Boolean.TRUE.equals(hashMap.get("isLogin")) && (!hashMap.containsKey("resultCode") || ((Integer) hashMap.get("resultCode")).intValue() != 0)) {
                try {
                    jSONObject.put("resultCode", 1);
                    jSONObject.put("socialType", hashMap.get("social_type"));
                    jSONObject.put("activityId", hashMap.get("activityId"));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                a(webView, CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN, jSONObject);
                t0aVar.o(jSONObject.toString());
                return t0aVar;
            } else {
                try {
                    jSONObject.put("resultCode", 0);
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
                t0aVar.o(jSONObject.toString());
                t0aVar.q(403, "登录失败！");
                return t0aVar;
            }
        }
        return (t0a) invokeLL.objValue;
    }
}
