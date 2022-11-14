package com.baidu.tieba;

import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class vj3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull uj3 uj3Var, @NonNull lu2 lu2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, uj3Var, lu2Var) == null) {
            uj3Var.f(lu2Var.d());
            uj3Var.g(lu2Var.e());
            if (lu2Var.g()) {
                uj3Var.a(1);
            } else {
                uj3Var.e(1);
            }
        }
    }

    public static FrameLayout.LayoutParams b(@NonNull mq1 mq1Var, @NonNull lu2 lu2Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, mq1Var, lu2Var)) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(lu2Var.f(), lu2Var.c());
            int i2 = 0;
            if (lu2Var.g()) {
                i2 = mq1Var.getWebViewScrollX();
                i = mq1Var.getWebViewScrollY();
            } else {
                i = 0;
            }
            layoutParams.leftMargin = lu2Var.d() + i2;
            layoutParams.topMargin = lu2Var.e() + i;
            return layoutParams;
        }
        return (FrameLayout.LayoutParams) invokeLL.objValue;
    }
}
