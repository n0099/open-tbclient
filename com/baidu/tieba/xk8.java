package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class xk8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static tk8<uk8> a(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            tk8<uk8> tk8Var = new tk8<>();
            tk8Var.e().j(1);
            uk8 uk8Var = new uk8();
            uk8Var.f(str);
            tk8Var.i(uk8Var);
            return tk8Var;
        }
        return (tk8) invokeL.objValue;
    }
}
