package com.baidu.tieba;

import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ns0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull ar0 ar0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, ar0Var) == null) && zq0.f() && oz0.q()) {
            ar0Var.c(new os0(), new FrameLayout.LayoutParams(-1, -2));
        }
    }
}
