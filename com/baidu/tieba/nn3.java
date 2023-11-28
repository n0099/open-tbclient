package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class nn3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile mn3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized mn3 a() {
        InterceptResult invokeV;
        mn3 mn3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (nn3.class) {
                if (a == null) {
                    a = new mn3();
                }
                mn3Var = a;
            }
            return mn3Var;
        }
        return (mn3) invokeV.objValue;
    }
}
