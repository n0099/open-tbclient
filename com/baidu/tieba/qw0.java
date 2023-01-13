package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class qw0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile pw0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized pw0 a() {
        InterceptResult invokeV;
        pw0 pw0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (qw0.class) {
                if (a == null) {
                    a = new pw0();
                }
                pw0Var = a;
            }
            return pw0Var;
        }
        return (pw0) invokeV.objValue;
    }
}
