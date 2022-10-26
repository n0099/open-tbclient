package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class s74 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile r74 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized r74 a() {
        InterceptResult invokeV;
        r74 r74Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (s74.class) {
                if (a == null) {
                    a = new r74();
                }
                r74Var = a;
            }
            return r74Var;
        }
        return (r74) invokeV.objValue;
    }
}
