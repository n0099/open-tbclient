package com.baidu.tieba;

import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class nm2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static lm2 a(SwanAppActivity swanAppActivity, m93 m93Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, swanAppActivity, m93Var)) == null) {
            if (m93Var == null || !m93Var.I()) {
                return null;
            }
            int k = m93Var.k();
            if (k != 0) {
                if (k != 1) {
                    return null;
                }
                return us2.i().n(swanAppActivity, m93Var.b);
            }
            return new om2(swanAppActivity, m93Var.b);
        }
        return (lm2) invokeLL.objValue;
    }
}
