package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class xa6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile wa6 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized wa6 a() {
        InterceptResult invokeV;
        wa6 wa6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (xa6.class) {
                if (a == null) {
                    a = new wa6();
                }
                wa6Var = a;
            }
            return wa6Var;
        }
        return (wa6) invokeV.objValue;
    }
}
