package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class zk9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile yk9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized yk9 a() {
        InterceptResult invokeV;
        yk9 yk9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (zk9.class) {
                if (a == null) {
                    a = new yk9();
                }
                yk9Var = a;
            }
            return yk9Var;
        }
        return (yk9) invokeV.objValue;
    }
}
