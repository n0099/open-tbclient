package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class x5a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile w5a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized w5a a() {
        InterceptResult invokeV;
        w5a w5aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (x5a.class) {
                if (a == null) {
                    a = new w5a();
                }
                w5aVar = a;
            }
            return w5aVar;
        }
        return (w5a) invokeV.objValue;
    }
}
