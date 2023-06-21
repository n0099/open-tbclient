package com.baidu.tieba;

import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class sd4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(hj2 hj2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, hj2Var) == null) && hj2Var != null && hj2Var.m().hasEventListener("audiointerruptionbegin") && c64.h().i()) {
            hj2Var.dispatchEvent(new JSEvent("audiointerruptionbegin"));
        }
    }

    public static void b(hj2 hj2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, hj2Var) == null) && hj2Var != null && hj2Var.m().hasEventListener("audiointerruptionend")) {
            hj2Var.dispatchEvent(new JSEvent("audiointerruptionend"));
        }
    }
}
