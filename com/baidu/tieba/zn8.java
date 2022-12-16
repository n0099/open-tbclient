package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class zn8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile yn8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized yn8 a() {
        InterceptResult invokeV;
        yn8 yn8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (zn8.class) {
                if (a == null) {
                    a = new yn8();
                }
                yn8Var = a;
            }
            return yn8Var;
        }
        return (yn8) invokeV.objValue;
    }
}
