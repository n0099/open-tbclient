package com.baidu.tieba;

import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class n94 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(cf2 cf2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, cf2Var) == null) && cf2Var != null && cf2Var.n().hasEventListener("audiointerruptionbegin") && x14.h().i()) {
            cf2Var.dispatchEvent(new JSEvent("audiointerruptionbegin"));
        }
    }

    public static void b(cf2 cf2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, cf2Var) == null) && cf2Var != null && cf2Var.n().hasEventListener("audiointerruptionend")) {
            cf2Var.dispatchEvent(new JSEvent("audiointerruptionend"));
        }
    }
}
