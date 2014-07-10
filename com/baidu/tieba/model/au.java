package com.baidu.tieba.model;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.data.PersonChangeData;
import com.baidu.tieba.person.PersonPostListData;
import com.baidu.tieba.person.bx;
import com.baidu.tieba.person.dd;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class au extends com.baidu.adp.base.e {
    private long c;
    private long d;
    private long e;
    private long f;
    private long g;
    private String h;
    private String l;
    private PersonPostListData n;
    private bx o;
    private AntiData r;
    private com.baidu.tbadk.editortool.aa s;
    private com.baidu.tbadk.coreExtra.b.a u;
    private Context v;
    private dd w;
    private int m = -1;
    private int p = 1;
    private boolean q = false;
    private aw t = null;
    private final CustomMessageListener x = new av(this, 2001118);
    private boolean a = true;
    private String b = null;
    private UserData k = null;
    private boolean i = false;
    private boolean j = false;

    public bx a() {
        return this.o;
    }

    public void a(bx bxVar) {
        this.o = bxVar;
    }

    public PersonPostListData b() {
        return this.n;
    }

    public void a(PersonPostListData personPostListData) {
        this.n = personPostListData;
    }

    public int c() {
        return this.m;
    }

    public void a(int i) {
        this.m = i;
    }

    public boolean d() {
        return this.q;
    }

    public void a(boolean z) {
        this.q = z;
    }

    public boolean e() {
        List<PersonPostListData.PostList> list;
        return (this.n == null || (list = this.n.post_list) == null || list.size() <= 0) ? false : true;
    }

    private int r() {
        List<PersonPostListData.PostList> list;
        if (this.n != null && (list = this.n.post_list) != null) {
            if (list.size() % 20 > 0) {
                return (list.size() / 20) + 2;
            }
            return (list.size() / 20) + 1;
        }
        return 1;
    }

    public au(Context context) {
        this.v = null;
        this.v = context;
        a(0L);
        d(0L);
        e(0L);
        b(0L);
        c(0L);
        this.s = new com.baidu.tbadk.editortool.aa(context);
    }

    public void f() {
        registerListener(this.x);
    }

    public void a(dd ddVar) {
        this.w = ddVar;
    }

    public AntiData g() {
        return this.r;
    }

    public void a(AntiData antiData) {
        this.r = antiData;
    }

    public String h() {
        return this.b;
    }

    public void a(String str) {
        this.b = str;
    }

    public void b(boolean z) {
        this.a = z;
    }

    public boolean i() {
        return this.a;
    }

    public void a(UserData userData) {
        this.k = userData;
    }

    public UserData j() {
        return this.k;
    }

    public void a(PersonChangeData personChangeData) {
        j().setSex(personChangeData.getSex());
        j().setUserName(personChangeData.getName());
        j().setIntro(personChangeData.getIntro());
    }

    public void a(boolean z, boolean z2, int i) {
        if (this.t == null) {
            if (i == 1) {
                this.p = 1;
            } else {
                this.p = r();
            }
            this.t = new aw(this);
            this.t.setPriority(3);
            this.t.execute(Boolean.valueOf(z), Boolean.valueOf(z2));
        }
    }

    public void k() {
        if (j() != null && this.u != null) {
            this.u.a(j().getHave_attention() != 1, j().getPortrait(), j().getUserId());
        }
    }

    public void b(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.k = new UserData();
                this.k.parserJson(jSONObject.optJSONObject("user"));
                this.o = new bx();
                this.o.a(jSONObject.optJSONObject("tainfo"));
                this.r = new AntiData();
                this.r.parserJson(jSONObject.optJSONObject("anti_stat"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public com.baidu.tbadk.editortool.aa l() {
        return this.s;
    }

    public void c(String str) {
        this.h = str;
    }

    public String m() {
        return this.h;
    }

    public void a(long j) {
        this.c = j;
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

    public boolean n() {
        return this.i;
    }

    public void d(boolean z) {
        this.j = z;
    }

    public boolean o() {
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

    public void p() {
        MessageManager.getInstance().unRegisterListener(this.x);
        if (this.t != null) {
            this.t.cancel();
        }
        if (this.s != null) {
            this.s.d();
        }
    }

    public void d(String str) {
        this.l = str;
    }

    public String q() {
        return this.l;
    }
}
