package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
/* loaded from: classes5.dex */
public class sg3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            l33 M = l33.M();
            return M != null ? String.format(str, M.O(), M.V()) : "";
        }
        return (String) invokeL.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            String a = a("https://smartapps.cn/%s/%s/page-frame.html");
            if (vj1.a) {
                Log.d("SwanAppRefererUtils", "getFixedReferer: " + a);
            }
            return a;
        }
        return (String) invokeV.objValue;
    }

    public static boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? !TextUtils.isEmpty(str) && str.startsWith("https://") : invokeL.booleanValue;
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            String b = b();
            if (TextUtils.isEmpty(b)) {
                return;
            }
            if (vj1.a) {
                Log.d("SwanAppRefererUtils", "call setRefererPattern for Slave Webview; referer is " + b);
            }
            WebSettingsGlobalBlink.setRefererPattern(b, hm2.i());
        }
    }
}
