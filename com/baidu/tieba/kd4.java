package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JsFunction;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class kd4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public JsFunction a;
    public JsFunction b;
    public JsFunction c;

    public kd4() {
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

    public static kd4 d(k32 k32Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, k32Var)) == null) {
            if (k32Var == null) {
                return null;
            }
            kd4 kd4Var = new kd4();
            JsFunction u = k32Var.u("onCheckForUpdate");
            kd4Var.a = u;
            if (u != null) {
                u.setReleaseMode(false);
            }
            JsFunction u2 = k32Var.u("onUpdateReady");
            kd4Var.b = u2;
            if (u2 != null) {
                u2.setReleaseMode(false);
            }
            JsFunction u3 = k32Var.u("onUpdateFailed");
            kd4Var.c = u3;
            if (u3 != null) {
                u3.setReleaseMode(false);
            }
            return kd4Var;
        }
        return (kd4) invokeL.objValue;
    }

    public void a(ld4 ld4Var) {
        JsFunction jsFunction;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, ld4Var) == null) && (jsFunction = this.a) != null) {
            jsFunction.call(ld4Var);
        }
    }
}
