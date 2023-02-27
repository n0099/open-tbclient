package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class km {
    public static /* synthetic */ Interceptable $ic;
    public static volatile jm a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized jm a() {
        InterceptResult invokeV;
        jm jmVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (km.class) {
                if (a == null) {
                    a = new jm();
                }
                jmVar = a;
            }
            return jmVar;
        }
        return (jm) invokeV.objValue;
    }
}
