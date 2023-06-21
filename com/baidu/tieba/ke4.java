package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ke4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile je4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized je4 a() {
        InterceptResult invokeV;
        je4 je4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ke4.class) {
                if (a == null) {
                    a = new je4();
                }
                je4Var = a;
            }
            return je4Var;
        }
        return (je4) invokeV.objValue;
    }
}
