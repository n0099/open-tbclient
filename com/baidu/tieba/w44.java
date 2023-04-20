package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class w44 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile v44 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized v44 a() {
        InterceptResult invokeV;
        v44 v44Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (w44.class) {
                if (a == null) {
                    a = new v44();
                }
                v44Var = a;
            }
            return v44Var;
        }
        return (v44) invokeV.objValue;
    }
}
