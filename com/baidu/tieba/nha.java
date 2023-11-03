package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class nha {
    public static /* synthetic */ Interceptable $ic;
    public static volatile mha a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized mha a() {
        InterceptResult invokeV;
        mha mhaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (nha.class) {
                if (a == null) {
                    a = new mha();
                }
                mhaVar = a;
            }
            return mhaVar;
        }
        return (mha) invokeV.objValue;
    }
}
