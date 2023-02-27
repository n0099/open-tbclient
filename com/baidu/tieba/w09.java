package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class w09 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile v09 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized v09 a() {
        InterceptResult invokeV;
        v09 v09Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (w09.class) {
                if (a == null) {
                    a = new v09();
                }
                v09Var = a;
            }
            return v09Var;
        }
        return (v09) invokeV.objValue;
    }
}
