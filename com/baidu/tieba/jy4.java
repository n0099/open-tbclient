package com.baidu.tieba;

import android.webkit.JsPromptResult;
import android.webkit.WebView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class jy4 implements ul6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.ul6
    public /* synthetic */ void a(WebView webView, String str, JSONObject jSONObject) {
        tl6.a(this, webView, str, jSONObject);
    }

    @Override // com.baidu.tieba.ul6
    public /* synthetic */ void onDestroy() {
        tl6.b(this);
    }

    public jy4() {
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

    @Override // com.baidu.tieba.ul6
    public boolean b(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, str2, str3, jsPromptResult)) == null) {
            if (CommonTbJsBridge.GET_CLIPPER_INFORMATION.equals(str2)) {
                jsPromptResult.confirm(c(webView).a());
                return true;
            } else if (CommonTbJsBridge.SET_CLIPPER_INFORMATION.equals(str2)) {
                try {
                    jsPromptResult.confirm(d(webView, new JSONObject(str3).optString("txt")).a());
                    return true;
                } catch (JSONException e) {
                    BdLog.e(e);
                    return false;
                }
            } else {
                return false;
            }
        }
        return invokeLLLLL.booleanValue;
    }

    public bz9 c(WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, webView)) == null) {
            bz9 bz9Var = new bz9();
            String clipBoardContent = UtilHelper.getClipBoardContent();
            int i = !ui.isEmpty(clipBoardContent) ? 1 : 0;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", i);
                jSONObject.put("data", clipBoardContent);
                bz9Var.o(jSONObject.toString());
                return bz9Var;
            } catch (JSONException e) {
                BdLog.e(e);
                return bz9Var;
            }
        }
        return (bz9) invokeL.objValue;
    }

    public bz9 d(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, webView, str)) == null) {
            bz9 bz9Var = new bz9();
            li.a(str);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", 1);
                bz9Var.o(jSONObject.toString());
                return bz9Var;
            } catch (JSONException e) {
                BdLog.e(e);
                return bz9Var;
            }
        }
        return (bz9) invokeLL.objValue;
    }
}
