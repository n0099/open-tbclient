package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class o1a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile n1a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized n1a a() {
        InterceptResult invokeV;
        n1a n1aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (o1a.class) {
                if (a == null) {
                    a = new n1a();
                }
                n1aVar = a;
            }
            return n1aVar;
        }
        return (n1a) invokeV.objValue;
    }
}
