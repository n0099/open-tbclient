package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class ju5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile iu5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized iu5 a() {
        InterceptResult invokeV;
        iu5 iu5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ju5.class) {
                if (a == null) {
                    a = new iu5();
                }
                iu5Var = a;
            }
            return iu5Var;
        }
        return (iu5) invokeV.objValue;
    }
}
