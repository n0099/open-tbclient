package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class s6a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile r6a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized r6a a() {
        InterceptResult invokeV;
        r6a r6aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (s6a.class) {
                if (a == null) {
                    a = new r6a();
                }
                r6aVar = a;
            }
            return r6aVar;
        }
        return (r6a) invokeV.objValue;
    }
}
