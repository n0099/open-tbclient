package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JsFunction;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class r84 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public JsFunction a;
    public JsFunction b;
    public JsFunction c;

    public r84() {
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

    public void b() {
        JsFunction jsFunction;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (jsFunction = this.c) != null) {
            jsFunction.call();
        }
    }

    public void c() {
        JsFunction jsFunction;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (jsFunction = this.b) != null) {
            jsFunction.call();
        }
    }

    public static r84 d(sy1 sy1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, sy1Var)) == null) {
            if (sy1Var == null) {
                return null;
            }
            r84 r84Var = new r84();
            JsFunction v = sy1Var.v("onCheckForUpdate");
            r84Var.a = v;
            if (v != null) {
                v.setReleaseMode(false);
            }
            JsFunction v2 = sy1Var.v("onUpdateReady");
            r84Var.b = v2;
            if (v2 != null) {
                v2.setReleaseMode(false);
            }
            JsFunction v3 = sy1Var.v("onUpdateFailed");
            r84Var.c = v3;
            if (v3 != null) {
                v3.setReleaseMode(false);
            }
            return r84Var;
        }
        return (r84) invokeL.objValue;
    }

    public void a(s84 s84Var) {
        JsFunction jsFunction;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, s84Var) == null) && (jsFunction = this.a) != null) {
            jsFunction.call(s84Var);
        }
    }
}
