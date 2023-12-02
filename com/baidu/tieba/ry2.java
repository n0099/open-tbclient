package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class ry2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile qy2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized qy2 a() {
        InterceptResult invokeV;
        qy2 qy2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ry2.class) {
                if (a == null) {
                    a = new qy2();
                }
                qy2Var = a;
            }
            return qy2Var;
        }
        return (qy2) invokeV.objValue;
    }
}
