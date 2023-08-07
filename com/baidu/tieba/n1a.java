package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class n1a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile m1a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized m1a a() {
        InterceptResult invokeV;
        m1a m1aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (n1a.class) {
                if (a == null) {
                    a = new m1a();
                }
                m1aVar = a;
            }
            return m1aVar;
        }
        return (m1a) invokeV.objValue;
    }
}
