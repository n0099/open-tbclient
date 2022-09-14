package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class nr5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile mr5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized mr5 a() {
        InterceptResult invokeV;
        mr5 mr5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (nr5.class) {
                if (a == null) {
                    a = new mr5();
                }
                mr5Var = a;
            }
            return mr5Var;
        }
        return (mr5) invokeV.objValue;
    }
}
