package com.baidu.tieba;

import android.net.Uri;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class yr0 {
    public static /* synthetic */ Interceptable $ic;
    public static final yr0 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948339634, "Lcom/baidu/tieba/yr0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948339634, "Lcom/baidu/tieba/yr0;");
                return;
            }
        }
        a = new yr0();
    }

    public yr0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @JvmStatic
    public static final int a(vr0 vr0Var, String str) {
        InterceptResult invokeLL;
        tr0 c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, vr0Var, str)) == null) {
            Integer valueOf = (vr0Var == null && ((c = xr0.c(str)) == null || (vr0Var = c.a()) == null)) ? null : Integer.valueOf(vr0Var.a());
            if (valueOf != null) {
                return valueOf.intValue();
            }
            return 0;
        }
        return invokeLL.intValue;
    }

    @JvmStatic
    public static final String c(vr0 vr0Var, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, vr0Var, str, str2)) == null) ? a.b(a(vr0Var, str), str2) : (String) invokeLLL.objValue;
    }

    public final String b(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, str)) == null) {
            return i != 1 ? "" : str == null || str.length() == 0 ? "https://sv.baidu.com" : d(str);
        }
        return (String) invokeIL.objValue;
    }

    public final String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            try {
                Uri url = Uri.parse(str);
                Intrinsics.checkNotNullExpressionValue(url, "url");
                String scheme = url.getScheme();
                if (scheme != null) {
                    String str2 = scheme + "://";
                    if (str2 != null) {
                        String str3 = str2 + url.getHost();
                        return str3 != null ? str3 : "https://sv.baidu.com";
                    }
                    return "https://sv.baidu.com";
                }
                return "https://sv.baidu.com";
            } catch (Exception e) {
                e.printStackTrace();
                return "https://sv.baidu.com";
            }
        }
        return (String) invokeL.objValue;
    }
}
