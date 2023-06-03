package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class kr9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile jr9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized jr9 a() {
        InterceptResult invokeV;
        jr9 jr9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (kr9.class) {
                if (a == null) {
                    a = new jr9();
                }
                jr9Var = a;
            }
            return jr9Var;
        }
        return (jr9) invokeV.objValue;
    }
}
