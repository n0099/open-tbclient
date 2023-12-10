package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class oma {
    public static /* synthetic */ Interceptable $ic;
    public static volatile nma a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized nma a() {
        InterceptResult invokeV;
        nma nmaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (oma.class) {
                if (a == null) {
                    a = new nma();
                }
                nmaVar = a;
            }
            return nmaVar;
        }
        return (nma) invokeV.objValue;
    }
}
