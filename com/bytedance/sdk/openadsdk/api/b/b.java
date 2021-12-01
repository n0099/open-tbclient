package com.bytedance.sdk.openadsdk.api.b;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.security.SecureRandom;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            String a = a();
            String a2 = a(a, 32);
            String b2 = b();
            String str2 = null;
            if (a2 != null && b2 != null) {
                str2 = a.a(str, b2, a2);
            }
            return 3 + a + b2 + str2;
        }
        return (String) invokeL.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            String a = a(8);
            if (a == null || a.length() != 16) {
                return null;
            }
            return a;
        }
        return (String) invokeV.objValue;
    }

    public static JSONObject a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject)) == null) {
            JSONObject jSONObject2 = new JSONObject();
            if (jSONObject == null) {
                return jSONObject2;
            }
            try {
                try {
                    String a = a(jSONObject.toString());
                    if (!TextUtils.isEmpty(a)) {
                        jSONObject2.put("message", a);
                        jSONObject2.put("cypher", 3);
                    } else {
                        jSONObject2.put("message", jSONObject.toString());
                        jSONObject2.put("cypher", 0);
                    }
                } catch (Throwable unused) {
                    jSONObject2.put("message", jSONObject.toString());
                    jSONObject2.put("cypher", 0);
                }
            } catch (Throwable unused2) {
            }
            return jSONObject2;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            String a = a(16);
            if (a == null || a.length() != 32) {
                return null;
            }
            return a;
        }
        return (String) invokeV.objValue;
    }

    public static String a(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, str, i2)) == null) {
            if (str == null || str.length() != i2) {
                return null;
            }
            int i3 = i2 / 2;
            return str.substring(i3, i2) + str.substring(0, i3);
        }
        return (String) invokeLI.objValue;
    }

    public static String a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) {
            try {
                byte[] bArr = new byte[i2];
                new SecureRandom().nextBytes(bArr);
                return c.a(bArr);
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeI.objValue;
    }
}
