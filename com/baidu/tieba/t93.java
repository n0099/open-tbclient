package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tieba.sw2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class t93 extends xi3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void onEvent(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            sw2.a W = ub3.K().q().W();
            yi3 yi3Var = new yi3();
            yi3Var.b = str;
            yi3Var.a = oi3.n(W.G());
            yi3Var.f = W.H();
            yi3Var.c = W.T();
            oi3.x("1088", yi3Var);
        }
    }
}
