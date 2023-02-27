package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class s09 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile r09 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized r09 a() {
        InterceptResult invokeV;
        r09 r09Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (s09.class) {
                if (a == null) {
                    a = new r09();
                }
                r09Var = a;
            }
            return r09Var;
        }
        return (r09) invokeV.objValue;
    }
}
