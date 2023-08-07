package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class w1b {
    public static /* synthetic */ Interceptable $ic;
    public static volatile v1b a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized v1b a() {
        InterceptResult invokeV;
        v1b v1bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (w1b.class) {
                if (a == null) {
                    a = new v1b();
                }
                v1bVar = a;
            }
            return v1bVar;
        }
        return (v1b) invokeV.objValue;
    }
}
