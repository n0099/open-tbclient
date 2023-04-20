package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class w8a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile v8a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized v8a a() {
        InterceptResult invokeV;
        v8a v8aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (w8a.class) {
                if (a == null) {
                    a = new v8a();
                }
                v8aVar = a;
            }
            return v8aVar;
        }
        return (v8a) invokeV.objValue;
    }
}
