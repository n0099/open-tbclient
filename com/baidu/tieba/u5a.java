package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class u5a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile t5a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized t5a a() {
        InterceptResult invokeV;
        t5a t5aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (u5a.class) {
                if (a == null) {
                    a = new t5a();
                }
                t5aVar = a;
            }
            return t5aVar;
        }
        return (t5a) invokeV.objValue;
    }
}
