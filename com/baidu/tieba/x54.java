package com.baidu.tieba;

import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class x54 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(mb2 mb2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, mb2Var) == null) && mb2Var != null && mb2Var.n().hasEventListener("audiointerruptionbegin") && hy3.h().i()) {
            mb2Var.dispatchEvent(new JSEvent("audiointerruptionbegin"));
        }
    }

    public static void b(mb2 mb2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, mb2Var) == null) && mb2Var != null && mb2Var.n().hasEventListener("audiointerruptionend")) {
            mb2Var.dispatchEvent(new JSEvent("audiointerruptionend"));
        }
    }
}
