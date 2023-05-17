package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class jk9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ik9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ik9 a() {
        InterceptResult invokeV;
        ik9 ik9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (jk9.class) {
                if (a == null) {
                    a = new ik9();
                }
                ik9Var = a;
            }
            return ik9Var;
        }
        return (ik9) invokeV.objValue;
    }
}
