package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class kx0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile jx0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized jx0 a() {
        InterceptResult invokeV;
        jx0 jx0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (kx0.class) {
                if (a == null) {
                    a = new jx0();
                }
                jx0Var = a;
            }
            return jx0Var;
        }
        return (jx0) invokeV.objValue;
    }
}
