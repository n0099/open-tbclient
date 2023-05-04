package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tieba.us2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class u53 extends ze3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void onEvent(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            us2.a W = w73.K().q().W();
            af3 af3Var = new af3();
            af3Var.b = str;
            af3Var.a = qe3.n(W.G());
            af3Var.f = W.H();
            af3Var.c = W.T();
            qe3.x("1045", af3Var);
        }
    }
}
