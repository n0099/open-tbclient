package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class r16 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile q16 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized q16 a() {
        InterceptResult invokeV;
        q16 q16Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (r16.class) {
                if (a == null) {
                    a = new q16();
                }
                q16Var = a;
            }
            return q16Var;
        }
        return (q16) invokeV.objValue;
    }
}
