package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class q84 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile p84 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized p84 a() {
        InterceptResult invokeV;
        p84 p84Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (q84.class) {
                if (a == null) {
                    a = new p84();
                }
                p84Var = a;
            }
            return p84Var;
        }
        return (p84) invokeV.objValue;
    }
}
