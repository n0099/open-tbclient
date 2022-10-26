package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class oo3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile no3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized no3 a() {
        InterceptResult invokeV;
        no3 no3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (oo3.class) {
                if (a == null) {
                    a = new no3();
                }
                no3Var = a;
            }
            return no3Var;
        }
        return (no3) invokeV.objValue;
    }
}
