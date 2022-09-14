package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class os5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ns5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ns5 a() {
        InterceptResult invokeV;
        ns5 ns5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (os5.class) {
                if (a == null) {
                    a = new ns5();
                }
                ns5Var = a;
            }
            return ns5Var;
        }
        return (ns5) invokeV.objValue;
    }
}
