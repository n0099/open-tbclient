package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class vp2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile up2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized up2 a() {
        InterceptResult invokeV;
        up2 up2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (vp2.class) {
                if (a == null) {
                    a = new up2();
                }
                up2Var = a;
            }
            return up2Var;
        }
        return (up2) invokeV.objValue;
    }
}
