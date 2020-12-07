package com.baidu.webkit.logsdk.b;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.tbadk.core.atomData.EditNickNameActivityConfig;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public final class b {
    public static String b = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDjTe6LTkPFvWowhciLFGS+nqhc\nhfaYCwBhVIkmZXNNiqdBMcNBUmqaAIKYB8lh1+UFf/KmuO14QbAKqzE/FjHWAV51\n68IJCk+DLxu885hYRiNH+kJDRuzDVMOv4NudroOwY1zB3c8VOjjLuz7xE7rRet7d\nAjH9k8YPZuedladalwIDAQAB";
    public static String c = "1_0";

    /* renamed from: a  reason: collision with root package name */
    public String f3959a;
    public HashMap<String, a> d = new HashMap<>();
    public HashMap<String, String> e = new HashMap<>();
    private HashMap<String, c> f = new HashMap<>();

    public b() {
        this.d.clear();
        this.e.clear();
    }

    public static SharedPreferences a() {
        return com.baidu.webkit.logsdk.a.b.d().getSharedPreferences("log_config_pref", 0);
    }

    private static a a(String str, int i, JSONObject jSONObject) {
        a aVar = new a(str);
        aVar.d = d();
        aVar.c = f();
        String str2 = "full";
        if (jSONObject != null && jSONObject.length() > 0) {
            i = jSONObject.optInt("log_level", i);
            str2 = jSONObject.optString(EditNickNameActivityConfig.PARAM_TYPE, "full");
        }
        aVar.b = i;
        aVar.e = str2;
        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "createConfig type = " + str + ", level = " + i + ", params = " + str2);
        if (i == 3) {
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
        return a().getLong("upload_" + str, 0L);
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
        int i;
        String str2;
        JSONObject jSONObject;
        if (this.d.containsKey(str)) {
            return this.d.get(str);
        }
        SharedPreferences a2 = a();
        int i2 = 1;
        if ("frame_pv".equals(str)) {
            i2 = 2;
        } else if ("frame_event".equals(str)) {
            i2 = 3;
        }
        String str3 = "";
        try {
            str3 = a2.getString(str, "");
            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "getConfig = " + str3);
            i = i2;
            str2 = str3;
        } catch (ClassCastException e) {
            int i3 = a2.getInt(str, i2);
            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "getConfig level = " + str3);
            String str4 = str3;
            i = i3;
            str2 = str4;
        }
        try {
            jSONObject = new JSONObject(str2);
        } catch (JSONException e2) {
            com.baidu.webkit.logsdk.d.c.a(e2);
            jSONObject = null;
        }
        a a3 = a(str, i, jSONObject);
        this.d.put(str, a3);
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
            this.f.put(next, cVar);
        }
    }

    public final void a(JSONObject jSONObject, boolean z, SharedPreferences.Editor editor) throws JSONException {
        if (jSONObject.has(com.baidu.fsg.base.statistics.b.j)) {
            JSONArray jSONArray = jSONObject.getJSONArray(com.baidu.fsg.base.statistics.b.j);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                if (jSONObject2.has(ExtraParamsManager.PARAM_LOG_TYPE)) {
                    String string = jSONObject2.getString(ExtraParamsManager.PARAM_LOG_TYPE);
                    int i2 = z ? 1 : 0;
                    if (!TextUtils.isEmpty(string)) {
                        if (z && jSONObject2.has("master")) {
                            String string2 = jSONObject2.getString("master");
                            if (!TextUtils.isEmpty(string2)) {
                                i2 = string2.equals("0") ? 0 : 1;
                            }
                        }
                        JSONObject jSONObject3 = new JSONObject();
                        if (i2 > 0 && jSONObject2.has("log_level") && ((i2 = jSONObject2.getInt("log_level")) < 0 || i2 > 3)) {
                            i2 = 1;
                        }
                        jSONObject3.put("log_level", i2);
                        if (jSONObject2.has(EditNickNameActivityConfig.PARAM_TYPE)) {
                            String string3 = jSONObject2.getString(EditNickNameActivityConfig.PARAM_TYPE);
                            if (TextUtils.isEmpty(string3)) {
                                string3 = "full";
                            }
                            jSONObject3.put(EditNickNameActivityConfig.PARAM_TYPE, string3);
                        }
                        editor.putString(string, jSONObject3.toString());
                        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "setConfig: " + string + " = " + i2 + ", extra = " + jSONObject3);
                        this.d.put(string, a(string, i2, jSONObject3));
                    }
                }
            }
        }
    }

    public final c c(String str) {
        if (this.f.containsKey(str)) {
            return this.f.get(str);
        }
        SharedPreferences a2 = a();
        String string = a2.getString(str + "@body", "");
        String string2 = a2.getString(str + "@url", "");
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
