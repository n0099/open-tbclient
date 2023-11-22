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
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.schemeaction.SchemeActionManager;
import com.baidu.tieba.browser.TbWebView;
import com.baidu.tieba.browser.exception.JsInterfaceException;
import com.baidu.tieba.browser.log.HybridLog;
import com.baidu.tieba.log.TbLog;
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
/* loaded from: classes8.dex */
public class ug6 implements bj6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<dj6> b;
    public final vg6 c;

    public ug6() {
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
        this.c = new vg6();
    }

    @Override // com.baidu.tieba.bj6
    public void a(List<Pair<String, String>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            this.c.g(list);
        }
    }

    @Override // com.baidu.tieba.bj6
    public void b(String str, HashMap<String, Object> hashMap) {
        WebView webView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, hashMap) == null) {
            for (WeakReference<WebView> weakReference : fj6.b().a()) {
                if (weakReference != null && (webView = weakReference.get()) != null) {
                    try {
                        d(webView, str, hashMap);
                    } catch (JsInterfaceException e) {
                        BdLog.e(e, true);
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.bj6
    public boolean c(WebView webView, String str, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, jsPromptResult)) == null) {
            if (gh6.isOn()) {
                l(str, str, webView.getUrl());
            }
            if (str.startsWith("tiebaapp")) {
                return o(webView, str);
            }
            boolean n = n(webView, str, jsPromptResult);
            if (!n) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_type", com.baidu.mobads.sdk.internal.a.g).param("obj_source", str));
            }
            return n;
        }
        return invokeLLL.booleanValue;
    }

    @Override // com.baidu.tieba.bj6
    public void d(View view2, String str, @Nullable HashMap<String, Object> hashMap) {
        WebView webView;
        boolean z;
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
                m(webView.getUrl(), str, str);
                List<osa> h = this.c.h(webView, str, hashMap);
                boolean f = this.c.f(webView, h);
                boolean z2 = false;
                if (!ListUtils.isEmpty(h)) {
                    loop0: while (true) {
                        z = false;
                        for (osa osaVar : h) {
                            if (osaVar != null && osaVar.k()) {
                                if (osaVar.j || z) {
                                    z = true;
                                }
                            }
                        }
                    }
                    z2 = z;
                }
                if (!z2) {
                    if (f) {
                        TbLog hybridLog = HybridLog.getInstance();
                        hybridLog.i("newHybrid", "端能力 执行成功 " + str + " 耗时:" + (System.currentTimeMillis() - currentTimeMillis));
                        return;
                    }
                    TbLog hybridLog2 = HybridLog.getInstance();
                    hybridLog2.e("newHybrid", "端能力 执行失败 " + str + " 耗时:" + (System.currentTimeMillis() - currentTimeMillis));
                    return;
                }
                return;
            }
            qj6.b("newHybrid", "端能力 执行失败 view类型不匹配！" + view2);
        }
    }

    @Override // com.baidu.tieba.bj6
    public void e(View view2, String str, ValueCallback<String> valueCallback) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048580, this, view2, str, valueCallback) == null) && !TextUtils.isEmpty(str)) {
            if (view2 instanceof WebView) {
                ((WebView) view2).evaluateJavascript(str, valueCallback);
            } else if (view2 instanceof TbWebView) {
                ((TbWebView) view2).w(str, valueCallback);
            }
        }
    }

    @Override // com.baidu.tieba.bj6
    public void i(View view2, String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2, str, jSONObject) == null) {
            j(view2, str, jSONObject, null);
        }
    }

    public final void l(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, str, str2, str3) == null) {
            StatisticItem statisticItem = new StatisticItem("js_call_native");
            statisticItem.addParam("obj_type", str);
            statisticItem.addParam("obj_name", str2);
            statisticItem.addParam("obj_source", str3);
            TiebaStatic.log(statisticItem);
        }
    }

    public final void m(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048588, this, str, str2, str3) == null) {
            StatisticItem statisticItem = new StatisticItem("native_call_js");
            statisticItem.addParam("obj_type", str);
            statisticItem.addParam("obj_name", str2);
            statisticItem.addParam("obj_source", str3);
            TiebaStatic.log(statisticItem);
        }
    }

    public final boolean p(TbPageContext<?> tbPageContext, String str, osa osaVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048591, this, tbPageContext, str, osaVar)) == null) {
            if (osaVar == null || osaVar.i() || !SchemeActionManager.getInstance().doSchemeAction(tbPageContext, str)) {
                return false;
            }
            osaVar.s(true);
            osaVar.z(0);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    @Override // com.baidu.tieba.bj6
    public void f(dj6 dj6Var, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048581, this, dj6Var, obj) == null) && (obj instanceof msa)) {
            this.b.add(dj6Var);
            this.c.a((msa) obj);
        }
    }

    @Override // com.baidu.tieba.bj6
    public void h(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, jSONObject) == null) {
            g(str, jSONObject, null);
        }
    }

    @Override // com.baidu.tieba.bj6
    public void g(String str, JSONObject jSONObject, WebView webView) {
        WebView webView2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, str, jSONObject, webView) == null) {
            for (WeakReference<WebView> weakReference : fj6.b().a()) {
                if (weakReference != null && (webView2 = weakReference.get()) != null) {
                    j(webView2, str, jSONObject, webView);
                }
            }
        }
    }

    public void j(View view2, String str, JSONObject jSONObject, WebView webView) {
        WebView webView2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048585, this, view2, str, jSONObject, webView) == null) {
            if (view2 instanceof WebView) {
                webView2 = (WebView) view2;
            } else if (view2 instanceof TbWebView) {
                webView2 = ((TbWebView) view2).getInnerWebView();
            } else {
                webView2 = null;
            }
            if (webView2 == null) {
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("key", str);
                jSONObject2.put("data", jSONObject);
                if (webView != null) {
                    jSONObject2.put("sourceWebviewId", webView.toString());
                }
                this.c.b(webView2, jSONObject2.toString());
            } catch (Exception e) {
                TbLog hybridLog = HybridLog.getInstance();
                hybridLog.e("JsBridge", "dispatchEvent Exception:" + e);
            }
        }
    }

    public final boolean k(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048586, this, webView, str, str2, str3, jsPromptResult)) == null) {
            Iterator<dj6> it = this.b.iterator();
            while (it.hasNext()) {
                dj6 next = it.next();
                if (next != null && next.b(webView, str, str2, str3, jsPromptResult)) {
                    return true;
                }
            }
            return false;
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean n(WebView webView, String str, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048589, this, webView, str, jsPromptResult)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                TbLog hybridLog = HybridLog.getInstance();
                hybridLog.i("JsBridge", "旧版端能力：start processJSON json:" + str + " " + webView);
                JSONObject jSONObject = new JSONObject(str);
                return k(webView, jSONObject.optString("interfaceName", ""), jSONObject.optString("methodName", ""), jSONObject.optString("param", ""), jsPromptResult);
            } catch (JSONException e) {
                TbLog hybridLog2 = HybridLog.getInstance();
                hybridLog2.e("JsBridge", "旧版端能力异常：processJSON JSONException:" + e);
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public final boolean o(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, webView, str)) == null) {
            TbLog hybridLog = HybridLog.getInstance();
            hybridLog.i("JsBridge", "新版端能力：start processScheme scheme:" + str + " " + webView);
            qsa qsaVar = new qsa();
            String a = ssa.a(str);
            String d = ssa.d(str);
            String b = ssa.b(str);
            qsaVar.f(a);
            qsaVar.h(d);
            osa osaVar = new osa();
            osaVar.w(b);
            if (qd.isEmpty(a) || qd.isEmpty(d) || qd.isEmpty(b)) {
                osaVar.z(101);
            }
            try {
                qsaVar.j(ssa.f(str));
            } catch (JSONException unused) {
                qsaVar.j(new JSONObject());
                osaVar.z(101);
            }
            qsaVar.i(ssa.e(str));
            qsaVar.g(ssa.c(str));
            osa d2 = this.c.d(webView, qsaVar, osaVar);
            if (d2.g()) {
                this.c.e(webView, d2);
                return false;
            }
            p(zpa.c(webView.getContext()), str, d2);
            return false;
        }
        return invokeLL.booleanValue;
    }
}
