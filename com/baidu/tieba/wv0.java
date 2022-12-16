package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class wv0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile vv0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized vv0 a() {
        InterceptResult invokeV;
        vv0 vv0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (wv0.class) {
                if (a == null) {
                    a = new vv0();
                }
                vv0Var = a;
            }
            return vv0Var;
        }
        return (vv0) invokeV.objValue;
    }
}
