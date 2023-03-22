package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class s59 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile r59 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized r59 a() {
        InterceptResult invokeV;
        r59 r59Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (s59.class) {
                if (a == null) {
                    a = new r59();
                }
                r59Var = a;
            }
            return r59Var;
        }
        return (r59) invokeV.objValue;
    }
}
