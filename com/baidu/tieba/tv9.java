package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class tv9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(do5 do5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, do5Var)) == null) {
            if (do5Var != null) {
                return do5Var.isViewAttached();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void b(do5 do5Var, View.OnClickListener onClickListener, Context context, View view2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{do5Var, onClickListener, context, view2, str, Boolean.valueOf(z)}) == null) && !a(do5Var) && context != null && view2 != null) {
            if (do5Var == null) {
                do5Var = new do5(context, onClickListener);
            }
            do5Var.k(context.getResources().getDimensionPixelSize(R.dimen.tbds530));
            do5Var.attachView(view2, z);
            do5Var.p();
            do5Var.onChangeSkinType();
        }
    }
}
