package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class qb9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile pb9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized pb9 a() {
        InterceptResult invokeV;
        pb9 pb9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (qb9.class) {
                if (a == null) {
                    a = new pb9();
                }
                pb9Var = a;
            }
            return pb9Var;
        }
        return (pb9) invokeV.objValue;
    }
}
