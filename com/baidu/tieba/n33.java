package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tieba.mq2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class n33 extends rc3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void onEvent(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            mq2.a X = o53.K().q().X();
            sc3 sc3Var = new sc3();
            sc3Var.b = str;
            sc3Var.a = ic3.n(X.H());
            sc3Var.f = X.I();
            sc3Var.c = X.U();
            ic3.x("1088", sc3Var);
        }
    }
}
