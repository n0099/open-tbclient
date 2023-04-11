package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class o8a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile n8a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized n8a a() {
        InterceptResult invokeV;
        n8a n8aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (o8a.class) {
                if (a == null) {
                    a = new n8a();
                }
                n8aVar = a;
            }
            return n8aVar;
        }
        return (n8a) invokeV.objValue;
    }
}
