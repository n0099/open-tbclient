package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class s56 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile r56 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized r56 a() {
        InterceptResult invokeV;
        r56 r56Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (s56.class) {
                if (a == null) {
                    a = new r56();
                }
                r56Var = a;
            }
            return r56Var;
        }
        return (r56) invokeV.objValue;
    }
}
