package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class p7a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile o7a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized o7a a() {
        InterceptResult invokeV;
        o7a o7aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (p7a.class) {
                if (a == null) {
                    a = new o7a();
                }
                o7aVar = a;
            }
            return o7aVar;
        }
        return (o7a) invokeV.objValue;
    }
}
