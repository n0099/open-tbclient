package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class v9a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile u9a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized u9a a() {
        InterceptResult invokeV;
        u9a u9aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (v9a.class) {
                if (a == null) {
                    a = new u9a();
                }
                u9aVar = a;
            }
            return u9aVar;
        }
        return (u9a) invokeV.objValue;
    }
}
