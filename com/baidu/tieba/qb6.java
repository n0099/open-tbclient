package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class qb6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile pb6 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized pb6 a() {
        InterceptResult invokeV;
        pb6 pb6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (qb6.class) {
                if (a == null) {
                    a = new pb6();
                }
                pb6Var = a;
            }
            return pb6Var;
        }
        return (pb6) invokeV.objValue;
    }
}
