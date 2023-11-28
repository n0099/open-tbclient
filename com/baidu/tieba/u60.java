package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class u60 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile t60 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized t60 a() {
        InterceptResult invokeV;
        t60 t60Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (u60.class) {
                if (a == null) {
                    a = new t60();
                }
                t60Var = a;
            }
            return t60Var;
        }
        return (t60) invokeV.objValue;
    }
}
