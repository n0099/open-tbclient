package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class t86 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile s86 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized s86 a() {
        InterceptResult invokeV;
        s86 s86Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (t86.class) {
                if (a == null) {
                    a = new s86();
                }
                s86Var = a;
            }
            return s86Var;
        }
        return (s86) invokeV.objValue;
    }
}
