package com.baidu.tieba;

import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ng2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static lg2 a(SwanAppActivity swanAppActivity, m33 m33Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, swanAppActivity, m33Var)) == null) {
            if (m33Var == null || !m33Var.I()) {
                return null;
            }
            int k = m33Var.k();
            if (k != 0) {
                if (k != 1) {
                    return null;
                }
                return um2.i().n(swanAppActivity, m33Var.b);
            }
            return new og2(swanAppActivity, m33Var.b);
        }
        return (lg2) invokeLL.objValue;
    }
}
