package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class pi8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile oi8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized oi8 a() {
        InterceptResult invokeV;
        oi8 oi8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (pi8.class) {
                if (a == null) {
                    a = new oi8();
                }
                oi8Var = a;
            }
            return oi8Var;
        }
        return (oi8) invokeV.objValue;
    }
}
