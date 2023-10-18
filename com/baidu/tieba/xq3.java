package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class xq3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile wq3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized wq3 a() {
        InterceptResult invokeV;
        wq3 wq3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (xq3.class) {
                if (a == null) {
                    a = new wq3();
                }
                wq3Var = a;
            }
            return wq3Var;
        }
        return (wq3) invokeV.objValue;
    }
}
