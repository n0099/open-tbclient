package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class z9a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile y9a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized y9a a() {
        InterceptResult invokeV;
        y9a y9aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (z9a.class) {
                if (a == null) {
                    a = new y9a();
                }
                y9aVar = a;
            }
            return y9aVar;
        }
        return (y9a) invokeV.objValue;
    }
}
