package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class t96 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile s96 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized s96 a() {
        InterceptResult invokeV;
        s96 s96Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (t96.class) {
                if (a == null) {
                    a = new s96();
                }
                s96Var = a;
            }
            return s96Var;
        }
        return (s96) invokeV.objValue;
    }
}
