package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class n4a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile m4a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized m4a a() {
        InterceptResult invokeV;
        m4a m4aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (n4a.class) {
                if (a == null) {
                    a = new m4a();
                }
                m4aVar = a;
            }
            return m4aVar;
        }
        return (m4a) invokeV.objValue;
    }
}
