package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class sr3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile rr3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized rr3 a() {
        InterceptResult invokeV;
        rr3 rr3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (sr3.class) {
                if (a == null) {
                    a = new rr3();
                }
                rr3Var = a;
            }
            return rr3Var;
        }
        return (rr3) invokeV.objValue;
    }
}
