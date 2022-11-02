package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class xn2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile wn2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized wn2 a() {
        InterceptResult invokeV;
        wn2 wn2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (xn2.class) {
                if (a == null) {
                    a = new wn2();
                }
                wn2Var = a;
            }
            return wn2Var;
        }
        return (wn2) invokeV.objValue;
    }
}
