package com.baidu.tieba;

import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class oi3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull ni3 ni3Var, @NonNull et2 et2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, ni3Var, et2Var) == null) {
            ni3Var.f(et2Var.d());
            ni3Var.g(et2Var.e());
            if (et2Var.g()) {
                ni3Var.a(1);
            } else {
                ni3Var.e(1);
            }
        }
    }

    public static FrameLayout.LayoutParams b(@NonNull fp1 fp1Var, @NonNull et2 et2Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, fp1Var, et2Var)) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(et2Var.f(), et2Var.c());
            int i2 = 0;
            if (et2Var.g()) {
                i2 = fp1Var.getWebViewScrollX();
                i = fp1Var.getWebViewScrollY();
            } else {
                i = 0;
            }
            layoutParams.leftMargin = et2Var.d() + i2;
            layoutParams.topMargin = et2Var.e() + i;
            return layoutParams;
        }
        return (FrameLayout.LayoutParams) invokeLL.objValue;
    }
}
