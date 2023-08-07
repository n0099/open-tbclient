package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class v3a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile u3a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized u3a a() {
        InterceptResult invokeV;
        u3a u3aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (v3a.class) {
                if (a == null) {
                    a = new u3a();
                }
                u3aVar = a;
            }
            return u3aVar;
        }
        return (u3a) invokeV.objValue;
    }
}
