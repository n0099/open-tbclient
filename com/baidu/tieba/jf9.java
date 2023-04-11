package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class jf9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile if9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized if9 a() {
        InterceptResult invokeV;
        if9 if9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (jf9.class) {
                if (a == null) {
                    a = new if9();
                }
                if9Var = a;
            }
            return if9Var;
        }
        return (if9) invokeV.objValue;
    }
}
