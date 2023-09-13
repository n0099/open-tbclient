package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class kd4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile jd4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized jd4 a() {
        InterceptResult invokeV;
        jd4 jd4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (kd4.class) {
                if (a == null) {
                    a = new jd4();
                }
                jd4Var = a;
            }
            return jd4Var;
        }
        return (jd4) invokeV.objValue;
    }
}
