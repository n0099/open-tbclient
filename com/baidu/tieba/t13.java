package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class t13 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile s13 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized s13 a() {
        InterceptResult invokeV;
        s13 s13Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (t13.class) {
                if (a == null) {
                    a = new s13();
                }
                s13Var = a;
            }
            return s13Var;
        }
        return (s13) invokeV.objValue;
    }
}
