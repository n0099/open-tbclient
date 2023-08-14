package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class y3a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile x3a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized x3a a() {
        InterceptResult invokeV;
        x3a x3aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (y3a.class) {
                if (a == null) {
                    a = new x3a();
                }
                x3aVar = a;
            }
            return x3aVar;
        }
        return (x3a) invokeV.objValue;
    }
}
