package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class rb9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile qb9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized qb9 a() {
        InterceptResult invokeV;
        qb9 qb9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (rb9.class) {
                if (a == null) {
                    a = new qb9();
                }
                qb9Var = a;
            }
            return qb9Var;
        }
        return (qb9) invokeV.objValue;
    }
}
