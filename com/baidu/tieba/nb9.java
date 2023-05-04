package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class nb9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(jh5 jh5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, jh5Var)) == null) {
            if (jh5Var != null) {
                return jh5Var.isViewAttached();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void b(jh5 jh5Var, View.OnClickListener onClickListener, Context context, View view2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{jh5Var, onClickListener, context, view2, str, Boolean.valueOf(z)}) == null) && !a(jh5Var) && context != null && view2 != null) {
            if (jh5Var == null) {
                jh5Var = new jh5(context, onClickListener);
            }
            jh5Var.k(context.getResources().getDimensionPixelSize(R.dimen.tbds530));
            jh5Var.attachView(view2, z);
            jh5Var.p();
            jh5Var.onChangeSkinType();
        }
    }
}
