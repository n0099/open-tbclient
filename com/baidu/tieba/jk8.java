package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class jk8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ik8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ik8 a() {
        InterceptResult invokeV;
        ik8 ik8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (jk8.class) {
                if (a == null) {
                    a = new ik8();
                }
                ik8Var = a;
            }
            return ik8Var;
        }
        return (ik8) invokeV.objValue;
    }
}
