package com.baidu.tieba;

import android.webkit.JsPromptResult;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.browser.log.HybridLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class mx4 implements qk6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.qk6
    public /* synthetic */ void a(WebView webView, String str, JSONObject jSONObject) {
        pk6.a(this, webView, str, jSONObject);
    }

    @Override // com.baidu.tieba.qk6
    public boolean b(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, str2, str3, jsPromptResult)) == null) {
            return false;
        }
        return invokeLLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.qk6
    public /* synthetic */ void onDestroy() {
        pk6.b(this);
    }

    public mx4() {
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

    public kca c(WebView webView, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, str2)) == null) {
            kca kcaVar = new kca();
            HybridLog.getInstance().w(str, str2);
            return kcaVar;
        }
        return (kca) invokeLLL.objValue;
    }

    public kca d(WebView webView, HashMap<String, String> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, webView, hashMap)) == null) {
            kca kcaVar = new kca();
            if (hashMap != null && hashMap.get("result") != null) {
                kcaVar.o(hashMap.get("result"));
            }
            return kcaVar;
        }
        return (kca) invokeLL.objValue;
    }
}
