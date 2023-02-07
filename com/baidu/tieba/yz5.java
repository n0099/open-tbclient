package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class yz5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile xz5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized xz5 a() {
        InterceptResult invokeV;
        xz5 xz5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (yz5.class) {
                if (a == null) {
                    a = new xz5();
                }
                xz5Var = a;
            }
            return xz5Var;
        }
        return (xz5) invokeV.objValue;
    }
}
