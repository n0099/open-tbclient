package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class jz3 {
    public static /* synthetic */ Interceptable $ic = null;
    public static float a = 3.0f;
    public static float b = 1.5f;
    public static float c = 0.12f;
    public static float d = 0.06f;
    public static float e = 0.13f;
    public static float f = 0.12f;
    public static float g = 0.19f;
    public static float h = 0.05f;
    public static float i = 0.48f;
    public static float j = 0.33f;
    public static float k = 0.19f;
    public static float l = 0.45f;
    public static float m = 0.15f;
    public static float n = 0.12f;
    public static float o = 0.13f;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947900550, "Lcom/baidu/tieba/jz3;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947900550, "Lcom/baidu/tieba/jz3;");
        }
    }
}
