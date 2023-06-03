package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class nv2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile mv2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized mv2 a() {
        InterceptResult invokeV;
        mv2 mv2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (nv2.class) {
                if (a == null) {
                    a = new mv2();
                }
                mv2Var = a;
            }
            return mv2Var;
        }
        return (mv2) invokeV.objValue;
    }
}
