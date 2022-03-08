package com.bytedance.sdk.openadsdk.api.b;

import android.text.TextUtils;
import java.security.SecureRandom;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b {
    public static String a(String str) {
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

    public static String b() {
        String a = a(8);
        if (a == null || a.length() != 16) {
            return null;
        }
        return a;
    }

    public static JSONObject a(JSONObject jSONObject) {
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
            }
        } catch (Throwable unused2) {
            jSONObject2.put("message", jSONObject.toString());
            jSONObject2.put("cypher", 0);
        }
        return jSONObject2;
    }

    public static String a() {
        String a = a(16);
        if (a == null || a.length() != 32) {
            return null;
        }
        return a;
    }

    public static String a(String str, int i2) {
        if (str == null || str.length() != i2) {
            return null;
        }
        int i3 = i2 / 2;
        return str.substring(i3, i2) + str.substring(0, i3);
    }

    public static String a(int i2) {
        try {
            byte[] bArr = new byte[i2];
            new SecureRandom().nextBytes(bArr);
            return c.a(bArr);
        } catch (Exception unused) {
            return null;
        }
    }
}
