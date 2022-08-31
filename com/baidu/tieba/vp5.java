package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class vp5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile up5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized up5 a() {
        InterceptResult invokeV;
        up5 up5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (vp5.class) {
                if (a == null) {
                    a = new up5();
                }
                up5Var = a;
            }
            return up5Var;
        }
        return (up5) invokeV.objValue;
    }
}
