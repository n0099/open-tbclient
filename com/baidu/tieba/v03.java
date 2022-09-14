package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tieba.vn2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class v03 extends aa3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void onEvent(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            vn2.a W = x23.K().q().W();
            ba3 ba3Var = new ba3();
            ba3Var.b = str;
            ba3Var.a = r93.n(W.G());
            ba3Var.f = W.H();
            ba3Var.c = W.T();
            r93.x("1045", ba3Var);
        }
    }
}
