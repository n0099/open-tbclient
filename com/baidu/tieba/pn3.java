package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class pn3 {
    public static /* synthetic */ Interceptable $ic;
    public static rn3 a;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static rn3 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (a == null) {
                a = new rn3("0");
            }
            return a;
        }
        return (rn3) invokeV.objValue;
    }

    public static void b(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            rn3 rn3Var = a;
            if (rn3Var == null) {
                a = new rn3(str);
            } else {
                rn3Var.n(str);
            }
        }
    }
}
