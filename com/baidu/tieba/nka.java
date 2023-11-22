package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class nka {
    public static /* synthetic */ Interceptable $ic;
    public static volatile mka a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized mka a() {
        InterceptResult invokeV;
        mka mkaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (nka.class) {
                if (a == null) {
                    a = new mka();
                }
                mkaVar = a;
            }
            return mkaVar;
        }
        return (mka) invokeV.objValue;
    }
}
