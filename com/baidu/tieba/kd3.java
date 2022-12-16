package com.baidu.tieba;

import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class kd3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static JSONObject b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947909199, "Lcom/baidu/tieba/kd3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947909199, "Lcom/baidu/tieba/kd3;");
                return;
            }
        }
        a = ok1.a;
    }

    public static JSONObject b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("abTestSwitch", a());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static synchronized void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            synchronized (kd3.class) {
                if (a) {
                    Log.d("SwanCoreConfigHelper", "release cache ab obj ");
                }
                b = null;
            }
        }
    }

    public static synchronized JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (kd3.class) {
                if (b != null) {
                    if (a) {
                        Log.d("SwanCoreConfigHelper", "return cache obj : " + b.toString());
                    }
                    return b;
                }
                JSONObject rawSwitch = ln2.g0().getRawSwitch();
                if (rawSwitch == null) {
                    b = new JSONObject();
                    if (a) {
                        Log.d("SwanCoreConfigHelper", "raw switch is null, return empty obj");
                    }
                    return b;
                }
                Iterator<String> keys = rawSwitch.keys();
                while (keys.hasNext()) {
                    if (!keys.next().startsWith("swanswitch")) {
                        keys.remove();
                    }
                }
                b = rawSwitch;
                if (a) {
                    Log.d("SwanCoreConfigHelper", "return new obj : " + b.toString());
                }
                return b;
            }
        }
        return (JSONObject) invokeV.objValue;
    }
}
