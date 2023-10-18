package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class kl3 {
    public static /* synthetic */ Interceptable $ic;
    public static ml3 a;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static ml3 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (a == null) {
                a = new ml3("0");
            }
            return a;
        }
        return (ml3) invokeV.objValue;
    }

    public static void b(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            ml3 ml3Var = a;
            if (ml3Var == null) {
                a = new ml3(str);
            } else {
                ml3Var.n(str);
            }
        }
    }
}
