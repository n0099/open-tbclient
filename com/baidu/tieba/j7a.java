package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class j7a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile i7a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized i7a a() {
        InterceptResult invokeV;
        i7a i7aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (j7a.class) {
                if (a == null) {
                    a = new i7a();
                }
                i7aVar = a;
            }
            return i7aVar;
        }
        return (i7a) invokeV.objValue;
    }
}
