package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class nv0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile mv0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized mv0 a() {
        InterceptResult invokeV;
        mv0 mv0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (nv0.class) {
                if (a == null) {
                    a = new mv0();
                }
                mv0Var = a;
            }
            return mv0Var;
        }
        return (mv0) invokeV.objValue;
    }
}
