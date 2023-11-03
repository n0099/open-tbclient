package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class ot3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile nt3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized nt3 a() {
        InterceptResult invokeV;
        nt3 nt3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ot3.class) {
                if (a == null) {
                    a = new nt3();
                }
                nt3Var = a;
            }
            return nt3Var;
        }
        return (nt3) invokeV.objValue;
    }
}
