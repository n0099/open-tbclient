package com.baidu.tieba.recommend;

import android.text.TextUtils;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.util.ag;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ad {
    private static final String d = com.baidu.tieba.data.h.f1165a + "c/f/forum/threadrecommend";

    /* renamed from: a  reason: collision with root package name */
    private int f2270a = -1;
    private ag b = null;
    private boolean c;

    public ad(boolean z) {
        this.c = z;
    }

    public String a(String str) {
        this.b = new ag();
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
                this.f2270a = new JSONObject(j).optInt(SocialConstants.PARAM_ERROR_CODE);
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
        return this.f2270a;
    }
}
