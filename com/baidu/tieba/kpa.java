package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class kpa {
    public static /* synthetic */ Interceptable $ic;
    public static volatile jpa a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized jpa a() {
        InterceptResult invokeV;
        jpa jpaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (kpa.class) {
                if (a == null) {
                    a = new jpa();
                }
                jpaVar = a;
            }
            return jpaVar;
        }
        return (jpa) invokeV.objValue;
    }
}
