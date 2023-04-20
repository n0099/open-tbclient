package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class wu3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile vu3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized vu3 a() {
        InterceptResult invokeV;
        vu3 vu3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (wu3.class) {
                if (a == null) {
                    a = new vu3();
                }
                vu3Var = a;
            }
            return vu3Var;
        }
        return (vu3) invokeV.objValue;
    }
}
