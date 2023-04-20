package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tieba.ss2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class t53 extends xe3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void onEvent(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            ss2.a W = u73.K().q().W();
            ye3 ye3Var = new ye3();
            ye3Var.b = str;
            ye3Var.a = oe3.n(W.G());
            ye3Var.f = W.H();
            ye3Var.c = W.T();
            oe3.x("1088", ye3Var);
        }
    }
}
