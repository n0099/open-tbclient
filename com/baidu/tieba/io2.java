package com.baidu.tieba;

import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class io2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static go2 a(SwanAppActivity swanAppActivity, hb3 hb3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, swanAppActivity, hb3Var)) == null) {
            if (hb3Var == null || !hb3Var.I()) {
                return null;
            }
            int k = hb3Var.k();
            if (k != 0) {
                if (k != 1) {
                    return null;
                }
                return pu2.i().n(swanAppActivity, hb3Var.b);
            }
            return new jo2(swanAppActivity, hb3Var.b);
        }
        return (go2) invokeLL.objValue;
    }
}
