package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class qt3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile pt3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized pt3 a() {
        InterceptResult invokeV;
        pt3 pt3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (qt3.class) {
                if (a == null) {
                    a = new pt3();
                }
                pt3Var = a;
            }
            return pt3Var;
        }
        return (pt3) invokeV.objValue;
    }
}
