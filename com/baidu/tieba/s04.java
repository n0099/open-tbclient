package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class s04 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile r04 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized r04 a() {
        InterceptResult invokeV;
        r04 r04Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (s04.class) {
                if (a == null) {
                    a = new r04();
                }
                r04Var = a;
            }
            return r04Var;
        }
        return (r04) invokeV.objValue;
    }
}
