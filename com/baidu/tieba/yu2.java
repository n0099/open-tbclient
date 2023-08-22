package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class yu2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile xu2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized xu2 a() {
        InterceptResult invokeV;
        xu2 xu2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (yu2.class) {
                if (a == null) {
                    a = new xu2();
                }
                xu2Var = a;
            }
            return xu2Var;
        }
        return (xu2) invokeV.objValue;
    }
}
