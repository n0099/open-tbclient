package com.baidu.tieba;

import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class xl2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static vl2 a(SwanAppActivity swanAppActivity, w83 w83Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, swanAppActivity, w83Var)) == null) {
            if (w83Var == null || !w83Var.I()) {
                return null;
            }
            int k = w83Var.k();
            if (k != 0) {
                if (k != 1) {
                    return null;
                }
                return es2.i().n(swanAppActivity, w83Var.b);
            }
            return new yl2(swanAppActivity, w83Var.b);
        }
        return (vl2) invokeLL.objValue;
    }
}
