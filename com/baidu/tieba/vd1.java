package com.baidu.tieba;

import android.content.Context;
import android.net.Uri;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class vd1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948236838, "Lcom/baidu/tieba/vd1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948236838, "Lcom/baidu/tieba/vd1;");
                return;
            }
        }
        zd1 e = zd1.e();
        ae1 ae1Var = new ae1();
        e.f("splash_ad", ae1Var);
        e.g(ae1Var);
    }

    public static boolean a(Context context, String str, sd1 sd1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, context, str, sd1Var)) == null) {
            if (be1.g(str)) {
                return c(context, Uri.parse(str), sd1Var);
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static boolean b(Context context, Uri uri, String str, sd1 sd1Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, context, uri, str, sd1Var)) == null) {
            if (context == null) {
                context = ud1.a();
            }
            zd1 e = zd1.e();
            yd1 yd1Var = new yd1(uri, str);
            yd1Var.g(false);
            return e.b(context, yd1Var, sd1Var);
        }
        return invokeLLLL.booleanValue;
    }

    public static boolean c(Context context, Uri uri, sd1 sd1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, context, uri, sd1Var)) == null) ? b(context, uri, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE, sd1Var) : invokeLLL.booleanValue;
    }
}
