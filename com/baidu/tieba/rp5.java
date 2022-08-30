package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class rp5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile qp5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized qp5 a() {
        InterceptResult invokeV;
        qp5 qp5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (rp5.class) {
                if (a == null) {
                    a = new qp5();
                }
                qp5Var = a;
            }
            return qp5Var;
        }
        return (qp5) invokeV.objValue;
    }
}
