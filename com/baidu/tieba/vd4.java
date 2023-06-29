package com.baidu.tieba;

import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class vd4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(kj2 kj2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, kj2Var) == null) && kj2Var != null && kj2Var.m().hasEventListener("audiointerruptionbegin") && f64.h().i()) {
            kj2Var.dispatchEvent(new JSEvent("audiointerruptionbegin"));
        }
    }

    public static void b(kj2 kj2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, kj2Var) == null) && kj2Var != null && kj2Var.m().hasEventListener("audiointerruptionend")) {
            kj2Var.dispatchEvent(new JSEvent("audiointerruptionend"));
        }
    }
}
