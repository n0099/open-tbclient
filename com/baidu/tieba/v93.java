package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tieba.vw2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class v93 extends aj3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void onEvent(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            vw2.a W = xb3.K().q().W();
            bj3 bj3Var = new bj3();
            bj3Var.b = str;
            bj3Var.a = ri3.n(W.G());
            bj3Var.f = W.H();
            bj3Var.c = W.T();
            ri3.x("1045", bj3Var);
        }
    }
}
