package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.JsPromptResult;
import android.webkit.WebView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.browser.UegTbJsBridge;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.novel.ReadRecordsData;
import com.baidu.tbadk.switchs.OpenJsSdkSwitch;
import com.baidu.tieba.h5power.DescriptionTableInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class xt4 implements re6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.re6
    public /* synthetic */ void a(WebView webView, String str, JSONObject jSONObject) {
        qe6.a(this, webView, str, jSONObject);
    }

    public xt4() {
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

    @Override // com.baidu.tieba.re6
    public boolean b(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, str2, str3, jsPromptResult)) == null) {
            if (TextUtils.equals(CommonTbJsBridge.GET_APIS, str2)) {
                jsPromptResult.confirm(d(webView));
                return true;
            } else if (UegTbJsBridge.METHOD_CALL_NATIVE_SMS.equals(str2)) {
                try {
                    JSONObject jSONObject = new JSONObject(str3);
                    c(webView, jSONObject.optString("phoneNumber"), jSONObject.optString("content"));
                    jsPromptResult.confirm("1");
                } catch (JSONException e) {
                    BdLog.e(e);
                }
                return true;
            } else if (UegTbJsBridge.METHOD_RECORD_NOVEL_INFO.equals(str2)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(str3);
                    g(webView, jSONObject2.optString("bookProgress"), jSONObject2.optString(TbEnum.ParamKey.GID), jSONObject2.optString("lastReadChapterId"), jSONObject2.optString("lastReadChapterIndex"), jSONObject2.optString("lastReadChapterName"));
                    jsPromptResult.confirm("1");
                } catch (JSONException e2) {
                    BdLog.e(e2);
                }
                return true;
            } else if (UegTbJsBridge.METHOD_NOVEL_PAY_RESULT_TO_CLIENT.equals(str2)) {
                try {
                    e(webView, new JSONObject(str3).optBoolean("isPaySuccess"));
                    jsPromptResult.confirm("1");
                } catch (JSONException e3) {
                    BdLog.e(e3);
                }
                return true;
            } else {
                return false;
            }
        }
        return invokeLLLLL.booleanValue;
    }

    public km9 c(WebView webView, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, str2)) == null) {
            km9 km9Var = new km9();
            Context a = he6.a(webView.getContext());
            if (a == null) {
                a = webView.getContext();
            }
            UtilHelper.smsTo(a, str, str2);
            return km9Var;
        }
        return (km9) invokeLLL.objValue;
    }

    public final String d(WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, webView)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("status", 0);
                jSONObject.put("message", webView.getContext().getString(R.string.scheme_action_status_ok));
                if (OpenJsSdkSwitch.isOn()) {
                    jSONObject.put("data", new JSONArray(DescriptionTableInfo.getDescriptionTable()));
                } else {
                    jSONObject.put("data", new JSONArray());
                }
                return jSONObject.toString();
            } catch (JSONException e) {
                BdLog.e(e);
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public km9 e(WebView webView, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048580, this, webView, z)) == null) {
            km9 km9Var = new km9();
            if (z) {
                bl5.d();
            }
            return km9Var;
        }
        return (km9) invokeLZ.objValue;
    }

    public km9 f(WebView webView, ArrayList<String> arrayList) {
        InterceptResult invokeLL;
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, webView, arrayList)) == null) {
            if (arrayList != null) {
                Iterator<String> it = arrayList.iterator();
                c = 65535;
                while (it.hasNext()) {
                    String a = cs5.a(it.next());
                    if (a != null) {
                        if (!cs5.d(webView.getContext(), a, null)) {
                            c = 2;
                        }
                    } else {
                        c = 1;
                    }
                }
            } else {
                c = 65535;
            }
            km9 km9Var = new km9();
            if (c == 65535) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("resultCode", 0);
                    km9Var.o(jSONObject.toString());
                    return km9Var;
                } catch (JSONException e) {
                    BdLog.e(e);
                }
            } else if (c == 1) {
                km9Var.q("url不支持预热");
            } else if (c == 2) {
                km9Var.q("预热池已存在该url");
            } else {
                km9Var.q("其它错误");
            }
            return km9Var;
        }
        return (km9) invokeLL.objValue;
    }

    public km9 g(WebView webView, String str, String str2, String str3, String str4, String str5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{webView, str, str2, str3, str4, str5})) == null) {
            km9 km9Var = new km9();
            ReadRecordsData readRecordsData = new ReadRecordsData(str, str2, str3, str4, str5);
            readRecordsData.S(true);
            bl5.e(str2, readRecordsData);
            return km9Var;
        }
        return (km9) invokeCommon.objValue;
    }
}
