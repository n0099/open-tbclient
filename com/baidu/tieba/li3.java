package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.tieba.hi3;
import com.baidu.tieba.ww2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class li3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static final int b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947943795, "Lcom/baidu/tieba/li3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947943795, "Lcom/baidu/tieba/li3;");
                return;
            }
        }
        a = js1.a;
        b = gv2.g0().u() * 1024;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (b > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean a(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (TextUtils.isEmpty(str) || str.getBytes().length <= b) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean b(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (!c()) {
                return false;
            }
            boolean a2 = a(str);
            if (a2) {
                d(str);
            }
            return a2;
        }
        return invokeL.booleanValue;
    }

    public static void d(@NonNull String str) {
        zb3 b0;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) != null) || (b0 = zb3.b0()) == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            ww2.a W = b0.W();
            SwanCoreVersion coreVersion = mx2.T().getCoreVersion();
            int k = b0.k();
            jSONObject.putOpt("scheme", W.W());
            jSONObject.putOpt("swanjs", el3.i(coreVersion, k));
            if (str != null && str.length() > 1024) {
                jSONObject.putOpt("params", str.substring(0, 1024));
            }
            hi3.b bVar = new hi3.b(10020);
            bVar.j(tp3.n().e());
            bVar.i(jSONObject.toString());
            bVar.h(b0.getAppId());
            bVar.m();
            z82.k("SwanAppParamChecker", "10020, params: " + str);
        } catch (JSONException e) {
            if (a) {
                e.printStackTrace();
            }
        }
    }
}
