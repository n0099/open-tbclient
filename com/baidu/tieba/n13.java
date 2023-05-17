package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class n13 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile m13 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized m13 a() {
        InterceptResult invokeV;
        m13 m13Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (n13.class) {
                if (a == null) {
                    a = new m13();
                }
                m13Var = a;
            }
            return m13Var;
        }
        return (m13) invokeV.objValue;
    }
}
