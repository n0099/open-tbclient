package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class xr5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile wr5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized wr5 a() {
        InterceptResult invokeV;
        wr5 wr5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (xr5.class) {
                if (a == null) {
                    a = new wr5();
                }
                wr5Var = a;
            }
            return wr5Var;
        }
        return (wr5) invokeV.objValue;
    }
}
