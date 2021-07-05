package com.baidu.ufosdk.f;

import android.annotation.SuppressLint;
import android.util.Log;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
@SuppressLint({"SimpleDateFormat"})
/* loaded from: classes6.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static String f23216a = "UFO";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(2041467238, "Lcom/baidu/ufosdk/f/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(2041467238, "Lcom/baidu/ufosdk/f/c;");
        }
    }

    public static int a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (com.baidu.ufosdk.b.o <= 1) {
                return Log.d(f23216a, str);
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static int a(String str, Throwable th) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, th)) == null) {
            if (com.baidu.ufosdk.b.o <= 4) {
                return Log.w(f23216a, str, th);
            }
            return 0;
        }
        return invokeLL.intValue;
    }

    public static int b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (com.baidu.ufosdk.b.o <= 2) {
                return Log.i(f23216a, str);
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static int c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, str)) == null) {
            if (com.baidu.ufosdk.b.o <= 3) {
                return Log.w(f23216a, str);
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static int d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            if (com.baidu.ufosdk.b.o <= 4) {
                return Log.e(f23216a, str);
            }
            return 0;
        }
        return invokeL.intValue;
    }
}
