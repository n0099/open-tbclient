package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class sa6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ra6 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ra6 a() {
        InterceptResult invokeV;
        ra6 ra6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (sa6.class) {
                if (a == null) {
                    a = new ra6();
                }
                ra6Var = a;
            }
            return ra6Var;
        }
        return (ra6) invokeV.objValue;
    }
}
