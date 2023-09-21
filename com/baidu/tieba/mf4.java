package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class mf4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile lf4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized lf4 a() {
        InterceptResult invokeV;
        lf4 lf4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (mf4.class) {
                if (a == null) {
                    a = new lf4();
                }
                lf4Var = a;
            }
            return lf4Var;
        }
        return (lf4) invokeV.objValue;
    }
}
