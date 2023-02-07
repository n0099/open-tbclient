package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class s06 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile r06 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized r06 a() {
        InterceptResult invokeV;
        r06 r06Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (s06.class) {
                if (a == null) {
                    a = new r06();
                }
                r06Var = a;
            }
            return r06Var;
        }
        return (r06) invokeV.objValue;
    }
}
