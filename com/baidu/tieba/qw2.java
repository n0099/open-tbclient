package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class qw2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile pw2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized pw2 a() {
        InterceptResult invokeV;
        pw2 pw2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (qw2.class) {
                if (a == null) {
                    a = new pw2();
                }
                pw2Var = a;
            }
            return pw2Var;
        }
        return (pw2) invokeV.objValue;
    }
}
