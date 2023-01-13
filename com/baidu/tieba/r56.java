package com.baidu.tieba;

import android.text.TextUtils;
import android.webkit.JsPromptResult;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
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
public class r56 implements h76 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<j76> b;
    public final s56 c;

    public r56() {
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
        this.c = new s56();
    }

    @Override // com.baidu.tieba.h76
    public void a(WebView webView, String str, @Nullable HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, webView, str, hashMap) == null) {
            this.c.e(webView, this.c.f(webView, str, hashMap));
        }
    }

    @Override // com.baidu.tieba.h76
    public boolean b(WebView webView, String str, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, jsPromptResult)) == null) {
            if (str.startsWith("tiebaapp")) {
                return f(webView, str);
            }
            return e(webView, str, jsPromptResult);
        }
        return invokeLLL.booleanValue;
    }

    public final boolean g(TbPageContext<?> tbPageContext, String str, zx8 zx8Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, tbPageContext, str, zx8Var)) == null) {
            if (zx8Var == null || zx8Var.i() || !SchemeActionManager.getInstance().doSchemeAction(tbPageContext, str)) {
                return false;
            }
            zx8Var.r(true);
            zx8Var.y(0);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    @Override // com.baidu.tieba.h76
    public void c(j76 j76Var, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, j76Var, obj) == null) && (obj instanceof xx8)) {
            this.b.add(j76Var);
            this.c.a((xx8) obj);
        }
    }

    public final boolean d(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048579, this, webView, str, str2, str3, jsPromptResult)) == null) {
            Iterator<j76> it = this.b.iterator();
            while (it.hasNext()) {
                j76 next = it.next();
                if (next != null && next.b(webView, str, str2, str3, jsPromptResult)) {
                    return true;
                }
            }
            return false;
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean e(WebView webView, String str, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, webView, str, jsPromptResult)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                return d(webView, jSONObject.optString("interfaceName", ""), jSONObject.optString("methodName", ""), jSONObject.optString(Constants.EXTRA_PARAM, ""), jsPromptResult);
            } catch (JSONException unused) {
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public final boolean f(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, webView, str)) == null) {
            by8 by8Var = new by8();
            String a = dy8.a(str);
            String d = dy8.d(str);
            String b = dy8.b(str);
            by8Var.f(a);
            by8Var.h(d);
            zx8 zx8Var = new zx8();
            zx8Var.v(b);
            if (yi.isEmpty(a) || yi.isEmpty(d) || yi.isEmpty(b)) {
                zx8Var.y(101);
            }
            try {
                by8Var.j(dy8.f(str));
            } catch (JSONException unused) {
                by8Var.j(new JSONObject());
                zx8Var.y(101);
            }
            by8Var.i(dy8.e(str));
            by8Var.g(dy8.c(str));
            zx8 c = this.c.c(webView, by8Var, zx8Var);
            if (c.g()) {
                this.c.d(webView, c);
                return false;
            }
            g(lv8.a(webView.getContext()), str, c);
            return false;
        }
        return invokeLL.booleanValue;
    }
}
