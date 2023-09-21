package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class rf4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile qf4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized qf4 a() {
        InterceptResult invokeV;
        qf4 qf4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (rf4.class) {
                if (a == null) {
                    a = new qf4();
                }
                qf4Var = a;
            }
            return qf4Var;
        }
        return (qf4) invokeV.objValue;
    }
}
