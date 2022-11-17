package com.baidu.tieba;

import android.webkit.JsPromptResult;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
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
/* loaded from: classes6.dex */
public class yp8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<zp8> a;
    public gq8 b;

    public yp8() {
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
        this.b = new gq8();
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a.clear();
        }
    }

    public void a(zp8 zp8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, zp8Var) == null) {
            if (zp8Var != null) {
                this.a.add(zp8Var);
            }
            if (this.b != null && zp8Var != null && zp8Var.getClass().getAnnotation(ro.class) != null) {
                try {
                    this.b.a((bq8) Class.forName("com.baidu.tieba.h5power." + zp8Var.getClass().getSimpleName() + bq8.PROXY_CLASS_NAME_SUFFIX).getConstructor(zp8Var.getClass()).newInstance(zp8Var));
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
        }
    }

    public boolean b(WebView webView, String str, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, jsPromptResult)) == null) {
            if (str.startsWith("tiebaapp")) {
                e(webView, str);
                return false;
            }
            return c(str, jsPromptResult);
        }
        return invokeLLL.booleanValue;
    }

    public final boolean f(TbPageContext<?> tbPageContext, String str, dq8 dq8Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, tbPageContext, str, dq8Var)) == null) {
            if (dq8Var == null || dq8Var.i() || !SchemeActionManager.getInstance().doSchemeAction(tbPageContext, str)) {
                return false;
            }
            dq8Var.r(true);
            dq8Var.y(0);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public void h(WebView webView, String str, @Nullable HashMap hashMap) {
        gq8 gq8Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048583, this, webView, str, hashMap) != null) || (gq8Var = this.b) == null) {
            return;
        }
        this.b.e(webView, gq8Var.f(str, hashMap));
    }

    public boolean c(String str, JsPromptResult jsPromptResult) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, jsPromptResult)) == null) {
            if (StringUtils.isNull(str)) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("interfaceName");
                String optString2 = jSONObject.optString("methodName");
                String optString3 = jSONObject.optString("param");
                if (!StringUtils.isNull(optString) && !StringUtils.isNull(optString2) && !StringUtils.isNull(optString3)) {
                    return d(optString, optString2, optString3, jsPromptResult);
                }
            } catch (JSONException unused) {
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final boolean d(String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, str, str2, str3, jsPromptResult)) == null) {
            if (ListUtils.getCount(this.a) > 0) {
                Iterator<zp8> it = this.a.iterator();
                while (it.hasNext()) {
                    zp8 next = it.next();
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

    public final void e(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048580, this, webView, str) != null) || this.b == null) {
            return;
        }
        fq8 fq8Var = new fq8();
        dq8 dq8Var = new dq8();
        String a = hq8.a(str);
        fq8Var.f(a);
        String d = hq8.d(str);
        fq8Var.h(d);
        String b = hq8.b(str);
        dq8Var.v(b);
        if (xi.isEmpty(a) || xi.isEmpty(d) || xi.isEmpty(b)) {
            dq8Var.y(101);
        }
        try {
            fq8Var.j(hq8.f(str));
        } catch (JSONException unused) {
            fq8Var.j(new JSONObject());
            dq8Var.y(101);
        }
        fq8Var.i(hq8.e(str));
        fq8Var.g(hq8.c(str));
        dq8 c = this.b.c(fq8Var, dq8Var);
        if (c.g()) {
            this.b.d(webView, c);
        } else {
            f(pn8.a(webView.getContext()), str, c);
        }
    }
}
