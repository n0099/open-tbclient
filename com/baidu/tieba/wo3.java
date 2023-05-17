package com.baidu.tieba;

import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class wo3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull vo3 vo3Var, @NonNull mz2 mz2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, vo3Var, mz2Var) == null) {
            vo3Var.f(mz2Var.d());
            vo3Var.g(mz2Var.e());
            if (mz2Var.g()) {
                vo3Var.a(1);
            } else {
                vo3Var.e(1);
            }
        }
    }

    public static FrameLayout.LayoutParams b(@NonNull nv1 nv1Var, @NonNull mz2 mz2Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, nv1Var, mz2Var)) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(mz2Var.f(), mz2Var.c());
            int i2 = 0;
            if (mz2Var.g()) {
                i2 = nv1Var.getWebViewScrollX();
                i = nv1Var.getWebViewScrollY();
            } else {
                i = 0;
            }
            layoutParams.leftMargin = mz2Var.d() + i2;
            layoutParams.topMargin = mz2Var.e() + i;
            return layoutParams;
        }
        return (FrameLayout.LayoutParams) invokeLL.objValue;
    }
}
