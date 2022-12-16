package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class op3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile np3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized np3 a() {
        InterceptResult invokeV;
        np3 np3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (op3.class) {
                if (a == null) {
                    a = new np3();
                }
                np3Var = a;
            }
            return np3Var;
        }
        return (np3) invokeV.objValue;
    }
}
