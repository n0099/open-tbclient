package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class jo4 {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = -1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947890010, "Lcom/baidu/tieba/jo4;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947890010, "Lcom/baidu/tieba/jo4;");
        }
    }

    public static int a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            int i = 5;
            if (c() <= 0) {
                return 5;
            }
            String string = kj4.b().i().getString("expire_time", "");
            if (TextUtils.isEmpty(string)) {
                return 5;
            }
            try {
                JSONObject jSONObject = new JSONObject(string);
                i = jSONObject.optInt("time", 5);
                JSONObject optJSONObject = jSONObject.optJSONObject("appkeys");
                if (optJSONObject == null) {
                    return i;
                }
                int optInt = optJSONObject.optInt(str, -1);
                if (optInt >= 0) {
                    return optInt;
                }
                return i;
            } catch (JSONException unused) {
                return i;
            }
        }
        return invokeL.intValue;
    }

    public static void e(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65541, null, jSONObject) != null) || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("version");
        if (TextUtils.isEmpty(optString) || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
            return;
        }
        kj4.b().i().putString("expire_time_version", optString);
        kj4.b().i().putString("expire_time", optJSONObject.toString());
    }

    public static long b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return TimeUnit.HOURS.toMillis(a(str));
        }
        return invokeL.longValue;
    }

    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (a < 0) {
                kj4.b().F("swan_update_expired_time", 0);
                a = 0;
            }
            return a;
        }
        return invokeV.intValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return kj4.b().i().getString("expire_time_version", "0");
        }
        return (String) invokeV.objValue;
    }
}
