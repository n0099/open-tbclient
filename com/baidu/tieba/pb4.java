package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class pb4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ob4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ob4 a() {
        InterceptResult invokeV;
        ob4 ob4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (pb4.class) {
                if (a == null) {
                    a = new ob4();
                }
                ob4Var = a;
            }
            return ob4Var;
        }
        return (ob4) invokeV.objValue;
    }
}
