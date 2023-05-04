package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class t84 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile s84 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized s84 a() {
        InterceptResult invokeV;
        s84 s84Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (t84.class) {
                if (a == null) {
                    a = new s84();
                }
                s84Var = a;
            }
            return s84Var;
        }
        return (s84) invokeV.objValue;
    }
}
