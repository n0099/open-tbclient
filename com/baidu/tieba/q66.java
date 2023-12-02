package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class q66 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile p66 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized p66 a() {
        InterceptResult invokeV;
        p66 p66Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (q66.class) {
                if (a == null) {
                    a = new p66();
                }
                p66Var = a;
            }
            return p66Var;
        }
        return (p66) invokeV.objValue;
    }
}
