package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class pz3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile oz3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized oz3 a() {
        InterceptResult invokeV;
        oz3 oz3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (pz3.class) {
                if (a == null) {
                    a = new oz3();
                }
                oz3Var = a;
            }
            return oz3Var;
        }
        return (oz3) invokeV.objValue;
    }
}
