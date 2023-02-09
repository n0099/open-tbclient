package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class vx8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ux8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ux8 a() {
        InterceptResult invokeV;
        ux8 ux8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (vx8.class) {
                if (a == null) {
                    a = new ux8();
                }
                ux8Var = a;
            }
            return ux8Var;
        }
        return (ux8) invokeV.objValue;
    }
}
