package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class s96 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile r96 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized r96 a() {
        InterceptResult invokeV;
        r96 r96Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (s96.class) {
                if (a == null) {
                    a = new r96();
                }
                r96Var = a;
            }
            return r96Var;
        }
        return (r96) invokeV.objValue;
    }
}
