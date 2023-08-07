package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class tq3 {
    public static /* synthetic */ Interceptable $ic;
    public static vq3 a;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static vq3 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (a == null) {
                a = new vq3("0");
            }
            return a;
        }
        return (vq3) invokeV.objValue;
    }

    public static void b(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            vq3 vq3Var = a;
            if (vq3Var == null) {
                a = new vq3(str);
            } else {
                vq3Var.n(str);
            }
        }
    }
}
