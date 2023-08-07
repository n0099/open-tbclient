package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class x4a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile w4a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized w4a a() {
        InterceptResult invokeV;
        w4a w4aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (x4a.class) {
                if (a == null) {
                    a = new w4a();
                }
                w4aVar = a;
            }
            return w4aVar;
        }
        return (w4a) invokeV.objValue;
    }
}
