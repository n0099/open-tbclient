package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.hybrid.BridgeWebView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class jk5 {
    public static /* synthetic */ Interceptable $ic;
    public static jk5 b;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, ik5> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947886197, "Lcom/baidu/tieba/jk5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947886197, "Lcom/baidu/tieba/jk5;");
        }
    }

    public jk5() {
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

    public static jk5 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (b == null) {
                synchronized (jk5.class) {
                    if (b == null) {
                        b = new jk5();
                    }
                }
            }
            return b;
        }
        return (jk5) invokeV.objValue;
    }

    public ik5 a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, str)) == null) {
            if (this.a.size() >= 8) {
                e();
            }
            ik5 ik5Var = new ik5();
            BridgeWebView bridgeWebView = new BridgeWebView(new MutableContextWrapper(context));
            kk5.b(bridgeWebView);
            ik5Var.a = bridgeWebView;
            ik5Var.b = str;
            ik5Var.c = 0;
            this.a.put(str, ik5Var);
            return ik5Var;
        }
        return (ik5) invokeLL.objValue;
    }

    public ik5 c(Activity activity, String str) {
        InterceptResult invokeLL;
        WebView webView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, str)) == null) {
            ik5 ik5Var = this.a.get(str);
            if (ik5Var != null && (webView = ik5Var.a) != null) {
                ((MutableContextWrapper) webView.getContext()).setBaseContext(activity);
                this.a.remove(str);
                return ik5Var;
            }
            return null;
        }
        return (ik5) invokeLL.objValue;
    }

    public boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            return this.a.containsKey(str);
        }
        return invokeL.booleanValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            long j = 0;
            String str = null;
            for (String str2 : this.a.keySet()) {
                ik5 ik5Var = this.a.get(str2);
                if (ik5Var != null) {
                    if (ik5Var.d < j) {
                        str = ik5Var.b;
                    }
                    j = ik5Var.d;
                }
            }
            if (str != null) {
                this.a.remove(str);
            }
        }
    }
}
