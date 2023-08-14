package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class q86 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile p86 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized p86 a() {
        InterceptResult invokeV;
        p86 p86Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (q86.class) {
                if (a == null) {
                    a = new p86();
                }
                p86Var = a;
            }
            return p86Var;
        }
        return (p86) invokeV.objValue;
    }
}
