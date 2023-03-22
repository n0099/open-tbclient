package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tieba.qs2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class q53 extends ve3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void onEvent(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            qs2.a W = s73.K().q().W();
            we3 we3Var = new we3();
            we3Var.b = str;
            we3Var.a = me3.n(W.G());
            we3Var.f = W.H();
            we3Var.c = W.T();
            me3.x("1045", we3Var);
        }
    }
}
