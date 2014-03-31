package com.baidu.tieba.model;

import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class ae {
    private int a;
    private int b;
    private int c;
    private int[] d;

    public final void a(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject != null) {
            this.a = jSONObject.optInt("conn_conf");
            this.b = jSONObject.optInt("continuous_fail_count");
            this.c = jSONObject.optInt("restart_time_interval");
            JSONArray optJSONArray = jSONObject.optJSONArray("conn_list");
            if (optJSONArray != null) {
                this.d = new int[optJSONArray.length()];
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.d[i] = optJSONArray.optInt(i);
                }
            }
        }
    }

    public final int a() {
        return this.a;
    }

    public final int b() {
        return this.b;
    }

    public final int c() {
        return this.c;
    }

    public final int[] d() {
        return this.d;
    }
}
