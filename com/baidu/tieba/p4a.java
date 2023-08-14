package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class p4a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile o4a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized o4a a() {
        InterceptResult invokeV;
        o4a o4aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (p4a.class) {
                if (a == null) {
                    a = new o4a();
                }
                o4aVar = a;
            }
            return o4aVar;
        }
        return (o4a) invokeV.objValue;
    }
}
