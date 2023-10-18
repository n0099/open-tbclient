package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class pa1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile oa1 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized oa1 a() {
        InterceptResult invokeV;
        oa1 oa1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (pa1.class) {
                if (a == null) {
                    a = new oa1();
                }
                oa1Var = a;
            }
            return oa1Var;
        }
        return (oa1) invokeV.objValue;
    }
}
