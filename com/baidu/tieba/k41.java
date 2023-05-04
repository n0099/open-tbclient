package com.baidu.tieba;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public class k41 {
    public static /* synthetic */ Interceptable $ic;
    public static final long a;
    public static final long b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947863009, "Lcom/baidu/tieba/k41;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947863009, "Lcom/baidu/tieba/k41;");
                return;
            }
        }
        a = TimeUnit.DAYS.toMillis(1L);
        TimeUnit.HOURS.toMillis(1L);
        b = TimeUnit.MINUTES.toMillis(1L);
        TimeUnit.SECONDS.toMillis(1L);
    }

    public static int a(@NonNull String str, @NonNull String str2, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65537, null, str, str2, i)) == null) {
            String b2 = b(str, str2);
            if (TextUtils.isEmpty(b2)) {
                return i;
            }
            try {
                return Integer.parseInt(b2);
            } catch (NumberFormatException unused) {
                return i;
            }
        }
        return invokeLLI.intValue;
    }

    public static void e(@NonNull String str, @NonNull String str2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65541, null, str, str2, i) == null) {
            f(str, str2, String.valueOf(i));
        }
    }

    @Nullable
    public static String b(@NonNull String str, @NonNull String str2) {
        InterceptResult invokeLL;
        int indexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            String string = l11.a().b(str).getString(str2, null);
            if (TextUtils.isEmpty(string) || (indexOf = string.indexOf("-")) == -1 || indexOf >= string.length() || !d(string.substring(0, indexOf), System.currentTimeMillis())) {
                return null;
            }
            return string.substring(indexOf + 1);
        }
        return (String) invokeLL.objValue;
    }

    public static boolean c(long j, long j2, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i)})) == null) {
            if (j - j2 > i * b) {
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static void f(@NonNull String str, @NonNull String str2, @NonNull String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65542, null, str, str2, str3) == null) {
            SharedPreferences.Editor edit = l11.a().b(str).edit();
            edit.putString(str2, System.currentTimeMillis() + "-" + str3);
            edit.apply();
        }
    }

    public static boolean d(@Nullable String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(InputDeviceCompat.SOURCE_TRACKBALL, null, str, j)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            long j2 = 0;
            try {
                j2 = Long.parseLong(str);
            } catch (NumberFormatException unused) {
            }
            long j3 = a;
            if (j2 / j3 != j / j3) {
                return false;
            }
            return true;
        }
        return invokeLJ.booleanValue;
    }
}
