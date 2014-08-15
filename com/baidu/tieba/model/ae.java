package com.baidu.tieba.model;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ae {
    private int a;
    private int b;
    private int c;
    private int[] d;
    private int e;
    private int f;
    private int g;

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject != null) {
            this.a = jSONObject.optInt("conn_conf");
            this.b = jSONObject.optInt("continuous_fail_count");
            this.c = jSONObject.optInt("restart_time_interval");
            this.e = jSONObject.optInt("lcs_timeout_2G");
            this.f = jSONObject.optInt("lcs_timeout_3G");
            this.g = jSONObject.optInt("lcs_timeout_wifi");
            JSONArray optJSONArray = jSONObject.optJSONArray("android_conn_list");
            if (optJSONArray != null) {
                this.d = new int[optJSONArray.length()];
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.d[i] = optJSONArray.optInt(i);
                }
                return;
            }
            this.d = new int[0];
        }
    }

    public int a() {
        return this.a;
    }

    public int b() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    public int[] d() {
        return this.d;
    }

    public int e() {
        return this.e;
    }

    public int f() {
        return this.f;
    }

    public int g() {
        return this.g;
    }
}
