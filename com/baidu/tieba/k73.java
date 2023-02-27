package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tieba.ju2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class k73 extends og3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void onEvent(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            ju2.a W = l93.K().q().W();
            pg3 pg3Var = new pg3();
            pg3Var.b = str;
            pg3Var.a = fg3.n(W.G());
            pg3Var.f = W.H();
            pg3Var.c = W.T();
            fg3.x("1088", pg3Var);
        }
    }
}
