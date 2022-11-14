package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class xv0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile wv0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized wv0 a() {
        InterceptResult invokeV;
        wv0 wv0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (xv0.class) {
                if (a == null) {
                    a = new wv0();
                }
                wv0Var = a;
            }
            return wv0Var;
        }
        return (wv0) invokeV.objValue;
    }
}
