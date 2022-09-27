package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class r04 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile q04 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized q04 a() {
        InterceptResult invokeV;
        q04 q04Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (r04.class) {
                if (a == null) {
                    a = new q04();
                }
                q04Var = a;
            }
            return q04Var;
        }
        return (q04) invokeV.objValue;
    }
}
