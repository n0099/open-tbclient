package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class pq3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile oq3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized oq3 a() {
        InterceptResult invokeV;
        oq3 oq3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (pq3.class) {
                if (a == null) {
                    a = new oq3();
                }
                oq3Var = a;
            }
            return oq3Var;
        }
        return (oq3) invokeV.objValue;
    }
}
