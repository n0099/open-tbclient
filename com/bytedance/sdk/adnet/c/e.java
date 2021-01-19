package com.bytedance.sdk.adnet.c;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class e {
    private static final Object d = new Object();

    /* renamed from: a  reason: collision with root package name */
    private Context f6006a;
    private boolean c;
    private d pkA = new d();

    public e(Context context, boolean z) {
        this.c = true;
        this.f6006a = context;
        this.c = z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [95=4, 96=4, 98=4, 99=4, 100=4, 101=5] */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 3, expect 1 */
    public void a(JSONObject jSONObject) {
        JSONObject jSONObject2;
        if (!this.c) {
            com.bytedance.sdk.adnet.d.d.b("TNCConfigHandler", "handleConfigChanged: no mainProc");
            return;
        }
        f.eor().b();
        try {
            boolean z = jSONObject.optInt("ttnet_url_dispatcher_enabled", 0) > 0;
            JSONArray optJSONArray = jSONObject.optJSONArray("ttnet_dispatch_actions");
            JSONObject jSONObject3 = null;
            if (com.bytedance.sdk.adnet.a.b() && z && optJSONArray != null) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject4 = ((JSONObject) optJSONArray.get(i)).getJSONObject("param");
                    if (jSONObject4.optString("service_name", "").equals("idc_selection")) {
                        arrayList.add(jSONObject4.getJSONObject("strategy_info"));
                    }
                }
                if (!arrayList.isEmpty()) {
                    JSONObject jSONObject5 = new JSONObject();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        JSONObject jSONObject6 = (JSONObject) it.next();
                        Iterator<String> keys = jSONObject6.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            jSONObject5.put(next, jSONObject6.getString(next));
                        }
                    }
                    jSONObject3 = jSONObject5;
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("tnc_config");
            if (optJSONObject == null && jSONObject3 == null) {
                com.bytedance.sdk.adnet.d.d.a("TNCConfigHandler", " tnc host_replace_map config is null");
                jSONObject2 = optJSONObject;
            } else if (optJSONObject == null) {
                JSONObject jSONObject7 = new JSONObject();
                jSONObject7.put("host_replace_map", jSONObject3);
                jSONObject2 = jSONObject7;
            } else {
                if (jSONObject3 != null) {
                    optJSONObject.put("host_replace_map", jSONObject3);
                }
                jSONObject2 = optJSONObject;
            }
            d eR = eR(jSONObject2);
            com.bytedance.sdk.adnet.d.d.b("TNCConfigHandler", "handleConfigChanged, newConfig: " + (eR == null ? "null" : eR.toString()));
            if (eR == null) {
                synchronized (d) {
                    this.f6006a.getSharedPreferences("ttnet_tnc_config", 0).edit().putString("tnc_config_str", "").apply();
                    com.bytedance.sdk.adnet.d.e.a(this.f6006a, 1, "");
                }
                return;
            }
            this.pkA = eR;
            String jSONObject8 = jSONObject2.toString();
            synchronized (d) {
                this.f6006a.getSharedPreferences("ttnet_tnc_config", 0).edit().putString("tnc_config_str", jSONObject8).apply();
                com.bytedance.sdk.adnet.d.e.a(this.f6006a, 1, jSONObject8);
            }
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                this.pkA = new d();
                synchronized (d) {
                    this.f6006a.getSharedPreferences("ttnet_tnc_config", 0).edit().putString("tnc_config_str", "").apply();
                    com.bytedance.sdk.adnet.d.e.a(this.f6006a, 1, "");
                }
            } catch (Throwable th2) {
                synchronized (d) {
                    this.f6006a.getSharedPreferences("ttnet_tnc_config", 0).edit().putString("tnc_config_str", "").apply();
                    com.bytedance.sdk.adnet.d.e.a(this.f6006a, 1, "");
                    throw th2;
                }
            }
        }
    }

    public void a() {
        if (this.c) {
            String string = this.f6006a.getSharedPreferences("ttnet_tnc_config", 0).getString("tnc_config_str", null);
            if (TextUtils.isEmpty(string)) {
                com.bytedance.sdk.adnet.d.d.b("TNCConfigHandler", "loadLocalConfig: no existed");
                return;
            }
            try {
                d eR = eR(new JSONObject(string));
                if (eR != null) {
                    this.pkA = eR;
                }
                com.bytedance.sdk.adnet.d.d.b("TNCConfigHandler", "loadLocalConfig: " + (eR == null ? "null" : eR.toString()));
            } catch (Throwable th) {
                th.printStackTrace();
                com.bytedance.sdk.adnet.d.d.b("TNCConfigHandler", "loadLocalConfig: except: " + th.getMessage());
            }
        }
    }

    public void b() {
        try {
            String a2 = com.bytedance.sdk.adnet.d.e.a(this.f6006a, 1);
            if (TextUtils.isEmpty(a2)) {
                com.bytedance.sdk.adnet.d.d.b("TNCConfigHandler", "loadLocalConfigForOtherProcess, data empty");
                return;
            }
            d eR = eR(new JSONObject(a2));
            com.bytedance.sdk.adnet.d.d.b("TNCConfigHandler", "loadLocalConfigForOtherProcess, config: " + (eR == null ? "null" : eR.toString()));
            if (eR != null) {
                this.pkA = eR;
            }
        } catch (Throwable th) {
            com.bytedance.sdk.adnet.d.d.b("TNCConfigHandler", "loadLocalConfigForOtherProcess, except: " + th.getMessage());
        }
    }

    public d eoq() {
        return this.pkA;
    }

    private d eR(JSONObject jSONObject) {
        try {
            d dVar = new d();
            if (jSONObject.has("local_enable")) {
                dVar.f6004a = jSONObject.getInt("local_enable") != 0;
            }
            if (jSONObject.has("probe_enable")) {
                dVar.f6005b = jSONObject.getInt("probe_enable") != 0;
            }
            if (jSONObject.has("local_host_filter")) {
                JSONArray jSONArray = jSONObject.getJSONArray("local_host_filter");
                HashMap hashMap = new HashMap();
                if (jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        String string = jSONArray.getString(i);
                        if (!TextUtils.isEmpty(string)) {
                            hashMap.put(string, 0);
                        }
                    }
                }
                dVar.c = hashMap;
            } else {
                dVar.c = null;
            }
            if (jSONObject.has("host_replace_map")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("host_replace_map");
                HashMap hashMap2 = new HashMap();
                if (jSONObject2.length() > 0) {
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        String string2 = jSONObject2.getString(next);
                        if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(string2)) {
                            hashMap2.put(next, string2);
                        }
                    }
                }
                dVar.d = hashMap2;
            } else {
                dVar.d = null;
            }
            dVar.e = jSONObject.optInt("req_to_cnt", dVar.e);
            dVar.f = jSONObject.optInt("req_to_api_cnt", dVar.f);
            dVar.g = jSONObject.optInt("req_to_ip_cnt", dVar.g);
            dVar.h = jSONObject.optInt("req_err_cnt", dVar.h);
            dVar.i = jSONObject.optInt("req_err_api_cnt", dVar.i);
            dVar.j = jSONObject.optInt("req_err_ip_cnt", dVar.j);
            dVar.k = jSONObject.optInt("update_interval", dVar.k);
            dVar.l = jSONObject.optInt("update_random_range", dVar.l);
            dVar.m = jSONObject.optString("http_code_black", dVar.m);
            return dVar;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
