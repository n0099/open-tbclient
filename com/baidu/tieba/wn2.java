package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class wn2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile vn2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized vn2 a() {
        InterceptResult invokeV;
        vn2 vn2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (wn2.class) {
                if (a == null) {
                    a = new vn2();
                }
                vn2Var = a;
            }
            return vn2Var;
        }
        return (vn2) invokeV.objValue;
    }
}
