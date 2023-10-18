package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class qs3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ps3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ps3 a() {
        InterceptResult invokeV;
        ps3 ps3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (qs3.class) {
                if (a == null) {
                    a = new ps3();
                }
                ps3Var = a;
            }
            return ps3Var;
        }
        return (ps3) invokeV.objValue;
    }
}
