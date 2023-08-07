package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class v76 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile u76 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized u76 a() {
        InterceptResult invokeV;
        u76 u76Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (v76.class) {
                if (a == null) {
                    a = new u76();
                }
                u76Var = a;
            }
            return u76Var;
        }
        return (u76) invokeV.objValue;
    }
}
