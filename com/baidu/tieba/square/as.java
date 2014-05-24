package com.baidu.tieba.square;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class as {
    public int a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;

    public void a(JSONObject jSONObject) {
        this.b = jSONObject.optString("title");
        this.c = jSONObject.optString("sub_title");
        this.d = jSONObject.optString("link");
        this.f = jSONObject.optString("is_all", "0");
        this.e = jSONObject.optString("pic_url", null);
        this.e = this.e != null ? String.valueOf(this.e) + "?v=2" : null;
    }
}
