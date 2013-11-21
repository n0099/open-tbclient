package com.baidu.tieba.square;

import com.baidu.cloudsdk.social.core.SocialConstants;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class as {

    /* renamed from: a  reason: collision with root package name */
    public int f2372a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;

    public void a(JSONObject jSONObject) {
        this.b = jSONObject.optString("title");
        this.c = jSONObject.optString("sub_title");
        this.d = jSONObject.optString("link");
        this.f = jSONObject.optString("is_all", SocialConstants.FALSE);
        this.e = jSONObject.optString("pic_url", null);
        this.e = this.e != null ? this.e + "?v=2" : null;
    }
}
