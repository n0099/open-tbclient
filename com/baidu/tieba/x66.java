package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class x66 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile w66 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized w66 a() {
        InterceptResult invokeV;
        w66 w66Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (x66.class) {
                if (a == null) {
                    a = new w66();
                }
                w66Var = a;
            }
            return w66Var;
        }
        return (w66) invokeV.objValue;
    }
}
