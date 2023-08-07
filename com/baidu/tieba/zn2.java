package com.baidu.tieba;

import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class zn2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static xn2 a(SwanAppActivity swanAppActivity, ya3 ya3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, swanAppActivity, ya3Var)) == null) {
            if (ya3Var == null || !ya3Var.I()) {
                return null;
            }
            int k = ya3Var.k();
            if (k != 0) {
                if (k != 1) {
                    return null;
                }
                return gu2.i().n(swanAppActivity, ya3Var.b);
            }
            return new ao2(swanAppActivity, ya3Var.b);
        }
        return (xn2) invokeLL.objValue;
    }
}
