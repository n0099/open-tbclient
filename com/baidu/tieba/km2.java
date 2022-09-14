package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class km2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile jm2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized jm2 a() {
        InterceptResult invokeV;
        jm2 jm2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (km2.class) {
                if (a == null) {
                    a = new jm2();
                }
                jm2Var = a;
            }
            return jm2Var;
        }
        return (jm2) invokeV.objValue;
    }
}
