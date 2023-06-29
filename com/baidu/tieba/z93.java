package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tieba.zw2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class z93 extends ej3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void onEvent(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            zw2.a W = bc3.K().q().W();
            fj3 fj3Var = new fj3();
            fj3Var.b = str;
            fj3Var.a = vi3.n(W.G());
            fj3Var.f = W.H();
            fj3Var.c = W.T();
            vi3.x("1045", fj3Var);
        }
    }
}
