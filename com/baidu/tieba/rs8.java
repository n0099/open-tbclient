package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class rs8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile qs8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized qs8 a() {
        InterceptResult invokeV;
        qs8 qs8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (rs8.class) {
                if (a == null) {
                    a = new qs8();
                }
                qs8Var = a;
            }
            return qs8Var;
        }
        return (qs8) invokeV.objValue;
    }
}
