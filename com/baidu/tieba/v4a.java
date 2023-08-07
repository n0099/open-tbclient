package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class v4a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile u4a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized u4a a() {
        InterceptResult invokeV;
        u4a u4aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (v4a.class) {
                if (a == null) {
                    a = new u4a();
                }
                u4aVar = a;
            }
            return u4aVar;
        }
        return (u4a) invokeV.objValue;
    }
}
