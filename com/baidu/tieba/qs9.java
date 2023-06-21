package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class qs9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ps9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ps9 a() {
        InterceptResult invokeV;
        ps9 ps9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (qs9.class) {
                if (a == null) {
                    a = new ps9();
                }
                ps9Var = a;
            }
            return ps9Var;
        }
        return (ps9) invokeV.objValue;
    }
}
