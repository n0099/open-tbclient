package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class zp2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile yp2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized yp2 a() {
        InterceptResult invokeV;
        yp2 yp2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (zp2.class) {
                if (a == null) {
                    a = new yp2();
                }
                yp2Var = a;
            }
            return yp2Var;
        }
        return (yp2) invokeV.objValue;
    }
}
