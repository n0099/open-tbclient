package com.baidu.tieba;

import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class rc4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(gi2 gi2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, gi2Var) == null) && gi2Var != null && gi2Var.m().hasEventListener("audiointerruptionbegin") && b54.h().i()) {
            gi2Var.dispatchEvent(new JSEvent("audiointerruptionbegin"));
        }
    }

    public static void b(gi2 gi2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, gi2Var) == null) && gi2Var != null && gi2Var.m().hasEventListener("audiointerruptionend")) {
            gi2Var.dispatchEvent(new JSEvent("audiointerruptionend"));
        }
    }
}
