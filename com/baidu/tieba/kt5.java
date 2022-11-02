package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class kt5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile jt5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized jt5 a() {
        InterceptResult invokeV;
        jt5 jt5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (kt5.class) {
                if (a == null) {
                    a = new jt5();
                }
                jt5Var = a;
            }
            return jt5Var;
        }
        return (jt5) invokeV.objValue;
    }
}
