package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class vn2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile un2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized un2 a() {
        InterceptResult invokeV;
        un2 un2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (vn2.class) {
                if (a == null) {
                    a = new un2();
                }
                un2Var = a;
            }
            return un2Var;
        }
        return (un2) invokeV.objValue;
    }
}
