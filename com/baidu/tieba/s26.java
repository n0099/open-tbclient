package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class s26 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile r26 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized r26 a() {
        InterceptResult invokeV;
        r26 r26Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (s26.class) {
                if (a == null) {
                    a = new r26();
                }
                r26Var = a;
            }
            return r26Var;
        }
        return (r26) invokeV.objValue;
    }
}
