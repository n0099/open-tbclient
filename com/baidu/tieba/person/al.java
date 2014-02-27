package com.baidu.tieba.person;

import android.content.Context;
import com.baidu.tieba.data.PersonChangeData;
import com.baidu.tieba.data.UserData;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class al extends com.baidu.adp.a.d {
    private am b;
    private String c;
    private Context e;
    private com.baidu.tieba.util.i f;
    private boolean i;
    private boolean j;
    private boolean k;
    private UserData a = null;
    private String d = null;
    private long g = 0;
    private long h = 0;

    public al(Context context) {
        this.f = new com.baidu.tieba.util.i(context);
        this.e = context;
    }

    public final UserData a() {
        return this.a;
    }

    public final void a(UserData userData) {
        this.a = userData;
    }

    public final void a(String str) {
        this.c = str;
    }

    public final String b() {
        return this.c;
    }

    public final void b(String str) {
        this.d = str;
    }

    public final long c() {
        return this.g;
    }

    public final void a(long j) {
        this.g = j;
    }

    public final long d() {
        return this.h;
    }

    public final void b(long j) {
        this.h = j;
    }

    public final void a(boolean z) {
        this.i = z;
    }

    public final boolean e() {
        return this.i;
    }

    public final void b(boolean z) {
        this.j = z;
    }

    public final boolean f() {
        return this.j;
    }

    public final void a(PersonChangeData personChangeData) {
        if (this.a != null) {
            this.a.setUserName(personChangeData.getName());
            this.a.setIntro(personChangeData.getIntro());
        }
    }

    public final void a(boolean z, boolean z2) {
        if (this.b == null) {
            this.b = new am(this, (byte) 0);
            this.b.setPriority(3);
            this.b.execute(true, true);
        }
    }

    public final com.baidu.tieba.util.i g() {
        return this.f;
    }

    public final void c(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject != null) {
                try {
                    this.a = new UserData();
                    this.a.parserJson(jSONObject.optJSONObject("user"));
                    this.k = true;
                } catch (Exception e) {
                    com.baidu.adp.lib.util.e.b(getClass().getName(), "parserJson", "error = " + e.getMessage());
                }
            }
        } catch (Exception e2) {
            com.baidu.adp.lib.util.e.b(getClass().getName(), "parserJson", "error = " + e2.getMessage());
        }
    }

    public final boolean h() {
        return this.k;
    }

    @Override // com.baidu.adp.a.d
    protected final boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public final boolean cancelLoadData() {
        return false;
    }

    public final void i() {
        if (this.b != null) {
            this.b.cancel();
        }
        if (this.f != null) {
            this.f.c();
        }
    }
}
