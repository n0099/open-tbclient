package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.ServiceState;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Method;
/* loaded from: classes5.dex */
public class m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(Context context, TelephonyManager telephonyManager) {
        InterceptResult invokeLL;
        ServiceState serviceState;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, telephonyManager)) == null) {
            if (context != null && Build.VERSION.SDK_INT >= 29 && context.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0) {
                try {
                    int a2 = a();
                    if (a2 == -1) {
                        serviceState = telephonyManager.getServiceState();
                    } else {
                        Method declaredMethod = TelephonyManager.class.getDeclaredMethod("getServiceStateForSubscriber", Integer.TYPE);
                        declaredMethod.setAccessible(true);
                        serviceState = (ServiceState) declaredMethod.invoke(telephonyManager, Integer.valueOf(a2));
                    }
                    return a(serviceState);
                } catch (Exception e2) {
                    j.f("NetworkUtils", e2.toString());
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static int b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) {
            int c2 = c(context);
            if (c2 != 1) {
                if (c2 != 4) {
                    if (c2 != 5) {
                        if (c2 != 6) {
                            return c2;
                        }
                        return 6;
                    }
                    return 4;
                }
                return 1;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static int c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) {
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                    int type = activeNetworkInfo.getType();
                    if (type != 0) {
                        return type != 1 ? 1 : 4;
                    }
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    switch (telephonyManager.getNetworkType()) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                        case 16:
                            return 2;
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                        case 17:
                            return 3;
                        case 13:
                        case 18:
                        case 19:
                            return a(context, telephonyManager) ? 6 : 5;
                        case 20:
                            return 6;
                        default:
                            String subtypeName = activeNetworkInfo.getSubtypeName();
                            return (TextUtils.isEmpty(subtypeName) || !(subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000"))) ? 1 : 3;
                    }
                }
                return 0;
            } catch (Throwable unused) {
                return 1;
            }
        }
        return invokeL.intValue;
    }

    public static boolean d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) ? c(context) == 4 : invokeL.booleanValue;
    }

    public static boolean e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) ? c(context) == 5 : invokeL.booleanValue;
    }

    public static boolean f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) ? c(context) == 6 : invokeL.booleanValue;
    }

    public static String g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            int c2 = c(context);
            return c2 != 2 ? c2 != 3 ? c2 != 4 ? c2 != 5 ? c2 != 6 ? "mobile" : "5g" : "4g" : "wifi" : "3g" : "2g";
        }
        return (String) invokeL.objValue;
    }

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                return SubscriptionManager.getDefaultDataSubscriptionId();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public static boolean a(ServiceState serviceState) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, serviceState)) == null) {
            try {
                Method method = serviceState.getClass().getMethod("getNrState", new Class[0]);
                if (method != null) {
                    method.setAccessible(true);
                    int intValue = ((Integer) method.invoke(serviceState, new Object[0])).intValue();
                    return intValue == 3 || intValue == 2;
                }
            } catch (Exception e2) {
                j.f("NetworkUtils", e2.toString());
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean a(Context context) {
        InterceptResult invokeL;
        NetworkInfo[] allNetworkInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager != null && (allNetworkInfo = connectivityManager.getAllNetworkInfo()) != null) {
                    for (NetworkInfo networkInfo : allNetworkInfo) {
                        if (networkInfo.getState() == NetworkInfo.State.CONNECTED || networkInfo.getState() == NetworkInfo.State.CONNECTING) {
                            return true;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith("https://")) : invokeL.booleanValue;
    }
}
