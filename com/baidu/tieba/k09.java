package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class k09 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile j09 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized j09 a() {
        InterceptResult invokeV;
        j09 j09Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (k09.class) {
                if (a == null) {
                    a = new j09();
                }
                j09Var = a;
            }
            return j09Var;
        }
        return (j09) invokeV.objValue;
    }
}
