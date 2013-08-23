package com.baidu.tieba.recommend;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ad {
    private static final String d = String.valueOf(com.baidu.tieba.data.g.f1014a) + "c/f/forum/threadrecommend";

    /* renamed from: a  reason: collision with root package name */
    private int f1675a = -1;
    private com.baidu.tieba.util.v b = null;
    private boolean c;

    public ad(boolean z) {
        this.c = z;
    }

    public String a(String str) {
        this.b = new com.baidu.tieba.util.v();
        this.b.a(d);
        this.b.c(false);
        if (this.c) {
            this.b.a("type", "banner");
        }
        if (!TextUtils.isEmpty(str)) {
            this.b.a("date", str);
        }
        String j = this.b.j();
        if (j != null) {
            try {
                this.f1675a = new JSONObject(j).optInt("error_code");
            } catch (JSONException e) {
            }
        }
        return j;
    }

    public void a() {
        if (this.b != null) {
            this.b.h();
        }
    }

    public boolean b() {
        if (this.b != null) {
            return this.b.c();
        }
        return false;
    }

    public int c() {
        return this.f1675a;
    }
}
