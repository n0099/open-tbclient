package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class l16 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile k16 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized k16 a() {
        InterceptResult invokeV;
        k16 k16Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (l16.class) {
                if (a == null) {
                    a = new k16();
                }
                k16Var = a;
            }
            return k16Var;
        }
        return (k16) invokeV.objValue;
    }
}
