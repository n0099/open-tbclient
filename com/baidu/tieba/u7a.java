package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class u7a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile t7a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized t7a a() {
        InterceptResult invokeV;
        t7a t7aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (u7a.class) {
                if (a == null) {
                    a = new t7a();
                }
                t7aVar = a;
            }
            return t7aVar;
        }
        return (t7a) invokeV.objValue;
    }
}
