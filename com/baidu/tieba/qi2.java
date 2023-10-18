package com.baidu.tieba;

import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class qi2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static oi2 a(SwanAppActivity swanAppActivity, p53 p53Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, swanAppActivity, p53Var)) == null) {
            if (p53Var == null || !p53Var.I()) {
                return null;
            }
            int k = p53Var.k();
            if (k != 0) {
                if (k != 1) {
                    return null;
                }
                return xo2.i().n(swanAppActivity, p53Var.b);
            }
            return new ri2(swanAppActivity, p53Var.b);
        }
        return (oi2) invokeLL.objValue;
    }
}
