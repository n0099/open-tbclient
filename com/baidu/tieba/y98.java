package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class y98 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(n65 n65Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, n65Var)) == null) {
            if (n65Var != null) {
                return n65Var.isViewAttached();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void b(n65 n65Var, View.OnClickListener onClickListener, Context context, View view2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{n65Var, onClickListener, context, view2, str, Boolean.valueOf(z)}) == null) || a(n65Var) || context == null || view2 == null) {
            return;
        }
        if (n65Var == null) {
            n65Var = new n65(context, onClickListener);
        }
        n65Var.k(context.getResources().getDimensionPixelSize(R.dimen.tbds530));
        n65Var.attachView(view2, z);
        n65Var.p();
        n65Var.onChangeSkinType();
    }
}
