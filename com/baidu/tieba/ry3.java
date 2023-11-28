package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class ry3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile qy3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized qy3 a() {
        InterceptResult invokeV;
        qy3 qy3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ry3.class) {
                if (a == null) {
                    a = new qy3();
                }
                qy3Var = a;
            }
            return qy3Var;
        }
        return (qy3) invokeV.objValue;
    }
}
