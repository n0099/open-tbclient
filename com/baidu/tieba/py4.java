package com.baidu.tieba;

import android.app.Activity;
import android.webkit.JsPromptResult;
import android.webkit.WebView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class py4 implements ul6 {
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

    public py4() {
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
            if (CommonTbJsBridge.IS_DISABLE_GO_BACK.equals(str2)) {
                jsPromptResult.confirm(c(webView).a());
                return false;
            }
            return false;
        }
        return invokeLLLLL.booleanValue;
    }

    public bz9 c(WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, webView)) == null) {
            bz9 bz9Var = new bz9();
            Activity a = jl6.a(webView.getContext());
            int i = 1;
            if (a instanceof BaseWebViewActivity) {
                ((BaseWebViewActivity) a).isDisableGoBack = true;
            } else {
                i = 0;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", i);
                bz9Var.o(jSONObject.toString());
                return bz9Var;
            } catch (JSONException e) {
                BdLog.e(e);
                return bz9Var;
            }
        }
        return (bz9) invokeL.objValue;
    }
}
