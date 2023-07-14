package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class w14 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile v14 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized v14 a() {
        InterceptResult invokeV;
        v14 v14Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (w14.class) {
                if (a == null) {
                    a = new v14();
                }
                v14Var = a;
            }
            return v14Var;
        }
        return (v14) invokeV.objValue;
    }
}
