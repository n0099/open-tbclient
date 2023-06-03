package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class rj9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(um5 um5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, um5Var)) == null) {
            if (um5Var != null) {
                return um5Var.isViewAttached();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void b(um5 um5Var, View.OnClickListener onClickListener, Context context, View view2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{um5Var, onClickListener, context, view2, str, Boolean.valueOf(z)}) == null) && !a(um5Var) && context != null && view2 != null) {
            if (um5Var == null) {
                um5Var = new um5(context, onClickListener);
            }
            um5Var.k(context.getResources().getDimensionPixelSize(R.dimen.tbds530));
            um5Var.attachView(view2, z);
            um5Var.p();
            um5Var.onChangeSkinType();
        }
    }
}
