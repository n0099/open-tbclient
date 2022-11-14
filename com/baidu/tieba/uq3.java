package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class uq3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile tq3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized tq3 a() {
        InterceptResult invokeV;
        tq3 tq3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (uq3.class) {
                if (a == null) {
                    a = new tq3();
                }
                tq3Var = a;
            }
            return tq3Var;
        }
        return (tq3) invokeV.objValue;
    }
}
