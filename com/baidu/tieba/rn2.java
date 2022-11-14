package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class rn2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile qn2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized qn2 a() {
        InterceptResult invokeV;
        qn2 qn2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (rn2.class) {
                if (a == null) {
                    a = new qn2();
                }
                qn2Var = a;
            }
            return qn2Var;
        }
        return (qn2) invokeV.objValue;
    }
}
