package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class ur3 {
    public static /* synthetic */ Interceptable $ic;
    public static wr3 a;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static wr3 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (a == null) {
                a = new wr3("0");
            }
            return a;
        }
        return (wr3) invokeV.objValue;
    }

    public static void b(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            wr3 wr3Var = a;
            if (wr3Var == null) {
                a = new wr3(str);
            } else {
                wr3Var.n(str);
            }
        }
    }
}
