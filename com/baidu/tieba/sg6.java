package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class sg6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile rg6 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized rg6 a() {
        InterceptResult invokeV;
        rg6 rg6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (sg6.class) {
                if (a == null) {
                    a = new rg6();
                }
                rg6Var = a;
            }
            return rg6Var;
        }
        return (rg6) invokeV.objValue;
    }
}
