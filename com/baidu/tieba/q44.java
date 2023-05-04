package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class q44 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile p44 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized p44 a() {
        InterceptResult invokeV;
        p44 p44Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (q44.class) {
                if (a == null) {
                    a = new p44();
                }
                p44Var = a;
            }
            return p44Var;
        }
        return (p44) invokeV.objValue;
    }
}
