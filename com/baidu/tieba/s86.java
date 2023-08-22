package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class s86 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile r86 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized r86 a() {
        InterceptResult invokeV;
        r86 r86Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (s86.class) {
                if (a == null) {
                    a = new r86();
                }
                r86Var = a;
            }
            return r86Var;
        }
        return (r86) invokeV.objValue;
    }
}
