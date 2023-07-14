package com.baidu.tieba;

import android.content.Context;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiEnterpriseConfig;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.charset.StandardCharsets;
import java.util.List;
/* loaded from: classes8.dex */
public class wm3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static WifiConfiguration a(tm3 tm3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tm3Var)) == null) {
            int b = xm3.b(tm3Var);
            if (!f(tm3Var.a)) {
                return null;
            }
            WifiConfiguration wifiConfiguration = new WifiConfiguration();
            wifiConfiguration.SSID = "\"" + tm3Var.a + "\"";
            if (!TextUtils.isEmpty(tm3Var.b)) {
                wifiConfiguration.BSSID = tm3Var.b;
            }
            if (b != 0) {
                if (b != 1) {
                    if (b != 2) {
                        if (b == 3) {
                            xm3.d(wifiConfiguration, 3);
                            WifiEnterpriseConfig wifiEnterpriseConfig = new WifiEnterpriseConfig();
                            wifiEnterpriseConfig.setEapMethod(0);
                            wifiEnterpriseConfig.setIdentity(tm3Var.c);
                            wifiEnterpriseConfig.setPassword(tm3Var.d);
                            wifiConfiguration.enterpriseConfig = wifiEnterpriseConfig;
                        }
                    } else {
                        xm3.d(wifiConfiguration, 2);
                        wifiConfiguration.preSharedKey = "\"" + tm3Var.d + "\"";
                    }
                } else {
                    xm3.d(wifiConfiguration, 1);
                    String[] strArr = wifiConfiguration.wepKeys;
                    strArr[0] = "\"" + tm3Var.d + "\"";
                }
            } else {
                xm3.d(wifiConfiguration, 0);
            }
            return wifiConfiguration;
        }
        return (WifiConfiguration) invokeL.objValue;
    }

    public static WifiConfiguration b(Context context, WifiManager wifiManager, WifiInfo wifiInfo) {
        InterceptResult invokeLLL;
        List<WifiConfiguration> d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, context, wifiManager, wifiInfo)) == null) {
            if (wifiInfo != null && f(wifiInfo.getSSID()) && (d = d(context, wifiManager)) != null) {
                for (WifiConfiguration wifiConfiguration : d) {
                    if (TextUtils.equals(e(wifiConfiguration.SSID), e(wifiInfo.getSSID()))) {
                        return wifiConfiguration;
                    }
                }
            }
            return null;
        }
        return (WifiConfiguration) invokeLLL.objValue;
    }

    public static WifiConfiguration c(Context context, WifiManager wifiManager, tm3 tm3Var) {
        InterceptResult invokeLLL;
        List<WifiConfiguration> d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, context, wifiManager, tm3Var)) == null) {
            if (tm3Var != null && f(tm3Var.a) && (d = d(context, wifiManager)) != null) {
                for (WifiConfiguration wifiConfiguration : d) {
                    if (TextUtils.equals(e(wifiConfiguration.SSID), tm3Var.a)) {
                        return wifiConfiguration;
                    }
                }
            }
            return null;
        }
        return (WifiConfiguration) invokeLLL.objValue;
    }

    public static List<WifiConfiguration> d(Context context, WifiManager wifiManager) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, wifiManager)) == null) {
            if (wifiManager == null) {
                return null;
            }
            try {
                if (ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.h.g) != 0) {
                    return null;
                }
                return wifiManager.getConfiguredNetworks();
            } catch (Exception e) {
                v82.b("SwanWifiUtils", Log.getStackTraceString(e));
                return null;
            }
        }
        return (List) invokeLL.objValue;
    }

    public static String e(String str) {
        InterceptResult invokeL;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (!TextUtils.isEmpty(str) && (length = str.length()) > 1 && str.charAt(0) == '\"') {
                int i = length - 1;
                if (str.charAt(i) == '\"') {
                    return str.substring(1, i);
                }
                return str;
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (!TextUtils.isEmpty(str) && !str.equals("<unknown ssid>")) {
                return StandardCharsets.UTF_8.newEncoder().canEncode(str);
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
