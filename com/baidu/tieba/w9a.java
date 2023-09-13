package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class w9a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile v9a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized v9a a() {
        InterceptResult invokeV;
        v9a v9aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (w9a.class) {
                if (a == null) {
                    a = new v9a();
                }
                v9aVar = a;
            }
            return v9aVar;
        }
        return (v9a) invokeV.objValue;
    }
}
