package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class x9a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile w9a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized w9a a() {
        InterceptResult invokeV;
        w9a w9aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (x9a.class) {
                if (a == null) {
                    a = new w9a();
                }
                w9aVar = a;
            }
            return w9aVar;
        }
        return (w9a) invokeV.objValue;
    }
}
