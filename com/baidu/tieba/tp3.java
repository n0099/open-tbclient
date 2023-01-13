package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class tp3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile sp3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized sp3 a() {
        InterceptResult invokeV;
        sp3 sp3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (tp3.class) {
                if (a == null) {
                    a = new sp3();
                }
                sp3Var = a;
            }
            return sp3Var;
        }
        return (sp3) invokeV.objValue;
    }
}
