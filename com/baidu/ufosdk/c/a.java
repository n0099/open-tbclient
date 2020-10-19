package com.baidu.ufosdk.c;

import android.annotation.SuppressLint;
import com.baidu.ufosdk.f.c;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes22.dex */
public final class a {
    @SuppressLint({"NewApi"})
    public static String a(Map map) {
        if (map == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        for (String str : map.keySet()) {
            try {
                Object obj = map.get(str);
                if (obj instanceof String) {
                    jSONObject.put(str, (String) obj);
                } else if (obj instanceof Integer) {
                    jSONObject.put(str, (Integer) obj);
                } else if (obj instanceof Long) {
                    jSONObject.put(str, (Long) obj);
                } else if (obj instanceof Float) {
                    jSONObject.put(str, (Float) obj);
                } else {
                    c.d("mapRecord2JSON: unexpected key[" + str + "]'s value " + obj);
                }
            } catch (JSONException e) {
                c.a("Could not create JSON object for key " + str, e);
            }
        }
        c.c("json is " + jSONObject.toString());
        return jSONObject.toString();
    }
}
