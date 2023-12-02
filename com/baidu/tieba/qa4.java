package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class qa4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile pa4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized pa4 a() {
        InterceptResult invokeV;
        pa4 pa4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (qa4.class) {
                if (a == null) {
                    a = new pa4();
                }
                pa4Var = a;
            }
            return pa4Var;
        }
        return (pa4) invokeV.objValue;
    }
}
