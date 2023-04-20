package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class qn3 {
    public static /* synthetic */ Interceptable $ic;
    public static sn3 a;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static sn3 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (a == null) {
                a = new sn3("0");
            }
            return a;
        }
        return (sn3) invokeV.objValue;
    }

    public static void b(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            sn3 sn3Var = a;
            if (sn3Var == null) {
                a = new sn3(str);
            } else {
                sn3Var.n(str);
            }
        }
    }
}
