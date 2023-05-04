package com.baidu.tieba;

import android.text.TextUtils;
import android.view.View;
import android.webkit.JsPromptResult;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.log.HybridLog;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.schemeaction.SchemeActionManager;
import com.baidu.tieba.browser.TbWebView;
import com.baidu.tieba.browser.exception.JsInterfaceException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class vd6 implements vf6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<xf6> b;
    public final wd6 c;

    public vd6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new ArrayList<>();
        this.c = new wd6();
    }

    @Override // com.baidu.tieba.vf6
    public void a(List<Pair<String, String>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            this.c.f(list);
        }
    }

    @Override // com.baidu.tieba.vf6
    public void b(String str, HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, hashMap) == null) {
            for (WeakReference<WebView> weakReference : zf6.b().a()) {
                if (weakReference != null && weakReference.get() != null) {
                    try {
                        d(weakReference.get(), str, hashMap);
                    } catch (JsInterfaceException e) {
                        BdLog.e(e, true);
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.vf6
    public boolean c(WebView webView, String str, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, jsPromptResult)) == null) {
            h(str, str, webView.getUrl());
            if (str.startsWith("tiebaapp")) {
                return k(webView, str);
            }
            return j(webView, str, jsPromptResult);
        }
        return invokeLLL.booleanValue;
    }

    @Override // com.baidu.tieba.vf6
    public void e(View view2, String str, ValueCallback<String> valueCallback) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048580, this, view2, str, valueCallback) == null) && !TextUtils.isEmpty(str)) {
            if (view2 instanceof WebView) {
                ((WebView) view2).evaluateJavascript(str, valueCallback);
            } else if (view2 instanceof TbWebView) {
                ((TbWebView) view2).o(str, valueCallback);
            }
        }
    }

    public final void h(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, str, str2, str3) == null) {
            StatisticItem statisticItem = new StatisticItem("js_call_native");
            statisticItem.addParam("obj_type", str);
            statisticItem.addParam("obj_name", str2);
            statisticItem.addParam("obj_source", str3);
            TiebaStatic.log(statisticItem);
        }
    }

    public final void i(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, str3) == null) {
            StatisticItem statisticItem = new StatisticItem("native_call_js");
            statisticItem.addParam("obj_type", str);
            statisticItem.addParam("obj_name", str2);
            statisticItem.addParam("obj_source", str3);
            TiebaStatic.log(statisticItem);
        }
    }

    public final boolean l(TbPageContext<?> tbPageContext, String str, hq9 hq9Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048587, this, tbPageContext, str, hq9Var)) == null) {
            if (hq9Var == null || hq9Var.i() || !SchemeActionManager.getInstance().doSchemeAction(tbPageContext, str)) {
                return false;
            }
            hq9Var.s(true);
            hq9Var.z(0);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    @Override // com.baidu.tieba.vf6
    public void d(View view2, String str, @Nullable HashMap<String, Object> hashMap) {
        WebView webView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, view2, str, hashMap) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (view2 instanceof WebView) {
                webView = (WebView) view2;
            } else if (view2 instanceof TbWebView) {
                webView = ((TbWebView) view2).getInnerWebView();
            } else {
                webView = null;
            }
            if (webView != null) {
                i(webView.getUrl(), str, str);
                if (this.c.e(webView, this.c.g(webView, str, hashMap))) {
                    kg6.c("lt-log", "端能力 执行成功 " + str + " 耗时:" + (System.currentTimeMillis() - currentTimeMillis));
                    return;
                }
                kg6.e("lt-log", "端能力 执行失败 " + str + " 耗时:" + (System.currentTimeMillis() - currentTimeMillis));
                return;
            }
            kg6.b("lt-log", "端能力 执行失败 view类型不匹配！" + view2);
        }
    }

    @Override // com.baidu.tieba.vf6
    public void f(xf6 xf6Var, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048581, this, xf6Var, obj) == null) && (obj instanceof fq9)) {
            this.b.add(xf6Var);
            this.c.a((fq9) obj);
        }
    }

    public final boolean g(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048582, this, webView, str, str2, str3, jsPromptResult)) == null) {
            Iterator<xf6> it = this.b.iterator();
            while (it.hasNext()) {
                xf6 next = it.next();
                if (next != null && next.b(webView, str, str2, str3, jsPromptResult)) {
                    return false;
                }
            }
            return true;
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean j(WebView webView, String str, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048585, this, webView, str, jsPromptResult)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                dj8 hybridLog = HybridLog.getInstance();
                hybridLog.c("JsBridge", "processJSON json:" + str);
                JSONObject jSONObject = new JSONObject(str);
                return g(webView, jSONObject.optString("interfaceName", ""), jSONObject.optString("methodName", ""), jSONObject.optString("param", ""), jsPromptResult);
            } catch (JSONException e) {
                dj8 hybridLog2 = HybridLog.getInstance();
                hybridLog2.b("JsBridge", "processJSON JSONException:" + e);
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public final boolean k(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, webView, str)) == null) {
            dj8 hybridLog = HybridLog.getInstance();
            hybridLog.c("JsBridge", "processScheme scheme:" + str);
            jq9 jq9Var = new jq9();
            String a = lq9.a(str);
            String d = lq9.d(str);
            String b = lq9.b(str);
            jq9Var.f(a);
            jq9Var.h(d);
            hq9 hq9Var = new hq9();
            hq9Var.w(b);
            if (hi.isEmpty(a) || hi.isEmpty(d) || hi.isEmpty(b)) {
                hq9Var.z(101);
            }
            try {
                jq9Var.j(lq9.f(str));
            } catch (JSONException unused) {
                jq9Var.j(new JSONObject());
                hq9Var.z(101);
            }
            jq9Var.i(lq9.e(str));
            jq9Var.g(lq9.c(str));
            hq9 c = this.c.c(webView, jq9Var, hq9Var);
            if (c.g()) {
                this.c.d(webView, c);
                return false;
            }
            l(sn9.a(webView.getContext()), str, c);
            return false;
        }
        return invokeLL.booleanValue;
    }
}
