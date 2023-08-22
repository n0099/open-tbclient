package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class jv4 {
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
    public static int m = 10;
    public static kv4 n;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947896737, "Lcom/baidu/tieba/jv4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947896737, "Lcom/baidu/tieba/jv4;");
                return;
            }
        }
        n = new kv4();
    }

    public static void a(@NonNull int i2, @NonNull int i3, String str, String str2, String str3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, str2, str3, Integer.valueOf(i4)}) == null) {
            lv4 lv4Var = new lv4();
            lv4Var.a = i2;
            lv4Var.b = i3;
            lv4Var.c = str;
            lv4Var.d = str2;
            lv4Var.e = str3;
            lv4Var.f = i4;
            n.a(lv4Var);
        }
    }
}
