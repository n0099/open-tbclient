package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class kj3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile jj3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized jj3 a() {
        InterceptResult invokeV;
        jj3 jj3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (kj3.class) {
                if (a == null) {
                    a = new jj3();
                }
                jj3Var = a;
            }
            return jj3Var;
        }
        return (jj3) invokeV.objValue;
    }
}
