package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class kw0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile jw0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized jw0 a() {
        InterceptResult invokeV;
        jw0 jw0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (kw0.class) {
                if (a == null) {
                    a = new jw0();
                }
                jw0Var = a;
            }
            return jw0Var;
        }
        return (jw0) invokeV.objValue;
    }
}
