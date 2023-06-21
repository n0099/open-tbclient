package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class kg4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile jg4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized jg4 a() {
        InterceptResult invokeV;
        jg4 jg4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (kg4.class) {
                if (a == null) {
                    a = new jg4();
                }
                jg4Var = a;
            }
            return jg4Var;
        }
        return (jg4) invokeV.objValue;
    }
}
