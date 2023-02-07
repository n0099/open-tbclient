package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class s94 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile r94 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized r94 a() {
        InterceptResult invokeV;
        r94 r94Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (s94.class) {
                if (a == null) {
                    a = new r94();
                }
                r94Var = a;
            }
            return r94Var;
        }
        return (r94) invokeV.objValue;
    }
}
