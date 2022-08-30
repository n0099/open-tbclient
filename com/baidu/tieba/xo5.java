package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class xo5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile wo5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized wo5 a() {
        InterceptResult invokeV;
        wo5 wo5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (xo5.class) {
                if (a == null) {
                    a = new wo5();
                }
                wo5Var = a;
            }
            return wo5Var;
        }
        return (wo5) invokeV.objValue;
    }
}
