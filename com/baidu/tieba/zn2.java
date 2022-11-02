package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class zn2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile yn2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized yn2 a() {
        InterceptResult invokeV;
        yn2 yn2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (zn2.class) {
                if (a == null) {
                    a = new yn2();
                }
                yn2Var = a;
            }
            return yn2Var;
        }
        return (yn2) invokeV.objValue;
    }
}
