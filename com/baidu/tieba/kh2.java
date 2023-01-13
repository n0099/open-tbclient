package com.baidu.tieba;

import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class kh2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ih2 a(SwanAppActivity swanAppActivity, j43 j43Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, swanAppActivity, j43Var)) == null) {
            if (j43Var == null || !j43Var.I()) {
                return null;
            }
            int k = j43Var.k();
            if (k != 0) {
                if (k != 1) {
                    return null;
                }
                return rn2.i().n(swanAppActivity, j43Var.b);
            }
            return new lh2(swanAppActivity, j43Var.b);
        }
        return (ih2) invokeLL.objValue;
    }
}
