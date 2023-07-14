package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class x2a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile w2a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized w2a a() {
        InterceptResult invokeV;
        w2a w2aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (x2a.class) {
                if (a == null) {
                    a = new w2a();
                }
                w2aVar = a;
            }
            return w2aVar;
        }
        return (w2a) invokeV.objValue;
    }
}
