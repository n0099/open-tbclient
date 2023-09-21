package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.security.SecureRandom;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class rnb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            String b = b(16);
            if (b == null || b.length() != 32) {
                return null;
            }
            return b;
        }
        return (String) invokeV.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            String b = b(8);
            if (b == null || b.length() != 16) {
                return null;
            }
            return b;
        }
        return (String) invokeV.objValue;
    }

    public static String b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
            try {
                byte[] bArr = new byte[i];
                new SecureRandom().nextBytes(bArr);
                return unb.a(bArr);
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeI.objValue;
    }

    public static String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            String a = a();
            String d = d(a, 32);
            String f = f();
            String str2 = null;
            if (d != null && f != null) {
                str2 = qnb.a(str, f, d);
            }
            return 3 + a + f + str2;
        }
        return (String) invokeL.objValue;
    }

    public static JSONObject e(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject)) == null) {
            JSONObject jSONObject2 = new JSONObject();
            if (jSONObject == null) {
                return jSONObject2;
            }
            try {
                try {
                    String c = c(jSONObject.toString());
                    if (!TextUtils.isEmpty(c)) {
                        jSONObject2.put("message", c);
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

    public static String d(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, str, i)) == null) {
            if (str != null && str.length() == i) {
                int i2 = i / 2;
                return str.substring(i2, i) + str.substring(0, i2);
            }
            return null;
        }
        return (String) invokeLI.objValue;
    }

    public static String g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            if (!TextUtils.isEmpty(str) && str.length() >= 49) {
                String d = d(str.substring(1, 33), 32);
                String substring = str.substring(33, 49);
                if (substring != null && d != null) {
                    return qnb.b(str.substring(49), substring, d);
                }
                return str;
            }
            return str;
        }
        return (String) invokeL.objValue;
    }
}
