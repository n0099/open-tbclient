package com.baidu.tieba;

import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class pv0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull cu0 cu0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, cu0Var) == null) && bu0.f() && p21.p()) {
            cu0Var.c(new qv0(), new FrameLayout.LayoutParams(-1, -2));
        }
    }
}
