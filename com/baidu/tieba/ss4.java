package com.baidu.tieba;

import android.text.TextUtils;
import android.webkit.JsPromptResult;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tieba.browser.log.HybridLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class ss4 implements mj6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.mj6
    public /* synthetic */ void a(WebView webView, String str, JSONObject jSONObject) {
        lj6.a(this, webView, str, jSONObject);
    }

    @Override // com.baidu.tieba.mj6
    public boolean b(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, str2, str3, jsPromptResult)) == null) {
            return false;
        }
        return invokeLLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.mj6
    public /* synthetic */ void onDestroy() {
        lj6.b(this);
    }

    public ss4() {
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

    public gxa c(WebView webView, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, str2)) == null) {
            gxa gxaVar = new gxa();
            HybridLog.getInstance().w(str, str2);
            return gxaVar;
        }
        return (gxa) invokeLLL.objValue;
    }

    public gxa d(WebView webView, HashMap<String, String> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, webView, hashMap)) == null) {
            gxa gxaVar = new gxa();
            if (hashMap != null && hashMap.get("result") != null) {
                gxaVar.o(hashMap.get("result"));
            }
            return gxaVar;
        }
        return (gxa) invokeLL.objValue;
    }

    public gxa e(WebView webView, String str, JSONObject jSONObject) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, webView, str, jSONObject)) == null) {
            gxa gxaVar = new gxa();
            if (TextUtils.isEmpty(str)) {
                gxaVar.r("logKey为null或者是空字符串");
                return gxaVar;
            }
            StatisticItem statisticItem = new StatisticItem(str);
            if (jSONObject != null) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    statisticItem.addParam(next, jSONObject.optString(next));
                }
            }
            statisticItem.eventStat();
            return gxaVar;
        }
        return (gxa) invokeLLL.objValue;
    }
}
