package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class nv8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile mv8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized mv8 a() {
        InterceptResult invokeV;
        mv8 mv8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (nv8.class) {
                if (a == null) {
                    a = new mv8();
                }
                mv8Var = a;
            }
            return mv8Var;
        }
        return (mv8) invokeV.objValue;
    }
}
