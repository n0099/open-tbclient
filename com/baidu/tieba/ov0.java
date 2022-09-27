package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ov0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile nv0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized nv0 a() {
        InterceptResult invokeV;
        nv0 nv0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ov0.class) {
                if (a == null) {
                    a = new nv0();
                }
                nv0Var = a;
            }
            return nv0Var;
        }
        return (nv0) invokeV.objValue;
    }
}
