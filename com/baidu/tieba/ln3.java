package com.baidu.tieba;

import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ln3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull kn3 kn3Var, @NonNull by2 by2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, kn3Var, by2Var) == null) {
            kn3Var.f(by2Var.d());
            kn3Var.g(by2Var.e());
            if (by2Var.g()) {
                kn3Var.a(1);
            } else {
                kn3Var.e(1);
            }
        }
    }

    public static FrameLayout.LayoutParams b(@NonNull cu1 cu1Var, @NonNull by2 by2Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, cu1Var, by2Var)) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(by2Var.f(), by2Var.c());
            int i2 = 0;
            if (by2Var.g()) {
                i2 = cu1Var.getWebViewScrollX();
                i = cu1Var.getWebViewScrollY();
            } else {
                i = 0;
            }
            layoutParams.leftMargin = by2Var.d() + i2;
            layoutParams.topMargin = by2Var.e() + i;
            return layoutParams;
        }
        return (FrameLayout.LayoutParams) invokeLL.objValue;
    }
}
