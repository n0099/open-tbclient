package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class v5a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile u5a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized u5a a() {
        InterceptResult invokeV;
        u5a u5aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (v5a.class) {
                if (a == null) {
                    a = new u5a();
                }
                u5aVar = a;
            }
            return u5aVar;
        }
        return (u5a) invokeV.objValue;
    }
}
