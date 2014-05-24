package com.baidu.tieba.person;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.data.PersonChangeData;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class t extends com.baidu.adp.base.b {
    private u b;
    private String c;
    private final Context e;
    private com.baidu.tbadk.editortool.ab f;
    private boolean i;
    private boolean j;
    private boolean k;
    private UserData a = null;
    private String d = null;
    private long g = 0;
    private long h = 0;

    public t(Context context) {
        this.f = new com.baidu.tbadk.editortool.ab(context);
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
            this.a.setUserName(personChangeData.getName());
            this.a.setIntro(personChangeData.getIntro());
        }
    }

    public void a(boolean z, boolean z2) {
        if (this.b == null) {
            this.b = new u(this, null);
            this.b.setPriority(3);
            this.b.execute(Boolean.valueOf(z), Boolean.valueOf(z2));
        }
    }

    public com.baidu.tbadk.editortool.ab g() {
        return this.f;
    }

    public void c(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(getClass().getName(), "parserJson", "error = " + e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a = new UserData();
                this.a.parserJson(jSONObject.optJSONObject("user"));
                this.k = true;
            } catch (Exception e) {
                BdLog.e(getClass().getName(), "parserJson", "error = " + e.getMessage());
            }
        }
    }

    public boolean h() {
        return this.k;
    }

    @Override // com.baidu.adp.base.b
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.b
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
