package com.baidu.tieba;

import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class wc4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(li2 li2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, li2Var) == null) && li2Var != null && li2Var.m().hasEventListener("audiointerruptionbegin") && g54.h().i()) {
            li2Var.dispatchEvent(new JSEvent("audiointerruptionbegin"));
        }
    }

    public static void b(li2 li2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, li2Var) == null) && li2Var != null && li2Var.m().hasEventListener("audiointerruptionend")) {
            li2Var.dispatchEvent(new JSEvent("audiointerruptionend"));
        }
    }
}
