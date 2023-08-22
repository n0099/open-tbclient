package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class s8a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile r8a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized r8a a() {
        InterceptResult invokeV;
        r8a r8aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (s8a.class) {
                if (a == null) {
                    a = new r8a();
                }
                r8aVar = a;
            }
            return r8aVar;
        }
        return (r8a) invokeV.objValue;
    }
}
