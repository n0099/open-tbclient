package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class qt5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile pt5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized pt5 a() {
        InterceptResult invokeV;
        pt5 pt5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (qt5.class) {
                if (a == null) {
                    a = new pt5();
                }
                pt5Var = a;
            }
            return pt5Var;
        }
        return (pt5) invokeV.objValue;
    }
}
