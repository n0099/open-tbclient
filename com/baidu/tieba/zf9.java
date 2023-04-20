package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class zf9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile yf9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized yf9 a() {
        InterceptResult invokeV;
        yf9 yf9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (zf9.class) {
                if (a == null) {
                    a = new yf9();
                }
                yf9Var = a;
            }
            return yf9Var;
        }
        return (yf9) invokeV.objValue;
    }
}
