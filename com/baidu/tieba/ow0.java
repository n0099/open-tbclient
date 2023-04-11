package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ow0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile nw0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized nw0 a() {
        InterceptResult invokeV;
        nw0 nw0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ow0.class) {
                if (a == null) {
                    a = new nw0();
                }
                nw0Var = a;
            }
            return nw0Var;
        }
        return (nw0) invokeV.objValue;
    }
}
