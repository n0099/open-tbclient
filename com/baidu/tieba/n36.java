package com.baidu.tieba;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.advert.sdk.data.WirelessNetworkType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class n36 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            String imei = TbadkCoreApplication.getInst().getImei();
            if (imei == null || Config.NULL_DEVICE_ID.equals(imei)) {
                return "-";
            }
            return imei;
        }
        return (String) invokeL.objValue;
    }

    public static Integer e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            return Integer.valueOf(context.getResources().getDisplayMetrics().heightPixels);
        }
        return (Integer) invokeL.objValue;
    }

    public static Integer f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            return Integer.valueOf(context.getResources().getDisplayMetrics().widthPixels);
        }
        return (Integer) invokeL.objValue;
    }

    public static Integer b(Context context) {
        InterceptResult invokeL;
        int value;
        WirelessNetworkType wirelessNetworkType;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            Integer valueOf = Integer.valueOf(WirelessNetworkType.UNKNOWN_NETWORK.getValue());
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                String typeName = activeNetworkInfo.getTypeName();
                if (typeName.equalsIgnoreCase("WIFI")) {
                    return Integer.valueOf(WirelessNetworkType.WIFI.getValue());
                }
                if (typeName.equalsIgnoreCase("MOBILE")) {
                    if (TextUtils.isEmpty(Proxy.getDefaultHost())) {
                        if (g(context)) {
                            wirelessNetworkType = WirelessNetworkType.MOBILE_3G;
                        } else {
                            wirelessNetworkType = WirelessNetworkType.MOBILE_2G;
                        }
                        value = wirelessNetworkType.getValue();
                    } else {
                        value = WirelessNetworkType.NETWORKTYPE_WAP.getValue();
                    }
                    return Integer.valueOf(value);
                }
                return valueOf;
            }
            return Integer.valueOf(WirelessNetworkType.UNKNOWN_NETWORK.getValue());
        }
        return (Integer) invokeL.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return ti.g();
        }
        return (String) invokeV.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return ti.k();
        }
        return (String) invokeV.objValue;
    }

    public static boolean g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 13:
                case 14:
                case 15:
                    return true;
                case 4:
                case 7:
                case 11:
                default:
                    return false;
            }
        }
        return invokeL.booleanValue;
    }
}
