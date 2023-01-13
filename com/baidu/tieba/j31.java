package com.baidu.tieba;

import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.model.AdOperator;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class j31 {
    public static /* synthetic */ Interceptable $ic;
    public static final HashMap<String, Integer> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947832257, "Lcom/baidu/tieba/j31;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947832257, "Lcom/baidu/tieba/j31;");
                return;
            }
        }
        HashMap<String, Integer> hashMap = new HashMap<>();
        a = hashMap;
        hashMap.put("__AD_EXTRA_PARAM_ENCODE_0__", 0);
        a.put("__AD_EXTRA_PARAM_ENCODE_1__", 1);
        a.put("__AD_EXTRA_PARAM_ENCODE_2__", 2);
        a.put("__AD_EXTRA_PARAM_ENCODE_3__", 3);
    }

    public static String a(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, str, i)) == null) {
            if (i <= 0) {
                return str;
            }
            for (int i2 = 0; i2 < i; i2++) {
                str = Uri.encode(str);
            }
            return str;
        }
        return (String) invokeLI.objValue;
    }

    public static String g(@NonNull AdBaseModel adBaseModel, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, adBaseModel, str)) == null) {
            if (!m(str)) {
                return str;
            }
            String c = c(adBaseModel);
            if (!TextUtils.isEmpty(c)) {
                return l(str, c);
            }
            return str;
        }
        return (String) invokeLL.objValue;
    }

    public static String b(@NonNull AdBaseModel adBaseModel, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, adBaseModel, str)) == null) {
            pp0 pp0Var = adBaseModel.l;
            if (pp0Var != null && pp0Var.e) {
                String str2 = pp0Var.a;
                if (TextUtils.isEmpty(str2)) {
                    return str;
                }
                boolean d = d(str2);
                String str3 = pp0Var.b;
                if (d) {
                    if (TextUtils.isEmpty(str3)) {
                        return str;
                    }
                } else {
                    str3 = "";
                }
                if (!TextUtils.isEmpty(str3)) {
                    return str3;
                }
                return str;
            }
            return str;
        }
        return (String) invokeLL.objValue;
    }

    public static String c(AdBaseModel adBaseModel) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, adBaseModel)) == null) {
            if (adBaseModel != null && (str = adBaseModel.f.d) != null) {
                return str;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            try {
                ej0.b().getPackageManager().getApplicationInfo(str, 0);
                return true;
            } catch (PackageManager.NameNotFoundException | Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static void e(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, adBaseModel) == null) {
            h(adBaseModel);
            j(adBaseModel);
        }
    }

    public static void f(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, null, adBaseModel) == null) && adBaseModel.d && !TextUtils.isEmpty(adBaseModel.h.d)) {
            AdOperator adOperator = adBaseModel.h;
            adOperator.d = g(adBaseModel, adOperator.d);
        }
    }

    public static void h(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, adBaseModel) == null) {
            i(adBaseModel);
            f(adBaseModel);
            k(adBaseModel);
        }
    }

    public static void i(@NonNull AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65545, null, adBaseModel) != null) || TextUtils.isEmpty(adBaseModel.f.c)) {
            return;
        }
        xp0 xp0Var = adBaseModel.f;
        xp0Var.c = g(adBaseModel, xp0Var.c);
    }

    public static void k(AdBaseModel adBaseModel) {
        pp0 pp0Var;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, null, adBaseModel) == null) && (pp0Var = adBaseModel.l) != null && (str = pp0Var.b) != null) {
            pp0Var.b = g(adBaseModel, str);
        }
    }

    public static void j(@NonNull AdBaseModel adBaseModel) {
        pp0 pp0Var;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65546, null, adBaseModel) == null) && (pp0Var = adBaseModel.l) != null && pp0Var.e) {
            String str2 = pp0Var.b;
            if (str2.contains("__AUTO_INVOKE__")) {
                if (d(adBaseModel.l.a)) {
                    str = "0";
                } else {
                    str = "1";
                }
                adBaseModel.l.b = str2.replace("__AUTO_INVOKE__", str);
            }
        }
    }

    public static boolean m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            for (Map.Entry<String, Integer> entry : a.entrySet()) {
                if (str.contains(entry.getKey())) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static String l(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, str, str2)) == null) {
            if (str != null && str2 != null) {
                for (Map.Entry<String, Integer> entry : a.entrySet()) {
                    if (str.contains(entry.getKey())) {
                        try {
                            str = str.replaceAll(entry.getKey(), a(str2, entry.getValue().intValue()));
                        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException unused) {
                        }
                    }
                }
            }
            return str;
        }
        return (String) invokeLL.objValue;
    }
}
