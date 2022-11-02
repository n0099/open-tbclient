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
/* loaded from: classes5.dex */
public class mp8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<np8> a;
    public up8 b;

    public mp8() {
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
        this.b = new up8();
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a.clear();
        }
    }

    public void a(np8 np8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, np8Var) == null) {
            if (np8Var != null) {
                this.a.add(np8Var);
            }
            if (this.b != null && np8Var != null && np8Var.getClass().getAnnotation(qo.class) != null) {
                try {
                    this.b.a((pp8) Class.forName("com.baidu.tieba.h5power." + np8Var.getClass().getSimpleName() + pp8.PROXY_CLASS_NAME_SUFFIX).getConstructor(np8Var.getClass()).newInstance(np8Var));
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

    public final boolean f(TbPageContext<?> tbPageContext, String str, rp8 rp8Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, tbPageContext, str, rp8Var)) == null) {
            if (rp8Var == null || rp8Var.i() || !SchemeActionManager.getInstance().doSchemeAction(tbPageContext, str)) {
                return false;
            }
            rp8Var.r(true);
            rp8Var.y(0);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public void h(WebView webView, String str, @Nullable HashMap hashMap) {
        up8 up8Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048583, this, webView, str, hashMap) != null) || (up8Var = this.b) == null) {
            return;
        }
        this.b.e(webView, up8Var.f(str, hashMap));
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
                Iterator<np8> it = this.a.iterator();
                while (it.hasNext()) {
                    np8 next = it.next();
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
        tp8 tp8Var = new tp8();
        rp8 rp8Var = new rp8();
        String a = vp8.a(str);
        tp8Var.f(a);
        String d = vp8.d(str);
        tp8Var.h(d);
        String b = vp8.b(str);
        rp8Var.v(b);
        if (wi.isEmpty(a) || wi.isEmpty(d) || wi.isEmpty(b)) {
            rp8Var.y(101);
        }
        try {
            tp8Var.j(vp8.f(str));
        } catch (JSONException unused) {
            tp8Var.j(new JSONObject());
            rp8Var.y(101);
        }
        tp8Var.i(vp8.e(str));
        tp8Var.g(vp8.c(str));
        rp8 c = this.b.c(tp8Var, rp8Var);
        if (c.g()) {
            this.b.d(webView, c);
        } else {
            f(dn8.a(webView.getContext()), str, c);
        }
    }
}
