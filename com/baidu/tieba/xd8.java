package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class xd8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(ja5 ja5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, ja5Var)) == null) {
            if (ja5Var != null) {
                return ja5Var.isViewAttached();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void b(ja5 ja5Var, View.OnClickListener onClickListener, Context context, View view2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{ja5Var, onClickListener, context, view2, str, Boolean.valueOf(z)}) == null) && !a(ja5Var) && context != null && view2 != null) {
            if (ja5Var == null) {
                ja5Var = new ja5(context, onClickListener);
            }
            ja5Var.k(context.getResources().getDimensionPixelSize(R.dimen.tbds530));
            ja5Var.attachView(view2, z);
            ja5Var.p();
            ja5Var.onChangeSkinType();
        }
    }
}
