package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class pn2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile on2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized on2 a() {
        InterceptResult invokeV;
        on2 on2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (pn2.class) {
                if (a == null) {
                    a = new on2();
                }
                on2Var = a;
            }
            return on2Var;
        }
        return (on2) invokeV.objValue;
    }
}
