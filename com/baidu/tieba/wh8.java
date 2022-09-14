package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class wh8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile vh8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized vh8 a() {
        InterceptResult invokeV;
        vh8 vh8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (wh8.class) {
                if (a == null) {
                    a = new vh8();
                }
                vh8Var = a;
            }
            return vh8Var;
        }
        return (vh8) invokeV.objValue;
    }
}
