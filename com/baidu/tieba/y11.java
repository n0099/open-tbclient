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
/* loaded from: classes6.dex */
public class y11 {
    public static /* synthetic */ Interceptable $ic;
    public static final HashMap<String, Integer> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948277200, "Lcom/baidu/tieba/y11;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948277200, "Lcom/baidu/tieba/y11;");
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

    public static String b(@NonNull AdBaseModel adBaseModel, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, adBaseModel, str)) == null) {
            ho0 ho0Var = adBaseModel.l;
            if (ho0Var == null || !ho0Var.e) {
                return str;
            }
            String str2 = ho0Var.a;
            if (TextUtils.isEmpty(str2)) {
                return str;
            }
            boolean d = d(str2);
            String str3 = ho0Var.b;
            if (!d) {
                str3 = "";
            } else if (TextUtils.isEmpty(str3)) {
                return str;
            }
            return TextUtils.isEmpty(str3) ? str : str3;
        }
        return (String) invokeLL.objValue;
    }

    public static String c(AdBaseModel adBaseModel) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, adBaseModel)) == null) {
            if (adBaseModel == null || (str = adBaseModel.f.d) == null) {
                return null;
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            try {
                mi0.b().getPackageManager().getApplicationInfo(str, 0);
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

    public static String g(@NonNull AdBaseModel adBaseModel, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, adBaseModel, str)) == null) {
            if (m(str)) {
                String c = c(adBaseModel);
                return !TextUtils.isEmpty(c) ? l(str, c) : str;
            }
            return str;
        }
        return (String) invokeLL.objValue;
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
        if (!(interceptable == null || interceptable.invokeL(65545, null, adBaseModel) == null) || TextUtils.isEmpty(adBaseModel.f.c)) {
            return;
        }
        po0 po0Var = adBaseModel.f;
        po0Var.c = g(adBaseModel, po0Var.c);
    }

    public static void j(@NonNull AdBaseModel adBaseModel) {
        ho0 ho0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65546, null, adBaseModel) == null) && (ho0Var = adBaseModel.l) != null && ho0Var.e) {
            String str = ho0Var.b;
            if (str.contains("__AUTO_INVOKE__")) {
                adBaseModel.l.b = str.replace("__AUTO_INVOKE__", d(adBaseModel.l.a) ? "0" : "1");
            }
        }
    }

    public static void k(AdBaseModel adBaseModel) {
        ho0 ho0Var;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65547, null, adBaseModel) == null) || (ho0Var = adBaseModel.l) == null || (str = ho0Var.b) == null) {
            return;
        }
        ho0Var.b = g(adBaseModel, str);
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
}
