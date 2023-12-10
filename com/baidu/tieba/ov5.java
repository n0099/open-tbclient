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
/* loaded from: classes7.dex */
public class ov5 {
    public static /* synthetic */ Interceptable $ic;
    public static ov5 b;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, nv5> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948045723, "Lcom/baidu/tieba/ov5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948045723, "Lcom/baidu/tieba/ov5;");
        }
    }

    /* loaded from: classes7.dex */
    public class a implements dxa {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bxa a;
        public final /* synthetic */ WebView b;

        public a(ov5 ov5Var, bxa bxaVar, WebView webView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ov5Var, bxaVar, webView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bxaVar;
            this.b = webView;
        }

        @Override // com.baidu.tieba.dxa
        public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, jsPromptResult)) == null) {
                bxa bxaVar = this.a;
                if (bxaVar != null) {
                    return bxaVar.c(this.b, str, jsPromptResult);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    public ov5() {
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

    public static ov5 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (b == null) {
                synchronized (ov5.class) {
                    if (b == null) {
                        b = new ov5();
                    }
                }
            }
            return b;
        }
        return (ov5) invokeV.objValue;
    }

    public nv5 a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, str)) == null) {
            if (this.a.size() >= 8) {
                f();
            }
            nv5 nv5Var = new nv5();
            BridgeWebView bridgeWebView = new BridgeWebView(new MutableContextWrapper(context));
            bridgeWebView.setBackgroundColor(R.color.transparent);
            pv5.b(bridgeWebView);
            bxa bxaVar = new bxa();
            bxaVar.a(new CommonTbJsBridge(context, bridgeWebView));
            fs4 fs4Var = new fs4();
            fs4Var.b(new a(this, bxaVar, bridgeWebView));
            bridgeWebView.setWebChromeClient(fs4Var);
            nv5Var.a = bridgeWebView;
            nv5Var.b = str;
            nv5Var.c = 0;
            this.a.put(str, nv5Var);
            return nv5Var;
        }
        return (nv5) invokeLL.objValue;
    }

    public nv5 c(Activity activity, String str) {
        InterceptResult invokeLL;
        WebView webView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, str)) == null) {
            nv5 nv5Var = this.a.get(str);
            if (nv5Var != null && (webView = nv5Var.a) != null) {
                ((MutableContextWrapper) webView.getContext()).setBaseContext(activity);
                this.a.remove(str);
                return nv5Var;
            }
            return null;
        }
        return (nv5) invokeLL.objValue;
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
                nv5 nv5Var = this.a.get(str2);
                if (nv5Var != null) {
                    if (nv5Var.d < j) {
                        str = nv5Var.b;
                    }
                    j = nv5Var.d;
                }
            }
            if (str != null) {
                this.a.remove(str);
            }
        }
    }
}
