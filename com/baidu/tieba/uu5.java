package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class uu5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile tu5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized tu5 a() {
        InterceptResult invokeV;
        tu5 tu5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (uu5.class) {
                if (a == null) {
                    a = new tu5();
                }
                tu5Var = a;
            }
            return tu5Var;
        }
        return (tu5) invokeV.objValue;
    }
}
