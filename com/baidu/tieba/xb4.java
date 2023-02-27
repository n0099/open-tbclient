package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class xb4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile wb4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized wb4 a() {
        InterceptResult invokeV;
        wb4 wb4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (xb4.class) {
                if (a == null) {
                    a = new wb4();
                }
                wb4Var = a;
            }
            return wb4Var;
        }
        return (wb4) invokeV.objValue;
    }
}
