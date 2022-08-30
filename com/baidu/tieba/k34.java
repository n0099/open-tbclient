package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class k34 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile j34 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized j34 a() {
        InterceptResult invokeV;
        j34 j34Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (k34.class) {
                if (a == null) {
                    a = new j34();
                }
                j34Var = a;
            }
            return j34Var;
        }
        return (j34) invokeV.objValue;
    }
}
