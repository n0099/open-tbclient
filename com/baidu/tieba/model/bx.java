package com.baidu.tieba.model;

import android.content.Context;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.data.PersonChangeData;
import com.baidu.tieba.data.UserData;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class bx extends com.baidu.adp.a.d implements com.baidu.tieba.im.messageCenter.g {
    private long c;
    private long d;
    private long e;
    private long f;
    private long g;
    private String h;
    private AntiData l;
    private com.baidu.tieba.util.i m;
    private e o;
    private Context p;
    private bz n = null;
    private boolean a = true;
    private String b = null;
    private UserData k = null;
    private boolean i = false;
    private boolean j = false;

    public bx(Context context) {
        this.p = null;
        this.p = context;
        a(0L);
        d(0L);
        e(0L);
        b(0L);
        c(0L);
        this.m = new com.baidu.tieba.util.i(context);
        com.baidu.tieba.im.messageCenter.e.a().a(-118, this);
    }

    public AntiData a() {
        return this.l;
    }

    public void a(AntiData antiData) {
        this.l = antiData;
    }

    public String b() {
        return this.b;
    }

    public void a(String str) {
        this.b = str;
    }

    public void a(boolean z) {
        this.a = z;
    }

    public boolean c() {
        return this.a;
    }

    public void a(UserData userData) {
        this.k = userData;
    }

    public UserData d() {
        return this.k;
    }

    public void a(PersonChangeData personChangeData) {
        d().setSex(personChangeData.getSex());
        d().setName(personChangeData.getName());
        d().setIntro(personChangeData.getIntro());
    }

    public void a(boolean z, boolean z2) {
        if (this.n == null) {
            this.n = new bz(this);
            this.n.setPriority(3);
            this.n.execute(Boolean.valueOf(z), Boolean.valueOf(z2));
        }
    }

    public void e() {
        if (d() != null && this.o != null) {
            this.o.a(d().getHave_attention() != 1, d().getPortrait(), d().getId());
        }
    }

    public void b(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            com.baidu.tieba.util.be.b(getClass().getName(), "parserJson", "error = " + e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.k = new UserData();
                this.k.parserJson(jSONObject.optJSONObject("user"));
                this.l = new AntiData();
                this.l.parserJson(jSONObject.optJSONObject("anti_stat"));
            } catch (Exception e) {
                com.baidu.tieba.util.be.b(getClass().getName(), "parserJson", "error = " + e.getMessage());
            }
        }
    }

    public com.baidu.tieba.util.i f() {
        return this.m;
    }

    public void c(String str) {
        this.h = str;
    }

    public String g() {
        return this.h;
    }

    public void a(long j) {
        this.c = j;
    }

    public long h() {
        return this.c;
    }

    public void b(long j) {
        this.f = j;
    }

    public void c(long j) {
        this.g = j;
    }

    public long i() {
        return this.g;
    }

    public void d(long j) {
        this.d = j;
    }

    public void e(long j) {
        this.e = j;
    }

    public void b(boolean z) {
        this.i = z;
    }

    public boolean j() {
        return this.i;
    }

    public void c(boolean z) {
        this.j = z;
    }

    public boolean k() {
        return this.j;
    }

    @Override // com.baidu.adp.a.d
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        return false;
    }

    public void l() {
        com.baidu.tieba.im.messageCenter.e.a().a(this);
        if (this.n != null) {
            this.n.cancel();
        }
        if (this.m != null) {
            this.m.b();
        }
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(com.baidu.tieba.im.message.n nVar) {
        if (nVar != null) {
            switch (nVar.t()) {
                case -118:
                    if ((nVar instanceof com.baidu.tieba.im.message.cc) && d() != null) {
                        com.baidu.tieba.im.message.cc ccVar = (com.baidu.tieba.im.message.cc) nVar;
                        if (d().getId() != null && d().getId().equals(ccVar.c())) {
                            d().setHave_attention(ccVar.d() ? 1 : 0);
                            this.mLoadDataMode = 3;
                            setErrorString(ccVar.b());
                            if (this.mLoadDataCallBack != null) {
                                this.mLoadDataCallBack.a(Boolean.valueOf(ccVar.a()));
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
