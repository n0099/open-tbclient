package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class w4a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile v4a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized v4a a() {
        InterceptResult invokeV;
        v4a v4aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (w4a.class) {
                if (a == null) {
                    a = new v4a();
                }
                v4aVar = a;
            }
            return v4aVar;
        }
        return (v4a) invokeV.objValue;
    }
}
