package com.baidu.wallet.personal.storage;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.apollon.utils.SharedPreferencesUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static String f27257a = "_card.preferences";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1627557301, "Lcom/baidu/wallet/personal/storage/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1627557301, "Lcom/baidu/wallet/personal/storage/a;");
        }
    }

    public static void a(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, context, str, str2) == null) {
            SharedPreferencesUtils.setParam(context, f27257a, str, str2);
        }
    }

    public static String b(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, context, str, str2)) == null) ? (String) SharedPreferencesUtils.getParam(context, f27257a, str, str2) : (String) invokeLLL.objValue;
    }

    public static void c(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, context, str, str2) == null) {
            SharedPreferencesUtils.setParam(context, f27257a, str, str2);
        }
    }

    public static String d(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, context, str, str2)) == null) ? (String) SharedPreferencesUtils.getParam(context, f27257a, str, str2) : (String) invokeLLL.objValue;
    }

    public static void a(Context context, String str, Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, context, str, bool) == null) {
            SharedPreferencesUtils.setParam(context, f27257a, str, bool);
        }
    }

    public static boolean b(Context context, String str, Boolean bool) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str, bool)) == null) ? ((Boolean) SharedPreferencesUtils.getParam(context, f27257a, str, bool)).booleanValue() : invokeLLL.booleanValue;
    }

    public static void c(Context context, String str, Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, context, str, bool) == null) {
            SharedPreferencesUtils.setParam(context, f27257a, str, bool);
        }
    }

    public static boolean d(Context context, String str, Boolean bool) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, context, str, bool)) == null) ? ((Boolean) SharedPreferencesUtils.getParam(context, f27257a, str, bool)).booleanValue() : invokeLLL.booleanValue;
    }
}
