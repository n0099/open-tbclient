package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class y4a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile x4a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized x4a a() {
        InterceptResult invokeV;
        x4a x4aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (y4a.class) {
                if (a == null) {
                    a = new x4a();
                }
                x4aVar = a;
            }
            return x4aVar;
        }
        return (x4a) invokeV.objValue;
    }
}
