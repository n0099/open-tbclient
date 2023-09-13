package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.launch.LaunchStatsUtils;
import com.baidu.searchbox.security.WarmTipsManager;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class p80 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static long b;
    public static long c;
    public static volatile String d;
    public static volatile long e;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948015777, "Lcom/baidu/tieba/p80;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948015777, "Lcom/baidu/tieba/p80;");
                return;
            }
        }
        a = AppConfig.isDebug();
        b = -1L;
        c = -1L;
        d = "";
        e = -1L;
    }

    public static long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return b;
        }
        return invokeV.longValue;
    }

    public static long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return c;
        }
        return invokeV.longValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return d;
        }
        return (String) invokeV.objValue;
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) && a() != -1 && !TextUtils.isEmpty(str)) {
            if (System.currentTimeMillis() - e < 10000) {
                if (a) {
                    Log.d(LaunchStatsUtils.TAG, "set source too often，ignore this set source " + str);
                }
            } else if (!TextUtils.equals("push", str) && !TextUtils.equals(PbModel.WISE, str) && !TextUtils.equals("scheme", str) && !TextUtils.equals(CommandUBCHelper.COMMAND_UBC_SHARE_TOKEN, str) && !TextUtils.equals(WarmTipsManager.WIDGET_SOURCE_VALUE, str)) {
                if (a) {
                    Log.d(LaunchStatsUtils.TAG, "cannot distinguish the source: " + str);
                }
            } else {
                e = System.currentTimeMillis();
                d = str;
                if (!TextUtils.equals(o80.e(), str)) {
                    o80.g(str);
                }
                if (a) {
                    Log.d(LaunchStatsUtils.TAG, "set external transfer source: " + str);
                }
            }
        }
    }
}
