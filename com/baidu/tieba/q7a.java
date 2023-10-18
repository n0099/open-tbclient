package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class q7a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile p7a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized p7a a() {
        InterceptResult invokeV;
        p7a p7aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (q7a.class) {
                if (a == null) {
                    a = new p7a();
                }
                p7aVar = a;
            }
            return p7aVar;
        }
        return (p7a) invokeV.objValue;
    }
}
