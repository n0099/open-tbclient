package com.baidu.webkit.logsdk.b;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.tbadk.core.atomData.EditNickNameActivityConfig;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class b {

    /* renamed from: b  reason: collision with root package name */
    public static String f27494b = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDjTe6LTkPFvWowhciLFGS+nqhc\nhfaYCwBhVIkmZXNNiqdBMcNBUmqaAIKYB8lh1+UFf/KmuO14QbAKqzE/FjHWAV51\n68IJCk+DLxu885hYRiNH+kJDRuzDVMOv4NudroOwY1zB3c8VOjjLuz7xE7rRet7d\nAjH9k8YPZuedladalwIDAQAB";

    /* renamed from: c  reason: collision with root package name */
    public static String f27495c = "1_0";

    /* renamed from: a  reason: collision with root package name */
    public String f27496a;

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, a> f27497d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public HashMap<String, String> f27498e = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, c> f27499f = new HashMap<>();

    public b() {
        this.f27497d.clear();
        this.f27498e.clear();
    }

    public static SharedPreferences a() {
        return com.baidu.webkit.logsdk.a.b.d().getSharedPreferences("log_config_pref", 0);
    }

    public static a a(String str, int i2, JSONObject jSONObject) {
        a aVar = new a(str);
        aVar.f27492d = d();
        aVar.f27491c = f();
        String str2 = "full";
        if (jSONObject != null && jSONObject.length() > 0) {
            i2 = jSONObject.optInt("log_level", i2);
            str2 = jSONObject.optString(EditNickNameActivityConfig.PARAM_TYPE, "full");
        }
        aVar.f27490b = i2;
        aVar.f27493e = str2;
        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "createConfig type = " + str + ", level = " + i2 + ", params = " + str2);
        if (i2 == 3) {
            com.baidu.webkit.logsdk.a.b.a().h().c().a(str, false);
        }
        return aVar;
    }

    public static void a(String str, long j) {
        SharedPreferences.Editor edit = a().edit();
        edit.putLong("upload_" + str, j);
        edit.apply();
    }

    public static int b() {
        return a().getInt(DpStatConstants.KEY_NET_LEVEL, 3);
    }

    public static long b(String str) {
        SharedPreferences a2 = a();
        return a2.getLong("upload_" + str, 0L);
    }

    public static long c() {
        return a().getLong("timeout", 604800000L);
    }

    public static String d() {
        return a().getString("publickey", f27494b);
    }

    public static String e() {
        return a().getString("f1", "1_0");
    }

    public static String f() {
        return a().getString("f2", f27495c);
    }

    public static String g() {
        return a().getString("f3", "");
    }

    public final a a(String str) {
        String str2 = "";
        if (this.f27497d.containsKey(str)) {
            return this.f27497d.get(str);
        }
        SharedPreferences a2 = a();
        int i2 = 1;
        if ("frame_pv".equals(str)) {
            i2 = 2;
        } else if ("frame_event".equals(str)) {
            i2 = 3;
        }
        try {
            str2 = a2.getString(str, "");
            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "getConfig = " + str2);
        } catch (ClassCastException unused) {
            i2 = a2.getInt(str, i2);
            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "getConfig level = " + str2);
        }
        JSONObject jSONObject = null;
        try {
            jSONObject = new JSONObject(str2);
        } catch (JSONException e2) {
            com.baidu.webkit.logsdk.d.c.a(e2);
        }
        a a3 = a(str, i2, jSONObject);
        this.f27497d.put(str, a3);
        return a3;
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
            this.f27499f.put(next, cVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(JSONObject jSONObject, boolean z, SharedPreferences.Editor editor) throws JSONException {
        int i2;
        if (jSONObject.has("array")) {
            JSONArray jSONArray = jSONObject.getJSONArray("array");
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                if (jSONObject2.has("log_type")) {
                    String string = jSONObject2.getString("log_type");
                    if (!TextUtils.isEmpty(string)) {
                        int i4 = 1;
                        if (z && jSONObject2.has("master")) {
                            String string2 = jSONObject2.getString("master");
                            if (!TextUtils.isEmpty(string2)) {
                                i2 = !string2.equals("0");
                                JSONObject jSONObject3 = new JSONObject();
                                if (i2 > 0 || !jSONObject2.has("log_level") || ((i2 = jSONObject2.getInt("log_level")) >= 0 && i2 <= 3)) {
                                    i4 = i2;
                                }
                                jSONObject3.put("log_level", i4);
                                if (jSONObject2.has(EditNickNameActivityConfig.PARAM_TYPE)) {
                                    String string3 = jSONObject2.getString(EditNickNameActivityConfig.PARAM_TYPE);
                                    if (TextUtils.isEmpty(string3)) {
                                        string3 = "full";
                                    }
                                    jSONObject3.put(EditNickNameActivityConfig.PARAM_TYPE, string3);
                                }
                                editor.putString(string, jSONObject3.toString());
                                com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "setConfig: " + string + " = " + i4 + ", extra = " + jSONObject3);
                                this.f27497d.put(string, a(string, i4, jSONObject3));
                            }
                        }
                        i2 = z ? 1 : 0;
                        JSONObject jSONObject32 = new JSONObject();
                        if (i2 > 0) {
                        }
                        i4 = i2;
                        jSONObject32.put("log_level", i4);
                        if (jSONObject2.has(EditNickNameActivityConfig.PARAM_TYPE)) {
                        }
                        editor.putString(string, jSONObject32.toString());
                        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "setConfig: " + string + " = " + i4 + ", extra = " + jSONObject32);
                        this.f27497d.put(string, a(string, i4, jSONObject32));
                    }
                }
            }
        }
    }

    public final c c(String str) {
        if (this.f27499f.containsKey(str)) {
            return this.f27499f.get(str);
        }
        SharedPreferences a2 = a();
        String string = a2.getString(str + "@body", "");
        String string2 = a2.getString(str + "@url", "");
        if (!TextUtils.isEmpty(string) || !TextUtils.isEmpty(string2)) {
            try {
                c cVar = new c(str);
                cVar.b(new JSONArray(string));
                cVar.a(new JSONArray(string2));
                this.f27499f.put(str, cVar);
                return cVar;
            } catch (JSONException e2) {
                com.baidu.webkit.logsdk.d.c.a(e2);
            }
        }
        return new c("full");
    }
}
