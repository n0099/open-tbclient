package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class jk3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ik3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ik3 a() {
        InterceptResult invokeV;
        ik3 ik3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (jk3.class) {
                if (a == null) {
                    a = new ik3();
                }
                ik3Var = a;
            }
            return ik3Var;
        }
        return (ik3) invokeV.objValue;
    }
}
