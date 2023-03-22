package com.baidu.tieba;

import android.webkit.JsPromptResult;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.log.HybridLog;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.schemeaction.SchemeActionManager;
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
/* loaded from: classes5.dex */
public class oc9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<pc9> a;
    public final wc9 b;

    public oc9() {
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
        this.b = new wc9();
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

    public void a(pc9 pc9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, pc9Var) != null) || pc9Var == null) {
            return;
        }
        this.a.add(pc9Var);
        if (pc9Var.getClass().getAnnotation(fo.class) != null) {
            try {
                this.b.a((rc9) Class.forName("com.baidu.tieba.h5power." + pc9Var.getClass().getSimpleName() + rc9.PROXY_CLASS_NAME_SUFFIX).getConstructor(pc9Var.getClass()).newInstance(pc9Var));
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

    public final boolean g(TbPageContext<?> tbPageContext, String str, tc9 tc9Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, tbPageContext, str, tc9Var)) == null) {
            if (tc9Var == null || tc9Var.i() || !SchemeActionManager.getInstance().doSchemeAction(tbPageContext, str)) {
                return false;
            }
            tc9Var.r(true);
            tc9Var.y(0);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public void i(WebView webView, String str, @Nullable HashMap hashMap) {
        wc9 wc9Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, webView, str, hashMap) != null) || (wc9Var = this.b) == null) {
            return;
        }
        this.b.e(webView, wc9Var.f(webView, str, hashMap));
    }

    public boolean d(String str, JsPromptResult jsPromptResult) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, jsPromptResult)) == null) {
            if (StringUtils.isNull(str)) {
                return false;
            }
            try {
                w58 hybridLog = HybridLog.getInstance();
                hybridLog.c("JsBridge", "processJSON json:" + str);
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("interfaceName");
                String optString2 = jSONObject.optString("methodName");
                String optString3 = jSONObject.optString("param");
                if (!StringUtils.isNull(optString) && !StringUtils.isNull(optString2) && !StringUtils.isNull(optString3)) {
                    return e(optString, optString2, optString3, jsPromptResult);
                }
                w58 hybridLog2 = HybridLog.getInstance();
                hybridLog2.b("JsBridge", "processJSON fail interfaceName:" + optString + " methodName:" + optString2 + " params:" + optString3);
                return false;
            } catch (JSONException e) {
                w58 hybridLog3 = HybridLog.getInstance();
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
        w58 hybridLog = HybridLog.getInstance();
        hybridLog.c("JsBridge", "processScheme scheme:" + str);
        vc9 vc9Var = new vc9();
        tc9 tc9Var = new tc9();
        String a = xc9.a(str);
        vc9Var.f(a);
        String d = xc9.d(str);
        vc9Var.h(d);
        String b = xc9.b(str);
        tc9Var.v(b);
        if (gi.isEmpty(a) || gi.isEmpty(d) || gi.isEmpty(b)) {
            tc9Var.y(101);
        }
        try {
            vc9Var.j(xc9.f(str));
        } catch (JSONException unused) {
            vc9Var.j(new JSONObject());
            tc9Var.y(101);
        }
        vc9Var.i(xc9.e(str));
        vc9Var.g(xc9.c(str));
        tc9 c = this.b.c(vc9Var, tc9Var);
        if (c.g()) {
            this.b.d(webView, c);
        } else {
            g(ea9.a(webView.getContext()), str, c);
        }
    }

    public final boolean e(String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, str, str2, str3, jsPromptResult)) == null) {
            if (ListUtils.getCount(this.a) > 0) {
                Iterator<pc9> it = this.a.iterator();
                while (it.hasNext()) {
                    pc9 next = it.next();
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
