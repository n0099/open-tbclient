package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class t2a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile s2a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized s2a a() {
        InterceptResult invokeV;
        s2a s2aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (t2a.class) {
                if (a == null) {
                    a = new s2a();
                }
                s2aVar = a;
            }
            return s2aVar;
        }
        return (s2a) invokeV.objValue;
    }
}
