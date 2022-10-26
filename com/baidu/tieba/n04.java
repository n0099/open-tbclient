package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class n04 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile m04 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized m04 a() {
        InterceptResult invokeV;
        m04 m04Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (n04.class) {
                if (a == null) {
                    a = new m04();
                }
                m04Var = a;
            }
            return m04Var;
        }
        return (m04) invokeV.objValue;
    }
}
