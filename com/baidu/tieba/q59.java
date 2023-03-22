package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class q59 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile p59 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized p59 a() {
        InterceptResult invokeV;
        p59 p59Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (q59.class) {
                if (a == null) {
                    a = new p59();
                }
                p59Var = a;
            }
            return p59Var;
        }
        return (p59) invokeV.objValue;
    }
}
