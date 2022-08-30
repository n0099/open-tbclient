package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class uj3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile tj3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized tj3 a() {
        InterceptResult invokeV;
        tj3 tj3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (uj3.class) {
                if (a == null) {
                    a = new tj3();
                }
                tj3Var = a;
            }
            return tj3Var;
        }
        return (tj3) invokeV.objValue;
    }
}
