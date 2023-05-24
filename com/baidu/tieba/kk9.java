package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class kk9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile jk9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized jk9 a() {
        InterceptResult invokeV;
        jk9 jk9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (kk9.class) {
                if (a == null) {
                    a = new jk9();
                }
                jk9Var = a;
            }
            return jk9Var;
        }
        return (jk9) invokeV.objValue;
    }
}
