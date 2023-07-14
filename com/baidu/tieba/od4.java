package com.baidu.tieba;

import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class od4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(dj2 dj2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, dj2Var) == null) && dj2Var != null && dj2Var.m().hasEventListener("audiointerruptionbegin") && y54.h().i()) {
            dj2Var.dispatchEvent(new JSEvent("audiointerruptionbegin"));
        }
    }

    public static void b(dj2 dj2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, dj2Var) == null) && dj2Var != null && dj2Var.m().hasEventListener("audiointerruptionend")) {
            dj2Var.dispatchEvent(new JSEvent("audiointerruptionend"));
        }
    }
}
