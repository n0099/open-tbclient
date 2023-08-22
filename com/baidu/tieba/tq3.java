package com.baidu.tieba;

import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class tq3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull sq3 sq3Var, @NonNull j13 j13Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, sq3Var, j13Var) == null) {
            sq3Var.f(j13Var.d());
            sq3Var.g(j13Var.e());
            if (j13Var.g()) {
                sq3Var.a(1);
            } else {
                sq3Var.e(1);
            }
        }
    }

    public static FrameLayout.LayoutParams b(@NonNull kx1 kx1Var, @NonNull j13 j13Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, kx1Var, j13Var)) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(j13Var.f(), j13Var.c());
            int i2 = 0;
            if (j13Var.g()) {
                i2 = kx1Var.getWebViewScrollX();
                i = kx1Var.getWebViewScrollY();
            } else {
                i = 0;
            }
            layoutParams.leftMargin = j13Var.d() + i2;
            layoutParams.topMargin = j13Var.e() + i;
            return layoutParams;
        }
        return (FrameLayout.LayoutParams) invokeLL.objValue;
    }
}
