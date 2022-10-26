package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ti8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile si8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized si8 a() {
        InterceptResult invokeV;
        si8 si8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ti8.class) {
                if (a == null) {
                    a = new si8();
                }
                si8Var = a;
            }
            return si8Var;
        }
        return (si8) invokeV.objValue;
    }
}
