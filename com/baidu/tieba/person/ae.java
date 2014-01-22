package com.baidu.tieba.person;

import android.content.Context;
import com.baidu.tieba.data.PersonChangeData;
import com.baidu.tieba.data.UserData;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ae extends com.baidu.adp.a.d {
    private ag b;
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

    public ae(Context context) {
        this.f = new com.baidu.tieba.util.i(context);
        this.e = context;
    }

    public UserData a() {
        return this.a;
    }

    public void a(UserData userData) {
        this.a = userData;
    }

    public void a(String str) {
        this.c = str;
    }

    public String b() {
        return this.c;
    }

    public void b(String str) {
        this.d = str;
    }

    public long c() {
        return this.g;
    }

    public void a(long j) {
        this.g = j;
    }

    public long d() {
        return this.h;
    }

    public void b(long j) {
        this.h = j;
    }

    public void a(boolean z) {
        this.i = z;
    }

    public boolean e() {
        return this.i;
    }

    public void b(boolean z) {
        this.j = z;
    }

    public boolean f() {
        return this.j;
    }

    public void a(PersonChangeData personChangeData) {
        if (this.a != null) {
            this.a.setName(personChangeData.getName());
            this.a.setIntro(personChangeData.getIntro());
        }
    }

    public void a(boolean z, boolean z2) {
        if (this.b == null) {
            this.b = new ag(this);
            this.b.setPriority(3);
            this.b.execute(Boolean.valueOf(z), Boolean.valueOf(z2));
        }
    }

    public com.baidu.tieba.util.i g() {
        return this.f;
    }

    public void c(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            com.baidu.adp.lib.g.e.b(getClass().getName(), "parserJson", "error = " + e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a = new UserData();
                this.a.parserJson(jSONObject.optJSONObject("user"));
                this.k = true;
            } catch (Exception e) {
                com.baidu.adp.lib.g.e.b(getClass().getName(), "parserJson", "error = " + e.getMessage());
            }
        }
    }

    public boolean h() {
        return this.k;
    }

    @Override // com.baidu.adp.a.d
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        return false;
    }

    public void i() {
        if (this.b != null) {
            this.b.cancel();
        }
        if (this.f != null) {
            this.f.d();
        }
    }
}
