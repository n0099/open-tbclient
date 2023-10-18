package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class qv3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile pv3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized pv3 a() {
        InterceptResult invokeV;
        pv3 pv3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (qv3.class) {
                if (a == null) {
                    a = new pv3();
                }
                pv3Var = a;
            }
            return pv3Var;
        }
        return (pv3) invokeV.objValue;
    }
}
