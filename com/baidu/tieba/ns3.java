package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class ns3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ms3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ms3 a() {
        InterceptResult invokeV;
        ms3 ms3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ns3.class) {
                if (a == null) {
                    a = new ms3();
                }
                ms3Var = a;
            }
            return ms3Var;
        }
        return (ms3) invokeV.objValue;
    }
}
