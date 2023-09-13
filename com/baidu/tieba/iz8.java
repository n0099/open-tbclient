package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class iz8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static ez8<fz8> a(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            ez8<fz8> ez8Var = new ez8<>();
            ez8Var.e().j(1);
            fz8 fz8Var = new fz8();
            fz8Var.f(str);
            ez8Var.i(fz8Var);
            return ez8Var;
        }
        return (ez8) invokeL.objValue;
    }
}
