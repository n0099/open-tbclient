package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
/* loaded from: classes8.dex */
public final class vn3 {
    public static /* synthetic */ Interceptable $ic;
    public static final Set<Integer> a;
    public static final Set<Integer> b;
    public static final Set<Integer> c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948246510, "Lcom/baidu/tieba/vn3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948246510, "Lcom/baidu/tieba/vn3;");
                return;
            }
        }
        a = new HashSet();
        b = new HashSet();
        c = new HashSet();
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        a.add(6);
        b.add(7);
        b.add(1);
        c.addAll(a);
        c.addAll(b);
    }

    public static Date a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return new Date();
        }
        return (Date) invokeV.objValue;
    }

    public static String b(Date date, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, date, str)) == null) {
            if (date == null) {
                return "";
            }
            try {
                return new SimpleDateFormat(str, Locale.getDefault()).format(date);
            } catch (Exception unused) {
                try {
                    return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(date);
                } catch (Exception e) {
                    e.printStackTrace();
                    return "";
                }
            }
        }
        return (String) invokeLL.objValue;
    }

    public static Date c(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            if (str == null) {
                return null;
            }
            try {
                return new SimpleDateFormat(str2, Locale.getDefault()).parse(str);
            } catch (Exception unused) {
                try {
                    return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(str);
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return (Date) invokeLL.objValue;
    }

    public static Date d(String str, String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, strArr)) == null) {
            Date date = null;
            if (!TextUtils.isEmpty(str) && strArr != null) {
                for (String str2 : strArr) {
                    try {
                        date = new SimpleDateFormat(str2, Locale.getDefault()).parse(str);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (date != null) {
                        break;
                    }
                }
            }
            return date;
        }
        return (Date) invokeLL.objValue;
    }

    public static String e(Date date, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, date, str)) == null) {
            if (date == null) {
                return "";
            }
            try {
                return new SimpleDateFormat(str, Locale.getDefault()).format(date);
            } catch (Exception unused) {
                try {
                    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(date);
                } catch (Exception e) {
                    e.printStackTrace();
                    return "";
                }
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String g(long j, String str) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65543, null, j, str)) == null) {
            try {
                return new SimpleDateFormat((str == null || str.isEmpty()) ? "yyyy-MM-dd HH:mm:ss" : "yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(j));
            } catch (NumberFormatException e) {
                if (rr1.a) {
                    e.printStackTrace();
                    return "";
                }
                return "";
            }
        }
        return (String) invokeJL.objValue;
    }

    public static boolean f(Long l, Long l2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, l, l2)) == null) {
            if (l.longValue() / 86400000 == l2.longValue() / 86400000) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
