package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class ul8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static ql8<rl8> a(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            ql8<rl8> ql8Var = new ql8<>();
            ql8Var.e().j(1);
            rl8 rl8Var = new rl8();
            rl8Var.f(str);
            ql8Var.i(rl8Var);
            return ql8Var;
        }
        return (ql8) invokeL.objValue;
    }
}
