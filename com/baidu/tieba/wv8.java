package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class wv8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile vv8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized vv8 a() {
        InterceptResult invokeV;
        vv8 vv8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (wv8.class) {
                if (a == null) {
                    a = new vv8();
                }
                vv8Var = a;
            }
            return vv8Var;
        }
        return (vv8) invokeV.objValue;
    }
}
