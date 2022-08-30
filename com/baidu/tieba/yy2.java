package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tieba.xl2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class yy2 extends c83 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void onEvent(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            xl2.a W = z03.K().q().W();
            d83 d83Var = new d83();
            d83Var.b = str;
            d83Var.a = t73.n(W.G());
            d83Var.f = W.H();
            d83Var.c = W.T();
            t73.x("1088", d83Var);
        }
    }
}
