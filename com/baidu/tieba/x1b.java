package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class x1b {
    public static /* synthetic */ Interceptable $ic;
    public static volatile w1b a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized w1b a() {
        InterceptResult invokeV;
        w1b w1bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (x1b.class) {
                if (a == null) {
                    a = new w1b();
                }
                w1bVar = a;
            }
            return w1bVar;
        }
        return (w1b) invokeV.objValue;
    }
}
