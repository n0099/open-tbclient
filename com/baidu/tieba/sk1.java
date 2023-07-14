package com.baidu.tieba;

import android.content.Context;
import android.net.Uri;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class sk1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948154192, "Lcom/baidu/tieba/sk1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948154192, "Lcom/baidu/tieba/sk1;");
                return;
            }
        }
        wk1 e = wk1.e();
        xk1 xk1Var = new xk1();
        e.f("splash_ad", xk1Var);
        e.g(xk1Var);
    }

    public static boolean a(Context context, String str, pk1 pk1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, context, str, pk1Var)) == null) {
            if (yk1.g(str)) {
                return c(context, Uri.parse(str), pk1Var);
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static boolean c(Context context, Uri uri, pk1 pk1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, context, uri, pk1Var)) == null) {
            return b(context, uri, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE, pk1Var);
        }
        return invokeLLL.booleanValue;
    }

    public static boolean b(Context context, Uri uri, String str, pk1 pk1Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, context, uri, str, pk1Var)) == null) {
            if (context == null) {
                context = rk1.a();
            }
            wk1 e = wk1.e();
            vk1 vk1Var = new vk1(uri, str);
            vk1Var.g(false);
            return e.b(context, vk1Var, pk1Var);
        }
        return invokeLLLL.booleanValue;
    }
}
