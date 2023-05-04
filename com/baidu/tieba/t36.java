package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class t36 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile s36 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized s36 a() {
        InterceptResult invokeV;
        s36 s36Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (t36.class) {
                if (a == null) {
                    a = new s36();
                }
                s36Var = a;
            }
            return s36Var;
        }
        return (s36) invokeV.objValue;
    }
}
