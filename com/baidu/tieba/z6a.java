package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class z6a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile y6a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized y6a a() {
        InterceptResult invokeV;
        y6a y6aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (z6a.class) {
                if (a == null) {
                    a = new y6a();
                }
                y6aVar = a;
            }
            return y6aVar;
        }
        return (y6a) invokeV.objValue;
    }
}
