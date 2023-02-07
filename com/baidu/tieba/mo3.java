package com.baidu.tieba;

import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class mo3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull lo3 lo3Var, @NonNull cz2 cz2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, lo3Var, cz2Var) == null) {
            lo3Var.f(cz2Var.d());
            lo3Var.g(cz2Var.e());
            if (cz2Var.g()) {
                lo3Var.a(1);
            } else {
                lo3Var.e(1);
            }
        }
    }

    public static FrameLayout.LayoutParams b(@NonNull dv1 dv1Var, @NonNull cz2 cz2Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, dv1Var, cz2Var)) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(cz2Var.f(), cz2Var.c());
            int i2 = 0;
            if (cz2Var.g()) {
                i2 = dv1Var.getWebViewScrollX();
                i = dv1Var.getWebViewScrollY();
            } else {
                i = 0;
            }
            layoutParams.leftMargin = cz2Var.d() + i2;
            layoutParams.topMargin = cz2Var.e() + i;
            return layoutParams;
        }
        return (FrameLayout.LayoutParams) invokeLL.objValue;
    }
}
