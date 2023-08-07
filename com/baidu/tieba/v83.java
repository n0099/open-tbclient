package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tieba.vv2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class v83 extends ai3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void onEvent(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            vv2.a W = xa3.K().q().W();
            bi3 bi3Var = new bi3();
            bi3Var.b = str;
            bi3Var.a = rh3.n(W.G());
            bi3Var.f = W.H();
            bi3Var.c = W.T();
            rh3.x("1045", bi3Var);
        }
    }
}
