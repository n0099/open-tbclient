package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tieba.tt2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class t63 extends yf3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void onEvent(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            tt2.a W = v83.K().q().W();
            zf3 zf3Var = new zf3();
            zf3Var.b = str;
            zf3Var.a = pf3.n(W.G());
            zf3Var.f = W.H();
            zf3Var.c = W.T();
            pf3.x("1045", zf3Var);
        }
    }
}
