package com.baidu.tieba;

import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class m94 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(bf2 bf2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, bf2Var) == null) && bf2Var != null && bf2Var.n().hasEventListener("audiointerruptionbegin") && w14.h().i()) {
            bf2Var.dispatchEvent(new JSEvent("audiointerruptionbegin"));
        }
    }

    public static void b(bf2 bf2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, bf2Var) == null) && bf2Var != null && bf2Var.n().hasEventListener("audiointerruptionend")) {
            bf2Var.dispatchEvent(new JSEvent("audiointerruptionend"));
        }
    }
}
