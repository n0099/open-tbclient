package com.baidu.tieba;

import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class zo2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static xo2 a(SwanAppActivity swanAppActivity, yb3 yb3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, swanAppActivity, yb3Var)) == null) {
            if (yb3Var == null || !yb3Var.I()) {
                return null;
            }
            int k = yb3Var.k();
            if (k != 0) {
                if (k != 1) {
                    return null;
                }
                return gv2.i().n(swanAppActivity, yb3Var.b);
            }
            return new ap2(swanAppActivity, yb3Var.b);
        }
        return (xo2) invokeLL.objValue;
    }
}
