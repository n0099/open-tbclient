package com.baidu.webkit.logsdk.b;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.network.NetworkDef;
import com.baidu.searchbox.ng.ai.apps.system.bluetooth.utils.AiAppsBluetoothConstants;
import com.baidu.tbadk.core.atomData.EditNickNameActivityConfig;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class b {
    private static String d = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDjTe6LTkPFvWowhciLFGS+nqhc\nhfaYCwBhVIkmZXNNiqdBMcNBUmqaAIKYB8lh1+UFf/KmuO14QbAKqzE/FjHWAV51\n68IJCk+DLxu885hYRiNH+kJDRuzDVMOv4NudroOwY1zB3c8VOjjLuz7xE7rRet7d\nAjH9k8YPZuedladalwIDAQAB";
    private static String e = "1_0";
    public String a;
    public HashMap<String, a> b = new HashMap<>();
    public HashMap<String, String> c = new HashMap<>();
    private HashMap<String, d> f = new HashMap<>();

    public b() {
        this.b.clear();
        this.c.clear();
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(b bVar) {
        String g = g();
        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "parseFromLocal spReserve = " + g);
        if (TextUtils.isEmpty(g)) {
            String a = com.baidu.webkit.logsdk.d.c.a(com.baidu.webkit.logsdk.a.b.d(), "logsdk_config.dat");
            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "parseFromLocal cacheConfig = " + a);
            if (TextUtils.isEmpty(a)) {
                return;
            }
            bVar.a(a);
        }
    }

    public static void a(String str, long j) {
        SharedPreferences.Editor edit = a().edit();
        edit.putLong("upload_" + str, j);
        edit.apply();
    }

    private void a(JSONObject jSONObject, SharedPreferences.Editor editor) throws JSONException {
        JSONObject jSONObject2;
        Iterator<String> keys;
        if (!jSONObject.has("params") || (keys = (jSONObject2 = jSONObject.getJSONObject("params")).keys()) == null) {
            return;
        }
        while (keys.hasNext()) {
            String next = keys.next();
            JSONObject jSONObject3 = jSONObject2.getJSONObject(next);
            d dVar = new d(next);
            if (jSONObject3.has(NetworkDef.Http.BODY)) {
                JSONArray jSONArray = jSONObject3.getJSONArray(NetworkDef.Http.BODY);
                dVar.b(jSONArray);
                editor.putString(next + "@body", jSONArray.toString());
            }
            if (jSONObject3.has("url")) {
                JSONArray jSONArray2 = jSONObject3.getJSONArray("url");
                dVar.a(jSONArray2);
                editor.putString(next + "@url", jSONArray2.toString());
            }
            this.f.put(next, dVar);
        }
    }

    private void a(JSONObject jSONObject, boolean z, SharedPreferences.Editor editor) throws JSONException {
        if (jSONObject.has(com.baidu.fsg.base.statistics.b.j)) {
            JSONArray jSONArray = jSONObject.getJSONArray(com.baidu.fsg.base.statistics.b.j);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                if (jSONObject2.has("log_type")) {
                    String string = jSONObject2.getString("log_type");
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
                        this.b.put(string, a(string, i2, jSONObject3));
                    }
                }
            }
        }
    }

    public static int b() {
        return a().getInt("net_level", 3);
    }

    public static long c() {
        return a().getLong(AiAppsBluetoothConstants.KEY_TIME_OUT, 604800000L);
    }

    public static long c(String str) {
        return a().getLong("upload_" + str, 0L);
    }

    public static String d() {
        return a().getString("publickey", d);
    }

    public static String e() {
        return a().getString("f1", "1_0");
    }

    public static String f() {
        return a().getString("f2", e);
    }

    public static String g() {
        return a().getString("f3", "");
    }

    public final void a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            SharedPreferences.Editor edit = a().edit();
            if (jSONObject.has("master")) {
                String string = jSONObject.getString("master");
                if (!TextUtils.isEmpty(string)) {
                    r0 = string.equals("0") ? false : true;
                    edit.putBoolean("master", r0);
                }
            }
            boolean z = r0;
            if (jSONObject.has("net_level")) {
                String string2 = jSONObject.getString("net_level");
                if (!TextUtils.isEmpty(string2)) {
                    int parseInt = Integer.parseInt(string2);
                    if (parseInt < 0 || parseInt > 3) {
                        parseInt = 3;
                    }
                    edit.putInt("net_level", parseInt);
                }
            }
            if (jSONObject.has(AiAppsBluetoothConstants.KEY_TIME_OUT)) {
                String string3 = jSONObject.getString(AiAppsBluetoothConstants.KEY_TIME_OUT);
                if (!TextUtils.isEmpty(string3)) {
                    double parseDouble = Double.parseDouble(string3) * 8.64E7d;
                    edit.putLong(AiAppsBluetoothConstants.KEY_TIME_OUT, (long) ((parseDouble < 3.456E8d || parseDouble > 2.592E9d) ? 6.048E8d : 6.048E8d));
                }
            }
            if (jSONObject.has("filesize")) {
                String string4 = jSONObject.getString("filesize");
                if (!TextUtils.isEmpty(string4)) {
                    double parseDouble2 = Double.parseDouble(string4) * 1024.0d;
                    edit.putLong("filesize", (long) ((parseDouble2 < 1024.0d || parseDouble2 > 307200.0d) ? 10240.0d : 10240.0d));
                }
            }
            if (jSONObject.has("timeup")) {
                String string5 = jSONObject.getString("timeup");
                if (!TextUtils.isEmpty(string5)) {
                    double parseDouble3 = Double.parseDouble(string5) * 8.64E7d;
                    edit.putLong("timeup", (long) ((parseDouble3 < 8.64E7d || parseDouble3 > 3.456E8d) ? 1.728E8d : 1.728E8d));
                }
            }
            if (jSONObject.has("threshold")) {
                String string6 = jSONObject.getString("threshold");
                if (!TextUtils.isEmpty(string6)) {
                    int parseInt2 = Integer.parseInt(string6);
                    if (parseInt2 <= 0) {
                        parseInt2 = 10;
                    }
                    edit.putLong("threshold", parseInt2);
                }
            }
            if (jSONObject.has("publickey")) {
                String string7 = jSONObject.getString("publickey");
                if (!TextUtils.isEmpty(string7)) {
                    edit.putString("publickey", string7);
                    d = string7;
                }
            }
            if (jSONObject.has("f1")) {
                String string8 = jSONObject.getString("f1");
                if (!TextUtils.isEmpty(string8)) {
                    edit.putString("f1", string8);
                }
            }
            if (jSONObject.has("f2")) {
                String string9 = jSONObject.getString("f2");
                if (!TextUtils.isEmpty(string9)) {
                    edit.putString("f2", string9);
                    e = string9;
                }
            }
            if (jSONObject.has("f3")) {
                String string10 = jSONObject.getString("f3");
                if (!TextUtils.isEmpty(string10)) {
                    edit.putString("f3", string10);
                }
            }
            a(jSONObject, edit);
            a(jSONObject, z, edit);
            edit.apply();
        } catch (Exception e2) {
            com.baidu.webkit.logsdk.d.c.a(e2);
        }
    }

    public final a b(String str) {
        int i;
        String str2;
        JSONObject jSONObject;
        if (this.b.containsKey(str)) {
            return this.b.get(str);
        }
        SharedPreferences a = a();
        int i2 = 1;
        if ("frame_pv".equals(str)) {
            i2 = 2;
        } else if ("frame_event".equals(str)) {
            i2 = 3;
        }
        String str3 = "";
        try {
            str3 = a.getString(str, "");
            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "getConfig = " + str3);
            i = i2;
            str2 = str3;
        } catch (ClassCastException e2) {
            int i3 = a.getInt(str, i2);
            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "getConfig level = " + str3);
            String str4 = str3;
            i = i3;
            str2 = str4;
        }
        try {
            jSONObject = new JSONObject(str2);
        } catch (JSONException e3) {
            com.baidu.webkit.logsdk.d.c.a(e3);
            jSONObject = null;
        }
        a a2 = a(str, i, jSONObject);
        this.b.put(str, a2);
        return a2;
    }

    public final d d(String str) {
        if (this.f.containsKey(str)) {
            return this.f.get(str);
        }
        SharedPreferences a = a();
        String string = a.getString(str + "@body", "");
        String string2 = a.getString(str + "@url", "");
        if (!TextUtils.isEmpty(string) || !TextUtils.isEmpty(string2)) {
            try {
                d dVar = new d(str);
                dVar.b(new JSONArray(string));
                dVar.a(new JSONArray(string2));
                this.f.put(str, dVar);
                return dVar;
            } catch (JSONException e2) {
                com.baidu.webkit.logsdk.d.c.a(e2);
            }
        }
        return new d("full");
    }
}
