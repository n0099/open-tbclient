package com.baidu.tieba;

import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class lj2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static jj2 a(SwanAppActivity swanAppActivity, k63 k63Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, swanAppActivity, k63Var)) == null) {
            if (k63Var == null || !k63Var.I()) {
                return null;
            }
            int k = k63Var.k();
            if (k != 0) {
                if (k != 1) {
                    return null;
                }
                return sp2.i().n(swanAppActivity, k63Var.b);
            }
            return new mj2(swanAppActivity, k63Var.b);
        }
        return (jj2) invokeLL.objValue;
    }
}
