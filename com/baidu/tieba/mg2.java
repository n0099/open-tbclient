package com.baidu.tieba;

import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class mg2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static kg2 a(SwanAppActivity swanAppActivity, l33 l33Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, swanAppActivity, l33Var)) == null) {
            if (l33Var == null || !l33Var.I()) {
                return null;
            }
            int k = l33Var.k();
            if (k != 0) {
                if (k != 1) {
                    return null;
                }
                return tm2.i().n(swanAppActivity, l33Var.b);
            }
            return new ng2(swanAppActivity, l33Var.b);
        }
        return (kg2) invokeLL.objValue;
    }
}
