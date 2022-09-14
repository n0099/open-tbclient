package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ur5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile tr5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized tr5 a() {
        InterceptResult invokeV;
        tr5 tr5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ur5.class) {
                if (a == null) {
                    a = new tr5();
                }
                tr5Var = a;
            }
            return tr5Var;
        }
        return (tr5) invokeV.objValue;
    }
}
