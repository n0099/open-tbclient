package com.baidu.tieba;

import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class s24 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(i82 i82Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, i82Var) == null) && i82Var != null && i82Var.m().hasEventListener("audiointerruptionbegin") && cv3.h().i()) {
            i82Var.dispatchEvent(new JSEvent("audiointerruptionbegin"));
        }
    }

    public static void b(i82 i82Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, i82Var) == null) && i82Var != null && i82Var.m().hasEventListener("audiointerruptionend")) {
            i82Var.dispatchEvent(new JSEvent("audiointerruptionend"));
        }
    }
}
