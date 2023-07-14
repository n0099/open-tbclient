package com.baidu.tieba;

import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class wo2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static uo2 a(SwanAppActivity swanAppActivity, vb3 vb3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, swanAppActivity, vb3Var)) == null) {
            if (vb3Var == null || !vb3Var.I()) {
                return null;
            }
            int k = vb3Var.k();
            if (k != 0) {
                if (k != 1) {
                    return null;
                }
                return dv2.i().n(swanAppActivity, vb3Var.b);
            }
            return new xo2(swanAppActivity, vb3Var.b);
        }
        return (uo2) invokeLL.objValue;
    }
}
