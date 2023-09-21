package com.baidu.tieba;

import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class wq3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull vq3 vq3Var, @NonNull m13 m13Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, vq3Var, m13Var) == null) {
            vq3Var.f(m13Var.d());
            vq3Var.g(m13Var.e());
            if (m13Var.g()) {
                vq3Var.a(1);
            } else {
                vq3Var.e(1);
            }
        }
    }

    public static FrameLayout.LayoutParams b(@NonNull nx1 nx1Var, @NonNull m13 m13Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, nx1Var, m13Var)) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(m13Var.f(), m13Var.c());
            int i2 = 0;
            if (m13Var.g()) {
                i2 = nx1Var.getWebViewScrollX();
                i = nx1Var.getWebViewScrollY();
            } else {
                i = 0;
            }
            layoutParams.leftMargin = m13Var.d() + i2;
            layoutParams.topMargin = m13Var.e() + i;
            return layoutParams;
        }
        return (FrameLayout.LayoutParams) invokeLL.objValue;
    }
}
