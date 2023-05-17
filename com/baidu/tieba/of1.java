package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class of1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile nf1 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized nf1 a() {
        InterceptResult invokeV;
        nf1 nf1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (of1.class) {
                if (a == null) {
                    a = new nf1();
                }
                nf1Var = a;
            }
            return nf1Var;
        }
        return (nf1) invokeV.objValue;
    }
}
