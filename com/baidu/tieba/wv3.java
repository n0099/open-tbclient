package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class wv3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile vv3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized vv3 a() {
        InterceptResult invokeV;
        vv3 vv3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (wv3.class) {
                if (a == null) {
                    a = new vv3();
                }
                vv3Var = a;
            }
            return vv3Var;
        }
        return (vv3) invokeV.objValue;
    }
}
