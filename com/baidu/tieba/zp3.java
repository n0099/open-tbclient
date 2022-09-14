package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class zp3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile yp3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized yp3 a() {
        InterceptResult invokeV;
        yp3 yp3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (zp3.class) {
                if (a == null) {
                    a = new yp3();
                }
                yp3Var = a;
            }
            return yp3Var;
        }
        return (yp3) invokeV.objValue;
    }
}
