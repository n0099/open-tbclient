package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class kf9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile jf9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized jf9 a() {
        InterceptResult invokeV;
        jf9 jf9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (kf9.class) {
                if (a == null) {
                    a = new jf9();
                }
                jf9Var = a;
            }
            return jf9Var;
        }
        return (jf9) invokeV.objValue;
    }
}
