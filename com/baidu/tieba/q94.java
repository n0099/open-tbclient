package com.baidu.tieba;

import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class q94 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(ff2 ff2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, ff2Var) == null) && ff2Var != null && ff2Var.n().hasEventListener("audiointerruptionbegin") && a24.h().i()) {
            ff2Var.dispatchEvent(new JSEvent("audiointerruptionbegin"));
        }
    }

    public static void b(ff2 ff2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, ff2Var) == null) && ff2Var != null && ff2Var.n().hasEventListener("audiointerruptionend")) {
            ff2Var.dispatchEvent(new JSEvent("audiointerruptionend"));
        }
    }
}
