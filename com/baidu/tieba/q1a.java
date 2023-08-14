package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class q1a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile p1a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized p1a a() {
        InterceptResult invokeV;
        p1a p1aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (q1a.class) {
                if (a == null) {
                    a = new p1a();
                }
                p1aVar = a;
            }
            return p1aVar;
        }
        return (p1a) invokeV.objValue;
    }
}
