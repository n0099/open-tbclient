package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class rf9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile qf9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized qf9 a() {
        InterceptResult invokeV;
        qf9 qf9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (rf9.class) {
                if (a == null) {
                    a = new qf9();
                }
                qf9Var = a;
            }
            return qf9Var;
        }
        return (qf9) invokeV.objValue;
    }
}
