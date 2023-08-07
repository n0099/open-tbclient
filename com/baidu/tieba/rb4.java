package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class rb4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile qb4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized qb4 a() {
        InterceptResult invokeV;
        qb4 qb4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (rb4.class) {
                if (a == null) {
                    a = new qb4();
                }
                qb4Var = a;
            }
            return qb4Var;
        }
        return (qb4) invokeV.objValue;
    }
}
