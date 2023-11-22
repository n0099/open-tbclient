package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class yja {
    public static /* synthetic */ Interceptable $ic;
    public static volatile xja a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized xja a() {
        InterceptResult invokeV;
        xja xjaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (yja.class) {
                if (a == null) {
                    a = new xja();
                }
                xjaVar = a;
            }
            return xjaVar;
        }
        return (xja) invokeV.objValue;
    }
}
