package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class q46 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile p46 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized p46 a() {
        InterceptResult invokeV;
        p46 p46Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (q46.class) {
                if (a == null) {
                    a = new p46();
                }
                p46Var = a;
            }
            return p46Var;
        }
        return (p46) invokeV.objValue;
    }
}
