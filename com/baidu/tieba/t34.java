package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class t34 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile s34 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized s34 a() {
        InterceptResult invokeV;
        s34 s34Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (t34.class) {
                if (a == null) {
                    a = new s34();
                }
                s34Var = a;
            }
            return s34Var;
        }
        return (s34) invokeV.objValue;
    }
}
