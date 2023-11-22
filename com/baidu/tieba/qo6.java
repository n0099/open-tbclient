package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class qo6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile po6 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized po6 a() {
        InterceptResult invokeV;
        po6 po6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (qo6.class) {
                if (a == null) {
                    a = new po6();
                }
                po6Var = a;
            }
            return po6Var;
        }
        return (po6) invokeV.objValue;
    }
}
