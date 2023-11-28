package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class rr3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile qr3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized qr3 a() {
        InterceptResult invokeV;
        qr3 qr3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (rr3.class) {
                if (a == null) {
                    a = new qr3();
                }
                qr3Var = a;
            }
            return qr3Var;
        }
        return (qr3) invokeV.objValue;
    }
}
