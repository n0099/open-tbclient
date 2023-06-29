package com.baidu.tieba;

import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class sr3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull rr3 rr3Var, @NonNull i23 i23Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, rr3Var, i23Var) == null) {
            rr3Var.f(i23Var.d());
            rr3Var.g(i23Var.e());
            if (i23Var.g()) {
                rr3Var.a(1);
            } else {
                rr3Var.e(1);
            }
        }
    }

    public static FrameLayout.LayoutParams b(@NonNull jy1 jy1Var, @NonNull i23 i23Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, jy1Var, i23Var)) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i23Var.f(), i23Var.c());
            int i2 = 0;
            if (i23Var.g()) {
                i2 = jy1Var.getWebViewScrollX();
                i = jy1Var.getWebViewScrollY();
            } else {
                i = 0;
            }
            layoutParams.leftMargin = i23Var.d() + i2;
            layoutParams.topMargin = i23Var.e() + i;
            return layoutParams;
        }
        return (FrameLayout.LayoutParams) invokeLL.objValue;
    }
}
