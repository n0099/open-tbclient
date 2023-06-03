package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class tr3 {
    public static /* synthetic */ Interceptable $ic;
    public static vr3 a;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static vr3 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (a == null) {
                a = new vr3("0");
            }
            return a;
        }
        return (vr3) invokeV.objValue;
    }

    public static void b(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            vr3 vr3Var = a;
            if (vr3Var == null) {
                a = new vr3(str);
            } else {
                vr3Var.n(str);
            }
        }
    }
}
