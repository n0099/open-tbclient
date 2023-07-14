package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class ut3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948222485, "Lcom/baidu/tieba/ut3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948222485, "Lcom/baidu/tieba/ut3;");
                return;
            }
        }
        a = fs1.a;
    }

    public static void a(String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65537, null, str, str2, str3, str4, str5) == null) {
            yi3 yi3Var = new yi3();
            yi3Var.a = "swan";
            yi3Var.b = str;
            yi3Var.g = str2;
            if (TextUtils.equals(str, "click")) {
                yi3Var.e = str3;
            }
            yi3Var.f = str5;
            yi3Var.a("source", str4);
            if (a) {
                Log.d("LoginAndGetMobileStatics", "staticLoginResult: event = " + yi3Var.f());
            }
            oi3.x("1372", yi3Var);
        }
    }
}
