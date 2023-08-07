package com.baidu.tieba;

import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class oq3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull nq3 nq3Var, @NonNull e13 e13Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, nq3Var, e13Var) == null) {
            nq3Var.f(e13Var.d());
            nq3Var.g(e13Var.e());
            if (e13Var.g()) {
                nq3Var.a(1);
            } else {
                nq3Var.e(1);
            }
        }
    }

    public static FrameLayout.LayoutParams b(@NonNull fx1 fx1Var, @NonNull e13 e13Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, fx1Var, e13Var)) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(e13Var.f(), e13Var.c());
            int i2 = 0;
            if (e13Var.g()) {
                i2 = fx1Var.getWebViewScrollX();
                i = fx1Var.getWebViewScrollY();
            } else {
                i = 0;
            }
            layoutParams.leftMargin = e13Var.d() + i2;
            layoutParams.topMargin = e13Var.e() + i;
            return layoutParams;
        }
        return (FrameLayout.LayoutParams) invokeLL.objValue;
    }
}
