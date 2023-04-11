package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class k26 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile j26 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized j26 a() {
        InterceptResult invokeV;
        j26 j26Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (k26.class) {
                if (a == null) {
                    a = new j26();
                }
                j26Var = a;
            }
            return j26Var;
        }
        return (j26) invokeV.objValue;
    }
}
