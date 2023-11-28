package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class jma {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ima a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ima a() {
        InterceptResult invokeV;
        ima imaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (jma.class) {
                if (a == null) {
                    a = new ima();
                }
                imaVar = a;
            }
            return imaVar;
        }
        return (ima) invokeV.objValue;
    }
}
