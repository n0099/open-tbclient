package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class vo3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile uo3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized uo3 a() {
        InterceptResult invokeV;
        uo3 uo3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (vo3.class) {
                if (a == null) {
                    a = new uo3();
                }
                uo3Var = a;
            }
            return uo3Var;
        }
        return (uo3) invokeV.objValue;
    }
}
