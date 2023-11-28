package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class ub9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static qb9<rb9> a(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            qb9<rb9> qb9Var = new qb9<>();
            qb9Var.e().k(1);
            rb9 rb9Var = new rb9();
            rb9Var.f(str);
            qb9Var.i(rb9Var);
            return qb9Var;
        }
        return (qb9) invokeL.objValue;
    }
}
