package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class w76 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile v76 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized v76 a() {
        InterceptResult invokeV;
        v76 v76Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (w76.class) {
                if (a == null) {
                    a = new v76();
                }
                v76Var = a;
            }
            return v76Var;
        }
        return (v76) invokeV.objValue;
    }
}
