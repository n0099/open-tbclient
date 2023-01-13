package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class qv5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile pv5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized pv5 a() {
        InterceptResult invokeV;
        pv5 pv5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (qv5.class) {
                if (a == null) {
                    a = new pv5();
                }
                pv5Var = a;
            }
            return pv5Var;
        }
        return (pv5) invokeV.objValue;
    }
}
