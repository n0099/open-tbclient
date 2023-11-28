package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class n34 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile m34 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized m34 a() {
        InterceptResult invokeV;
        m34 m34Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (n34.class) {
                if (a == null) {
                    a = new m34();
                }
                m34Var = a;
            }
            return m34Var;
        }
        return (m34) invokeV.objValue;
    }
}
