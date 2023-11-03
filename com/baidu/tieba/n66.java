package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class n66 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile m66 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized m66 a() {
        InterceptResult invokeV;
        m66 m66Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (n66.class) {
                if (a == null) {
                    a = new m66();
                }
                m66Var = a;
            }
            return m66Var;
        }
        return (m66) invokeV.objValue;
    }
}
