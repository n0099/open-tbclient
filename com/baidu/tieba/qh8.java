package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class qh8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ph8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ph8 a() {
        InterceptResult invokeV;
        ph8 ph8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (qh8.class) {
                if (a == null) {
                    a = new ph8();
                }
                ph8Var = a;
            }
            return ph8Var;
        }
        return (ph8) invokeV.objValue;
    }
}
