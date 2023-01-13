package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class wa0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile va0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized va0 a() {
        InterceptResult invokeV;
        va0 va0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (wa0.class) {
                if (a == null) {
                    a = new va0();
                }
                va0Var = a;
            }
            return va0Var;
        }
        return (va0) invokeV.objValue;
    }
}
