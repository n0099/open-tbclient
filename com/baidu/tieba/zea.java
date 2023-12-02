package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class zea {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(fk5 fk5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, fk5Var)) == null) {
            if (fk5Var != null) {
                return fk5Var.isViewAttached();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void b(fk5 fk5Var, View.OnClickListener onClickListener, Context context, View view2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{fk5Var, onClickListener, context, view2, str, Boolean.valueOf(z)}) == null) && !a(fk5Var) && context != null && view2 != null) {
            if (fk5Var == null) {
                fk5Var = new fk5(context, onClickListener);
            }
            fk5Var.k(context.getResources().getDimensionPixelSize(R.dimen.tbds530));
            fk5Var.attachView(view2, z);
            fk5Var.q();
            fk5Var.onChangeSkinType();
        }
    }
}
