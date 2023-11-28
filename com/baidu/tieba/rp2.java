package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class rp2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile qp2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized qp2 a() {
        InterceptResult invokeV;
        qp2 qp2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (rp2.class) {
                if (a == null) {
                    a = new qp2();
                }
                qp2Var = a;
            }
            return qp2Var;
        }
        return (qp2) invokeV.objValue;
    }
}
