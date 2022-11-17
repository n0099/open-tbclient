package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class xt5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile wt5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized wt5 a() {
        InterceptResult invokeV;
        wt5 wt5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (xt5.class) {
                if (a == null) {
                    a = new wt5();
                }
                wt5Var = a;
            }
            return wt5Var;
        }
        return (wt5) invokeV.objValue;
    }
}
