package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class yx3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile xx3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized xx3 a() {
        InterceptResult invokeV;
        xx3 xx3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (yx3.class) {
                if (a == null) {
                    a = new xx3();
                }
                xx3Var = a;
            }
            return xx3Var;
        }
        return (xx3) invokeV.objValue;
    }
}
