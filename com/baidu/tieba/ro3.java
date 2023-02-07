package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ro3 {
    public static /* synthetic */ Interceptable $ic;
    public static to3 a;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static to3 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (a == null) {
                a = new to3("0");
            }
            return a;
        }
        return (to3) invokeV.objValue;
    }

    public static void b(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            to3 to3Var = a;
            if (to3Var == null) {
                a = new to3(str);
            } else {
                to3Var.n(str);
            }
        }
    }
}
