package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class n14 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile m14 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized m14 a() {
        InterceptResult invokeV;
        m14 m14Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (n14.class) {
                if (a == null) {
                    a = new m14();
                }
                m14Var = a;
            }
            return m14Var;
        }
        return (m14) invokeV.objValue;
    }
}
