package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class zk8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile yk8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized yk8 a() {
        InterceptResult invokeV;
        yk8 yk8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (zk8.class) {
                if (a == null) {
                    a = new yk8();
                }
                yk8Var = a;
            }
            return yk8Var;
        }
        return (yk8) invokeV.objValue;
    }
}
