package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class ry9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(dn5 dn5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, dn5Var)) == null) {
            if (dn5Var != null) {
                return dn5Var.isViewAttached();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void b(dn5 dn5Var, View.OnClickListener onClickListener, Context context, View view2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{dn5Var, onClickListener, context, view2, str, Boolean.valueOf(z)}) == null) && !a(dn5Var) && context != null && view2 != null) {
            if (dn5Var == null) {
                dn5Var = new dn5(context, onClickListener);
            }
            dn5Var.j(context.getResources().getDimensionPixelSize(R.dimen.tbds530));
            dn5Var.attachView(view2, z);
            dn5Var.o();
            dn5Var.onChangeSkinType();
        }
    }
}
