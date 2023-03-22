package com.baidu.tieba;

import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class uk2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static sk2 a(SwanAppActivity swanAppActivity, t73 t73Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, swanAppActivity, t73Var)) == null) {
            if (t73Var == null || !t73Var.I()) {
                return null;
            }
            int k = t73Var.k();
            if (k != 0) {
                if (k != 1) {
                    return null;
                }
                return br2.i().n(swanAppActivity, t73Var.b);
            }
            return new vk2(swanAppActivity, t73Var.b);
        }
        return (sk2) invokeLL.objValue;
    }
}
