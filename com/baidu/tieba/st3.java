package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class st3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile rt3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized rt3 a() {
        InterceptResult invokeV;
        rt3 rt3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (st3.class) {
                if (a == null) {
                    a = new rt3();
                }
                rt3Var = a;
            }
            return rt3Var;
        }
        return (rt3) invokeV.objValue;
    }
}
