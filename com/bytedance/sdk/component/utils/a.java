package com.bytedance.sdk.component.utils;

import android.text.TextUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.security.SecureRandom;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static JSONObject a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, jSONObject)) == null) {
            JSONObject jSONObject2 = new JSONObject();
            if (jSONObject == null) {
                return jSONObject2;
            }
            try {
                try {
                    String a2 = a(jSONObject.toString());
                    if (!TextUtils.isEmpty(a2)) {
                        jSONObject2.put("message", a2);
                        jSONObject2.put("cypher", 3);
                    } else {
                        jSONObject2.put("message", jSONObject.toString());
                        jSONObject2.put("cypher", 0);
                    }
                } catch (Throwable unused) {
                    jSONObject2.put("message", jSONObject.toString());
                    jSONObject2.put("cypher", 0);
                }
            } catch (Throwable th) {
                j.a(th.getMessage());
            }
            return jSONObject2;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) {
            if (TextUtils.isEmpty(str) || str.length() < 49) {
                return str;
            }
            String a2 = a(str.substring(1, 33), 32);
            String substring = str.substring(33, 49);
            return (substring == null || a2 == null) ? str : com.bytedance.sdk.component.c.a.b(str.substring(49), substring, a2);
        }
        return (String) invokeL.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            String a2 = a(8);
            if (a2 == null || a2.length() != 16) {
                return null;
            }
            return a2;
        }
        return (String) invokeV.objValue;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            String a2 = a();
            String a3 = a(a2, 32);
            String b2 = b();
            String str2 = null;
            if (a3 != null && b2 != null) {
                str2 = com.bytedance.sdk.component.c.a.a(str, b2, a3);
            }
            return 3 + a2 + b2 + str2;
        }
        return (String) invokeL.objValue;
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            String a2 = a(16);
            if (a2 == null || a2.length() != 32) {
                return null;
            }
            return a2;
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
                return e.a(bArr);
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeI.objValue;
    }
}
