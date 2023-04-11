package com.baidu.tieba;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes5.dex */
public class m85 {
    public static /* synthetic */ Interceptable $ic;
    public static final List<String> a;
    public static List<String> b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947926559, "Lcom/baidu/tieba/m85;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947926559, "Lcom/baidu/tieba/m85;");
                return;
            }
        }
        a = Arrays.asList(".baidu.com", ".nuomi.com", ".baifubao.com", ".hao123.com");
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        String s;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (hi.isEmpty(str)) {
                return false;
            }
            Uri parse = Uri.parse(str);
            if (parse != null && "file".equals(parse.getScheme()) && parse.getPath() != null && parse.getPath().contains("bdtbNWCache")) {
                return true;
            }
            if (b == null && (s = p45.m().s("js_host_white_list", null)) != null) {
                b = b(s);
            }
            if (b == null) {
                b = a;
            }
            if (parse != null) {
                for (String str2 : b) {
                    if (!TextUtils.isEmpty(str2)) {
                        String host = parse.getHost();
                        if (!TextUtils.isEmpty(host) && host.endsWith(str2)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static List<String> b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (hi.isEmpty(str)) {
                return null;
            }
            return Arrays.asList(str.split(ParamableElem.DIVIDE_PARAM));
        }
        return (List) invokeL.objValue;
    }

    public static void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            if (str == null) {
                p45.m().B("js_host_white_list", "");
            } else {
                p45.m().B("js_host_white_list", str);
            }
            b = b(str);
        }
    }
}
