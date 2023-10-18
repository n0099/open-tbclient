package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class q6a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile p6a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized p6a a() {
        InterceptResult invokeV;
        p6a p6aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (q6a.class) {
                if (a == null) {
                    a = new p6a();
                }
                p6aVar = a;
            }
            return p6aVar;
        }
        return (p6a) invokeV.objValue;
    }
}
