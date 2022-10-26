package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class kk3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile jk3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized jk3 a() {
        InterceptResult invokeV;
        jk3 jk3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (kk3.class) {
                if (a == null) {
                    a = new jk3();
                }
                jk3Var = a;
            }
            return jk3Var;
        }
        return (jk3) invokeV.objValue;
    }
}
