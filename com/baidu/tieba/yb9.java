package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class yb9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static ub9<vb9> a(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            ub9<vb9> ub9Var = new ub9<>();
            ub9Var.e().k(1);
            vb9 vb9Var = new vb9();
            vb9Var.f(str);
            ub9Var.i(vb9Var);
            return ub9Var;
        }
        return (ub9) invokeL.objValue;
    }
}
