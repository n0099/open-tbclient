package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class k90 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile j90 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized j90 a() {
        InterceptResult invokeV;
        j90 j90Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (k90.class) {
                if (a == null) {
                    a = new j90();
                }
                j90Var = a;
            }
            return j90Var;
        }
        return (j90) invokeV.objValue;
    }
}
