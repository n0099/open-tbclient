package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class wq9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile vq9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized vq9 a() {
        InterceptResult invokeV;
        vq9 vq9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (wq9.class) {
                if (a == null) {
                    a = new vq9();
                }
                vq9Var = a;
            }
            return vq9Var;
        }
        return (vq9) invokeV.objValue;
    }
}
