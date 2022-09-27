package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tieba.io2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class j13 extends na3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void onEvent(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            io2.a W = k33.K().q().W();
            oa3 oa3Var = new oa3();
            oa3Var.b = str;
            oa3Var.a = ea3.n(W.G());
            oa3Var.f = W.H();
            oa3Var.c = W.T();
            ea3.x("1088", oa3Var);
        }
    }
}
