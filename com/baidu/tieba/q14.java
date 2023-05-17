package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class q14 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile p14 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized p14 a() {
        InterceptResult invokeV;
        p14 p14Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (q14.class) {
                if (a == null) {
                    a = new p14();
                }
                p14Var = a;
            }
            return p14Var;
        }
        return (p14) invokeV.objValue;
    }
}
