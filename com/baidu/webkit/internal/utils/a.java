package com.baidu.webkit.internal.utils;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.Stack;
/* loaded from: classes9.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static String f64178a = "none";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1860953195, "Lcom/baidu/webkit/internal/utils/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1860953195, "Lcom/baidu/webkit/internal/utils/a;");
        }
    }

    public static boolean a(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, file)) == null) ? file.setReadable(true, false) : invokeL.booleanValue;
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            Stack stack = new Stack();
            if (str == null) {
                return false;
            }
            stack.push(str);
            while (stack.size() > 0) {
                String str2 = (String) stack.pop();
                File file = new File(str2);
                if (file.isDirectory()) {
                    String[] list = file.list();
                    if (list != null && list.length > 0) {
                        stack.push(str2);
                        String str3 = str2 + "/";
                        for (String str4 : file.list()) {
                            stack.push(str3 + str4);
                        }
                    } else if (!file.delete()) {
                        sb = new StringBuilder("remove fail, can not delete file = ");
                        sb.append(file.getAbsolutePath());
                        f64178a = sb.toString();
                        return false;
                    }
                } else if (!file.delete()) {
                    sb = new StringBuilder("remove fail, can not delete file = ");
                    sb.append(file.getAbsolutePath());
                    f64178a = sb.toString();
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
