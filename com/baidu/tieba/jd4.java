package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class jd4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile id4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized id4 a() {
        InterceptResult invokeV;
        id4 id4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (jd4.class) {
                if (a == null) {
                    a = new id4();
                }
                id4Var = a;
            }
            return id4Var;
        }
        return (id4) invokeV.objValue;
    }
}
