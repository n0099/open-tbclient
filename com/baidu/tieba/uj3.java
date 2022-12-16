package com.baidu.tieba;

import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class uj3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull tj3 tj3Var, @NonNull ku2 ku2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, tj3Var, ku2Var) == null) {
            tj3Var.f(ku2Var.d());
            tj3Var.g(ku2Var.e());
            if (ku2Var.g()) {
                tj3Var.a(1);
            } else {
                tj3Var.e(1);
            }
        }
    }

    public static FrameLayout.LayoutParams b(@NonNull lq1 lq1Var, @NonNull ku2 ku2Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, lq1Var, ku2Var)) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ku2Var.f(), ku2Var.c());
            int i2 = 0;
            if (ku2Var.g()) {
                i2 = lq1Var.getWebViewScrollX();
                i = lq1Var.getWebViewScrollY();
            } else {
                i = 0;
            }
            layoutParams.leftMargin = ku2Var.d() + i2;
            layoutParams.topMargin = ku2Var.e() + i;
            return layoutParams;
        }
        return (FrameLayout.LayoutParams) invokeLL.objValue;
    }
}
