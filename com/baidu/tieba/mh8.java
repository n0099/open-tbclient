package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class mh8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile lh8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized lh8 a() {
        InterceptResult invokeV;
        lh8 lh8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (mh8.class) {
                if (a == null) {
                    a = new lh8();
                }
                lh8Var = a;
            }
            return lh8Var;
        }
        return (lh8) invokeV.objValue;
    }
}
