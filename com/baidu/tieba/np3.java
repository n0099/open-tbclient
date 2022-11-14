package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class np3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile mp3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized mp3 a() {
        InterceptResult invokeV;
        mp3 mp3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (np3.class) {
                if (a == null) {
                    a = new mp3();
                }
                mp3Var = a;
            }
            return mp3Var;
        }
        return (mp3) invokeV.objValue;
    }
}
