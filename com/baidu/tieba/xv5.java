package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class xv5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile wv5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized wv5 a() {
        InterceptResult invokeV;
        wv5 wv5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (xv5.class) {
                if (a == null) {
                    a = new wv5();
                }
                wv5Var = a;
            }
            return wv5Var;
        }
        return (wv5) invokeV.objValue;
    }
}
