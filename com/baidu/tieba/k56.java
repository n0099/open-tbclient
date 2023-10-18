package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class k56 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile j56 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized j56 a() {
        InterceptResult invokeV;
        j56 j56Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (k56.class) {
                if (a == null) {
                    a = new j56();
                }
                j56Var = a;
            }
            return j56Var;
        }
        return (j56) invokeV.objValue;
    }
}
