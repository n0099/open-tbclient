package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class tf1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile sf1 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized sf1 a() {
        InterceptResult invokeV;
        sf1 sf1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (tf1.class) {
                if (a == null) {
                    a = new sf1();
                }
                sf1Var = a;
            }
            return sf1Var;
        }
        return (sf1) invokeV.objValue;
    }
}
