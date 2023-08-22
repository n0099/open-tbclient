package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class m8b {
    public static /* synthetic */ Interceptable $ic;
    public static volatile l8b a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized l8b a() {
        InterceptResult invokeV;
        l8b l8bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (m8b.class) {
                if (a == null) {
                    a = new l8b();
                }
                l8bVar = a;
            }
            return l8bVar;
        }
        return (l8b) invokeV.objValue;
    }
}
