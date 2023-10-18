package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class s7a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile r7a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized r7a a() {
        InterceptResult invokeV;
        r7a r7aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (s7a.class) {
                if (a == null) {
                    a = new r7a();
                }
                r7aVar = a;
            }
            return r7aVar;
        }
        return (r7a) invokeV.objValue;
    }
}
