package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class k33 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile j33 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized j33 a() {
        InterceptResult invokeV;
        j33 j33Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (k33.class) {
                if (a == null) {
                    a = new j33();
                }
                j33Var = a;
            }
            return j33Var;
        }
        return (j33) invokeV.objValue;
    }
}
