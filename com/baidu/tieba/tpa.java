package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class tpa {
    public static /* synthetic */ Interceptable $ic;
    public static volatile spa a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized spa a() {
        InterceptResult invokeV;
        spa spaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (tpa.class) {
                if (a == null) {
                    a = new spa();
                }
                spaVar = a;
            }
            return spaVar;
        }
        return (spa) invokeV.objValue;
    }
}
