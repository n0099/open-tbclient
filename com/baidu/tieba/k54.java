package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class k54 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile j54 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized j54 a() {
        InterceptResult invokeV;
        j54 j54Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (k54.class) {
                if (a == null) {
                    a = new j54();
                }
                j54Var = a;
            }
            return j54Var;
        }
        return (j54) invokeV.objValue;
    }
}
