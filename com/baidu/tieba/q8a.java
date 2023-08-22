package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class q8a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile p8a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized p8a a() {
        InterceptResult invokeV;
        p8a p8aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (q8a.class) {
                if (a == null) {
                    a = new p8a();
                }
                p8aVar = a;
            }
            return p8aVar;
        }
        return (p8a) invokeV.objValue;
    }
}
