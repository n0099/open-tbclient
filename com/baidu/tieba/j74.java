package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class j74 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile i74 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized i74 a() {
        InterceptResult invokeV;
        i74 i74Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (j74.class) {
                if (a == null) {
                    a = new i74();
                }
                i74Var = a;
            }
            return i74Var;
        }
        return (i74) invokeV.objValue;
    }
}
