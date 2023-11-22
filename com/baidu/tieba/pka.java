package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class pka {
    public static /* synthetic */ Interceptable $ic;
    public static volatile oka a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized oka a() {
        InterceptResult invokeV;
        oka okaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (pka.class) {
                if (a == null) {
                    a = new oka();
                }
                okaVar = a;
            }
            return okaVar;
        }
        return (oka) invokeV.objValue;
    }
}
