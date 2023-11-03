package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class r66 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile q66 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized q66 a() {
        InterceptResult invokeV;
        q66 q66Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (r66.class) {
                if (a == null) {
                    a = new q66();
                }
                q66Var = a;
            }
            return q66Var;
        }
        return (q66) invokeV.objValue;
    }
}
