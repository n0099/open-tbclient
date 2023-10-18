package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class os3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ns3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ns3 a() {
        InterceptResult invokeV;
        ns3 ns3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (os3.class) {
                if (a == null) {
                    a = new ns3();
                }
                ns3Var = a;
            }
            return ns3Var;
        }
        return (ns3) invokeV.objValue;
    }
}
