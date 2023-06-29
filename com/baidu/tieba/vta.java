package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class vta {
    public static /* synthetic */ Interceptable $ic;
    public static volatile uta a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized uta a() {
        InterceptResult invokeV;
        uta utaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (vta.class) {
                if (a == null) {
                    a = new uta();
                }
                utaVar = a;
            }
            return utaVar;
        }
        return (uta) invokeV.objValue;
    }
}
