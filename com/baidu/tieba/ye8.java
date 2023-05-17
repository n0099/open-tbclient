package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class ye8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static ue8<ve8> a(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            ue8<ve8> ue8Var = new ue8<>();
            ue8Var.e().j(1);
            ve8 ve8Var = new ve8();
            ve8Var.f(str);
            ue8Var.i(ve8Var);
            return ue8Var;
        }
        return (ue8) invokeL.objValue;
    }
}
