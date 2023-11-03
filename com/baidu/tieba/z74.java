package com.baidu.tieba;

import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class z74 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(od2 od2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, od2Var) == null) && od2Var != null && od2Var.m().hasEventListener("audiointerruptionbegin") && j04.h().i()) {
            od2Var.dispatchEvent(new JSEvent("audiointerruptionbegin"));
        }
    }

    public static void b(od2 od2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, od2Var) == null) && od2Var != null && od2Var.m().hasEventListener("audiointerruptionend")) {
            od2Var.dispatchEvent(new JSEvent("audiointerruptionend"));
        }
    }
}
