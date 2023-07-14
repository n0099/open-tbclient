package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ky3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile jy3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized jy3 a() {
        InterceptResult invokeV;
        jy3 jy3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ky3.class) {
                if (a == null) {
                    a = new jy3();
                }
                jy3Var = a;
            }
            return jy3Var;
        }
        return (jy3) invokeV.objValue;
    }
}
