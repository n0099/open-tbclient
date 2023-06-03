package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class no9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile mo9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized mo9 a() {
        InterceptResult invokeV;
        mo9 mo9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (no9.class) {
                if (a == null) {
                    a = new mo9();
                }
                mo9Var = a;
            }
            return mo9Var;
        }
        return (mo9) invokeV.objValue;
    }
}
