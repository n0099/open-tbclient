package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class k84 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile j84 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized j84 a() {
        InterceptResult invokeV;
        j84 j84Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (k84.class) {
                if (a == null) {
                    a = new j84();
                }
                j84Var = a;
            }
            return j84Var;
        }
        return (j84) invokeV.objValue;
    }
}
