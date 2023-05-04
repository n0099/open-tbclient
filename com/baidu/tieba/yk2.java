package com.baidu.tieba;

import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class yk2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static wk2 a(SwanAppActivity swanAppActivity, x73 x73Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, swanAppActivity, x73Var)) == null) {
            if (x73Var == null || !x73Var.I()) {
                return null;
            }
            int k = x73Var.k();
            if (k != 0) {
                if (k != 1) {
                    return null;
                }
                return fr2.i().n(swanAppActivity, x73Var.b);
            }
            return new zk2(swanAppActivity, x73Var.b);
        }
        return (wk2) invokeLL.objValue;
    }
}
