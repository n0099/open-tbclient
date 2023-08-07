package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class o4a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile n4a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized n4a a() {
        InterceptResult invokeV;
        n4a n4aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (o4a.class) {
                if (a == null) {
                    a = new n4a();
                }
                n4aVar = a;
            }
            return n4aVar;
        }
        return (n4a) invokeV.objValue;
    }
}
