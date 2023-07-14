package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class za6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ya6 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ya6 a() {
        InterceptResult invokeV;
        ya6 ya6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (za6.class) {
                if (a == null) {
                    a = new ya6();
                }
                ya6Var = a;
            }
            return ya6Var;
        }
        return (ya6) invokeV.objValue;
    }
}
