package com.baidu.tieba;

import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class qg3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull pg3 pg3Var, @NonNull gr2 gr2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, pg3Var, gr2Var) == null) {
            pg3Var.f(gr2Var.d());
            pg3Var.g(gr2Var.e());
            if (gr2Var.g()) {
                pg3Var.a(1);
            } else {
                pg3Var.e(1);
            }
        }
    }

    public static FrameLayout.LayoutParams b(@NonNull hn1 hn1Var, @NonNull gr2 gr2Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, hn1Var, gr2Var)) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(gr2Var.f(), gr2Var.c());
            int i2 = 0;
            if (gr2Var.g()) {
                i2 = hn1Var.getWebViewScrollX();
                i = hn1Var.getWebViewScrollY();
            } else {
                i = 0;
            }
            layoutParams.leftMargin = gr2Var.d() + i2;
            layoutParams.topMargin = gr2Var.e() + i;
            return layoutParams;
        }
        return (FrameLayout.LayoutParams) invokeLL.objValue;
    }
}
