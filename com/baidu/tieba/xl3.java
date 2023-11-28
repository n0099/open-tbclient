package com.baidu.tieba;

import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class xl3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull wl3 wl3Var, @NonNull nw2 nw2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, wl3Var, nw2Var) == null) {
            wl3Var.f(nw2Var.d());
            wl3Var.g(nw2Var.e());
            if (nw2Var.g()) {
                wl3Var.a(1);
            } else {
                wl3Var.e(1);
            }
        }
    }

    public static FrameLayout.LayoutParams b(@NonNull ps1 ps1Var, @NonNull nw2 nw2Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, ps1Var, nw2Var)) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(nw2Var.f(), nw2Var.c());
            int i2 = 0;
            if (nw2Var.g()) {
                i2 = ps1Var.getWebViewScrollX();
                i = ps1Var.getWebViewScrollY();
            } else {
                i = 0;
            }
            layoutParams.leftMargin = nw2Var.d() + i2;
            layoutParams.topMargin = nw2Var.e() + i;
            return layoutParams;
        }
        return (FrameLayout.LayoutParams) invokeLL.objValue;
    }
}
