package com.baidu.tieba.person;

import android.content.Context;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.data.PersonChangeData;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class t extends com.baidu.adp.a.e {
    private u b;
    private String c;
    private final Context e;
    private com.baidu.tbadk.editortool.aa f;
    private boolean i;
    private boolean j;
    private boolean k;
    private UserData a = null;
    private String d = null;
    private long g = 0;
    private long h = 0;

    public t(Context context) {
        this.f = new com.baidu.tbadk.editortool.aa(context);
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
        this.i = true;
    }

    public final boolean e() {
        return this.i;
    }

    public final void b(boolean z) {
        this.j = true;
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
            this.b = new u(this, (byte) 0);
            this.b.setPriority(3);
            this.b.execute(true, true);
        }
    }

    public final com.baidu.tbadk.editortool.aa g() {
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
                    com.baidu.adp.lib.util.f.b(getClass().getName(), "parserJson", "error = " + e.getMessage());
                }
            }
        } catch (Exception e2) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "parserJson", "error = " + e2.getMessage());
        }
    }

    public final boolean h() {
        return this.k;
    }

    @Override // com.baidu.adp.a.e
    protected final boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.e
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
