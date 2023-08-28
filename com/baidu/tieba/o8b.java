package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class o8b {
    public static /* synthetic */ Interceptable $ic;
    public static volatile n8b a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized n8b a() {
        InterceptResult invokeV;
        n8b n8bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (o8b.class) {
                if (a == null) {
                    a = new n8b();
                }
                n8bVar = a;
            }
            return n8bVar;
        }
        return (n8b) invokeV.objValue;
    }
}
