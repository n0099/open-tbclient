package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class z26 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(View view2, Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, view2, runnable) == null) {
            view2.postDelayed(runnable, 16L);
        }
    }

    public static void b(View view2, Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, view2, drawable) == null) {
            view2.setBackgroundDrawable(drawable);
        }
    }
}
