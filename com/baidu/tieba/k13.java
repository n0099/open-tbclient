package com.baidu.tieba;

import com.baidu.tieba.jo2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class k13 extends oa3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void onEvent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            jo2.a W = l33.K().q().W();
            pa3 pa3Var = new pa3();
            pa3Var.b = str;
            pa3Var.a = fa3.n(W.G());
            pa3Var.f = W.H();
            pa3Var.c = W.T();
            fa3.x("1088", pa3Var);
        }
    }
}
