package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class kma {
    public static /* synthetic */ Interceptable $ic;
    public static volatile jma a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized jma a() {
        InterceptResult invokeV;
        jma jmaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (kma.class) {
                if (a == null) {
                    a = new jma();
                }
                jmaVar = a;
            }
            return jmaVar;
        }
        return (jma) invokeV.objValue;
    }
}
