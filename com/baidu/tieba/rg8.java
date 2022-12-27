package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class rg8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(la5 la5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, la5Var)) == null) {
            if (la5Var != null) {
                return la5Var.isViewAttached();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void b(la5 la5Var, View.OnClickListener onClickListener, Context context, View view2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{la5Var, onClickListener, context, view2, str, Boolean.valueOf(z)}) == null) && !a(la5Var) && context != null && view2 != null) {
            if (la5Var == null) {
                la5Var = new la5(context, onClickListener);
            }
            la5Var.k(context.getResources().getDimensionPixelSize(R.dimen.tbds530));
            la5Var.attachView(view2, z);
            la5Var.p();
            la5Var.onChangeSkinType();
        }
    }
}
