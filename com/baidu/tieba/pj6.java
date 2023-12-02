package com.baidu.tieba;

import android.webkit.WebView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
/* compiled from: JsPromptInterface.java */
/* loaded from: classes7.dex */
public final /* synthetic */ class pj6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void b(qj6 qj6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, qj6Var) == null) {
        }
    }

    public static void a(qj6 qj6Var, WebView webView, String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(65536, null, qj6Var, webView, str, jSONObject) != null) || webView == null) {
            return;
        }
        webView.evaluateJavascript("javascript:" + str + "&&" + str + "('" + jSONObject.toString() + "')", null);
    }
}
