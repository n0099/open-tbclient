package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class xv3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile wv3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized wv3 a() {
        InterceptResult invokeV;
        wv3 wv3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (xv3.class) {
                if (a == null) {
                    a = new wv3();
                }
                wv3Var = a;
            }
            return wv3Var;
        }
        return (wv3) invokeV.objValue;
    }
}
