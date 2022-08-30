package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class vg3 {
    public static /* synthetic */ Interceptable $ic;
    public static xg3 a;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static xg3 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (a == null) {
                a = new xg3("0");
            }
            return a;
        }
        return (xg3) invokeV.objValue;
    }

    public static void b(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            xg3 xg3Var = a;
            if (xg3Var == null) {
                a = new xg3(str);
            } else {
                xg3Var.n(str);
            }
        }
    }
}
