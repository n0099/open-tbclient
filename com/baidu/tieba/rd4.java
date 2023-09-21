package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class rd4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile qd4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized qd4 a() {
        InterceptResult invokeV;
        qd4 qd4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (rd4.class) {
                if (a == null) {
                    a = new qd4();
                }
                qd4Var = a;
            }
            return qd4Var;
        }
        return (qd4) invokeV.objValue;
    }
}
