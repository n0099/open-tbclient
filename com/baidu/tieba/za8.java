package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class za8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static va8<wa8> a(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            va8<wa8> va8Var = new va8<>();
            va8Var.e().j(1);
            wa8 wa8Var = new wa8();
            wa8Var.b(str);
            va8Var.i(wa8Var);
            return va8Var;
        }
        return (va8) invokeL.objValue;
    }
}
