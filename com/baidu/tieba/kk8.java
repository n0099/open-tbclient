package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class kk8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile jk8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized jk8 a() {
        InterceptResult invokeV;
        jk8 jk8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (kk8.class) {
                if (a == null) {
                    a = new jk8();
                }
                jk8Var = a;
            }
            return jk8Var;
        }
        return (jk8) invokeV.objValue;
    }
}
