package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class zj3 {
    public static /* synthetic */ Interceptable $ic;
    public static bk3 a;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static bk3 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (a == null) {
                a = new bk3("0");
            }
            return a;
        }
        return (bk3) invokeV.objValue;
    }

    public static void b(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            bk3 bk3Var = a;
            if (bk3Var == null) {
                a = new bk3(str);
            } else {
                bk3Var.n(str);
            }
        }
    }
}
