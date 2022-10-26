package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class wn4 {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = 1;
    public static int b = 2;
    public static int c = 3;
    public static int d = 1;
    public static int e = 2;
    public static int f = 3;
    public static int g = 4;
    public static int h = 5;
    public static int i = 6;
    public static int j = 7;
    public static int k = 8;
    public static int l = 9;
    public static xn4 m;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948276332, "Lcom/baidu/tieba/wn4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948276332, "Lcom/baidu/tieba/wn4;");
                return;
            }
        }
        m = new xn4();
    }

    public static void a(int i2, int i3, String str, String str2, String str3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, str2, str3, Integer.valueOf(i4)}) == null) {
            yn4 yn4Var = new yn4();
            yn4Var.a = i2;
            yn4Var.b = i3;
            yn4Var.c = str;
            yn4Var.d = str2;
            yn4Var.e = str3;
            yn4Var.f = i4;
            m.a(yn4Var);
        }
    }
}
