package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes5.dex */
public class ma {
    public static /* synthetic */ Interceptable $ic;
    public static final Pattern a;
    public static final HashMap b;
    public static volatile String c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448310937, "Lcom/baidu/tieba/ma;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448310937, "Lcom/baidu/tieba/ma;");
                return;
            }
        }
        a = Pattern.compile("[http|https]://tiebac.baidu.com/(.*)");
        b = new HashMap();
        c = "";
    }

    public static synchronized void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65537, null, i) == null) {
            synchronized (ma.class) {
                if (!b.containsKey(c)) {
                    b.put(c, new HashSet());
                }
                Set set = (Set) b.get(c);
                if (set != null) {
                    set.add(Integer.toString(i));
                }
            }
        }
    }

    public static synchronized void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            synchronized (ma.class) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                Matcher matcher = a.matcher(str);
                if (matcher.find()) {
                    String group = matcher.group(1);
                    if (!b.containsKey(c)) {
                        b.put(c, new HashSet());
                    }
                    Set set = (Set) b.get(c);
                    if (set != null && group != null) {
                        set.add(group);
                    }
                }
            }
        }
    }

    public static synchronized String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            synchronized (ma.class) {
                Set set = (Set) b.get(str);
                if (set == null) {
                    return "";
                }
                return TextUtils.join("_", set);
            }
        }
        return (String) invokeL.objValue;
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) {
            c = str;
        }
    }
}
