package com.baidu.tieba;

import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class za4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(og2 og2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, og2Var) == null) && og2Var != null && og2Var.n().hasEventListener("audiointerruptionbegin") && j34.h().i()) {
            og2Var.dispatchEvent(new JSEvent("audiointerruptionbegin"));
        }
    }

    public static void b(og2 og2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, og2Var) == null) && og2Var != null && og2Var.n().hasEventListener("audiointerruptionend")) {
            og2Var.dispatchEvent(new JSEvent("audiointerruptionend"));
        }
    }
}
