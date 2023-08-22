package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class u8a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile t8a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized t8a a() {
        InterceptResult invokeV;
        t8a t8aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (u8a.class) {
                if (a == null) {
                    a = new t8a();
                }
                t8aVar = a;
            }
            return t8aVar;
        }
        return (t8a) invokeV.objValue;
    }
}
