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
/* loaded from: classes8.dex */
public class wy9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<xy9> a;
    public final ez9 b;

    public wy9() {
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
        this.b = new ez9();
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

    public void a(xy9 xy9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, xy9Var) != null) || xy9Var == null) {
            return;
        }
        this.a.add(xy9Var);
        if (xy9Var.getClass().getAnnotation(ip.class) != null) {
            try {
                this.b.a((zy9) Class.forName("com.baidu.tieba.h5power." + xy9Var.getClass().getSimpleName() + zy9.PROXY_CLASS_NAME_SUFFIX).getConstructor(xy9Var.getClass()).newInstance(xy9Var));
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

    public final boolean g(TbPageContext<?> tbPageContext, String str, bz9 bz9Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, tbPageContext, str, bz9Var)) == null) {
            if (bz9Var == null || bz9Var.i() || !SchemeActionManager.getInstance().doSchemeAction(tbPageContext, str)) {
                return false;
            }
            bz9Var.s(true);
            bz9Var.z(0);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public void i(WebView webView, String str, @Nullable HashMap hashMap) {
        ez9 ez9Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, webView, str, hashMap) != null) || (ez9Var = this.b) == null) {
            return;
        }
        this.b.e(webView, ez9Var.f(webView, str, hashMap));
    }

    public boolean d(String str, JsPromptResult jsPromptResult) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, jsPromptResult)) == null) {
            if (StringUtils.isNull(str)) {
                return false;
            }
            try {
                zq8 hybridLog = HybridLog.getInstance();
                hybridLog.c("JsBridge", "processJSON json:" + str);
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("interfaceName");
                String optString2 = jSONObject.optString("methodName");
                String optString3 = jSONObject.optString("param");
                if (!StringUtils.isNull(optString) && !StringUtils.isNull(optString2) && !StringUtils.isNull(optString3)) {
                    return e(optString, optString2, optString3, jsPromptResult);
                }
                zq8 hybridLog2 = HybridLog.getInstance();
                hybridLog2.b("JsBridge", "processJSON fail interfaceName:" + optString + " methodName:" + optString2 + " params:" + optString3);
                return false;
            } catch (JSONException e) {
                zq8 hybridLog3 = HybridLog.getInstance();
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
        zq8 hybridLog = HybridLog.getInstance();
        hybridLog.c("JsBridge", "processScheme scheme:" + str);
        dz9 dz9Var = new dz9();
        bz9 bz9Var = new bz9();
        String a = fz9.a(str);
        dz9Var.f(a);
        String d = fz9.d(str);
        dz9Var.h(d);
        String b = fz9.b(str);
        bz9Var.w(b);
        if (ui.isEmpty(a) || ui.isEmpty(d) || ui.isEmpty(b)) {
            bz9Var.z(101);
        }
        try {
            dz9Var.j(fz9.f(str));
        } catch (JSONException unused) {
            dz9Var.j(new JSONObject());
            bz9Var.z(101);
        }
        dz9Var.i(fz9.e(str));
        dz9Var.g(fz9.c(str));
        bz9 c = this.b.c(dz9Var, bz9Var);
        if (c.g()) {
            this.b.d(webView, c);
        } else {
            g(mw9.a(webView.getContext()), str, c);
        }
    }

    public final boolean e(String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, str, str2, str3, jsPromptResult)) == null) {
            if (ListUtils.getCount(this.a) > 0) {
                Iterator<xy9> it = this.a.iterator();
                while (it.hasNext()) {
                    xy9 next = it.next();
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
