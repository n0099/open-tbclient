package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class kd9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(si5 si5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, si5Var)) == null) {
            if (si5Var != null) {
                return si5Var.isViewAttached();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void b(si5 si5Var, View.OnClickListener onClickListener, Context context, View view2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{si5Var, onClickListener, context, view2, str, Boolean.valueOf(z)}) == null) && !a(si5Var) && context != null && view2 != null) {
            if (si5Var == null) {
                si5Var = new si5(context, onClickListener);
            }
            si5Var.k(context.getResources().getDimensionPixelSize(R.dimen.tbds530));
            si5Var.attachView(view2, z);
            si5Var.p();
            si5Var.onChangeSkinType();
        }
    }
}
