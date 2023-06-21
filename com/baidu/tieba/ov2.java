package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class ov2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile nv2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized nv2 a() {
        InterceptResult invokeV;
        nv2 nv2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ov2.class) {
                if (a == null) {
                    a = new nv2();
                }
                nv2Var = a;
            }
            return nv2Var;
        }
        return (nv2) invokeV.objValue;
    }
}
