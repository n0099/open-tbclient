package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class xn6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile wn6 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized wn6 a() {
        InterceptResult invokeV;
        wn6 wn6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (xn6.class) {
                if (a == null) {
                    a = new wn6();
                }
                wn6Var = a;
            }
            return wn6Var;
        }
        return (wn6) invokeV.objValue;
    }
}
