package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class ub4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile tb4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized tb4 a() {
        InterceptResult invokeV;
        tb4 tb4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ub4.class) {
                if (a == null) {
                    a = new tb4();
                }
                tb4Var = a;
            }
            return tb4Var;
        }
        return (tb4) invokeV.objValue;
    }
}
