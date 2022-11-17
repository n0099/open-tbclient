package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class zt5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile yt5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized yt5 a() {
        InterceptResult invokeV;
        yt5 yt5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (zt5.class) {
                if (a == null) {
                    a = new yt5();
                }
                yt5Var = a;
            }
            return yt5Var;
        }
        return (yt5) invokeV.objValue;
    }
}
