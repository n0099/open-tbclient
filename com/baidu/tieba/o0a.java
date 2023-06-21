package com.baidu.tieba;

import android.webkit.JsPromptResult;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.schemeaction.SchemeActionManager;
import com.baidu.tieba.browser.log.HybridLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class o0a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<p0a> a;
    public final w0a b;

    public o0a() {
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
        this.a = new ArrayList<>();
        this.b = new w0a();
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a.isEmpty();
        }
        return invokeV.booleanValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.a.clear();
        }
    }

    public void a(p0a p0aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, p0aVar) != null) || p0aVar == null) {
            return;
        }
        this.a.add(p0aVar);
        if (p0aVar.getClass().getAnnotation(jp.class) != null) {
            try {
                this.b.a((r0a) Class.forName("com.baidu.tieba.h5power." + p0aVar.getClass().getSimpleName() + r0a.PROXY_CLASS_NAME_SUFFIX).getConstructor(p0aVar.getClass()).newInstance(p0aVar));
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public boolean c(WebView webView, String str, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, jsPromptResult)) == null) {
            if (str.startsWith("tiebaapp")) {
                f(webView, str);
                return false;
            }
            return d(str, jsPromptResult);
        }
        return invokeLLL.booleanValue;
    }

    public final boolean g(TbPageContext<?> tbPageContext, String str, t0a t0aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, tbPageContext, str, t0aVar)) == null) {
            if (t0aVar == null || t0aVar.i() || !SchemeActionManager.getInstance().doSchemeAction(tbPageContext, str)) {
                return false;
            }
            t0aVar.s(true);
            t0aVar.z(0);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public void i(WebView webView, String str, @Nullable HashMap hashMap) {
        w0a w0aVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, webView, str, hashMap) != null) || (w0aVar = this.b) == null) {
            return;
        }
        this.b.e(webView, w0aVar.f(webView, str, hashMap));
    }

    public boolean d(String str, JsPromptResult jsPromptResult) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, jsPromptResult)) == null) {
            if (StringUtils.isNull(str)) {
                return false;
            }
            try {
                tr8 hybridLog = HybridLog.getInstance();
                hybridLog.c("JsBridge", "processJSON json:" + str);
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("interfaceName");
                String optString2 = jSONObject.optString("methodName");
                String optString3 = jSONObject.optString("param");
                if (!StringUtils.isNull(optString) && !StringUtils.isNull(optString2) && !StringUtils.isNull(optString3)) {
                    return e(optString, optString2, optString3, jsPromptResult);
                }
                tr8 hybridLog2 = HybridLog.getInstance();
                hybridLog2.b("JsBridge", "processJSON fail interfaceName:" + optString + " methodName:" + optString2 + " params:" + optString3);
                return false;
            } catch (JSONException e) {
                tr8 hybridLog3 = HybridLog.getInstance();
                hybridLog3.b("JsBridge", "processJSON JSONException:" + e);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public final void f(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048581, this, webView, str) != null) || this.b == null) {
            return;
        }
        tr8 hybridLog = HybridLog.getInstance();
        hybridLog.c("JsBridge", "processScheme scheme:" + str);
        v0a v0aVar = new v0a();
        t0a t0aVar = new t0a();
        String a = x0a.a(str);
        v0aVar.f(a);
        String d = x0a.d(str);
        v0aVar.h(d);
        String b = x0a.b(str);
        t0aVar.w(b);
        if (vi.isEmpty(a) || vi.isEmpty(d) || vi.isEmpty(b)) {
            t0aVar.z(101);
        }
        try {
            v0aVar.j(x0a.f(str));
        } catch (JSONException unused) {
            v0aVar.j(new JSONObject());
            t0aVar.z(101);
        }
        v0aVar.i(x0a.e(str));
        v0aVar.g(x0a.c(str));
        t0a c = this.b.c(v0aVar, t0aVar);
        if (c.g()) {
            this.b.d(webView, c);
        } else {
            g(ey9.a(webView.getContext()), str, c);
        }
    }

    public final boolean e(String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, str, str2, str3, jsPromptResult)) == null) {
            if (ListUtils.getCount(this.a) > 0) {
                Iterator<p0a> it = this.a.iterator();
                while (it.hasNext()) {
                    p0a next = it.next();
                    if (next != null && next.dealJsInterface(str, str2, str3, jsPromptResult)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }
}
