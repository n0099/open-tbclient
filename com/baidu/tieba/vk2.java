package com.baidu.tieba;

import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class vk2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static tk2 a(SwanAppActivity swanAppActivity, u73 u73Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, swanAppActivity, u73Var)) == null) {
            if (u73Var == null || !u73Var.I()) {
                return null;
            }
            int k = u73Var.k();
            if (k != 0) {
                if (k != 1) {
                    return null;
                }
                return cr2.i().n(swanAppActivity, u73Var.b);
            }
            return new wk2(swanAppActivity, u73Var.b);
        }
        return (tk2) invokeLL.objValue;
    }
}
