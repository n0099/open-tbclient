package com.baidu.webkit.logsdk.b;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.tbadk.core.atomData.EditNickNameActivityConfig;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class b {
    public static String b = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDjTe6LTkPFvWowhciLFGS+nqhc\nhfaYCwBhVIkmZXNNiqdBMcNBUmqaAIKYB8lh1+UFf/KmuO14QbAKqzE/FjHWAV51\n68IJCk+DLxu885hYRiNH+kJDRuzDVMOv4NudroOwY1zB3c8VOjjLuz7xE7rRet7d\nAjH9k8YPZuedladalwIDAQAB";
    public static String c = "1_0";
    public String a;
    public HashMap<String, a> d = new HashMap<>();
    public HashMap<String, String> e = new HashMap<>();
    public HashMap<String, c> f = new HashMap<>();

    public b() {
        this.d.clear();
        this.e.clear();
    }

    public static SharedPreferences a() {
        return com.baidu.webkit.logsdk.a.b.d().getSharedPreferences("log_config_pref", 0);
    }

    public static a a(String str, int i, JSONObject jSONObject) {
        a aVar = new a(str);
        aVar.d = d();
        aVar.c = f();
        String str2 = "full";
        if (jSONObject != null && jSONObject.length() > 0) {
            i = jSONObject.optInt(CyberCfgManager.KEY_INT_LOG_LEVEL, i);
            str2 = jSONObject.optString(EditNickNameActivityConfig.PARAM_TYPE, "full");
        }
        aVar.b = i;
        aVar.e = str2;
        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "createConfig type = " + str + ", level = " + i + ", params = " + str2);
        if (i == 3) {
            com.baidu.webkit.logsdk.a.b.a().h().b().a(str, false);
        }
        return aVar;
    }

    public static void a(String str, long j) {
        SharedPreferences.Editor edit = a().edit();
        edit.putLong("upload_".concat(String.valueOf(str)), j);
        edit.apply();
    }

    public static int b() {
        return a().getInt(DpStatConstants.KEY_NET_LEVEL, 3);
    }

    public static long b(String str) {
        return a().getLong("upload_".concat(String.valueOf(str)), 0L);
    }

    public static long c() {
        return a().getLong("timeout", 604800000L);
    }

    public static String d() {
        return a().getString("publickey", b);
    }

    public static String e() {
        return a().getString("f1", "1_0");
    }

    public static String f() {
        return a().getString("f2", c);
    }

    public static String g() {
        return a().getString("f3", "");
    }

    public final a a(String str) {
        String str2 = "";
        if (this.d.containsKey(str)) {
            return this.d.get(str);
        }
        SharedPreferences a = a();
        int i = 1;
        if ("frame_pv".equals(str)) {
            i = 2;
        } else if ("frame_event".equals(str)) {
            i = 3;
        }
        try {
            str2 = a.getString(str, "");
            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "getConfig = ".concat(String.valueOf(str2)));
        } catch (ClassCastException unused) {
            i = a.getInt(str, i);
            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "getConfig level = ".concat(String.valueOf(str2)));
        }
        JSONObject jSONObject = null;
        try {
            jSONObject = new JSONObject(str2);
        } catch (JSONException e) {
            com.baidu.webkit.logsdk.d.c.a(e);
        }
        a a2 = a(str, i, jSONObject);
        this.d.put(str, a2);
        return a2;
    }

    public final void a(a aVar) {
        this.d.put(aVar.a, aVar);
    }

    public final void a(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.e.put(str, str2);
    }

    public final void a(JSONObject jSONObject, SharedPreferences.Editor editor) throws JSONException {
        JSONObject jSONObject2;
        Iterator<String> keys;
        if (!jSONObject.has("params") || (keys = (jSONObject2 = jSONObject.getJSONObject("params")).keys()) == null) {
            return;
        }
        while (keys.hasNext()) {
            String next = keys.next();
            JSONObject jSONObject3 = jSONObject2.getJSONObject(next);
            c cVar = new c(next);
            if (jSONObject3.has("body")) {
                JSONArray jSONArray = jSONObject3.getJSONArray("body");
                cVar.b(jSONArray);
                editor.putString(next + "@body", jSONArray.toString());
            }
            if (jSONObject3.has("url")) {
                JSONArray jSONArray2 = jSONObject3.getJSONArray("url");
                cVar.a(jSONArray2);
                editor.putString(next + "@url", jSONArray2.toString());
            }
            this.f.put(next, cVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(JSONObject jSONObject, boolean z, SharedPreferences.Editor editor) throws JSONException {
        int i;
        if (jSONObject.has("array")) {
            JSONArray jSONArray = jSONObject.getJSONArray("array");
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                if (jSONObject2.has("log_type")) {
                    String string = jSONObject2.getString("log_type");
                    if (!TextUtils.isEmpty(string)) {
                        int i3 = 1;
                        if (z && jSONObject2.has("master")) {
                            String string2 = jSONObject2.getString("master");
                            if (!TextUtils.isEmpty(string2)) {
                                i = !string2.equals("0");
                                JSONObject jSONObject3 = new JSONObject();
                                if (i > 0 || !jSONObject2.has(CyberCfgManager.KEY_INT_LOG_LEVEL) || ((i = jSONObject2.getInt(CyberCfgManager.KEY_INT_LOG_LEVEL)) >= 0 && i <= 3)) {
                                    i3 = i;
                                }
                                jSONObject3.put(CyberCfgManager.KEY_INT_LOG_LEVEL, i3);
                                if (jSONObject2.has(EditNickNameActivityConfig.PARAM_TYPE)) {
                                    String string3 = jSONObject2.getString(EditNickNameActivityConfig.PARAM_TYPE);
                                    if (TextUtils.isEmpty(string3)) {
                                        string3 = "full";
                                    }
                                    jSONObject3.put(EditNickNameActivityConfig.PARAM_TYPE, string3);
                                }
                                editor.putString(string, jSONObject3.toString());
                                com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "setConfig: " + string + " = " + i3 + ", extra = " + jSONObject3);
                                this.d.put(string, a(string, i3, jSONObject3));
                            }
                        }
                        i = z ? 1 : 0;
                        JSONObject jSONObject32 = new JSONObject();
                        if (i > 0) {
                        }
                        i3 = i;
                        jSONObject32.put(CyberCfgManager.KEY_INT_LOG_LEVEL, i3);
                        if (jSONObject2.has(EditNickNameActivityConfig.PARAM_TYPE)) {
                        }
                        editor.putString(string, jSONObject32.toString());
                        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "setConfig: " + string + " = " + i3 + ", extra = " + jSONObject32);
                        this.d.put(string, a(string, i3, jSONObject32));
                    }
                }
            }
        }
    }

    public final String c(String str) {
        return this.e.get(str);
    }

    public final c d(String str) {
        if (this.f.containsKey(str)) {
            return this.f.get(str);
        }
        SharedPreferences a = a();
        String string = a.getString(str + "@body", "");
        String string2 = a.getString(str + "@url", "");
        if (!TextUtils.isEmpty(string) || !TextUtils.isEmpty(string2)) {
            try {
                c cVar = new c(str);
                cVar.b(new JSONArray(string));
                cVar.a(new JSONArray(string2));
                this.f.put(str, cVar);
                return cVar;
            } catch (JSONException e) {
                com.baidu.webkit.logsdk.d.c.a(e);
            }
        }
        return new c("full");
    }
}
