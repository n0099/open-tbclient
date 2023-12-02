package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class kb1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile jb1 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized jb1 a() {
        InterceptResult invokeV;
        jb1 jb1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (kb1.class) {
                if (a == null) {
                    a = new jb1();
                }
                jb1Var = a;
            }
            return jb1Var;
        }
        return (jb1) invokeV.objValue;
    }
}
