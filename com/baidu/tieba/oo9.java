package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class oo9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile no9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized no9 a() {
        InterceptResult invokeV;
        no9 no9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (oo9.class) {
                if (a == null) {
                    a = new no9();
                }
                no9Var = a;
            }
            return no9Var;
        }
        return (no9) invokeV.objValue;
    }
}
