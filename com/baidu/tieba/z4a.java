package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class z4a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile y4a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized y4a a() {
        InterceptResult invokeV;
        y4a y4aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (z4a.class) {
                if (a == null) {
                    a = new y4a();
                }
                y4aVar = a;
            }
            return y4aVar;
        }
        return (y4a) invokeV.objValue;
    }
}
