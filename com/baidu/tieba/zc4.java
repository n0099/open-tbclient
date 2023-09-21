package com.baidu.tieba;

import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class zc4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(oi2 oi2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, oi2Var) == null) && oi2Var != null && oi2Var.m().hasEventListener("audiointerruptionbegin") && j54.h().i()) {
            oi2Var.dispatchEvent(new JSEvent("audiointerruptionbegin"));
        }
    }

    public static void b(oi2 oi2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, oi2Var) == null) && oi2Var != null && oi2Var.m().hasEventListener("audiointerruptionend")) {
            oi2Var.dispatchEvent(new JSEvent("audiointerruptionend"));
        }
    }
}
