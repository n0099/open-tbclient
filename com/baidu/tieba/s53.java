package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tieba.rs2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class s53 extends we3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void onEvent(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            rs2.a W = t73.K().q().W();
            xe3 xe3Var = new xe3();
            xe3Var.b = str;
            xe3Var.a = ne3.n(W.G());
            xe3Var.f = W.H();
            xe3Var.c = W.T();
            ne3.x("1088", xe3Var);
        }
    }
}
