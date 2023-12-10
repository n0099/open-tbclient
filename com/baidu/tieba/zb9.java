package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class zb9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static vb9<wb9> a(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            vb9<wb9> vb9Var = new vb9<>();
            vb9Var.e().k(1);
            wb9 wb9Var = new wb9();
            wb9Var.f(str);
            vb9Var.i(wb9Var);
            return vb9Var;
        }
        return (vb9) invokeL.objValue;
    }
}
