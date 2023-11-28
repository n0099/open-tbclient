package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class ms3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ls3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ls3 a() {
        InterceptResult invokeV;
        ls3 ls3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ms3.class) {
                if (a == null) {
                    a = new ls3();
                }
                ls3Var = a;
            }
            return ls3Var;
        }
        return (ls3) invokeV.objValue;
    }
}
