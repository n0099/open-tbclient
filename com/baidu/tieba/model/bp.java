package com.baidu.tieba.model;

import android.content.Context;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.data.PersonChangeData;
import com.baidu.tieba.data.UserData;
import com.baidu.tieba.im.message.de;
import com.baidu.tieba.person.PersonPostListData;
import com.baidu.tieba.person.cx;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class bp extends com.baidu.adp.a.d implements com.baidu.tieba.im.messageCenter.g {
    private long c;
    private long d;
    private long e;
    private long f;
    private long g;
    private String h;
    private PersonPostListData l;
    private AntiData o;
    private com.baidu.tieba.util.i p;
    private d r;
    private Context s;
    private cx t;
    private int m = 1;
    private boolean n = false;
    private bq q = null;
    private boolean a = true;
    private String b = null;
    private UserData k = null;
    private boolean i = false;
    private boolean j = false;

    public PersonPostListData a() {
        return this.l;
    }

    public boolean b() {
        return this.n;
    }

    public void a(boolean z) {
        this.n = z;
    }

    private int n() {
        List<PersonPostListData.PostList> list;
        if (this.l != null && (list = this.l.post_list) != null) {
            if (list.size() % 20 > 0) {
                return (list.size() / 20) + 2;
            }
            return (list.size() / 20) + 1;
        }
        return 1;
    }

    public bp(Context context) {
        this.s = null;
        this.s = context;
        a(0L);
        d(0L);
        e(0L);
        b(0L);
        c(0L);
        this.p = new com.baidu.tieba.util.i(context);
        com.baidu.tieba.im.messageCenter.e.a().a(-118, this);
    }

    public void a(cx cxVar) {
        this.t = cxVar;
    }

    public AntiData c() {
        return this.o;
    }

    public void a(AntiData antiData) {
        this.o = antiData;
    }

    public String d() {
        return this.b;
    }

    public void a(String str) {
        this.b = str;
    }

    public void b(boolean z) {
        this.a = z;
    }

    public boolean e() {
        return this.a;
    }

    public void a(UserData userData) {
        this.k = userData;
    }

    public UserData f() {
        return this.k;
    }

    public void a(PersonChangeData personChangeData) {
        f().setSex(personChangeData.getSex());
        f().setUserName(personChangeData.getName());
        f().setIntro(personChangeData.getIntro());
    }

    public void a(boolean z, boolean z2, int i) {
        if (this.q == null) {
            if (i == 1) {
                this.m = 1;
            } else {
                this.m = n();
            }
            this.q = new bq(this, null);
            this.q.setPriority(3);
            this.q.execute(Boolean.valueOf(z), Boolean.valueOf(z2));
        }
    }

    public void g() {
        if (f() != null && this.r != null) {
            this.r.a(f().getHave_attention() != 1, f().getPortrait(), f().getUserId());
        }
    }

    public void b(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "parserJson", "error = " + e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.k = new UserData();
                this.k.parserJson(jSONObject.optJSONObject("user"));
                this.o = new AntiData();
                this.o.parserJson(jSONObject.optJSONObject("anti_stat"));
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(getClass().getName(), "parserJson", "error = " + e.getMessage());
            }
        }
    }

    public com.baidu.tieba.util.i h() {
        return this.p;
    }

    public void c(String str) {
        this.h = str;
    }

    public String i() {
        return this.h;
    }

    public void a(long j) {
        this.c = j;
    }

    public long j() {
        return this.c;
    }

    public void b(long j) {
        this.f = j;
    }

    public void c(long j) {
        this.g = j;
    }

    public void d(long j) {
        this.d = j;
    }

    public void e(long j) {
        this.e = j;
    }

    public void c(boolean z) {
        this.i = z;
    }

    public boolean k() {
        return this.i;
    }

    public void d(boolean z) {
        this.j = z;
    }

    public boolean l() {
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

    public void m() {
        com.baidu.tieba.im.messageCenter.e.a().a(this);
        if (this.q != null) {
            this.q.cancel();
        }
        if (this.p != null) {
            this.p.d();
        }
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(com.baidu.tieba.im.message.s sVar) {
        if (sVar != null) {
            switch (sVar.w()) {
                case -118:
                    if ((sVar instanceof de) && f() != null) {
                        de deVar = (de) sVar;
                        if (f().getUserId() != null && f().getUserId().equals(deVar.c())) {
                            f().setHave_attention(deVar.d() ? 1 : 0);
                            this.mLoadDataMode = 3;
                            setErrorString(deVar.b());
                            if (this.mLoadDataCallBack != null) {
                                this.mLoadDataCallBack.a(Boolean.valueOf(deVar.a()));
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
