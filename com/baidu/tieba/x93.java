package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tieba.ww2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class x93 extends bj3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void onEvent(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            ww2.a W = yb3.K().q().W();
            cj3 cj3Var = new cj3();
            cj3Var.b = str;
            cj3Var.a = si3.n(W.G());
            cj3Var.f = W.H();
            cj3Var.c = W.T();
            si3.x("1088", cj3Var);
        }
    }
}
