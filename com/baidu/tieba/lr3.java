package com.baidu.tieba;

import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class lr3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull kr3 kr3Var, @NonNull b23 b23Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, kr3Var, b23Var) == null) {
            kr3Var.f(b23Var.d());
            kr3Var.g(b23Var.e());
            if (b23Var.g()) {
                kr3Var.a(1);
            } else {
                kr3Var.e(1);
            }
        }
    }

    public static FrameLayout.LayoutParams b(@NonNull cy1 cy1Var, @NonNull b23 b23Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, cy1Var, b23Var)) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(b23Var.f(), b23Var.c());
            int i2 = 0;
            if (b23Var.g()) {
                i2 = cy1Var.getWebViewScrollX();
                i = cy1Var.getWebViewScrollY();
            } else {
                i = 0;
            }
            layoutParams.leftMargin = b23Var.d() + i2;
            layoutParams.topMargin = b23Var.e() + i;
            return layoutParams;
        }
        return (FrameLayout.LayoutParams) invokeLL.objValue;
    }
}
