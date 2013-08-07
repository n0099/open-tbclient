package com.baidu.tieba.model;

import android.text.TextUtils;
import com.baidu.tieba.TiebaApplication;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class au {

    /* renamed from: a  reason: collision with root package name */
    private int f1337a;
    private String b;
    private String c;

    public void a(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject != null) {
            this.f1337a = jSONObject.optInt("offline");
            TiebaApplication.f().x(this.f1337a == 1);
            this.b = jSONObject.optString("title");
            TiebaApplication.f().q(this.b);
            this.c = jSONObject.optString("link");
            if (!TextUtils.isEmpty(this.c)) {
                this.c = this.c.replaceFirst("webview:", com.baidu.loginshare.e.f);
                TiebaApplication.f().r(this.c);
            }
        }
    }
}
