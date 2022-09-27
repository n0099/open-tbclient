package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class kz3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile jz3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized jz3 a() {
        InterceptResult invokeV;
        jz3 jz3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (kz3.class) {
                if (a == null) {
                    a = new jz3();
                }
                jz3Var = a;
            }
            return jz3Var;
        }
        return (jz3) invokeV.objValue;
    }
}
