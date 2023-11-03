package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class xja {
    public static /* synthetic */ Interceptable $ic;
    public static volatile wja a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized wja a() {
        InterceptResult invokeV;
        wja wjaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (xja.class) {
                if (a == null) {
                    a = new wja();
                }
                wjaVar = a;
            }
            return wjaVar;
        }
        return (wja) invokeV.objValue;
    }
}
