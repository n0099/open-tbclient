package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class pq6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile oq6 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized oq6 a() {
        InterceptResult invokeV;
        oq6 oq6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (pq6.class) {
                if (a == null) {
                    a = new oq6();
                }
                oq6Var = a;
            }
            return oq6Var;
        }
        return (oq6) invokeV.objValue;
    }
}
