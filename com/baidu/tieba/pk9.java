package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class pk9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ok9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ok9 a() {
        InterceptResult invokeV;
        ok9 ok9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (pk9.class) {
                if (a == null) {
                    a = new ok9();
                }
                ok9Var = a;
            }
            return ok9Var;
        }
        return (ok9) invokeV.objValue;
    }
}
