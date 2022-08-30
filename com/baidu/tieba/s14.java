package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class s14 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile r14 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized r14 a() {
        InterceptResult invokeV;
        r14 r14Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (s14.class) {
                if (a == null) {
                    a = new r14();
                }
                r14Var = a;
            }
            return r14Var;
        }
        return (r14) invokeV.objValue;
    }
}
