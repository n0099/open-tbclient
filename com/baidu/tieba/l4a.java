package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class l4a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile k4a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized k4a a() {
        InterceptResult invokeV;
        k4a k4aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (l4a.class) {
                if (a == null) {
                    a = new k4a();
                }
                k4aVar = a;
            }
            return k4aVar;
        }
        return (k4a) invokeV.objValue;
    }
}
