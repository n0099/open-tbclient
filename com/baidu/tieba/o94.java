package com.baidu.tieba;

import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class o94 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(df2 df2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, df2Var) == null) && df2Var != null && df2Var.n().hasEventListener("audiointerruptionbegin") && y14.h().i()) {
            df2Var.dispatchEvent(new JSEvent("audiointerruptionbegin"));
        }
    }

    public static void b(df2 df2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, df2Var) == null) && df2Var != null && df2Var.n().hasEventListener("audiointerruptionend")) {
            df2Var.dispatchEvent(new JSEvent("audiointerruptionend"));
        }
    }
}
