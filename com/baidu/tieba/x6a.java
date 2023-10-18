package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class x6a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile w6a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized w6a a() {
        InterceptResult invokeV;
        w6a w6aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (x6a.class) {
                if (a == null) {
                    a = new w6a();
                }
                w6aVar = a;
            }
            return w6aVar;
        }
        return (w6a) invokeV.objValue;
    }
}
