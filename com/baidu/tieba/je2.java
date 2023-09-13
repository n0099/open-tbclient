package com.baidu.tieba;

import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class je2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947880338, "Lcom/baidu/tieba/je2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947880338, "Lcom/baidu/tieba/je2;");
                return;
            }
        }
        a = rr1.a;
    }

    public static void a(Message message) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, message) == null) && message != null) {
            Object obj = message.obj;
            if (obj instanceof Bundle) {
                Bundle bundle = (Bundle) obj;
                String string = bundle.getString("eventType");
                HashMap hashMap = new HashMap();
                hashMap.put("eventType", string);
                JSONObject jSONObject = new JSONObject();
                if (TextUtils.equals(string, "checkForUpdate")) {
                    try {
                        jSONObject.put("hasUpdate", bundle.getBoolean("hasUpdate"));
                    } catch (JSONException e) {
                        if (a) {
                            e.printStackTrace();
                        }
                    }
                }
                hashMap.put("data", jSONObject.toString());
                il2 il2Var = new il2("updateStatusChange", hashMap);
                SwanAppActivity activity = uw2.T().getActivity();
                if (activity != null && activity.R() == 1) {
                    pu2.i().v(string, bundle.getBoolean("hasUpdate"));
                } else {
                    uw2.T().u(il2Var);
                }
            }
        }
    }

    public static void b(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65538, null, str, z) == null) {
            h82.k("SwanAppPkgUpdateManager", "send checkForUpdate msg, hasUpdate=" + z);
            Bundle bundle = new Bundle();
            bundle.putBoolean("hasUpdate", z);
            d("checkForUpdate", str, bundle);
        }
    }

    public static void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            h82.k("SwanAppPkgUpdateManager", "send update failed msg");
            d("updateFailed", str, null);
        }
    }

    public static void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            if (a) {
                Log.d("SwanAppPkgUpdateManager", "send update ready msg");
            }
            d("updateReady", str, null);
        }
    }

    public static void d(String str, String str2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2, bundle) == null) {
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                bundle.putString("eventType", str);
                x73 e = x73.e();
                z73 z73Var = new z73(107, bundle);
                z73Var.c(str2);
                e.h(z73Var);
                return;
            }
            h82.k("SwanAppPkgUpdateManager", "appId is empty or eventType is empty");
        }
    }

    public static void f(String str, String str2, boolean z) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65542, null, str, str2, z) == null) {
            int hashCode = str.hashCode();
            if (hashCode != -1330233754) {
                if (hashCode != -1317168438) {
                    if (hashCode == -585906598 && str.equals("updateReady")) {
                        c = 0;
                    }
                    c = 65535;
                } else {
                    if (str.equals("checkForUpdate")) {
                        c = 2;
                    }
                    c = 65535;
                }
            } else {
                if (str.equals("updateFailed")) {
                    c = 1;
                }
                c = 65535;
            }
            if (c != 0) {
                if (c != 1) {
                    if (c == 2) {
                        b(str2, z);
                        return;
                    }
                    return;
                }
                c(str2);
                return;
            }
            e(str2);
        }
    }
}
