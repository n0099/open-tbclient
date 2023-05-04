package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class n46 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile m46 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized m46 a() {
        InterceptResult invokeV;
        m46 m46Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (n46.class) {
                if (a == null) {
                    a = new m46();
                }
                m46Var = a;
            }
            return m46Var;
        }
        return (m46) invokeV.objValue;
    }
}
