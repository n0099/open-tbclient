package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class qv2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile pv2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized pv2 a() {
        InterceptResult invokeV;
        pv2 pv2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (qv2.class) {
                if (a == null) {
                    a = new pv2();
                }
                pv2Var = a;
            }
            return pv2Var;
        }
        return (pv2) invokeV.objValue;
    }
}
