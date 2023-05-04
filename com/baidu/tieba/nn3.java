package com.baidu.tieba;

import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class nn3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull mn3 mn3Var, @NonNull dy2 dy2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, mn3Var, dy2Var) == null) {
            mn3Var.f(dy2Var.d());
            mn3Var.g(dy2Var.e());
            if (dy2Var.g()) {
                mn3Var.a(1);
            } else {
                mn3Var.e(1);
            }
        }
    }

    public static FrameLayout.LayoutParams b(@NonNull eu1 eu1Var, @NonNull dy2 dy2Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, eu1Var, dy2Var)) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dy2Var.f(), dy2Var.c());
            int i2 = 0;
            if (dy2Var.g()) {
                i2 = eu1Var.getWebViewScrollX();
                i = eu1Var.getWebViewScrollY();
            } else {
                i = 0;
            }
            layoutParams.leftMargin = dy2Var.d() + i2;
            layoutParams.topMargin = dy2Var.e() + i;
            return layoutParams;
        }
        return (FrameLayout.LayoutParams) invokeLL.objValue;
    }
}
