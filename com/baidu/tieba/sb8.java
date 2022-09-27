package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class sb8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(g95 g95Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, g95Var)) == null) {
            if (g95Var != null) {
                return g95Var.isViewAttached();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void b(g95 g95Var, View.OnClickListener onClickListener, Context context, View view2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{g95Var, onClickListener, context, view2, str, Boolean.valueOf(z)}) == null) || a(g95Var) || context == null || view2 == null) {
            return;
        }
        if (g95Var == null) {
            g95Var = new g95(context, onClickListener);
        }
        g95Var.k(context.getResources().getDimensionPixelSize(R.dimen.tbds530));
        g95Var.attachView(view2, z);
        g95Var.p();
        g95Var.onChangeSkinType();
    }
}
