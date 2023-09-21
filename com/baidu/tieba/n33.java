package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class n33 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile m33 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized m33 a() {
        InterceptResult invokeV;
        m33 m33Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (n33.class) {
                if (a == null) {
                    a = new m33();
                }
                m33Var = a;
            }
            return m33Var;
        }
        return (m33) invokeV.objValue;
    }
}
