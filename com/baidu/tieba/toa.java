package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class toa {
    public static /* synthetic */ Interceptable $ic;
    public static volatile soa a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized soa a() {
        InterceptResult invokeV;
        soa soaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (toa.class) {
                if (a == null) {
                    a = new soa();
                }
                soaVar = a;
            }
            return soaVar;
        }
        return (soa) invokeV.objValue;
    }
}
