package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class qr3 {
    public static /* synthetic */ Interceptable $ic;
    public static sr3 a;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static sr3 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (a == null) {
                a = new sr3("0");
            }
            return a;
        }
        return (sr3) invokeV.objValue;
    }

    public static void b(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            sr3 sr3Var = a;
            if (sr3Var == null) {
                a = new sr3(str);
            } else {
                sr3Var.n(str);
            }
        }
    }
}
