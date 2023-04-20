package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class to3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile so3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized so3 a() {
        InterceptResult invokeV;
        so3 so3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (to3.class) {
                if (a == null) {
                    a = new so3();
                }
                so3Var = a;
            }
            return so3Var;
        }
        return (so3) invokeV.objValue;
    }
}
