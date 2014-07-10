package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class p {
    private int a;
    private String b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private com.baidu.tieba.home.r h = new com.baidu.tieba.home.r();

    public int a() {
        return this.a;
    }

    public int b() {
        return this.c;
    }

    public int c() {
        return this.f;
    }

    public int d() {
        return this.g;
    }

    public com.baidu.tieba.home.r e() {
        return this.h;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.h.a(jSONObject.optJSONObject("error"));
                this.a = jSONObject.optInt(com.baidu.tbadk.core.frameworkData.a.FORUM_ID);
                this.b = jSONObject.optString(com.baidu.tbadk.core.frameworkData.a.FORUM_NAME);
                this.c = jSONObject.optInt("signed");
                this.d = jSONObject.optInt("is_on");
                this.e = jSONObject.optInt("is_filter");
                this.f = jSONObject.optInt("sign_day_count");
                this.g = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
