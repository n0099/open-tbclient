package com.baidu.tieba.model;

import android.text.TextUtils;
import com.baidu.tieba.TiebaApplication;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class at {

    /* renamed from: a  reason: collision with root package name */
    private int f1371a;
    private String b;
    private String c;

    public void a(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject != null) {
            this.f1371a = jSONObject.optInt("offline");
            TiebaApplication.g().w(this.f1371a == 1);
            this.b = jSONObject.optString("title");
            TiebaApplication.g().t(this.b);
            this.c = jSONObject.optString("link");
            if (!TextUtils.isEmpty(this.c)) {
                this.c = this.c.replaceFirst("webview:", com.baidu.loginshare.e.f);
                TiebaApplication.g().u(this.c);
            }
        }
    }
}
