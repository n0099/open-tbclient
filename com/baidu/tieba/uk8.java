package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class uk8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static qk8<rk8> a(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            qk8<rk8> qk8Var = new qk8<>();
            qk8Var.e().j(1);
            rk8 rk8Var = new rk8();
            rk8Var.f(str);
            qk8Var.i(rk8Var);
            return qk8Var;
        }
        return (qk8) invokeL.objValue;
    }
}
