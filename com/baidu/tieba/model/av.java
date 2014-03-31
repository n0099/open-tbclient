package com.baidu.tieba.model;

import android.content.Context;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.data.PersonChangeData;
import com.baidu.tieba.person.PersonPostListData;
import com.baidu.tieba.person.bx;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class av extends com.baidu.adp.a.e {
    private String h;
    private PersonPostListData l;
    private AntiData o;
    private com.baidu.tbadk.editortool.aa p;
    private com.baidu.tbadk.coreExtra.b.a r;
    private Context s;
    private bx t;
    private int m = 1;
    private boolean n = false;
    private ax q = null;
    private final com.baidu.adp.framework.c.a u = new aw(this, 2001118);
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

    public av(Context context) {
        this.s = null;
        this.s = context;
        this.p = new com.baidu.tbadk.editortool.aa(context);
    }

    public final void c() {
        registerListener(this.u);
    }

    public final void a(bx bxVar) {
        this.t = bxVar;
    }

    public final AntiData d() {
        return this.o;
    }

    public final void a(AntiData antiData) {
        this.o = antiData;
    }

    public final String e() {
        return this.b;
    }

    public final void a(String str) {
        this.b = str;
    }

    public final void b(boolean z) {
        this.a = z;
    }

    public final boolean f() {
        return this.a;
    }

    public final void a(UserData userData) {
        this.k = userData;
    }

    public final UserData g() {
        return this.k;
    }

    public final void a(PersonChangeData personChangeData) {
        this.k.setSex(personChangeData.getSex());
        this.k.setUserName(personChangeData.getName());
        this.k.setIntro(personChangeData.getIntro());
    }

    public final void a(boolean z, boolean z2, int i) {
        av avVar;
        List<PersonPostListData.PostList> list;
        int size;
        av avVar2;
        if (this.q == null) {
            if (i == 1) {
                avVar = this;
            } else if (this.l != null && (list = this.l.post_list) != null) {
                if (list.size() % 20 > 0) {
                    size = (list.size() / 20) + 2;
                    avVar2 = this;
                } else {
                    size = (list.size() / 20) + 1;
                    avVar2 = this;
                }
                avVar2.m = size;
                this.q = new ax(this);
                this.q.setPriority(3);
                this.q.execute(Boolean.valueOf(z), true);
            } else {
                avVar = this;
            }
            avVar2 = avVar;
            size = 1;
            avVar2.m = size;
            this.q = new ax(this);
            this.q.setPriority(3);
            this.q.execute(Boolean.valueOf(z), true);
        }
    }

    public final void h() {
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
                    com.baidu.adp.lib.util.f.b(getClass().getName(), "parserJson", "error = " + e.getMessage());
                }
            }
        } catch (Exception e2) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "parserJson", "error = " + e2.getMessage());
        }
    }

    public final com.baidu.tbadk.editortool.aa i() {
        return this.p;
    }

    public final void c(String str) {
        this.h = str;
    }

    public final String j() {
        return this.h;
    }

    public final void a(long j) {
        this.c = j;
    }

    public final long k() {
        return this.c;
    }

    public final void c(boolean z) {
        this.i = z;
    }

    public final boolean l() {
        return this.i;
    }

    public final void d(boolean z) {
        this.j = z;
    }

    public final boolean m() {
        return this.j;
    }

    @Override // com.baidu.adp.a.e
    protected final boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.e
    public final boolean cancelLoadData() {
        return false;
    }

    public final void n() {
        com.baidu.adp.framework.c.a().b(this.u);
        if (this.q != null) {
            this.q.cancel();
        }
        if (this.p != null) {
            this.p.c();
        }
    }
}
