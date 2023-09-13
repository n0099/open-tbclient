package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher;
import com.baidu.swan.apps.jsbridge.SwanAppGlobalJsBridge;
import com.baidu.swan.apps.jsbridge.SwanAppJsBridge;
import com.baidu.swan.apps.jsbridge.SwanAppNativeSwanJsBridge;
import com.baidu.swan.apps.jsbridge.SwanAppPreloadJsBridge;
import com.baidu.swan.apps.jsbridge.SwanAppUtilsJavaScriptInterface;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class qv2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public pv2 a;
    public pv2 b;
    public SwanAppUtilsJavaScriptInterface c;
    public fz1 d;

    public qv2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void a(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, activity) == null) {
            pv2 pv2Var = this.a;
            if (pv2Var != null) {
                pv2Var.setActivityRef(activity);
            }
            pv2 pv2Var2 = this.b;
            if (pv2Var2 != null) {
                pv2Var2.setActivityRef(activity);
            }
            SwanAppUtilsJavaScriptInterface swanAppUtilsJavaScriptInterface = this.c;
            if (swanAppUtilsJavaScriptInterface != null) {
                swanAppUtilsJavaScriptInterface.setActivity(activity);
            }
            fz1 fz1Var = this.d;
            if (fz1Var != null) {
                fz1Var.i(activity);
            }
        }
    }

    public final void d(fa2 fa2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fa2Var) == null) {
            fa2Var.addJavascriptInterface(new SwanAppNativeSwanJsBridge(fa2Var), SwanAppNativeSwanJsBridge.JAVASCRIPT_INTERFACE_NAME);
        }
    }

    public final void b(fa2 fa2Var, Context context, CallbackHandler callbackHandler, UnitedSchemeMainDispatcher unitedSchemeMainDispatcher, @NonNull fz1 fz1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fa2Var, context, callbackHandler, unitedSchemeMainDispatcher, fz1Var) == null) {
            SwanAppGlobalJsBridge swanAppGlobalJsBridge = new SwanAppGlobalJsBridge(context, unitedSchemeMainDispatcher, callbackHandler, fa2Var);
            this.a = swanAppGlobalJsBridge;
            fa2Var.addJavascriptInterface(swanAppGlobalJsBridge, SwanAppGlobalJsBridge.JAVASCRIPT_INTERFACE_NAME);
            SwanAppJsBridge swanAppJsBridge = new SwanAppJsBridge(context, unitedSchemeMainDispatcher, callbackHandler, fa2Var);
            this.b = swanAppJsBridge;
            fa2Var.addJavascriptInterface(swanAppJsBridge, SwanAppJsBridge.JAVASCRIPT_INTERFACE_NAME);
            fa2Var.addJavascriptInterface(new SwanAppPreloadJsBridge(fa2Var), SwanAppPreloadJsBridge.JAVASCRIPT_INTERFACE_NAME);
            fz1Var.b(fa2Var);
        }
    }

    public final void c(@NonNull fa2 fa2Var, Context context, @NonNull fz1 fz1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, fa2Var, context, fz1Var) == null) {
            SwanAppUtilsJavaScriptInterface swanAppUtilsJavaScriptInterface = new SwanAppUtilsJavaScriptInterface(context, fa2Var);
            this.c = swanAppUtilsJavaScriptInterface;
            swanAppUtilsJavaScriptInterface.setSource("swan_");
            fa2Var.addJavascriptInterface(this.c, SwanAppUtilsJavaScriptInterface.JAVASCRIPT_INTERFACE_NAME);
            fz1Var.a(fa2Var);
        }
    }

    public void e(fa2 fa2Var, Context context, CallbackHandler callbackHandler, UnitedSchemeMainDispatcher unitedSchemeMainDispatcher) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048580, this, fa2Var, context, callbackHandler, unitedSchemeMainDispatcher) == null) && fa2Var != null && context != null && callbackHandler != null && unitedSchemeMainDispatcher != null) {
            fz1 fz1Var = new fz1(context, callbackHandler, fa2Var);
            this.d = fz1Var;
            b(fa2Var, context, callbackHandler, unitedSchemeMainDispatcher, fz1Var);
            if (fa2Var instanceof ri2) {
                c(fa2Var, context, this.d);
            } else {
                d(fa2Var);
            }
        }
    }

    public void f(Context context, fa2 fa2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, context, fa2Var) == null) {
            SwanAppUtilsJavaScriptInterface swanAppUtilsJavaScriptInterface = new SwanAppUtilsJavaScriptInterface(context, fa2Var);
            this.c = swanAppUtilsJavaScriptInterface;
            swanAppUtilsJavaScriptInterface.setSource("swan_");
            fa2Var.addJavascriptInterface(this.c, SwanAppUtilsJavaScriptInterface.JAVASCRIPT_INTERFACE_NAME);
            this.c.setForceShareLight(true);
        }
    }
}
