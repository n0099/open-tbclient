package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class xj8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile wj8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized wj8 a() {
        InterceptResult invokeV;
        wj8 wj8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (xj8.class) {
                if (a == null) {
                    a = new wj8();
                }
                wj8Var = a;
            }
            return wj8Var;
        }
        return (wj8) invokeV.objValue;
    }
}
