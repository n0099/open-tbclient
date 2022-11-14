package com.baidu.tieba;

import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class y54 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(nb2 nb2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, nb2Var) == null) && nb2Var != null && nb2Var.n().hasEventListener("audiointerruptionbegin") && iy3.h().i()) {
            nb2Var.dispatchEvent(new JSEvent("audiointerruptionbegin"));
        }
    }

    public static void b(nb2 nb2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, nb2Var) == null) && nb2Var != null && nb2Var.n().hasEventListener("audiointerruptionend")) {
            nb2Var.dispatchEvent(new JSEvent("audiointerruptionend"));
        }
    }
}
