package com.baidu.tieba;

import android.util.Log;
import android.webkit.WebView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
/* compiled from: JsPromptInterface.java */
/* loaded from: classes6.dex */
public final /* synthetic */ class wf6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void b(xf6 xf6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, xf6Var) == null) {
        }
    }

    public static void a(xf6 xf6Var, WebView webView, String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(65536, null, xf6Var, webView, str, jSONObject) != null) || webView == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        webView.evaluateJavascript("javascript:" + str + "&&" + str + "('" + jSONObject.toString() + "')", null);
        StringBuilder sb = new StringBuilder();
        sb.append("javascript 执行成功:");
        sb.append(str);
        sb.append(" 耗时：");
        sb.append(System.currentTimeMillis() - currentTimeMillis);
        Log.i("lt-log", sb.toString());
    }
}
