package com.baidu.tieba;

import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class wk2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static uk2 a(SwanAppActivity swanAppActivity, v73 v73Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, swanAppActivity, v73Var)) == null) {
            if (v73Var == null || !v73Var.I()) {
                return null;
            }
            int k = v73Var.k();
            if (k != 0) {
                if (k != 1) {
                    return null;
                }
                return dr2.i().n(swanAppActivity, v73Var.b);
            }
            return new xk2(swanAppActivity, v73Var.b);
        }
        return (uk2) invokeLL.objValue;
    }
}
