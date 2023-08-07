package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class p86 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile o86 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized o86 a() {
        InterceptResult invokeV;
        o86 o86Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (p86.class) {
                if (a == null) {
                    a = new o86();
                }
                o86Var = a;
            }
            return o86Var;
        }
        return (o86) invokeV.objValue;
    }
}
