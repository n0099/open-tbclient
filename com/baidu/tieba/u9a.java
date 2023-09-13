package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class u9a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile t9a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized t9a a() {
        InterceptResult invokeV;
        t9a t9aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (u9a.class) {
                if (a == null) {
                    a = new t9a();
                }
                t9aVar = a;
            }
            return t9aVar;
        }
        return (t9a) invokeV.objValue;
    }
}
