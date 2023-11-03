package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class vka {
    public static /* synthetic */ Interceptable $ic;
    public static volatile uka a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized uka a() {
        InterceptResult invokeV;
        uka ukaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (vka.class) {
                if (a == null) {
                    a = new uka();
                }
                ukaVar = a;
            }
            return ukaVar;
        }
        return (uka) invokeV.objValue;
    }
}
