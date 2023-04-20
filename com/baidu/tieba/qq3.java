package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class qq3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile pq3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized pq3 a() {
        InterceptResult invokeV;
        pq3 pq3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (qq3.class) {
                if (a == null) {
                    a = new pq3();
                }
                pq3Var = a;
            }
            return pq3Var;
        }
        return (pq3) invokeV.objValue;
    }
}
