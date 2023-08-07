package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class t76 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile s76 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized s76 a() {
        InterceptResult invokeV;
        s76 s76Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (t76.class) {
                if (a == null) {
                    a = new s76();
                }
                s76Var = a;
            }
            return s76Var;
        }
        return (s76) invokeV.objValue;
    }
}
