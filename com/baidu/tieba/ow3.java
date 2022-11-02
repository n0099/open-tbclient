package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ow3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile nw3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized nw3 a() {
        InterceptResult invokeV;
        nw3 nw3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ow3.class) {
                if (a == null) {
                    a = new nw3();
                }
                nw3Var = a;
            }
            return nw3Var;
        }
        return (nw3) invokeV.objValue;
    }
}
