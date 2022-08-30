package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class kk2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile jk2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized jk2 a() {
        InterceptResult invokeV;
        jk2 jk2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (kk2.class) {
                if (a == null) {
                    a = new jk2();
                }
                jk2Var = a;
            }
            return jk2Var;
        }
        return (jk2) invokeV.objValue;
    }
}
