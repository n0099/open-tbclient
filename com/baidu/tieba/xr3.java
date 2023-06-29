package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class xr3 {
    public static /* synthetic */ Interceptable $ic;
    public static zr3 a;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static zr3 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (a == null) {
                a = new zr3("0");
            }
            return a;
        }
        return (zr3) invokeV.objValue;
    }

    public static void b(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            zr3 zr3Var = a;
            if (zr3Var == null) {
                a = new zr3(str);
            } else {
                zr3Var.n(str);
            }
        }
    }
}
