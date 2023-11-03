package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class st0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile rt0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized rt0 a() {
        InterceptResult invokeV;
        rt0 rt0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (st0.class) {
                if (a == null) {
                    a = new rt0();
                }
                rt0Var = a;
            }
            return rt0Var;
        }
        return (rt0) invokeV.objValue;
    }
}
