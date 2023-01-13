package com.baidu.tieba;

import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class zj3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull yj3 yj3Var, @NonNull pu2 pu2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, yj3Var, pu2Var) == null) {
            yj3Var.f(pu2Var.d());
            yj3Var.g(pu2Var.e());
            if (pu2Var.g()) {
                yj3Var.a(1);
            } else {
                yj3Var.e(1);
            }
        }
    }

    public static FrameLayout.LayoutParams b(@NonNull qq1 qq1Var, @NonNull pu2 pu2Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, qq1Var, pu2Var)) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(pu2Var.f(), pu2Var.c());
            int i2 = 0;
            if (pu2Var.g()) {
                i2 = qq1Var.getWebViewScrollX();
                i = qq1Var.getWebViewScrollY();
            } else {
                i = 0;
            }
            layoutParams.leftMargin = pu2Var.d() + i2;
            layoutParams.topMargin = pu2Var.e() + i;
            return layoutParams;
        }
        return (FrameLayout.LayoutParams) invokeLL.objValue;
    }
}
