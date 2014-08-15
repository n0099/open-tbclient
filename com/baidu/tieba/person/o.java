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
    private boolean g;
    private boolean h;
    private boolean i;
    private UserData a = null;
    private String d = null;
    private long f = 0;

    public o(Context context) {
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
        return this.f;
    }

    public void a(long j) {
        this.f = j;
    }

    public void a(boolean z) {
        this.g = z;
    }

    public boolean d() {
        return this.g;
    }

    public void b(boolean z) {
        this.h = z;
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
                this.i = true;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public boolean e() {
        return this.i;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void f() {
        if (this.b != null) {
            this.b.cancel();
        }
    }
}
