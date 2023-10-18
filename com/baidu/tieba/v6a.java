package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class v6a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile u6a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized u6a a() {
        InterceptResult invokeV;
        u6a u6aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (v6a.class) {
                if (a == null) {
                    a = new u6a();
                }
                u6aVar = a;
            }
            return u6aVar;
        }
        return (u6a) invokeV.objValue;
    }
}
