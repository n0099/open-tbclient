package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class x46 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile w46 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized w46 a() {
        InterceptResult invokeV;
        w46 w46Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (x46.class) {
                if (a == null) {
                    a = new w46();
                }
                w46Var = a;
            }
            return w46Var;
        }
        return (w46) invokeV.objValue;
    }
}
