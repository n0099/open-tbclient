package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class ry0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile qy0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized qy0 a() {
        InterceptResult invokeV;
        qy0 qy0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ry0.class) {
                if (a == null) {
                    a = new qy0();
                }
                qy0Var = a;
            }
            return qy0Var;
        }
        return (qy0) invokeV.objValue;
    }
}
