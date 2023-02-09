package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class kx8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile jx8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized jx8 a() {
        InterceptResult invokeV;
        jx8 jx8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (kx8.class) {
                if (a == null) {
                    a = new jx8();
                }
                jx8Var = a;
            }
            return jx8Var;
        }
        return (jx8) invokeV.objValue;
    }
}
