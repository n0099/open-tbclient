package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class xx0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile wx0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized wx0 a() {
        InterceptResult invokeV;
        wx0 wx0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (xx0.class) {
                if (a == null) {
                    a = new wx0();
                }
                wx0Var = a;
            }
            return wx0Var;
        }
        return (wx0) invokeV.objValue;
    }
}
