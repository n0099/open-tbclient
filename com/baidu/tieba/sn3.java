package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class sn3 {
    public static /* synthetic */ Interceptable $ic;
    public static un3 a;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static un3 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (a == null) {
                a = new un3("0");
            }
            return a;
        }
        return (un3) invokeV.objValue;
    }

    public static void b(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            un3 un3Var = a;
            if (un3Var == null) {
                a = new un3(str);
            } else {
                un3Var.n(str);
            }
        }
    }
}
