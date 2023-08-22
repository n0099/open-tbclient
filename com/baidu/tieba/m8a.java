package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class m8a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile l8a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized l8a a() {
        InterceptResult invokeV;
        l8a l8aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (m8a.class) {
                if (a == null) {
                    a = new l8a();
                }
                l8aVar = a;
            }
            return l8aVar;
        }
        return (l8a) invokeV.objValue;
    }
}
