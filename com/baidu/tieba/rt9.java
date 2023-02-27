package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class rt9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile qt9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized qt9 a() {
        InterceptResult invokeV;
        qt9 qt9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (rt9.class) {
                if (a == null) {
                    a = new qt9();
                }
                qt9Var = a;
            }
            return qt9Var;
        }
        return (qt9) invokeV.objValue;
    }
}
