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
/* loaded from: classes6.dex */
public class vq5 {
    public static /* synthetic */ Interceptable $ic;
    public static vq5 b;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, uq5> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948249455, "Lcom/baidu/tieba/vq5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948249455, "Lcom/baidu/tieba/vq5;");
        }
    }

    /* loaded from: classes6.dex */
    public class a implements qc9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oc9 a;
        public final /* synthetic */ WebView b;

        public a(vq5 vq5Var, oc9 oc9Var, WebView webView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vq5Var, oc9Var, webView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oc9Var;
            this.b = webView;
        }

        @Override // com.baidu.tieba.qc9
        public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, jsPromptResult)) == null) {
                oc9 oc9Var = this.a;
                if (oc9Var != null) {
                    return oc9Var.c(this.b, str, jsPromptResult);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    public vq5() {
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

    public static vq5 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (b == null) {
                synchronized (vq5.class) {
                    if (b == null) {
                        b = new vq5();
                    }
                }
            }
            return b;
        }
        return (vq5) invokeV.objValue;
    }

    public uq5 a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, str)) == null) {
            if (this.a.size() >= 8) {
                f();
            }
            uq5 uq5Var = new uq5();
            BridgeWebView bridgeWebView = new BridgeWebView(new MutableContextWrapper(context));
            bridgeWebView.setBackgroundColor(R.color.transparent);
            wq5.b(bridgeWebView);
            oc9 oc9Var = new oc9();
            oc9Var.a(new CommonTbJsBridge(context, bridgeWebView));
            nt4 nt4Var = new nt4();
            nt4Var.b(new a(this, oc9Var, bridgeWebView));
            bridgeWebView.setWebChromeClient(nt4Var);
            uq5Var.a = bridgeWebView;
            uq5Var.b = str;
            uq5Var.c = 0;
            this.a.put(str, uq5Var);
            return uq5Var;
        }
        return (uq5) invokeLL.objValue;
    }

    public uq5 c(Activity activity, String str) {
        InterceptResult invokeLL;
        WebView webView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, str)) == null) {
            uq5 uq5Var = this.a.get(str);
            if (uq5Var != null && (webView = uq5Var.a) != null) {
                ((MutableContextWrapper) webView.getContext()).setBaseContext(activity);
                this.a.remove(str);
                return uq5Var;
            }
            return null;
        }
        return (uq5) invokeLL.objValue;
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
                uq5 uq5Var = this.a.get(str2);
                if (uq5Var != null) {
                    if (uq5Var.d < j) {
                        str = uq5Var.b;
                    }
                    j = uq5Var.d;
                }
            }
            if (str != null) {
                this.a.remove(str);
            }
        }
    }
}
