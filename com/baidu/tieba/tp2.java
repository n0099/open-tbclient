package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class tp2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile sp2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized sp2 a() {
        InterceptResult invokeV;
        sp2 sp2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (tp2.class) {
                if (a == null) {
                    a = new sp2();
                }
                sp2Var = a;
            }
            return sp2Var;
        }
        return (sp2) invokeV.objValue;
    }
}
