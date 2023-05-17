package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class rl6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ql6 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ql6 a() {
        InterceptResult invokeV;
        ql6 ql6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (rl6.class) {
                if (a == null) {
                    a = new ql6();
                }
                ql6Var = a;
            }
            return ql6Var;
        }
        return (ql6) invokeV.objValue;
    }
}
