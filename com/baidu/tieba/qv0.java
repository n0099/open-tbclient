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
/* loaded from: classes7.dex */
public final class qv0 {
    public static /* synthetic */ Interceptable $ic;
    public static final qv0 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948105150, "Lcom/baidu/tieba/qv0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948105150, "Lcom/baidu/tieba/qv0;");
                return;
            }
        }
        a = new qv0();
    }

    public qv0() {
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
    public static final int a(nv0 nv0Var, String str) {
        InterceptResult invokeLL;
        lv0 c;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, nv0Var, str)) == null) {
            if (nv0Var != null || ((c = pv0.c(str)) != null && (nv0Var = c.a()) != null)) {
                num = Integer.valueOf(nv0Var.a());
            } else {
                num = null;
            }
            if (num != null) {
                return num.intValue();
            }
            return 0;
        }
        return invokeLL.intValue;
    }

    @JvmStatic
    public static final String c(nv0 nv0Var, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, nv0Var, str, str2)) == null) {
            return a.b(a(nv0Var, str), str2);
        }
        return (String) invokeLLL.objValue;
    }

    public final String b(int i, String str) {
        InterceptResult invokeIL;
        boolean z;
        String d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, str)) == null) {
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                d = "https://sv.baidu.com";
            } else {
                d = d(str);
            }
            if (i != 1) {
                return "";
            }
            return d;
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
                if (scheme == null) {
                    return "https://sv.baidu.com";
                }
                String str2 = scheme + "://";
                if (str2 == null) {
                    return "https://sv.baidu.com";
                }
                String str3 = str2 + url.getHost();
                if (str3 == null) {
                    return "https://sv.baidu.com";
                }
                return str3;
            } catch (Exception e) {
                e.printStackTrace();
                return "https://sv.baidu.com";
            }
        }
        return (String) invokeL.objValue;
    }
}
