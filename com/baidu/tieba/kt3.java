package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class kt3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile jt3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized jt3 a() {
        InterceptResult invokeV;
        jt3 jt3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (kt3.class) {
                if (a == null) {
                    a = new jt3();
                }
                jt3Var = a;
            }
            return jt3Var;
        }
        return (jt3) invokeV.objValue;
    }
}
