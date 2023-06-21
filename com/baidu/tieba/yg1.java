package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class yg1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile xg1 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized xg1 a() {
        InterceptResult invokeV;
        xg1 xg1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (yg1.class) {
                if (a == null) {
                    a = new xg1();
                }
                xg1Var = a;
            }
            return xg1Var;
        }
        return (xg1) invokeV.objValue;
    }
}
