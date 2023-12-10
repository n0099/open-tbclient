package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class zoa {
    public static /* synthetic */ Interceptable $ic;
    public static volatile yoa a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized yoa a() {
        InterceptResult invokeV;
        yoa yoaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (zoa.class) {
                if (a == null) {
                    a = new yoa();
                }
                yoaVar = a;
            }
            return yoaVar;
        }
        return (yoa) invokeV.objValue;
    }
}
