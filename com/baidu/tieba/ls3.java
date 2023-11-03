package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class ls3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ks3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ks3 a() {
        InterceptResult invokeV;
        ks3 ks3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ls3.class) {
                if (a == null) {
                    a = new ks3();
                }
                ks3Var = a;
            }
            return ks3Var;
        }
        return (ks3) invokeV.objValue;
    }
}
