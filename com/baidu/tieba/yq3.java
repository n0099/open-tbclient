package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class yq3 {
    public static /* synthetic */ Interceptable $ic;
    public static ar3 a;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static ar3 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (a == null) {
                a = new ar3("0");
            }
            return a;
        }
        return (ar3) invokeV.objValue;
    }

    public static void b(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            ar3 ar3Var = a;
            if (ar3Var == null) {
                a = new ar3(str);
            } else {
                ar3Var.n(str);
            }
        }
    }
}
