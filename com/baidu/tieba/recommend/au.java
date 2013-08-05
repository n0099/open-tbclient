package com.baidu.tieba.recommend;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class au {
    private static final String d = String.valueOf(com.baidu.tieba.data.g.f1013a) + "c/f/forum/threadrecommend";

    /* renamed from: a  reason: collision with root package name */
    private int f1649a = -1;
    private com.baidu.tieba.util.u b = null;
    private boolean c;

    public au(boolean z) {
        this.c = z;
    }

    public String a(String str) {
        this.b = new com.baidu.tieba.util.u();
        this.b.a(d);
        this.b.c(false);
        if (this.c) {
            this.b.a("type", "banner");
        }
        if (!TextUtils.isEmpty(str)) {
            this.b.a("date", str);
        }
        String k = this.b.k();
        if (k != null) {
            try {
                this.f1649a = new JSONObject(k).optInt("error_code");
            } catch (JSONException e) {
            }
        }
        return k;
    }

    public void a() {
        if (this.b != null) {
            this.b.i();
        }
    }

    public boolean b() {
        if (this.b != null) {
            return this.b.d();
        }
        return false;
    }

    public int c() {
        return this.f1649a;
    }
}
