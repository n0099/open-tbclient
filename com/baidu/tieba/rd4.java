package com.baidu.tieba;

import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class rd4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(gj2 gj2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, gj2Var) == null) && gj2Var != null && gj2Var.m().hasEventListener("audiointerruptionbegin") && b64.h().i()) {
            gj2Var.dispatchEvent(new JSEvent("audiointerruptionbegin"));
        }
    }

    public static void b(gj2 gj2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, gj2Var) == null) && gj2Var != null && gj2Var.m().hasEventListener("audiointerruptionend")) {
            gj2Var.dispatchEvent(new JSEvent("audiointerruptionend"));
        }
    }
}
