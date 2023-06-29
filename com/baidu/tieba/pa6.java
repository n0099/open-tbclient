package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class pa6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile oa6 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized oa6 a() {
        InterceptResult invokeV;
        oa6 oa6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (pa6.class) {
                if (a == null) {
                    a = new oa6();
                }
                oa6Var = a;
            }
            return oa6Var;
        }
        return (oa6) invokeV.objValue;
    }
}
