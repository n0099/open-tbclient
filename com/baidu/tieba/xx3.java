package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class xx3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile wx3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized wx3 a() {
        InterceptResult invokeV;
        wx3 wx3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (xx3.class) {
                if (a == null) {
                    a = new wx3();
                }
                wx3Var = a;
            }
            return wx3Var;
        }
        return (wx3) invokeV.objValue;
    }
}
