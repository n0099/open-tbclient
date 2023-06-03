package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class xg1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile wg1 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized wg1 a() {
        InterceptResult invokeV;
        wg1 wg1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (xg1.class) {
                if (a == null) {
                    a = new wg1();
                }
                wg1Var = a;
            }
            return wg1Var;
        }
        return (wg1) invokeV.objValue;
    }
}
