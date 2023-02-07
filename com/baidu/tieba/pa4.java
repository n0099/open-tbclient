package com.baidu.tieba;

import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class pa4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(eg2 eg2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, eg2Var) == null) && eg2Var != null && eg2Var.n().hasEventListener("audiointerruptionbegin") && z24.h().i()) {
            eg2Var.dispatchEvent(new JSEvent("audiointerruptionbegin"));
        }
    }

    public static void b(eg2 eg2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, eg2Var) == null) && eg2Var != null && eg2Var.n().hasEventListener("audiointerruptionend")) {
            eg2Var.dispatchEvent(new JSEvent("audiointerruptionend"));
        }
    }
}
