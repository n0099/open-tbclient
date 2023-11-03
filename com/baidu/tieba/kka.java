package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class kka {
    public static /* synthetic */ Interceptable $ic;
    public static volatile jka a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized jka a() {
        InterceptResult invokeV;
        jka jkaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (kka.class) {
                if (a == null) {
                    a = new jka();
                }
                jkaVar = a;
            }
            return jkaVar;
        }
        return (jka) invokeV.objValue;
    }
}
