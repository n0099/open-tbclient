package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class jf4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile if4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized if4 a() {
        InterceptResult invokeV;
        if4 if4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (jf4.class) {
                if (a == null) {
                    a = new if4();
                }
                if4Var = a;
            }
            return if4Var;
        }
        return (if4) invokeV.objValue;
    }
}
