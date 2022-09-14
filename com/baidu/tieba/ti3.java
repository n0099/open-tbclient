package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ti3 {
    public static /* synthetic */ Interceptable $ic;
    public static vi3 a;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static vi3 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (a == null) {
                a = new vi3("0");
            }
            return a;
        }
        return (vi3) invokeV.objValue;
    }

    public static void b(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            vi3 vi3Var = a;
            if (vi3Var == null) {
                a = new vi3(str);
            } else {
                vi3Var.n(str);
            }
        }
    }
}
