package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class rn8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile qn8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized qn8 a() {
        InterceptResult invokeV;
        qn8 qn8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (rn8.class) {
                if (a == null) {
                    a = new qn8();
                }
                qn8Var = a;
            }
            return qn8Var;
        }
        return (qn8) invokeV.objValue;
    }
}
