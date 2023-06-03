package com.baidu.tieba;

import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class or3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull nr3 nr3Var, @NonNull e23 e23Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, nr3Var, e23Var) == null) {
            nr3Var.f(e23Var.d());
            nr3Var.g(e23Var.e());
            if (e23Var.g()) {
                nr3Var.a(1);
            } else {
                nr3Var.e(1);
            }
        }
    }

    public static FrameLayout.LayoutParams b(@NonNull fy1 fy1Var, @NonNull e23 e23Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, fy1Var, e23Var)) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(e23Var.f(), e23Var.c());
            int i2 = 0;
            if (e23Var.g()) {
                i2 = fy1Var.getWebViewScrollX();
                i = fy1Var.getWebViewScrollY();
            } else {
                i = 0;
            }
            layoutParams.leftMargin = e23Var.d() + i2;
            layoutParams.topMargin = e23Var.e() + i;
            return layoutParams;
        }
        return (FrameLayout.LayoutParams) invokeLL.objValue;
    }
}
