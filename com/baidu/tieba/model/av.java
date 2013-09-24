package com.baidu.tieba.model;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class av {

    /* renamed from: a  reason: collision with root package name */
    private int f1408a;
    private String b;
    private String c;

    public void a(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject != null) {
            this.f1408a = jSONObject.optInt("offline");
            this.b = jSONObject.optString("title");
            this.c = jSONObject.optString("link");
            if (!TextUtils.isEmpty(this.c)) {
                this.c = this.c.replaceFirst("webview:", com.baidu.loginshare.e.f);
            }
        }
    }
}
