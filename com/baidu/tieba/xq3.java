package com.baidu.tieba;

import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class xq3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull wq3 wq3Var, @NonNull n13 n13Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, wq3Var, n13Var) == null) {
            wq3Var.f(n13Var.d());
            wq3Var.g(n13Var.e());
            if (n13Var.g()) {
                wq3Var.a(1);
            } else {
                wq3Var.e(1);
            }
        }
    }

    public static FrameLayout.LayoutParams b(@NonNull ox1 ox1Var, @NonNull n13 n13Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, ox1Var, n13Var)) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(n13Var.f(), n13Var.c());
            int i2 = 0;
            if (n13Var.g()) {
                i2 = ox1Var.getWebViewScrollX();
                i = ox1Var.getWebViewScrollY();
            } else {
                i = 0;
            }
            layoutParams.leftMargin = n13Var.d() + i2;
            layoutParams.topMargin = n13Var.e() + i;
            return layoutParams;
        }
        return (FrameLayout.LayoutParams) invokeLL.objValue;
    }
}
