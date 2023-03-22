package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.ubc.UBCManager;
import java.util.AbstractMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class jl {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = "11446";
    public static String b = "type";
    public static String c = "value";
    public static String d = "ext";
    public static String e = "suc";
    public static String f = "fail";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1448308395, "Lcom/baidu/tieba/jl;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1448308395, "Lcom/baidu/tieba/jl;");
        }
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "-";
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static void b(String str, List<AbstractMap.SimpleEntry<String, String>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, str, list) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(b, f);
                jSONObject.put(c, str);
                JSONObject jSONObject2 = new JSONObject();
                if (list != null && !list.isEmpty()) {
                    for (int i = 0; i < list.size(); i++) {
                        AbstractMap.SimpleEntry<String, String> simpleEntry = list.get(i);
                        if (simpleEntry != null && !TextUtils.isEmpty(simpleEntry.getKey())) {
                            jSONObject2.put(simpleEntry.getKey(), a(simpleEntry.getValue()));
                        }
                    }
                }
                jSONObject.put(d, jSONObject2);
                d(a, jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void c(String str, List<AbstractMap.SimpleEntry<String, String>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, str, list) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(b, e);
                jSONObject.put(c, str);
                JSONObject jSONObject2 = new JSONObject();
                if (list != null && !list.isEmpty()) {
                    for (int i = 0; i < list.size(); i++) {
                        AbstractMap.SimpleEntry<String, String> simpleEntry = list.get(i);
                        if (simpleEntry != null && !TextUtils.isEmpty(simpleEntry.getKey())) {
                            jSONObject2.put(simpleEntry.getKey(), a(simpleEntry.getValue()));
                        }
                    }
                }
                jSONObject.put(d, jSONObject2);
                d(a, jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void d(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, jSONObject) == null) {
            ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent(str, jSONObject);
        }
    }
}
