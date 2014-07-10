package com.baidu.tieba.person;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.data.PersonChangeData;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class o extends com.baidu.adp.base.e {
    private p b;
    private String c;
    private final Context e;
    private com.baidu.tbadk.editortool.aa f;
    private boolean h;
    private boolean i;
    private boolean j;
    private UserData a = null;
    private String d = null;
    private long g = 0;

    public o(Context context) {
        this.f = new com.baidu.tbadk.editortool.aa(context);
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

    public void a(boolean z) {
        this.h = z;
    }

    public boolean d() {
        return this.h;
    }

    public void b(boolean z) {
        this.i = z;
    }

    public void a(PersonChangeData personChangeData) {
        if (this.a != null) {
            this.a.setUserName(personChangeData.getName());
            this.a.setIntro(personChangeData.getIntro());
        }
    }

    public void a(boolean z, boolean z2) {
        if (this.b == null) {
            this.b = new p(this, null);
            this.b.setPriority(3);
            this.b.execute(Boolean.valueOf(z), Boolean.valueOf(z2));
        }
    }

    public com.baidu.tbadk.editortool.aa e() {
        return this.f;
    }

    public void c(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a = new UserData();
                this.a.parserJson(jSONObject.optJSONObject("user"));
                this.j = true;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public boolean f() {
        return this.j;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void g() {
        if (this.b != null) {
            this.b.cancel();
        }
        if (this.f != null) {
            this.f.d();
        }
    }
}
