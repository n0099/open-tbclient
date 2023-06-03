package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class rr9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile qr9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized qr9 a() {
        InterceptResult invokeV;
        qr9 qr9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (rr9.class) {
                if (a == null) {
                    a = new qr9();
                }
                qr9Var = a;
            }
            return qr9Var;
        }
        return (qr9) invokeV.objValue;
    }
}
