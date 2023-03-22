package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ue1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile te1 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized te1 a() {
        InterceptResult invokeV;
        te1 te1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ue1.class) {
                if (a == null) {
                    a = new te1();
                }
                te1Var = a;
            }
            return te1Var;
        }
        return (te1) invokeV.objValue;
    }
}
