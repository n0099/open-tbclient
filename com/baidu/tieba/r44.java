package com.baidu.tieba;

import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class r44 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(ga2 ga2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, ga2Var) == null) && ga2Var != null && ga2Var.n().hasEventListener("audiointerruptionbegin") && bx3.h().i()) {
            ga2Var.dispatchEvent(new JSEvent("audiointerruptionbegin"));
        }
    }

    public static void b(ga2 ga2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, ga2Var) == null) && ga2Var != null && ga2Var.n().hasEventListener("audiointerruptionend")) {
            ga2Var.dispatchEvent(new JSEvent("audiointerruptionend"));
        }
    }
}
