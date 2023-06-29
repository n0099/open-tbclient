package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class mp9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(en5 en5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, en5Var)) == null) {
            if (en5Var != null) {
                return en5Var.isViewAttached();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void b(en5 en5Var, View.OnClickListener onClickListener, Context context, View view2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{en5Var, onClickListener, context, view2, str, Boolean.valueOf(z)}) == null) && !a(en5Var) && context != null && view2 != null) {
            if (en5Var == null) {
                en5Var = new en5(context, onClickListener);
            }
            en5Var.k(context.getResources().getDimensionPixelSize(R.dimen.tbds530));
            en5Var.attachView(view2, z);
            en5Var.p();
            en5Var.onChangeSkinType();
        }
    }
}
