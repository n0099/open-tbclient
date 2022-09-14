package com.baidu.tieba;

import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class zf2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static xf2 a(SwanAppActivity swanAppActivity, y23 y23Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, swanAppActivity, y23Var)) == null) {
            if (y23Var == null || !y23Var.I()) {
                return null;
            }
            int k = y23Var.k();
            if (k != 0) {
                if (k != 1) {
                    return null;
                }
                return gm2.i().n(swanAppActivity, y23Var.b);
            }
            return new ag2(swanAppActivity, y23Var.b);
        }
        return (xf2) invokeLL.objValue;
    }
}
