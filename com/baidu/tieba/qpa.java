package com.baidu.tieba;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class qpa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948100903, "Lcom/baidu/tieba/qpa;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948100903, "Lcom/baidu/tieba/qpa;");
        }
    }

    public static int a(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, str, i)) == null) {
            if (TextUtils.isEmpty(str)) {
                return i;
            }
            try {
                return BdBaseApplication.getInst().getApp().getSharedPreferences("network_config_prefs", 0).getInt(str, i);
            } catch (Exception unused) {
                return i;
            }
        }
        return invokeLI.intValue;
    }

    public static String b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str2;
            }
            try {
                return BdBaseApplication.getInst().getApp().getSharedPreferences("network_config_prefs", 0).getString(str, str2);
            } catch (Exception unused) {
                return str2;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            a("threshold_to_store_log", 1500);
        }
    }

    public static void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("network_config_prefs", 0).edit();
                edit.putString(str, str2);
                edit.apply();
            } catch (Exception unused) {
            }
        }
    }
}
