package com.baidu.tieba;

import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class jn3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull in3 in3Var, @NonNull zx2 zx2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, in3Var, zx2Var) == null) {
            in3Var.f(zx2Var.d());
            in3Var.g(zx2Var.e());
            if (zx2Var.g()) {
                in3Var.a(1);
            } else {
                in3Var.e(1);
            }
        }
    }

    public static FrameLayout.LayoutParams b(@NonNull au1 au1Var, @NonNull zx2 zx2Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, au1Var, zx2Var)) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(zx2Var.f(), zx2Var.c());
            int i2 = 0;
            if (zx2Var.g()) {
                i2 = au1Var.getWebViewScrollX();
                i = au1Var.getWebViewScrollY();
            } else {
                i = 0;
            }
            layoutParams.leftMargin = zx2Var.d() + i2;
            layoutParams.topMargin = zx2Var.e() + i;
            return layoutParams;
        }
        return (FrameLayout.LayoutParams) invokeLL.objValue;
    }
}
