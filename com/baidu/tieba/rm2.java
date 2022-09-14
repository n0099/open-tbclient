package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class rm2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile qm2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized qm2 a() {
        InterceptResult invokeV;
        qm2 qm2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (rm2.class) {
                if (a == null) {
                    a = new qm2();
                }
                qm2Var = a;
            }
            return qm2Var;
        }
        return (qm2) invokeV.objValue;
    }
}
