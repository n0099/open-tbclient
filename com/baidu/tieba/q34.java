package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class q34 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile p34 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized p34 a() {
        InterceptResult invokeV;
        p34 p34Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (q34.class) {
                if (a == null) {
                    a = new p34();
                }
                p34Var = a;
            }
            return p34Var;
        }
        return (p34) invokeV.objValue;
    }
}
