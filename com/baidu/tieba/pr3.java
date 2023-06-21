package com.baidu.tieba;

import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class pr3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull or3 or3Var, @NonNull f23 f23Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, or3Var, f23Var) == null) {
            or3Var.f(f23Var.d());
            or3Var.g(f23Var.e());
            if (f23Var.g()) {
                or3Var.a(1);
            } else {
                or3Var.e(1);
            }
        }
    }

    public static FrameLayout.LayoutParams b(@NonNull gy1 gy1Var, @NonNull f23 f23Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, gy1Var, f23Var)) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(f23Var.f(), f23Var.c());
            int i2 = 0;
            if (f23Var.g()) {
                i2 = gy1Var.getWebViewScrollX();
                i = gy1Var.getWebViewScrollY();
            } else {
                i = 0;
            }
            layoutParams.leftMargin = f23Var.d() + i2;
            layoutParams.topMargin = f23Var.e() + i;
            return layoutParams;
        }
        return (FrameLayout.LayoutParams) invokeLL.objValue;
    }
}
