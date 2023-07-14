package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class jb6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ib6 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ib6 a() {
        InterceptResult invokeV;
        ib6 ib6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (jb6.class) {
                if (a == null) {
                    a = new ib6();
                }
                ib6Var = a;
            }
            return ib6Var;
        }
        return (ib6) invokeV.objValue;
    }
}
