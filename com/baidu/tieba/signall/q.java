package com.baidu.tieba.signall;

import org.json.JSONObject;
/* loaded from: classes.dex */
public final class q {
    private int a;
    private String b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private com.baidu.tieba.home.q h = new com.baidu.tieba.home.q();

    public final int a() {
        return this.a;
    }

    public final int b() {
        return this.c;
    }

    public final int c() {
        return this.f;
    }

    public final int d() {
        return this.g;
    }

    public final com.baidu.tieba.home.q e() {
        return this.h;
    }

    public final void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.h.a(jSONObject.optJSONObject("error"));
                this.a = jSONObject.optInt("forum_id");
                this.b = jSONObject.optString("forum_name");
                this.c = jSONObject.optInt("signed");
                this.d = jSONObject.optInt("is_on");
                this.e = jSONObject.optInt("is_filter");
                this.f = jSONObject.optInt("sign_day_count");
                this.g = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(getClass().getName(), "parserJson", e.getMessage());
            }
        }
    }
}
