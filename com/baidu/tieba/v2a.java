package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class v2a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile u2a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized u2a a() {
        InterceptResult invokeV;
        u2a u2aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (v2a.class) {
                if (a == null) {
                    a = new u2a();
                }
                u2aVar = a;
            }
            return u2aVar;
        }
        return (u2a) invokeV.objValue;
    }
}
