package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ra8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static na8<oa8> a(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            na8<oa8> na8Var = new na8<>();
            na8Var.e().j(1);
            oa8 oa8Var = new oa8();
            oa8Var.b(str);
            na8Var.i(oa8Var);
            return na8Var;
        }
        return (na8) invokeL.objValue;
    }
}
