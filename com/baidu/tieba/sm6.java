package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class sm6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile rm6 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized rm6 a() {
        InterceptResult invokeV;
        rm6 rm6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (sm6.class) {
                if (a == null) {
                    a = new rm6();
                }
                rm6Var = a;
            }
            return rm6Var;
        }
        return (rm6) invokeV.objValue;
    }
}
