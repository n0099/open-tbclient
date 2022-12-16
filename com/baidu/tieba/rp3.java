package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class rp3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile qp3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized qp3 a() {
        InterceptResult invokeV;
        qp3 qp3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (rp3.class) {
                if (a == null) {
                    a = new qp3();
                }
                qp3Var = a;
            }
            return qp3Var;
        }
        return (qp3) invokeV.objValue;
    }
}
