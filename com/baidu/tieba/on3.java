package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class on3 {
    public static /* synthetic */ Interceptable $ic;
    public static qn3 a;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static qn3 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (a == null) {
                a = new qn3("0");
            }
            return a;
        }
        return (qn3) invokeV.objValue;
    }

    public static void b(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            qn3 qn3Var = a;
            if (qn3Var == null) {
                a = new qn3(str);
            } else {
                qn3Var.n(str);
            }
        }
    }
}
