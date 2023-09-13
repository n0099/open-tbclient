package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class n7a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile m7a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized m7a a() {
        InterceptResult invokeV;
        m7a m7aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (n7a.class) {
                if (a == null) {
                    a = new m7a();
                }
                m7aVar = a;
            }
            return m7aVar;
        }
        return (m7a) invokeV.objValue;
    }
}
