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
public final class bp extends com.baidu.adp.a.d implements com.baidu.tieba.im.messageCenter.g {
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
    private long c = 0;
    private long d = 0;
    private long e = 0;
    private long f = 0;
    private long g = 0;

    public final PersonPostListData a() {
        return this.l;
    }

    public final boolean b() {
        return this.n;
    }

    public final void a(boolean z) {
        this.n = z;
    }

    public bp(Context context) {
        this.s = null;
        this.s = context;
        this.p = new com.baidu.tieba.util.i(context);
        com.baidu.tieba.im.messageCenter.d.a().a(-118, this);
    }

    public final void a(cx cxVar) {
        this.t = cxVar;
    }

    public final AntiData c() {
        return this.o;
    }

    public final void a(AntiData antiData) {
        this.o = antiData;
    }

    public final String d() {
        return this.b;
    }

    public final void a(String str) {
        this.b = str;
    }

    public final void b(boolean z) {
        this.a = z;
    }

    public final boolean e() {
        return this.a;
    }

    public final void a(UserData userData) {
        this.k = userData;
    }

    public final UserData f() {
        return this.k;
    }

    public final void a(PersonChangeData personChangeData) {
        this.k.setSex(personChangeData.getSex());
        this.k.setUserName(personChangeData.getName());
        this.k.setIntro(personChangeData.getIntro());
    }

    public final void a(boolean z, boolean z2, int i) {
        bp bpVar;
        List<PersonPostListData.PostList> list;
        int size;
        bp bpVar2;
        if (this.q == null) {
            if (i == 1) {
                bpVar = this;
            } else if (this.l != null && (list = this.l.post_list) != null) {
                if (list.size() % 20 > 0) {
                    size = (list.size() / 20) + 2;
                    bpVar2 = this;
                } else {
                    size = (list.size() / 20) + 1;
                    bpVar2 = this;
                }
                bpVar2.m = size;
                this.q = new bq(this, (byte) 0);
                this.q.setPriority(3);
                this.q.execute(Boolean.valueOf(z), true);
            } else {
                bpVar = this;
            }
            bpVar2 = bpVar;
            size = 1;
            bpVar2.m = size;
            this.q = new bq(this, (byte) 0);
            this.q.setPriority(3);
            this.q.execute(Boolean.valueOf(z), true);
        }
    }

    public final void g() {
        if (this.k != null && this.r != null) {
            this.r.a(this.k.getHave_attention() != 1, this.k.getPortrait(), this.k.getUserId());
        }
    }

    public final void b(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject != null) {
                try {
                    this.k = new UserData();
                    this.k.parserJson(jSONObject.optJSONObject("user"));
                    this.o = new AntiData();
                    this.o.parserJson(jSONObject.optJSONObject("anti_stat"));
                } catch (Exception e) {
                    com.baidu.adp.lib.util.e.b(getClass().getName(), "parserJson", "error = " + e.getMessage());
                }
            }
        } catch (Exception e2) {
            com.baidu.adp.lib.util.e.b(getClass().getName(), "parserJson", "error = " + e2.getMessage());
        }
    }

    public final com.baidu.tieba.util.i h() {
        return this.p;
    }

    public final void c(String str) {
        this.h = str;
    }

    public final String i() {
        return this.h;
    }

    public final void a(long j) {
        this.c = j;
    }

    public final long j() {
        return this.c;
    }

    public final void c(boolean z) {
        this.i = z;
    }

    public final boolean k() {
        return this.i;
    }

    public final void d(boolean z) {
        this.j = z;
    }

    public final boolean l() {
        return this.j;
    }

    @Override // com.baidu.adp.a.d
    protected final boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public final boolean cancelLoadData() {
        return false;
    }

    public final void m() {
        com.baidu.tieba.im.messageCenter.d.a().a(this);
        if (this.q != null) {
            this.q.cancel();
        }
        if (this.p != null) {
            this.p.c();
        }
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public final void a(com.baidu.tieba.im.message.s sVar) {
        if (sVar != null) {
            switch (sVar.w()) {
                case -118:
                    if ((sVar instanceof de) && this.k != null) {
                        de deVar = (de) sVar;
                        if (this.k.getUserId() != null && this.k.getUserId().equals(deVar.c())) {
                            this.k.setHave_attention(deVar.d() ? 0 : 1);
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
