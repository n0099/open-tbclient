package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class p1a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile o1a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized o1a a() {
        InterceptResult invokeV;
        o1a o1aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (p1a.class) {
                if (a == null) {
                    a = new o1a();
                }
                o1aVar = a;
            }
            return o1aVar;
        }
        return (o1a) invokeV.objValue;
    }
}
