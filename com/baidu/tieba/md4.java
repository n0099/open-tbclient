package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class md4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ld4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ld4 a() {
        InterceptResult invokeV;
        ld4 ld4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (md4.class) {
                if (a == null) {
                    a = new ld4();
                }
                ld4Var = a;
            }
            return ld4Var;
        }
        return (ld4) invokeV.objValue;
    }
}
