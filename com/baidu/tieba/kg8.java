package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class kg8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile jg8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized jg8 a() {
        InterceptResult invokeV;
        jg8 jg8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (kg8.class) {
                if (a == null) {
                    a = new jg8();
                }
                jg8Var = a;
            }
            return jg8Var;
        }
        return (jg8) invokeV.objValue;
    }
}
