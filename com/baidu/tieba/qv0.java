package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class qv0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile pv0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized pv0 a() {
        InterceptResult invokeV;
        pv0 pv0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (qv0.class) {
                if (a == null) {
                    a = new pv0();
                }
                pv0Var = a;
            }
            return pv0Var;
        }
        return (pv0) invokeV.objValue;
    }
}
