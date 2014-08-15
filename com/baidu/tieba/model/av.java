package com.baidu.tieba.model;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.data.PersonChangeData;
import com.baidu.tieba.person.PersonPostListData;
import com.baidu.tieba.person.bz;
import com.baidu.tieba.person.di;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class av extends com.baidu.adp.base.e {
    private long c;
    private long d;
    private long e;
    private long f;
    private long g;
    private String h;
    private String l;
    private String n;
    private PersonPostListData o;
    private bz p;
    private AntiData s;
    private com.baidu.tbadk.coreExtra.b.a u;
    private Context v;
    private di w;
    private int m = -1;
    private int q = 1;
    private boolean r = false;
    private ax t = null;
    private final CustomMessageListener x = new aw(this, 2001118);
    private boolean a = true;
    private String b = null;
    private UserData k = null;
    private boolean i = false;
    private boolean j = false;

    public bz a() {
        return this.p;
    }

    public void a(bz bzVar) {
        this.p = bzVar;
    }

    public PersonPostListData b() {
        return this.o;
    }

    public void a(PersonPostListData personPostListData) {
        this.o = personPostListData;
    }

    public int c() {
        return this.m;
    }

    public void a(int i) {
        this.m = i;
    }

    public String d() {
        return this.n;
    }

    public void a(String str) {
        this.n = str;
    }

    public boolean e() {
        return this.r;
    }

    public void a(boolean z) {
        this.r = z;
    }

    public boolean f() {
        List<PersonPostListData.PostList> list;
        return (this.o == null || (list = this.o.post_list) == null || list.size() <= 0) ? false : true;
    }

    private int s() {
        List<PersonPostListData.PostList> list;
        if (this.o != null && (list = this.o.post_list) != null) {
            if (list.size() % 20 > 0) {
                return (list.size() / 20) + 2;
            }
            return (list.size() / 20) + 1;
        }
        return 1;
    }

    public av(Context context) {
        this.v = null;
        this.v = context;
        a(0L);
        d(0L);
        e(0L);
        b(0L);
        c(0L);
    }

    public void g() {
        registerListener(this.x);
    }

    public void a(di diVar) {
        this.w = diVar;
    }

    public AntiData h() {
        return this.s;
    }

    public void a(AntiData antiData) {
        this.s = antiData;
    }

    public String i() {
        return this.b;
    }

    public void b(String str) {
        this.b = str;
    }

    public void b(boolean z) {
        this.a = z;
    }

    public boolean j() {
        return this.a;
    }

    public void a(UserData userData) {
        this.k = userData;
    }

    public UserData k() {
        return this.k;
    }

    public void a(PersonChangeData personChangeData) {
        k().setSex(personChangeData.getSex());
        k().setUserName(personChangeData.getName());
        k().setIntro(personChangeData.getIntro());
    }

    public void a(boolean z, boolean z2, int i) {
        if (this.t == null) {
            if (i == 1) {
                this.q = 1;
            } else {
                this.q = s();
            }
            this.t = new ax(this);
            this.t.setPriority(3);
            this.t.execute(Boolean.valueOf(z), Boolean.valueOf(z2));
        }
    }

    public void l() {
        if (k() != null && this.u != null) {
            this.u.a(k().getHave_attention() != 1, k().getPortrait(), k().getUserId());
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
                this.k = new UserData();
                this.k.parserJson(jSONObject.optJSONObject("user"));
                this.p = new bz();
                this.p.a(jSONObject.optJSONObject("tainfo"));
                this.s = new AntiData();
                this.s.parserJson(jSONObject.optJSONObject("anti_stat"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void d(String str) {
        this.h = str;
    }

    public String m() {
        return this.h;
    }

    public void a(long j) {
        this.c = j;
    }

    public long n() {
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

    public boolean o() {
        return this.i;
    }

    public void d(boolean z) {
        this.j = z;
    }

    public boolean p() {
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

    public void q() {
        MessageManager.getInstance().unRegisterListener(this.x);
        if (this.t != null) {
            this.t.cancel();
        }
    }

    public void e(String str) {
        this.l = str;
    }

    public String r() {
        return this.l;
    }
}
