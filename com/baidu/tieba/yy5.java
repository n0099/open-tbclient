package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.webkit.JsPromptResult;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.hybrid.BridgeWebView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes9.dex */
public class yy5 {
    public static /* synthetic */ Interceptable $ic;
    public static yy5 b;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, xy5> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948346516, "Lcom/baidu/tieba/yy5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948346516, "Lcom/baidu/tieba/yy5;");
        }
    }

    /* loaded from: classes9.dex */
    public class a implements jia {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hia a;
        public final /* synthetic */ WebView b;

        public a(yy5 yy5Var, hia hiaVar, WebView webView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yy5Var, hiaVar, webView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hiaVar;
            this.b = webView;
        }

        @Override // com.baidu.tieba.jia
        public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, jsPromptResult)) == null) {
                hia hiaVar = this.a;
                if (hiaVar != null) {
                    return hiaVar.c(this.b, str, jsPromptResult);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    public yy5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new HashMap<>();
    }

    public static yy5 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (b == null) {
                synchronized (yy5.class) {
                    if (b == null) {
                        b = new yy5();
                    }
                }
            }
            return b;
        }
        return (yy5) invokeV.objValue;
    }

    public xy5 a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, str)) == null) {
            if (this.a.size() >= 8) {
                f();
            }
            xy5 xy5Var = new xy5();
            BridgeWebView bridgeWebView = new BridgeWebView(new MutableContextWrapper(context));
            bridgeWebView.setBackgroundColor(R.color.transparent);
            zy5.b(bridgeWebView);
            hia hiaVar = new hia();
            hiaVar.a(new CommonTbJsBridge(context, bridgeWebView));
            dx4 dx4Var = new dx4();
            dx4Var.b(new a(this, hiaVar, bridgeWebView));
            bridgeWebView.setWebChromeClient(dx4Var);
            xy5Var.a = bridgeWebView;
            xy5Var.b = str;
            xy5Var.c = 0;
            this.a.put(str, xy5Var);
            return xy5Var;
        }
        return (xy5) invokeLL.objValue;
    }

    public xy5 c(Activity activity, String str) {
        InterceptResult invokeLL;
        WebView webView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, str)) == null) {
            xy5 xy5Var = this.a.get(str);
            if (xy5Var != null && (webView = xy5Var.a) != null) {
                ((MutableContextWrapper) webView.getContext()).setBaseContext(activity);
                this.a.remove(str);
                return xy5Var;
            }
            return null;
        }
        return (xy5) invokeLL.objValue;
    }

    public boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            return this.a.containsKey(str);
        }
        return invokeL.booleanValue;
    }

    public boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (this.a.containsKey(str) && this.a.get(str) != null && this.a.get(str).a()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            long j = 0;
            String str = null;
            for (String str2 : this.a.keySet()) {
                xy5 xy5Var = this.a.get(str2);
                if (xy5Var != null) {
                    if (xy5Var.d < j) {
                        str = xy5Var.b;
                    }
                    j = xy5Var.d;
                }
            }
            if (str != null) {
                this.a.remove(str);
            }
        }
    }
}
