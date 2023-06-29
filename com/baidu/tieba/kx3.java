package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class kx3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile jx3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized jx3 a() {
        InterceptResult invokeV;
        jx3 jx3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (kx3.class) {
                if (a == null) {
                    a = new jx3();
                }
                jx3Var = a;
            }
            return jx3Var;
        }
        return (jx3) invokeV.objValue;
    }
}
