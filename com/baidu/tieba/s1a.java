package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class s1a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile r1a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized r1a a() {
        InterceptResult invokeV;
        r1a r1aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (s1a.class) {
                if (a == null) {
                    a = new r1a();
                }
                r1aVar = a;
            }
            return r1aVar;
        }
        return (r1a) invokeV.objValue;
    }
}
