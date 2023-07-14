package com.baidu.tieba;

import android.net.wifi.WifiConfiguration;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class xm3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(WifiConfiguration wifiConfiguration) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, wifiConfiguration)) == null) {
            if (wifiConfiguration == null) {
                return -1;
            }
            if (wifiConfiguration.allowedKeyManagement.get(1)) {
                return 2;
            }
            if (wifiConfiguration.allowedKeyManagement.get(2) || wifiConfiguration.allowedKeyManagement.get(3)) {
                return 3;
            }
            if (wifiConfiguration.wepKeys[0] != null) {
                return 1;
            }
            if (!wifiConfiguration.allowedKeyManagement.get(0)) {
                return -1;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static int b(tm3 tm3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, tm3Var)) == null) {
            if (tm3Var == null) {
                return -1;
            }
            if (TextUtils.isEmpty(tm3Var.c) && TextUtils.isEmpty(tm3Var.d)) {
                return 0;
            }
            if (!TextUtils.isEmpty(tm3Var.c) && !TextUtils.isEmpty(tm3Var.d)) {
                return 3;
            }
            if (TextUtils.isEmpty(tm3Var.d)) {
                return -1;
            }
            return 2;
        }
        return invokeL.intValue;
    }

    public static int c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            if (str.contains("WEP")) {
                return 1;
            }
            if (str.contains("PSK")) {
                return 2;
            }
            if (str.contains("EAP")) {
                return 3;
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public static void d(WifiConfiguration wifiConfiguration, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(65539, null, wifiConfiguration, i) != null) || wifiConfiguration == null) {
            return;
        }
        wifiConfiguration.allowedKeyManagement.clear();
        wifiConfiguration.allowedProtocols.clear();
        wifiConfiguration.allowedAuthAlgorithms.clear();
        wifiConfiguration.allowedPairwiseCiphers.clear();
        wifiConfiguration.allowedGroupCiphers.clear();
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        wifiConfiguration.allowedKeyManagement.set(2);
                        wifiConfiguration.allowedKeyManagement.set(3);
                        return;
                    }
                    return;
                }
                wifiConfiguration.allowedKeyManagement.set(1);
                return;
            }
            wifiConfiguration.allowedKeyManagement.set(0);
            wifiConfiguration.allowedAuthAlgorithms.set(0);
            wifiConfiguration.allowedAuthAlgorithms.set(1);
            return;
        }
        wifiConfiguration.allowedKeyManagement.set(0);
    }
}
